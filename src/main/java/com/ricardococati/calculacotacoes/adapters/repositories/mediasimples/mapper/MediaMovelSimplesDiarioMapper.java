package com.ricardococati.calculacotacoes.adapters.repositories.mediasimples.mapper;

import static com.ricardococati.calculacotacoes.adapters.repositories.utils.TratamentoResultSetCampoData.retornaDataSeResultSetContemDataSenaoRetornaNulo;

import com.ricardococati.calculacotacoes.entities.domains.mediasimples.MediaMovelSimples;
import com.ricardococati.calculacotacoes.entities.domains.mediasimples.MediaMovelSimplesDiario;
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
          .dtpreg(retornaDataSeResultSetContemDataSenaoRetornaNulo(rs, "dtpreg"))
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
