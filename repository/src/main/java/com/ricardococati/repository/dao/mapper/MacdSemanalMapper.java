package com.ricardococati.repository.dao.mapper;

import static java.util.Objects.nonNull;

import com.ricardococati.model.dto.Macd;
import com.ricardococati.model.dto.MacdDiario;
import com.ricardococati.model.dto.MacdSemanal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import org.springframework.stereotype.Service;

@Service
public class MacdSemanalMapper {

  public MacdSemanal mapper(ResultSet rs) {
    try {
      return MacdSemanal
          .builder()
          .idMacdSemanal(rs.getLong("id_macd"))
          .dtpregini(parseDateWithoutNull(rs , "dtpregini"))
          .dtpregfim(parseDateWithoutNull(rs , "dtpregfim"))
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

  public LocalDate parseDateWithoutNull(ResultSet rs, String stringData)
      throws SQLException {
    LocalDate date = null;
    if (nonNull(rs.getDate(stringData))) {
      date = rs.getDate(stringData).toLocalDate();
    }
    return date;
  }

}
