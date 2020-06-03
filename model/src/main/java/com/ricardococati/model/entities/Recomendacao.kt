package com.ricardococati.model.entities

import java.math.BigDecimal

class Recomendacao {
    var codneg: String? = null
    var precoFechamento: BigDecimal? = null
    var precoMME12p: BigDecimal? = null
    var precoMME26p: BigDecimal? = null
    var precoMacd: BigDecimal? = null
    var precoSinalMacd: BigDecimal? = null
    var precoHistograma: BigDecimal? = null
    var decisao: String? = null

    constructor(codneg: String?, precoFechamento: BigDecimal?, precoMME12p: BigDecimal?,
                precoMME26p: BigDecimal?, precoMacd: BigDecimal?, precoSinalMacd: BigDecimal?,
                precoHistograma: BigDecimal?, decisao: String?) {
        this.codneg = codneg
        this.precoFechamento = precoFechamento
        this.precoMME12p = precoMME12p
        this.precoMME26p = precoMME26p
        this.precoMacd = precoMacd
        this.precoSinalMacd = precoSinalMacd
        this.precoHistograma = precoHistograma
        this.decisao = decisao
    }

    constructor() {}

    override fun equals(o: Any?): Boolean {
        if (o === this) {
            return true
        }
        if (o !is Recomendacao) {
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
        val `this$precoFechamento`: Any? = precoFechamento
        val `other$precoFechamento`: Any? = other.precoFechamento
        if (if (`this$precoFechamento` == null) `other$precoFechamento` != null else `this$precoFechamento` != `other$precoFechamento`) {
            return false
        }
        val `this$precoMME12p`: Any? = precoMME12p
        val `other$precoMME12p`: Any? = other.precoMME12p
        if (if (`this$precoMME12p` == null) `other$precoMME12p` != null else `this$precoMME12p` != `other$precoMME12p`) {
            return false
        }
        val `this$precoMME26p`: Any? = precoMME26p
        val `other$precoMME26p`: Any? = other.precoMME26p
        if (if (`this$precoMME26p` == null) `other$precoMME26p` != null else `this$precoMME26p` != `other$precoMME26p`) {
            return false
        }
        val `this$precoMacd`: Any? = precoMacd
        val `other$precoMacd`: Any? = other.precoMacd
        if (if (`this$precoMacd` == null) `other$precoMacd` != null else `this$precoMacd` != `other$precoMacd`) {
            return false
        }
        val `this$precoSinalMacd`: Any? = precoSinalMacd
        val `other$precoSinalMacd`: Any? = other.precoSinalMacd
        if (if (`this$precoSinalMacd` == null) `other$precoSinalMacd` != null else `this$precoSinalMacd` != `other$precoSinalMacd`) {
            return false
        }
        val `this$precoHistograma`: Any? = precoHistograma
        val `other$precoHistograma`: Any? = other.precoHistograma
        if (if (`this$precoHistograma` == null) `other$precoHistograma` != null else `this$precoHistograma` != `other$precoHistograma`) {
            return false
        }
        val `this$decisao`: Any? = decisao
        val `other$decisao`: Any? = other.decisao
        return if (if (`this$decisao` == null) `other$decisao` != null else `this$decisao` != `other$decisao`) {
            false
        } else true
    }

    protected fun canEqual(other: Any?): Boolean {
        return other is Recomendacao
    }

    override fun hashCode(): Int {
        val PRIME = 59
        var result = 1
        val `$codneg`: Any? = codneg
        result = result * PRIME + (`$codneg`?.hashCode() ?: 43)
        val `$precoFechamento`: Any? = precoFechamento
        result = result * PRIME + (`$precoFechamento`?.hashCode() ?: 43)
        val `$precoMME12p`: Any? = precoMME12p
        result = result * PRIME + (`$precoMME12p`?.hashCode() ?: 43)
        val `$precoMME26p`: Any? = precoMME26p
        result = result * PRIME + (`$precoMME26p`?.hashCode() ?: 43)
        val `$precoMacd`: Any? = precoMacd
        result = result * PRIME + (`$precoMacd`?.hashCode() ?: 43)
        val `$precoSinalMacd`: Any? = precoSinalMacd
        result = result * PRIME + (`$precoSinalMacd`?.hashCode() ?: 43)
        val `$precoHistograma`: Any? = precoHistograma
        result = result * PRIME + (`$precoHistograma`?.hashCode() ?: 43)
        val `$decisao`: Any? = decisao
        result = result * PRIME + (`$decisao`?.hashCode() ?: 43)
        return result
    }

    override fun toString(): String {
        return ("Recomendacao(codneg=" + codneg + ", precoFechamento=" + precoFechamento + ", precoMME12p=" + precoMME12p + ", precoMME26p=" + precoMME26p + ", precoMacd=" + precoMacd + ", precoSinalMacd=" + precoSinalMacd + ", precoHistograma=" + precoHistograma + ", decisao="
                + decisao + ")")
    }

    class RecomendacaoBuilder internal constructor() {
        private var codneg: String? = null
        private var precoFechamento: BigDecimal? = null
        private var precoMME12p: BigDecimal? = null
        private var precoMME26p: BigDecimal? = null
        private var precoMacd: BigDecimal? = null
        private var precoSinalMacd: BigDecimal? = null
        private var precoHistograma: BigDecimal? = null
        private var decisao: String? = null
        fun codneg(codneg: String?): RecomendacaoBuilder {
            this.codneg = codneg
            return this
        }

        fun precoFechamento(precoFechamento: BigDecimal?): RecomendacaoBuilder {
            this.precoFechamento = precoFechamento
            return this
        }

        fun precoMME12p(precoMME12p: BigDecimal?): RecomendacaoBuilder {
            this.precoMME12p = precoMME12p
            return this
        }

        fun precoMME26p(precoMME26p: BigDecimal?): RecomendacaoBuilder {
            this.precoMME26p = precoMME26p
            return this
        }

        fun precoMacd(precoMacd: BigDecimal?): RecomendacaoBuilder {
            this.precoMacd = precoMacd
            return this
        }

        fun precoSinalMacd(precoSinalMacd: BigDecimal?): RecomendacaoBuilder {
            this.precoSinalMacd = precoSinalMacd
            return this
        }

        fun precoHistograma(precoHistograma: BigDecimal?): RecomendacaoBuilder {
            this.precoHistograma = precoHistograma
            return this
        }

        fun decisao(decisao: String?): RecomendacaoBuilder {
            this.decisao = decisao
            return this
        }

        fun build(): Recomendacao {
            return Recomendacao(codneg, precoFechamento, precoMME12p, precoMME26p, precoMacd,
                    precoSinalMacd, precoHistograma, decisao)
        }

        override fun toString(): String {
            return ("Recomendacao.RecomendacaoBuilder(codneg=" + codneg + ", precoFechamento="
                    + precoFechamento + ", precoMME12p=" + precoMME12p + ", precoMME26p="
                    + precoMME26p + ", precoMacd=" + precoMacd + ", precoSinalMacd="
                    + precoSinalMacd + ", precoHistograma=" + precoHistograma + ", decisao="
                    + decisao + ")")
        }
    }

    companion object {
        @kotlin.jvm.JvmStatic
        fun builder(): RecomendacaoBuilder {
            return RecomendacaoBuilder()
        }
    }
}