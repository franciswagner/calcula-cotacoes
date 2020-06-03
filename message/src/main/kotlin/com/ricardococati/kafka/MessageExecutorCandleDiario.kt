package com.ricardococati.kafka

import com.fasterxml.jackson.databind.ObjectMapper
import com.ricardococati.model.entities.CandlestickDiarioMessage
import com.ricardococati.service.CandlestickDiarioInserirService
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.io.IOException

@Service
@RequiredArgsConstructor
class MessageExecutorCandleDiario {

    private val objectMapper: ObjectMapper? = null
    private val service: CandlestickDiarioInserirService? = null
    fun execute(payload: String) {
        val domain = payloadToDomain(payload)
        log.info("payload: $payload")
        service!!.incluirCandlestickDiario(domain)
    }

    private fun payloadToDomain(payload: String): CandlestickDiarioMessage {
        return try {
            objectMapper!!.readValue(payload, CandlestickDiarioMessage::class.java)
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
    }

    companion object {
        private val log = LoggerFactory.getLogger(MessageExecutorCandleDiario::class.java)
    }

}