package com.ricardococati.calculacotacoes.adapters.repositories.mediasimples.impl;

import static java.util.Objects.isNull;

import com.ricardococati.calculacotacoes.adapters.repositories.gerasequencia.GeraSequenciaDAO;
import com.ricardococati.calculacotacoes.adapters.repositories.mediasimples.MediaMovelSimplesSemanalInserirDAO;
import com.ricardococati.calculacotacoes.adapters.repositories.mediasimples.sqlutil.MediaMovelSimplesSemanalSQLUtil;
import com.ricardococati.calculacotacoes.entities.domains.mediasimples.MediaMovelSimplesSemanal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MediaMovelSimplesSemanalInserirDAOImpl implements MediaMovelSimplesSemanalInserirDAO {

  @Qualifier("namedParameterJdbcTemplate")
  private final NamedParameterJdbcTemplate template;

  private final GeraSequenciaDAO genericDAO;
  private final MediaMovelSimplesSemanalSQLUtil sqlUtil;

  @Override
  public Boolean incluirMediaMovelSimples(final MediaMovelSimplesSemanal mmsSemanal) {
    if (isNull(mmsSemanal)
        || isNull(mmsSemanal.getDtpregini())
        || isNull(mmsSemanal.getDtpregfim())
        || isNull(mmsSemanal.getMediaMovelSimples())
        || isNull(mmsSemanal.getMediaMovelSimples().getCodneg())) {
      throw new DataIntegrityViolationException(
          "Violação de integridade na inserção de MEDIA_MOVEL_SIMPLES_SEMANAL");
    }
    int retorno;
    try {
      mmsSemanal.setIdMediaMovelSimplesSemanal(
          genericDAO.getSequence("MEDIA_MOVEL_SIMPLES_SEMANAL_SEQ").longValue()
      );
      retorno = template.update(sqlUtil.getInsert(), sqlUtil.toParameters(mmsSemanal));
    } catch (Exception ex) {
      log.error("Erro na execução do método MEDIA_MOVEL_SIMPLES_SEMANAL: " + ex.getMessage());
      throw ex;
    }
    return retorno > 0;
  }

}
