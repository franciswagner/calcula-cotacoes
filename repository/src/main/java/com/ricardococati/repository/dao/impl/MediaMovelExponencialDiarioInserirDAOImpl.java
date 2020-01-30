package com.ricardococati.repository.dao.impl;

import static java.util.Objects.isNull;

import com.ricardococati.model.dto.MediaMovelExponencialDiario;
import com.ricardococati.repository.dao.MediaMovelExponencialDiarioInserirDAO;
import com.ricardococati.repository.dao.sqlutil.MediaMovelExponencialDiarioSQLUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MediaMovelExponencialDiarioInserirDAOImpl implements
    MediaMovelExponencialDiarioInserirDAO {

  @Qualifier("namedParameterJdbcTemplate")
  private final NamedParameterJdbcTemplate template;

  private final GeraSequenciaDAOImpl genericDAO;
  private final MediaMovelExponencialDiarioSQLUtil sqlUtil;

  @Override
  public Boolean incluirMediaMovelExponencial(
      final MediaMovelExponencialDiario mmeDiario) {
    if (isNull(mmeDiario)
        || isNull(mmeDiario.getDtpreg())
        || isNull(mmeDiario.getMediaMovelExponencial().getCodneg())) {
      throw new DataIntegrityViolationException(
          "Violação de integridade na inserção de MEDIA_MOVEL_EXPONENCIAL_DIARIO");
    }
    int retorno;
    try {
      mmeDiario.setIdMediaMovelExponencialDiario(
          genericDAO
              .getSequence("MEDIA_MOVEL_EXPONENCIAL_DIARIO_SEQ")
              .longValue()
      );
      retorno = template.update(sqlUtil.getInsert(), sqlUtil.toParameters(mmeDiario));
    } catch (Exception ex) {
      log.error("Erro na execução do método MEDIA_MOVEL_EXPONENCIAL_DIARIO: " + ex.getMessage());
      throw ex;
    }
    return retorno > 0;
  }

}
