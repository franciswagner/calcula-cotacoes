package com.ricardococati.model.entities

import java.math.BigDecimal

class CandlestickSemanalMessage {
    var idCandleSemanal: Long? = null
    var dtpregini: String? = null
    var dtpregfim: String? = null
    var semana: Int? = null
    var codneg: String? = null
    var preabe: BigDecimal? = null
    var premax: BigDecimal? = null
    var premin: BigDecimal? = null
    var preult: BigDecimal? = null
    var voltot: BigDecimal? = null

    override fun equals(o: Any?): Boolean {
        if (o === this) {
            return true
        }
        if (o !is CandlestickSemanalMessage) {
            return false
        }
        val other = o
        if (!other.canEqual(this as Any)) {
            return false
        }
        val `this$idCandleSemanal`: Any? = idCandleSemanal
        val `other$idCandleSemanal`: Any? = other.idCandleSemanal
        if (if (`this$idCandleSemanal` == null) `other$idCandleSemanal` != null else `this$idCandleSemanal` != `other$idCandleSemanal`) {
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
        val `this$semana`: Any? = semana
        val `other$semana`: Any? = other.semana
        if (if (`this$semana` == null) `other$semana` != null else `this$semana` != `other$semana`) {
            return false
        }
        val `this$codneg`: Any? = codneg
        val `other$codneg`: Any? = other.codneg
        if (if (`this$codneg` == null) `other$codneg` != null else `this$codneg` != `other$codneg`) {
            return false
        }
        val `this$preabe`: Any? = preabe
        val `other$preabe`: Any? = other.preabe
        if (if (`this$preabe` == null) `other$preabe` != null else `this$preabe` != `other$preabe`) {
            return false
        }
        val `this$premax`: Any? = premax
        val `other$premax`: Any? = other.premax
        if (if (`this$premax` == null) `other$premax` != null else `this$premax` != `other$premax`) {
            return false
        }
        val `this$premin`: Any? = premin
        val `other$premin`: Any? = other.premin
        if (if (`this$premin` == null) `other$premin` != null else `this$premin` != `other$premin`) {
            return false
        }
        val `this$preult`: Any? = preult
        val `other$preult`: Any? = other.preult
        if (if (`this$preult` == null) `other$preult` != null else `this$preult` != `other$preult`) {
            return false
        }
        val `this$voltot`: Any? = voltot
        val `other$voltot`: Any? = other.voltot
        return if (if (`this$voltot` == null) `other$voltot` != null else `this$voltot` != `other$voltot`) {
            false
        } else true
    }

    protected fun canEqual(other: Any?): Boolean {
        return other is CandlestickSemanalMessage
    }

    override fun hashCode(): Int {
        val PRIME = 59
        var result = 1
        val `$idCandleSemanal`: Any? = idCandleSemanal
        result = result * PRIME + (`$idCandleSemanal`?.hashCode() ?: 43)
        val `$dtpregini`: Any? = dtpregini
        result = result * PRIME + (`$dtpregini`?.hashCode() ?: 43)
        val `$dtpregfim`: Any? = dtpregfim
        result = result * PRIME + (`$dtpregfim`?.hashCode() ?: 43)
        val `$semana`: Any? = semana
        result = result * PRIME + (`$semana`?.hashCode() ?: 43)
        val `$codneg`: Any? = codneg
        result = result * PRIME + (`$codneg`?.hashCode() ?: 43)
        val `$preabe`: Any? = preabe
        result = result * PRIME + (`$preabe`?.hashCode() ?: 43)
        val `$premax`: Any? = premax
        result = result * PRIME + (`$premax`?.hashCode() ?: 43)
        val `$premin`: Any? = premin
        result = result * PRIME + (`$premin`?.hashCode() ?: 43)
        val `$preult`: Any? = preult
        result = result * PRIME + (`$preult`?.hashCode() ?: 43)
        val `$voltot`: Any? = voltot
        result = result * PRIME + (`$voltot`?.hashCode() ?: 43)
        return result
    }

    override fun toString(): String {
        return ("CandlestickSemanalMessage(idCandleSemanal=" + idCandleSemanal + ", dtpregini="
                + dtpregini + ", dtpregfim=" + dtpregfim + ", semana=" + semana + ", codneg=" + codneg + ", preabe=" + preabe + ", premax="
                + premax + ", premin=" + premin + ", preult=" + preult
                + ", voltot=" + voltot + ")")
    }
}