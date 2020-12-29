package com.ricardococati.calculacotacoes.usecases.recomendacao.impl;

import static com.ricardococati.calculacotacoes.entities.enums.Decisao.CONSOLIDANDO;
import static com.ricardococati.calculacotacoes.entities.enums.Decisao.TENDENCIA_ALTA;
import static com.ricardococati.calculacotacoes.entities.enums.Decisao.TENDENCIA_BAIXA;
import static java.util.Objects.nonNull;

import com.ricardococati.calculacotacoes.adapters.repositories.histograma.HistogramaDiarioInserirDAO;
import com.ricardococati.calculacotacoes.adapters.repositories.macd.MacdDiarioBuscarDAO;
import com.ricardococati.calculacotacoes.adapters.repositories.mediaexponencial.MediaMovelExponencialDiarioBuscarDAO;
import com.ricardococati.calculacotacoes.adapters.repositories.recomendacao.RecomendacaoDiarioBuscarDAO;
import com.ricardococati.calculacotacoes.adapters.repositories.recomendacao.RecomendacaoDiarioExcluirDAO;
import com.ricardococati.calculacotacoes.adapters.repositories.recomendacao.RecomendacaoDiarioInserirDAO;
import com.ricardococati.calculacotacoes.adapters.repositories.sinalmacd.SinalMacdDiarioBuscarDAO;
import com.ricardococati.calculacotacoes.entities.domains.recomendacao.RecomendacaoDiario;
import com.ricardococati.calculacotacoes.usecases.calculageral.CalculaService;
import com.ricardococati.calculacotacoes.usecases.candlestick.CandlestickDiarioBuscarService;
import com.ricardococati.calculacotacoes.usecases.recomendacao.RecomendacaoDiarioCalculaService;
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
