package com.ricardococati.calculacotacoes.adapters.repositories.ativo.impl;

import com.ricardococati.calculacotacoes.adapters.repositories.ativo.AtivoBuscarDAO;
import com.ricardococati.calculacotacoes.adapters.repositories.ativo.mapper.AtivoBuscarMapper;
import com.ricardococati.calculacotacoes.adapters.repositories.ativo.sqlutil.AtivoBuscarSQLUtil;
import com.ricardococati.calculacotacoes.entities.domains.ativo.Ativo;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class AtivoBuscarDAOImpl implements AtivoBuscarDAO {

  @Qualifier("namedParameterJdbcTemplate")
  private final NamedParameterJdbcTemplate template;

  private final AtivoBuscarSQLUtil sqlUtil;
  private final AtivoBuscarMapper mapper;

  @Override
  public List<Ativo> buscaAtivoByUsuario(Long idUsuario) {
    return template.query(
        sqlUtil.getSelectAtivoByUsuario(),
        sqlUtil.toParametersAtivoByUsuario(idUsuario),
        (rs, rowNum) -> mapper.mapper(rs)
    );
  }
}
