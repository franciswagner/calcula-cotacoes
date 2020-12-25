package com.ricardococati.calculacotacoes.adapters.repositories.recomendacao.impl;

import com.ricardococati.calculacotacoes.adapters.repositories.recomendacao.RecomendacaoDiarioBuscarDAO;
import com.ricardococati.calculacotacoes.adapters.repositories.recomendacao.mapper.RecomendacaoDiarioMapper;
import com.ricardococati.calculacotacoes.adapters.repositories.recomendacao.sqlutil.RecomendacaoDiarioBuscarSQLUtil;
import com.ricardococati.calculacotacoes.entities.domains.recomendacao.RecomendacaoDiario;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class RecomendacaoDiarioBuscarDAOImpl implements RecomendacaoDiarioBuscarDAO {

  @Qualifier("namedParameterJdbcTemplate")
  private final NamedParameterJdbcTemplate template;

  private final RecomendacaoDiarioBuscarSQLUtil sqlUtil;
  private final RecomendacaoDiarioMapper mapper;

  @Override
  public List<RecomendacaoDiario> getListRecomendacaoByDtPregECodNeg(
      final LocalDate dtLimitePregao,
      final String codneg
  ) {
    return template.query(
        sqlUtil.getSelectByCodNegDtPreg(),
        sqlUtil.toParametersCodNegDtPreg(codneg,dtLimitePregao),
        (rs, rowNum) -> mapper.mapperConsult(rs)
    );
  }
}
