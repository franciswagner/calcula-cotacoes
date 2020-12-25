package com.ricardococati.calculacotacoes.adapters.repositories.macd.impl;

import com.ricardococati.calculacotacoes.adapters.repositories.macd.MacdDiarioBuscarDAO;
import com.ricardococati.calculacotacoes.adapters.repositories.macd.mapper.MacdDiarioMapper;
import com.ricardococati.calculacotacoes.adapters.repositories.macd.sqlutil.MacdDiarioSQLUtil;
import com.ricardococati.calculacotacoes.entities.domains.macd.MacdDiario;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MacdDiarioBuscarDAOImpl implements MacdDiarioBuscarDAO {

  @Qualifier("namedParameterJdbcTemplate")
  private final NamedParameterJdbcTemplate template;

  private final MacdDiarioSQLUtil sqlUtil;
  private final MacdDiarioMapper macdMapper;

  @Override
  public List<MacdDiario> listMacdByCodNeg(String codneg) {
    return template.query(
        sqlUtil.getSelectByCodNeg(),
        sqlUtil.toParametersByCodNeg(codneg),
        (rs, rowNum) -> macdMapper.mapper(rs)
    );
  }

  @Override
  public List<MacdDiario> buscaMacdMediaSimplesPorCodNegDtPregLimite9Periodos(
      final String codneg,
      final LocalDate dtpregIni) {
    return template.query(
        sqlUtil.getSelectByCodNegEDtpregLimite9Periodos(),
        sqlUtil.toParametersByCodNegDtpregLimite9Periodos(codneg, dtpregIni),
        (rs, rowNum) -> macdMapper.mapper(rs)
    );
  }

}
