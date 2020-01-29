package com.ricardococati.repository.dao.impl;

import com.ricardococati.model.dto.MacdSemanal;
import com.ricardococati.repository.dao.MacdSemanalBuscarDAO;
import com.ricardococati.repository.dao.MacdSemanalInserirDAO;
import com.ricardococati.repository.dao.mapper.MacdSemanalMapper;
import com.ricardococati.repository.dao.sqlutil.MacdSemanalSQLUtil;
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
public class MacdSemanalInserirDAOImpl implements MacdSemanalInserirDAO {

  @Qualifier("namedParameterJdbcTemplate")
  private final NamedParameterJdbcTemplate template;

  private final GeraSequenciaDAOImpl genericDAO;
  private final MacdSemanalSQLUtil sqlUtil;
  private final MacdSemanalMapper macdMapper;

  @Override
  public Boolean incluirMacd(List<MacdSemanal> macdList) {
    AtomicInteger retorno = new AtomicInteger(0);
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

}
