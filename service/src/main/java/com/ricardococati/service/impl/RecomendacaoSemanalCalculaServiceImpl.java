package com.ricardococati.service.impl;

import static com.ricardococati.model.enums.Decisao.COMPRA;
import static com.ricardococati.model.enums.Decisao.NEUTRO;
import static com.ricardococati.model.enums.Decisao.VENDE;

import com.ricardococati.model.dto.RecomendacaoSemanal;
import com.ricardococati.repository.dao.HistogramaSemanalDAO;
import com.ricardococati.repository.dao.MacdSemanalDAO;
import com.ricardococati.repository.dao.MediaMovelExponencialSemanalDAO;
import com.ricardococati.repository.dao.RecomendacaoSemanalBuscarDAO;
import com.ricardococati.repository.dao.RecomendacaoSemanalInserirDAO;
import com.ricardococati.repository.dao.SinalMacdSemanalDAO;
import com.ricardococati.service.CalculaService;
import com.ricardococati.service.CandlestickSemanalBuscarService;
import com.ricardococati.service.RecomendacaoSemanalCalculaService;
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
public class RecomendacaoSemanalCalculaServiceImpl
    implements RecomendacaoSemanalCalculaService {

  private final CandlestickSemanalBuscarService calculaCandlestickService;
  private final MacdSemanalDAO macdDAO;
  private final SinalMacdSemanalDAO sinalMacdDAO;
  private final HistogramaSemanalDAO histogramaDAO;
  private final RecomendacaoSemanalBuscarDAO buscarRecomendacao;
  private final RecomendacaoSemanalInserirDAO inserirRecomendacao;
  private final MediaMovelExponencialSemanalDAO mediaMovelExponencialDAO;
  private final CalculaService calculaService;

  @Override
  public List<RecomendacaoSemanal> executeByCodNeg(
      final List<String> listCodneg, final LocalDate dtLimitePregao) {
    List<RecomendacaoSemanal> diarioList = new ArrayList<>();
    log.info("Código de negociação: " + listCodneg);
    listCodneg
        .stream()
        .filter(Objects::nonNull)
        .forEach(codneg -> {
          diarioList.addAll(calculaRecomendacao(codneg, dtLimitePregao));
          inserirRecomendacao.incluirRecomendacao(diarioList);
        });
    return diarioList;
  }

  private List<RecomendacaoSemanal> calculaRecomendacao(
      final String codneg, final LocalDate dtLimitePregao) {
    List<RecomendacaoSemanal> recomendacaoList = buildListRecomendacao(
        codneg,
        dtLimitePregao
    );
    for (int indice = 0; indice < recomendacaoList.size(); indice++) {
      if (indice > 0 && recomendacaoList.size() >= 2) {
        if (recomendacaoList.get(indice - 1).getRecomendacao().getPrecoHistograma()
            .compareTo(recomendacaoList.get(indice).getRecomendacao().getPrecoHistograma()) < 0) {
          recomendacaoList.get(indice).getRecomendacao().setDecisao(COMPRA.getTexto());
        } else if (recomendacaoList.get(indice - 1).getRecomendacao().getPrecoHistograma()
            .compareTo(recomendacaoList.get(indice).getRecomendacao().getPrecoHistograma()) > 0) {
          recomendacaoList.get(indice).getRecomendacao().setDecisao(VENDE.getTexto());
        } else {
          recomendacaoList.get(indice).getRecomendacao().setDecisao(NEUTRO.getTexto());
        }
      }
    }
    return recomendacaoList;
  }

  private List<RecomendacaoSemanal> buildListRecomendacao(
      final String codneg,
      final LocalDate dtLimitePregao
  ) {
    return buscarRecomendacao.getListRecomendacaoByDtPregECodNeg(
        dtLimitePregao,
        codneg
    );
  }

}
