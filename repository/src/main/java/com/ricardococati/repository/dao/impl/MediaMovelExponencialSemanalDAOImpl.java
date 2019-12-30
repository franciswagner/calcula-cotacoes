package com.ricardococati.repository.dao.impl;

import com.ricardococati.model.dto.MediaMovelExponencialSemanal;
import com.ricardococati.repository.dao.GenericDAO;
import com.ricardococati.repository.dao.MediaMovelExponencialSemanalDAO;
import com.ricardococati.repository.dao.mapper.CandlestickSemanalMapper;
import com.ricardococati.repository.dao.mapper.MediaMovelExponencialSemanalMapper;
import com.ricardococati.repository.dao.sqlutil.MediaMovelExponencialSemanalSQLUtil;
import com.ricardococati.repository.util.SQLAppender;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MediaMovelExponencialSemanalDAOImpl implements MediaMovelExponencialSemanalDAO {

  @Qualifier("namedParameterJdbcTemplate")
  private final NamedParameterJdbcTemplate template;

  private final GenericDAO genericDAO;
  private final MediaMovelExponencialSemanalSQLUtil sqlUtil;
  private final CandlestickSemanalMapper mapper;
  private final MediaMovelExponencialSemanalMapper mediaMapper;

  @Override
  public Boolean incluirMediaMovelExponencial(final List<MediaMovelExponencialSemanal> mediaMovelExponencialList) {
    AtomicInteger retorno = new AtomicInteger(0);
    final SQLAppender sql = new SQLAppender(100);
    try {
      mediaMovelExponencialList
          .stream()
          .forEach(mediaMovelSimples -> {
            mediaMovelSimples.setIdMediaMovelExponencialSemanal(
                genericDAO.getSequence("MEDIA_MOVEL_EXPONENCIAL_SEMANAL_SEQ", template).longValue()
            );
            retorno.addAndGet(template.update(sqlUtil.getInsert(), sqlUtil.toParameters(mediaMovelSimples)));
          });
    } catch (Exception ex) {
      log.error("Erro na execução do método: " + ex.getMessage());
      throw ex;
    }
    return retorno.get() > 0;
  }

  @Override
  public Boolean deleteAllMME() {
    return template.update(sqlUtil.getDelete(), new MapSqlParameterSource()) == 0;
  }

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

  @Override
  public List<MediaMovelExponencialSemanal> listMediaExponencialByCodneg(final String codneg) {
    return template.query(
        sqlUtil.getSelect(),
        new MapSqlParameterSource(),
        (rs, rowNum) -> mediaMapper.mapperSemanal(rs)
    );
  }

}
