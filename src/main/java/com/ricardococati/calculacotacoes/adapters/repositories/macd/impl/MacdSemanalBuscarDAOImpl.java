package com.ricardococati.calculacotacoes.adapters.repositories.macd.impl;

import com.ricardococati.calculacotacoes.adapters.repositories.macd.MacdSemanalBuscarDAO;
import com.ricardococati.calculacotacoes.adapters.repositories.macd.mapper.MacdSemanalMapper;
import com.ricardococati.calculacotacoes.adapters.repositories.macd.sqlutil.MacdSemanalSQLUtil;
import com.ricardococati.calculacotacoes.entities.domains.macd.MacdSemanal;
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
public class MacdSemanalBuscarDAOImpl implements MacdSemanalBuscarDAO {

  @Qualifier("namedParameterJdbcTemplate")
  private final NamedParameterJdbcTemplate template;

  private final MacdSemanalSQLUtil sqlUtil;
  private final MacdSemanalMapper macdMapper;

  @Override
  public List<MacdSemanal> listMacdByCodNeg(String codneg) {
    return template.query(
        sqlUtil.getSelectByCodNeg(),
        sqlUtil.toParametersByCodNeg(codneg),
        (rs, rowNum) -> macdMapper.mapper(rs)
    );
  }

  @Override
  public List<MacdSemanal> buscaMacdMediaSimplesPorCodNegDtPregLimite9Periodos(
      final String codneg,
      final LocalDate dtpregIni) {
    return template.query(
        sqlUtil.getSelectByCodNegEDtpregLimite9Periodos(),
        sqlUtil.toParametersByCodNegDtpregLimite9Periodos(codneg, dtpregIni),
        (rs, rowNum) -> macdMapper.mapper(rs)
    );
  }

}
