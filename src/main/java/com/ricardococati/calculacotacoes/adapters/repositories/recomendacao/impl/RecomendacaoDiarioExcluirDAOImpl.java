package com.ricardococati.calculacotacoes.adapters.repositories.recomendacao.impl;

import com.ricardococati.calculacotacoes.adapters.repositories.recomendacao.RecomendacaoDiarioExcluirDAO;
import com.ricardococati.calculacotacoes.adapters.repositories.recomendacao.sqlutil.RecomendacaoDiarioExcluirSQLUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class RecomendacaoDiarioExcluirDAOImpl implements RecomendacaoDiarioExcluirDAO {

  @Qualifier("namedParameterJdbcTemplate")
  private final NamedParameterJdbcTemplate template;

  private final RecomendacaoDiarioExcluirSQLUtil sqlUtil;

  @Override
  public Boolean excluirAllRecomendacao() {
    return template.update(sqlUtil.getDelete(), new MapSqlParameterSource()) == 0;
  }

}
