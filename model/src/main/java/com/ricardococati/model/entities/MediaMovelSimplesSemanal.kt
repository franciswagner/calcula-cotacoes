package com.ricardococati.model.entities

import java.time.LocalDate

class MediaMovelSimplesSemanal {
    var idMediaMovelSimplesSemanal: Long? = null
    var dtpregini: LocalDate? = null
    var dtpregfim: LocalDate? = null
    var mediaMovelSimples: MediaMovelSimples? = null

    constructor(idMediaMovelSimplesSemanal: Long?, dtpregini: LocalDate?,
                dtpregfim: LocalDate?, mediaMovelSimples: MediaMovelSimples?) {
        this.idMediaMovelSimplesSemanal = idMediaMovelSimplesSemanal
        this.dtpregini = dtpregini
        this.dtpregfim = dtpregfim
        this.mediaMovelSimples = mediaMovelSimples
    }

    constructor() {}

    override fun equals(o: Any?): Boolean {
        if (o === this) {
            return true
        }
        if (o !is MediaMovelSimplesSemanal) {
            return false
        }
        val other = o
        if (!other.canEqual(this as Any)) {
            return false
        }
        val `this$idMediaMovelSimplesSemanal`: Any? = idMediaMovelSimplesSemanal
        val `other$idMediaMovelSimplesSemanal`: Any? = other.idMediaMovelSimplesSemanal
        if (if (`this$idMediaMovelSimplesSemanal` == null) `other$idMediaMovelSimplesSemanal` != null else `this$idMediaMovelSimplesSemanal` != `other$idMediaMovelSimplesSemanal`) {
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
        val `this$mediaMovelSimples`: Any? = mediaMovelSimples
        val `other$mediaMovelSimples`: Any? = other.mediaMovelSimples
        return if (if (`this$mediaMovelSimples` == null) `other$mediaMovelSimples` != null else `this$mediaMovelSimples` != `other$mediaMovelSimples`) {
            false
        } else true
    }

    protected fun canEqual(other: Any?): Boolean {
        return other is MediaMovelSimplesSemanal
    }

    override fun hashCode(): Int {
        val PRIME = 59
        var result = 1
        val `$idMediaMovelSimplesSemanal`: Any? = idMediaMovelSimplesSemanal
        result = result * PRIME + (`$idMediaMovelSimplesSemanal`?.hashCode() ?: 43)
        val `$dtpregini`: Any? = dtpregini
        result = result * PRIME + (`$dtpregini`?.hashCode() ?: 43)
        val `$dtpregfim`: Any? = dtpregfim
        result = result * PRIME + (`$dtpregfim`?.hashCode() ?: 43)
        val `$mediaMovelSimples`: Any? = mediaMovelSimples
        result = result * PRIME + (`$mediaMovelSimples`?.hashCode() ?: 43)
        return result
    }

    override fun toString(): String {
        return ("MediaMovelSimplesSemanal(idMediaMovelSimplesSemanal=" + idMediaMovelSimplesSemanal + ", dtpregini=" + dtpregini + ", dtpregfim="
                + dtpregfim + ", mediaMovelSimples=" + mediaMovelSimples + ")")
    }

    class MediaMovelSimplesSemanalBuilder internal constructor() {
        private var idMediaMovelSimplesSemanal: Long? = null
        private var dtpregini: LocalDate? = null
        private var dtpregfim: LocalDate? = null
        private var mediaMovelSimples: MediaMovelSimples? = null
        fun idMediaMovelSimplesSemanal(
                idMediaMovelSimplesSemanal: Long?): MediaMovelSimplesSemanalBuilder {
            this.idMediaMovelSimplesSemanal = idMediaMovelSimplesSemanal
            return this
        }

        fun dtpregini(dtpregini: LocalDate?): MediaMovelSimplesSemanalBuilder {
            this.dtpregini = dtpregini
            return this
        }

        fun dtpregfim(dtpregfim: LocalDate?): MediaMovelSimplesSemanalBuilder {
            this.dtpregfim = dtpregfim
            return this
        }

        fun mediaMovelSimples(
                mediaMovelSimples: MediaMovelSimples?): MediaMovelSimplesSemanalBuilder {
            this.mediaMovelSimples = mediaMovelSimples
            return this
        }

        fun build(): MediaMovelSimplesSemanal {
            return MediaMovelSimplesSemanal(idMediaMovelSimplesSemanal, dtpregini, dtpregfim,
                    mediaMovelSimples)
        }

        override fun toString(): String {
            return ("MediaMovelSimplesSemanal.MediaMovelSimplesSemanalBuilder(idMediaMovelSimplesSemanal="
                    + idMediaMovelSimplesSemanal + ", dtpregini=" + dtpregini + ", dtpregfim="
                    + dtpregfim + ", mediaMovelSimples=" + mediaMovelSimples + ")")
        }
    }

    companion object {
        @kotlin.jvm.JvmStatic
        fun builder(): MediaMovelSimplesSemanalBuilder {
            return MediaMovelSimplesSemanalBuilder()
        }
    }
}