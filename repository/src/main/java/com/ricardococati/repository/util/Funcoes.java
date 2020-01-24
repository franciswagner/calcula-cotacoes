package com.ricardococati.repository.util;

import static java.util.Objects.nonNull;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class Funcoes {

  public static LocalDate parseDateWithoutNull(ResultSet rs, String stringData)
      throws SQLException {
    LocalDate date = null;
    if (nonNull(rs.getDate(stringData))) {
      date = rs.getDate(stringData).toLocalDate();
    }
    return date;
  }

}
