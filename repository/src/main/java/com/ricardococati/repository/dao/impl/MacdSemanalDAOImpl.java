package com.ricardococati.repository.dao.impl;

import com.ricardococati.model.dto.MacdSemanal;
import com.ricardococati.repository.dao.MacdSemanalDAO;
import com.ricardococati.repository.dao.mapper.MacdSemanalMapper;
import com.ricardococati.repository.dao.sqlutil.MacdSemanalSQLUtil;
import com.ricardococati.repository.util.SQLAppender;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MacdSemanalDAOImpl implements MacdSemanalDAO {

  @Qualifier("namedParameterJdbcTemplate")
  private final NamedParameterJdbcTemplate template;

  private final GenericDAOImpl genericDAO;
  private final MacdSemanalSQLUtil sqlUtil;
  private final MacdSemanalMapper macdMapper;

  @Override
  public Boolean incluirMacd(List<MacdSemanal> macdList) {
    AtomicInteger retorno = new AtomicInteger(0);
    final SQLAppender sql = new SQLAppender(100);
    try {
      macdList
          .stream()
          .forEach(macd -> {
            macd.setIdMacdSemanal(
                genericDAO.getSequence("MACD_SEMANAL_SEQ").longValue()
            );
            retorno.addAndGet(template.update(sqlUtil.getInsert(), sqlUtil.toParameters(macd)));
          });
    } catch (Exception ex) {
      log.error("Erro na execução do método incluir MACD: " + ex.getMessage());
      throw ex;
    }
    return retorno.get() > 0;
  }

  @Override
  public Boolean deleteAllMacd() {
    return template.update(sqlUtil.getDelete(), new MapSqlParameterSource()) == 0;
  }

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
