package com.ricardococati.service.scheduler;

import com.ricardococati.model.entities.ControleExecucao;
import com.ricardococati.service.CalculaService;
import com.ricardococati.service.CandlestickSemanalBuscarService;
import com.ricardococati.service.HistogramaSemanalCalculaService;
import com.ricardococati.service.MACDSemanalCalculaService;
import com.ricardococati.service.MediaMovelExponencialSemanalCalculaService;
import com.ricardococati.service.MediaMovelSimplesSemanalCalculaService;
import com.ricardococati.service.SinalMacdSemanalCalculaService;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CalculoSemanalAgendadoService {

  private final MediaMovelExponencialSemanalCalculaService calculaMediaMovelExponencial;
  private final MediaMovelSimplesSemanalCalculaService calculaMediaMovelSimples;
  private final MACDSemanalCalculaService calculaMACDService;
  private final SinalMacdSemanalCalculaService calculaSinalMacdService;
  private final HistogramaSemanalCalculaService histogramaService;
  private final CalculaService calculaService;
  private final CandlestickSemanalBuscarService semanalService;
  SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
  LocalDate dtpregLimite = LocalDate.of(2001, 01, 01);

  @Scheduled(cron = "0 0/1 * * * *")
  public void executaAgendador() {
    log.info("Inicia execução CALCULOS em " + sdf.format(new Date()));
    try {
      ControleExecucao controleExecucao = calculaService.carregaControleExecucao();
      if (controleExecucao.getControleExecucaoAtivo()) {
        executeMediaSimplesSemanal(controleExecucao);
        executeMediaExponencialSemanal(controleExecucao);
        executeMacdSemanal(controleExecucao);
        executeSinalMacdSemanal(controleExecucao);
        executeHistogramaSemanal(controleExecucao);
      }
    } catch (Exception e) {
      log.error(" Causa: " + e.getCause() + " Mensagem de Erro: " + e.getMessage());
    }
    log.info("Termina execução CALCULOS em " + sdf.format(new Date()));
  }

  private void executeMediaSimplesSemanal(final ControleExecucao controleExecucao) {
    semanalService.buscaCandlestickSemanalPorDtPreg(dtpregLimite)
        .stream()
        .filter(Objects::nonNull)
        .forEach(codneg -> {
          calculaMediaMovelSimples.executeByCodNeg(codneg);
        });
  }

  private void executeMediaExponencialSemanal(final ControleExecucao controleExecucao) {
    semanalService.buscaCandlestickSemanalPorDtPreg(dtpregLimite)
        .stream()
        .filter(Objects::nonNull)
        .forEach(codneg -> {
          calculaMediaMovelExponencial.executeByCodNeg(codneg);
        });
  }

  private void executeMacdSemanal(final ControleExecucao controleExecucao) {
    semanalService.buscaCandlestickSemanalPorDtPreg(dtpregLimite)
        .stream()
        .filter(Objects::nonNull)
        .forEach(codneg -> {
          calculaMACDService.executeByCodNeg(codneg);
        });
  }

  private void executeSinalMacdSemanal(final ControleExecucao controleExecucao) {
    semanalService.buscaCandlestickSemanalPorDtPreg(dtpregLimite)
        .stream()
        .filter(Objects::nonNull)
        .forEach(codneg -> {
          calculaSinalMacdService.executeByCodNeg(codneg);
        });
  }

  private void executeHistogramaSemanal(final ControleExecucao controleExecucao) {
    semanalService.buscaCandlestickSemanalPorDtPreg(dtpregLimite)
        .stream()
        .filter(Objects::nonNull)
        .forEach(codneg -> {
          histogramaService.executeByCodNeg(codneg);
        });
  }

}
