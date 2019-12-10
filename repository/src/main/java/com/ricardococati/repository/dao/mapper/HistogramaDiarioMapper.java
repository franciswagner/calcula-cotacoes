package com.ricardococati.repository.dao.mapper;

import static java.util.Objects.nonNull;

import com.ricardococati.model.dto.Histograma;
import com.ricardococati.model.dto.HistogramaDiario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import org.springframework.stereotype.Service;

@Service
public class HistogramaDiarioMapper {

  public HistogramaDiario mapper(ResultSet rs) {
    try {
      return HistogramaDiario
          .builder()
          .idHistogramaDiario(rs.getLong("id_sinal_macd"))
          .dtpreg(parseDateWithoutNull(rs, "dtpreg"))
          .histograma(
              Histograma
                  .builder()
                  .codneg(rs.getString("codneg"))
                  .prehist(rs.getBigDecimal("prehist"))
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
