package com.ricardococati.model.entities

import java.time.LocalDate

class RecomendacaoDiario {
    var idRecomendacaoDiario: Long? = null
    var dtpreg: LocalDate? = null
    var recomendacao: Recomendacao? = null

    constructor(idRecomendacaoDiario: Long?, dtpreg: LocalDate?,
                recomendacao: Recomendacao?) {
        this.idRecomendacaoDiario = idRecomendacaoDiario
        this.dtpreg = dtpreg
        this.recomendacao = recomendacao
    }

    constructor() {}

    override fun equals(o: Any?): Boolean {
        if (o === this) {
            return true
        }
        if (o !is RecomendacaoDiario) {
            return false
        }
        val other = o
        if (!other.canEqual(this as Any)) {
            return false
        }
        val `this$idRecomendacaoDiario`: Any? = idRecomendacaoDiario
        val `other$idRecomendacaoDiario`: Any? = other.idRecomendacaoDiario
        if (if (`this$idRecomendacaoDiario` == null) `other$idRecomendacaoDiario` != null else `this$idRecomendacaoDiario` != `other$idRecomendacaoDiario`) {
            return false
        }
        val `this$dtpreg`: Any? = dtpreg
        val `other$dtpreg`: Any? = other.dtpreg
        if (if (`this$dtpreg` == null) `other$dtpreg` != null else `this$dtpreg` != `other$dtpreg`) {
            return false
        }
        val `this$recomendacao`: Any? = recomendacao
        val `other$recomendacao`: Any? = other.recomendacao
        return if (if (`this$recomendacao` == null) `other$recomendacao` != null else `this$recomendacao` != `other$recomendacao`) {
            false
        } else true
    }

    protected fun canEqual(other: Any?): Boolean {
        return other is RecomendacaoDiario
    }

    override fun hashCode(): Int {
        val PRIME = 59
        var result = 1
        val `$idRecomendacaoDiario`: Any? = idRecomendacaoDiario
        result = result * PRIME + (`$idRecomendacaoDiario`?.hashCode() ?: 43)
        val `$dtpreg`: Any? = dtpreg
        result = result * PRIME + (`$dtpreg`?.hashCode() ?: 43)
        val `$recomendacao`: Any? = recomendacao
        result = result * PRIME + (`$recomendacao`?.hashCode() ?: 43)
        return result
    }

    override fun toString(): String {
        return ("RecomendacaoDiario(idRecomendacaoDiario=" + idRecomendacaoDiario + ", dtpreg="
                + dtpreg + ", recomendacao=" + recomendacao + ")")
    }

    class RecomendacaoDiarioBuilder internal constructor() {
        private var idRecomendacaoDiario: Long? = null
        private var dtpreg: LocalDate? = null
        private var recomendacao: Recomendacao? = null
        fun idRecomendacaoDiario(
                idRecomendacaoDiario: Long?): RecomendacaoDiarioBuilder {
            this.idRecomendacaoDiario = idRecomendacaoDiario
            return this
        }

        fun dtpreg(dtpreg: LocalDate?): RecomendacaoDiarioBuilder {
            this.dtpreg = dtpreg
            return this
        }

        fun recomendacao(recomendacao: Recomendacao?): RecomendacaoDiarioBuilder {
            this.recomendacao = recomendacao
            return this
        }

        fun build(): RecomendacaoDiario {
            return RecomendacaoDiario(idRecomendacaoDiario, dtpreg, recomendacao)
        }

        override fun toString(): String {
            return ("RecomendacaoDiario.RecomendacaoDiarioBuilder(idRecomendacaoDiario="
                    + idRecomendacaoDiario + ", dtpreg=" + dtpreg + ", recomendacao="
                    + recomendacao + ")")
        }
    }

    companion object {
        @kotlin.jvm.JvmStatic
        fun builder(): RecomendacaoDiarioBuilder {
            return RecomendacaoDiarioBuilder()
        }
    }
}