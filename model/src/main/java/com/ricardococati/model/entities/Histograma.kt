package com.ricardococati.model.entities

import java.math.BigDecimal

class Histograma {
    var codneg: String? = null
    var prehist: BigDecimal? = null

    constructor(codneg: String?, prehist: BigDecimal?) {
        this.codneg = codneg
        this.prehist = prehist
    }

    constructor() {}

    override fun equals(o: Any?): Boolean {
        if (o === this) {
            return true
        }
        if (o !is Histograma) {
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
        val `this$prehist`: Any? = prehist
        val `other$prehist`: Any? = other.prehist
        return if (if (`this$prehist` == null) `other$prehist` != null else `this$prehist` != `other$prehist`) {
            false
        } else true
    }

    protected fun canEqual(other: Any?): Boolean {
        return other is Histograma
    }

    override fun hashCode(): Int {
        val PRIME = 59
        var result = 1
        val `$codneg`: Any? = codneg
        result = result * PRIME + (`$codneg`?.hashCode() ?: 43)
        val `$prehist`: Any? = prehist
        result = result * PRIME + (`$prehist`?.hashCode() ?: 43)
        return result
    }

    override fun toString(): String {
        return "Histograma(codneg=" + codneg + ", prehist=" + prehist + ")"
    }

    class HistogramaBuilder internal constructor() {
        private var codneg: String? = null
        private var prehist: BigDecimal? = null
        fun codneg(codneg: String?): HistogramaBuilder {
            this.codneg = codneg
            return this
        }

        fun prehist(prehist: BigDecimal?): HistogramaBuilder {
            this.prehist = prehist
            return this
        }

        fun build(): Histograma {
            return Histograma(codneg, prehist)
        }

        override fun toString(): String {
            return ("Histograma.HistogramaBuilder(codneg=" + codneg + ", prehist=" + prehist
                    + ")")
        }
    }

    companion object {
        @kotlin.jvm.JvmStatic
        fun builder(): HistogramaBuilder {
            return HistogramaBuilder()
        }
    }
}