package com.ricardococati.model.entities

import java.time.LocalDate

class ControleExecucao {
    var idControleExecucao: Long? = null
    var controleExecucaoAtivo: Boolean? = null
    var calcMediaSimplesDiarioExecutado: Boolean? = null
    var calcMediaSimplesDiarioExecutadoDtpreg: LocalDate? = null
    var calcMediaSimplesSemanalExecutado: Boolean? = null
    var calcMediaSimplesSemanalExecutadoDtpreg: LocalDate? = null
    var calcMediaExponencialSemanalExecutado: Boolean? = null
    var calcMediaExponencialSemanalExecutadoDtpreg: LocalDate? = null
    var calcMediaExponencialDiarioExecutado: Boolean? = null
    var calcMediaExponencialDiarioExecutadoDtpreg: LocalDate? = null
    var calcMacdDiarioExecutado: Boolean? = null
    var calcMacdDiarioExecutadoDtpreg: LocalDate? = null
    var calcMacdSemanalExecutado: Boolean? = null
    var calcMacdSemanalExecutadoDtpreg: LocalDate? = null
    var calcSinalMacdDiarioExecutado: Boolean? = null
    var calcSinalMacdDiarioExecutadoDtpreg: LocalDate? = null
    var calcSinalMacdSemanalExecutado: Boolean? = null
    var calcSinalMacdSemanalExecutadoDtpreg: LocalDate? = null
    var calcHistogramaDiarioExecutado: Boolean? = null
    var calcHistogramaDiarioExecutadoDtpreg: LocalDate? = null
    var calcHistogramaSemanalExecutado: Boolean? = null
    var calcHistogramaSemanalExecutadoDtpreg: LocalDate? = null

    constructor(idControleExecucao: Long?, controleExecucaoAtivo: Boolean?,
                calcMediaSimplesDiarioExecutado: Boolean?, calcMediaSimplesDiarioExecutadoDtpreg: LocalDate?,
                calcMediaSimplesSemanalExecutado: Boolean?, calcMediaSimplesSemanalExecutadoDtpreg: LocalDate?,
                calcMediaExponencialSemanalExecutado: Boolean?,
                calcMediaExponencialSemanalExecutadoDtpreg: LocalDate?,
                calcMediaExponencialDiarioExecutado: Boolean?,
                calcMediaExponencialDiarioExecutadoDtpreg: LocalDate?, calcMacdDiarioExecutado: Boolean?,
                calcMacdDiarioExecutadoDtpreg: LocalDate?, calcMacdSemanalExecutado: Boolean?,
                calcMacdSemanalExecutadoDtpreg: LocalDate?, calcSinalMacdDiarioExecutado: Boolean?,
                calcSinalMacdDiarioExecutadoDtpreg: LocalDate?, calcSinalMacdSemanalExecutado: Boolean?,
                calcSinalMacdSemanalExecutadoDtpreg: LocalDate?, calcHistogramaDiarioExecutado: Boolean?,
                calcHistogramaDiarioExecutadoDtpreg: LocalDate?, calcHistogramaSemanalExecutado: Boolean?,
                calcHistogramaSemanalExecutadoDtpreg: LocalDate?) {
        this.idControleExecucao = idControleExecucao
        this.controleExecucaoAtivo = controleExecucaoAtivo
        this.calcMediaSimplesDiarioExecutado = calcMediaSimplesDiarioExecutado
        this.calcMediaSimplesDiarioExecutadoDtpreg = calcMediaSimplesDiarioExecutadoDtpreg
        this.calcMediaSimplesSemanalExecutado = calcMediaSimplesSemanalExecutado
        this.calcMediaSimplesSemanalExecutadoDtpreg = calcMediaSimplesSemanalExecutadoDtpreg
        this.calcMediaExponencialSemanalExecutado = calcMediaExponencialSemanalExecutado
        this.calcMediaExponencialSemanalExecutadoDtpreg = calcMediaExponencialSemanalExecutadoDtpreg
        this.calcMediaExponencialDiarioExecutado = calcMediaExponencialDiarioExecutado
        this.calcMediaExponencialDiarioExecutadoDtpreg = calcMediaExponencialDiarioExecutadoDtpreg
        this.calcMacdDiarioExecutado = calcMacdDiarioExecutado
        this.calcMacdDiarioExecutadoDtpreg = calcMacdDiarioExecutadoDtpreg
        this.calcMacdSemanalExecutado = calcMacdSemanalExecutado
        this.calcMacdSemanalExecutadoDtpreg = calcMacdSemanalExecutadoDtpreg
        this.calcSinalMacdDiarioExecutado = calcSinalMacdDiarioExecutado
        this.calcSinalMacdDiarioExecutadoDtpreg = calcSinalMacdDiarioExecutadoDtpreg
        this.calcSinalMacdSemanalExecutado = calcSinalMacdSemanalExecutado
        this.calcSinalMacdSemanalExecutadoDtpreg = calcSinalMacdSemanalExecutadoDtpreg
        this.calcHistogramaDiarioExecutado = calcHistogramaDiarioExecutado
        this.calcHistogramaDiarioExecutadoDtpreg = calcHistogramaDiarioExecutadoDtpreg
        this.calcHistogramaSemanalExecutado = calcHistogramaSemanalExecutado
        this.calcHistogramaSemanalExecutadoDtpreg = calcHistogramaSemanalExecutadoDtpreg
    }

    constructor() {}

    override fun equals(o: Any?): Boolean {
        if (o === this) {
            return true
        }
        if (o !is ControleExecucao) {
            return false
        }
        val other = o
        if (!other.canEqual(this as Any)) {
            return false
        }
        val `this$idControleExecucao`: Any? = idControleExecucao
        val `other$idControleExecucao`: Any? = other.idControleExecucao
        if (if (`this$idControleExecucao` == null) `other$idControleExecucao` != null else `this$idControleExecucao` != `other$idControleExecucao`) {
            return false
        }
        val `this$controleExecucaoAtivo`: Any? = controleExecucaoAtivo
        val `other$controleExecucaoAtivo`: Any? = other.controleExecucaoAtivo
        if (if (`this$controleExecucaoAtivo` == null) `other$controleExecucaoAtivo` != null else `this$controleExecucaoAtivo` != `other$controleExecucaoAtivo`) {
            return false
        }
        val `this$calcMediaSimplesDiarioExecutado`: Any? = calcMediaSimplesDiarioExecutado
        val `other$calcMediaSimplesDiarioExecutado`: Any? = other.calcMediaSimplesDiarioExecutado
        if (if (`this$calcMediaSimplesDiarioExecutado` == null) `other$calcMediaSimplesDiarioExecutado` != null else `this$calcMediaSimplesDiarioExecutado` != `other$calcMediaSimplesDiarioExecutado`) {
            return false
        }
        val `this$calcMediaSimplesDiarioExecutadoDtpreg`: Any? = calcMediaSimplesDiarioExecutadoDtpreg
        val `other$calcMediaSimplesDiarioExecutadoDtpreg`: Any? = other
                .calcMediaSimplesDiarioExecutadoDtpreg
        if (if (`this$calcMediaSimplesDiarioExecutadoDtpreg` == null) `other$calcMediaSimplesDiarioExecutadoDtpreg` != null else `this$calcMediaSimplesDiarioExecutadoDtpreg` != `other$calcMediaSimplesDiarioExecutadoDtpreg`) {
            return false
        }
        val `this$calcMediaSimplesSemanalExecutado`: Any? = calcMediaSimplesSemanalExecutado
        val `other$calcMediaSimplesSemanalExecutado`: Any? = other
                .calcMediaSimplesSemanalExecutado
        if (if (`this$calcMediaSimplesSemanalExecutado` == null) `other$calcMediaSimplesSemanalExecutado`
                        != null else `this$calcMediaSimplesSemanalExecutado` != `other$calcMediaSimplesSemanalExecutado`) {
            return false
        }
        val `this$calcMediaSimplesSemanalExecutadoDtpreg`: Any? = calcMediaSimplesSemanalExecutadoDtpreg
        val `other$calcMediaSimplesSemanalExecutadoDtpreg`: Any? = other
                .calcMediaSimplesSemanalExecutadoDtpreg
        if (if (`this$calcMediaSimplesSemanalExecutadoDtpreg` == null) `other$calcMediaSimplesSemanalExecutadoDtpreg` != null else `this$calcMediaSimplesSemanalExecutadoDtpreg` != `other$calcMediaSimplesSemanalExecutadoDtpreg`) {
            return false
        }
        val `this$calcMediaExponencialSemanalExecutado`: Any? = calcMediaExponencialSemanalExecutado
        val `other$calcMediaExponencialSemanalExecutado`: Any? = other
                .calcMediaExponencialSemanalExecutado
        if (if (`this$calcMediaExponencialSemanalExecutado` == null) `other$calcMediaExponencialSemanalExecutado` != null else `this$calcMediaExponencialSemanalExecutado` != `other$calcMediaExponencialSemanalExecutado`) {
            return false
        }
        val `this$calcMediaExponencialSemanalExecutadoDtpreg`: Any? = calcMediaExponencialSemanalExecutadoDtpreg
        val `other$calcMediaExponencialSemanalExecutadoDtpreg`: Any? = other
                .calcMediaExponencialSemanalExecutadoDtpreg
        if (if (`this$calcMediaExponencialSemanalExecutadoDtpreg` == null) `other$calcMediaExponencialSemanalExecutadoDtpreg` != null else `this$calcMediaExponencialSemanalExecutadoDtpreg` != `other$calcMediaExponencialSemanalExecutadoDtpreg`) {
            return false
        }
        val `this$calcMediaExponencialDiarioExecutado`: Any? = calcMediaExponencialDiarioExecutado
        val `other$calcMediaExponencialDiarioExecutado`: Any? = other
                .calcMediaExponencialDiarioExecutado
        if (if (`this$calcMediaExponencialDiarioExecutado` == null) `other$calcMediaExponencialDiarioExecutado`
                        != null else `this$calcMediaExponencialDiarioExecutado` != `other$calcMediaExponencialDiarioExecutado`) {
            return false
        }
        val `this$calcMediaExponencialDiarioExecutadoDtpreg`: Any? = calcMediaExponencialDiarioExecutadoDtpreg
        val `other$calcMediaExponencialDiarioExecutadoDtpreg`: Any? = other
                .calcMediaExponencialDiarioExecutadoDtpreg
        if (if (`this$calcMediaExponencialDiarioExecutadoDtpreg` == null) `other$calcMediaExponencialDiarioExecutadoDtpreg` != null else `this$calcMediaExponencialDiarioExecutadoDtpreg` != `other$calcMediaExponencialDiarioExecutadoDtpreg`) {
            return false
        }
        val `this$calcMacdDiarioExecutado`: Any? = calcMacdDiarioExecutado
        val `other$calcMacdDiarioExecutado`: Any? = other.calcMacdDiarioExecutado
        if (if (`this$calcMacdDiarioExecutado` == null) `other$calcMacdDiarioExecutado` != null else `this$calcMacdDiarioExecutado` != `other$calcMacdDiarioExecutado`) {
            return false
        }
        val `this$calcMacdDiarioExecutadoDtpreg`: Any? = calcMacdDiarioExecutadoDtpreg
        val `other$calcMacdDiarioExecutadoDtpreg`: Any? = other.calcMacdDiarioExecutadoDtpreg
        if (if (`this$calcMacdDiarioExecutadoDtpreg` == null) `other$calcMacdDiarioExecutadoDtpreg` != null else `this$calcMacdDiarioExecutadoDtpreg` != `other$calcMacdDiarioExecutadoDtpreg`) {
            return false
        }
        val `this$calcMacdSemanalExecutado`: Any? = calcMacdSemanalExecutado
        val `other$calcMacdSemanalExecutado`: Any? = other.calcMacdSemanalExecutado
        if (if (`this$calcMacdSemanalExecutado` == null) `other$calcMacdSemanalExecutado` != null else `this$calcMacdSemanalExecutado` != `other$calcMacdSemanalExecutado`) {
            return false
        }
        val `this$calcMacdSemanalExecutadoDtpreg`: Any? = calcMacdSemanalExecutadoDtpreg
        val `other$calcMacdSemanalExecutadoDtpreg`: Any? = other.calcMacdSemanalExecutadoDtpreg
        if (if (`this$calcMacdSemanalExecutadoDtpreg` == null) `other$calcMacdSemanalExecutadoDtpreg` != null else `this$calcMacdSemanalExecutadoDtpreg` != `other$calcMacdSemanalExecutadoDtpreg`) {
            return false
        }
        val `this$calcSinalMacdDiarioExecutado`: Any? = calcSinalMacdDiarioExecutado
        val `other$calcSinalMacdDiarioExecutado`: Any? = other.calcSinalMacdDiarioExecutado
        if (if (`this$calcSinalMacdDiarioExecutado` == null) `other$calcSinalMacdDiarioExecutado` != null else `this$calcSinalMacdDiarioExecutado` != `other$calcSinalMacdDiarioExecutado`) {
            return false
        }
        val `this$calcSinalMacdDiarioExecutadoDtpreg`: Any? = calcSinalMacdDiarioExecutadoDtpreg
        val `other$calcSinalMacdDiarioExecutadoDtpreg`: Any? = other
                .calcSinalMacdDiarioExecutadoDtpreg
        if (if (`this$calcSinalMacdDiarioExecutadoDtpreg` == null) `other$calcSinalMacdDiarioExecutadoDtpreg`
                        != null else `this$calcSinalMacdDiarioExecutadoDtpreg` != `other$calcSinalMacdDiarioExecutadoDtpreg`) {
            return false
        }
        val `this$calcSinalMacdSemanalExecutado`: Any? = calcSinalMacdSemanalExecutado
        val `other$calcSinalMacdSemanalExecutado`: Any? = other.calcSinalMacdSemanalExecutado
        if (if (`this$calcSinalMacdSemanalExecutado` == null) `other$calcSinalMacdSemanalExecutado` != null else `this$calcSinalMacdSemanalExecutado` != `other$calcSinalMacdSemanalExecutado`) {
            return false
        }
        val `this$calcSinalMacdSemanalExecutadoDtpreg`: Any? = calcSinalMacdSemanalExecutadoDtpreg
        val `other$calcSinalMacdSemanalExecutadoDtpreg`: Any? = other
                .calcSinalMacdSemanalExecutadoDtpreg
        if (if (`this$calcSinalMacdSemanalExecutadoDtpreg` == null) `other$calcSinalMacdSemanalExecutadoDtpreg`
                        != null else `this$calcSinalMacdSemanalExecutadoDtpreg` != `other$calcSinalMacdSemanalExecutadoDtpreg`) {
            return false
        }
        val `this$calcHistogramaDiarioExecutado`: Any? = calcHistogramaDiarioExecutado
        val `other$calcHistogramaDiarioExecutado`: Any? = other.calcHistogramaDiarioExecutado
        if (if (`this$calcHistogramaDiarioExecutado` == null) `other$calcHistogramaDiarioExecutado` != null else `this$calcHistogramaDiarioExecutado` != `other$calcHistogramaDiarioExecutado`) {
            return false
        }
        val `this$calcHistogramaDiarioExecutadoDtpreg`: Any? = calcHistogramaDiarioExecutadoDtpreg
        val `other$calcHistogramaDiarioExecutadoDtpreg`: Any? = other
                .calcHistogramaDiarioExecutadoDtpreg
        if (if (`this$calcHistogramaDiarioExecutadoDtpreg` == null) `other$calcHistogramaDiarioExecutadoDtpreg`
                        != null else `this$calcHistogramaDiarioExecutadoDtpreg` != `other$calcHistogramaDiarioExecutadoDtpreg`) {
            return false
        }
        val `this$calcHistogramaSemanalExecutado`: Any? = calcHistogramaSemanalExecutado
        val `other$calcHistogramaSemanalExecutado`: Any? = other.calcHistogramaSemanalExecutado
        if (if (`this$calcHistogramaSemanalExecutado` == null) `other$calcHistogramaSemanalExecutado` != null else `this$calcHistogramaSemanalExecutado` != `other$calcHistogramaSemanalExecutado`) {
            return false
        }
        val `this$calcHistogramaSemanalExecutadoDtpreg`: Any? = calcHistogramaSemanalExecutadoDtpreg
        val `other$calcHistogramaSemanalExecutadoDtpreg`: Any? = other
                .calcHistogramaSemanalExecutadoDtpreg
        return if (if (`this$calcHistogramaSemanalExecutadoDtpreg` == null) `other$calcHistogramaSemanalExecutadoDtpreg` != null else `this$calcHistogramaSemanalExecutadoDtpreg` != `other$calcHistogramaSemanalExecutadoDtpreg`) {
            false
        } else true
    }

    protected fun canEqual(other: Any?): Boolean {
        return other is ControleExecucao
    }

    override fun hashCode(): Int {
        val PRIME = 59
        var result = 1
        val `$idControleExecucao`: Any? = idControleExecucao
        result = result * PRIME + (`$idControleExecucao`?.hashCode() ?: 43)
        val `$controleExecucaoAtivo`: Any? = controleExecucaoAtivo
        result = result * PRIME + (`$controleExecucaoAtivo`?.hashCode() ?: 43)
        val `$calcMediaSimplesDiarioExecutado`: Any? = calcMediaSimplesDiarioExecutado
        result = result * PRIME + (`$calcMediaSimplesDiarioExecutado`?.hashCode() ?: 43)
        val `$calcMediaSimplesDiarioExecutadoDtpreg`: Any? = calcMediaSimplesDiarioExecutadoDtpreg
        result = result * PRIME + (`$calcMediaSimplesDiarioExecutadoDtpreg`?.hashCode() ?: 43)
        val `$calcMediaSimplesSemanalExecutado`: Any? = calcMediaSimplesSemanalExecutado
        result = result * PRIME + (`$calcMediaSimplesSemanalExecutado`?.hashCode() ?: 43)
        val `$calcMediaSimplesSemanalExecutadoDtpreg`: Any? = calcMediaSimplesSemanalExecutadoDtpreg
        result = result * PRIME + (`$calcMediaSimplesSemanalExecutadoDtpreg`?.hashCode() ?: 43)
        val `$calcMediaExponencialSemanalExecutado`: Any? = calcMediaExponencialSemanalExecutado
        result = result * PRIME + (`$calcMediaExponencialSemanalExecutado`?.hashCode() ?: 43)
        val `$calcMediaExponencialSemanalExecutadoDtpreg`: Any? = calcMediaExponencialSemanalExecutadoDtpreg
        result = result * PRIME + (`$calcMediaExponencialSemanalExecutadoDtpreg`?.hashCode() ?: 43)
        val `$calcMediaExponencialDiarioExecutado`: Any? = calcMediaExponencialDiarioExecutado
        result = result * PRIME + (`$calcMediaExponencialDiarioExecutado`?.hashCode() ?: 43)
        val `$calcMediaExponencialDiarioExecutadoDtpreg`: Any? = calcMediaExponencialDiarioExecutadoDtpreg
        result = result * PRIME + (`$calcMediaExponencialDiarioExecutadoDtpreg`?.hashCode() ?: 43)
        val `$calcMacdDiarioExecutado`: Any? = calcMacdDiarioExecutado
        result = result * PRIME + (`$calcMacdDiarioExecutado`?.hashCode() ?: 43)
        val `$calcMacdDiarioExecutadoDtpreg`: Any? = calcMacdDiarioExecutadoDtpreg
        result = result * PRIME + (`$calcMacdDiarioExecutadoDtpreg`?.hashCode() ?: 43)
        val `$calcMacdSemanalExecutado`: Any? = calcMacdSemanalExecutado
        result = result * PRIME + (`$calcMacdSemanalExecutado`?.hashCode() ?: 43)
        val `$calcMacdSemanalExecutadoDtpreg`: Any? = calcMacdSemanalExecutadoDtpreg
        result = result * PRIME + (`$calcMacdSemanalExecutadoDtpreg`?.hashCode() ?: 43)
        val `$calcSinalMacdDiarioExecutado`: Any? = calcSinalMacdDiarioExecutado
        result = result * PRIME + (`$calcSinalMacdDiarioExecutado`?.hashCode() ?: 43)
        val `$calcSinalMacdDiarioExecutadoDtpreg`: Any? = calcSinalMacdDiarioExecutadoDtpreg
        result = result * PRIME + (`$calcSinalMacdDiarioExecutadoDtpreg`?.hashCode() ?: 43)
        val `$calcSinalMacdSemanalExecutado`: Any? = calcSinalMacdSemanalExecutado
        result = result * PRIME + (`$calcSinalMacdSemanalExecutado`?.hashCode() ?: 43)
        val `$calcSinalMacdSemanalExecutadoDtpreg`: Any? = calcSinalMacdSemanalExecutadoDtpreg
        result = result * PRIME + (`$calcSinalMacdSemanalExecutadoDtpreg`?.hashCode() ?: 43)
        val `$calcHistogramaDiarioExecutado`: Any? = calcHistogramaDiarioExecutado
        result = result * PRIME + (`$calcHistogramaDiarioExecutado`?.hashCode() ?: 43)
        val `$calcHistogramaDiarioExecutadoDtpreg`: Any? = calcHistogramaDiarioExecutadoDtpreg
        result = result * PRIME + (`$calcHistogramaDiarioExecutadoDtpreg`?.hashCode() ?: 43)
        val `$calcHistogramaSemanalExecutado`: Any? = calcHistogramaSemanalExecutado
        result = result * PRIME + (`$calcHistogramaSemanalExecutado`?.hashCode() ?: 43)
        val `$calcHistogramaSemanalExecutadoDtpreg`: Any? = calcHistogramaSemanalExecutadoDtpreg
        result = result * PRIME + (`$calcHistogramaSemanalExecutadoDtpreg`?.hashCode() ?: 43)
        return result
    }

    override fun toString(): String {
        return ("ControleExecucao(idControleExecucao=" + idControleExecucao
                + ", controleExecucaoAtivo=" + controleExecucaoAtivo
                + ", calcMediaSimplesDiarioExecutado=" + calcMediaSimplesDiarioExecutado
                + ", calcMediaSimplesDiarioExecutadoDtpreg=" + calcMediaSimplesDiarioExecutadoDtpreg + ", calcMediaSimplesSemanalExecutado=" + calcMediaSimplesSemanalExecutado + ", calcMediaSimplesSemanalExecutadoDtpreg=" + calcMediaSimplesSemanalExecutadoDtpreg + ", calcMediaExponencialSemanalExecutado="
                + calcMediaExponencialSemanalExecutado
                + ", calcMediaExponencialSemanalExecutadoDtpreg=" + calcMediaExponencialSemanalExecutadoDtpreg + ", calcMediaExponencialDiarioExecutado="
                + calcMediaExponencialDiarioExecutado
                + ", calcMediaExponencialDiarioExecutadoDtpreg=" + calcMediaExponencialDiarioExecutadoDtpreg + ", calcMacdDiarioExecutado=" + calcMacdDiarioExecutado + ", calcMacdDiarioExecutadoDtpreg=" + calcMacdDiarioExecutadoDtpreg + ", calcMacdSemanalExecutado=" + calcMacdSemanalExecutado + ", calcMacdSemanalExecutadoDtpreg=" + calcMacdSemanalExecutadoDtpreg + ", calcSinalMacdDiarioExecutado=" + calcSinalMacdDiarioExecutado + ", calcSinalMacdDiarioExecutadoDtpreg=" + calcSinalMacdDiarioExecutadoDtpreg + ", calcSinalMacdSemanalExecutado=" + calcSinalMacdSemanalExecutado + ", calcSinalMacdSemanalExecutadoDtpreg=" + calcSinalMacdSemanalExecutadoDtpreg + ", calcHistogramaDiarioExecutado=" + calcHistogramaDiarioExecutado + ", calcHistogramaDiarioExecutadoDtpreg=" + calcHistogramaDiarioExecutadoDtpreg + ", calcHistogramaSemanalExecutado=" + calcHistogramaSemanalExecutado + ", calcHistogramaSemanalExecutadoDtpreg=" + calcHistogramaSemanalExecutadoDtpreg + ")")
    }

    class ControleExecucaoBuilder internal constructor() {
        private var idControleExecucao: Long? = null
        private var controleExecucaoAtivo: Boolean? = null
        private var calcMediaSimplesDiarioExecutado: Boolean? = null
        private var calcMediaSimplesDiarioExecutadoDtpreg: LocalDate? = null
        private var calcMediaSimplesSemanalExecutado: Boolean? = null
        private var calcMediaSimplesSemanalExecutadoDtpreg: LocalDate? = null
        private var calcMediaExponencialSemanalExecutado: Boolean? = null
        private var calcMediaExponencialSemanalExecutadoDtpreg: LocalDate? = null
        private var calcMediaExponencialDiarioExecutado: Boolean? = null
        private var calcMediaExponencialDiarioExecutadoDtpreg: LocalDate? = null
        private var calcMacdDiarioExecutado: Boolean? = null
        private var calcMacdDiarioExecutadoDtpreg: LocalDate? = null
        private var calcMacdSemanalExecutado: Boolean? = null
        private var calcMacdSemanalExecutadoDtpreg: LocalDate? = null
        private var calcSinalMacdDiarioExecutado: Boolean? = null
        private var calcSinalMacdDiarioExecutadoDtpreg: LocalDate? = null
        private var calcSinalMacdSemanalExecutado: Boolean? = null
        private var calcSinalMacdSemanalExecutadoDtpreg: LocalDate? = null
        private var calcHistogramaDiarioExecutado: Boolean? = null
        private var calcHistogramaDiarioExecutadoDtpreg: LocalDate? = null
        private var calcHistogramaSemanalExecutado: Boolean? = null
        private var calcHistogramaSemanalExecutadoDtpreg: LocalDate? = null
        fun idControleExecucao(idControleExecucao: Long?): ControleExecucaoBuilder {
            this.idControleExecucao = idControleExecucao
            return this
        }

        fun controleExecucaoAtivo(
                controleExecucaoAtivo: Boolean?): ControleExecucaoBuilder {
            this.controleExecucaoAtivo = controleExecucaoAtivo
            return this
        }

        fun calcMediaSimplesDiarioExecutado(
                calcMediaSimplesDiarioExecutado: Boolean?): ControleExecucaoBuilder {
            this.calcMediaSimplesDiarioExecutado = calcMediaSimplesDiarioExecutado
            return this
        }

        fun calcMediaSimplesDiarioExecutadoDtpreg(
                calcMediaSimplesDiarioExecutadoDtpreg: LocalDate?): ControleExecucaoBuilder {
            this.calcMediaSimplesDiarioExecutadoDtpreg = calcMediaSimplesDiarioExecutadoDtpreg
            return this
        }

        fun calcMediaSimplesSemanalExecutado(
                calcMediaSimplesSemanalExecutado: Boolean?): ControleExecucaoBuilder {
            this.calcMediaSimplesSemanalExecutado = calcMediaSimplesSemanalExecutado
            return this
        }

        fun calcMediaSimplesSemanalExecutadoDtpreg(
                calcMediaSimplesSemanalExecutadoDtpreg: LocalDate?): ControleExecucaoBuilder {
            this.calcMediaSimplesSemanalExecutadoDtpreg = calcMediaSimplesSemanalExecutadoDtpreg
            return this
        }

        fun calcMediaExponencialSemanalExecutado(
                calcMediaExponencialSemanalExecutado: Boolean?): ControleExecucaoBuilder {
            this.calcMediaExponencialSemanalExecutado = calcMediaExponencialSemanalExecutado
            return this
        }

        fun calcMediaExponencialSemanalExecutadoDtpreg(
                calcMediaExponencialSemanalExecutadoDtpreg: LocalDate?): ControleExecucaoBuilder {
            this.calcMediaExponencialSemanalExecutadoDtpreg = calcMediaExponencialSemanalExecutadoDtpreg
            return this
        }

        fun calcMediaExponencialDiarioExecutado(
                calcMediaExponencialDiarioExecutado: Boolean?): ControleExecucaoBuilder {
            this.calcMediaExponencialDiarioExecutado = calcMediaExponencialDiarioExecutado
            return this
        }

        fun calcMediaExponencialDiarioExecutadoDtpreg(
                calcMediaExponencialDiarioExecutadoDtpreg: LocalDate?): ControleExecucaoBuilder {
            this.calcMediaExponencialDiarioExecutadoDtpreg = calcMediaExponencialDiarioExecutadoDtpreg
            return this
        }

        fun calcMacdDiarioExecutado(
                calcMacdDiarioExecutado: Boolean?): ControleExecucaoBuilder {
            this.calcMacdDiarioExecutado = calcMacdDiarioExecutado
            return this
        }

        fun calcMacdDiarioExecutadoDtpreg(
                calcMacdDiarioExecutadoDtpreg: LocalDate?): ControleExecucaoBuilder {
            this.calcMacdDiarioExecutadoDtpreg = calcMacdDiarioExecutadoDtpreg
            return this
        }

        fun calcMacdSemanalExecutado(
                calcMacdSemanalExecutado: Boolean?): ControleExecucaoBuilder {
            this.calcMacdSemanalExecutado = calcMacdSemanalExecutado
            return this
        }

        fun calcMacdSemanalExecutadoDtpreg(
                calcMacdSemanalExecutadoDtpreg: LocalDate?): ControleExecucaoBuilder {
            this.calcMacdSemanalExecutadoDtpreg = calcMacdSemanalExecutadoDtpreg
            return this
        }

        fun calcSinalMacdDiarioExecutado(
                calcSinalMacdDiarioExecutado: Boolean?): ControleExecucaoBuilder {
            this.calcSinalMacdDiarioExecutado = calcSinalMacdDiarioExecutado
            return this
        }

        fun calcSinalMacdDiarioExecutadoDtpreg(
                calcSinalMacdDiarioExecutadoDtpreg: LocalDate?): ControleExecucaoBuilder {
            this.calcSinalMacdDiarioExecutadoDtpreg = calcSinalMacdDiarioExecutadoDtpreg
            return this
        }

        fun calcSinalMacdSemanalExecutado(
                calcSinalMacdSemanalExecutado: Boolean?): ControleExecucaoBuilder {
            this.calcSinalMacdSemanalExecutado = calcSinalMacdSemanalExecutado
            return this
        }

        fun calcSinalMacdSemanalExecutadoDtpreg(
                calcSinalMacdSemanalExecutadoDtpreg: LocalDate?): ControleExecucaoBuilder {
            this.calcSinalMacdSemanalExecutadoDtpreg = calcSinalMacdSemanalExecutadoDtpreg
            return this
        }

        fun calcHistogramaDiarioExecutado(
                calcHistogramaDiarioExecutado: Boolean?): ControleExecucaoBuilder {
            this.calcHistogramaDiarioExecutado = calcHistogramaDiarioExecutado
            return this
        }

        fun calcHistogramaDiarioExecutadoDtpreg(
                calcHistogramaDiarioExecutadoDtpreg: LocalDate?): ControleExecucaoBuilder {
            this.calcHistogramaDiarioExecutadoDtpreg = calcHistogramaDiarioExecutadoDtpreg
            return this
        }

        fun calcHistogramaSemanalExecutado(
                calcHistogramaSemanalExecutado: Boolean?): ControleExecucaoBuilder {
            this.calcHistogramaSemanalExecutado = calcHistogramaSemanalExecutado
            return this
        }

        fun calcHistogramaSemanalExecutadoDtpreg(
                calcHistogramaSemanalExecutadoDtpreg: LocalDate?): ControleExecucaoBuilder {
            this.calcHistogramaSemanalExecutadoDtpreg = calcHistogramaSemanalExecutadoDtpreg
            return this
        }

        fun build(): ControleExecucao {
            return ControleExecucao(idControleExecucao, controleExecucaoAtivo,
                    calcMediaSimplesDiarioExecutado, calcMediaSimplesDiarioExecutadoDtpreg,
                    calcMediaSimplesSemanalExecutado, calcMediaSimplesSemanalExecutadoDtpreg,
                    calcMediaExponencialSemanalExecutado, calcMediaExponencialSemanalExecutadoDtpreg,
                    calcMediaExponencialDiarioExecutado, calcMediaExponencialDiarioExecutadoDtpreg,
                    calcMacdDiarioExecutado, calcMacdDiarioExecutadoDtpreg, calcMacdSemanalExecutado,
                    calcMacdSemanalExecutadoDtpreg, calcSinalMacdDiarioExecutado,
                    calcSinalMacdDiarioExecutadoDtpreg, calcSinalMacdSemanalExecutado,
                    calcSinalMacdSemanalExecutadoDtpreg, calcHistogramaDiarioExecutado,
                    calcHistogramaDiarioExecutadoDtpreg, calcHistogramaSemanalExecutado,
                    calcHistogramaSemanalExecutadoDtpreg)
        }

        override fun toString(): String {
            return ("ControleExecucao.ControleExecucaoBuilder(idControleExecucao="
                    + idControleExecucao
                    + ", controleExecucaoAtivo=" + controleExecucaoAtivo
                    + ", calcMediaSimplesDiarioExecutado=" + calcMediaSimplesDiarioExecutado
                    + ", calcMediaSimplesDiarioExecutadoDtpreg=" + calcMediaSimplesDiarioExecutadoDtpreg
                    + ", calcMediaSimplesSemanalExecutado=" + calcMediaSimplesSemanalExecutado
                    + ", calcMediaSimplesSemanalExecutadoDtpreg="
                    + calcMediaSimplesSemanalExecutadoDtpreg
                    + ", calcMediaExponencialSemanalExecutado=" + calcMediaExponencialSemanalExecutado
                    + ", calcMediaExponencialSemanalExecutadoDtpreg="
                    + calcMediaExponencialSemanalExecutadoDtpreg
                    + ", calcMediaExponencialDiarioExecutado="
                    + calcMediaExponencialDiarioExecutado
                    + ", calcMediaExponencialDiarioExecutadoDtpreg="
                    + calcMediaExponencialDiarioExecutadoDtpreg + ", calcMacdDiarioExecutado="
                    + calcMacdDiarioExecutado + ", calcMacdDiarioExecutadoDtpreg="
                    + calcMacdDiarioExecutadoDtpreg + ", calcMacdSemanalExecutado="
                    + calcMacdSemanalExecutado + ", calcMacdSemanalExecutadoDtpreg="
                    + calcMacdSemanalExecutadoDtpreg + ", calcSinalMacdDiarioExecutado="
                    + calcSinalMacdDiarioExecutado + ", calcSinalMacdDiarioExecutadoDtpreg="
                    + calcSinalMacdDiarioExecutadoDtpreg + ", calcSinalMacdSemanalExecutado="
                    + calcSinalMacdSemanalExecutado + ", calcSinalMacdSemanalExecutadoDtpreg="
                    + calcSinalMacdSemanalExecutadoDtpreg + ", calcHistogramaDiarioExecutado="
                    + calcHistogramaDiarioExecutado + ", calcHistogramaDiarioExecutadoDtpreg="
                    + calcHistogramaDiarioExecutadoDtpreg + ", calcHistogramaSemanalExecutado="
                    + calcHistogramaSemanalExecutado + ", calcHistogramaSemanalExecutadoDtpreg="
                    + calcHistogramaSemanalExecutadoDtpreg + ")")
        }
    }

    companion object {
        @kotlin.jvm.JvmStatic
        fun builder(): ControleExecucaoBuilder {
            return ControleExecucaoBuilder()
        }
    }
}