package com.ricardococati.model.entities

import java.time.LocalDate

class MacdDiario {
    var idMacdDiario: Long? = null
    var dtpreg: LocalDate? = null
    var macd: Macd? = null

    constructor(idMacdDiario: Long?, dtpreg: LocalDate?, macd: Macd?) {
        this.idMacdDiario = idMacdDiario
        this.dtpreg = dtpreg
        this.macd = macd
    }

    constructor() {}

    override fun equals(o: Any?): Boolean {
        if (o === this) {
            return true
        }
        if (o !is MacdDiario) {
            return false
        }
        val other = o
        if (!other.canEqual(this as Any)) {
            return false
        }
        val `this$idMacdDiario`: Any? = idMacdDiario
        val `other$idMacdDiario`: Any? = other.idMacdDiario
        if (if (`this$idMacdDiario` == null) `other$idMacdDiario` != null else `this$idMacdDiario` != `other$idMacdDiario`) {
            return false
        }
        val `this$dtpreg`: Any? = dtpreg
        val `other$dtpreg`: Any? = other.dtpreg
        if (if (`this$dtpreg` == null) `other$dtpreg` != null else `this$dtpreg` != `other$dtpreg`) {
            return false
        }
        val `this$macd`: Any? = macd
        val `other$macd`: Any? = other.macd
        return if (if (`this$macd` == null) `other$macd` != null else `this$macd` != `other$macd`) {
            false
        } else true
    }

    protected fun canEqual(other: Any?): Boolean {
        return other is MacdDiario
    }

    override fun hashCode(): Int {
        val PRIME = 59
        var result = 1
        val `$idMacdDiario`: Any? = idMacdDiario
        result = result * PRIME + (`$idMacdDiario`?.hashCode() ?: 43)
        val `$dtpreg`: Any? = dtpreg
        result = result * PRIME + (`$dtpreg`?.hashCode() ?: 43)
        val `$macd`: Any? = macd
        result = result * PRIME + (`$macd`?.hashCode() ?: 43)
        return result
    }

    override fun toString(): String {
        return ("MacdDiario(idMacdDiario=" + idMacdDiario + ", dtpreg=" + dtpreg
                + ", macd=" + macd + ")")
    }

    class MacdDiarioBuilder internal constructor() {
        private var idMacdDiario: Long? = null
        private var dtpreg: LocalDate? = null
        private var macd: Macd? = null
        fun idMacdDiario(idMacdDiario: Long?): MacdDiarioBuilder {
            this.idMacdDiario = idMacdDiario
            return this
        }

        fun dtpreg(dtpreg: LocalDate?): MacdDiarioBuilder {
            this.dtpreg = dtpreg
            return this
        }

        fun macd(macd: Macd?): MacdDiarioBuilder {
            this.macd = macd
            return this
        }

        fun build(): MacdDiario {
            return MacdDiario(idMacdDiario, dtpreg, macd)
        }

        override fun toString(): String {
            return ("MacdDiario.MacdDiarioBuilder(idMacdDiario=" + idMacdDiario + ", dtpreg="
                    + dtpreg + ", macd=" + macd + ")")
        }
    }

    companion object {
        @kotlin.jvm.JvmStatic
        fun builder(): MacdDiarioBuilder {
            return MacdDiarioBuilder()
        }
    }
}