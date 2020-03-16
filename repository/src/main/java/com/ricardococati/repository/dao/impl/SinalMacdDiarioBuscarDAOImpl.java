package com.ricardococati.repository.dao.impl;

import com.ricardococati.model.entities.SinalMacdDiario;
import com.ricardococati.repository.dao.SinalMacdDiarioBuscarDAO;
import com.ricardococati.repository.dao.mapper.SinalMacdDiarioMapper;
import com.ricardococati.repository.dao.sqlutil.SinalMacdDiarioSQLUtil;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class SinalMacdDiarioBuscarDAOImpl implements SinalMacdDiarioBuscarDAO {

  @Qualifier("namedParameterJdbcTemplate")
  private final NamedParameterJdbcTemplate template;

  private final SinalMacdDiarioSQLUtil sqlUtil;
  private final SinalMacdDiarioMapper mapper;

  @Override
  public List<SinalMacdDiario> listSinalMacdByCodNeg(String codneg) {
    return template.query(
        sqlUtil.getSelectByCodNeg(),
        sqlUtil.toParametersByCodNeg(codneg),
        (rs, rowNum) -> mapper.mapper(rs)
    );
  }
}
