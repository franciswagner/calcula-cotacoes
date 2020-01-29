package com.ricardococati.service.impl;

import static com.ricardococati.model.enums.Decisao.COMPRA;
import static com.ricardococati.model.enums.Decisao.NEUTRO;
import static com.ricardococati.model.enums.Decisao.VENDE;

import com.ricardococati.model.dto.RecomendacaoDiario;
import com.ricardococati.repository.dao.HistogramaDiarioInserirDAO;
import com.ricardococati.repository.dao.MacdDiarioBuscarDAO;
import com.ricardococati.repository.dao.MediaMovelExponencialDiarioDAO;
import com.ricardococati.repository.dao.RecomendacaoDiarioBuscarDAO;
import com.ricardococati.repository.dao.RecomendacaoDiarioExcluirDAO;
import com.ricardococati.repository.dao.RecomendacaoDiarioInserirDAO;
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
  private final MacdDiarioBuscarDAO macdDAO;
  private final SinalMacdDiarioDAO sinalMacdDAO;
  private final HistogramaDiarioInserirDAO histogramaDAO;
  private final RecomendacaoDiarioBuscarDAO buscarRecomendacao;
  private final RecomendacaoDiarioInserirDAO incluirRecomendacao;
  private final RecomendacaoDiarioExcluirDAO excluirRecomendacao;
  private final MediaMovelExponencialDiarioDAO mediaMovelExponencialDAO;
  private final CalculaService calculaService;

  @Override
  public List<RecomendacaoDiario> executeByCodNeg(
      final List<String> listCodneg, final LocalDate dtLimitePregao) {
    excluirRecomendacao.excluirAllRecomendacao();
    List<RecomendacaoDiario> diarioList =  new ArrayList<>();
    log.info("Código de negociação: " + listCodneg);
    listCodneg
        .stream()
        .filter(Objects::nonNull)
        .forEach(codneg -> {
          diarioList.addAll(calculaRecomendacao(codneg, dtLimitePregao));
          incluirRecomendacao.incluirRecomendacao(diarioList);
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
          recomendacaoList.get(indice).getRecomendacao().setDecisao(COMPRA.getTexto());
        } else if(recomendacaoList.get(indice-1).getRecomendacao().getPrecoHistograma()
            .compareTo(recomendacaoList.get(indice).getRecomendacao().getPrecoHistograma()) > 0){
          recomendacaoList.get(indice).getRecomendacao().setDecisao(VENDE.getTexto());
        } else {
          recomendacaoList.get(indice).getRecomendacao().setDecisao(NEUTRO.getTexto());
        }
      }
    }
    return recomendacaoList;
  }

  private List<RecomendacaoDiario> buildListRecomendacao(final String codneg, final LocalDate dtLimitePregao) {
    return buscarRecomendacao.getListRecomendacaoByDtPregECodNeg(
        dtLimitePregao,
        codneg
    );
  }

}
