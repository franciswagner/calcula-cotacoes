package com.ricardococati.repository.dao.impl;

import static java.util.Objects.isNull;

import com.ricardococati.model.dto.MediaMovelSimplesDiario;
import com.ricardococati.repository.dao.MediaMovelSimplesDiarioInserirDAO;
import com.ricardococati.repository.dao.sqlutil.MediaMovelSimplesDiarioSQLUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MediaMovelSimplesDiarioInserirDAOImpl implements MediaMovelSimplesDiarioInserirDAO {

  @Qualifier("namedParameterJdbcTemplate")
  private final NamedParameterJdbcTemplate template;

  private final GeraSequenciaDAOImpl genericDAO;
  private final MediaMovelSimplesDiarioSQLUtil sqlUtil;

  @Override
  public Boolean incluirMediaMovelSimples(
      final MediaMovelSimplesDiario mmsDiario) {
    if (isNull(mmsDiario)
        || isNull(mmsDiario.getDtpreg())
        || isNull(mmsDiario.getMediaMovelSimples())
        || isNull(mmsDiario.getMediaMovelSimples().getCodneg())) {
      throw new DataIntegrityViolationException(
          "Violação de integridade na inserção de MEDIA_MOVEL_SIMPLES_DIARIO");
    }
    int retorno;
    try {
      mmsDiario.setIdMediaMovelSimplesDiario(
          genericDAO.getSequence("MEDIA_MOVEL_SIMPLES_DIARIO_SEQ").longValue()
      );
      retorno = template.update(sqlUtil.getInsert(), sqlUtil.toParameters(mmsDiario));
    } catch (Exception ex) {
      log.error("Erro na execução do método MEDIA_MOVEL_SIMPLES_DIARIO: " + ex.getMessage());
      throw ex;
    }
    return retorno > 0;
  }

}
