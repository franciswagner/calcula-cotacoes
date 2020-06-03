package com.ricardococati.model.entities

import java.math.BigDecimal

class SinalMacd {
    var codneg: String? = null
    var presinal: BigDecimal? = null
    var periodo: Int? = null

    constructor(codneg: String?, presinal: BigDecimal?, periodo: Int?) {
        this.codneg = codneg
        this.presinal = presinal
        this.periodo = periodo
    }

    constructor() {}

    override fun equals(o: Any?): Boolean {
        if (o === this) {
            return true
        }
        if (o !is SinalMacd) {
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
        val `this$presinal`: Any? = presinal
        val `other$presinal`: Any? = other.presinal
        if (if (`this$presinal` == null) `other$presinal` != null else `this$presinal` != `other$presinal`) {
            return false
        }
        val `this$periodo`: Any? = periodo
        val `other$periodo`: Any? = other.periodo
        return if (if (`this$periodo` == null) `other$periodo` != null else `this$periodo` != `other$periodo`) {
            false
        } else true
    }

    protected fun canEqual(other: Any?): Boolean {
        return other is SinalMacd
    }

    override fun hashCode(): Int {
        val PRIME = 59
        var result = 1
        val `$codneg`: Any? = codneg
        result = result * PRIME + (`$codneg`?.hashCode() ?: 43)
        val `$presinal`: Any? = presinal
        result = result * PRIME + (`$presinal`?.hashCode() ?: 43)
        val `$periodo`: Any? = periodo
        result = result * PRIME + (`$periodo`?.hashCode() ?: 43)
        return result
    }

    override fun toString(): String {
        return ("SinalMacd(codneg=" + codneg + ", presinal=" + presinal
                + ", periodo=" + periodo + ")")
    }

    class SinalMacdBuilder internal constructor() {
        private var codneg: String? = null
        private var presinal: BigDecimal? = null
        private var periodo: Int? = null
        fun codneg(codneg: String?): SinalMacdBuilder {
            this.codneg = codneg
            return this
        }

        fun presinal(presinal: BigDecimal?): SinalMacdBuilder {
            this.presinal = presinal
            return this
        }

        fun periodo(periodo: Int?): SinalMacdBuilder {
            this.periodo = periodo
            return this
        }

        fun build(): SinalMacd {
            return SinalMacd(codneg, presinal, periodo)
        }

        override fun toString(): String {
            return ("SinalMacd.SinalMacdBuilder(codneg=" + codneg + ", presinal=" + presinal
                    + ", periodo=" + periodo + ")")
        }
    }

    companion object {
        @kotlin.jvm.JvmStatic
        fun builder(): SinalMacdBuilder {
            return SinalMacdBuilder()
        }
    }
}