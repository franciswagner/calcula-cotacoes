package com.ricardococati.scheduler;

import com.ricardococati.model.dto.ControleExecucao;
import com.ricardococati.service.ICalculaHistogramaDiarioService;
import com.ricardococati.service.ICalculaMACDDiarioService;
import com.ricardococati.service.ICalculaMediaMovelExponencialDiarioService;
import com.ricardococati.service.ICalculaMediaMovelSimplesDiarioService;
import com.ricardococati.service.ICalculaService;
import com.ricardococati.service.ICalculaSinalMacdDiarioService;
import java.text.SimpleDateFormat;
import java.util.Date;
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
  private final ICalculaHistogramaDiarioService histogramaService;
  private final ICalculaService calculaService;
  SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

  @Scheduled(cron = "0 0/1 * * * *")
  public void executaAgendador() {
    log.info("Inicia execução CALCULOS em " + sdf.format(new Date()));
    try {
      ControleExecucao controleExecucao = calculaService.carregaControleExecucao();
      if(controleExecucao.getControleExecucaoAtivo()) {
        if (controleExecucao.getCalcMediaSimplesDiarioExecutado()) {
          calculaMediaMovelSimples.execute();
          controleExecucao.setCalcMediaSimplesDiarioExecutado(false);
        }
        if (controleExecucao.getCalcMediaExponencialDiarioExecutado()) {
          calculaMediaMovelExponencial.execute();
          controleExecucao.setCalcMediaExponencialDiarioExecutado(false);
        }
        if (controleExecucao.getCalcMacdDiarioExecutado()) {
          calculaMACDService.execute();
          controleExecucao.setCalcMacdDiarioExecutado(false);
        }
        if (controleExecucao.getCalcSinalMacdDiarioExecutado()) {
          calculaSinalMacdService.execute();
          controleExecucao.setCalcSinalMacdDiarioExecutado(false);
        }
        if (controleExecucao.getCalcHistogramaDiarioExecutado()) {
          histogramaService.execute();
          controleExecucao.setCalcHistogramaDiarioExecutado(false);
        }
        calculaService.updateControleExecucaoDiario(controleExecucao);
      }
    } catch (Exception e) {
      log.error(" Causa: " + e.getCause() + " Mensagem de Erro: " + e.getMessage());
    }
    log.info("Termina execução CALCULOS em " + sdf.format(new Date()));
  }

}
