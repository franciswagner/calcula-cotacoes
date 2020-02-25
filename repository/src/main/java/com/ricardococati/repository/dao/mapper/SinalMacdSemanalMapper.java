package com.ricardococati.repository.dao.mapper;

import static com.ricardococati.repository.util.TratamentoResultSetCampoData.retornaDataSeResultSetContemDataSenaoRetornaNulo;

import com.ricardococati.model.dto.SinalMacd;
import com.ricardococati.model.dto.SinalMacdSemanal;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Service;

@Service
public class SinalMacdSemanalMapper {

  public SinalMacdSemanal mapper(ResultSet rs) {
    try {
      return SinalMacdSemanal
          .builder()
          .idSinalMacdSemanal(rs.getLong("id_sinal_macd"))
          .dtpregini(retornaDataSeResultSetContemDataSenaoRetornaNulo(rs , "dtpregini"))
          .dtpregfim(retornaDataSeResultSetContemDataSenaoRetornaNulo(rs , "dtpregfim"))
          .sinalMacd(
              SinalMacd
                  .builder()
                  .codneg(rs.getString("codneg"))
                  .presinal(rs.getBigDecimal("presinal"))
                  .build())
          .build();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

}
