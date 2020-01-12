package com.ricardococati.repository.dao.impl;

import com.ricardococati.model.dto.CandlestickSemanalDTO;
import com.ricardococati.repository.dao.InserirCandlestickSemanalDAO;
import com.ricardococati.repository.dao.sqlutil.InserirCandlestickSemanalSQLUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class InserirCandlestickSemanalDAOImpl implements InserirCandlestickSemanalDAO {

  @Qualifier("namedParameterJdbcTemplate")
  private final NamedParameterJdbcTemplate template;

  private final GenericDAOImpl genericDAO;
  private final InserirCandlestickSemanalSQLUtil sqlUtil;

  @Override
  public Boolean incluirCandlestickSemanal(CandlestickSemanalDTO semanal) {
    int retorno = 0;
    try {
      semanal.setIdCandleSemanal(
          genericDAO.getSequence("CANDLESTICK_SEMANAL_SEQ", template).longValue()
      );
      retorno = template.update(sqlUtil.getInsert(), sqlUtil.toParameters(semanal));
    } catch (Exception ex) {
      log.error("Erro na execução do método CANDLESTICK_DIARIO: " + ex.getMessage());
      throw ex;
    }
    return retorno > 0;
  }

}
