package com.ricardococati.service.scheduler

import com.ricardococati.model.entities.ControleExecucao
import com.ricardococati.service.CalculaService
import com.ricardococati.service.CandlestickDiarioBuscarService
import com.ricardococati.service.HistogramaDiarioCalculaService
import com.ricardococati.service.MACDDiarioCalculaService
import com.ricardococati.service.MediaMovelExponencialDiarioCalculaService
import com.ricardococati.service.MediaMovelSimplesDiarioCalculaService
import com.ricardococati.service.SinalMacdDiarioCalculaService
import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.Date
import java.util.Objects

@Service
class CalculoDiarioAgendadoService(
        private val calculaMediaMovelExponencial: MediaMovelExponencialDiarioCalculaService,
        private val calculaMediaMovelSimples: MediaMovelSimplesDiarioCalculaService,
        private val calculaMACDService: MACDDiarioCalculaService,
        private val calculaSinalMacdService: SinalMacdDiarioCalculaService,
        private val calculaHistogramaService: HistogramaDiarioCalculaService,
        private val diarioService: CandlestickDiarioBuscarService,
        private val calculaService: CalculaService) {

    var sdf = SimpleDateFormat("dd/MM/yyyy hh:mm:ss")
    var dtpregLimite = LocalDate.of(2001, 1, 1)

    @Scheduled(cron = "0 0/1 * * * *")
    fun executaAgendador() {
        log.info("Inicia execução CALCULOS em " + sdf.format(Date()))
        try {
            val controleExecucao = calculaService.carregaControleExecucao()
            if (controleExecucao.controleExecucaoAtivo!!) {
                executeMediaSimplesDiario(controleExecucao)
                executeMediaExponencialDiario(controleExecucao)
                executeMacdDiario(controleExecucao)
                executeSinalMacdDiario(controleExecucao)
                executeHistogramaDiario(controleExecucao)
            }
        } catch (e: Exception) {
            log.error(" Causa: " + e.cause + " Mensagem de Erro: " + e.message)
        }
        log.info("Termina execução CALCULOS em " + sdf.format(Date()))
    }

    private fun executeMediaSimplesDiario(controleExecucao: ControleExecucao) {
        diarioService.buscaCandlestickDiarioPorDtPreg(dtpregLimite)
                .stream()
                .filter { obj: String? -> Objects.nonNull(obj) }
                .forEach { codneg: String? -> calculaMediaMovelSimples.executeByCodNeg(codneg) }
    }

    private fun executeMediaExponencialDiario(controleExecucao: ControleExecucao) {
        diarioService.buscaCandlestickDiarioPorDtPreg(dtpregLimite)
                .stream()
                .filter { obj: String? -> Objects.nonNull(obj) }
                .forEach { codneg: String? -> calculaMediaMovelExponencial.executeByCodNeg(codneg) }
    }

    private fun executeMacdDiario(controleExecucao: ControleExecucao) {
        diarioService.buscaCandlestickDiarioPorDtPreg(dtpregLimite)
                .stream()
                .filter { obj: String? -> Objects.nonNull(obj) }
                .forEach { codneg: String? -> calculaMACDService.executeByCodNeg(codneg) }
    }

    private fun executeSinalMacdDiario(controleExecucao: ControleExecucao) {
        diarioService.buscaCandlestickDiarioPorDtPreg(dtpregLimite)
                .stream()
                .filter { obj: String? -> Objects.nonNull(obj) }
                .forEach { codneg: String? -> calculaSinalMacdService.executeByCodNeg(codneg) }
    }

    private fun executeHistogramaDiario(controleExecucao: ControleExecucao) {
        diarioService.buscaCandlestickDiarioPorDtPreg(dtpregLimite)
                .stream()
                .filter { obj: String? -> Objects.nonNull(obj) }
                .forEach { codneg: String? -> calculaHistogramaService.executeByCodNeg(codneg) }
    }

    companion object {
        private val log = LoggerFactory
                .getLogger(CalculoDiarioAgendadoService::class.java)
    }

}