package com.ricardococati.service.impl

import com.ricardococati.model.entities.CandlestickSemanal
import com.ricardococati.repository.dao.CandlestickSemanalBuscarDAO
import com.ricardococati.service.CandlestickSemanalBuscarService
import com.ricardococati.service.converter.CandlestickMessageConverter
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class CandlestickSemanalBuscarServiceImpl(val semanalDAO: CandlestickSemanalBuscarDAO,
                                          val converter: CandlestickMessageConverter
) : CandlestickSemanalBuscarService {

    override fun buscaCandlestickSemanalPorCodNeg(
            semanalDTO: CandlestickSemanal): List<CandlestickSemanal> {
        return semanalDAO.buscaCandleSemanalPorCodNeg(semanalDTO.candlestick!!.codneg)
    }

    override fun buscaCandlestickSemanalPorDtPreg(
            dtpregLimite: LocalDate): List<String> {
        return semanalDAO.buscaCandleSemanalPorDtPreg(dtpregLimite)
    }

    override fun toString(): String {
        return ("CandlestickSemanalBuscarServiceImpl(semanalDAO=" + semanalDAO + ", converter="
                + converter + ")")
    }

    companion object {
        private val log = LoggerFactory
                .getLogger(CandlestickSemanalBuscarServiceImpl::class.java)
    }

}