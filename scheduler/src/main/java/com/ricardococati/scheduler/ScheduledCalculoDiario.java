package com.ricardococati.scheduler;

import com.ricardococati.model.dto.ControleExecucao;
import com.ricardococati.service.ICalculaHistogramaDiarioService;
import com.ricardococati.service.ICalculaMACDDiarioService;
import com.ricardococati.service.ICalculaMediaMovelExponencialDiarioService;
import com.ricardococati.service.ICalculaMediaMovelSimplesDiarioService;
import com.ricardococati.service.ICalculaService;
import com.ricardococati.service.ICalculaSinalMacdDiarioService;
import com.ricardococati.service.ICandlestickDiarioService;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
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

  @Scheduled(cron = "0 0/1 * * * *")
  public void executaAgendador() {
    log.info("Inicia execução CALCULOS em " + sdf.format(new Date()));
    try {
      ControleExecucao controleExecucao = calculaService.carregaControleExecucao();
      if(false) {
        if (controleExecucao.getCalcMediaSimplesDiarioExecutado()) {
          executeMediaSimplesDiario();
          controleExecucao.setCalcMediaSimplesDiarioExecutado(false);
        }
        if (controleExecucao.getCalcMediaExponencialDiarioExecutado()) {
          executeMediaExponencialDiario();
          controleExecucao.setCalcMediaExponencialDiarioExecutado(false);
        }
        if (controleExecucao.getCalcMacdDiarioExecutado()) {
          executeMacdDiario();
          controleExecucao.setCalcMacdDiarioExecutado(false);
        }
        if (controleExecucao.getCalcSinalMacdDiarioExecutado()) {
          executeSinalMacdDiario();
          controleExecucao.setCalcSinalMacdDiarioExecutado(false);
        }
        if (controleExecucao.getCalcHistogramaDiarioExecutado()) {
          executeHistogramaDiario();
          controleExecucao.setCalcHistogramaDiarioExecutado(false);
        }
        calculaService.updateControleExecucaoDiario(controleExecucao);
      }
    } catch (Exception e) {
      log.error(" Causa: " + e.getCause() + " Mensagem de Erro: " + e.getMessage());
    }
    log.info("Termina execução CALCULOS em " + sdf.format(new Date()));
  }

  private void executeMediaSimplesDiario() {
    diarioService.listCodNegocioMediaSimplesFalse()
        .stream()
        .filter(Objects::nonNull)
        .forEach(codneg -> {
          calculaMediaMovelSimples.executeByCodNeg(codneg);
        });
  }

  private void executeMediaExponencialDiario() {
    diarioService.listCodNegocioMediaExponencialFalse()
        .stream()
        .filter(Objects::nonNull)
        .forEach(codneg -> {
          calculaMediaMovelExponencial.executeByCodNeg(codneg);
        });
  }

  private void executeMacdDiario() {
    diarioService.listCodNegocioMacdFalse()
        .stream()
        .filter(Objects::nonNull)
        .forEach(codneg -> {
          calculaMACDService.executeByCodNeg(codneg);
        });
  }

  private void executeSinalMacdDiario() {
    diarioService.listCodNegocioSinalMacdFalse()
        .stream()
        .filter(Objects::nonNull)
        .forEach(codneg -> {
          calculaSinalMacdService.executeByCodNeg(codneg);
        });
  }

  private void executeHistogramaDiario() {
    diarioService.listCodNegocioHistogramaFalse()
        .stream()
        .filter(Objects::nonNull)
        .forEach(codneg -> {
          calculaHistogramaService.executeByCodNeg(codneg);
        });
  }

}