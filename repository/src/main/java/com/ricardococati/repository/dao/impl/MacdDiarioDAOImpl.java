package com.ricardococati.repository.dao.impl;

import com.ricardococati.model.dto.MacdDiario;
import com.ricardococati.repository.dao.MacdDiarioDAO;
import com.ricardococati.repository.dao.mapper.MacdDiarioMapper;
import com.ricardococati.repository.dao.sqlutil.MacdDiarioSQLUtil;
import com.ricardococati.repository.util.SQLAppender;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MacdDiarioDAOImpl implements MacdDiarioDAO {

  @Qualifier("namedParameterJdbcTemplate")
  private final NamedParameterJdbcTemplate template;

  private final GenericDAOImpl genericDAO;
  private final MacdDiarioSQLUtil sqlUtil;
  private final MacdDiarioMapper macdMapper;

  @Override
  public Boolean incluirMacd(List<MacdDiario> macdList) {
    AtomicInteger retorno = new AtomicInteger(0);
    final SQLAppender sql = new SQLAppender(100);
    try {
      macdList
          .stream()
          .forEach(macd -> {
            macd.setIdMacdDiario(
                genericDAO.getSequence("MACD_DIARIO_SEQ").longValue()
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
