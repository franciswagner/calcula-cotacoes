package com.ricardococati.calculacotacoes.adapters.repositories.macd.mapper;

import static com.ricardococati.calculacotacoes.adapters.repositories.utils.TratamentoResultSetCampoData.retornaDataSeResultSetContemDataSenaoRetornaNulo;

import com.ricardococati.calculacotacoes.entities.domains.macd.Macd;
import com.ricardococati.calculacotacoes.entities.domains.macd.MacdSemanal;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Service;

@Service
public class MacdSemanalMapper {

  public MacdSemanal mapper(ResultSet rs) {
    try {
      return MacdSemanal
          .builder()
          .idMacdSemanal(rs.getLong("id_macd"))
          .dtpregini(retornaDataSeResultSetContemDataSenaoRetornaNulo(rs , "dtpregini"))
          .dtpregfim(retornaDataSeResultSetContemDataSenaoRetornaNulo(rs , "dtpregfim"))
          .macd(
              Macd
                  .builder()
                  .codneg(rs.getString("codneg"))
                  .premacd(rs.getBigDecimal("premacd"))
                  .build())
          .build();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

}
