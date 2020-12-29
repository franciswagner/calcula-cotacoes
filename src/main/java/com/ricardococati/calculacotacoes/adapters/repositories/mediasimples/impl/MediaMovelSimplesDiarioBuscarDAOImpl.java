package com.ricardococati.calculacotacoes.adapters.repositories.mediasimples.impl;

import com.ricardococati.calculacotacoes.adapters.repositories.mediasimples.MediaMovelSimplesDiarioBuscarDAO;
import com.ricardococati.calculacotacoes.adapters.repositories.mediasimples.mapper.MediaMovelSimplesDiarioMapper;
import com.ricardococati.calculacotacoes.adapters.repositories.mediasimples.sqlutil.MediaMovelSimplesDiarioSQLUtil;
import com.ricardococati.calculacotacoes.entities.domains.mediasimples.MediaMovelSimplesDiario;
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
public class MediaMovelSimplesDiarioBuscarDAOImpl implements MediaMovelSimplesDiarioBuscarDAO {

  @Qualifier("namedParameterJdbcTemplate")
  private final NamedParameterJdbcTemplate template;

  private final MediaMovelSimplesDiarioSQLUtil sqlUtil;
  private final MediaMovelSimplesDiarioMapper mediaMapper;

  @Override
  public MediaMovelSimplesDiario buscaMediaSimplesPorCodNegPeriodoDtPreg(
      final String codneg,
      final Integer periodo,
      final LocalDate dtpreg
  ) throws Exception {
    MediaMovelSimplesDiario mmsDiario;
    try {
      mmsDiario = template.queryForObject(
          sqlUtil.getSelectByCodNegPeriodoDtPreg(),
          sqlUtil.toParametersSelectByCodNegPeriodoDtPreg(codneg, periodo, dtpreg),
          (rs, rowNum) -> mediaMapper.mapper(rs)
      );
    } catch (EmptyResultDataAccessException erdae) {
      log.error("Erro ao buscar média móvel simples: {} ", erdae.getMessage());
      throw new EmptyResultDataAccessException("Erro ao buscar média móvel simples!", 0);
    } catch (Exception ex){
      log.error("Erro ao buscar média móvel simples: {} ", ex.getMessage());
      throw new Exception("Erro ao buscar média móvel simples! {}", ex.getCause());
    }
    return mmsDiario;
  }

}
