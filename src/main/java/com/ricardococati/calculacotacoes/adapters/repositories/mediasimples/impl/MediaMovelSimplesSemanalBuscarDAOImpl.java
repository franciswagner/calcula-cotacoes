package com.ricardococati.calculacotacoes.adapters.repositories.mediasimples.impl;

import com.ricardococati.calculacotacoes.adapters.repositories.mediasimples.MediaMovelSimplesSemanalBuscarDAO;
import com.ricardococati.calculacotacoes.adapters.repositories.mediasimples.mapper.MediaMovelSimplesSemanalMapper;
import com.ricardococati.calculacotacoes.adapters.repositories.mediasimples.sqlutil.MediaMovelSimplesSemanalSQLUtil;
import com.ricardococati.calculacotacoes.entities.domains.mediasimples.MediaMovelSimplesSemanal;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MediaMovelSimplesSemanalBuscarDAOImpl implements MediaMovelSimplesSemanalBuscarDAO {

  @Qualifier("namedParameterJdbcTemplate")
  private final NamedParameterJdbcTemplate template;

  private final MediaMovelSimplesSemanalSQLUtil sqlUtil;
  private final MediaMovelSimplesSemanalMapper mediaMapper;

  @Override
  public MediaMovelSimplesSemanal buscaMediaSimplesPorCodNegPeriodoDtPreg(
      final String codneg,
      final Integer periodo,
      final LocalDate dtpregini,
      final LocalDate dtpregfim
  ) throws Exception {
    try {
      return template.queryForObject(
          sqlUtil.getSelectByCodNegPeriodoDtPreg(),
          sqlUtil.toParametersSelectByCodNegPeriodoDtPreg(codneg, periodo, dtpregini, dtpregfim),
          (rs, rowNum) -> mediaMapper.mapper(rs)
      );
    } catch (EmptyResultDataAccessException erdae) {
      log.error("Erro ao buscar média móvel simples: {} ", erdae.getMessage());
      throw new EmptyResultDataAccessException("Erro ao buscar média móvel simples!", 0);
    } catch (Exception ex){
      log.error("Erro ao buscar média móvel simples: {} ", ex.getMessage());
      throw new Exception("Erro ao buscar média móvel simples! {}", ex.getCause());
    }
  }

}
