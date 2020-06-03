package com.ricardococati.model.entities

import java.time.LocalDate

class SinalMacdDiario {
    var idSinalMacdDiario: Long? = null
    var dtpreg: LocalDate? = null
    var sinalMacd: SinalMacd? = null

    constructor(idSinalMacdDiario: Long?, dtpreg: LocalDate?, sinalMacd: SinalMacd?) {
        this.idSinalMacdDiario = idSinalMacdDiario
        this.dtpreg = dtpreg
        this.sinalMacd = sinalMacd
    }

    constructor() {}

    override fun equals(o: Any?): Boolean {
        if (o === this) {
            return true
        }
        if (o !is SinalMacdDiario) {
            return false
        }
        val other = o
        if (!other.canEqual(this as Any)) {
            return false
        }
        val `this$idSinalMacdDiario`: Any? = idSinalMacdDiario
        val `other$idSinalMacdDiario`: Any? = other.idSinalMacdDiario
        if (if (`this$idSinalMacdDiario` == null) `other$idSinalMacdDiario` != null else `this$idSinalMacdDiario` != `other$idSinalMacdDiario`) {
            return false
        }
        val `this$dtpreg`: Any? = dtpreg
        val `other$dtpreg`: Any? = other.dtpreg
        if (if (`this$dtpreg` == null) `other$dtpreg` != null else `this$dtpreg` != `other$dtpreg`) {
            return false
        }
        val `this$sinalMacd`: Any? = sinalMacd
        val `other$sinalMacd`: Any? = other.sinalMacd
        return if (if (`this$sinalMacd` == null) `other$sinalMacd` != null else `this$sinalMacd` != `other$sinalMacd`) {
            false
        } else true
    }

    protected fun canEqual(other: Any?): Boolean {
        return other is SinalMacdDiario
    }

    override fun hashCode(): Int {
        val PRIME = 59
        var result = 1
        val `$idSinalMacdDiario`: Any? = idSinalMacdDiario
        result = result * PRIME + (`$idSinalMacdDiario`?.hashCode() ?: 43)
        val `$dtpreg`: Any? = dtpreg
        result = result * PRIME + (`$dtpreg`?.hashCode() ?: 43)
        val `$sinalMacd`: Any? = sinalMacd
        result = result * PRIME + (`$sinalMacd`?.hashCode() ?: 43)
        return result
    }

    override fun toString(): String {
        return "SinalMacdDiario(idSinalMacdDiario=" + idSinalMacdDiario + ", dtpreg=" + dtpreg + ", sinalMacd=" + sinalMacd + ")"
    }

    class SinalMacdDiarioBuilder internal constructor() {
        private var idSinalMacdDiario: Long? = null
        private var dtpreg: LocalDate? = null
        private var sinalMacd: SinalMacd? = null
        fun idSinalMacdDiario(idSinalMacdDiario: Long?): SinalMacdDiarioBuilder {
            this.idSinalMacdDiario = idSinalMacdDiario
            return this
        }

        fun dtpreg(dtpreg: LocalDate?): SinalMacdDiarioBuilder {
            this.dtpreg = dtpreg
            return this
        }

        fun sinalMacd(sinalMacd: SinalMacd?): SinalMacdDiarioBuilder {
            this.sinalMacd = sinalMacd
            return this
        }

        fun build(): SinalMacdDiario {
            return SinalMacdDiario(idSinalMacdDiario, dtpreg, sinalMacd)
        }

        override fun toString(): String {
            return ("SinalMacdDiario.SinalMacdDiarioBuilder(idSinalMacdDiario=" + idSinalMacdDiario
                    + ", dtpreg=" + dtpreg + ", sinalMacd=" + sinalMacd + ")")
        }
    }

    companion object {
        @kotlin.jvm.JvmStatic
        fun builder(): SinalMacdDiarioBuilder {
            return SinalMacdDiarioBuilder()
        }
    }
}