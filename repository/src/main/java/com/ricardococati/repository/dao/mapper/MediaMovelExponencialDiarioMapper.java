package com.ricardococati.repository.dao.mapper;

import static java.util.Objects.nonNull;

import com.ricardococati.model.dto.MediaMovelExponencial;
import com.ricardococati.model.dto.MediaMovelExponencialDiario;
import com.ricardococati.model.dto.MediaMovelExponencialSemanal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import org.springframework.stereotype.Service;

@Service
public class MediaMovelExponencialDiarioMapper {

  public MediaMovelExponencialDiario mapper(ResultSet rs) {
    try {
      return MediaMovelExponencialDiario
          .builder()
          .idMediaMovelExponencialDiario(rs.getLong("id_media_movel_exponencial"))
          .dtpreg(parseDateWithoutNull(rs , "dtpreg"))
          .mediaMovelExponencial(
              MediaMovelExponencial
                  .builder()
                  .codneg(rs.getString("codneg"))
                  .premedult(rs.getBigDecimal("premedult"))
                  .periodo(rs.getInt("periodo"))
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
