package com.ricardococati.service.impl

import com.ricardococati.model.entities.Macd
import com.ricardococati.model.entities.MacdDiario
import com.ricardococati.model.entities.SinalMacd
import com.ricardococati.model.entities.SinalMacdDiario
import com.ricardococati.model.enums.QuantidadePeriodo
import com.ricardococati.repository.dao.MacdDiarioBuscarDAO
import com.ricardococati.repository.dao.SinalMacdDiarioInserirDAO
import com.ricardococati.service.CalculaService
import com.ricardococati.service.SinalMacdDiarioCalculaService
import com.ricardococati.service.util.BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas
import com.ricardococati.service.util.BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.time.LocalDate
import java.util.ArrayList
import java.util.Objects

@Service
class SinalMacdDiarioCalculaServiceImpl(
        val macdDAO: MacdDiarioBuscarDAO,
        val sinalMacdDAO: SinalMacdDiarioInserirDAO,
        val calculaService: CalculaService
) : SinalMacdDiarioCalculaService {

    override fun executeByCodNeg(codneg: String): List<SinalMacdDiario> {
        log.info("Código de negociação: $codneg")
        val macdList = calculaService.listMacdDiarioByCodNeg(codneg)
        val sinalMacdList = calculaMediaMovelExponencialMacd9Periodos(macdList)
        incluirSinalMacd(sinalMacdList)
        return sinalMacdList
    }

    private fun incluirSinalMacd(sinalMacdList: List<SinalMacdDiario>) {
        sinalMacdList
                .parallelStream()
                .filter { obj: SinalMacdDiario? -> Objects.nonNull(obj) }
                .filter { sinalMacdDiario: SinalMacdDiario -> Objects.nonNull(sinalMacdDiario.dtpreg) }
                .filter { sinalMacdDiario: SinalMacdDiario -> Objects.nonNull(sinalMacdDiario.sinalMacd) }
                .filter { sinalMacdDiario: SinalMacdDiario -> Objects.nonNull(sinalMacdDiario.sinalMacd!!.codneg) }
                .forEach { sinalMacdDiario: SinalMacdDiario? -> sinalMacdDAO.incluirSinalMacd(sinalMacdDiario) }
    }

    private fun calculaMediaMovelExponencialMacd9Periodos(
            macdList: List<MacdDiario>): List<SinalMacdDiario> {
        return calculaMediaMovelExponencialParaMacd(QuantidadePeriodo.FAST_9.quantidade, macdList)
    }

    private fun calculaMediaMovelExponencialParaMacd(
            periodo: Int, macdList: List<MacdDiario>): List<SinalMacdDiario> {
        val listReturn: MutableList<SinalMacdDiario> = ArrayList()
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
                    macdList[indice].dtpreg,
                    periodo,
                    calculaMME(periodo, macdList[indice].macd!!.premacd,
                            listReturn[posicao - 1].sinalMacd!!.presinal))
            )
            posicao++
        }
        return listReturn
    }

    private fun getPrimeiraMedia(
            macdList: List<MacdDiario>,
            indice: Int,
            periodo: Int
    ): MacdDiario {
        val valorSomado = getValueBigDecimalHalfUpArredondado4Casas(macdDAO
                .buscaMacdMediaSimplesPorCodNegDtPregLimite9Periodos(
                        macdList[indice].macd!!.codneg,
                        macdList[indice].dtpreg)
                .stream()
                .filter { obj: MacdDiario? -> Objects.nonNull(obj) }
                .map(MacdDiario::macd)
                .map<BigDecimal>(Macd::premacd)
                .reduce { obj: BigDecimal, augend: BigDecimal? -> obj.add(augend) }
                .orElse(BigDecimal.ZERO))
        return buildMacdPremed(
                macdList[indice],
                getDoubleValueBigDecimalHalfUpArredondado4Casas(
                        valorSomado.toDouble() /
                                periodo
                )
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
                precoHojeMultplFatorK +
                        mmeOntemMultplFatorKMenos1
        )
    }

    private fun buildSinalMacdByMMS(macd: MacdDiario): SinalMacdDiario {
        return SinalMacdDiario.builder()
                .dtpreg(macd.dtpreg)
                .sinalMacd(
                        SinalMacd
                                .builder()
                                .codneg(macd.macd!!.codneg)
                                .presinal(
                                        getValueBigDecimalHalfUpArredondado4Casas(macd.macd!!.premacd!!))
                                .build()
                ).build()
    }

    private fun buildMacdPremed(macd: MacdDiario, premed: BigDecimal): MacdDiario {
        return MacdDiario.builder()
                .dtpreg(macd.dtpreg)
                .macd(
                        Macd
                                .builder()
                                .codneg(macd.macd!!.codneg)
                                .premacd(getValueBigDecimalHalfUpArredondado4Casas(premed))
                                .build())
                .build()
    }

    private fun buildSinalMacd(
            codneg: String?,
            dtpreg: LocalDate?,
            periodo: Int,
            premed: BigDecimal): SinalMacdDiario {
        return SinalMacdDiario.builder()
                .dtpreg(dtpreg)
                .sinalMacd(SinalMacd.builder().codneg(codneg)
                        .periodo(periodo)
                        .presinal(premed).build())
                .build()
    }

    override fun toString(): String {
        return ("SinalMacdDiarioCalculaServiceImpl(macdDAO=" + macdDAO + ", sinalMacdDAO="
                + sinalMacdDAO + ", calculaService=" + calculaService + ")")
    }

    companion object {
        private val log = LoggerFactory
                .getLogger(SinalMacdDiarioCalculaServiceImpl::class.java)
    }

}