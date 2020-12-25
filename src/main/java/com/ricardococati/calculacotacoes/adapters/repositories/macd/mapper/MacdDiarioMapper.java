package com.ricardococati.calculacotacoes.adapters.repositories.macd.mapper;

import static com.ricardococati.calculacotacoes.adapters.repositories.utils.TratamentoResultSetCampoData.retornaDataSeResultSetContemDataSenaoRetornaNulo;

import com.ricardococati.calculacotacoes.entities.domains.macd.Macd;
import com.ricardococati.calculacotacoes.entities.domains.macd.MacdDiario;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Service;

@Service
public class MacdDiarioMapper {

  public MacdDiario mapper(ResultSet rs) {
    try {
      return MacdDiario
          .builder()
          .idMacdDiario(rs.getLong("id_macd"))
          .dtpreg(retornaDataSeResultSetContemDataSenaoRetornaNulo(rs , "dtpreg"))
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
