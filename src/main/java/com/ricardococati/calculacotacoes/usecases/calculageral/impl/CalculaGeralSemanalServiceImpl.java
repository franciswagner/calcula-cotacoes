package com.ricardococati.calculacotacoes.usecases.calculageral.impl;

import static com.ricardococati.calculacotacoes.adapters.message.topic.TopicosDiarioSemanal.TOPIC_RECOMENDACAO_SEMANAL;

import com.ricardococati.calculacotacoes.adapters.message.action.RecomendacaoActionListener;
import com.ricardococati.calculacotacoes.entities.domains.histograma.HistogramaSemanal;
import com.ricardococati.calculacotacoes.entities.domains.macd.MacdSemanal;
import com.ricardococati.calculacotacoes.entities.domains.mediaexponencial.MediaMovelExponencialSemanal;
import com.ricardococati.calculacotacoes.entities.domains.mediasimples.MediaMovelSimplesSemanal;
import com.ricardococati.calculacotacoes.entities.domains.recomendacao.RecomendacaoSemanal;
import com.ricardococati.calculacotacoes.entities.domains.sinalmacd.SinalMacdSemanal;
import com.ricardococati.calculacotacoes.usecases.calculageral.CalculaGeralSemanalService;
import com.ricardococati.calculacotacoes.usecases.histograma.HistogramaSemanalCalculaService;
import com.ricardococati.calculacotacoes.usecases.macd.MACDSemanalCalculaService;
import com.ricardococati.calculacotacoes.usecases.mediaexponencial.MediaMovelExponencialSemanalCalculaService;
import com.ricardococati.calculacotacoes.usecases.mediasimples.MediaMovelSimplesSemanalCalculaService;
import com.ricardococati.calculacotacoes.usecases.recomendacao.RecomendacaoSemanalCalculaService;
import com.ricardococati.calculacotacoes.usecases.sinalmacd.SinalMacdSemanalCalculaService;
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
public class CalculaGeralSemanalServiceImpl implements
    CalculaGeralSemanalService {

  public static final String RECOMENDACAO_SEMANAL_CALCULA_INPUT = "recomendacao.semanal.calcula.input";
  private final MediaMovelSimplesSemanalCalculaService mmsService;
  private final MediaMovelExponencialSemanalCalculaService mmeService;
  private final MACDSemanalCalculaService macdService;
  private final SinalMacdSemanalCalculaService sinalMacdService;
  private final HistogramaSemanalCalculaService histogramaService;
  private final RecomendacaoSemanalCalculaService recomendacaoService;
  private final RecomendacaoActionListener actionListener;

  @Override
  public List<RecomendacaoSemanal> executeByCodNeg(
      final List<String> listCodneg,
      final LocalDate dtLimitePregao
  ) throws Exception{
    List<RecomendacaoSemanal> recomendacaoSemanalList = new ArrayList<>();
    try {
      Boolean controle = executeMediaSimplesSemanal(listCodneg);
      controle = controle && executeMediaExponencialSemanal(listCodneg);
      controle = controle && executeMacdSemanal(listCodneg);
      controle = controle && executeSinalMacdSemanal(listCodneg);
      controle = controle && executeHistogramaSemanal(listCodneg);
      if (controle) {
        recomendacaoSemanalList.addAll(recomendacaoService.executeByCodNeg(listCodneg, dtLimitePregao));
      }
    } catch (Exception ex){
      log.error("Erro ao gerar recomendação: {} ", ex.getMessage());
      throw ex;
    }
    sendRecomendacao(recomendacaoSemanalList);
    return recomendacaoSemanalList;
  }

  private Boolean executeMediaSimplesSemanal(final List<String> listCodneg) throws Exception {
    List<MediaMovelSimplesSemanal> lisMMS = new ArrayList<>();
    listCodneg
        .parallelStream()
        .filter(Objects::nonNull)
        .forEach(codneg -> {
          lisMMS.addAll(mmsService.executeByCodNeg(codneg));
        });
    return !lisMMS.isEmpty();
  }

  private Boolean executeMediaExponencialSemanal(final List<String> listCodneg) throws Exception {
    List<MediaMovelExponencialSemanal> lisMME = new ArrayList<>();
    listCodneg
        .parallelStream()
        .filter(Objects::nonNull)
        .forEach(codneg -> {
          lisMME.addAll(mmeService.executeByCodNeg(codneg));
        });
    return !lisMME.isEmpty();
  }

  private Boolean executeMacdSemanal(final List<String> listCodneg) throws Exception {
    List<MacdSemanal> listMacd = new ArrayList<>();
    listCodneg
        .parallelStream()
        .filter(Objects::nonNull)
        .forEach(codneg -> {
          listMacd.addAll(macdService.executeByCodNeg(codneg));
        });
    return !listMacd.isEmpty();
  }

  private Boolean executeSinalMacdSemanal(final List<String> listCodneg) throws Exception {
    List<SinalMacdSemanal> listSinal = new ArrayList<>();
    listCodneg
        .parallelStream()
        .filter(Objects::nonNull)
        .forEach(codneg -> {
          listSinal.addAll(sinalMacdService.executeByCodNeg(codneg));
        });
    return !listSinal.isEmpty();
  }

  private Boolean executeHistogramaSemanal(final List<String> listCodneg) throws Exception {
    List<HistogramaSemanal> listHistograma = new ArrayList<>();
    listCodneg
        .parallelStream()
        .filter(Objects::nonNull)
        .forEach(codneg -> {
          listHistograma.addAll(histogramaService.executeByCodNeg(codneg));
        });
    return !listHistograma.isEmpty();
  }

  private void sendRecomendacao(final List<RecomendacaoSemanal> recomendacaoSemanalList) {
    recomendacaoSemanalList
        .stream()
        .filter(Objects::nonNull)
        .forEach(recomendacaoSemanal -> {
          log.info("Enviado ao tópico:  " + TOPIC_RECOMENDACAO_SEMANAL.getTopicName()  + " Recomendações "+ recomendacaoSemanal);
          actionListener.onAfterSave(recomendacaoSemanal, TOPIC_RECOMENDACAO_SEMANAL.getTopicName());
        });
  }

}
