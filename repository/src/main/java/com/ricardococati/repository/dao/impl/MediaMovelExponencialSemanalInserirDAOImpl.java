package com.ricardococati.repository.dao.impl;

import static java.util.Objects.isNull;

import com.ricardococati.model.dto.MediaMovelExponencialSemanal;
import com.ricardococati.repository.dao.MediaMovelExponencialSemanalInserirDAO;
import com.ricardococati.repository.dao.mapper.MediaMovelExponencialSemanalMapper;
import com.ricardococati.repository.dao.sqlutil.MediaMovelExponencialSemanalSQLUtil;
import com.ricardococati.repository.util.SQLAppender;
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
public class MediaMovelExponencialSemanalInserirDAOImpl
    implements MediaMovelExponencialSemanalInserirDAO {

  @Qualifier("namedParameterJdbcTemplate")
  private final NamedParameterJdbcTemplate template;

  private final GeraSequenciaDAOImpl genericDAO;
  private final MediaMovelExponencialSemanalSQLUtil sqlUtil;

  @Override
  public Boolean incluirMediaMovelExponencial(
      final MediaMovelExponencialSemanal mmeSemanal
  ) {
    if (isNull(mmeSemanal)
        || isNull(mmeSemanal.getDtpregini())
        || isNull(mmeSemanal.getDtpregfim())
        || isNull(mmeSemanal.getMediaMovelExponencial())
        || isNull(mmeSemanal.getMediaMovelExponencial().getCodneg())) {
      throw new DataIntegrityViolationException(
          "Violação de integridade na inserção de MEDIA_MOVEL_EXPONENCIAL_SEMANAL");
    }
    int retorno;
    try {
      mmeSemanal.setIdMediaMovelExponencialSemanal(
          genericDAO.getSequence("MEDIA_MOVEL_EXPONENCIAL_SEMANAL_SEQ").longValue()
      );
      retorno = template.update(sqlUtil.getInsert(), sqlUtil.toParameters(mmeSemanal));
    } catch (Exception ex) {
      log.error("Erro na execução do método MEDIA_MOVEL_EXPONENCIAL_SEMANAL: " + ex.getMessage());
      throw ex;
    }
    return retorno > 0;
  }

}
