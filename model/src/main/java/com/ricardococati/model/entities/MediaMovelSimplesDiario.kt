package com.ricardococati.model.entities

import java.time.LocalDate

class MediaMovelSimplesDiario {
    var idMediaMovelSimplesDiario: Long? = null
    var dtpreg: LocalDate? = null
    var mediaMovelSimples: MediaMovelSimples? = null

    constructor(idMediaMovelSimplesDiario: Long?, dtpreg: LocalDate?,
                mediaMovelSimples: MediaMovelSimples?) {
        this.idMediaMovelSimplesDiario = idMediaMovelSimplesDiario
        this.dtpreg = dtpreg
        this.mediaMovelSimples = mediaMovelSimples
    }

    constructor() {}

    override fun equals(o: Any?): Boolean {
        if (o === this) {
            return true
        }
        if (o !is MediaMovelSimplesDiario) {
            return false
        }
        val other = o
        if (!other.canEqual(this as Any)) {
            return false
        }
        val `this$idMediaMovelSimplesDiario`: Any? = idMediaMovelSimplesDiario
        val `other$idMediaMovelSimplesDiario`: Any? = other.idMediaMovelSimplesDiario
        if (if (`this$idMediaMovelSimplesDiario` == null) `other$idMediaMovelSimplesDiario` != null else `this$idMediaMovelSimplesDiario` != `other$idMediaMovelSimplesDiario`) {
            return false
        }
        val `this$dtpreg`: Any? = dtpreg
        val `other$dtpreg`: Any? = other.dtpreg
        if (if (`this$dtpreg` == null) `other$dtpreg` != null else `this$dtpreg` != `other$dtpreg`) {
            return false
        }
        val `this$mediaMovelSimples`: Any? = mediaMovelSimples
        val `other$mediaMovelSimples`: Any? = other.mediaMovelSimples
        return if (if (`this$mediaMovelSimples` == null) `other$mediaMovelSimples` != null else `this$mediaMovelSimples` != `other$mediaMovelSimples`) {
            false
        } else true
    }

    protected fun canEqual(other: Any?): Boolean {
        return other is MediaMovelSimplesDiario
    }

    override fun hashCode(): Int {
        val PRIME = 59
        var result = 1
        val `$idMediaMovelSimplesDiario`: Any? = idMediaMovelSimplesDiario
        result = result * PRIME + (`$idMediaMovelSimplesDiario`?.hashCode() ?: 43)
        val `$dtpreg`: Any? = dtpreg
        result = result * PRIME + (`$dtpreg`?.hashCode() ?: 43)
        val `$mediaMovelSimples`: Any? = mediaMovelSimples
        result = result * PRIME + (`$mediaMovelSimples`?.hashCode() ?: 43)
        return result
    }

    override fun toString(): String {
        return ("MediaMovelSimplesDiario(idMediaMovelSimplesDiario=" + idMediaMovelSimplesDiario + ", dtpreg=" + dtpreg + ", mediaMovelSimples="
                + mediaMovelSimples + ")")
    }

    class MediaMovelSimplesDiarioBuilder internal constructor() {
        private var idMediaMovelSimplesDiario: Long? = null
        private var dtpreg: LocalDate? = null
        private var mediaMovelSimples: MediaMovelSimples? = null
        fun idMediaMovelSimplesDiario(
                idMediaMovelSimplesDiario: Long?): MediaMovelSimplesDiarioBuilder {
            this.idMediaMovelSimplesDiario = idMediaMovelSimplesDiario
            return this
        }

        fun dtpreg(dtpreg: LocalDate?): MediaMovelSimplesDiarioBuilder {
            this.dtpreg = dtpreg
            return this
        }

        fun mediaMovelSimples(
                mediaMovelSimples: MediaMovelSimples?): MediaMovelSimplesDiarioBuilder {
            this.mediaMovelSimples = mediaMovelSimples
            return this
        }

        fun build(): MediaMovelSimplesDiario {
            return MediaMovelSimplesDiario(idMediaMovelSimplesDiario, dtpreg, mediaMovelSimples)
        }

        override fun toString(): String {
            return ("MediaMovelSimplesDiario.MediaMovelSimplesDiarioBuilder(idMediaMovelSimplesDiario="
                    + idMediaMovelSimplesDiario + ", dtpreg=" + dtpreg + ", mediaMovelSimples="
                    + mediaMovelSimples + ")")
        }
    }

    companion object {
        @kotlin.jvm.JvmStatic
        fun builder(): MediaMovelSimplesDiarioBuilder {
            return MediaMovelSimplesDiarioBuilder()
        }
    }
}