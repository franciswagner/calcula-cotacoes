package com.ricardococati.calculacotacoes.adapters.repositories.sinalmacd.mapper;

import static com.ricardococati.calculacotacoes.utils.data.TratamentoResultSetCampoData.retornaDataSeResultSetContemDataSenaoRetornaNulo;

import com.ricardococati.calculacotacoes.entities.domains.sinalmacd.SinalMacd;
import com.ricardococati.calculacotacoes.entities.domains.sinalmacd.SinalMacdDiario;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Service;

@Service
public class SinalMacdDiarioMapper {

  public SinalMacdDiario mapper(ResultSet rs) {
    try {
      return SinalMacdDiario
          .builder()
          .idSinalMacdDiario(rs.getLong("id_sinal_macd"))
          .dtpreg(retornaDataSeResultSetContemDataSenaoRetornaNulo(rs , "dtpreg"))
          .sinalMacd(
              SinalMacd
                  .builder()
                  .codneg(rs.getString("codneg"))
                  .presinal(rs.getBigDecimal("presinal"))
                  .build())
          .build();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

}
