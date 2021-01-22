package com.ricardococati.calculacotacoes.usecases.calculageral.impl;

import static com.ricardococati.calculacotacoes.adapters.message.topic.TopicosDiarioSemanal.TOPIC_RECOMENDACAO_DIARIA;

import com.ricardococati.calculacotacoes.adapters.message.action.RecomendacaoActionListener;
import com.ricardococati.calculacotacoes.entities.domains.histograma.HistogramaDiario;
import com.ricardococati.calculacotacoes.entities.domains.macd.MacdDiario;
import com.ricardococati.calculacotacoes.entities.domains.mediaexponencial.MediaMovelExponencialDiario;
import com.ricardococati.calculacotacoes.entities.domains.mediasimples.MediaMovelSimplesDiario;
import com.ricardococati.calculacotacoes.entities.domains.recomendacao.RecomendacaoDiario;
import com.ricardococati.calculacotacoes.entities.domains.sinalmacd.SinalMacdDiario;
import com.ricardococati.calculacotacoes.usecases.calculageral.CalculaGeralDiarioService;
import com.ricardococati.calculacotacoes.usecases.histograma.HistogramaDiarioCalculaService;
import com.ricardococati.calculacotacoes.usecases.macd.MACDDiarioCalculaService;
import com.ricardococati.calculacotacoes.usecases.mediaexponencial.MediaMovelExponencialDiarioCalculaService;
import com.ricardococati.calculacotacoes.usecases.mediasimples.MediaMovelSimplesDiarioCalculaService;
import com.ricardococati.calculacotacoes.usecases.recomendacao.RecomendacaoDiarioCalculaService;
import com.ricardococati.calculacotacoes.usecases.sinalmacd.SinalMacdDiarioCalculaService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Data
@Service
@RequiredArgsConstructor
public class CalculaGeralDiarioServiceImpl implements
    CalculaGeralDiarioService {

  private final MediaMovelSimplesDiarioCalculaService mmsService;
  private final MediaMovelExponencialDiarioCalculaService mmeService;
  private final MACDDiarioCalculaService macdService;
  private final SinalMacdDiarioCalculaService sinalMacdService;
  private final HistogramaDiarioCalculaService histogramaService;
  private final RecomendacaoDiarioCalculaService recomendacaoService;
  private final RecomendacaoActionListener actionListener;

  @Override
  public List<RecomendacaoDiario> executeByCodNeg(
      final List<String> listCodneg,
      final LocalDate dtLimitePregao
  ) throws Exception{
    List<RecomendacaoDiario> recomendacaoDiarioList = new ArrayList<>();
    try {
      Boolean controle = executeMediaSimplesDiario(listCodneg);
      controle = controle && executeMediaExponencialDiario(listCodneg);
      controle = controle && executeMacdDiario(listCodneg);
      controle = controle && executeSinalMacdDiario(listCodneg);
      controle = controle && executeHistogramaDiario(listCodneg);
      if (controle) {
        recomendacaoDiarioList = recomendacaoService.executeByCodNeg(listCodneg, dtLimitePregao);
      }
    } catch (Exception ex){
      log.error("Erro ao gerar recomendação: {} ", ex.getMessage());
      throw ex;
    }
    sendRecomendacao(recomendacaoDiarioList);
    return recomendacaoDiarioList;
  }

  private Boolean executeMediaSimplesDiario(final List<String> listCodneg) throws Exception {
    List<MediaMovelSimplesDiario> lisMMS = new ArrayList<>();
    listCodneg
        .parallelStream()
        .filter(Objects::nonNull)
        .forEach(codneg -> lisMMS.addAll(mmsService.executeByCodNeg(codneg)));
    return !lisMMS.isEmpty();
  }

  private Boolean executeMediaExponencialDiario(final List<String> listCodneg) throws Exception {
    List<MediaMovelExponencialDiario> lisMME = new ArrayList<>();
    listCodneg
        .parallelStream()
        .filter(Objects::nonNull)
        .forEach(codneg -> lisMME.addAll(mmeService.executeByCodNeg(codneg)));
    return !lisMME.isEmpty();
  }

  private Boolean executeMacdDiario(final List<String> listCodneg) throws Exception {
    List<MacdDiario> listMacd = new ArrayList<>();
    listCodneg
        .parallelStream()
        .filter(Objects::nonNull)
        .forEach(codneg -> listMacd.addAll(macdService.executeByCodNeg(codneg)));
    return !listMacd.isEmpty();
  }

  private Boolean executeSinalMacdDiario(final List<String> listCodneg) throws Exception {
    List<SinalMacdDiario> listSinal = new ArrayList<>();
    listCodneg
        .parallelStream()
        .filter(Objects::nonNull)
        .forEach(codneg -> listSinal.addAll(sinalMacdService.executeByCodNeg(codneg)));
    return !listSinal.isEmpty();
  }

  private Boolean executeHistogramaDiario(final List<String> listCodneg) throws Exception {
    List<HistogramaDiario> listHistograma = new ArrayList<>();
    listCodneg
        .parallelStream()
        .filter(Objects::nonNull)
        .forEach(codneg -> listHistograma.addAll(histogramaService.executeByCodNeg(codneg)));
    return !listHistograma.isEmpty();
  }

  private void sendRecomendacao(final List<RecomendacaoDiario> recomendacaoDiarioList) {
    recomendacaoDiarioList
        .stream()
        .filter(Objects::nonNull)
        .forEach(recomendacaoSemanal -> {
          log.info("Enviado ao tópico: ", recomendacaoSemanal);
          actionListener.onAfterSave(recomendacaoSemanal, TOPIC_RECOMENDACAO_DIARIA.getTopicName());
        });
  }

}
