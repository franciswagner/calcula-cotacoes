package com.ricardococati.repository.dao.impl;

import static java.util.Objects.isNull;

import com.ricardococati.model.dto.HistogramaSemanal;
import com.ricardococati.repository.dao.HistogramaSemanalInserirDAO;
import com.ricardococati.repository.dao.sqlutil.HistogramaSemanalSQLUtil;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class HistogramaSemanalInserirDAOImpl implements HistogramaSemanalInserirDAO {

  @Qualifier("namedParameterJdbcTemplate")
  private final NamedParameterJdbcTemplate template;

  private final GeraSequenciaDAOImpl genericDAO;
  private final HistogramaSemanalSQLUtil sqlUtil;

  @Override
  public Boolean incluirHistograma(HistogramaSemanal histograma) {
    Integer retorno = 0;
    if (isNull(histograma)
        || isNull(histograma.getDtpregini())
        || isNull(histograma.getDtpregfim())
        || isNull(histograma.getHistograma().getCodneg())) {
      throw new DataIntegrityViolationException(
          "Violação de integridade na inserção de HISTOGRAMA_SEMANAL");
    }
    try {
      histograma.setIdHistogramaSemanal(
          genericDAO.getSequence("HISTOGRAMA_SEMANAL_SEQ").longValue()
      );
      retorno = template.update(sqlUtil.getInsert(), sqlUtil.toParameters(histograma));
    } catch (Exception ex) {
      log.error("Erro na execução do método incluir HISTOGRAMA_SEMANAL: " + ex.getMessage());
      throw ex;
    }
    return retorno > 0;
  }

}
