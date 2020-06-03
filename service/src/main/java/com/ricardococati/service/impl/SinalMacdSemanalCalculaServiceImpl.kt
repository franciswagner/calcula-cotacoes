package com.ricardococati.service.impl

import com.ricardococati.model.entities.Macd
import com.ricardococati.model.entities.MacdSemanal
import com.ricardococati.model.entities.SinalMacd
import com.ricardococati.model.entities.SinalMacdSemanal
import com.ricardococati.model.enums.QuantidadePeriodo
import com.ricardococati.repository.dao.MacdSemanalBuscarDAO
import com.ricardococati.repository.dao.MediaMovelExponencialSemanalBuscarDAO
import com.ricardococati.repository.dao.SinalMacdSemanalInserirDAO
import com.ricardococati.service.CalculaService
import com.ricardococati.service.CandlestickSemanalBuscarService
import com.ricardococati.service.SinalMacdSemanalCalculaService
import com.ricardococati.service.util.BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas
import com.ricardococati.service.util.BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.time.LocalDate
import java.util.ArrayList
import java.util.Objects

@Service
class SinalMacdSemanalCalculaServiceImpl(
        val calculaCandlestickService: CandlestickSemanalBuscarService,
        val macdDAO: MacdSemanalBuscarDAO,
        val sinalMacdDAO: SinalMacdSemanalInserirDAO,
        val mediaMovelExponencialDAO: MediaMovelExponencialSemanalBuscarDAO,
        val calculaService: CalculaService
) : SinalMacdSemanalCalculaService {

    override fun executeByCodNeg(codneg: String): List<SinalMacdSemanal> {
        log.info("Código de negociação: $codneg")
        val macdList = calculaService.listMacdSemanalByCodNeg(codneg)
        val sinalMacdList = calculaMediaMovelExponencialMacd9Periodos(macdList)
        incluirSinalMacdSemanal(sinalMacdList)
        return sinalMacdList
    }

    private fun incluirSinalMacdSemanal(sinalMacdList: List<SinalMacdSemanal>) {
        sinalMacdList
                .parallelStream()
                .filter { obj: SinalMacdSemanal? -> Objects.nonNull(obj) }
                .filter { sinalMacdSemanal: SinalMacdSemanal -> Objects.nonNull(sinalMacdSemanal.dtpregini) }
                .filter { sinalMacdSemanal: SinalMacdSemanal -> Objects.nonNull(sinalMacdSemanal.dtpregfim) }
                .filter { sinalMacdSemanal: SinalMacdSemanal -> Objects.nonNull(sinalMacdSemanal.sinalMacd) }
                .filter { sinalMacdSemanal: SinalMacdSemanal -> Objects.nonNull(sinalMacdSemanal.sinalMacd!!.codneg) }
                .forEach { sinalMacdSemanal: SinalMacdSemanal? -> sinalMacdDAO.incluirSinalMacd(sinalMacdSemanal) }
    }

    private fun calculaMediaMovelExponencialMacd9Periodos(
            macdList: List<MacdSemanal>): List<SinalMacdSemanal> {
        return calculaMediaMovelExponencial(QuantidadePeriodo.FAST_9.quantidade, macdList)
    }

    private fun calculaMediaMovelExponencial(
            periodo: Int, macdList: List<MacdSemanal>): List<SinalMacdSemanal> {
        val listReturn: MutableList<SinalMacdSemanal> = ArrayList()
        val qtdPeriodos = macdList.size
        var posicao = 0
        for (indice in periodo - 1 until qtdPeriodos) {
            if (posicao == 0) {
                listReturn.add(
                        buildSinalMacdByMMS(getPrimeiraMedia(macdList, indice, periodo)))
                posicao++
                continue
            }
            listReturn.add(buildSinalMacd(
                    macdList[indice].macd!!.codneg,
                    macdList[indice].dtpregini,
                    macdList[indice].dtpregfim,
                    periodo,
                    calculaMME(periodo, macdList[indice].macd!!.premacd,
                            listReturn[posicao - 1].sinalMacd!!.presinal))
            )
            posicao++
        }
        return listReturn
    }

    private fun getPrimeiraMedia(
            macdList: List<MacdSemanal>,
            indice: Int,
            periodo: Int
    ): MacdSemanal {
        val valorSomado = getValueBigDecimalHalfUpArredondado4Casas(macdDAO
                .buscaMacdMediaSimplesPorCodNegDtPregLimite9Periodos(
                        macdList[indice].macd!!.codneg,
                        macdList[indice].dtpregini)
                .stream()
                .filter { obj: MacdSemanal? -> Objects.nonNull(obj) }
                .map(MacdSemanal::macd)
                .map<BigDecimal>(Macd::premacd)
                .reduce { obj: BigDecimal, augend: BigDecimal? -> obj.add(augend) }
                .orElse(BigDecimal.ZERO))
        return buildMacdPremed(
                macdList[indice],
                BigDecimal(valorSomado.toDouble() / periodo)
        )
    }

    private fun calculaMME(
            periodo: Int,
            precoHoje: BigDecimal?,
            precoMMEOntem: BigDecimal?): BigDecimal {
        val coeficienteK = 2.0 / (periodo + 1)
        val menos1 = 1
        val precoHojeMultplFatorK: Double = precoHoje!!.toDouble() * coeficienteK
        val mmeOntemMultplFatorKMenos1: Double = precoMMEOntem!!.toDouble() * (menos1 - coeficienteK)
        return getDoubleValueBigDecimalHalfUpArredondado4Casas(
                precoHojeMultplFatorK + mmeOntemMultplFatorKMenos1
        )
    }

    private fun buildSinalMacdByMMS(macd: MacdSemanal): SinalMacdSemanal {
        return SinalMacdSemanal.builder()
                .dtpregini(macd.dtpregini)
                .dtpregfim(macd.dtpregfim)
                .sinalMacd(
                        SinalMacd
                                .builder()
                                .codneg(macd.macd!!.codneg)
                                .presinal(
                                        getValueBigDecimalHalfUpArredondado4Casas(macd.macd!!.premacd!!)
                                ).build())
                .build()
    }

    private fun buildMacdPremed(macd: MacdSemanal, premed: BigDecimal): MacdSemanal {
        return MacdSemanal.builder()
                .dtpregini(macd.dtpregini)
                .dtpregfim(macd.dtpregfim)
                .macd(
                        Macd
                                .builder()
                                .codneg(macd.macd!!.codneg)
                                .premacd(getValueBigDecimalHalfUpArredondado4Casas(premed))
                                .build()
                ).build()
    }

    private fun buildSinalMacd(
            codneg: String?,
            dtpregini: LocalDate?,
            dtpregfim: LocalDate?,
            periodo: Int,
            premed: BigDecimal): SinalMacdSemanal {
        return SinalMacdSemanal.builder()
                .dtpregini(dtpregini)
                .dtpregfim(dtpregfim)
                .sinalMacd(SinalMacd.builder().codneg(codneg)
                        .periodo(periodo)
                        .presinal(premed).build())
                .build()
    }

    override fun equals(o: Any?): Boolean {
        if (o === this) {
            return true
        }
        if (o !is SinalMacdSemanalCalculaServiceImpl) {
            return false
        }
        val other = o
        if (!other.canEqual(this as Any)) {
            return false
        }
        val `this$calculaCandlestickService`: Any = calculaCandlestickService
        val `other$calculaCandlestickService`: Any = other.calculaCandlestickService
        if (if (`this$calculaCandlestickService` == null) `other$calculaCandlestickService` != null else `this$calculaCandlestickService` != `other$calculaCandlestickService`) {
            return false
        }
        val `this$macdDAO`: Any = macdDAO
        val `other$macdDAO`: Any = other.macdDAO
        if (if (`this$macdDAO` == null) `other$macdDAO` != null else `this$macdDAO` != `other$macdDAO`) {
            return false
        }
        val `this$sinalMacdDAO`: Any = sinalMacdDAO
        val `other$sinalMacdDAO`: Any = other.sinalMacdDAO
        if (if (`this$sinalMacdDAO` == null) `other$sinalMacdDAO` != null else `this$sinalMacdDAO` != `other$sinalMacdDAO`) {
            return false
        }
        val `this$mediaMovelExponencialDAO`: Any = mediaMovelExponencialDAO
        val `other$mediaMovelExponencialDAO`: Any = other.mediaMovelExponencialDAO
        if (if (`this$mediaMovelExponencialDAO` == null) `other$mediaMovelExponencialDAO` != null else `this$mediaMovelExponencialDAO` != `other$mediaMovelExponencialDAO`) {
            return false
        }
        val `this$calculaService`: Any = calculaService
        val `other$calculaService`: Any = other.calculaService
        return if (if (`this$calculaService` == null) `other$calculaService` != null else `this$calculaService` != `other$calculaService`) {
            false
        } else true
    }

    protected fun canEqual(other: Any?): Boolean {
        return other is SinalMacdSemanalCalculaServiceImpl
    }

    override fun hashCode(): Int {
        val PRIME = 59
        var result = 1
        val `$calculaCandlestickService`: Any = calculaCandlestickService
        result = result * PRIME + (`$calculaCandlestickService`?.hashCode() ?: 43)
        val `$macdDAO`: Any = macdDAO
        result = result * PRIME + (`$macdDAO`?.hashCode() ?: 43)
        val `$sinalMacdDAO`: Any = sinalMacdDAO
        result = result * PRIME + (`$sinalMacdDAO`?.hashCode() ?: 43)
        val `$mediaMovelExponencialDAO`: Any = mediaMovelExponencialDAO
        result = result * PRIME + (`$mediaMovelExponencialDAO`?.hashCode() ?: 43)
        val `$calculaService`: Any = calculaService
        result = result * PRIME + (`$calculaService`?.hashCode() ?: 43)
        return result
    }

    override fun toString(): String {
        return ("SinalMacdSemanalCalculaServiceImpl(calculaCandlestickService=" + calculaCandlestickService + ", macdDAO=" + macdDAO + ", sinalMacdDAO="
                + sinalMacdDAO + ", mediaMovelExponencialDAO=" + mediaMovelExponencialDAO + ", calculaService=" + calculaService + ")")
    }

    companion object {
        private val log = LoggerFactory
                .getLogger(SinalMacdSemanalCalculaServiceImpl::class.java)
    }

}