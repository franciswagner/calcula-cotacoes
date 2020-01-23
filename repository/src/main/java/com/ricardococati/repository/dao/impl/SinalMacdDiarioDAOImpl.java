package com.ricardococati.repository.dao.impl;

import com.ricardococati.model.dto.SinalMacdDiario;
import com.ricardococati.repository.dao.SinalMacdDiarioDAO;
import com.ricardococati.repository.dao.mapper.SinalMacdDiarioMapper;
import com.ricardococati.repository.dao.sqlutil.SinalMacdDiarioSQLUtil;
import com.ricardococati.repository.util.SQLAppender;
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
public class SinalMacdDiarioDAOImpl implements SinalMacdDiarioDAO {

  @Qualifier("namedParameterJdbcTemplate")
  private final NamedParameterJdbcTemplate template;

  private final GenericDAOImpl genericDAO;
  private final SinalMacdDiarioSQLUtil sqlUtil;
  private final SinalMacdDiarioMapper mapper;

  @Override
  public Boolean incluirSinalMacd(List<SinalMacdDiario> macdList) {
    AtomicInteger retorno = new AtomicInteger(0);
    final SQLAppender sql = new SQLAppender(100);
    try {
      macdList
          .stream()
          .forEach(sinalMacd -> {
            sinalMacd.setIdSinalMacdDiario(
                genericDAO.getSequence("SINAL_MACD_DIARIO_SEQ").longValue()
            );
            retorno.addAndGet(template.update(sqlUtil.getInsert(), sqlUtil.toParameters(sinalMacd)));
          });
    } catch (Exception ex) {
      log.error("Erro na execução do método incluir SINAL_MACD: " + ex.getMessage());
      throw ex;
    }
    return retorno.get() > 0;
  }

  @Override
  public Boolean deleteAllSinalMacd() {
    return template.update(sqlUtil.getDelete(), new MapSqlParameterSource()) == 0;
  }

  @Override
  public List<SinalMacdDiario> listSinalMacdByCodNeg(String codneg) {
    return template.query(
        sqlUtil.getSelectByCodNeg(),
        sqlUtil.toParametersByCodNeg(codneg),
        (rs, rowNum) -> mapper.mapper(rs)
    );
  }
}
