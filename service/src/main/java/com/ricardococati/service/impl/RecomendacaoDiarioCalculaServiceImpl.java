package com.ricardococati.service.impl;

import com.ricardococati.model.dto.HistogramaDiario;
import com.ricardococati.model.dto.Recomendacao;
import com.ricardococati.model.dto.RecomendacaoDiario;
import com.ricardococati.repository.dao.HistogramaDiarioDAO;
import com.ricardococati.repository.dao.MacdDiarioDAO;
import com.ricardococati.repository.dao.MediaMovelExponencialDiarioDAO;
import com.ricardococati.repository.dao.RecomendacaoDiarioDAO;
import com.ricardococati.repository.dao.SinalMacdDiarioDAO;
import com.ricardococati.service.RecomendacaoDiarioCalculaService;
import com.ricardococati.service.CalculaService;
import com.ricardococati.service.CandlestickDiarioBuscarService;
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
public class RecomendacaoDiarioCalculaServiceImpl
    implements RecomendacaoDiarioCalculaService {

  private final CandlestickDiarioBuscarService calculaCandlestickService;
  private final MacdDiarioDAO macdDAO;
  private final SinalMacdDiarioDAO sinalMacdDAO;
  private final HistogramaDiarioDAO histogramaDAO;
  private final RecomendacaoDiarioDAO recomendacaoDAO;
  private final MediaMovelExponencialDiarioDAO mediaMovelExponencialDAO;
  private final CalculaService calculaService;
  private final String COMPRA = "COMPRA";
  private final String VENDE = "VENDE";
  private final String NEUTRO = "NEUTRO";

  @Override
  public List<RecomendacaoDiario> executeByCodNeg(
      final List<String> listCodneg, final LocalDate dtLimitePregao) {
    List<RecomendacaoDiario> diarioList =  new ArrayList<>();
    log.info("Código de negociação: " + listCodneg);
    listCodneg
        .stream()
        .filter(Objects::nonNull)
        .forEach(codneg -> {
          diarioList.addAll(calculaRecomendacao(codneg, dtLimitePregao));
          recomendacaoDAO.incluirRecomendacao(diarioList);
        });
    return diarioList;
  }

  private List<RecomendacaoDiario> calculaRecomendacao(
      final String codneg, final LocalDate dtLimitePregao) {
    List<RecomendacaoDiario> recomendacaoList = buildListRecomendacao(
        codneg,
        dtLimitePregao
    );
    for (int indice = 0; indice < recomendacaoList.size(); indice++) {
      if (indice > 0 && recomendacaoList.size() >= 2) {
        if(recomendacaoList.get(indice-1).getRecomendacao().getPrecoHistograma()
            .compareTo(recomendacaoList.get(indice).getRecomendacao().getPrecoHistograma()) < 0){
          recomendacaoList.get(indice).getRecomendacao().setDecisao(COMPRA);
        } else if(recomendacaoList.get(indice-1).getRecomendacao().getPrecoHistograma()
            .compareTo(recomendacaoList.get(indice).getRecomendacao().getPrecoHistograma()) > 0){
          recomendacaoList.get(indice).getRecomendacao().setDecisao(VENDE);
        } else {
          recomendacaoList.get(indice).getRecomendacao().setDecisao(NEUTRO);
        }
      }
    }
    return recomendacaoList;
  }

  private List<RecomendacaoDiario> buildListRecomendacao(final String codneg, final LocalDate dtLimitePregao) {
    return recomendacaoDAO.getListRecomendacaoByDtPregECodNeg(
        dtLimitePregao,
        codneg
    );
  }

  private RecomendacaoDiario buildRecomendacao(
      final HistogramaDiario diario,
      final String decisao) {
    return RecomendacaoDiario.builder()
        .dtpreg(diario.getDtpreg())
        .recomendacao(
            Recomendacao
                .builder()
                .codneg(diario.getHistograma().getCodneg())
                .precoHistograma(diario.getHistograma().getPrehist())
                .decisao(decisao)
                .build())
        .build();
  }

}
