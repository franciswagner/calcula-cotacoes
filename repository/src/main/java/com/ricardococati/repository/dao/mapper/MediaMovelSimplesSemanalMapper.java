package com.ricardococati.repository.dao.mapper;

import static java.util.Objects.nonNull;

import com.ricardococati.model.dto.MediaMovelSimples;
import com.ricardococati.model.dto.MediaMovelSimplesSemanal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import org.springframework.stereotype.Service;

@Service
public class MediaMovelSimplesSemanalMapper {

  public String mapperCodNeg(ResultSet rs) {
    try {
      return rs.getString("codneg");
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public MediaMovelSimplesSemanal mapper(ResultSet rs) {
    try {
      return MediaMovelSimplesSemanal
          .builder()
          .idMediaMovelSimplesSemanal(rs.getLong("id_media_movel_simples"))
          .dtpregini(parseDateWithoutNull(rs, "dtpregini"))
          .dtpregfim(parseDateWithoutNull(rs, "dtpregfim"))
          .mediaMovelSimples(
              MediaMovelSimples
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
