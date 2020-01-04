package com.ricardococati.repository.dao.impl;

import com.ricardococati.model.dto.CandlestickDiarioDTO;
import com.ricardococati.repository.dao.CandlestickDiarioDAO;
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
public class CandlestickDiarioDAOImpl implements CandlestickDiarioDAO {

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
  public List<String> getListCodNegMediaSimplesFalse(final LocalDate dtpregLimite) {
    return template.query(
        sqlUtil.getSelectCodNegMediaSimplesFalse(),
        sqlUtil.toParametersDtPreg(dtpregLimite),
        (rs, rowNum) -> mapper.mapperCodNeg(rs)
    );
  }

  @Override
  public List<String> getListCodNegByDtPreg(final LocalDate dtpregLimite) {
    return template.query(
        sqlUtil.getSelectCodNegByDtPreg(),
        sqlUtil.toParametersDtPreg(dtpregLimite),
        (rs, rowNum) -> mapper.mapperCodNeg(rs)
    );
  }

  @Override
  public List<String> getListCodNegMediaExponencialFalse(final LocalDate dtpregLimite) {
    return template.query(
        sqlUtil.getSelectCodNegMediaExponencialFalse(),
        sqlUtil.toParametersDtPreg(dtpregLimite),
        (rs, rowNum) -> mapper.mapperCodNeg(rs)
    );
  }

  @Override
  public List<String> getListCodNegMacdFalse(final LocalDate dtpregLimite) {
    return template.query(
        sqlUtil.getSelectCodNegMacdFalse(),
        sqlUtil.toParametersDtPreg(dtpregLimite),
        (rs, rowNum) -> mapper.mapperCodNeg(rs)
    );
  }

  @Override
  public List<String> getListCodNegSinalMacdFalse(final LocalDate dtpregLimite) {
    return template.query(
        sqlUtil.getSelectCodNegSinalMacdFalse(),
        sqlUtil.toParametersDtPreg(dtpregLimite),
        (rs, rowNum) -> mapper.mapperCodNeg(rs)
    );
  }

  @Override
  public List<String> getListCodNegHistogramaFalse(final LocalDate dtpregLimite) {
    return template.query(
        sqlUtil.getSelectCodNegHistogramaFalse(),
        sqlUtil.toParametersDtPreg(dtpregLimite),
        (rs, rowNum) -> mapper.mapperCodNeg(rs)
    );
  }

  @Override
  public List<String> getListCodNeg() {
    return template.query(
        sqlUtil.getSelectCodNeg(),
        (rs, rowNum) -> mapper.mapperCodNeg(rs)
    );
  }

  @Override
  public Boolean updateCandleDiarioMediaSimplesGeradaByCodNeg(final String codneg) {
    int retorno = 0;
    try {
      retorno = template.update(sqlUtil.getUpdateMediaMovelByCodneg(),
          sqlUtil.toParametersCodNeg(codneg));
    } catch (Exception ex) {
      log.error("Erro na execução do método update: " + ex.getMessage());
      throw ex;
    }
    return retorno > 0;
  }

  @Override
  public Boolean updateCandleDiarioMediaExponencialGeradaByCodNeg(final String codneg) {
    int retorno = 0;
    try {
      retorno = template.update(sqlUtil.getUpdateMediaExponencialByCodneg(),
          sqlUtil.toParametersCodNeg(codneg));
    } catch (Exception ex) {
      log.error("Erro na execução do método update: " + ex.getMessage());
      throw ex;
    }
    return retorno > 0;
  }

  @Override
  public Boolean updateCandleDiarioMacdGeradaByCodNeg(final String codneg) {
    int retorno = 0;
    try {
      retorno = template.update(sqlUtil.getUpdateMacdByCodneg(),
          sqlUtil.toParametersCodNeg(codneg));
    } catch (Exception ex) {
      log.error("Erro na execução do método update: " + ex.getMessage());
      throw ex;
    }
    return retorno > 0;
  }

  @Override
  public Boolean updateCandleDiarioSinalMacdGeradaByCodNeg(String codneg) {
    int retorno = 0;
    try {
      retorno = template.update(sqlUtil.getUpdateSinalMacdByCodneg(),
          sqlUtil.toParametersCodNeg(codneg));
    } catch (Exception ex) {
      log.error("Erro na execução do método update: " + ex.getMessage());
      throw ex;
    }
    return retorno > 0;
  }

}