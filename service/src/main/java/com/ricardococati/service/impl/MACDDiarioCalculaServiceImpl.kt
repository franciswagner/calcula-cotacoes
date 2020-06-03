package com.ricardococati.service.impl

import com.ricardococati.model.entities.Macd
import com.ricardococati.model.entities.MacdDiario
import com.ricardococati.model.entities.MediaMovelExponencialDiario
import com.ricardococati.model.enums.QuantidadePeriodo
import com.ricardococati.repository.dao.MacdDiarioBuscarDAO
import com.ricardococati.repository.dao.MacdDiarioInserirDAO
import com.ricardococati.repository.dao.MediaMovelExponencialDiarioBuscarDAO
import com.ricardococati.service.MACDDiarioCalculaService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.time.LocalDate
import java.util.ArrayList
import java.util.Objects
import java.util.function.Consumer

@Service
class MACDDiarioCalculaServiceImpl(val mmeDAO: MediaMovelExponencialDiarioBuscarDAO,
                                   val macdDAO: MacdDiarioBuscarDAO,
                                   val macdInserirDAO: MacdDiarioInserirDAO
) : MACDDiarioCalculaService {

    override fun executeByCodNeg(codneg: String): List<MacdDiario> {
        log.info("Código de negociação: $codneg")
        return calculaMACD(codneg)
    }

    private fun calculaMACD(codneg: String): List<MacdDiario> {
        val macdList: MutableList<MacdDiario> = ArrayList()
        val listMedia12 = buscaMME12Periodo(codneg)
        val listMedia26 = buscaMME26Periodo(codneg)
        if (Objects.nonNull(listMedia12) && Objects.nonNull(listMedia26)) {
            listMedia12.forEach(Consumer { mme12: MediaMovelExponencialDiario ->
                listMedia26
                        .stream()
                        .filter { mme26: MediaMovelExponencialDiario -> mme12.dtpreg!!.isEqual(mme26.dtpreg) }
                        .forEach { mme26: MediaMovelExponencialDiario ->
                            val premacd = mme12.mediaMovelExponencial!!.premedult
                                    ?.subtract(mme26.mediaMovelExponencial!!.premedult)
                            macdList.add(
                                    buildMacd(
                                            mme26.mediaMovelExponencial!!.codneg,
                                            mme26.dtpreg,
                                            premacd!!
                                    )
                            )
                        }
            })
        }
        inserirMacd(macdList)
        return macdList
    }

    private fun inserirMacd(macdList: List<MacdDiario>) {
        macdList
                .parallelStream()
                .filter { obj: MacdDiario? -> Objects.nonNull(obj) }
                .filter { macdDiario: MacdDiario -> Objects.nonNull(macdDiario.dtpreg) }
                .filter { macdDiario: MacdDiario -> Objects.nonNull(macdDiario.macd) }
                .filter { macdDiario: MacdDiario -> Objects.nonNull(macdDiario.macd!!.codneg) }
                .forEach { macdDiario: MacdDiario? -> macdInserirDAO.incluirMacd(macdDiario) }
    }

    private fun buscaMME12Periodo(codneg: String): List<MediaMovelExponencialDiario> {
        return mmeDAO.getListMMEByCodNegEPeriodo(
                codneg,
                QuantidadePeriodo.FAST_12.quantidade)
    }

    private fun buscaMME26Periodo(codneg: String): List<MediaMovelExponencialDiario> {
        return mmeDAO.getListMMEByCodNegEPeriodo(
                codneg,
                QuantidadePeriodo.SLOW_26.quantidade)
    }

    private fun buildMacd(
            codneg: String?,
            dtpreg: LocalDate?,
            prepremacd: BigDecimal): MacdDiario {
        return MacdDiario.builder()
                .dtpreg(dtpreg)
                .macd(Macd.builder().codneg(codneg)
                        .premacd(prepremacd).build())
                .build()
    }

    override fun toString(): String {
        return "MACDDiarioCalculaServiceImpl(mmeDAO=" + mmeDAO + ", macdDAO=" + macdDAO + ", macdInserirDAO=" + macdInserirDAO + ")"
    }

    companion object {
        private val log = LoggerFactory
                .getLogger(MACDDiarioCalculaServiceImpl::class.java)
    }

}