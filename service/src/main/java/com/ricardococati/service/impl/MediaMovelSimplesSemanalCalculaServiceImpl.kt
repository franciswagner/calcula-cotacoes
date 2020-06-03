package com.ricardococati.service.impl

import com.ricardococati.model.entities.Candlestick
import com.ricardococati.model.entities.CandlestickSemanal
import com.ricardococati.model.entities.MediaMovelSimplesSemanal
import com.ricardococati.model.enums.QuantidadePeriodo.Companion.listQuantidadePeriodo
import com.ricardococati.repository.dao.MediaMovelSimplesSemanalInserirDAO
import com.ricardococati.service.CandlestickSemanalBuscarService
import com.ricardococati.service.MediaMovelSimplesSemanalCalculaService
import com.ricardococati.service.converter.MediaMovelSimplesConverter
import com.ricardococati.service.util.BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.ArrayList
import java.util.Objects
import java.util.function.Consumer
import java.util.stream.Collectors
import java.util.stream.IntStream

@Service
class MediaMovelSimplesSemanalCalculaServiceImpl(
        val semanalService: CandlestickSemanalBuscarService,
        val converteMediaMovelSimples: MediaMovelSimplesConverter,
        val mmsInserirDAO: MediaMovelSimplesSemanalInserirDAO
) : MediaMovelSimplesSemanalCalculaService {

    override fun executeByCodNeg(codigoNegocio: String): List<MediaMovelSimplesSemanal> {
        log.info("Código de negociação: $codigoNegocio")
        val candlestickList = semanalService.buscaCandlestickSemanalPorCodNeg(buildCandlestickSemanalDTO(codigoNegocio))
        val mediaMovelSimplesList = calculaMediaMovelSimplesPorPeriodo(candlestickList, codigoNegocio)
        inserirMMS(mediaMovelSimplesList)
        return mediaMovelSimplesList
    }

    private fun inserirMMS(mediaMovelSimplesList: List<MediaMovelSimplesSemanal>) {
        mediaMovelSimplesList
                .parallelStream()
                .filter { obj: MediaMovelSimplesSemanal? -> Objects.nonNull(obj) }
                .filter { mmsSemanal: MediaMovelSimplesSemanal -> Objects.nonNull(mmsSemanal.dtpregini) }
                .filter { mmsSemanal: MediaMovelSimplesSemanal -> Objects.nonNull(mmsSemanal.dtpregfim) }
                .filter { mmsSemanal: MediaMovelSimplesSemanal -> Objects.nonNull(mmsSemanal.mediaMovelSimples) }
                .filter { mmsSemanal: MediaMovelSimplesSemanal -> Objects.nonNull(mmsSemanal.mediaMovelSimples!!.codneg) }
                .forEach { mmsSemanal: MediaMovelSimplesSemanal? -> mmsInserirDAO.incluirMediaMovelSimples(mmsSemanal) }
    }

    private fun calculaMediaMovelSimplesPorPeriodo(
            candlestickSemanals: List<CandlestickSemanal>, codneg: String): List<MediaMovelSimplesSemanal> {
        val mediaMovelSimplesList: MutableList<MediaMovelSimplesSemanal> = ArrayList()
        listQuantidadePeriodo
                .parallelStream()
                .filter { periodo: Int? -> Objects.nonNull(candlestickSemanals) }
                .filter { periodo: Int -> candlestickSemanals.size >= periodo }
                .map { periodo: Int -> calculaMediaMovelSimples(periodo, candlestickSemanals, codneg) }
                .forEachOrdered(Consumer<List<MediaMovelSimplesSemanal>> { c: List<MediaMovelSimplesSemanal>? -> mediaMovelSimplesList.addAll(c!!) })
        return mediaMovelSimplesList
    }

    private fun calculaMediaMovelSimples(
            periodo: Int, candlestickSemanal: List<CandlestickSemanal>, codneg: String): List<MediaMovelSimplesSemanal?> {
        return IntStream.range(periodo - 1, candlestickSemanal.size)
                .mapToObj { indice: Int -> calcula(periodo, indice, candlestickSemanal, codneg) }
                .collect(Collectors.toList())
    }

    private fun calcula(
            periodo: Int, posicao: Int, candlestickSemanalList: List<CandlestickSemanal>, codneg: String): MediaMovelSimplesSemanal {
        var soma = 0.0
        val mediaMovelSimples = converteMediaMovelSimples
                .converterCandlestickSemanalToMediaMovelSimples(buildCandlestickSemanalDTO(codneg))
        mediaMovelSimples.mediaMovelSimples!!.periodo = periodo
        for (indice in posicao - (periodo - 1)..posicao) {
            val candlestickSemanal = candlestickSemanalList[indice]
            soma += candlestickSemanal.candlestick!!.preult!!.toDouble()
            if (indice == posicao) {
                mediaMovelSimples.dtpregini = candlestickSemanal.dtpregini
                mediaMovelSimples.dtpregfim = candlestickSemanal.dtpregfim
                mediaMovelSimples.mediaMovelSimples!!.premedult = getDoubleValueBigDecimalHalfUpArredondado4Casas(soma / periodo)
            }
        }
        return mediaMovelSimples
    }

    private fun buildCandlestickSemanalDTO(codneg: String): CandlestickSemanal {
        return CandlestickSemanal.builder()
                .candlestick(Candlestick.builder().codneg(codneg).build())
                .build()
    }

    override fun toString(): String {
        return ("MediaMovelSimplesSemanalCalculaServiceImpl(semanalService=" + semanalService
                + ", converteMediaMovelSimples=" + converteMediaMovelSimples + ", mmsInserirDAO="
                + mmsInserirDAO + ")")
    }

    companion object {
        private const val PRIMEIRA_POSICAO = 0
        private const val MEDIA_MOVEL_SIMPLES_NAO_GERADA = false
        private val log = LoggerFactory
                .getLogger(MediaMovelSimplesSemanalCalculaServiceImpl::class.java)
    }

}