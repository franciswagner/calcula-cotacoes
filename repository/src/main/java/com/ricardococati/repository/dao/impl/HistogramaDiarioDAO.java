package com.ricardococati.repository.dao.impl;

import com.ricardococati.model.dto.HistogramaDiario;
import com.ricardococati.repository.dao.GenericDAO;
import com.ricardococati.repository.dao.IHistogramaDiarioDAO;
import com.ricardococati.repository.dao.mapper.HistogramaDiarioMapper;
import com.ricardococati.repository.dao.sqlutil.HistogramaDiarioSQLUtil;
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
public class HistogramaDiarioDAO implements IHistogramaDiarioDAO {

  @Qualifier("namedParameterJdbcTemplate")
  private final NamedParameterJdbcTemplate template;

  private final GenericDAO genericDAO;
  private final HistogramaDiarioSQLUtil sqlUtil;
  private final HistogramaDiarioMapper mapper;

  @Override
  public Boolean incluirHistograma(List<HistogramaDiario> macdList) {
    AtomicInteger retorno = new AtomicInteger(0);
    final SQLAppender sql = new SQLAppender(100);
    try {
      macdList
          .stream()
          .forEach(histograma -> {
            histograma.setIdHistogramaDiario(
                genericDAO.getSequence("HISTOGRAMA_DIARIO_SEQ", template).longValue()
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
  public List<HistogramaDiario> listHistogramaByCodNeg(String codneg) {
    return template.query(
        sqlUtil.getSelectByCodNeg(),
        sqlUtil.toParametersByCodNeg(codneg),
        (rs, rowNum) -> mapper.mapper(rs)
    );
  }
}
