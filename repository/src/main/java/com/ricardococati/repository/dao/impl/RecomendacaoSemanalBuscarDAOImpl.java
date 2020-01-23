package com.ricardococati.repository.dao.impl;

import com.ricardococati.model.dto.RecomendacaoSemanal;
import com.ricardococati.repository.dao.RecomendacaoSemanalBuscarDAO;
import com.ricardococati.repository.dao.mapper.RecomendacaoSemanalMapper;
import com.ricardococati.repository.dao.sqlutil.RecomendacaoSemanalBuscarSQLUtil;
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
