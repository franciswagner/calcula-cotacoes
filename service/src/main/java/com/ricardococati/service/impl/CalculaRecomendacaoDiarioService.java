package com.ricardococati.service.impl;

import com.ricardococati.model.dto.CandlestickDiarioDTO;
import com.ricardococati.model.dto.Histograma;
import com.ricardococati.model.dto.HistogramaDiario;
import com.ricardococati.model.dto.MacdDiario;
import com.ricardococati.model.dto.MediaMovelExponencialDiario;
import com.ricardococati.model.dto.MediaMovelSimplesDiario;
import com.ricardococati.model.dto.Recomendacao;
import com.ricardococati.model.dto.RecomendacaoDiario;
import com.ricardococati.model.dto.SinalMacdDiario;
import com.ricardococati.repository.dao.IHistogramaDiarioDAO;
import com.ricardococati.repository.dao.IMacdDiarioDAO;
import com.ricardococati.repository.dao.IMediaMovelExponencialDiarioDAO;
import com.ricardococati.repository.dao.IRecomendacaoDiarioDAO;
import com.ricardococati.repository.dao.ISinalMacdDiarioDAO;
import com.ricardococati.service.ICalculaRecomendacaoDiarioService;
import com.ricardococati.service.ICalculaService;
import com.ricardococati.service.ICandlestickDiarioService;
import java.math.BigDecimal;
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
public class CalculaRecomendacaoDiarioService
    implements ICalculaRecomendacaoDiarioService {

  private final ICandlestickDiarioService calculaCandlestickService;
  private final IMacdDiarioDAO macdDAO;
  private final ISinalMacdDiarioDAO sinalMacdDAO;
  private final IHistogramaDiarioDAO histogramaDAO;
  private final IRecomendacaoDiarioDAO recomendacaoDAO;
  private final IMediaMovelExponencialDiarioDAO mediaMovelExponencialDAO;
  private final ICalculaService calculaService;
  private final String COMPRA = "COMPRA";
  private final String VENDE = "VENDE";
  private final String NEUTRO = "NEUTRO";

  @Override
  public List<RecomendacaoDiario> executeByCodNeg(
      final String codneg, LocalDate dtLimitePregao) {
    log.info("Código de negociação: " + codneg);
    List<RecomendacaoDiario> diarioList = calculaRecomendacao(codneg, dtLimitePregao);
    recomendacaoDAO.incluirRecomendacao(diarioList);
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
