package com.ricardococati.repository.dao.impl;

import com.ricardococati.model.dto.RecomendacaoDiario;
import com.ricardococati.repository.dao.GenericDAO;
import com.ricardococati.repository.dao.IRecomendacaoDiarioDAO;
import com.ricardococati.repository.dao.mapper.RecomendacaoDiarioMapper;
import com.ricardococati.repository.dao.sqlutil.RecomendacaoDiarioSQLUtil;
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
public class RecomendacaoDiarioDAO implements IRecomendacaoDiarioDAO {

  @Qualifier("namedParameterJdbcTemplate")
  private final NamedParameterJdbcTemplate template;

  private final GenericDAO genericDAO;
  private final RecomendacaoDiarioSQLUtil sqlUtil;
  private final RecomendacaoDiarioMapper mapper;

  @Override
  public Boolean incluirRecomendacao(List<RecomendacaoDiario> diarioList) {
    AtomicInteger retorno = new AtomicInteger(0);
    final SQLAppender sql = new SQLAppender(100);
    try {
      diarioList
          .stream()
          .forEach(diario -> {
            diario.setIdRecomendacaoDiario(
                genericDAO.getSequence("RECOMENDACAO_DIARIO_SEQ", template).longValue()
            );
            retorno.addAndGet(template.update(sqlUtil.getInsert(), sqlUtil.toParameters(diario)));
          });
    } catch (Exception ex) {
      log.error("Erro na execução do método incluir RECOMENDACAO: " + ex.getMessage());
      throw ex;
    }
    return retorno.get() > 0;
  }

  @Override
  public Boolean deleteAllRecomendacao() {
    return template.update(sqlUtil.getDelete(), new MapSqlParameterSource()) == 0;
  }

  @Override
  public List<RecomendacaoDiario> listRecomendacaoByCodNeg(String codneg) {
    return template.query(
        sqlUtil.getSelectByCodNeg(),
        sqlUtil.toParametersByCodNeg(codneg),
        (rs, rowNum) -> mapper.mapper(rs)
    );
  }

  @Override
  public List<RecomendacaoDiario> getListRecomendacaoByDtPregECodNeg(
      final LocalDate dtLimitePregao,
      final String codneg
  ) {
    return template.query(
        sqlUtil.getSelectByCodNegDtPreg(),
        sqlUtil.toParametersCodNegDtPreg(codneg,dtLimitePregao),
        (rs, rowNum) -> mapper.mapperConsult(rs)
    );
  }
}
