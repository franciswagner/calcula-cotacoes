package com.ricardococati.service.impl

import com.ricardococati.model.entities.CandlestickDiarioMessage
import com.ricardococati.repository.dao.CandlestickDiarioInserirDAO
import com.ricardococati.service.CandlestickDiarioInserirService
import com.ricardococati.service.converter.CandlestickMessageConverter
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class CandlestickDiarioInserirServiceImpl(val incluirDiario: CandlestickDiarioInserirDAO,
                                          val converter: CandlestickMessageConverter
) : CandlestickDiarioInserirService {

    override fun incluirCandlestickDiario(message: CandlestickDiarioMessage): Boolean {
        return incluirDiario.insereCandlestickDiario(converter.convert(message))
    }

    override fun toString(): String {
        return ("CandlestickDiarioInserirServiceImpl(incluirDiario=" + incluirDiario
                + ", converter=" + converter + ")")
    }

    companion object {
        private val log = LoggerFactory
                .getLogger(CandlestickDiarioInserirServiceImpl::class.java)
    }

}