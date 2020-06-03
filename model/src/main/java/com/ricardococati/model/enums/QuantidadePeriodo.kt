package com.ricardococati.model.enums

import java.util.Arrays

enum class QuantidadePeriodo(val quantidade: Int) {

    FAST_9(9),
    FAST_12(12),
    FAST_13(13),
    SLOW_26(26),
    SLOW_100(100);

    companion object {
        @JvmStatic
        val listQuantidadePeriodo: List<Int>
            get() = Arrays.asList(
                    FAST_9.quantidade,
                    FAST_12.quantidade,
                    FAST_13.quantidade,
                    SLOW_26.quantidade,
                    SLOW_100.quantidade
            )
    }

}