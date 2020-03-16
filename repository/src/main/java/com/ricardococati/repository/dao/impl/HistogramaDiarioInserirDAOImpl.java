package com.ricardococati.repository.dao.impl;

import static java.util.Objects.isNull;

import com.ricardococati.model.entities.HistogramaDiario;
import com.ricardococati.repository.dao.HistogramaDiarioInserirDAO;
import com.ricardococati.repository.dao.sqlutil.HistogramaDiarioSQLUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class HistogramaDiarioInserirDAOImpl implements HistogramaDiarioInserirDAO {

  @Qualifier("namedParameterJdbcTemplate")
  private final NamedParameterJdbcTemplate template;

  private final GeraSequenciaDAOImpl genericDAO;
  private final HistogramaDiarioSQLUtil sqlUtil;

  @Override
  public Boolean incluirHistograma(final HistogramaDiario histograma) {
    Integer retorno = 0;
    if (isNull(histograma)
        || isNull(histograma.getDtpreg())
        || isNull(histograma.getHistograma().getCodneg())) {
      throw new DataIntegrityViolationException(
          "Violação de integridade na inserção de HISTOGRAMA_DIARIO");
    }
    try {
      histograma.setIdHistogramaDiario(
          genericDAO.getSequence("HISTOGRAMA_DIARIO_SEQ").longValue()
      );
      retorno = template.update(sqlUtil.getInsert(), sqlUtil.toParameters(histograma));
    } catch (Exception ex) {
      log.error("Erro na execução do método incluir HISTOGRAMA_DIARIO: " + ex.getMessage());
      throw ex;
    }
    return retorno > 0;
  }

}
