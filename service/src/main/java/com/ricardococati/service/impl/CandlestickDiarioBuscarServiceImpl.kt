package com.ricardococati.service.impl

import com.ricardococati.model.entities.CandlestickDiario
import com.ricardococati.repository.dao.CandlestickDiarioBuscarDAO
import com.ricardococati.service.CandlestickDiarioBuscarService
import com.ricardococati.service.converter.CandlestickMessageConverter
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class CandlestickDiarioBuscarServiceImpl(val diarioDAO: CandlestickDiarioBuscarDAO,
                                         val converter: CandlestickMessageConverter
) : CandlestickDiarioBuscarService {

    override fun buscaCandlestickDiarioPorCodNeg(
            candlestickDiario: CandlestickDiario): List<CandlestickDiario> {
        return diarioDAO.buscaCandleDiarioPorCodNeg(candlestickDiario.candlestick!!.codneg)
    }

    override fun buscaCandlestickDiarioPorDtPreg(
            dtpregLimite: LocalDate): List<String> {
        return diarioDAO.buscaCandleDiarioPorDtPreg(dtpregLimite)
    }

    override fun toString(): String {
        return ("CandlestickDiarioBuscarServiceImpl(diarioDAO=" + diarioDAO + ", converter="
                + converter + ")")
    }

    companion object {
        private val log = LoggerFactory
                .getLogger(CandlestickDiarioBuscarServiceImpl::class.java)
    }

}