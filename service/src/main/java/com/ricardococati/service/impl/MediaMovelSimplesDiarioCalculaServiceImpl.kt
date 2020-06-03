package com.ricardococati.service.impl

import com.ricardococati.model.entities.Candlestick
import com.ricardococati.model.entities.CandlestickDiario
import com.ricardococati.model.entities.MediaMovelSimplesDiario
import com.ricardococati.model.enums.QuantidadePeriodo.Companion.listQuantidadePeriodo
import com.ricardococati.repository.dao.MediaMovelSimplesDiarioInserirDAO
import com.ricardococati.service.CandlestickDiarioBuscarService
import com.ricardococati.service.MediaMovelSimplesDiarioCalculaService
import com.ricardococati.service.converter.MediaMovelSimplesConverter
import com.ricardococati.service.util.BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.ArrayList
import java.util.Objects
import java.util.Objects.nonNull
import java.util.stream.Collectors
import java.util.stream.IntStream


@Service
class MediaMovelSimplesDiarioCalculaServiceImpl(
        val diarioService: CandlestickDiarioBuscarService,
        val converteMediaMovelSimples: MediaMovelSimplesConverter,
        val mmsDAO: MediaMovelSimplesDiarioInserirDAO
) : MediaMovelSimplesDiarioCalculaService {

    override fun executeByCodNeg(codigoNegocio: String): List<MediaMovelSimplesDiario> {
        log.info("Código de negociação: $codigoNegocio")
        val candlestickList = diarioService.buscaCandlestickDiarioPorCodNeg(buildCandlestickDiarioDTO(codigoNegocio))
        val mediaMovelSimplesList = calculaMediaMovelSimplesPorPeriodo(candlestickList, codigoNegocio)
        inserirMMSDiario(mediaMovelSimplesList)
        return mediaMovelSimplesList
    }

    private fun inserirMMSDiario(
            mediaMovelSimplesList: List<MediaMovelSimplesDiario>
    ) {
        mediaMovelSimplesList
                .parallelStream()
                .filter { obj: MediaMovelSimplesDiario? -> Objects.nonNull(obj) }
                .filter { mmsDiario: MediaMovelSimplesDiario -> Objects.nonNull(mmsDiario.dtpreg) }
                .filter { mmsDiario: MediaMovelSimplesDiario -> Objects.nonNull(mmsDiario.mediaMovelSimples) }
                .filter { mmsDiario: MediaMovelSimplesDiario -> Objects.nonNull(mmsDiario.mediaMovelSimples!!.codneg) }
                .forEach { mmsDiario: MediaMovelSimplesDiario? -> mmsDAO.incluirMediaMovelSimples(mmsDiario) }
    }

    private fun calculaMediaMovelSimplesPorPeriodo(
            candlestickDiarios: List<CandlestickDiario>, codneg: String): List<MediaMovelSimplesDiario>? {
        val mediaMovelSimplesList: List<MediaMovelSimplesDiario> = ArrayList()
        listQuantidadePeriodo
                .parallelStream()
                .filter { periodo: Int? -> nonNull(candlestickDiarios) }
                .filter { obj: Int? -> nonNull(obj) }
                .filter { periodo: Int -> candlestickDiarios.size >= periodo }
                .map<Any> { periodo: Int? -> calculaMediaMovelSimples(periodo!!, candlestickDiarios, codneg) }
                .forEachOrdered(mediaMovelSimplesList::addAll)
        return mediaMovelSimplesList
    }

    private fun calculaMediaMovelSimples(
            periodo: Int, candlestickDiario: List<CandlestickDiario>, codneg: String): List<MediaMovelSimplesDiario?> {
        return IntStream.range(periodo - 1, candlestickDiario.size)
                .mapToObj { indice: Int -> calcula(periodo, indice, candlestickDiario, codneg) }
                .collect(Collectors.toList())
    }

    private fun calcula(
            periodo: Int, posicao: Int, candlestickDiarioList: List<CandlestickDiario>, codneg: String): MediaMovelSimplesDiario {
        var soma = 0.0
        val mediaMovelSimples = converteMediaMovelSimples
                .converterCandlestickDiarioToMediaMovelSimples(buildCandlestickDiarioDTO(codneg))
        mediaMovelSimples.mediaMovelSimples!!.periodo = periodo
        for (indice in posicao - (periodo - 1)..posicao) {
            val candlestickDiario = candlestickDiarioList[indice]
            soma += candlestickDiario.candlestick!!.preult!!.toDouble()
            if (indice == posicao) {
                mediaMovelSimples.dtpreg = candlestickDiario.dtpreg
                mediaMovelSimples.mediaMovelSimples!!.premedult =
                        getDoubleValueBigDecimalHalfUpArredondado4Casas(soma / periodo)
            }
        }
        return mediaMovelSimples
    }

    private fun buildCandlestickDiarioDTO(codneg: String): CandlestickDiario {
        return CandlestickDiario.builder()
                .candlestick(Candlestick.builder().codneg(codneg).build())
                .build()
    }

    override fun toString(): String {
        return ("MediaMovelSimplesDiarioCalculaServiceImpl(diarioService=" + diarioService
                + ", converteMediaMovelSimples=" + converteMediaMovelSimples + ", mmsDAO=" + mmsDAO + ")")
    }

    companion object {
        private val log = LoggerFactory
                .getLogger(MediaMovelSimplesDiarioCalculaServiceImpl::class.java)
    }

}