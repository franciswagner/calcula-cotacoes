package com.ricardococati.calculacotacoes.adapters.repositories.mediasimples.mapper;

import static com.ricardococati.calculacotacoes.utils.data.TratamentoResultSetCampoData.retornaDataSeResultSetContemDataSenaoRetornaNulo;

import com.ricardococati.calculacotacoes.entities.domains.mediasimples.MediaMovelSimples;
import com.ricardococati.calculacotacoes.entities.domains.mediasimples.MediaMovelSimplesSemanal;
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
          .dtpregini(retornaDataSeResultSetContemDataSenaoRetornaNulo(rs, "dtpregini"))
          .dtpregfim(retornaDataSeResultSetContemDataSenaoRetornaNulo(rs, "dtpregfim"))
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
