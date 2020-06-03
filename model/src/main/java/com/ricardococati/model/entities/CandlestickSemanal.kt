package com.ricardococati.model.entities

import java.time.LocalDate

class CandlestickSemanal {
    var idCandleSemanal: Long? = null
    var dtpregini: LocalDate? = null
    var dtpregfim: LocalDate? = null
    var candlestick: Candlestick? = null

    constructor(idCandleSemanal: Long?, dtpregini: LocalDate?, dtpregfim: LocalDate?,
                candlestick: Candlestick?) {
        this.idCandleSemanal = idCandleSemanal
        this.dtpregini = dtpregini
        this.dtpregfim = dtpregfim
        this.candlestick = candlestick
    }

    constructor() {}

    override fun equals(o: Any?): Boolean {
        if (o === this) {
            return true
        }
        if (o !is CandlestickSemanal) {
            return false
        }
        val other = o
        if (!other.canEqual(this as Any)) {
            return false
        }
        val `this$idCandleSemanal`: Any? = idCandleSemanal
        val `other$idCandleSemanal`: Any? = other.idCandleSemanal
        if (if (`this$idCandleSemanal` == null) `other$idCandleSemanal` != null else `this$idCandleSemanal` != `other$idCandleSemanal`) {
            return false
        }
        val `this$dtpregini`: Any? = dtpregini
        val `other$dtpregini`: Any? = other.dtpregini
        if (if (`this$dtpregini` == null) `other$dtpregini` != null else `this$dtpregini` != `other$dtpregini`) {
            return false
        }
        val `this$dtpregfim`: Any? = dtpregfim
        val `other$dtpregfim`: Any? = other.dtpregfim
        if (if (`this$dtpregfim` == null) `other$dtpregfim` != null else `this$dtpregfim` != `other$dtpregfim`) {
            return false
        }
        val `this$candlestick`: Any? = candlestick
        val `other$candlestick`: Any? = other.candlestick
        return if (if (`this$candlestick` == null) `other$candlestick` != null else `this$candlestick` != `other$candlestick`) {
            false
        } else true
    }

    protected fun canEqual(other: Any?): Boolean {
        return other is CandlestickSemanal
    }

    override fun hashCode(): Int {
        val PRIME = 59
        var result = 1
        val `$idCandleSemanal`: Any? = idCandleSemanal
        result = result * PRIME + (`$idCandleSemanal`?.hashCode() ?: 43)
        val `$dtpregini`: Any? = dtpregini
        result = result * PRIME + (`$dtpregini`?.hashCode() ?: 43)
        val `$dtpregfim`: Any? = dtpregfim
        result = result * PRIME + (`$dtpregfim`?.hashCode() ?: 43)
        val `$candlestick`: Any? = candlestick
        result = result * PRIME + (`$candlestick`?.hashCode() ?: 43)
        return result
    }

    override fun toString(): String {
        return "CandlestickSemanal(idCandleSemanal=" + idCandleSemanal + ", dtpregini=" + dtpregini + ", dtpregfim=" + dtpregfim + ", candlestick=" + candlestick + ")"
    }

    class CandlestickSemanalBuilder internal constructor() {
        private var idCandleSemanal: Long? = null
        private var dtpregini: LocalDate? = null
        private var dtpregfim: LocalDate? = null
        private var candlestick: Candlestick? = null
        fun idCandleSemanal(idCandleSemanal: Long?): CandlestickSemanalBuilder {
            this.idCandleSemanal = idCandleSemanal
            return this
        }

        fun dtpregini(dtpregini: LocalDate?): CandlestickSemanalBuilder {
            this.dtpregini = dtpregini
            return this
        }

        fun dtpregfim(dtpregfim: LocalDate?): CandlestickSemanalBuilder {
            this.dtpregfim = dtpregfim
            return this
        }

        fun candlestick(candlestick: Candlestick?): CandlestickSemanalBuilder {
            this.candlestick = candlestick
            return this
        }

        fun build(): CandlestickSemanal {
            return CandlestickSemanal(idCandleSemanal, dtpregini, dtpregfim, candlestick)
        }

        override fun toString(): String {
            return ("CandlestickSemanal.CandlestickSemanalBuilder(idCandleSemanal=" + idCandleSemanal
                    + ", dtpregini=" + dtpregini + ", dtpregfim=" + dtpregfim + ", candlestick="
                    + candlestick + ")")
        }
    }

    companion object {
        @kotlin.jvm.JvmStatic
        fun builder(): CandlestickSemanalBuilder {
            return CandlestickSemanalBuilder()
        }
    }
}