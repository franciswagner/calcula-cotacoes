package com.ricardococati.repository.dao.mapper;

import static com.ricardococati.repository.util.TratamentoResultSetCampoData.retornaDataSeResultSetContemDataSenaoRetornaNulo;

import com.ricardococati.model.dto.MediaMovelExponencial;
import com.ricardococati.model.dto.MediaMovelExponencialSemanal;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Service;

@Service
public class MediaMovelExponencialSemanalMapper {

  public MediaMovelExponencialSemanal mapperSemanal(ResultSet rs) {
    try {
      return MediaMovelExponencialSemanal
          .builder()
          .idMediaMovelExponencialSemanal(rs.getLong("id_media_movel_exponencial"))
          .dtpregini(retornaDataSeResultSetContemDataSenaoRetornaNulo(rs , "dtpregini"))
          .dtpregfim(retornaDataSeResultSetContemDataSenaoRetornaNulo(rs , "dtpregfim"))
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

}
