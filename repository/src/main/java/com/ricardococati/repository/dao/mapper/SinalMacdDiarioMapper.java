package com.ricardococati.repository.dao.mapper;

import static com.ricardococati.repository.util.Funcoes.parseDateWithoutNull;

import com.ricardococati.model.dto.SinalMacd;
import com.ricardococati.model.dto.SinalMacdDiario;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Service;

@Service
public class SinalMacdDiarioMapper {

  public SinalMacdDiario mapper(ResultSet rs) {
    try {
      return SinalMacdDiario
          .builder()
          .idSinalMacdDiario(rs.getLong("id_sinal_macd"))
          .dtpreg(parseDateWithoutNull(rs , "dtpreg"))
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
