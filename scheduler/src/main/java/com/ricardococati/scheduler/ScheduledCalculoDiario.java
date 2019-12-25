package com.ricardococati.scheduler;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import com.ricardococati.model.dto.ControleExecucao;
import com.ricardococati.service.ICalculaHistogramaDiarioService;
import com.ricardococati.service.ICalculaMACDDiarioService;
import com.ricardococati.service.ICalculaMediaMovelExponencialDiarioService;
import com.ricardococati.service.ICalculaMediaMovelSimplesDiarioService;
import com.ricardococati.service.ICalculaService;
import com.ricardococati.service.ICalculaSinalMacdDiarioService;
import com.ricardococati.service.ICandlestickDiarioService;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ScheduledCalculoDiario {

  private final ICalculaMediaMovelExponencialDiarioService calculaMediaMovelExponencial;
  private final ICalculaMediaMovelSimplesDiarioService calculaMediaMovelSimples;
  private final ICalculaMACDDiarioService calculaMACDService;
  private final ICalculaSinalMacdDiarioService calculaSinalMacdService;
  private final ICalculaHistogramaDiarioService calculaHistogramaService;
  private final ICandlestickDiarioService diarioService;
  private final ICalculaService calculaService;
  SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
  LocalDate dtpregLimite = LocalDate.of(2017, 01, 01);

  @Scheduled(cron = "0 0/1 * * * *")
  public void executaAgendador() {
    log.info("Inicia execução CALCULOS em " + sdf.format(new Date()));
    try {
      ControleExecucao controleExecucao = calculaService.carregaControleExecucao();
      if(controleExecucao.getControleExecucaoAtivo()) {
        if (controleExecucao.getCalcMediaSimplesDiarioExecutado()) {
          executeMediaSimplesDiario(controleExecucao);
          controleExecucao.setCalcMediaSimplesDiarioExecutado(false);
          controleExecucao.setCalcMediaSimplesDiarioExecutadoDtpreg(dtpregLimite);
        }
        if (controleExecucao.getCalcMediaExponencialDiarioExecutado()) {
          executeMediaExponencialDiario(controleExecucao);
          controleExecucao.setCalcMediaExponencialDiarioExecutado(false);
          controleExecucao.setCalcMediaExponencialDiarioExecutadoDtpreg(dtpregLimite);
        }
        if (controleExecucao.getCalcMacdDiarioExecutado()) {
          executeMacdDiario(controleExecucao);
          controleExecucao.setCalcMacdDiarioExecutado(false);
          controleExecucao.setCalcMacdDiarioExecutadoDtpreg(dtpregLimite);
        }
        if (controleExecucao.getCalcSinalMacdDiarioExecutado()) {
          executeSinalMacdDiario(controleExecucao);
          controleExecucao.setCalcSinalMacdDiarioExecutado(false);
          controleExecucao.setCalcSinalMacdDiarioExecutadoDtpreg(dtpregLimite);
        }
        if (controleExecucao.getCalcHistogramaDiarioExecutado()) {
          executeHistogramaDiario(controleExecucao);
          controleExecucao.setCalcHistogramaDiarioExecutado(false);
          controleExecucao.setCalcHistogramaDiarioExecutadoDtpreg(dtpregLimite);
        }
        calculaService.updateControleExecucaoDiario(controleExecucao);
      }
    } catch (Exception e) {
      log.error(" Causa: " + e.getCause() + " Mensagem de Erro: " + e.getMessage());
    }
    log.info("Termina execução CALCULOS em " + sdf.format(new Date()));
  }

  private void executeMediaSimplesDiario(final ControleExecucao controleExecucao) {
    diarioService.listCodNegocioMediaSimplesFalse(
        verificaUltimaExecucao(controleExecucao.getCalcMediaSimplesDiarioExecutadoDtpreg()))
        .stream()
        .filter(Objects::nonNull)
        .forEach(codneg -> {
          calculaMediaMovelSimples.executeByCodNeg(codneg);
        });
  }

  private void executeMediaExponencialDiario(final ControleExecucao controleExecucao) {
    diarioService.listCodNegocioMediaExponencialFalse(
        verificaUltimaExecucao(controleExecucao.getCalcMediaExponencialDiarioExecutadoDtpreg()))
        .stream()
        .filter(Objects::nonNull)
        .forEach(codneg -> {
          calculaMediaMovelExponencial.executeByCodNeg(codneg);
        });
  }

  private void executeMacdDiario(final ControleExecucao controleExecucao) {
    diarioService.listCodNegocioMacdFalse(
        verificaUltimaExecucao(controleExecucao.getCalcMacdDiarioExecutadoDtpreg()))
        .stream()
        .filter(Objects::nonNull)
        .forEach(codneg -> {
          calculaMACDService.executeByCodNeg(codneg);
        });
  }

  private void executeSinalMacdDiario(final ControleExecucao controleExecucao) {
    diarioService.listCodNegocioSinalMacdFalse(
        verificaUltimaExecucao(controleExecucao.getCalcSinalMacdDiarioExecutadoDtpreg()))
        .stream()
        .filter(Objects::nonNull)
        .forEach(codneg -> {
          calculaSinalMacdService.executeByCodNeg(codneg);
        });
  }

  private void executeHistogramaDiario(final ControleExecucao controleExecucao) {
    diarioService.listCodNegocioHistogramaFalse(
        verificaUltimaExecucao(controleExecucao.getCalcHistogramaDiarioExecutadoDtpreg()))
        .stream()
        .filter(Objects::nonNull)
        .forEach(codneg -> {
          calculaHistogramaService.executeByCodNeg(codneg);
        });
  }

  private LocalDate verificaUltimaExecucao(final LocalDate dtUltimaExec){
    LocalDate dataRetorno = dtpregLimite;
    if(isNull(dtUltimaExec)){
      return dataRetorno;
    } else if(nonNull(dtUltimaExec) && dtUltimaExec.isBefore(dataRetorno)){
      dataRetorno = dtUltimaExec;
    }
    return dataRetorno;
  }

}