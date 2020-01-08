package com.ricardococati.repository.dao.mapper;

import static java.util.Objects.nonNull;

import com.ricardococati.model.dto.CandlestickDTO;
import com.ricardococati.model.dto.CandlestickDiarioDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import org.springframework.stereotype.Service;

@Service
public class BuscarCandlestickDiarioMapper {

  public String mapperCodNeg(ResultSet rs) {
    try {
      return rs.getString("codneg");
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public CandlestickDiarioDTO mapper(ResultSet rs) {
    try {
      return CandlestickDiarioDTO
          .builder()
          .idCandleDiario(rs.getLong("id_candle_diario"))
          .dtpreg(parseDateWithoutNull(rs, "dtpreg"))
          .candlestickDTO(
              CandlestickDTO
                  .builder()
                  .codneg(rs.getString("codneg"))
                  .mediaMovelGerada(rs.getBoolean("media_movel_gerada"))
                  .mediaExponencialGerada(rs.getBoolean("media_exponecial_gerada"))
                  .macdGerada(rs.getBoolean("macd_gerada"))
                  .sinalMacdGerada(rs.getBoolean("sinal_macd_gerada"))
                  .histogramaGerada(rs.getBoolean("histograma_gerada"))
                  .preabe(rs.getBigDecimal("preabe"))
                  .premax(rs.getBigDecimal("premax"))
                  .premin(rs.getBigDecimal("premin"))
                  .preult(rs.getBigDecimal("preult"))
                  .semana(rs.getInt("semana"))
                  .voltot(rs.getBigDecimal("voltot"))
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
