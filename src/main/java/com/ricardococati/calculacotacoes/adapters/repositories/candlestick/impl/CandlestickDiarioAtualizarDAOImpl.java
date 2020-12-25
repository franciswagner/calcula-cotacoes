package com.ricardococati.calculacotacoes.adapters.repositories.candlestick.impl;

import com.ricardococati.calculacotacoes.adapters.repositories.candlestick.CandlestickDiarioAtualizarDAO;
import com.ricardococati.calculacotacoes.adapters.repositories.candlestick.sqlutil.CandlestickDiarioAtualizarSQLUtil;
import com.ricardococati.calculacotacoes.entities.domains.split.SplitInplit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CandlestickDiarioAtualizarDAOImpl implements CandlestickDiarioAtualizarDAO {

  @Qualifier("namedParameterJdbcTemplate")
  private final NamedParameterJdbcTemplate template;

  private final CandlestickDiarioAtualizarSQLUtil sqlUtil;

  @Override
  public Boolean atualizaSplitInplit(final SplitInplit splitInplit) {
    int retorno = 0;
    try {
      retorno = template.update(
          sqlUtil.getUpdateSplitInplit(splitInplit.getOperacao().getTipoOperacao()),
          sqlUtil.toParametersUpdateSplitInplit(splitInplit)
      );
    } catch (Exception ex) {
      log.error("Erro na execução do método split: " + ex.getMessage());
      throw ex;
    }
    return retorno > 0;
  }

}