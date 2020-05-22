package com.ricardococati.listener

import com.ricardococati.kafka.MessageExecutorCandleDiario
import com.ricardococati.kafka.Topics
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class MessageListenerCandleDiario(private val messageExecutorCandleDiario: MessageExecutorCandleDiario) {

    @KafkaListener(topics = [Topics.CANDLESTICK_DIARIO])
    fun consume(consumerRecord: ConsumerRecord<*, *>) {
        messageExecutorCandleDiario.execute(consumerRecord.value().toString())
    }

}