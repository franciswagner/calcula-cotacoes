package com.ricardococati.model.entities

import java.math.BigDecimal

class Candlestick {
    var codneg: String? = null
    var preabe: BigDecimal? = null
    var premax: BigDecimal? = null
    var premin: BigDecimal? = null
    var preult: BigDecimal? = null
    var voltot: BigDecimal? = null
    var semana: Int? = null

    constructor(codneg: String?, preabe: BigDecimal?, premax: BigDecimal?, premin: BigDecimal?,
                preult: BigDecimal?, voltot: BigDecimal?, semana: Int?) {
        this.codneg = codneg
        this.preabe = preabe
        this.premax = premax
        this.premin = premin
        this.preult = preult
        this.voltot = voltot
        this.semana = semana
    }

    constructor() {}

    override fun equals(o: Any?): Boolean {
        if (o === this) {
            return true
        }
        if (o !is Candlestick) {
            return false
        }
        val other = o
        if (!other.canEqual(this as Any)) {
            return false
        }
        val `this$codneg`: Any? = codneg
        val `other$codneg`: Any? = other.codneg
        if (if (`this$codneg` == null) `other$codneg` != null else `this$codneg` != `other$codneg`) {
            return false
        }
        val `this$preabe`: Any? = preabe
        val `other$preabe`: Any? = other.preabe
        if (if (`this$preabe` == null) `other$preabe` != null else `this$preabe` != `other$preabe`) {
            return false
        }
        val `this$premax`: Any? = premax
        val `other$premax`: Any? = other.premax
        if (if (`this$premax` == null) `other$premax` != null else `this$premax` != `other$premax`) {
            return false
        }
        val `this$premin`: Any? = premin
        val `other$premin`: Any? = other.premin
        if (if (`this$premin` == null) `other$premin` != null else `this$premin` != `other$premin`) {
            return false
        }
        val `this$preult`: Any? = preult
        val `other$preult`: Any? = other.preult
        if (if (`this$preult` == null) `other$preult` != null else `this$preult` != `other$preult`) {
            return false
        }
        val `this$voltot`: Any? = voltot
        val `other$voltot`: Any? = other.voltot
        if (if (`this$voltot` == null) `other$voltot` != null else `this$voltot` != `other$voltot`) {
            return false
        }
        val `this$semana`: Any? = semana
        val `other$semana`: Any? = other.semana
        return if (if (`this$semana` == null) `other$semana` != null else `this$semana` != `other$semana`) {
            false
        } else true
    }

    protected fun canEqual(other: Any?): Boolean {
        return other is Candlestick
    }

    override fun hashCode(): Int {
        val PRIME = 59
        var result = 1
        val `$codneg`: Any? = codneg
        result = result * PRIME + (`$codneg`?.hashCode() ?: 43)
        val `$preabe`: Any? = preabe
        result = result * PRIME + (`$preabe`?.hashCode() ?: 43)
        val `$premax`: Any? = premax
        result = result * PRIME + (`$premax`?.hashCode() ?: 43)
        val `$premin`: Any? = premin
        result = result * PRIME + (`$premin`?.hashCode() ?: 43)
        val `$preult`: Any? = preult
        result = result * PRIME + (`$preult`?.hashCode() ?: 43)
        val `$voltot`: Any? = voltot
        result = result * PRIME + (`$voltot`?.hashCode() ?: 43)
        val `$semana`: Any? = semana
        result = result * PRIME + (`$semana`?.hashCode() ?: 43)
        return result
    }

    override fun toString(): String {
        return ("Candlestick(codneg=" + codneg + ", preabe=" + preabe + ", premax="
                + premax + ", premin=" + premin + ", preult=" + preult
                + ", voltot=" + voltot + ", semana=" + semana + ")")
    }

    class CandlestickBuilder internal constructor() {
        private var codneg: String? = null
        private var preabe: BigDecimal? = null
        private var premax: BigDecimal? = null
        private var premin: BigDecimal? = null
        private var preult: BigDecimal? = null
        private var voltot: BigDecimal? = null
        private var semana: Int? = null
        fun codneg(codneg: String?): CandlestickBuilder {
            this.codneg = codneg
            return this
        }

        fun preabe(preabe: BigDecimal?): CandlestickBuilder {
            this.preabe = preabe
            return this
        }

        fun premax(premax: BigDecimal?): CandlestickBuilder {
            this.premax = premax
            return this
        }

        fun premin(premin: BigDecimal?): CandlestickBuilder {
            this.premin = premin
            return this
        }

        fun preult(preult: BigDecimal?): CandlestickBuilder {
            this.preult = preult
            return this
        }

        fun voltot(voltot: BigDecimal?): CandlestickBuilder {
            this.voltot = voltot
            return this
        }

        fun semana(semana: Int?): CandlestickBuilder {
            this.semana = semana
            return this
        }

        fun build(): Candlestick {
            return Candlestick(codneg, preabe, premax, premin, preult, voltot, semana)
        }

        override fun toString(): String {
            return ("Candlestick.CandlestickBuilder(codneg=" + codneg + ", preabe=" + preabe
                    + ", premax=" + premax + ", premin=" + premin + ", preult=" + preult
                    + ", voltot=" + voltot + ", semana=" + semana + ")")
        }
    }

    companion object {
        @kotlin.jvm.JvmStatic
        fun builder(): CandlestickBuilder {
            return CandlestickBuilder()
        }
    }
}