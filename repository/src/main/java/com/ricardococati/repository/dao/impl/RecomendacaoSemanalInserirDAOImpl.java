package com.ricardococati.repository.dao.impl;

import com.ricardococati.model.dto.RecomendacaoSemanal;
import com.ricardococati.repository.dao.RecomendacaoSemanalInserirDAO;
import com.ricardococati.repository.dao.sqlutil.RecomendacaoSemanalInserirSQLUtil;
import com.ricardococati.repository.util.SQLAppender;
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
public class RecomendacaoSemanalInserirDAOImpl implements RecomendacaoSemanalInserirDAO {

  @Qualifier("namedParameterJdbcTemplate")
  private final NamedParameterJdbcTemplate template;

  private final GeraSequenciaDAOImpl genericDAO;
  private final RecomendacaoSemanalInserirSQLUtil sqlUtil;

  @Override
  public Boolean incluirRecomendacao(List<RecomendacaoSemanal> diarioList) {
    AtomicInteger retorno = new AtomicInteger(0);
    final SQLAppender sql = new SQLAppender(100);
    try {
      diarioList
          .stream()
          .forEach(diario -> {
            diario.setIdRecomendacaoSemanal(
                genericDAO.getSequence("RECOMENDACAO_SEMANAL_SEQ").longValue()
            );
            retorno.addAndGet(template.update(sqlUtil.getInsert(), sqlUtil.toParameters(diario)));
          });
    } catch (Exception ex) {
      log.error("Erro na execução do método incluir RECOMENDACAO: " + ex.getMessage());
      throw ex;
    }
    return retorno.get() > 0;
  }
}
