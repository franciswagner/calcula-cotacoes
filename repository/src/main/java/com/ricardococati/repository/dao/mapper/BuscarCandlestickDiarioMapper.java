package com.ricardococati.repository.dao.mapper;

import static com.ricardococati.repository.util.TratamentoResultSetCampoData.retornaDataSeResultSetContemDataSenaoRetornaNulo;

import com.ricardococati.model.dto.CandlestickDTO;
import com.ricardococati.model.dto.CandlestickDiarioDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
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
          .dtpreg(retornaDataSeResultSetContemDataSenaoRetornaNulo(rs, "dtpreg"))
          .candlestickDTO(
              CandlestickDTO
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
