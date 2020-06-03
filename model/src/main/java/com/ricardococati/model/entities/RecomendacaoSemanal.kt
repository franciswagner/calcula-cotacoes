package com.ricardococati.model.entities

import java.time.LocalDate

class RecomendacaoSemanal {
    var idRecomendacaoSemanal: Long? = null
    var dtpregini: LocalDate? = null
    var dtpregfim: LocalDate? = null
    var recomendacao: Recomendacao? = null

    constructor(idRecomendacaoSemanal: Long?, dtpregini: LocalDate?, dtpregfim: LocalDate?,
                recomendacao: Recomendacao?) {
        this.idRecomendacaoSemanal = idRecomendacaoSemanal
        this.dtpregini = dtpregini
        this.dtpregfim = dtpregfim
        this.recomendacao = recomendacao
    }

    constructor() {}

    override fun equals(o: Any?): Boolean {
        if (o === this) {
            return true
        }
        if (o !is RecomendacaoSemanal) {
            return false
        }
        val other = o
        if (!other.canEqual(this as Any)) {
            return false
        }
        val `this$idRecomendacaoSemanal`: Any? = idRecomendacaoSemanal
        val `other$idRecomendacaoSemanal`: Any? = other.idRecomendacaoSemanal
        if (if (`this$idRecomendacaoSemanal` == null) `other$idRecomendacaoSemanal` != null else `this$idRecomendacaoSemanal` != `other$idRecomendacaoSemanal`) {
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
        val `this$recomendacao`: Any? = recomendacao
        val `other$recomendacao`: Any? = other.recomendacao
        return if (if (`this$recomendacao` == null) `other$recomendacao` != null else `this$recomendacao` != `other$recomendacao`) {
            false
        } else true
    }

    protected fun canEqual(other: Any?): Boolean {
        return other is RecomendacaoSemanal
    }

    override fun hashCode(): Int {
        val PRIME = 59
        var result = 1
        val `$idRecomendacaoSemanal`: Any? = idRecomendacaoSemanal
        result = result * PRIME + (`$idRecomendacaoSemanal`?.hashCode() ?: 43)
        val `$dtpregini`: Any? = dtpregini
        result = result * PRIME + (`$dtpregini`?.hashCode() ?: 43)
        val `$dtpregfim`: Any? = dtpregfim
        result = result * PRIME + (`$dtpregfim`?.hashCode() ?: 43)
        val `$recomendacao`: Any? = recomendacao
        result = result * PRIME + (`$recomendacao`?.hashCode() ?: 43)
        return result
    }

    override fun toString(): String {
        return ("RecomendacaoSemanal(idRecomendacaoSemanal=" + idRecomendacaoSemanal
                + ", dtpregini=" + dtpregini + ", dtpregfim=" + dtpregfim
                + ", recomendacao=" + recomendacao + ")")
    }

    class RecomendacaoSemanalBuilder internal constructor() {
        private var idRecomendacaoSemanal: Long? = null
        private var dtpregini: LocalDate? = null
        private var dtpregfim: LocalDate? = null
        private var recomendacao: Recomendacao? = null
        fun idRecomendacaoSemanal(
                idRecomendacaoSemanal: Long?): RecomendacaoSemanalBuilder {
            this.idRecomendacaoSemanal = idRecomendacaoSemanal
            return this
        }

        fun dtpregini(dtpregini: LocalDate?): RecomendacaoSemanalBuilder {
            this.dtpregini = dtpregini
            return this
        }

        fun dtpregfim(dtpregfim: LocalDate?): RecomendacaoSemanalBuilder {
            this.dtpregfim = dtpregfim
            return this
        }

        fun recomendacao(recomendacao: Recomendacao?): RecomendacaoSemanalBuilder {
            this.recomendacao = recomendacao
            return this
        }

        fun build(): RecomendacaoSemanal {
            return RecomendacaoSemanal(idRecomendacaoSemanal, dtpregini, dtpregfim, recomendacao)
        }

        override fun toString(): String {
            return ("RecomendacaoSemanal.RecomendacaoSemanalBuilder(idRecomendacaoSemanal="
                    + idRecomendacaoSemanal + ", dtpregini=" + dtpregini + ", dtpregfim="
                    + dtpregfim + ", recomendacao=" + recomendacao + ")")
        }
    }

    companion object {
        @kotlin.jvm.JvmStatic
        fun builder(): RecomendacaoSemanalBuilder {
            return RecomendacaoSemanalBuilder()
        }
    }
}