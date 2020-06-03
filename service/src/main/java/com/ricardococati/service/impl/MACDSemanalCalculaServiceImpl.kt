package com.ricardococati.service.impl

import com.ricardococati.model.entities.Macd
import com.ricardococati.model.entities.MacdSemanal
import com.ricardococati.model.entities.MediaMovelExponencialSemanal
import com.ricardococati.model.enums.QuantidadePeriodo
import com.ricardococati.repository.dao.MacdSemanalBuscarDAO
import com.ricardococati.repository.dao.MacdSemanalInserirDAO
import com.ricardococati.repository.dao.MediaMovelExponencialSemanalBuscarDAO
import com.ricardococati.service.CalculaService
import com.ricardococati.service.CandlestickSemanalBuscarService
import com.ricardococati.service.MACDSemanalCalculaService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.time.LocalDate
import java.util.ArrayList
import java.util.Objects
import java.util.function.Consumer

@Service
class MACDSemanalCalculaServiceImpl(val candleSemanalService: CandlestickSemanalBuscarService,
                                    val mmeDAO: MediaMovelExponencialSemanalBuscarDAO,
                                    val macdDAO: MacdSemanalBuscarDAO,
                                    val calculaService: CalculaService,
                                    val incluirMacd: MacdSemanalInserirDAO
) : MACDSemanalCalculaService {

    override fun executeByCodNeg(codneg: String): List<MacdSemanal> {
        log.info("Código de negociação: $codneg")
        return calculaMACD(codneg)
    }

    private fun buscaMME12Periodo(codneg: String): List<MediaMovelExponencialSemanal> {
        return mmeDAO.getListMMEByCodNegEPeriodo(
                codneg,
                QuantidadePeriodo.FAST_12.quantidade)
    }

    private fun buscaMME26Periodo(codneg: String): List<MediaMovelExponencialSemanal> {
        return mmeDAO.getListMMEByCodNegEPeriodo(
                codneg,
                QuantidadePeriodo.SLOW_26.quantidade)
    }

    private fun calculaMACD(codneg: String): List<MacdSemanal> {
        val macdList: MutableList<MacdSemanal> = ArrayList()
        val listMedia12 = buscaMME12Periodo(codneg)
        val listMedia26 = buscaMME26Periodo(codneg)
        if (Objects.nonNull(listMedia12) && Objects.nonNull(listMedia26)) {
            listMedia12.forEach(Consumer { mme12: MediaMovelExponencialSemanal ->
                listMedia26
                        .stream()
                        .filter { mme26: MediaMovelExponencialSemanal ->
                            (mme12.dtpregini!!.isEqual(mme26.dtpregini)
                                    && mme12.dtpregfim!!.isEqual(mme26.dtpregfim))
                        }
                        .forEach { mme26: MediaMovelExponencialSemanal ->
                            val premacd = mme12
                                    .mediaMovelExponencial
                                    ?.premedult
                                    ?.subtract(mme26.mediaMovelExponencial!!.premedult)
                            macdList.add(
                                    buildMacd(
                                            mme26.mediaMovelExponencial!!.codneg,
                                            mme26.dtpregini,
                                            mme26.dtpregfim,
                                            premacd!!
                                    )
                            )
                        }
            })
        }
        incluirMacd(macdList)
        return macdList
    }

    private fun incluirMacd(macdList: List<MacdSemanal>) {
        macdList
                .parallelStream()
                .filter { obj: MacdSemanal? -> Objects.nonNull(obj) }
                .filter { macdSemanal: MacdSemanal -> Objects.nonNull(macdSemanal.dtpregini) }
                .filter { macdSemanal: MacdSemanal -> Objects.nonNull(macdSemanal.dtpregfim) }
                .filter { macdSemanal: MacdSemanal -> Objects.nonNull(macdSemanal.macd) }
                .filter { macdSemanal: MacdSemanal -> Objects.nonNull(macdSemanal.macd!!.codneg) }
                .forEach { macdSemanal: MacdSemanal? -> incluirMacd.incluirMacd(macdSemanal) }
    }

    private fun buildMacd(
            codneg: String?,
            dtpregini: LocalDate?,
            dtpregfim: LocalDate?,
            prepremacd: BigDecimal): MacdSemanal {
        return MacdSemanal.builder()
                .dtpregini(dtpregini)
                .dtpregfim(dtpregfim)
                .macd(Macd.builder().codneg(codneg)
                        .premacd(prepremacd).build())
                .build()
    }

    override fun toString(): String {
        return ("MACDSemanalCalculaServiceImpl(candleSemanalService=" + candleSemanalService
                + ", mmeDAO=" + mmeDAO + ", macdDAO=" + macdDAO + ", calculaService="
                + calculaService + ", incluirMacd=" + incluirMacd + ")")
    }

    companion object {
        private val log = LoggerFactory
                .getLogger(MACDSemanalCalculaServiceImpl::class.java)
    }

}