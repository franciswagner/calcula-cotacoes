package com.ricardococati.repository.dao.impl;

import static java.util.Objects.isNull;

import com.ricardococati.model.entities.MacdSemanal;
import com.ricardococati.repository.dao.MacdSemanalInserirDAO;
import com.ricardococati.repository.dao.sqlutil.MacdSemanalSQLUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MacdSemanalInserirDAOImpl implements MacdSemanalInserirDAO {

  @Qualifier("namedParameterJdbcTemplate")
  private final NamedParameterJdbcTemplate template;

  private final GeraSequenciaDAOImpl genericDAO;
  private final MacdSemanalSQLUtil sqlUtil;

  @Override
  public Boolean incluirMacd(MacdSemanal macdSemanal) {
    Integer retorno = 0;
    if (isNull(macdSemanal)
        || isNull(macdSemanal.getDtpregini())
        || isNull(macdSemanal.getDtpregfim())
        || isNull(macdSemanal.getMacd().getCodneg())) {
      throw new DataIntegrityViolationException(
          "Violação de integridade na inserção de MACD_SEMANAL");
    }
    try {
      macdSemanal.setIdMacdSemanal(
          genericDAO.getSequence("MACD_SEMANAL_SEQ").longValue()
      );
      retorno = template.update(sqlUtil.getInsert(), sqlUtil.toParameters(macdSemanal));
    } catch (Exception ex) {
      log.error("Erro na execução do método incluir MACD_SEMANAL: " + ex.getMessage());
      throw ex;
    }
    return retorno > 0;
  }

}
