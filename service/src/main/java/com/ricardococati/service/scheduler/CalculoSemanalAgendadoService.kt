package com.ricardococati.service.scheduler

import com.ricardococati.model.entities.ControleExecucao
import com.ricardococati.service.CalculaService
import com.ricardococati.service.CandlestickSemanalBuscarService
import com.ricardococati.service.HistogramaSemanalCalculaService
import com.ricardococati.service.MACDSemanalCalculaService
import com.ricardococati.service.MediaMovelExponencialSemanalCalculaService
import com.ricardococati.service.MediaMovelSimplesSemanalCalculaService
import com.ricardococati.service.SinalMacdSemanalCalculaService
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Date
import java.util.Objects

@Service
class CalculoSemanalAgendadoService(
        private val calculaMediaMovelExponencial: MediaMovelExponencialSemanalCalculaService,
        private val calculaMediaMovelSimples: MediaMovelSimplesSemanalCalculaService,
        private val calculaMACDService: MACDSemanalCalculaService,
        private val calculaSinalMacdService: SinalMacdSemanalCalculaService,
        private val histogramaService: HistogramaSemanalCalculaService, private val calculaService: CalculaService,
        private val semanalService: CandlestickSemanalBuscarService) {
    var sdf = SimpleDateFormat("dd/MM/yyyy hh:mm:ss")
    var dtpregLimite = LocalDate.of(2001, 1, 1)

    @Scheduled(cron = "0 0/1 * * * *")
    fun executaAgendador() {
        log.info("Inicia execução CALCULOS em " + sdf.format(Date()))
        try {
            val controleExecucao = calculaService.carregaControleExecucao()
            if (controleExecucao.controleExecucaoAtivo!!) {
                executeMediaSimplesSemanal(controleExecucao)
                executeMediaExponencialSemanal(controleExecucao)
                executeMacdSemanal(controleExecucao)
                executeSinalMacdSemanal(controleExecucao)
                executeHistogramaSemanal(controleExecucao)
            }
        } catch (e: Exception) {
            log.error(" Causa: " + e.cause + " Mensagem de Erro: " + e.message)
        }
        log.info("Termina execução CALCULOS em " + sdf.format(Date()))
    }

    private fun executeMediaSimplesSemanal(controleExecucao: ControleExecucao) {
        semanalService.buscaCandlestickSemanalPorDtPreg(dtpregLimite)
                .stream()
                .filter { obj: String? -> Objects.nonNull(obj) }
                .forEach { codneg: String? -> calculaMediaMovelSimples.executeByCodNeg(codneg) }
    }

    private fun executeMediaExponencialSemanal(controleExecucao: ControleExecucao) {
        semanalService.buscaCandlestickSemanalPorDtPreg(dtpregLimite)
                .stream()
                .filter { obj: String? -> Objects.nonNull(obj) }
                .forEach { codneg: String? -> calculaMediaMovelExponencial.executeByCodNeg(codneg) }
    }

    private fun executeMacdSemanal(controleExecucao: ControleExecucao) {
        semanalService.buscaCandlestickSemanalPorDtPreg(dtpregLimite)
                .stream()
                .filter { obj: String? -> Objects.nonNull(obj) }
                .forEach { codneg: String? -> calculaMACDService.executeByCodNeg(codneg) }
    }

    private fun executeSinalMacdSemanal(controleExecucao: ControleExecucao) {
        semanalService.buscaCandlestickSemanalPorDtPreg(dtpregLimite)
                .stream()
                .filter { obj: String? -> Objects.nonNull(obj) }
                .forEach { codneg: String? -> calculaSinalMacdService.executeByCodNeg(codneg) }
    }

    private fun executeHistogramaSemanal(controleExecucao: ControleExecucao) {
        semanalService.buscaCandlestickSemanalPorDtPreg(dtpregLimite)
                .stream()
                .filter { obj: String? -> Objects.nonNull(obj) }
                .forEach { codneg: String? -> histogramaService.executeByCodNeg(codneg) }
    }

    companion object {
        private val log = LoggerFactory
                .getLogger(CalculoSemanalAgendadoService::class.java)
    }

}