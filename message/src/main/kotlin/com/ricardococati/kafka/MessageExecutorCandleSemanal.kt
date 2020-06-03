package com.ricardococati.kafka

import com.fasterxml.jackson.databind.ObjectMapper
import com.ricardococati.model.entities.CandlestickSemanalMessage
import com.ricardococati.service.CandlestickSemanalInserirService
import lombok.RequiredArgsConstructor
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.io.IOException

@Service
@RequiredArgsConstructor
class MessageExecutorCandleSemanal {

    private val objectMapper: ObjectMapper? = null
    private val service: CandlestickSemanalInserirService? = null
    fun execute(payload: String) {
        val domain = payloadToDomain(payload)
        log.info("payload: $payload")
        service!!.incluirCandlestickSemanal(domain)
    }

    private fun payloadToDomain(payload: String): CandlestickSemanalMessage {
        return try {
            objectMapper!!.readValue(payload, CandlestickSemanalMessage::class.java)
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
    }

    companion object {
        private val log = LoggerFactory.getLogger(MessageExecutorCandleSemanal::class.java)
    }

}