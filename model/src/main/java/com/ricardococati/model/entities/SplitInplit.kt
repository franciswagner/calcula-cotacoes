package com.ricardococati.model.entities

import com.ricardococati.model.enums.OperacaoSplitInplit
import java.time.LocalDate

class SplitInplit {
    var codneg: String? = null
    var dtpreg: LocalDate? = null
    var qtdSplitInplit: Int? = null
    var operacao: OperacaoSplitInplit? = null

    constructor(codneg: String?, dtpreg: LocalDate?, qtdSplitInplit: Int?,
                operacao: OperacaoSplitInplit?) {
        this.codneg = codneg
        this.dtpreg = dtpreg
        this.qtdSplitInplit = qtdSplitInplit
        this.operacao = operacao
    }

    constructor() {}

    override fun equals(o: Any?): Boolean {
        if (o === this) {
            return true
        }
        if (o !is SplitInplit) {
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
        val `this$dtpreg`: Any? = dtpreg
        val `other$dtpreg`: Any? = other.dtpreg
        if (if (`this$dtpreg` == null) `other$dtpreg` != null else `this$dtpreg` != `other$dtpreg`) {
            return false
        }
        val `this$qtdSplitInplit`: Any? = qtdSplitInplit
        val `other$qtdSplitInplit`: Any? = other.qtdSplitInplit
        if (if (`this$qtdSplitInplit` == null) `other$qtdSplitInplit` != null else `this$qtdSplitInplit` != `other$qtdSplitInplit`) {
            return false
        }
        val `this$operacao`: Any? = operacao
        val `other$operacao`: Any? = other.operacao
        return if (if (`this$operacao` == null) `other$operacao` != null else `this$operacao` != `other$operacao`) {
            false
        } else true
    }

    protected fun canEqual(other: Any?): Boolean {
        return other is SplitInplit
    }

    override fun hashCode(): Int {
        val PRIME = 59
        var result = 1
        val `$codneg`: Any? = codneg
        result = result * PRIME + (`$codneg`?.hashCode() ?: 43)
        val `$dtpreg`: Any? = dtpreg
        result = result * PRIME + (`$dtpreg`?.hashCode() ?: 43)
        val `$qtdSplitInplit`: Any? = qtdSplitInplit
        result = result * PRIME + (`$qtdSplitInplit`?.hashCode() ?: 43)
        val `$operacao`: Any? = operacao
        result = result * PRIME + (`$operacao`?.hashCode() ?: 43)
        return result
    }

    override fun toString(): String {
        return ("SplitInplit(codneg=" + codneg + ", dtpreg=" + dtpreg
                + ", qtdSplitInplit=" + qtdSplitInplit + ", operacao=" + operacao + ")")
    }

    class SplitInplitBuilder internal constructor() {
        private var codneg: String? = null
        private var dtpreg: LocalDate? = null
        private var qtdSplitInplit: Int? = null
        private var operacao: OperacaoSplitInplit? = null
        fun codneg(codneg: String?): SplitInplitBuilder {
            this.codneg = codneg
            return this
        }

        fun dtpreg(dtpreg: LocalDate?): SplitInplitBuilder {
            this.dtpreg = dtpreg
            return this
        }

        fun qtdSplitInplit(qtdSplitInplit: Int?): SplitInplitBuilder {
            this.qtdSplitInplit = qtdSplitInplit
            return this
        }

        fun operacao(operacao: OperacaoSplitInplit?): SplitInplitBuilder {
            this.operacao = operacao
            return this
        }

        fun build(): SplitInplit {
            return SplitInplit(codneg, dtpreg, qtdSplitInplit, operacao)
        }

        override fun toString(): String {
            return ("SplitInplit.SplitInplitBuilder(codneg=" + codneg + ", dtpreg=" + dtpreg
                    + ", qtdSplitInplit=" + qtdSplitInplit + ", operacao=" + operacao + ")")
        }
    }

    companion object {
        @kotlin.jvm.JvmStatic
        fun builder(): SplitInplitBuilder {
            return SplitInplitBuilder()
        }
    }
}