package com.ricardococati.repository.dao.impl;

import com.ricardococati.model.dto.HistogramaSemanal;
import com.ricardococati.repository.dao.HistogramaSemanalDAO;
import com.ricardococati.repository.dao.mapper.HistogramaSemanalMapper;
import com.ricardococati.repository.dao.sqlutil.HistogramaSemanalSQLUtil;
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
public class HistogramaSemanalDAOImpl implements HistogramaSemanalDAO {

  @Qualifier("namedParameterJdbcTemplate")
  private final NamedParameterJdbcTemplate template;

  private final GenericDAOImpl genericDAO;
  private final HistogramaSemanalSQLUtil sqlUtil;
  private final HistogramaSemanalMapper mapper;

  @Override
  public Boolean incluirHistograma(List<HistogramaSemanal> macdList) {
    AtomicInteger retorno = new AtomicInteger(0);
    final SQLAppender sql = new SQLAppender(100);
    try {
      macdList
          .stream()
          .forEach(histograma -> {
            histograma.setIdHistogramaSemanal(
                genericDAO.getSequence("HISTOGRAMA_SEMANAL_SEQ").longValue()
            );
            retorno.addAndGet(template.update(sqlUtil.getInsert(), sqlUtil.toParameters(histograma)));
          });
    } catch (Exception ex) {
      log.error("Erro na execução do método incluir MACD: " + ex.getMessage());
      throw ex;
    }
    return retorno.get() > 0;
  }

  @Override
  public Boolean deleteAllHistograma() {
    return template.update(sqlUtil.getDelete(), new MapSqlParameterSource()) == 0;
  }

  @Override
  public List<HistogramaSemanal> listHistogramaByCodNeg(String codneg) {
    return template.query(
        sqlUtil.getSelectByCodNeg(),
        sqlUtil.toParametersByCodNeg(codneg),
        (rs, rowNum) -> mapper.mapper(rs)
    );
  }
}
