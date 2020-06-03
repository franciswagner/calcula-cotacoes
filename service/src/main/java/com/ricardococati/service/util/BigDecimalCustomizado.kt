package com.ricardococati.service.util

import java.math.BigDecimal
import java.math.RoundingMode

object BigDecimalCustomizado {
    @JvmStatic
    fun getDoubleValueBigDecimalHalfUpArredondado4Casas(
            valorDouble: Double?): BigDecimal {
        return BigDecimal(valorDouble!!).setScale(4, RoundingMode.HALF_UP)
    }

    @JvmStatic
    fun getValueBigDecimalHalfUpArredondado4Casas(
            valorDouble: BigDecimal): BigDecimal {
        return valorDouble.setScale(4, RoundingMode.HALF_UP)
    }
}