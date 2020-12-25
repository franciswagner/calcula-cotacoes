package com.ricardococati.calculacotacoes.adapters.repositories.recomendacao.impl;

import com.ricardococati.calculacotacoes.adapters.repositories.recomendacao.RecomendacaoSemanalBuscarDAO;
import com.ricardococati.calculacotacoes.adapters.repositories.recomendacao.mapper.RecomendacaoSemanalMapper;
import com.ricardococati.calculacotacoes.adapters.repositories.recomendacao.sqlutil.RecomendacaoSemanalBuscarSQLUtil;
import com.ricardococati.calculacotacoes.entities.domains.recomendacao.RecomendacaoSemanal;
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
public class RecomendacaoSemanalBuscarDAOImpl implements RecomendacaoSemanalBuscarDAO {

  @Qualifier("namedParameterJdbcTemplate")
  private final NamedParameterJdbcTemplate template;

  private final RecomendacaoSemanalBuscarSQLUtil sqlUtil;
  private final RecomendacaoSemanalMapper mapper;

  @Override
  public List<RecomendacaoSemanal> getListRecomendacaoByDtPregECodNeg(
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
