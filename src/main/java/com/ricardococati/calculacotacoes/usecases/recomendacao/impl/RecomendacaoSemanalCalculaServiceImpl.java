package com.ricardococati.calculacotacoes.usecases.recomendacao.impl;

import static com.ricardococati.calculacotacoes.entities.enums.Decisao.CONSOLIDANDO;
import static com.ricardococati.calculacotacoes.entities.enums.Decisao.TENDENCIA_ALTA;
import static com.ricardococati.calculacotacoes.entities.enums.Decisao.TENDENCIA_BAIXA;
import static java.util.Objects.nonNull;

import com.ricardococati.calculacotacoes.adapters.repositories.histograma.HistogramaSemanalInserirDAO;
import com.ricardococati.calculacotacoes.adapters.repositories.macd.MacdSemanalBuscarDAO;
import com.ricardococati.calculacotacoes.adapters.repositories.mediaexponencial.MediaMovelExponencialSemanalBuscarDAO;
import com.ricardococati.calculacotacoes.adapters.repositories.recomendacao.RecomendacaoSemanalBuscarDAO;
import com.ricardococati.calculacotacoes.adapters.repositories.recomendacao.RecomendacaoSemanalExcluirDAO;
import com.ricardococati.calculacotacoes.adapters.repositories.recomendacao.RecomendacaoSemanalInserirDAO;
import com.ricardococati.calculacotacoes.adapters.repositories.sinalmacd.SinalMacdSemanalBuscarDAO;
import com.ricardococati.calculacotacoes.entities.domains.recomendacao.RecomendacaoSemanal;
import com.ricardococati.calculacotacoes.usecases.calculageral.CalculaService;
import com.ricardococati.calculacotacoes.usecases.candlestick.CandlestickSemanalBuscarService;
import com.ricardococati.calculacotacoes.usecases.recomendacao.RecomendacaoSemanalCalculaService;
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
public class RecomendacaoSemanalCalculaServiceImpl
    implements RecomendacaoSemanalCalculaService {

  private final CandlestickSemanalBuscarService calculaCandlestickService;
  private final MacdSemanalBuscarDAO macdDAO;
  private final SinalMacdSemanalBuscarDAO sinalMacdDAO;
  private final HistogramaSemanalInserirDAO histogramaDAO;
  private final RecomendacaoSemanalBuscarDAO buscarRecomendacao;
  private final RecomendacaoSemanalInserirDAO inserirRecomendacao;
  private final RecomendacaoSemanalExcluirDAO excluirRecomendacao;
  private final MediaMovelExponencialSemanalBuscarDAO mediaMovelExponencialDAO;
  private final CalculaService calculaService;

  @Override
  public List<RecomendacaoSemanal> executeByCodNeg(
      final List<String> listCodneg, final LocalDate dtLimitePregao) {
    excluirRecomendacao.excluirAllRecomendacao();
    List<RecomendacaoSemanal> diarioList = new ArrayList<>();
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

  private void incluirRecomendacao(final List<RecomendacaoSemanal> semanalList) {
    semanalList
        .stream()
        .filter(Objects::nonNull)
        .filter(mmsSemanal -> nonNull(mmsSemanal.getDtpregini()))
        .filter(mmsSemanal -> nonNull(mmsSemanal.getDtpregfim()))
        .filter(mmsSemanal -> nonNull(mmsSemanal.getRecomendacao()))
        .filter(mmsSemanal -> nonNull(mmsSemanal.getRecomendacao().getCodneg()))
        .forEach(inserirRecomendacao::incluirRecomendacao);
  }

  private List<RecomendacaoSemanal> calculaRecomendacao(
      final String codneg, final LocalDate dtLimitePregao) {
    List<RecomendacaoSemanal> recomendacaoList = buildListRecomendacao(
        codneg,
        dtLimitePregao
    );
    IntStream.range(0, recomendacaoList.size())
        .filter(indice -> indice > 0 && recomendacaoList.size() >= 2)
        .forEach(indice -> {
          if (recomendacaoList.get(indice - 1).getRecomendacao().getPrecoHistograma()
              .compareTo(recomendacaoList.get(indice).getRecomendacao().getPrecoHistograma()) < 0) {
            recomendacaoList.get(indice).getRecomendacao().setDecisao(TENDENCIA_ALTA.getTexto());
          } else if (recomendacaoList.get(indice - 1).getRecomendacao().getPrecoHistograma()
              .compareTo(recomendacaoList.get(indice).getRecomendacao().getPrecoHistograma()) > 0) {
            recomendacaoList.get(indice).getRecomendacao().setDecisao(TENDENCIA_BAIXA.getTexto());
          } else {
            recomendacaoList.get(indice).getRecomendacao().setDecisao(CONSOLIDANDO.getTexto());
          }
        });
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
