package com.ricardococati.calculacotacoes.adapters.repositories.histograma.impl;

import static java.util.Objects.isNull;

import com.ricardococati.calculacotacoes.adapters.repositories.histograma.HistogramaSemanalInserirDAO;
import com.ricardococati.calculacotacoes.adapters.repositories.histograma.sqlutil.HistogramaSemanalSQLUtil;
import com.ricardococati.calculacotacoes.adapters.repositories.gerasequencia.impl.GeraSequenciaDAOImpl;
import com.ricardococati.calculacotacoes.entities.domains.histograma.HistogramaSemanal;
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
        || isNull(histograma.getHistograma())
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
