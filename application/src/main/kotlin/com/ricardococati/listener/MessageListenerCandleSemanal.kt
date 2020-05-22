package com.ricardococati.listener

import com.ricardococati.kafka.MessageExecutorCandleSemanal
import com.ricardococati.kafka.Topics
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class MessageListenerCandleSemanal(private val messageExecutorCandleSemanal: MessageExecutorCandleSemanal) {

    @KafkaListener(topics = [Topics.CANDLESTICK_SEMANAL])
    fun consume(consumerRecord: ConsumerRecord<*, *>) {
        messageExecutorCandleSemanal.execute(consumerRecord.value().toString())
    }

}
