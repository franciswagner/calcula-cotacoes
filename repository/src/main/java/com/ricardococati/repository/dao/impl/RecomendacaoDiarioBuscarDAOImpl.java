package com.ricardococati.repository.dao.impl;

import com.ricardococati.model.entities.RecomendacaoDiario;
import com.ricardococati.repository.dao.RecomendacaoDiarioBuscarDAO;
import com.ricardococati.repository.dao.mapper.RecomendacaoDiarioMapper;
import com.ricardococati.repository.dao.sqlutil.RecomendacaoDiarioBuscarSQLUtil;
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
