package com.ricardococati.calculacotacoes.adapters.repositories.sinalmacd.impl;

import com.ricardococati.calculacotacoes.adapters.repositories.sinalmacd.SinalMacdSemanalBuscarDAO;
import com.ricardococati.calculacotacoes.adapters.repositories.sinalmacd.mapper.SinalMacdSemanalMapper;
import com.ricardococati.calculacotacoes.adapters.repositories.sinalmacd.sqlutil.SinalMacdSemanalSQLUtil;
import com.ricardococati.calculacotacoes.entities.domains.sinalmacd.SinalMacdSemanal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class SinalMacdSemanalBuscarDAOImpl implements SinalMacdSemanalBuscarDAO {

  @Qualifier("namedParameterJdbcTemplate")
  private final NamedParameterJdbcTemplate template;

  private final SinalMacdSemanalSQLUtil sqlUtil;
  private final SinalMacdSemanalMapper mapper;

  @Override
  public List<SinalMacdSemanal> listSinalMacdByCodNeg(String codneg) {
    return template.query(
        sqlUtil.getSelectByCodNeg(),
        sqlUtil.toParametersByCodNeg(codneg),
        (rs, rowNum) -> mapper.mapper(rs)
    );
  }
}
