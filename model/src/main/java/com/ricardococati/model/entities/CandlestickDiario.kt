package com.ricardococati.model.entities

import java.time.LocalDate

class CandlestickDiario {
    var idCandleDiario: Long? = null
    var dtpreg: LocalDate? = null
    var candlestick: Candlestick? = null

    constructor(idCandleDiario: Long?, dtpreg: LocalDate?, candlestick: Candlestick?) {
        this.idCandleDiario = idCandleDiario
        this.dtpreg = dtpreg
        this.candlestick = candlestick
    }

    constructor() {}

    override fun equals(o: Any?): Boolean {
        if (o === this) {
            return true
        }
        if (o !is CandlestickDiario) {
            return false
        }
        val other = o
        if (!other.canEqual(this as Any)) {
            return false
        }
        val `this$idCandleDiario`: Any? = idCandleDiario
        val `other$idCandleDiario`: Any? = other.idCandleDiario
        if (if (`this$idCandleDiario` == null) `other$idCandleDiario` != null else `this$idCandleDiario` != `other$idCandleDiario`) {
            return false
        }
        val `this$dtpreg`: Any? = dtpreg
        val `other$dtpreg`: Any? = other.dtpreg
        if (if (`this$dtpreg` == null) `other$dtpreg` != null else `this$dtpreg` != `other$dtpreg`) {
            return false
        }
        val `this$candlestick`: Any? = candlestick
        val `other$candlestick`: Any? = other.candlestick
        return if (if (`this$candlestick` == null) `other$candlestick` != null else `this$candlestick` != `other$candlestick`) {
            false
        } else true
    }

    protected fun canEqual(other: Any?): Boolean {
        return other is CandlestickDiario
    }

    override fun hashCode(): Int {
        val PRIME = 59
        var result = 1
        val `$idCandleDiario`: Any? = idCandleDiario
        result = result * PRIME + (`$idCandleDiario`?.hashCode() ?: 43)
        val `$dtpreg`: Any? = dtpreg
        result = result * PRIME + (`$dtpreg`?.hashCode() ?: 43)
        val `$candlestick`: Any? = candlestick
        result = result * PRIME + (`$candlestick`?.hashCode() ?: 43)
        return result
    }

    override fun toString(): String {
        return "CandlestickDiario(idCandleDiario=" + idCandleDiario + ", dtpreg=" + dtpreg + ", candlestick=" + candlestick + ")"
    }

    class CandlestickDiarioBuilder internal constructor() {
        private var idCandleDiario: Long? = null
        private var dtpreg: LocalDate? = null
        private var candlestick: Candlestick? = null
        fun idCandleDiario(idCandleDiario: Long?): CandlestickDiarioBuilder {
            this.idCandleDiario = idCandleDiario
            return this
        }

        fun dtpreg(dtpreg: LocalDate?): CandlestickDiarioBuilder {
            this.dtpreg = dtpreg
            return this
        }

        fun candlestick(candlestick: Candlestick?): CandlestickDiarioBuilder {
            this.candlestick = candlestick
            return this
        }

        fun build(): CandlestickDiario {
            return CandlestickDiario(idCandleDiario, dtpreg, candlestick)
        }

        override fun toString(): String {
            return ("CandlestickDiario.CandlestickDiarioBuilder(idCandleDiario=" + idCandleDiario
                    + ", dtpreg=" + dtpreg + ", candlestick=" + candlestick + ")")
        }
    }

    companion object {
        @kotlin.jvm.JvmStatic
        fun builder(): CandlestickDiarioBuilder {
            return CandlestickDiarioBuilder()
        }
    }
}