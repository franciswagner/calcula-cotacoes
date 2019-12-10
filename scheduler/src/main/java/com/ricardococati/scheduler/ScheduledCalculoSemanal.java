package com.ricardococati.scheduler;

import com.ricardococati.model.dto.ControleExecucao;
import com.ricardococati.service.ICalculaHistogramaSemanalService;
import com.ricardococati.service.ICalculaMACDSemanalService;
import com.ricardococati.service.ICalculaMediaMovelExponencialSemanalService;
import com.ricardococati.service.ICalculaMediaMovelSimplesSemanalService;
import com.ricardococati.service.ICalculaService;
import com.ricardococati.service.ICalculaSinalMacdSemanalService;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ScheduledCalculoSemanal {

  private final ICalculaMediaMovelExponencialSemanalService calculaMediaMovelExponencial;
  private final ICalculaMediaMovelSimplesSemanalService calculaMediaMovelSimples;
  private final ICalculaMACDSemanalService calculaMACDService;
  private final ICalculaSinalMacdSemanalService calculaSinalMacdService;
  private final ICalculaHistogramaSemanalService histogramaService;
  private final ICalculaService calculaService;
  SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

  @Scheduled(cron = "0 0/1 * * * *")
  public void executaAgendador() {
    log.info("Inicia execução CALCULOS em " + sdf.format(new Date()));
    try {
      ControleExecucao controleExecucao = calculaService.carregaControleExecucao();
      if(controleExecucao.getControleExecucaoAtivo()) {
        if (controleExecucao.getCalcMediaSimplesSemanalExecutado()) {
          calculaMediaMovelSimples.execute();
          controleExecucao.setCalcMediaSimplesSemanalExecutado(false);
        }
        if (controleExecucao.getCalcMediaExponencialSemanalExecutado()) {
          calculaMediaMovelExponencial.execute();
          controleExecucao.setCalcMediaExponencialSemanalExecutado(false);
        }
        if (controleExecucao.getCalcMacdSemanalExecutado()) {
          calculaMACDService.execute();
          controleExecucao.setCalcMacdSemanalExecutado(false);
        }
        if (controleExecucao.getCalcSinalMacdSemanalExecutado()) {
          calculaSinalMacdService.execute();
          controleExecucao.setCalcSinalMacdSemanalExecutado(false);
        }
        if (controleExecucao.getCalcHistogramaSemanalExecutado()) {
          histogramaService.execute();
          controleExecucao.setCalcHistogramaSemanalExecutado(false);
        }
        calculaService.updateControleExecucaoSemanal(controleExecucao);
      }
    } catch (Exception e) {
      log.error(" Causa: " + e.getCause() + " Mensagem de Erro: " + e.getMessage());
    }
    log.info("Termina execução CALCULOS em " + sdf.format(new Date()));
  }

}
