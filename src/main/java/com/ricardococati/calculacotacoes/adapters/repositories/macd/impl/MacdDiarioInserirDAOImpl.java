package com.ricardococati.calculacotacoes.adapters.repositories.macd.impl;

import static java.util.Objects.isNull;

import com.ricardococati.calculacotacoes.adapters.repositories.gerasequencia.impl.GeraSequenciaDAOImpl;
import com.ricardococati.calculacotacoes.adapters.repositories.macd.MacdDiarioInserirDAO;
import com.ricardococati.calculacotacoes.adapters.repositories.macd.sqlutil.MacdDiarioSQLUtil;
import com.ricardococati.calculacotacoes.entities.domains.macd.MacdDiario;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MacdDiarioInserirDAOImpl implements MacdDiarioInserirDAO {

  @Qualifier("namedParameterJdbcTemplate")
  private final NamedParameterJdbcTemplate template;

  private final GeraSequenciaDAOImpl genericDAO;
  private final MacdDiarioSQLUtil sqlUtil;

  @Override
  public Boolean incluirMacd(final MacdDiario macdDiario) {
    Integer retorno = 0;
    if (isNull(macdDiario)
        || isNull(macdDiario.getDtpreg())
        || isNull(macdDiario.getMacd().getCodneg())) {
      throw new DataIntegrityViolationException(
          "Violação de integridade na inserção de MACD_DIARIO");
    }
    try {
      macdDiario.setIdMacdDiario(
          genericDAO.getSequence("MACD_DIARIO_SEQ").longValue()
      );
      retorno = template.update(sqlUtil.getInsert(), sqlUtil.toParameters(macdDiario));
    } catch (Exception ex) {
      log.error("Erro na execução do método incluir MACD_DIARIO: " + ex.getMessage());
      throw ex;
    }
    return retorno > 0;
  }

}
