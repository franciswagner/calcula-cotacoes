package com.ricardococati.calculacotacoes.adapters.repositories.mediaexponencial.mapper;

import static com.ricardococati.calculacotacoes.adapters.repositories.utils.TratamentoResultSetCampoData.retornaDataSeResultSetContemDataSenaoRetornaNulo;

import com.ricardococati.calculacotacoes.entities.domains.mediaexponencial.MediaMovelExponencial;
import com.ricardococati.calculacotacoes.entities.domains.mediaexponencial.MediaMovelExponencialDiario;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Service;

@Service
public class MediaMovelExponencialDiarioMapper {

  public MediaMovelExponencialDiario mapper(ResultSet rs) {
    try {
      return MediaMovelExponencialDiario
          .builder()
          .idMediaMovelExponencialDiario(rs.getLong("id_media_movel_exponencial"))
          .dtpreg(retornaDataSeResultSetContemDataSenaoRetornaNulo(rs , "dtpreg"))
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
