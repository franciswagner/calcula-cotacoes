package com.ricardococati.repository.dao.impl;

import com.ricardococati.model.dto.MediaMovelSimplesSemanal;
import com.ricardococati.repository.dao.GenericDAO;
import com.ricardococati.repository.dao.MediaMovelSimplesSemanalDAO;
import com.ricardococati.repository.dao.mapper.MediaMovelSimplesSemanalMapper;
import com.ricardococati.repository.dao.sqlutil.MediaMovelSimplesSemanalSQLUtil;
import com.ricardococati.repository.util.SQLAppender;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MediaMovelSimplesSemanalDAOImpl implements MediaMovelSimplesSemanalDAO {

  @Qualifier("namedParameterJdbcTemplate")
  private final NamedParameterJdbcTemplate template;

  private final GenericDAO genericDAO;
  private final MediaMovelSimplesSemanalSQLUtil sqlUtil;
  private final MediaMovelSimplesSemanalMapper mediaMapper;

  @Override
  public Boolean incluirMediaMovelSimples(final List<MediaMovelSimplesSemanal> mediaMovelSimplesList) {
    AtomicInteger retorno = new AtomicInteger(0);
    final SQLAppender sql = new SQLAppender(100);
    try {
      mediaMovelSimplesList
          .stream()
          .forEach(mediaMovelSimples -> {
            mediaMovelSimples.setIdMediaMovelSimplesSemanal(
                genericDAO.getSequence("MEDIA_MOVEL_SIMPLES_SEMANAL_SEQ", template).longValue()
            );
            retorno.addAndGet(template.update(sqlUtil.getInsert(), sqlUtil.toParameters(mediaMovelSimples)));
          });
    } catch (Exception ex) {
      log.error("Erro na execução do método CANDLESTICK_DIARIO: " + ex.getMessage());
      throw ex;
    }
    return retorno.get() > 0;
  }

  @Override
  public MediaMovelSimplesSemanal buscaMediaSimplesPorCodNegPeriodoDtPreg(
      final String codneg,
      final Integer periodo,
      final LocalDate dtpregini,
      final LocalDate dtpregfim
  ) {
    try {
      return template.queryForObject(
          sqlUtil.getSelectByCodNegPeriodoDtPreg(),
          sqlUtil.toParametersSelectByCodNegPeriodoDtPreg(codneg, periodo, dtpregini, dtpregfim),
          (rs, rowNum) -> mediaMapper.mapper(rs)
      );
    } catch (EmptyResultDataAccessException exc){
      log.error("Não foi possível encontrar a média simples {} com os parâmetros: {} {} {} {} ",
          exc.getMessage(),
          codneg,
          periodo,
          dtpregini,
          dtpregfim);
      return null;
    }
  }

  @Override
  public Boolean deleteAllMM() {
    return template.update(sqlUtil.getDelete(), new MapSqlParameterSource()) == 0;
  }

}
