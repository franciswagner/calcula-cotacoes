package com.ricardococati.service.impl

import com.ricardococati.model.entities.Histograma
import com.ricardococati.model.entities.HistogramaSemanal
import com.ricardococati.model.entities.MacdSemanal
import com.ricardococati.model.entities.SinalMacdSemanal
import com.ricardococati.repository.dao.HistogramaSemanalInserirDAO
import com.ricardococati.repository.dao.MacdSemanalBuscarDAO
import com.ricardococati.repository.dao.MediaMovelExponencialSemanalBuscarDAO
import com.ricardococati.repository.dao.SinalMacdSemanalBuscarDAO
import com.ricardococati.service.CalculaService
import com.ricardococati.service.HistogramaSemanalCalculaService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.ArrayList
import java.util.Objects
import java.util.function.Consumer

@Service
class HistogramaSemanalCalculaServiceImpl(val macdDAO: MacdSemanalBuscarDAO,
                                          val sinalMacdDAO: SinalMacdSemanalBuscarDAO,
                                          val histogramaDAO: HistogramaSemanalInserirDAO,
                                          val mediaMovelExponencialDAO: MediaMovelExponencialSemanalBuscarDAO,
                                          val calculaService: CalculaService
) : HistogramaSemanalCalculaService {

    override fun executeByCodNeg(codneg: String): List<HistogramaSemanal> {
        log.info("Código de negociação: $codneg")
        val macdList = macdDAO.listMacdByCodNeg(codneg)
        val sinalMacdList = sinalMacdDAO.listSinalMacdByCodNeg(codneg)
        val histogramaList = calculaHistograma(macdList, sinalMacdList)
        incluirHistograma(histogramaList)
        return histogramaList
    }

    private fun incluirHistograma(histogramaList: List<HistogramaSemanal>) {
        histogramaList
                .parallelStream()
                .filter { obj: HistogramaSemanal? -> Objects.nonNull(obj) }
                .filter { histogramaSemanal: HistogramaSemanal -> Objects.nonNull(histogramaSemanal.dtpregini) }
                .filter { histogramaSemanal: HistogramaSemanal -> Objects.nonNull(histogramaSemanal.dtpregfim) }
                .filter { histogramaSemanal: HistogramaSemanal -> Objects.nonNull(histogramaSemanal.histograma) }
                .filter { histogramaSemanal: HistogramaSemanal -> Objects.nonNull(histogramaSemanal.histograma!!.codneg) }
                .forEach { histogramaSemanal: HistogramaSemanal? -> histogramaDAO.incluirHistograma(histogramaSemanal) }
    }

    private fun calculaHistograma(
            macdList: List<MacdSemanal>,
            sinalMacdList: List<SinalMacdSemanal>
    ): List<HistogramaSemanal> {
        val histogramaList: MutableList<HistogramaSemanal> = ArrayList()
        if (Objects.nonNull(macdList) && Objects.nonNull(sinalMacdList)) {
            macdList.forEach(Consumer { macd: MacdSemanal ->
                sinalMacdList
                        .stream()
                        .filter { sinal: SinalMacdSemanal ->
                            (sinal.dtpregini!!.isEqual(macd.dtpregini)
                                    && sinal.dtpregfim!!.isEqual(macd.dtpregfim)
                                    && sinal.sinalMacd!!.codneg == macd.macd!!.codneg)
                        }
                        .map { sinal: SinalMacdSemanal -> buildHistograma(macd, sinal) }
                        .filter { hist: HistogramaSemanal -> !histogramaList.contains(hist) }
                        .forEach { e: HistogramaSemanal -> histogramaList.add(e) }
            })
        }
        return histogramaList
    }

    private fun buildHistograma(macd: MacdSemanal, sinal: SinalMacdSemanal): HistogramaSemanal {
        return HistogramaSemanal.builder()
                .dtpregini(macd.dtpregini)
                .dtpregfim(macd.dtpregfim)
                .histograma(
                        Histograma
                                .builder()
                                .codneg(macd.macd!!.codneg)
                                .prehist(macd.macd!!.premacd
                                        ?.subtract(sinal.sinalMacd!!.presinal))
                                .build())
                .build()
    }

    override fun toString(): String {
        return ("HistogramaSemanalCalculaServiceImpl(macdDAO=" + macdDAO + ", sinalMacdDAO="
                + sinalMacdDAO + ", histogramaDAO=" + histogramaDAO
                + ", mediaMovelExponencialDAO=" + mediaMovelExponencialDAO + ", calculaService="
                + calculaService + ")")
    }

    companion object {
        private val log = LoggerFactory
                .getLogger(HistogramaSemanalCalculaServiceImpl::class.java)
    }

}