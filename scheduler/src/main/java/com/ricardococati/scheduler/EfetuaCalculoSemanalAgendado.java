package com.ricardococati.scheduler;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import com.ricardococati.model.dto.ControleExecucao;
import com.ricardococati.service.CalculaHistogramaSemanalService;
import com.ricardococati.service.CalculaMACDSemanalService;
import com.ricardococati.service.CalculaMediaMovelExponencialSemanalService;
import com.ricardococati.service.CalculaMediaMovelSimplesSemanalService;
import com.ricardococati.service.CalculaService;
import com.ricardococati.service.CalculaSinalMacdSemanalService;
import com.ricardococati.service.BuscarCandlestickSemanalService;
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
public class EfetuaCalculoSemanalAgendado {

  private final CalculaMediaMovelExponencialSemanalService calculaMediaMovelExponencial;
  private final CalculaMediaMovelSimplesSemanalService calculaMediaMovelSimples;
  private final CalculaMACDSemanalService calculaMACDService;
  private final CalculaSinalMacdSemanalService calculaSinalMacdService;
  private final CalculaHistogramaSemanalService histogramaService;
  private final CalculaService calculaService;
  private final BuscarCandlestickSemanalService semanalService;
  SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
  LocalDate dtpregLimite = LocalDate.of(2017, 01, 01);

  @Scheduled(cron = "0 0/1 * * * *")
  public void executaAgendador() {
    log.info("Inicia execução CALCULOS em " + sdf.format(new Date()));
    try {
      ControleExecucao controleExecucao = calculaService.carregaControleExecucao();
      if (controleExecucao.getControleExecucaoAtivo()) {
        if (controleExecucao.getCalcMediaSimplesSemanalExecutado()) {
          executeMediaSimplesSemanal(controleExecucao);
          controleExecucao.setCalcMediaSimplesSemanalExecutado(false);
          controleExecucao.setCalcMediaSimplesSemanalExecutadoDtpreg(dtpregLimite);
          calculaService.updateControleExecucaoSemanal(controleExecucao);
        }
        if (controleExecucao.getCalcMediaExponencialSemanalExecutado()) {
          executeMediaExponencialSemanal(controleExecucao);
          controleExecucao.setCalcMediaExponencialSemanalExecutado(false);
          controleExecucao.setCalcMediaExponencialSemanalExecutadoDtpreg(dtpregLimite);
          calculaService.updateControleExecucaoSemanal(controleExecucao);
        }
        if (controleExecucao.getCalcMacdSemanalExecutado()) {
          executeMacdSemanal(controleExecucao);
          controleExecucao.setCalcMacdSemanalExecutado(false);
          controleExecucao.setCalcMacdSemanalExecutadoDtpreg(dtpregLimite);
          calculaService.updateControleExecucaoSemanal(controleExecucao);
        }
        if (controleExecucao.getCalcSinalMacdSemanalExecutado()) {
          executeSinalMacdSemanal(controleExecucao);
          controleExecucao.setCalcSinalMacdSemanalExecutado(false);
          controleExecucao.setCalcSinalMacdSemanalExecutadoDtpreg(dtpregLimite);
          calculaService.updateControleExecucaoSemanal(controleExecucao);
        }
        if (controleExecucao.getCalcHistogramaSemanalExecutado()) {
          executeHistogramaSemanal(controleExecucao);
          controleExecucao.setCalcHistogramaSemanalExecutado(false);
          controleExecucao.setCalcHistogramaSemanalExecutadoDtpreg(dtpregLimite);
          calculaService.updateControleExecucaoSemanal(controleExecucao);
        }
      }
    } catch (Exception e) {
      log.error(" Causa: " + e.getCause() + " Mensagem de Erro: " + e.getMessage());
    }
    log.info("Termina execução CALCULOS em " + sdf.format(new Date()));
  }

  private void executeMediaSimplesSemanal(final ControleExecucao controleExecucao) {
    semanalService.buscaCandlestickSemanalPorDtPreg(
        verificaUltimaExecucao(controleExecucao.getCalcMediaSimplesSemanalExecutadoDtpreg()))
        .stream()
        .filter(Objects::nonNull)
        .forEach(codneg -> {
          calculaMediaMovelSimples.executeByCodNeg(codneg);
        });
  }

  private void executeMediaExponencialSemanal(final ControleExecucao controleExecucao) {
    semanalService.buscaCandlestickSemanalPorDtPreg(
        verificaUltimaExecucao(controleExecucao.getCalcMediaExponencialSemanalExecutadoDtpreg()))
        .stream()
        .filter(Objects::nonNull)
        .forEach(codneg -> {
          calculaMediaMovelExponencial.executeByCodNeg(codneg);
        });
  }

  private void executeMacdSemanal(final ControleExecucao controleExecucao) {
    semanalService.buscaCandlestickSemanalPorDtPreg(
        verificaUltimaExecucao(controleExecucao.getCalcMacdSemanalExecutadoDtpreg()))
        .stream()
        .filter(Objects::nonNull)
        .forEach(codneg -> {
          calculaMACDService.executeByCodNeg(codneg);
        });
  }

  private void executeSinalMacdSemanal(final ControleExecucao controleExecucao) {
    semanalService.buscaCandlestickSemanalPorDtPreg(
        verificaUltimaExecucao(controleExecucao.getCalcSinalMacdSemanalExecutadoDtpreg()))
        .stream()
        .filter(Objects::nonNull)
        .forEach(codneg -> {
          calculaSinalMacdService.executeByCodNeg(codneg);
        });
  }

  private void executeHistogramaSemanal(final ControleExecucao controleExecucao) {
    semanalService.buscaCandlestickSemanalPorDtPreg(
        verificaUltimaExecucao(controleExecucao.getCalcHistogramaSemanalExecutadoDtpreg()))
        .stream()
        .filter(Objects::nonNull)
        .forEach(codneg -> {
          histogramaService.executeByCodNeg(codneg);
        });
  }

  private LocalDate verificaUltimaExecucao(final LocalDate dtUltimaExec) {
    LocalDate dataRetorno = dtpregLimite;
    if (isNull(dtUltimaExec)) {
      return dataRetorno;
    } else if (nonNull(dtUltimaExec) && dtUltimaExec.isBefore(dataRetorno)) {
      dataRetorno = dtUltimaExec;
    }
    return dataRetorno;
  }

}
