package com.ricardococati.repository.dao.impl;

import com.ricardococati.model.dto.CandlestickSemanalDTO;
import com.ricardococati.model.dto.SplitInplit;
import com.ricardococati.repository.dao.GenericDAO;
import com.ricardococati.repository.dao.CandlestickSemanalDAO;
import com.ricardococati.repository.dao.mapper.CandlestickSemanalMapper;
import com.ricardococati.repository.dao.sqlutil.CandlestickSemanalSQLUtil;
import com.ricardococati.repository.util.SQLAppender;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CandlestickSemanalDAOImpl implements CandlestickSemanalDAO {

  @Qualifier("namedParameterJdbcTemplate")
  private final NamedParameterJdbcTemplate template;

  private final GenericDAO genericDAO;
  private final CandlestickSemanalSQLUtil sqlUtil;
  private final CandlestickSemanalMapper mapper;

  @Override
  public Integer contaCandleDiarioSemCandleSemSemanalGerado() {
    return template.queryForObject(
        sqlUtil.getSelectCount(),
        new MapSqlParameterSource(),
        Integer.class
    );
  }

  @Override
  public Boolean incluirCandlestickSemanal(CandlestickSemanalDTO semanal) {
    int retorno = 0;
    final SQLAppender sql = new SQLAppender(100);
    try {
      semanal.setIdCandleSemanal(
          genericDAO.getSequence("CANDLESTICK_SEMANAL_SEQ", template).longValue()
      );
      retorno = template.update(sqlUtil.getInsert(), sqlUtil.toParameters(semanal));
    } catch (Exception ex) {
      log.error("Erro na execução do método CANDLESTICK_DIARIO: " + ex.getMessage());
      throw ex;
    }
    return retorno > 0;
  }

  public Boolean split(final SplitInplit splitInplit) {
    int retorno = 0;
    final String operacao = "/";
    try {
      retorno = template.update(sqlUtil.getUpdate(operacao),
          sqlUtil.toParametersUpdate(splitInplit));
    } catch (Exception ex) {
      log.error("Erro na execução do método split: " + ex.getMessage());
      throw ex;
    }
    return retorno > 0;
  }

  public Boolean inplit(final SplitInplit splitInplit) {
    int retorno = 0;
    final String operacao = "*";
    try {
      retorno = template.update(sqlUtil.getUpdate(operacao),
          sqlUtil.toParametersUpdate(splitInplit));
    } catch (Exception ex) {
      log.error("Erro na execução do método inplit: " + ex.getMessage());
      throw ex;
    }
    return retorno > 0;
  }

  @Override
  public Boolean updateCandlestickSemanal() {
    int retorno = 0;
    try {
      retorno = template.update(sqlUtil.updateCandleStickSemanal(),
          new MapSqlParameterSource());
    } catch (Exception ex) {
      log.error("Erro na execução do método update: " + ex.getMessage());
      throw ex;
    }
    return retorno > 0;
  }

  @Override
  public List<String> listCodNegocioMediaSimplesFalse() {
    return template.query(
        sqlUtil.getSelectCodNegMediaSimplesFalse(),
        (rs, rowNum) -> mapper.mapperCodNeg(rs)
    );
  }

  @Override
  public List<CandlestickSemanalDTO> findCandleSemanalPorCodNeg(String codneg) {
    return template.query(
        sqlUtil.getSelectByCodNeg(),
        sqlUtil.toParametersCodNeg(codneg),
        (rs, rowNum) -> mapper.mapper(rs)
    );
  }

  @Override
  public Boolean updateCandleSemanalMediaSimplesGeradaByCodNeg(String codneg) {
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
  public Boolean updateCandleSemanalMediaExponencialGeradaByCodNeg(String codneg) {
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
  public Boolean updateCandleSemanalMacdGeradaByCodNeg(String codneg) {
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
  public Boolean updateCandleSemanalSinalMacdGeradaByCodNeg(String codneg) {
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

  @Override
  public List<String> getListCodNeg() {
    return template.query(
        sqlUtil.getSelectCodNeg(),
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
}
