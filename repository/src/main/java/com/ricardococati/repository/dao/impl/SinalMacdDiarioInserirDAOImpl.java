package com.ricardococati.repository.dao.impl;

import static java.util.Objects.isNull;

import com.ricardococati.model.dto.SinalMacdDiario;
import com.ricardococati.repository.dao.SinalMacdDiarioInserirDAO;
import com.ricardococati.repository.dao.mapper.SinalMacdDiarioMapper;
import com.ricardococati.repository.dao.sqlutil.SinalMacdDiarioSQLUtil;
import com.ricardococati.repository.util.SQLAppender;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class SinalMacdDiarioInserirDAOImpl implements SinalMacdDiarioInserirDAO {

  @Qualifier("namedParameterJdbcTemplate")
  private final NamedParameterJdbcTemplate template;

  private final GeraSequenciaDAOImpl genericDAO;
  private final SinalMacdDiarioSQLUtil sqlUtil;

  @Override
  public Boolean incluirSinalMacd(final SinalMacdDiario sinalMacdDiario) {
    if (isNull(sinalMacdDiario)
        || isNull(sinalMacdDiario.getDtpreg())
        || isNull(sinalMacdDiario.getSinalMacd())
        || isNull(sinalMacdDiario.getSinalMacd().getCodneg())) {
      throw new DataIntegrityViolationException(
          "Violação de integridade na inserção de SINAL_MACD_DIARIO");
    }
    int retorno;
    try {
      sinalMacdDiario.setIdSinalMacdDiario(
          genericDAO.getSequence("SINAL_MACD_DIARIO_SEQ").longValue()
      );
      retorno = template.update(sqlUtil.getInsert(), sqlUtil.toParameters(sinalMacdDiario));
    } catch (Exception ex) {
      log.error("Erro na execução do método incluir SINAL_MACD_DIARIO: " + ex.getMessage());
      throw ex;
    }
    return retorno > 0;
  }

}
