package com.ricardococati.service.impl

import com.ricardococati.model.entities.Candlestick
import com.ricardococati.model.entities.CandlestickDiario
import com.ricardococati.model.entities.MediaMovelExponencial
import com.ricardococati.model.entities.MediaMovelExponencialDiario
import com.ricardococati.model.entities.MediaMovelSimplesDiario
import com.ricardococati.model.enums.QuantidadePeriodo.Companion.listQuantidadePeriodo
import com.ricardococati.repository.dao.MediaMovelExponencialDiarioInserirDAO
import com.ricardococati.repository.dao.MediaMovelSimplesDiarioBuscarDAO
import com.ricardococati.service.CandlestickDiarioBuscarService
import com.ricardococati.service.MediaMovelExponencialDiarioCalculaService
import com.ricardococati.service.converter.MediaMovelSimplesConverter
import com.ricardococati.service.util.BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas
import com.ricardococati.service.util.BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.time.LocalDate
import java.util.ArrayList
import java.util.Objects

@Service
class MediaMovelExponencialDiarioCalculaServiceImpl(
        val diarioService: CandlestickDiarioBuscarService,
        val converteMediaMovelSimples: MediaMovelSimplesConverter,
        val mediaMovelSimplesDAO: MediaMovelSimplesDiarioBuscarDAO,
        val mmeInserirDAO: MediaMovelExponencialDiarioInserirDAO
) : MediaMovelExponencialDiarioCalculaService {

    override fun executeByCodNeg(codneg: String): List<MediaMovelExponencialDiario> {
        log.info("Código de negociação: $codneg")
        val candlestickList = diarioService.buscaCandlestickDiarioPorCodNeg(
                buildCandlestickDiarioDTO(codneg))
        val listMME = calculaMediaMovelExponencialPorPeriodo(codneg, candlestickList)
        incluirMMEDiario(listMME)
        return listMME
    }

    private fun incluirMMEDiario(listMME: List<MediaMovelExponencialDiario>) {
        listMME
                .parallelStream()
                .filter { obj: MediaMovelExponencialDiario? -> Objects.nonNull(obj) }
                .filter { mmeDiario: MediaMovelExponencialDiario -> Objects.nonNull(mmeDiario.dtpreg) }
                .filter { mmeDiario: MediaMovelExponencialDiario -> Objects.nonNull(mmeDiario.mediaMovelExponencial) }
                .filter { mmeDiario: MediaMovelExponencialDiario -> Objects.nonNull(mmeDiario.mediaMovelExponencial!!.codneg) }
                .forEach { mmeDiario: MediaMovelExponencialDiario? -> mmeInserirDAO.incluirMediaMovelExponencial(mmeDiario) }
    }

    private fun calculaMediaMovelExponencialPorPeriodo(
            codneg: String,
            candlestickList: List<CandlestickDiario>): List<MediaMovelExponencialDiario> {
        val mediaMovelExponencialList: MutableList<MediaMovelExponencialDiario> = ArrayList()
        listQuantidadePeriodo
                .parallelStream()
                .filter { periodo: Int? -> Objects.nonNull(candlestickList) }
                .filter { obj: Int? -> Objects.nonNull(obj) }
                .forEach { periodo: Int ->
                    mediaMovelExponencialList.addAll(
                            calculaMediaMovelExponencial(periodo, candlestickList)
                    )
                }
        return mediaMovelExponencialList
    }

    fun calculaMediaMovelExponencial(
            periodo: Int, candlestickList: List<CandlestickDiario>): List<MediaMovelExponencialDiario> {
        val listReturn: MutableList<MediaMovelExponencialDiario> = ArrayList()
        val qtdPeriodos = candlestickList.size
        var posicao = 0
        for (indice in periodo - 1 until qtdPeriodos) {
            if (posicao == 0) {
                listReturn.add(
                        buildMediaMovelExponencialByMMS(getPrimeiraMedia(periodo, candlestickList, indice)))
                posicao++
                continue
            }
            listReturn.add(buildMediaMovelExponencial(
                    candlestickList[indice].candlestick!!.codneg,
                    candlestickList[indice].dtpreg,
                    periodo,
                    calculaMME(periodo, candlestickList[indice].candlestick!!.preult,
                            listReturn[posicao - 1].mediaMovelExponencial!!.premedult))
            )
            posicao++
        }
        return listReturn
    }

    private fun getPrimeiraMedia(
            periodo: Int,
            candlestickList: List<CandlestickDiario>,
            indice: Int): MediaMovelSimplesDiario? {
        var mediaMovelSimplesDiario: MediaMovelSimplesDiario? = null
        try {
            mediaMovelSimplesDiario = mediaMovelSimplesDAO
                    .buscaMediaSimplesPorCodNegPeriodoDtPreg(
                            candlestickList[indice].candlestick!!.codneg,
                            periodo,
                            candlestickList[indice].dtpreg)
        } catch (exc: Exception) {
            log.error("Erro ao buscar média móvel simples! {} ", exc.message)
        }
        return mediaMovelSimplesDiario
    }

    private fun calculaMME(
            periodo: Int,
            precoHoje: BigDecimal?,
            precoMMEOntem: BigDecimal?): BigDecimal {
        val coeficienteK = 2.0 / (periodo + 1)
        val menos1 = 1
        val precoHojeMultplFatorK: Double = precoHoje!!.toDouble() * coeficienteK
        val mmeOntemMultplFatorKMenos1: Double = precoMMEOntem!!.toDouble() * (menos1 - coeficienteK)
        return getDoubleValueBigDecimalHalfUpArredondado4Casas(
                precoHojeMultplFatorK + mmeOntemMultplFatorKMenos1
        )
    }

    private fun buildCandlestickDiarioDTO(codneg: String): CandlestickDiario {
        return CandlestickDiario.builder()
                .candlestick(Candlestick.builder().codneg(codneg).build())
                .build()
    }

    private fun buildMediaMovelExponencialByMMS(
            mmSimples: MediaMovelSimplesDiario?): MediaMovelExponencialDiario {
        return MediaMovelExponencialDiario.builder()
                .dtpreg(mmSimples!!.dtpreg)
                .mediaMovelExponencial(
                        MediaMovelExponencial
                                .builder()
                                .codneg(mmSimples.mediaMovelSimples!!.codneg)
                                .periodo(mmSimples.mediaMovelSimples!!.periodo)
                                .premedult(
                                        getValueBigDecimalHalfUpArredondado4Casas(
                                                mmSimples.mediaMovelSimples!!.premedult!!
                                        )
                                ).build())
                .build()
    }

    private fun buildMediaMovelExponencial(
            codneg: String?,
            dtpreg: LocalDate?,
            periodo: Int,
            premed: BigDecimal): MediaMovelExponencialDiario {
        return MediaMovelExponencialDiario.builder()
                .dtpreg(dtpreg)
                .mediaMovelExponencial(
                        MediaMovelExponencial
                                .builder()
                                .codneg(codneg)
                                .periodo(periodo)
                                .premedult(
                                        getValueBigDecimalHalfUpArredondado4Casas(premed)
                                ).build())
                .build()
    }

    override fun toString(): String {
        return ("MediaMovelExponencialDiarioCalculaServiceImpl(diarioService=" + diarioService
                + ", converteMediaMovelSimples=" + converteMediaMovelSimples
                + ", mediaMovelSimplesDAO=" + mediaMovelSimplesDAO + ", mmeInserirDAO=" + mmeInserirDAO + ")")
    }

    companion object {
        private const val PRIMEIRA_POSICAO = 0
        private const val MEDIA_MOVEL_SIMPLES_GERADA = true
        private const val MEDIA_EXPONENCIAL_NAO_GERADA = false
        private val log = LoggerFactory
                .getLogger(MediaMovelExponencialDiarioCalculaServiceImpl::class.java)
    }

}