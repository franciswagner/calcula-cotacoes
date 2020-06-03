package com.ricardococati.model.entities

import java.time.LocalDate

class SinalMacdSemanal {
    var idSinalMacdSemanal: Long? = null
    var dtpregini: LocalDate? = null
    var dtpregfim: LocalDate? = null
    var sinalMacd: SinalMacd? = null

    constructor(idSinalMacdSemanal: Long?, dtpregini: LocalDate?, dtpregfim: LocalDate?,
                sinalMacd: SinalMacd?) {
        this.idSinalMacdSemanal = idSinalMacdSemanal
        this.dtpregini = dtpregini
        this.dtpregfim = dtpregfim
        this.sinalMacd = sinalMacd
    }

    constructor() {}

    override fun equals(o: Any?): Boolean {
        if (o === this) {
            return true
        }
        if (o !is SinalMacdSemanal) {
            return false
        }
        val other = o
        if (!other.canEqual(this as Any)) {
            return false
        }
        val `this$idSinalMacdSemanal`: Any? = idSinalMacdSemanal
        val `other$idSinalMacdSemanal`: Any? = other.idSinalMacdSemanal
        if (if (`this$idSinalMacdSemanal` == null) `other$idSinalMacdSemanal` != null else `this$idSinalMacdSemanal` != `other$idSinalMacdSemanal`) {
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
        val `this$sinalMacd`: Any? = sinalMacd
        val `other$sinalMacd`: Any? = other.sinalMacd
        return if (if (`this$sinalMacd` == null) `other$sinalMacd` != null else `this$sinalMacd` != `other$sinalMacd`) {
            false
        } else true
    }

    protected fun canEqual(other: Any?): Boolean {
        return other is SinalMacdSemanal
    }

    override fun hashCode(): Int {
        val PRIME = 59
        var result = 1
        val `$idSinalMacdSemanal`: Any? = idSinalMacdSemanal
        result = result * PRIME + (`$idSinalMacdSemanal`?.hashCode() ?: 43)
        val `$dtpregini`: Any? = dtpregini
        result = result * PRIME + (`$dtpregini`?.hashCode() ?: 43)
        val `$dtpregfim`: Any? = dtpregfim
        result = result * PRIME + (`$dtpregfim`?.hashCode() ?: 43)
        val `$sinalMacd`: Any? = sinalMacd
        result = result * PRIME + (`$sinalMacd`?.hashCode() ?: 43)
        return result
    }

    override fun toString(): String {
        return ("SinalMacdSemanal(idSinalMacdSemanal=" + idSinalMacdSemanal + ", dtpregini="
                + dtpregini + ", dtpregfim=" + dtpregfim + ", sinalMacd=" + sinalMacd + ")")
    }

    class SinalMacdSemanalBuilder internal constructor() {
        private var idSinalMacdSemanal: Long? = null
        private var dtpregini: LocalDate? = null
        private var dtpregfim: LocalDate? = null
        private var sinalMacd: SinalMacd? = null
        fun idSinalMacdSemanal(idSinalMacdSemanal: Long?): SinalMacdSemanalBuilder {
            this.idSinalMacdSemanal = idSinalMacdSemanal
            return this
        }

        fun dtpregini(dtpregini: LocalDate?): SinalMacdSemanalBuilder {
            this.dtpregini = dtpregini
            return this
        }

        fun dtpregfim(dtpregfim: LocalDate?): SinalMacdSemanalBuilder {
            this.dtpregfim = dtpregfim
            return this
        }

        fun sinalMacd(sinalMacd: SinalMacd?): SinalMacdSemanalBuilder {
            this.sinalMacd = sinalMacd
            return this
        }

        fun build(): SinalMacdSemanal {
            return SinalMacdSemanal(idSinalMacdSemanal, dtpregini, dtpregfim, sinalMacd)
        }

        override fun toString(): String {
            return ("SinalMacdSemanal.SinalMacdSemanalBuilder(idSinalMacdSemanal="
                    + idSinalMacdSemanal
                    + ", dtpregini=" + dtpregini + ", dtpregfim=" + dtpregfim + ", sinalMacd="
                    + sinalMacd + ")")
        }
    }

    companion object {
        @kotlin.jvm.JvmStatic
        fun builder(): SinalMacdSemanalBuilder {
            return SinalMacdSemanalBuilder()
        }
    }
}