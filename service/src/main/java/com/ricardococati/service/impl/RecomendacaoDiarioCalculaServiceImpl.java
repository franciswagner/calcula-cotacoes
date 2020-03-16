package com.ricardococati.service.impl;

import static com.ricardococati.model.enums.Decisao.COMPRA;
import static com.ricardococati.model.enums.Decisao.NEUTRO;
import static com.ricardococati.model.enums.Decisao.VENDE;
import static java.util.Objects.nonNull;

import com.ricardococati.model.entities.RecomendacaoDiario;
import com.ricardococati.repository.dao.HistogramaDiarioInserirDAO;
import com.ricardococati.repository.dao.MacdDiarioBuscarDAO;
import com.ricardococati.repository.dao.MediaMovelExponencialDiarioBuscarDAO;
import com.ricardococati.repository.dao.RecomendacaoDiarioBuscarDAO;
import com.ricardococati.repository.dao.RecomendacaoDiarioExcluirDAO;
import com.ricardococati.repository.dao.RecomendacaoDiarioInserirDAO;
import com.ricardococati.repository.dao.SinalMacdDiarioBuscarDAO;
import com.ricardococati.service.CalculaService;
import com.ricardococati.service.CandlestickDiarioBuscarService;
import com.ricardococati.service.RecomendacaoDiarioCalculaService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;
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
  private final SinalMacdDiarioBuscarDAO sinalMacdDAO;
  private final HistogramaDiarioInserirDAO histogramaDAO;
  private final RecomendacaoDiarioBuscarDAO buscarRecomendacao;
  private final RecomendacaoDiarioInserirDAO inserirRecomendacao;
  private final RecomendacaoDiarioExcluirDAO excluirRecomendacao;
  private final MediaMovelExponencialDiarioBuscarDAO mediaMovelExponencialDAO;
  private final CalculaService calculaService;

  @Override
  public List<RecomendacaoDiario> executeByCodNeg(
      final List<String> listCodneg, final LocalDate dtLimitePregao) {
    excluirRecomendacao.excluirAllRecomendacao();
    List<RecomendacaoDiario> diarioList = new ArrayList<>();
    log.info("Código de negociação: " + listCodneg);
    listCodneg
        .parallelStream()
        .filter(Objects::nonNull)
        .forEachOrdered(codneg -> {
          diarioList.addAll(calculaRecomendacao(codneg, dtLimitePregao));
          incluirRecomendacao(diarioList);
        });
    return diarioList;
  }

  private void incluirRecomendacao(List<RecomendacaoDiario> diarioList) {
    diarioList
        .stream()
        .filter(Objects::nonNull)
        .filter(mmsSemanal -> nonNull(mmsSemanal.getDtpreg()))
        .filter(mmsSemanal -> nonNull(mmsSemanal.getRecomendacao()))
        .filter(mmsSemanal -> nonNull(mmsSemanal.getRecomendacao().getCodneg()))
        .forEach(inserirRecomendacao::incluirRecomendacao);
  }

  private List<RecomendacaoDiario> calculaRecomendacao(
      final String codneg, final LocalDate dtLimitePregao) {
    List<RecomendacaoDiario> recomendacaoList = buildListRecomendacao(
        codneg,
        dtLimitePregao
    );
    IntStream.range(0, recomendacaoList.size())
        .filter(indice -> indice > 0 && recomendacaoList.size() >= 2)
        .forEach(indice -> {
          if (recomendacaoList.get(indice - 1).getRecomendacao().getPrecoHistograma()
              .compareTo(recomendacaoList.get(indice).getRecomendacao().getPrecoHistograma()) < 0) {
            recomendacaoList.get(indice).getRecomendacao().setDecisao(COMPRA.getTexto());
          } else if (recomendacaoList.get(indice - 1).getRecomendacao().getPrecoHistograma()
              .compareTo(recomendacaoList.get(indice).getRecomendacao().getPrecoHistograma()) > 0) {
            recomendacaoList.get(indice).getRecomendacao().setDecisao(VENDE.getTexto());
          } else {
            recomendacaoList.get(indice).getRecomendacao().setDecisao(NEUTRO.getTexto());
          }
        });
    return recomendacaoList;
  }

  private List<RecomendacaoDiario> buildListRecomendacao(
      final String codneg,
      final LocalDate dtLimitePregao
  ) {
    return buscarRecomendacao.getListRecomendacaoByDtPregECodNeg(
        dtLimitePregao,
        codneg
    );
  }

}
