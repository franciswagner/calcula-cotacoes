package com.ricardococati.repository.dao.impl;

import static java.util.Objects.isNull;

import com.ricardococati.model.entities.RecomendacaoSemanal;
import com.ricardococati.repository.dao.RecomendacaoSemanalInserirDAO;
import com.ricardococati.repository.dao.sqlutil.RecomendacaoSemanalInserirSQLUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class RecomendacaoSemanalInserirDAOImpl implements RecomendacaoSemanalInserirDAO {

  @Qualifier("namedParameterJdbcTemplate")
  private final NamedParameterJdbcTemplate template;

  private final GeraSequenciaDAOImpl genericDAO;
  private final RecomendacaoSemanalInserirSQLUtil sqlUtil;

  @Override
  public Boolean incluirRecomendacao(final RecomendacaoSemanal recomendacaoSemanal) {
    if (isNull(recomendacaoSemanal)
        || isNull(recomendacaoSemanal.getDtpregini())
        || isNull(recomendacaoSemanal.getDtpregfim())
        || isNull(recomendacaoSemanal.getRecomendacao())
        || isNull(recomendacaoSemanal.getRecomendacao().getCodneg())) {
      throw new DataIntegrityViolationException(
          "Violação de integridade na inserção de RECOMENDACAO_SEMANAL");
    }
    int retorno;
    try {
      recomendacaoSemanal.setIdRecomendacaoSemanal(
          genericDAO.getSequence("RECOMENDACAO_SEMANAL_SEQ").longValue()
      );
      retorno = template.update(sqlUtil.getInsert(), sqlUtil.toParameters(recomendacaoSemanal));
    } catch (Exception ex) {
      log.error("Erro na execução do método incluir RECOMENDACAO_SEMANAL: " + ex.getMessage());
      throw ex;
    }
    return retorno > 0;
  }
}
