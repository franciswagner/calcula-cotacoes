package com.ricardococati.service.impl

import com.ricardococati.model.entities.Histograma
import com.ricardococati.model.entities.HistogramaDiario
import com.ricardococati.model.entities.MacdDiario
import com.ricardococati.model.entities.SinalMacdDiario
import com.ricardococati.repository.dao.HistogramaDiarioInserirDAO
import com.ricardococati.repository.dao.MacdDiarioBuscarDAO
import com.ricardococati.repository.dao.SinalMacdDiarioBuscarDAO
import com.ricardococati.service.HistogramaDiarioCalculaService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.ArrayList
import java.util.Objects
import java.util.function.Consumer

@Service
class HistogramaDiarioCalculaServiceImpl(val macdDAO: MacdDiarioBuscarDAO,
                                         val sinalMacdDAO: SinalMacdDiarioBuscarDAO,
                                         val histogramaDAO: HistogramaDiarioInserirDAO
) : HistogramaDiarioCalculaService {

    override fun executeByCodNeg(codneg: String): List<HistogramaDiario> {
        log.info("Código de negociação: $codneg")
        val macdList = macdDAO.listMacdByCodNeg(codneg)
        val sinalMacdList = sinalMacdDAO.listSinalMacdByCodNeg(codneg)
        val histogramaList = calculaHistograma(macdList, sinalMacdList)
        insereHistograma(histogramaList)
        return histogramaList
    }

    private fun insereHistograma(histogramaList: List<HistogramaDiario>) {
        histogramaList
                .parallelStream()
                .filter { obj: HistogramaDiario? -> Objects.nonNull(obj) }
                .filter { histogramaDiario: HistogramaDiario -> Objects.nonNull(histogramaDiario.dtpreg) }
                .filter { histogramaDiario: HistogramaDiario -> Objects.nonNull(histogramaDiario.histograma) }
                .filter { histogramaDiario: HistogramaDiario -> Objects.nonNull(histogramaDiario.histograma!!.codneg) }
                .forEach { histogramaDiario: HistogramaDiario? -> histogramaDAO.incluirHistograma(histogramaDiario) }
    }

    private fun calculaHistograma(
            macdList: List<MacdDiario>,
            sinalMacdList: List<SinalMacdDiario>
    ): List<HistogramaDiario> {
        val histogramaList: MutableList<HistogramaDiario> = ArrayList()
        if (Objects.nonNull(macdList) && Objects.nonNull(sinalMacdList)) {
            macdList.forEach(Consumer { macd: MacdDiario ->
                sinalMacdList
                        .stream()
                        .filter { sinal: SinalMacdDiario ->
                            (sinal.dtpreg!!.isEqual(macd.dtpreg)
                                    && sinal.sinalMacd!!.codneg == macd.macd!!.codneg)
                        }
                        .map { sinal: SinalMacdDiario -> buildHistograma(macd, sinal) }
                        .filter { hist: HistogramaDiario -> !histogramaList.contains(hist) }
                        .forEach { e: HistogramaDiario -> histogramaList.add(e) }
            })
        }
        return histogramaList
    }

    private fun buildHistograma(macd: MacdDiario, sinal: SinalMacdDiario): HistogramaDiario {
        return HistogramaDiario.builder()
                .dtpreg(macd.dtpreg)
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
        return ("HistogramaDiarioCalculaServiceImpl(macdDAO=" + macdDAO + ", sinalMacdDAO="
                + sinalMacdDAO + ", histogramaDAO=" + histogramaDAO + ")")
    }

    companion object {
        private val log = LoggerFactory
                .getLogger(HistogramaDiarioCalculaServiceImpl::class.java)
    }

}