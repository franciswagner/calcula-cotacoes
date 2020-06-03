package com.ricardococati.model.entities

import java.time.LocalDate

class HistogramaSemanal {
    var idHistogramaSemanal: Long? = null
    var dtpregini: LocalDate? = null
    var dtpregfim: LocalDate? = null
    var histograma: Histograma? = null

    constructor(idHistogramaSemanal: Long?, dtpregini: LocalDate?, dtpregfim: LocalDate?,
                histograma: Histograma?) {
        this.idHistogramaSemanal = idHistogramaSemanal
        this.dtpregini = dtpregini
        this.dtpregfim = dtpregfim
        this.histograma = histograma
    }

    constructor() {}

    override fun equals(o: Any?): Boolean {
        if (o === this) {
            return true
        }
        if (o !is HistogramaSemanal) {
            return false
        }
        val other = o
        if (!other.canEqual(this as Any)) {
            return false
        }
        val `this$idHistogramaSemanal`: Any? = idHistogramaSemanal
        val `other$idHistogramaSemanal`: Any? = other.idHistogramaSemanal
        if (if (`this$idHistogramaSemanal` == null) `other$idHistogramaSemanal` != null else `this$idHistogramaSemanal` != `other$idHistogramaSemanal`) {
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
        val `this$histograma`: Any? = histograma
        val `other$histograma`: Any? = other.histograma
        return if (if (`this$histograma` == null) `other$histograma` != null else `this$histograma` != `other$histograma`) {
            false
        } else true
    }

    protected fun canEqual(other: Any?): Boolean {
        return other is HistogramaSemanal
    }

    override fun hashCode(): Int {
        val PRIME = 59
        var result = 1
        val `$idHistogramaSemanal`: Any? = idHistogramaSemanal
        result = result * PRIME + (`$idHistogramaSemanal`?.hashCode() ?: 43)
        val `$dtpregini`: Any? = dtpregini
        result = result * PRIME + (`$dtpregini`?.hashCode() ?: 43)
        val `$dtpregfim`: Any? = dtpregfim
        result = result * PRIME + (`$dtpregfim`?.hashCode() ?: 43)
        val `$histograma`: Any? = histograma
        result = result * PRIME + (`$histograma`?.hashCode() ?: 43)
        return result
    }

    override fun toString(): String {
        return ("HistogramaSemanal(idHistogramaSemanal=" + idHistogramaSemanal + ", dtpregini="
                + dtpregini + ", dtpregfim=" + dtpregfim + ", histograma=" + histograma + ")")
    }

    class HistogramaSemanalBuilder internal constructor() {
        private var idHistogramaSemanal: Long? = null
        private var dtpregini: LocalDate? = null
        private var dtpregfim: LocalDate? = null
        private var histograma: Histograma? = null
        fun idHistogramaSemanal(
                idHistogramaSemanal: Long?): HistogramaSemanalBuilder {
            this.idHistogramaSemanal = idHistogramaSemanal
            return this
        }

        fun dtpregini(dtpregini: LocalDate?): HistogramaSemanalBuilder {
            this.dtpregini = dtpregini
            return this
        }

        fun dtpregfim(dtpregfim: LocalDate?): HistogramaSemanalBuilder {
            this.dtpregfim = dtpregfim
            return this
        }

        fun histograma(histograma: Histograma?): HistogramaSemanalBuilder {
            this.histograma = histograma
            return this
        }

        fun build(): HistogramaSemanal {
            return HistogramaSemanal(idHistogramaSemanal, dtpregini, dtpregfim, histograma)
        }

        override fun toString(): String {
            return ("HistogramaSemanal.HistogramaSemanalBuilder(idHistogramaSemanal="
                    + idHistogramaSemanal + ", dtpregini=" + dtpregini + ", dtpregfim="
                    + dtpregfim + ", histograma=" + histograma + ")")
        }
    }

    companion object {
        @kotlin.jvm.JvmStatic
        fun builder(): HistogramaSemanalBuilder {
            return HistogramaSemanalBuilder()
        }
    }
}