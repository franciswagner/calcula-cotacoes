package com.ricardococati.model.entities

class Ativo {
    var idAtivo: Long? = null
    var ativo: String? = null

    constructor(idAtivo: Long?, ativo: String?) {
        this.idAtivo = idAtivo
        this.ativo = ativo
    }

    constructor() {}

    override fun equals(o: Any?): Boolean {
        if (o === this) {
            return true
        }
        if (o !is Ativo) {
            return false
        }
        val other = o
        if (!other.canEqual(this as Any)) {
            return false
        }
        val `this$idAtivo`: Any? = idAtivo
        val `other$idAtivo`: Any? = other.idAtivo
        if (if (`this$idAtivo` == null) `other$idAtivo` != null else `this$idAtivo` != `other$idAtivo`) {
            return false
        }
        val `this$ativo`: Any? = ativo
        val `other$ativo`: Any? = other.ativo
        return if (if (`this$ativo` == null) `other$ativo` != null else `this$ativo` != `other$ativo`) {
            false
        } else true
    }

    protected fun canEqual(other: Any?): Boolean {
        return other is Ativo
    }

    override fun hashCode(): Int {
        val PRIME = 59
        var result = 1
        val `$idAtivo`: Any? = idAtivo
        result = result * PRIME + (`$idAtivo`?.hashCode() ?: 43)
        val `$ativo`: Any? = ativo
        result = result * PRIME + (`$ativo`?.hashCode() ?: 43)
        return result
    }

    override fun toString(): String {
        return "Ativo(idAtivo=" + idAtivo + ", ativo=" + ativo + ")"
    }

    class AtivoBuilder internal constructor() {
        private var idAtivo: Long? = null
        private var ativo: String? = null
        fun idAtivo(idAtivo: Long?): AtivoBuilder {
            this.idAtivo = idAtivo
            return this
        }

        fun ativo(ativo: String?): AtivoBuilder {
            this.ativo = ativo
            return this
        }

        fun build(): Ativo {
            return Ativo(idAtivo, ativo)
        }

        override fun toString(): String {
            return "Ativo.AtivoBuilder(idAtivo=" + idAtivo + ", ativo=" + ativo + ")"
        }
    }

    companion object {
        @kotlin.jvm.JvmStatic
        fun builder(): AtivoBuilder {
            return AtivoBuilder()
        }
    }
}