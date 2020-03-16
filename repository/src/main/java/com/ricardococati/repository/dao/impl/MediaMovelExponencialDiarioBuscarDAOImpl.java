package com.ricardococati.repository.dao.impl;

import com.ricardococati.model.entities.MediaMovelExponencialDiario;
import com.ricardococati.repository.dao.MediaMovelExponencialDiarioBuscarDAO;
import com.ricardococati.repository.dao.mapper.MediaMovelExponencialDiarioMapper;
import com.ricardococati.repository.dao.sqlutil.MediaMovelExponencialDiarioSQLUtil;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MediaMovelExponencialDiarioBuscarDAOImpl implements
    MediaMovelExponencialDiarioBuscarDAO {

  @Qualifier("namedParameterJdbcTemplate")
  private final NamedParameterJdbcTemplate template;

  private final MediaMovelExponencialDiarioSQLUtil sqlUtil;
  private final MediaMovelExponencialDiarioMapper mediaMapper;

  @Override
  public List<MediaMovelExponencialDiario> getListMMEByCodNegEPeriodo(
      final String codneg,
      final Integer periodo
  ) {
    return template.query(
        sqlUtil.getSelectByCodNegEPeriodo(),
        sqlUtil.toParametersByCodNegEPeriodo(codneg, periodo),
        (rs, rowNum) -> mediaMapper.mapper(rs)
    );
  }

}
