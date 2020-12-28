package com.ricardococati.calculacotacoes.utils.data;

import static java.util.Objects.nonNull;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class TratamentoResultSetCampoData {

  public static LocalDate retornaDataSeResultSetContemDataSenaoRetornaNulo(
      final ResultSet rs,
      final String stringData
  ) throws SQLException {
    LocalDate date = null;
    if (nonNull(rs.getDate(stringData))) {
      date = rs.getDate(stringData).toLocalDate();
    }
    return date;
  }

}
