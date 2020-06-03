package com.ricardococati.model.entities

import java.time.LocalDate

class MediaMovelExponencialDiario {
    var idMediaMovelExponencialDiario: Long? = null
    var dtpreg: LocalDate? = null
    var mediaMovelExponencial: MediaMovelExponencial? = null

    constructor(idMediaMovelExponencialDiario: Long?, dtpreg: LocalDate?,
                mediaMovelExponencial: MediaMovelExponencial?) {
        this.idMediaMovelExponencialDiario = idMediaMovelExponencialDiario
        this.dtpreg = dtpreg
        this.mediaMovelExponencial = mediaMovelExponencial
    }

    constructor() {}

    override fun equals(o: Any?): Boolean {
        if (o === this) {
            return true
        }
        if (o !is MediaMovelExponencialDiario) {
            return false
        }
        val other = o
        if (!other.canEqual(this as Any)) {
            return false
        }
        val `this$idMediaMovelExponencialDiario`: Any? = idMediaMovelExponencialDiario
        val `other$idMediaMovelExponencialDiario`: Any? = other.idMediaMovelExponencialDiario
        if (if (`this$idMediaMovelExponencialDiario` == null) `other$idMediaMovelExponencialDiario` != null else `this$idMediaMovelExponencialDiario` != `other$idMediaMovelExponencialDiario`) {
            return false
        }
        val `this$dtpreg`: Any? = dtpreg
        val `other$dtpreg`: Any? = other.dtpreg
        if (if (`this$dtpreg` == null) `other$dtpreg` != null else `this$dtpreg` != `other$dtpreg`) {
            return false
        }
        val `this$mediaMovelExponencial`: Any? = mediaMovelExponencial
        val `other$mediaMovelExponencial`: Any? = other.mediaMovelExponencial
        return if (if (`this$mediaMovelExponencial` == null) `other$mediaMovelExponencial` != null else `this$mediaMovelExponencial` != `other$mediaMovelExponencial`) {
            false
        } else true
    }

    protected fun canEqual(other: Any?): Boolean {
        return other is MediaMovelExponencialDiario
    }

    override fun hashCode(): Int {
        val PRIME = 59
        var result = 1
        val `$idMediaMovelExponencialDiario`: Any? = idMediaMovelExponencialDiario
        result = result * PRIME + (`$idMediaMovelExponencialDiario`?.hashCode() ?: 43)
        val `$dtpreg`: Any? = dtpreg
        result = result * PRIME + (`$dtpreg`?.hashCode() ?: 43)
        val `$mediaMovelExponencial`: Any? = mediaMovelExponencial
        result = result * PRIME + (`$mediaMovelExponencial`?.hashCode() ?: 43)
        return result
    }

    override fun toString(): String {
        return ("MediaMovelExponencialDiario(idMediaMovelExponencialDiario=" + idMediaMovelExponencialDiario + ", dtpreg=" + dtpreg
                + ", mediaMovelExponencial=" + mediaMovelExponencial + ")")
    }

    class MediaMovelExponencialDiarioBuilder internal constructor() {
        private var idMediaMovelExponencialDiario: Long? = null
        private var dtpreg: LocalDate? = null
        private var mediaMovelExponencial: MediaMovelExponencial? = null
        fun idMediaMovelExponencialDiario(
                idMediaMovelExponencialDiario: Long?): MediaMovelExponencialDiarioBuilder {
            this.idMediaMovelExponencialDiario = idMediaMovelExponencialDiario
            return this
        }

        fun dtpreg(dtpreg: LocalDate?): MediaMovelExponencialDiarioBuilder {
            this.dtpreg = dtpreg
            return this
        }

        fun mediaMovelExponencial(
                mediaMovelExponencial: MediaMovelExponencial?): MediaMovelExponencialDiarioBuilder {
            this.mediaMovelExponencial = mediaMovelExponencial
            return this
        }

        fun build(): MediaMovelExponencialDiario {
            return MediaMovelExponencialDiario(idMediaMovelExponencialDiario, dtpreg,
                    mediaMovelExponencial)
        }

        override fun toString(): String {
            return ("MediaMovelExponencialDiario.MediaMovelExponencialDiarioBuilder(idMediaMovelExponencialDiario="
                    + idMediaMovelExponencialDiario + ", dtpreg=" + dtpreg
                    + ", mediaMovelExponencial=" + mediaMovelExponencial + ")")
        }
    }

    companion object {
        private const val serialVersionUID = 505011356059052924L
        @kotlin.jvm.JvmStatic
        fun builder(): MediaMovelExponencialDiarioBuilder {
            return MediaMovelExponencialDiarioBuilder()
        }
    }
}