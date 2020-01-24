package com.ricardococati.repository.dao.mapper;

import static com.ricardococati.repository.util.Funcoes.parseDateWithoutNull;

import com.ricardococati.model.dto.CandlestickDTO;
import com.ricardococati.model.dto.CandlestickSemanalDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Service;

@Service
public class BuscarCandlestickSemanalMapper {

  public String mapperCodNeg(ResultSet rs) {
    try {
      return rs.getString("codneg");
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public CandlestickSemanalDTO mapper(ResultSet rs) {
    try {
      return CandlestickSemanalDTO
          .builder()
          .idCandleSemanal(rs.getLong("id_candle_semanal"))
          .dtpregini(parseDateWithoutNull(rs, "dtpregini"))
          .dtpregfim(parseDateWithoutNull(rs, "dtpregfim"))
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

}
