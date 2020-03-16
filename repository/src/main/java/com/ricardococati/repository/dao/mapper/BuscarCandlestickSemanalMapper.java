package com.ricardococati.repository.dao.mapper;

import static com.ricardococati.repository.util.TratamentoResultSetCampoData.retornaDataSeResultSetContemDataSenaoRetornaNulo;

import com.ricardococati.model.entities.Candlestick;
import com.ricardococati.model.entities.CandlestickSemanal;
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

  public CandlestickSemanal mapper(ResultSet rs) {
    try {
      return CandlestickSemanal
          .builder()
          .idCandleSemanal(rs.getLong("id_candle_semanal"))
          .dtpregini(retornaDataSeResultSetContemDataSenaoRetornaNulo(rs, "dtpregini"))
          .dtpregfim(retornaDataSeResultSetContemDataSenaoRetornaNulo(rs, "dtpregfim"))
          .candlestick(
              Candlestick
                  .builder()
                  .codneg(rs.getString("codneg"))
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
