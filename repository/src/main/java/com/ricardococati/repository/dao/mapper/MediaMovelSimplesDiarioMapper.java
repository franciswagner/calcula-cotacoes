package com.ricardococati.repository.dao.mapper;

import static com.ricardococati.repository.util.Funcoes.parseDateWithoutNull;

import com.ricardococati.model.dto.MediaMovelSimples;
import com.ricardococati.model.dto.MediaMovelSimplesDiario;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Service;

@Service
public class MediaMovelSimplesDiarioMapper {

  public MediaMovelSimplesDiario mapper(ResultSet rs) {
    try {
      return MediaMovelSimplesDiario
          .builder()
          .idMediaMovelSimplesDiario(rs.getLong("id_media_movel_simples"))
          .dtpreg(parseDateWithoutNull(rs, "dtpreg"))
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
