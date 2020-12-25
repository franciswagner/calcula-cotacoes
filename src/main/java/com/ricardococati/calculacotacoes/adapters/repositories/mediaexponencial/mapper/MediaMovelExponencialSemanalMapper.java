package com.ricardococati.calculacotacoes.adapters.repositories.mediaexponencial.mapper;

import static com.ricardococati.calculacotacoes.adapters.repositories.utils.TratamentoResultSetCampoData.retornaDataSeResultSetContemDataSenaoRetornaNulo;

import com.ricardococati.calculacotacoes.entities.domains.mediaexponencial.MediaMovelExponencial;
import com.ricardococati.calculacotacoes.entities.domains.mediaexponencial.MediaMovelExponencialSemanal;
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
