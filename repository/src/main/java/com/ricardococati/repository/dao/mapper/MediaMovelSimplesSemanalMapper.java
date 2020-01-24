package com.ricardococati.repository.dao.mapper;

import static com.ricardococati.repository.util.Funcoes.parseDateWithoutNull;

import com.ricardococati.model.dto.MediaMovelSimples;
import com.ricardococati.model.dto.MediaMovelSimplesSemanal;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Service;

@Service
public class MediaMovelSimplesSemanalMapper {

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

}
