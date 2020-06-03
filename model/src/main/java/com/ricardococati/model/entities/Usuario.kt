package com.ricardococati.model.entities

import java.time.LocalDate

class Usuario {
    var idUsuario: Long? = null
    var nomeUsuario: String? = null
    var email: String? = null
    var ultimaDataExecucao: LocalDate? = null

    constructor(idUsuario: Long?, nomeUsuario: String?, email: String?, ultimaDataExecucao: LocalDate?) {
        this.idUsuario = idUsuario
        this.nomeUsuario = nomeUsuario
        this.email = email
        this.ultimaDataExecucao = ultimaDataExecucao
    }

    constructor() {}

    override fun equals(o: Any?): Boolean {
        if (o === this) {
            return true
        }
        if (o !is Usuario) {
            return false
        }
        val other = o
        if (!other.canEqual(this as Any)) {
            return false
        }
        val `this$idUsuario`: Any? = idUsuario
        val `other$idUsuario`: Any? = other.idUsuario
        if (if (`this$idUsuario` == null) `other$idUsuario` != null else `this$idUsuario` != `other$idUsuario`) {
            return false
        }
        val `this$nomeUsuario`: Any? = nomeUsuario
        val `other$nomeUsuario`: Any? = other.nomeUsuario
        if (if (`this$nomeUsuario` == null) `other$nomeUsuario` != null else `this$nomeUsuario` != `other$nomeUsuario`) {
            return false
        }
        val `this$email`: Any? = email
        val `other$email`: Any? = other.email
        if (if (`this$email` == null) `other$email` != null else `this$email` != `other$email`) {
            return false
        }
        val `this$ultimaDataExecucao`: Any? = ultimaDataExecucao
        val `other$ultimaDataExecucao`: Any? = other.ultimaDataExecucao
        return if (if (`this$ultimaDataExecucao` == null) `other$ultimaDataExecucao` != null else `this$ultimaDataExecucao` != `other$ultimaDataExecucao`) {
            false
        } else true
    }

    protected fun canEqual(other: Any?): Boolean {
        return other is Usuario
    }

    override fun hashCode(): Int {
        val PRIME = 59
        var result = 1
        val `$idUsuario`: Any? = idUsuario
        result = result * PRIME + (`$idUsuario`?.hashCode() ?: 43)
        val `$nomeUsuario`: Any? = nomeUsuario
        result = result * PRIME + (`$nomeUsuario`?.hashCode() ?: 43)
        val `$email`: Any? = email
        result = result * PRIME + (`$email`?.hashCode() ?: 43)
        val `$ultimaDataExecucao`: Any? = ultimaDataExecucao
        result = result * PRIME + (`$ultimaDataExecucao`?.hashCode() ?: 43)
        return result
    }

    override fun toString(): String {
        return ("Usuario(idUsuario=" + idUsuario + ", nomeUsuario=" + nomeUsuario
                + ", email=" + email + ", ultimaDataExecucao=" + ultimaDataExecucao
                + ")")
    }

    class UsuarioBuilder internal constructor() {
        private var idUsuario: Long? = null
        private var nomeUsuario: String? = null
        private var email: String? = null
        private var ultimaDataExecucao: LocalDate? = null
        fun idUsuario(idUsuario: Long?): UsuarioBuilder {
            this.idUsuario = idUsuario
            return this
        }

        fun nomeUsuario(nomeUsuario: String?): UsuarioBuilder {
            this.nomeUsuario = nomeUsuario
            return this
        }

        fun email(email: String?): UsuarioBuilder {
            this.email = email
            return this
        }

        fun ultimaDataExecucao(ultimaDataExecucao: LocalDate?): UsuarioBuilder {
            this.ultimaDataExecucao = ultimaDataExecucao
            return this
        }

        fun build(): Usuario {
            return Usuario(idUsuario, nomeUsuario, email, ultimaDataExecucao)
        }

        override fun toString(): String {
            return ("Usuario.UsuarioBuilder(idUsuario=" + idUsuario + ", nomeUsuario="
                    + nomeUsuario + ", email=" + email + ", ultimaDataExecucao="
                    + ultimaDataExecucao + ")")
        }
    }

    companion object {
        fun builder(): UsuarioBuilder {
            return UsuarioBuilder()
        }
    }
}