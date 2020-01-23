package com.ricardococati.repository.dao.impl;

import com.ricardococati.model.dto.MediaMovelSimplesDiario;
import com.ricardococati.model.dto.SplitInplit;
import com.ricardococati.repository.dao.MediaMovelSimplesDiarioDAO;
import com.ricardococati.repository.dao.mapper.MediaMovelSimplesDiarioMapper;
import com.ricardococati.repository.dao.sqlutil.MediaMovelSimplesDiarioSQLUtil;
import com.ricardococati.repository.util.SQLAppender;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
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
public class MediaMovelSimplesDiarioDAOImpl implements MediaMovelSimplesDiarioDAO {

  @Qualifier("namedParameterJdbcTemplate")
  private final NamedParameterJdbcTemplate template;

  private final GeraSequenciaDAOImpl genericDAO;
  private final MediaMovelSimplesDiarioSQLUtil sqlUtil;
  private final MediaMovelSimplesDiarioMapper mediaMapper;

  @Override
  public Boolean incluirMediaMovelSimples(final List<MediaMovelSimplesDiario> mediaMovelSimplesList) {
    AtomicInteger retorno = new AtomicInteger(0);
    final SQLAppender sql = new SQLAppender(100);
    try {
      mediaMovelSimplesList
          .stream()
          .filter(Objects::nonNull)
          .forEach(mediaMovelSimples -> {
            mediaMovelSimples.setIdMediaMovelSimplesDiario(
                genericDAO.getSequence("MEDIA_MOVEL_SIMPLES_DIARIO_SEQ").longValue()
            );
            retorno.addAndGet(template.update(sqlUtil.getInsert(), sqlUtil.toParameters(mediaMovelSimples)));
          });
    } catch (Exception ex) {
      log.error("Erro na execução do método CANDLESTICK_DIARIO: " + ex.getMessage());
      throw ex;
    }
    return retorno.get() > 0;
  }

  @Override
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

  @Override
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
  public MediaMovelSimplesDiario buscaMediaSimplesPorCodNegPeriodoDtPreg(
      final String codneg,
      final Integer periodo,
      final LocalDate dtpreg
  ) {
    return template.query(
        sqlUtil.getSelectByCodNegPeriodoDtPreg(),
        sqlUtil.toParametersSelectByCodNegPeriodoDtPreg(codneg, periodo, dtpreg),
        (rs, rowNum) -> mediaMapper.mapper(rs)
    ).stream().findFirst().get();
  }

  @Override
  public Boolean deleteAllMM() {
    return template.update(sqlUtil.getDelete(), new MapSqlParameterSource()) == 0;
  }

}
