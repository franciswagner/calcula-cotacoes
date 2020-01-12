package com.ricardococati.repository.dao.impl;

import com.ricardococati.model.dto.MediaMovelExponencialDiario;
import com.ricardococati.repository.dao.MediaMovelExponencialDiarioDAO;
import com.ricardococati.repository.dao.mapper.BuscarCandlestickDiarioMapper;
import com.ricardococati.repository.dao.mapper.MediaMovelExponencialDiarioMapper;
import com.ricardococati.repository.dao.sqlutil.MediaMovelExponencialDiarioSQLUtil;
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
public class MediaMovelExponencialDiarioDAOImpl implements MediaMovelExponencialDiarioDAO {

  @Qualifier("namedParameterJdbcTemplate")
  private final NamedParameterJdbcTemplate template;

  private final GenericDAOImpl genericDAO;
  private final MediaMovelExponencialDiarioSQLUtil sqlUtil;
  private final BuscarCandlestickDiarioMapper mapper;
  private final MediaMovelExponencialDiarioMapper mediaMapper;

  @Override
  public Boolean incluirMediaMovelExponencial(final List<MediaMovelExponencialDiario> mediaMovelExponencialList) {
    AtomicInteger retorno = new AtomicInteger(0);
    final SQLAppender sql = new SQLAppender(100);
    try {
      mediaMovelExponencialList
          .stream()
          .forEach(mediaMovelSimples -> {
            mediaMovelSimples.setIdMediaMovelExponencialDiario(
                genericDAO.getSequence("MEDIA_MOVEL_EXPONENCIAL_DIARIO_SEQ", template).longValue()
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
  public Boolean deleteAllMME() {
    return template.update(sqlUtil.getDelete(), new MapSqlParameterSource()) == 0;
  }

  @Override
  public List<MediaMovelExponencialDiario> getListMMEByCodNegEPeriodo(
      String codneg,
      Integer periodo
  ) {
    return template.query(
        sqlUtil.getSelectByCodNegEPeriodo(),
        sqlUtil.toParametersByCodNegEPeriodo(codneg, periodo),
        (rs, rowNum) -> mediaMapper.mapper(rs)
    );
  }

  @Override
  public List<MediaMovelExponencialDiario> listMediaExponencialByCodneg(final String codneg) {
    return template.query(
        sqlUtil.getSelect(),
        new MapSqlParameterSource(),
        (rs, rowNum) -> mediaMapper.mapper(rs)
    );
  }

}
