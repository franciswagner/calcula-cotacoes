package com.ricardococati.calculacotacoes.adapters.schedulers;

import com.ricardococati.calculacotacoes.entities.domains.controle.ControleExecucao;
import com.ricardococati.calculacotacoes.usecases.calculageral.CalculaService;
import com.ricardococati.calculacotacoes.usecases.candlestick.CandlestickDiarioBuscarService;
import com.ricardococati.calculacotacoes.usecases.histograma.HistogramaDiarioCalculaService;
import com.ricardococati.calculacotacoes.usecases.macd.MACDDiarioCalculaService;
import com.ricardococati.calculacotacoes.usecases.mediaexponencial.MediaMovelExponencialDiarioCalculaService;
import com.ricardococati.calculacotacoes.usecases.mediasimples.MediaMovelSimplesDiarioCalculaService;
import com.ricardococati.calculacotacoes.usecases.sinalmacd.SinalMacdDiarioCalculaService;
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