package com.ricardococati.repository.dao.impl;

import com.ricardococati.model.dto.RecomendacaoDiario;
import com.ricardococati.repository.dao.RecomendacaoDiarioInserirDAO;
import com.ricardococati.repository.dao.sqlutil.RecomendacaoDiarioInserirSQLUtil;
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
public class RecomendacaoDiarioInserirDAOImpl implements RecomendacaoDiarioInserirDAO {

  @Qualifier("namedParameterJdbcTemplate")
  private final NamedParameterJdbcTemplate template;

  private final GeraSequenciaDAOImpl genericDAO;
  private final RecomendacaoDiarioInserirSQLUtil sqlUtil;

  @Override
  public Boolean incluirRecomendacao(List<RecomendacaoDiario> diarioList) {
    AtomicInteger retorno = new AtomicInteger(0);
    try {
      diarioList
          .stream()
          .forEach(diario -> {
            diario.setIdRecomendacaoDiario(
                genericDAO.getSequence("RECOMENDACAO_DIARIO_SEQ").longValue()
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
