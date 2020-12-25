package com.ricardococati.calculacotacoes.adapters.repositories.mediaexponencial.impl;

import com.ricardococati.calculacotacoes.adapters.repositories.mediaexponencial.MediaMovelExponencialDiarioBuscarDAO;
import com.ricardococati.calculacotacoes.adapters.repositories.mediaexponencial.mapper.MediaMovelExponencialDiarioMapper;
import com.ricardococati.calculacotacoes.adapters.repositories.mediaexponencial.sqlutil.MediaMovelExponencialDiarioSQLUtil;
import com.ricardococati.calculacotacoes.entities.domains.mediaexponencial.MediaMovelExponencialDiario;
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
