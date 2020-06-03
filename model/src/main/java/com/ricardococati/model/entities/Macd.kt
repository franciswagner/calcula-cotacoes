package com.ricardococati.model.entities

import java.math.BigDecimal

class Macd {
    var codneg: String? = null
    var premacd: BigDecimal? = null

    constructor(codneg: String?, premacd: BigDecimal?) {
        this.codneg = codneg
        this.premacd = premacd
    }

    constructor() {}

    override fun equals(o: Any?): Boolean {
        if (o === this) {
            return true
        }
        if (o !is Macd) {
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
        val `this$premacd`: Any? = premacd
        val `other$premacd`: Any? = other.premacd
        return if (if (`this$premacd` == null) `other$premacd` != null else `this$premacd` != `other$premacd`) {
            false
        } else true
    }

    protected fun canEqual(other: Any?): Boolean {
        return other is Macd
    }

    override fun hashCode(): Int {
        val PRIME = 59
        var result = 1
        val `$codneg`: Any? = codneg
        result = result * PRIME + (`$codneg`?.hashCode() ?: 43)
        val `$premacd`: Any? = premacd
        result = result * PRIME + (`$premacd`?.hashCode() ?: 43)
        return result
    }

    override fun toString(): String {
        return "Macd(codneg=" + codneg + ", premacd=" + premacd + ")"
    }

    class MacdBuilder internal constructor() {
        private var codneg: String? = null
        private var premacd: BigDecimal? = null
        fun codneg(codneg: String?): MacdBuilder {
            this.codneg = codneg
            return this
        }

        fun premacd(premacd: BigDecimal?): MacdBuilder {
            this.premacd = premacd
            return this
        }

        fun build(): Macd {
            return Macd(codneg, premacd)
        }

        override fun toString(): String {
            return "Macd.MacdBuilder(codneg=" + codneg + ", premacd=" + premacd + ")"
        }
    }

    companion object {
        @kotlin.jvm.JvmStatic
        fun builder(): MacdBuilder {
            return MacdBuilder()
        }
    }
}