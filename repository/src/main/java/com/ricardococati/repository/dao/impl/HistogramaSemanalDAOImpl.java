package com.ricardococati.repository.dao.impl;

import com.ricardococati.model.dto.HistogramaSemanal;
import com.ricardococati.repository.dao.HistogramaSemanalDAO;
import com.ricardococati.repository.dao.sqlutil.HistogramaSemanalSQLUtil;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class HistogramaSemanalDAOImpl implements HistogramaSemanalDAO {

  @Qualifier("namedParameterJdbcTemplate")
  private final NamedParameterJdbcTemplate template;

  private final GeraSequenciaDAOImpl genericDAO;
  private final HistogramaSemanalSQLUtil sqlUtil;

  @Override
  public Boolean incluirHistograma(List<HistogramaSemanal> histogramas) {
    AtomicInteger retorno = new AtomicInteger(0);
    try {
      histogramas
          .stream()
          .forEach(histograma -> {
            histograma.setIdHistogramaSemanal(
                genericDAO.getSequence("HISTOGRAMA_SEMANAL_SEQ").longValue()
            );
            retorno.addAndGet(template.update(sqlUtil.getInsert(), sqlUtil.toParameters(histograma)));
          });
    } catch (Exception ex) {
      log.error("Erro na execução do método incluir HISTOGRAMA_SEMANAL_SEQ: " + ex.getMessage());
      throw ex;
    }
    return retorno.get() > 0;
  }

}
