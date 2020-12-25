package com.ricardococati.calculacotacoes.adapters.repositories.candlestick.impl;

import com.ricardococati.calculacotacoes.adapters.repositories.candlestick.CandlestickDiarioBuscarDAO;
import com.ricardococati.calculacotacoes.adapters.repositories.candlestick.mapper.BuscarCandlestickDiarioMapper;
import com.ricardococati.calculacotacoes.adapters.repositories.candlestick.sqlutil.CandlestickDiarioBuscarSQLUtil;
import com.ricardococati.calculacotacoes.entities.domains.candlestick.CandlestickDiario;
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
public class CandlestickDiarioBuscarDAOImpl implements CandlestickDiarioBuscarDAO {

  @Qualifier("namedParameterJdbcTemplate")
  private final NamedParameterJdbcTemplate template;

  private final CandlestickDiarioBuscarSQLUtil sqlUtil;
  private final BuscarCandlestickDiarioMapper mapper;

  @Override
  public List<CandlestickDiario> buscaCandleDiarioPorCodNeg(final String codneg) {
    return template.query(
        sqlUtil.getSelectByCodNeg(),
        sqlUtil.toParametersCodNeg(codneg),
        (rs, rowNum) -> mapper.mapper(rs)
    );
  }

  @Override
  public List<String> buscaCandleDiarioPorDtPreg(final LocalDate dtpregLimite) {
    return template.query(
        sqlUtil.getSelectCodNegByDtPreg(),
        sqlUtil.toParametersDtPreg(dtpregLimite),
        (rs, rowNum) -> mapper.mapperCodNeg(rs)
    );
  }

}