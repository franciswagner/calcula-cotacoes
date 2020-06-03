package com.ricardococati.model.entities

import java.time.LocalDate

class MediaMovelExponencialSemanal {
    var idMediaMovelExponencialSemanal: Long? = null
    var dtpregini: LocalDate? = null
    var dtpregfim: LocalDate? = null
    var mediaMovelExponencial: MediaMovelExponencial? = null

    constructor(idMediaMovelExponencialSemanal: Long?, dtpregini: LocalDate?,
                dtpregfim: LocalDate?, mediaMovelExponencial: MediaMovelExponencial?) {
        this.idMediaMovelExponencialSemanal = idMediaMovelExponencialSemanal
        this.dtpregini = dtpregini
        this.dtpregfim = dtpregfim
        this.mediaMovelExponencial = mediaMovelExponencial
    }

    constructor() {}

    override fun equals(o: Any?): Boolean {
        if (o === this) {
            return true
        }
        if (o !is MediaMovelExponencialSemanal) {
            return false
        }
        val other = o
        if (!other.canEqual(this as Any)) {
            return false
        }
        val `this$idMediaMovelExponencialSemanal`: Any? = idMediaMovelExponencialSemanal
        val `other$idMediaMovelExponencialSemanal`: Any? = other.idMediaMovelExponencialSemanal
        if (if (`this$idMediaMovelExponencialSemanal` == null) `other$idMediaMovelExponencialSemanal` != null else `this$idMediaMovelExponencialSemanal` != `other$idMediaMovelExponencialSemanal`) {
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
        val `this$mediaMovelExponencial`: Any? = mediaMovelExponencial
        val `other$mediaMovelExponencial`: Any? = other.mediaMovelExponencial
        return if (if (`this$mediaMovelExponencial` == null) `other$mediaMovelExponencial` != null else `this$mediaMovelExponencial` != `other$mediaMovelExponencial`) {
            false
        } else true
    }

    protected fun canEqual(other: Any?): Boolean {
        return other is MediaMovelExponencialSemanal
    }

    override fun hashCode(): Int {
        val PRIME = 59
        var result = 1
        val `$idMediaMovelExponencialSemanal`: Any? = idMediaMovelExponencialSemanal
        result = result * PRIME + (`$idMediaMovelExponencialSemanal`?.hashCode() ?: 43)
        val `$dtpregini`: Any? = dtpregini
        result = result * PRIME + (`$dtpregini`?.hashCode() ?: 43)
        val `$dtpregfim`: Any? = dtpregfim
        result = result * PRIME + (`$dtpregfim`?.hashCode() ?: 43)
        val `$mediaMovelExponencial`: Any? = mediaMovelExponencial
        result = result * PRIME + (`$mediaMovelExponencial`?.hashCode() ?: 43)
        return result
    }

    override fun toString(): String {
        return ("MediaMovelExponencialSemanal(idMediaMovelExponencialSemanal=" + idMediaMovelExponencialSemanal + ", dtpregini=" + dtpregini + ", dtpregfim="
                + dtpregfim + ", mediaMovelExponencial=" + mediaMovelExponencial + ")")
    }

    class MediaMovelExponencialSemanalBuilder internal constructor() {
        private var idMediaMovelExponencialSemanal: Long? = null
        private var dtpregini: LocalDate? = null
        private var dtpregfim: LocalDate? = null
        private var mediaMovelExponencial: MediaMovelExponencial? = null
        fun idMediaMovelExponencialSemanal(
                idMediaMovelExponencialSemanal: Long?): MediaMovelExponencialSemanalBuilder {
            this.idMediaMovelExponencialSemanal = idMediaMovelExponencialSemanal
            return this
        }

        fun dtpregini(
                dtpregini: LocalDate?): MediaMovelExponencialSemanalBuilder {
            this.dtpregini = dtpregini
            return this
        }

        fun dtpregfim(
                dtpregfim: LocalDate?): MediaMovelExponencialSemanalBuilder {
            this.dtpregfim = dtpregfim
            return this
        }

        fun mediaMovelExponencial(
                mediaMovelExponencial: MediaMovelExponencial?): MediaMovelExponencialSemanalBuilder {
            this.mediaMovelExponencial = mediaMovelExponencial
            return this
        }

        fun build(): MediaMovelExponencialSemanal {
            return MediaMovelExponencialSemanal(idMediaMovelExponencialSemanal, dtpregini, dtpregfim,
                    mediaMovelExponencial)
        }

        override fun toString(): String {
            return ("MediaMovelExponencialSemanal.MediaMovelExponencialSemanalBuilder(idMediaMovelExponencialSemanal="
                    + idMediaMovelExponencialSemanal + ", dtpregini=" + dtpregini
                    + ", dtpregfim="
                    + dtpregfim + ", mediaMovelExponencial=" + mediaMovelExponencial + ")")
        }
    }

    companion object {
        private const val serialVersionUID = 505011356059052924L
        @kotlin.jvm.JvmStatic
        fun builder(): MediaMovelExponencialSemanalBuilder {
            return MediaMovelExponencialSemanalBuilder()
        }
    }
}