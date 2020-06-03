package com.ricardococati.model.entities

import java.time.LocalDate

class MacdSemanal {
    var idMacdSemanal: Long? = null
    var dtpregini: LocalDate? = null
    var dtpregfim: LocalDate? = null
    var macd: Macd? = null

    constructor(idMacdSemanal: Long?, dtpregini: LocalDate?, dtpregfim: LocalDate?, macd: Macd?) {
        this.idMacdSemanal = idMacdSemanal
        this.dtpregini = dtpregini
        this.dtpregfim = dtpregfim
        this.macd = macd
    }

    constructor() {}

    override fun equals(o: Any?): Boolean {
        if (o === this) {
            return true
        }
        if (o !is MacdSemanal) {
            return false
        }
        val other = o
        if (!other.canEqual(this as Any)) {
            return false
        }
        val `this$idMacdSemanal`: Any? = idMacdSemanal
        val `other$idMacdSemanal`: Any? = other.idMacdSemanal
        if (if (`this$idMacdSemanal` == null) `other$idMacdSemanal` != null else `this$idMacdSemanal` != `other$idMacdSemanal`) {
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
        val `this$macd`: Any? = macd
        val `other$macd`: Any? = other.macd
        return if (if (`this$macd` == null) `other$macd` != null else `this$macd` != `other$macd`) {
            false
        } else true
    }

    protected fun canEqual(other: Any?): Boolean {
        return other is MacdSemanal
    }

    override fun hashCode(): Int {
        val PRIME = 59
        var result = 1
        val `$idMacdSemanal`: Any? = idMacdSemanal
        result = result * PRIME + (`$idMacdSemanal`?.hashCode() ?: 43)
        val `$dtpregini`: Any? = dtpregini
        result = result * PRIME + (`$dtpregini`?.hashCode() ?: 43)
        val `$dtpregfim`: Any? = dtpregfim
        result = result * PRIME + (`$dtpregfim`?.hashCode() ?: 43)
        val `$macd`: Any? = macd
        result = result * PRIME + (`$macd`?.hashCode() ?: 43)
        return result
    }

    override fun toString(): String {
        return "MacdSemanal(idMacdSemanal=" + idMacdSemanal + ", dtpregini=" + dtpregini + ", dtpregfim=" + dtpregfim + ", macd=" + macd + ")"
    }

    class MacdSemanalBuilder internal constructor() {
        private var idMacdSemanal: Long? = null
        private var dtpregini: LocalDate? = null
        private var dtpregfim: LocalDate? = null
        private var macd: Macd? = null
        fun idMacdSemanal(idMacdSemanal: Long?): MacdSemanalBuilder {
            this.idMacdSemanal = idMacdSemanal
            return this
        }

        fun dtpregini(dtpregini: LocalDate?): MacdSemanalBuilder {
            this.dtpregini = dtpregini
            return this
        }

        fun dtpregfim(dtpregfim: LocalDate?): MacdSemanalBuilder {
            this.dtpregfim = dtpregfim
            return this
        }

        fun macd(macd: Macd?): MacdSemanalBuilder {
            this.macd = macd
            return this
        }

        fun build(): MacdSemanal {
            return MacdSemanal(idMacdSemanal, dtpregini, dtpregfim, macd)
        }

        override fun toString(): String {
            return ("MacdSemanal.MacdSemanalBuilder(idMacdSemanal=" + idMacdSemanal + ", dtpregini="
                    + dtpregini + ", dtpregfim=" + dtpregfim + ", macd=" + macd + ")")
        }
    }

    companion object {
        @kotlin.jvm.JvmStatic
        fun builder(): MacdSemanalBuilder {
            return MacdSemanalBuilder()
        }
    }
}