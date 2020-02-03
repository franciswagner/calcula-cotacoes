package com.ricardococati.repository.dao.impl;

import com.ricardococati.model.dto.MediaMovelExponencialSemanal;
import com.ricardococati.repository.dao.MediaMovelExponencialSemanalBuscarDAO;
import com.ricardococati.repository.dao.mapper.MediaMovelExponencialSemanalMapper;
import com.ricardococati.repository.dao.sqlutil.MediaMovelExponencialSemanalSQLUtil;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MediaMovelExponencialSemanalBuscarDAOImpl implements
    MediaMovelExponencialSemanalBuscarDAO {

  @Qualifier("namedParameterJdbcTemplate")
  private final NamedParameterJdbcTemplate template;

  private final MediaMovelExponencialSemanalSQLUtil sqlUtil;
  private final MediaMovelExponencialSemanalMapper mediaMapper;

  @Override
  public List<MediaMovelExponencialSemanal> getListMMEByCodNegEPeriodo(
      String codneg,
      Integer periodo
  ) {
    return template.query(
        sqlUtil.getSelectByCodNegEPeriodo(),
        sqlUtil.toParametersByCodNegEPeriodo(codneg, periodo),
        (rs, rowNum) -> mediaMapper.mapperSemanal(rs)
    );
  }

}
