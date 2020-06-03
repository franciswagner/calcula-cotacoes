package com.ricardococati.model.entities

import java.time.LocalDate

class HistogramaDiario {
    var idHistogramaDiario: Long? = null
    var dtpreg: LocalDate? = null
    var histograma: Histograma? = null

    constructor(idHistogramaDiario: Long?, dtpreg: LocalDate?, histograma: Histograma?) {
        this.idHistogramaDiario = idHistogramaDiario
        this.dtpreg = dtpreg
        this.histograma = histograma
    }

    constructor() {}

    override fun equals(o: Any?): Boolean {
        if (o === this) {
            return true
        }
        if (o !is HistogramaDiario) {
            return false
        }
        val other = o
        if (!other.canEqual(this as Any)) {
            return false
        }
        val `this$idHistogramaDiario`: Any? = idHistogramaDiario
        val `other$idHistogramaDiario`: Any? = other.idHistogramaDiario
        if (if (`this$idHistogramaDiario` == null) `other$idHistogramaDiario` != null else `this$idHistogramaDiario` != `other$idHistogramaDiario`) {
            return false
        }
        val `this$dtpreg`: Any? = dtpreg
        val `other$dtpreg`: Any? = other.dtpreg
        if (if (`this$dtpreg` == null) `other$dtpreg` != null else `this$dtpreg` != `other$dtpreg`) {
            return false
        }
        val `this$histograma`: Any? = histograma
        val `other$histograma`: Any? = other.histograma
        return if (if (`this$histograma` == null) `other$histograma` != null else `this$histograma` != `other$histograma`) {
            false
        } else true
    }

    protected fun canEqual(other: Any?): Boolean {
        return other is HistogramaDiario
    }

    override fun hashCode(): Int {
        val PRIME = 59
        var result = 1
        val `$idHistogramaDiario`: Any? = idHistogramaDiario
        result = result * PRIME + (`$idHistogramaDiario`?.hashCode() ?: 43)
        val `$dtpreg`: Any? = dtpreg
        result = result * PRIME + (`$dtpreg`?.hashCode() ?: 43)
        val `$histograma`: Any? = histograma
        result = result * PRIME + (`$histograma`?.hashCode() ?: 43)
        return result
    }

    override fun toString(): String {
        return ("HistogramaDiario(idHistogramaDiario=" + idHistogramaDiario + ", dtpreg="
                + dtpreg + ", histograma=" + histograma + ")")
    }

    class HistogramaDiarioBuilder internal constructor() {
        private var idHistogramaDiario: Long? = null
        private var dtpreg: LocalDate? = null
        private var histograma: Histograma? = null
        fun idHistogramaDiario(idHistogramaDiario: Long?): HistogramaDiarioBuilder {
            this.idHistogramaDiario = idHistogramaDiario
            return this
        }

        fun dtpreg(dtpreg: LocalDate?): HistogramaDiarioBuilder {
            this.dtpreg = dtpreg
            return this
        }

        fun histograma(histograma: Histograma?): HistogramaDiarioBuilder {
            this.histograma = histograma
            return this
        }

        fun build(): HistogramaDiario {
            return HistogramaDiario(idHistogramaDiario, dtpreg, histograma)
        }

        override fun toString(): String {
            return ("HistogramaDiario.HistogramaDiarioBuilder(idHistogramaDiario="
                    + idHistogramaDiario
                    + ", dtpreg=" + dtpreg + ", histograma=" + histograma + ")")
        }
    }

    companion object {
        @kotlin.jvm.JvmStatic
        fun builder(): HistogramaDiarioBuilder {
            return HistogramaDiarioBuilder()
        }
    }
}