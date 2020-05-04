package com.ricardococati.service.scheduler;

import com.ricardococati.model.entities.ControleExecucao;
import com.ricardococati.service.CalculaService;
import com.ricardococati.service.CandlestickDiarioBuscarService;
import com.ricardococati.service.HistogramaDiarioCalculaService;
import com.ricardococati.service.MACDDiarioCalculaService;
import com.ricardococati.service.MediaMovelExponencialDiarioCalculaService;
import com.ricardococati.service.MediaMovelSimplesDiarioCalculaService;
import com.ricardococati.service.SinalMacdDiarioCalculaService;
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
public class CalculoDiarioAgendadoService {

  private final MediaMovelExponencialDiarioCalculaService calculaMediaMovelExponencial;
  private final MediaMovelSimplesDiarioCalculaService calculaMediaMovelSimples;
  private final MACDDiarioCalculaService calculaMACDService;
  private final SinalMacdDiarioCalculaService calculaSinalMacdService;
  private final HistogramaDiarioCalculaService calculaHistogramaService;
  private final CandlestickDiarioBuscarService diarioService;
  private final CalculaService calculaService;
  SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
  LocalDate dtpregLimite = LocalDate.of(2001, 01, 01);

  @Scheduled(cron = "0 0/1 * * * *")
  public void executaAgendador() {
    log.info("Inicia execução CALCULOS em " + sdf.format(new Date()));
    try {
      ControleExecucao controleExecucao = calculaService.carregaControleExecucao();
      if (controleExecucao.getControleExecucaoAtivo()) {
        executeMediaSimplesDiario(controleExecucao);
        executeMediaExponencialDiario(controleExecucao);
        executeMacdDiario(controleExecucao);
        executeSinalMacdDiario(controleExecucao);
        executeHistogramaDiario(controleExecucao);
      }
    } catch (Exception e) {
      log.error(" Causa: " + e.getCause() + " Mensagem de Erro: " + e.getMessage());
    }
    log.info("Termina execução CALCULOS em " + sdf.format(new Date()));
  }

  private void executeMediaSimplesDiario(final ControleExecucao controleExecucao) {
    diarioService.buscaCandlestickDiarioPorDtPreg(dtpregLimite)
        .stream()
        .filter(Objects::nonNull)
        .forEach(codneg -> {
          calculaMediaMovelSimples.executeByCodNeg(codneg);
        });
  }

  private void executeMediaExponencialDiario(final ControleExecucao controleExecucao) {
    diarioService.buscaCandlestickDiarioPorDtPreg(dtpregLimite)
        .stream()
        .filter(Objects::nonNull)
        .forEach(codneg -> {
          calculaMediaMovelExponencial.executeByCodNeg(codneg);
        });
  }

  private void executeMacdDiario(final ControleExecucao controleExecucao) {
    diarioService.buscaCandlestickDiarioPorDtPreg(dtpregLimite)
        .stream()
        .filter(Objects::nonNull)
        .forEach(codneg -> {
          calculaMACDService.executeByCodNeg(codneg);
        });
  }

  private void executeSinalMacdDiario(final ControleExecucao controleExecucao) {
    diarioService.buscaCandlestickDiarioPorDtPreg(dtpregLimite)
        .stream()
        .filter(Objects::nonNull)
        .forEach(codneg -> {
          calculaSinalMacdService.executeByCodNeg(codneg);
        });
  }

  private void executeHistogramaDiario(final ControleExecucao controleExecucao) {
    diarioService.buscaCandlestickDiarioPorDtPreg(dtpregLimite)
        .stream()
        .filter(Objects::nonNull)
        .forEach(codneg -> {
          calculaHistogramaService.executeByCodNeg(codneg);
        });
  }

}