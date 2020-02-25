package com.ricardococati.repository.dao.mapper;

import static com.ricardococati.repository.util.TratamentoResultSetCampoData.retornaDataSeResultSetContemDataSenaoRetornaNulo;

import com.ricardococati.model.dto.Macd;
import com.ricardococati.model.dto.MacdDiario;
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
