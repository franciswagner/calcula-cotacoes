package com.ricardococati.model.entities

import java.math.BigDecimal

class MediaMovelExponencial {
    var codneg: String? = null
    var premedult: BigDecimal? = null
    var periodo: Int? = null

    constructor(codneg: String?, premedult: BigDecimal?, periodo: Int?) {
        this.codneg = codneg
        this.premedult = premedult
        this.periodo = periodo
    }

    constructor() {}

    override fun equals(o: Any?): Boolean {
        if (o === this) {
            return true
        }
        if (o !is MediaMovelExponencial) {
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
        val `this$premedult`: Any? = premedult
        val `other$premedult`: Any? = other.premedult
        if (if (`this$premedult` == null) `other$premedult` != null else `this$premedult` != `other$premedult`) {
            return false
        }
        val `this$periodo`: Any? = periodo
        val `other$periodo`: Any? = other.periodo
        return if (if (`this$periodo` == null) `other$periodo` != null else `this$periodo` != `other$periodo`) {
            false
        } else true
    }

    protected fun canEqual(other: Any?): Boolean {
        return other is MediaMovelExponencial
    }

    override fun hashCode(): Int {
        val PRIME = 59
        var result = 1
        val `$codneg`: Any? = codneg
        result = result * PRIME + (`$codneg`?.hashCode() ?: 43)
        val `$premedult`: Any? = premedult
        result = result * PRIME + (`$premedult`?.hashCode() ?: 43)
        val `$periodo`: Any? = periodo
        result = result * PRIME + (`$periodo`?.hashCode() ?: 43)
        return result
    }

    override fun toString(): String {
        return ("MediaMovelExponencial(codneg=" + codneg + ", premedult=" + premedult
                + ", periodo=" + periodo + ")")
    }

    class MediaMovelExponencialBuilder internal constructor() {
        private var codneg: String? = null
        private var premedult: BigDecimal? = null
        private var periodo: Int? = null
        fun codneg(codneg: String?): MediaMovelExponencialBuilder {
            this.codneg = codneg
            return this
        }

        fun premedult(premedult: BigDecimal?): MediaMovelExponencialBuilder {
            this.premedult = premedult
            return this
        }

        fun periodo(periodo: Int?): MediaMovelExponencialBuilder {
            this.periodo = periodo
            return this
        }

        fun build(): MediaMovelExponencial {
            return MediaMovelExponencial(codneg, premedult, periodo)
        }

        override fun toString(): String {
            return ("MediaMovelExponencial.MediaMovelExponencialBuilder(codneg=" + codneg
                    + ", premedult=" + premedult + ", periodo=" + periodo + ")")
        }
    }

    companion object {
        @kotlin.jvm.JvmStatic
        fun builder(): MediaMovelExponencialBuilder {
            return MediaMovelExponencialBuilder()
        }
    }
}