package com.ricardococati.service.impl

import com.ricardococati.model.entities.HistogramaSemanal
import com.ricardococati.model.entities.MacdSemanal
import com.ricardococati.model.entities.MediaMovelExponencialSemanal
import com.ricardococati.model.entities.MediaMovelSimplesSemanal
import com.ricardococati.model.entities.RecomendacaoSemanal
import com.ricardococati.model.entities.SinalMacdSemanal
import com.ricardococati.service.CalculaGeralSemanalService
import com.ricardococati.service.HistogramaSemanalCalculaService
import com.ricardococati.service.MACDSemanalCalculaService
import com.ricardococati.service.MediaMovelExponencialSemanalCalculaService
import com.ricardococati.service.MediaMovelSimplesSemanalCalculaService
import com.ricardococati.service.RecomendacaoSemanalCalculaService
import com.ricardococati.service.SinalMacdSemanalCalculaService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.ArrayList
import java.util.Objects

@Service
class CalculaGeralSemanalServiceImpl(val mmsService: MediaMovelSimplesSemanalCalculaService,
                                     val mmeService: MediaMovelExponencialSemanalCalculaService, val macdService: MACDSemanalCalculaService,
                                     val sinalMacdService: SinalMacdSemanalCalculaService,
                                     val histogramaService: HistogramaSemanalCalculaService,
                                     val recomendacaoService: RecomendacaoSemanalCalculaService) : CalculaGeralSemanalService {

    @Throws(Exception::class)
    override fun executeByCodNeg(
            listCodneg: List<String>,
            dtLimitePregao: LocalDate
    ): List<RecomendacaoSemanal> {
        val recomendacaoSemanalList: MutableList<RecomendacaoSemanal> = ArrayList()
        try {
            var controle = executeMediaSimplesSemanal(listCodneg)
            controle = controle && executeMediaExponencialSemanal(listCodneg)
            controle = controle && executeMacdSemanal(listCodneg)
            controle = controle && executeSinalMacdSemanal(listCodneg)
            controle = controle && executeHistogramaSemanal(listCodneg)
            if (controle) {
                recomendacaoSemanalList.addAll(recomendacaoService.executeByCodNeg(listCodneg, dtLimitePregao))
            }
        } catch (ex: Exception) {
            log.error("Erro ao gerar recomendação: {} ", ex.message)
            throw ex
        }
        return recomendacaoSemanalList
    }

    @Throws(Exception::class)
    private fun executeMediaSimplesSemanal(listCodneg: List<String>): Boolean {
        val lisMMS: MutableList<MediaMovelSimplesSemanal> = ArrayList()
        listCodneg
                .parallelStream()
                .filter { obj: String? -> Objects.nonNull(obj) }
                .forEach { codneg: String? -> lisMMS.addAll(mmsService.executeByCodNeg(codneg)) }
        return !lisMMS.isEmpty()
    }

    @Throws(Exception::class)
    private fun executeMediaExponencialSemanal(listCodneg: List<String>): Boolean {
        val lisMME: MutableList<MediaMovelExponencialSemanal> = ArrayList()
        listCodneg
                .parallelStream()
                .filter { obj: String? -> Objects.nonNull(obj) }
                .forEach { codneg: String? -> lisMME.addAll(mmeService.executeByCodNeg(codneg)) }
        return !lisMME.isEmpty()
    }

    @Throws(Exception::class)
    private fun executeMacdSemanal(listCodneg: List<String>): Boolean {
        val listMacd: MutableList<MacdSemanal> = ArrayList()
        listCodneg
                .parallelStream()
                .filter { obj: String? -> Objects.nonNull(obj) }
                .forEach { codneg: String? -> listMacd.addAll(macdService.executeByCodNeg(codneg)) }
        return !listMacd.isEmpty()
    }

    @Throws(Exception::class)
    private fun executeSinalMacdSemanal(listCodneg: List<String>): Boolean {
        val listSinal: MutableList<SinalMacdSemanal> = ArrayList()
        listCodneg
                .parallelStream()
                .filter { obj: String? -> Objects.nonNull(obj) }
                .forEach { codneg: String? -> listSinal.addAll(sinalMacdService.executeByCodNeg(codneg)) }
        return !listSinal.isEmpty()
    }

    @Throws(Exception::class)
    private fun executeHistogramaSemanal(listCodneg: List<String>): Boolean {
        val listHistograma: MutableList<HistogramaSemanal> = ArrayList()
        listCodneg
                .parallelStream()
                .filter { obj: String? -> Objects.nonNull(obj) }
                .forEach { codneg: String? -> listHistograma.addAll(histogramaService.executeByCodNeg(codneg)) }
        return !listHistograma.isEmpty()
    }

    override fun equals(o: Any?): Boolean {
        if (o === this) {
            return true
        }
        if (o !is CalculaGeralSemanalServiceImpl) {
            return false
        }
        val other = o
        if (!other.canEqual(this as Any)) {
            return false
        }
        val `this$mmsService`: Any = mmsService
        val `other$mmsService`: Any = other.mmsService
        if (if (`this$mmsService` == null) `other$mmsService` != null else `this$mmsService` != `other$mmsService`) {
            return false
        }
        val `this$mmeService`: Any = mmeService
        val `other$mmeService`: Any = other.mmeService
        if (if (`this$mmeService` == null) `other$mmeService` != null else `this$mmeService` != `other$mmeService`) {
            return false
        }
        val `this$macdService`: Any = macdService
        val `other$macdService`: Any = other.macdService
        if (if (`this$macdService` == null) `other$macdService` != null else `this$macdService` != `other$macdService`) {
            return false
        }
        val `this$sinalMacdService`: Any = sinalMacdService
        val `other$sinalMacdService`: Any = other.sinalMacdService
        if (if (`this$sinalMacdService` == null) `other$sinalMacdService` != null else `this$sinalMacdService` != `other$sinalMacdService`) {
            return false
        }
        val `this$histogramaService`: Any = histogramaService
        val `other$histogramaService`: Any = other.histogramaService
        if (if (`this$histogramaService` == null) `other$histogramaService` != null else `this$histogramaService` != `other$histogramaService`) {
            return false
        }
        val `this$recomendacaoService`: Any = recomendacaoService
        val `other$recomendacaoService`: Any = other.recomendacaoService
        return if (if (`this$recomendacaoService` == null) `other$recomendacaoService` != null else `this$recomendacaoService` != `other$recomendacaoService`) {
            false
        } else true
    }

    protected fun canEqual(other: Any?): Boolean {
        return other is CalculaGeralSemanalServiceImpl
    }

    override fun hashCode(): Int {
        val PRIME = 59
        var result = 1
        val `$mmsService`: Any = mmsService
        result = result * PRIME + (`$mmsService`?.hashCode() ?: 43)
        val `$mmeService`: Any = mmeService
        result = result * PRIME + (`$mmeService`?.hashCode() ?: 43)
        val `$macdService`: Any = macdService
        result = result * PRIME + (`$macdService`?.hashCode() ?: 43)
        val `$sinalMacdService`: Any = sinalMacdService
        result = result * PRIME + (`$sinalMacdService`?.hashCode() ?: 43)
        val `$histogramaService`: Any = histogramaService
        result = result * PRIME + (`$histogramaService`?.hashCode() ?: 43)
        val `$recomendacaoService`: Any = recomendacaoService
        result = result * PRIME + (`$recomendacaoService`?.hashCode() ?: 43)
        return result
    }

    override fun toString(): String {
        return ("CalculaGeralSemanalServiceImpl(mmsService=" + mmsService + ", mmeService="
                + mmeService + ", macdService=" + macdService + ", sinalMacdService="
                + sinalMacdService + ", histogramaService=" + histogramaService
                + ", recomendacaoService=" + recomendacaoService + ")")
    }

    companion object {
        private val log = LoggerFactory
                .getLogger(CalculaGeralSemanalServiceImpl::class.java)
    }

}