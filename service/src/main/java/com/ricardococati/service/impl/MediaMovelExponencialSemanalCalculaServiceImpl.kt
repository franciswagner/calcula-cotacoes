package com.ricardococati.service.impl

import com.ricardococati.model.entities.Candlestick
import com.ricardococati.model.entities.CandlestickSemanal
import com.ricardococati.model.entities.MediaMovelExponencial
import com.ricardococati.model.entities.MediaMovelExponencialSemanal
import com.ricardococati.model.entities.MediaMovelSimplesSemanal
import com.ricardococati.model.enums.QuantidadePeriodo.Companion.listQuantidadePeriodo
import com.ricardococati.repository.dao.MediaMovelExponencialSemanalInserirDAO
import com.ricardococati.repository.dao.MediaMovelSimplesSemanalBuscarDAO
import com.ricardococati.service.CalculaService
import com.ricardococati.service.CandlestickSemanalBuscarService
import com.ricardococati.service.MediaMovelExponencialSemanalCalculaService
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
class MediaMovelExponencialSemanalCalculaServiceImpl(
        val calculaCandlestickService: CandlestickSemanalBuscarService,
        val converteMediaMovelSimples: MediaMovelSimplesConverter,
        val mediaMovelSimplesDAO: MediaMovelSimplesSemanalBuscarDAO,
        val inserirMMEDAO: MediaMovelExponencialSemanalInserirDAO,
        val calculaService: CalculaService
) : MediaMovelExponencialSemanalCalculaService {

    override fun executeByCodNeg(codneg: String): List<MediaMovelExponencialSemanal> {
        log.info("Código de negociação: $codneg")
        val candlestickList = calculaCandlestickService.buscaCandlestickSemanalPorCodNeg(
                buildCandlestickSemanalDTO(codneg))
        val listMME = calculaMediaMovelExponencialPorPeriodo(candlestickList)
        inserirMMESemanal(listMME)
        return listMME
    }

    private fun inserirMMESemanal(listMME: List<MediaMovelExponencialSemanal>) {
        listMME
                .parallelStream()
                .filter { obj: MediaMovelExponencialSemanal? -> Objects.nonNull(obj) }
                .filter { mmeSemanal: MediaMovelExponencialSemanal -> Objects.nonNull(mmeSemanal.dtpregini) }
                .filter { mmeSemanal: MediaMovelExponencialSemanal -> Objects.nonNull(mmeSemanal.dtpregfim) }
                .filter { mmeSemanal: MediaMovelExponencialSemanal -> Objects.nonNull(mmeSemanal.mediaMovelExponencial) }
                .filter { mmeSemanal: MediaMovelExponencialSemanal -> Objects.nonNull(mmeSemanal.mediaMovelExponencial!!.codneg) }
                .forEach { mmeSemanal: MediaMovelExponencialSemanal? -> inserirMMEDAO.incluirMediaMovelExponencial(mmeSemanal) }
    }

    private fun calculaMediaMovelExponencialPorPeriodo(
            candlestickList: List<CandlestickSemanal>): List<MediaMovelExponencialSemanal> {
        val mediaMovelExponencialList: MutableList<MediaMovelExponencialSemanal> = ArrayList()
        try {
            listQuantidadePeriodo
                    .stream()
                    .filter { periodo: Int? -> Objects.nonNull(candlestickList) }
                    .filter { obj: Int? -> Objects.nonNull(obj) }
                    .forEach { periodo: Int ->
                        mediaMovelExponencialList
                                .addAll(calculaMediaMovelExponencial(periodo, candlestickList))
                    }
        } catch (ex: Exception) {
            log.error("Erro no cálculo de média exponencial: {} ", ex.message)
            throw ex
        }
        return mediaMovelExponencialList
    }

    fun calculaMediaMovelExponencial(
            periodo: Int, candlestickList: List<CandlestickSemanal>): List<MediaMovelExponencialSemanal> {
        val listReturn: MutableList<MediaMovelExponencialSemanal> = ArrayList()
        val qtdPeriodos = candlestickList.size
        var posicao = 0
        for (indice in periodo - 1 until qtdPeriodos) {
            if (posicao == 0) {
                val primeiraMedia = getPrimeiraMedia(
                        periodo,
                        candlestickList,
                        indice)
                if (Objects.isNull(primeiraMedia)) {
                    return listReturn
                }
                listReturn.add(buildMediaMovelExponencialByMMS(primeiraMedia))
                posicao++
                continue
            }
            listReturn.add(buildMediaMovelExponencial(
                    candlestickList[indice].candlestick!!.codneg,
                    candlestickList[indice].dtpregini,
                    candlestickList[indice].dtpregfim,
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
            candlestickList: List<CandlestickSemanal>,
            indice: Int): MediaMovelSimplesSemanal? {
        return try {
            mediaMovelSimplesDAO
                    .buscaMediaSimplesPorCodNegPeriodoDtPreg(
                            candlestickList[indice].candlestick!!.codneg,
                            periodo,
                            candlestickList[indice].dtpregini,
                            candlestickList[indice].dtpregfim)
        } catch (e: Exception) {
            log.error("Erro ao buscar média móvel simples! {}", e.message)
            null
        }
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

    private fun buildCandlestickSemanalDTO(codneg: String): CandlestickSemanal {
        return CandlestickSemanal
                .builder()
                .candlestick(
                        Candlestick
                                .builder()
                                .codneg(codneg)
                                .build())
                .build()
    }

    private fun buildMediaMovelExponencialByMMS(
            mmSimples: MediaMovelSimplesSemanal?): MediaMovelExponencialSemanal {
        return MediaMovelExponencialSemanal.builder()
                .dtpregini(mmSimples!!.dtpregini)
                .dtpregfim(mmSimples.dtpregfim)
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
            dtpregini: LocalDate?,
            dtpregfim: LocalDate?,
            periodo: Int,
            premed: BigDecimal): MediaMovelExponencialSemanal {
        return MediaMovelExponencialSemanal.builder()
                .dtpregini(dtpregini)
                .dtpregfim(dtpregfim)
                .mediaMovelExponencial(
                        MediaMovelExponencial
                                .builder()
                                .codneg(codneg)
                                .periodo(periodo)
                                .premedult(getValueBigDecimalHalfUpArredondado4Casas(premed))
                                .build())
                .build()
    }

    override fun toString(): String {
        return ("MediaMovelExponencialSemanalCalculaServiceImpl(calculaCandlestickService=" + calculaCandlestickService + ", converteMediaMovelSimples=" + converteMediaMovelSimples + ", mediaMovelSimplesDAO=" + mediaMovelSimplesDAO
                + ", inserirMMEDAO=" + inserirMMEDAO + ", calculaService=" + calculaService + ")")
    }

    companion object {
        private const val PRIMEIRA_POSICAO = 0
        private const val MEDIA_MOVEL_SIMPLES_GERADA = true
        private const val MEDIA_EXPONENCIAL_NAO_GERADA = false
        private val log = LoggerFactory
                .getLogger(MediaMovelExponencialSemanalCalculaServiceImpl::class.java)
    }

}