package com.ricardococati.service.impl

import com.ricardococati.model.entities.CandlestickSemanalMessage
import com.ricardococati.repository.dao.CandlestickSemanalInserirDAO
import com.ricardococati.service.CandlestickSemanalInserirService
import com.ricardococati.service.converter.CandlestickMessageConverter
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class CandlestickSemanalInserirServiceImpl(val semanalDAO: CandlestickSemanalInserirDAO,
                                           val converter: CandlestickMessageConverter
) : CandlestickSemanalInserirService {

    override fun incluirCandlestickSemanal(message: CandlestickSemanalMessage): Boolean {
        return semanalDAO.incluirCandlestickSemanal(converter.convertSemanal(message))
    }

    override fun toString(): String {
        return ("CandlestickSemanalInserirServiceImpl(semanalDAO=" + semanalDAO
                + ", converter=" + converter + ")")
    }

    companion object {
        private val log = LoggerFactory
                .getLogger(CandlestickSemanalInserirServiceImpl::class.java)
    }

}