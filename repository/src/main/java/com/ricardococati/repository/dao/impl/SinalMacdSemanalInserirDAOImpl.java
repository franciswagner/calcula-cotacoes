package com.ricardococati.repository.dao.impl;

import static java.util.Objects.isNull;

import com.ricardococati.model.entities.SinalMacdSemanal;
import com.ricardococati.repository.dao.SinalMacdSemanalInserirDAO;
import com.ricardococati.repository.dao.sqlutil.SinalMacdSemanalSQLUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class SinalMacdSemanalInserirDAOImpl implements SinalMacdSemanalInserirDAO {

  @Qualifier("namedParameterJdbcTemplate")
  private final NamedParameterJdbcTemplate template;

  private final GeraSequenciaDAOImpl genericDAO;
  private final SinalMacdSemanalSQLUtil sqlUtil;

  @Override
  public Boolean incluirSinalMacd(final SinalMacdSemanal sinalMacdSemanal) {
    if (isNull(sinalMacdSemanal)
        || isNull(sinalMacdSemanal.getDtpregini())
        || isNull(sinalMacdSemanal.getDtpregfim())
        || isNull(sinalMacdSemanal.getSinalMacd())
        || isNull(sinalMacdSemanal.getSinalMacd().getCodneg())) {
      throw new DataIntegrityViolationException(
          "Violação de integridade na inserção de SINAL_MACD_SEMANAL");
    }
    int retorno;
    try {
      sinalMacdSemanal.setIdSinalMacdSemanal(
          genericDAO.getSequence("SINAL_MACD_SEMANAL_SEQ").longValue()
      );
      retorno = template.update(sqlUtil.getInsert(), sqlUtil.toParameters(sinalMacdSemanal));
    } catch (Exception ex) {
      log.error("Erro na execução do método incluir SINAL_MACD_SEMANAL: " + ex.getMessage());
      throw ex;
    }
    return retorno > 0;
  }

}
