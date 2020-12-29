package com.ricardococati.calculacotacoes.utils.geral;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalCustomizado {

  public static BigDecimal sendDoubleGetValueBigDecimalArredonda4Casas(
      final Double valorDouble) {
    return new BigDecimal(valorDouble).setScale(4, RoundingMode.HALF_UP);
  }

  public static BigDecimal sendBigDecimalGetValueBigDecimalArredonda4Casas(
      final BigDecimal valorDouble) {
    return valorDouble.setScale(4, RoundingMode.HALF_UP);
  }

}
