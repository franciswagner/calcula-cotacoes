package com.ricardococati.service.impl

import com.ricardococati.model.entities.HistogramaDiario
import com.ricardococati.model.entities.MacdDiario
import com.ricardococati.model.entities.MediaMovelExponencialDiario
import com.ricardococati.model.entities.MediaMovelSimplesDiario
import com.ricardococati.model.entities.RecomendacaoDiario
import com.ricardococati.model.entities.SinalMacdDiario
import com.ricardococati.service.CalculaGeralDiarioService
import com.ricardococati.service.HistogramaDiarioCalculaService
import com.ricardococati.service.MACDDiarioCalculaService
import com.ricardococati.service.MediaMovelExponencialDiarioCalculaService
import com.ricardococati.service.MediaMovelSimplesDiarioCalculaService
import com.ricardococati.service.RecomendacaoDiarioCalculaService
import com.ricardococati.service.SinalMacdDiarioCalculaService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.ArrayList
import java.util.Objects

@Service
class CalculaGeralDiarioServiceImpl(val mmsService: MediaMovelSimplesDiarioCalculaService,
                                    val mmeService: MediaMovelExponencialDiarioCalculaService,
                                    val macdService: MACDDiarioCalculaService,
                                    val sinalMacdService: SinalMacdDiarioCalculaService,
                                    val histogramaService: HistogramaDiarioCalculaService,
                                    val recomendacaoService: RecomendacaoDiarioCalculaService
) : CalculaGeralDiarioService {

    @Throws(Exception::class)
    override fun executeByCodNeg(
            listCodneg: List<String>,
            dtLimitePregao: LocalDate
    ): List<RecomendacaoDiario> {
        var recomendacaoDiarioList: List<RecomendacaoDiario> = ArrayList()
        try {
            var controle = executeMediaSimplesDiario(listCodneg)
            controle = controle && executeMediaExponencialDiario(listCodneg)
            controle = controle && executeMacdDiario(listCodneg)
            controle = controle && executeSinalMacdDiario(listCodneg)
            controle = controle && executeHistogramaDiario(listCodneg)
            if (controle) {
                recomendacaoDiarioList = recomendacaoService.executeByCodNeg(listCodneg, dtLimitePregao)
            }
        } catch (ex: Exception) {
            log.error("Erro ao gerar recomendação: {} ", ex.message)
            throw ex
        }
        return recomendacaoDiarioList
    }

    @Throws(Exception::class)
    private fun executeMediaSimplesDiario(listCodneg: List<String>): Boolean {
        val lisMMS: MutableList<MediaMovelSimplesDiario> = ArrayList()
        listCodneg
                .parallelStream()
                .filter { obj: String? -> Objects.nonNull(obj) }
                .forEach { codneg: String? -> lisMMS.addAll(mmsService.executeByCodNeg(codneg)) }
        return !lisMMS.isEmpty()
    }

    @Throws(Exception::class)
    private fun executeMediaExponencialDiario(listCodneg: List<String>): Boolean {
        val lisMME: MutableList<MediaMovelExponencialDiario> = ArrayList()
        listCodneg
                .parallelStream()
                .filter { obj: String? -> Objects.nonNull(obj) }
                .forEach { codneg: String? -> lisMME.addAll(mmeService.executeByCodNeg(codneg)) }
        return !lisMME.isEmpty()
    }

    @Throws(Exception::class)
    private fun executeMacdDiario(listCodneg: List<String>): Boolean {
        val listMacd: MutableList<MacdDiario> = ArrayList()
        listCodneg
                .parallelStream()
                .filter { obj: String? -> Objects.nonNull(obj) }
                .forEach { codneg: String? -> listMacd.addAll(macdService.executeByCodNeg(codneg)) }
        return !listMacd.isEmpty()
    }

    @Throws(Exception::class)
    private fun executeSinalMacdDiario(listCodneg: List<String>): Boolean {
        val listSinal: MutableList<SinalMacdDiario> = ArrayList()
        listCodneg
                .parallelStream()
                .filter { obj: String? -> Objects.nonNull(obj) }
                .forEach { codneg: String? -> listSinal.addAll(sinalMacdService.executeByCodNeg(codneg)) }
        return !listSinal.isEmpty()
    }

    @Throws(Exception::class)
    private fun executeHistogramaDiario(listCodneg: List<String>): Boolean {
        val listHistograma: MutableList<HistogramaDiario> = ArrayList()
        listCodneg
                .parallelStream()
                .filter { obj: String? -> Objects.nonNull(obj) }
                .forEach { codneg: String? -> listHistograma.addAll(histogramaService.executeByCodNeg(codneg)) }
        return !listHistograma.isEmpty()
    }

    override fun toString(): String {
        return ("CalculaGeralDiarioServiceImpl(mmsService=" + mmsService + ", mmeService="
                + mmeService + ", macdService=" + macdService + ", sinalMacdService="
                + sinalMacdService + ", histogramaService=" + histogramaService
                + ", recomendacaoService=" + recomendacaoService + ")")
    }

    companion object {
        private val log = LoggerFactory
                .getLogger(CalculaGeralDiarioServiceImpl::class.java)
    }

}