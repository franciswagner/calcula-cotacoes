package com.ricardococati.repository.dao.impl;

import com.ricardococati.model.dto.CandlestickSemanalDTO;
import com.ricardococati.repository.dao.BuscarCandlestickSemanalDAO;
import com.ricardococati.repository.dao.mapper.BuscarCandlestickSemanalMapper;
import com.ricardococati.repository.dao.sqlutil.BuscarCandlestickSemanalSQLUtil;
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
public class BuscarCandlestickSemanalDAOImpl implements BuscarCandlestickSemanalDAO {

  @Qualifier("namedParameterJdbcTemplate")
  private final NamedParameterJdbcTemplate template;

  private final BuscarCandlestickSemanalSQLUtil sqlUtil;
  private final BuscarCandlestickSemanalMapper mapper;

  @Override
  public List<CandlestickSemanalDTO> buscaCandleSemanalPorCodNeg(String codneg) {
    return template.query(
        sqlUtil.getSelectByCodNeg(),
        sqlUtil.toParametersCodNeg(codneg),
        (rs, rowNum) -> mapper.mapper(rs)
    );
  }

  @Override
  public List<String> buscaCandleSemanalPorDtPreg(final LocalDate dtpregLimite) {
    return template.query(
        sqlUtil.getSelectCodNegByDtPreg(),
        sqlUtil.toParametersDtPreg(dtpregLimite),
        (rs, rowNum) -> mapper.mapperCodNeg(rs)
    );
  }
}
