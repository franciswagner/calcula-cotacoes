package com.ricardococati.repository.dao.impl;

import com.ricardococati.model.dto.CandlestickDiarioDTO;
import com.ricardococati.repository.dao.GenericDAO;
import com.ricardococati.repository.dao.IncluirCandlestickDiarioDAO;
import com.ricardococati.repository.dao.sqlutil.IncluirCandlestickDiarioSQLUtil;
import com.ricardococati.repository.util.SQLAppender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class IncluirCandlestickDiarioDAOImpl implements IncluirCandlestickDiarioDAO {

  @Qualifier("namedParameterJdbcTemplate")
  private final NamedParameterJdbcTemplate template;

  private final GenericDAO genericDAO;
  private final IncluirCandlestickDiarioSQLUtil sqlUtil;

  @Override
  public Boolean incluirCandlestickDiario(final CandlestickDiarioDTO candlestickDiarioDTO) {
    int retorno = 0;
    final SQLAppender sql = new SQLAppender(100);
    try {
      candlestickDiarioDTO.setIdCandleDiario(
          genericDAO.getSequence("CANDLESTICK_SEQ", template).longValue()
      );
      retorno = template.update(sqlUtil.getInsert(), sqlUtil.toParameters(candlestickDiarioDTO));
    } catch (Exception ex) {
      log.error("Erro na execução do método CANDLESTICK_DIARIO: " + ex.getMessage());
      throw ex;
    }
    return retorno > 0;
  }

}