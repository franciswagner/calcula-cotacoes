package com.ricardococati.repository.dao.impl;

import com.ricardococati.model.dto.CandlestickDiarioDTO;
import com.ricardococati.repository.dao.InserirCandlestickDiarioDAO;
import com.ricardococati.repository.dao.sqlutil.InserirCandlestickDiarioSQLUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class InserirCandlestickDiarioDAOImpl implements InserirCandlestickDiarioDAO {

  @Qualifier("namedParameterJdbcTemplate")
  private final NamedParameterJdbcTemplate template;

  private final GenericDAOImpl genericDAO;
  private final InserirCandlestickDiarioSQLUtil sqlUtil;

  @Override
  public Boolean insereCandlestickDiario(final CandlestickDiarioDTO candlestickDiarioDTO) {
    int retorno = 0;
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