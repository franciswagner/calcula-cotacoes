package com.ricardococati.repository.dao.impl;

import com.ricardococati.model.dto.CandlestickDiarioDTO;
import com.ricardococati.repository.dao.BuscarCandlestickDiarioDAO;
import com.ricardococati.repository.dao.mapper.CandlestickDiarioMapper;
import com.ricardococati.repository.dao.sqlutil.CandlestickDiarioSQLUtil;
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
public class BuscarCandlestickDiarioDAOImpl implements BuscarCandlestickDiarioDAO {

  @Qualifier("namedParameterJdbcTemplate")
  private final NamedParameterJdbcTemplate template;

  private final CandlestickDiarioSQLUtil sqlUtil;
  private final CandlestickDiarioMapper mapper;

  @Override
  public List<CandlestickDiarioDTO> buscaCandleDiarioPorCodNeg(String codneg) {
    return template.query(
        sqlUtil.getSelectByCodNeg(),
        sqlUtil.toParametersCodNeg(codneg),
        (rs, rowNum) -> mapper.mapper(rs)
    );
  }

  @Override
  public List<CandlestickDiarioDTO> buscaCandleDiarioPorDtPreg(final LocalDate dtpregLimite) {
    return template.query(
        sqlUtil.getSelectCodNegByDtPreg(),
        sqlUtil.toParametersDtPreg(dtpregLimite),
        (rs, rowNum) -> mapper.mapper(rs)
    );
  }

}