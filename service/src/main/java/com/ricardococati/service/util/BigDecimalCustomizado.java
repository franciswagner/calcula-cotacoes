package com.ricardococati.service.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalCustomizado {

  public static BigDecimal getDoubleValueBigDecimalHalfUpArredondado4Casas(
      final Double valorDouble) {
    return new BigDecimal(valorDouble).setScale(4, RoundingMode.HALF_UP);
  }

  public static BigDecimal getValueBigDecimalHalfUpArredondado4Casas(
      final BigDecimal valorDouble) {
    return valorDouble.setScale(4, RoundingMode.HALF_UP);
  }

}