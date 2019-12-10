package com.ricardococati.repository.dao.mapper;

import static java.util.Objects.nonNull;

import com.ricardococati.model.dto.SinalMacd;
import com.ricardococati.model.dto.SinalMacdDiario;
import com.ricardococati.model.dto.SinalMacdSemanal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import org.springframework.stereotype.Service;

@Service
public class SinalMacdSemanalMapper {

  public SinalMacdSemanal mapper(ResultSet rs) {
    try {
      return SinalMacdSemanal
          .builder()
          .idSinalMacdSemanal(rs.getLong("id_sinal_macd"))
          .dtpregini(parseDateWithoutNull(rs , "dtpregini"))
          .dtpregfim(parseDateWithoutNull(rs , "dtpregfim"))
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

  public LocalDate parseDateWithoutNull(ResultSet rs, String stringData)
      throws SQLException {
    LocalDate date = null;
    if (nonNull(rs.getDate(stringData))) {
      date = rs.getDate(stringData).toLocalDate();
    }
    return date;
  }

}
