package com.ricardococati.repository.dao.impl;

import com.ricardococati.model.dto.ControleExecucao;
import com.ricardococati.repository.dao.IControleExecucaoDAO;
import com.ricardococati.repository.dao.mapper.ControleExecucaoMapper;
import com.ricardococati.repository.dao.sqlutil.ControleExecucaoSQLUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ControleExecucaoDAO implements IControleExecucaoDAO {

  @Qualifier("namedParameterJdbcTemplate")
  private final NamedParameterJdbcTemplate template;

  private final ControleExecucaoSQLUtil sqlUtil;
  private final ControleExecucaoMapper mapper;

  @Override
  public ControleExecucao loadControleExecucao() {
    return template.queryForObject(
        sqlUtil.getSelectControleExecucaoAtivo(),
        sqlUtil.toParametersControleExecucaoAtivo(true),
        (rs, rowNum) -> mapper.mapper(rs)
    );
  }

  @Override
  public Boolean updateControleExecucaoDiario(ControleExecucao controleExecucao) {
    int retorno = 0;
    try {
      retorno = template.update(sqlUtil.getUpdateDiario(),
          sqlUtil.toParametersUpdateDiario(controleExecucao));
    } catch (Exception ex) {
      log.error("Erro na execução do método UPDATE DIARIO: " + ex.getMessage());
      throw ex;
    }
    return retorno > 0;
  }

  @Override
  public Boolean updateControleExecucaoSemanal(ControleExecucao controleExecucao) {
    int retorno = 0;
    try {
      retorno = template.update(sqlUtil.getUpdateSemanal(),
          sqlUtil.toParametersUpdateSemanal(controleExecucao));
    } catch (Exception ex) {
      log.error("Erro na execução do método UPDATE SEMANAL: " + ex.getMessage());
      throw ex;
    }
    return retorno > 0;
  }

}
