package com.ricardococati.repository.dao.mapper;

import static com.ricardococati.repository.util.TratamentoResultSetCampoData.retornaDataSeResultSetContemDataSenaoRetornaNulo;

import com.ricardococati.model.dto.Macd;
import com.ricardococati.model.dto.MacdSemanal;
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
