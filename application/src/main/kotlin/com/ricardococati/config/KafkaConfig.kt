package com.ricardococati.config

import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.clients.producer.ProducerConfig
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.config.KafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer
import java.util.*

@Configuration
@EnableKafka
open class KafkaConfig {

    @Value("\${spring.kafka.bootstrap.servers}")
    private val bootstrapServers: String? = null

    @Value("\${spring.kafka.consumer.group-id}")
    private val groupId: String? = null

    @Value("\${spring.kafka.properties.max.request.size}")
    private val maxSizeRequest: Long? = null

    @Value("\${spring.kafka.auto-offset-reset}")
    private val autoOffsetReset: String? = null

    @Value("\${spring.kafka.max.poll.records}")
    private val maxPollRecords: Int? = null

    @Value("\${spring.kafka.key.deserializer}")
    private val keyDeserializer: String? = null

    @Value("\${spring.kafka.value.deserializer}")
    private val valueDeserializer: String? = null

    @Value("\${spring.kafka.enable.auto.commit}")
    private val enableAutoCommit: Boolean? = null

    @Value("\${spring.kafka.concurrency}")
    private val concurrency: Int? = null

    @Value("\${spring.kafka.polltimeout}")
    private val polltimeout: Int? = null

    @Bean
    open fun kafkaListenerContainerFactory(): KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<Int, String>> {
        val factory = ConcurrentKafkaListenerContainerFactory<Int, String>()
        factory.consumerFactory = consumerFactory()
        factory.setConcurrency(concurrency)
        factory.containerProperties.pollTimeout = polltimeout!!.toLong()
        return factory
    }

    @Bean
    open fun consumerFactory(): ConsumerFactory<Int, String> {
        return DefaultKafkaConsumerFactory(consumerConfigs())
    }

    @Bean
    open fun consumerConfigs(): Map<String, Any?> {
        val props: MutableMap<String, Any?> = HashMap()
        props[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = bootstrapServers
        props[ConsumerConfig.GROUP_ID_CONFIG] = groupId
        props[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = keyDeserializer
        props[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = valueDeserializer
        props[ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG] = enableAutoCommit
        props[ConsumerConfig.MAX_POLL_RECORDS_CONFIG] = maxPollRecords
        props[ProducerConfig.MAX_REQUEST_SIZE_CONFIG] = maxSizeRequest
        props[ConsumerConfig.AUTO_OFFSET_RESET_CONFIG] = autoOffsetReset
        return props
    }
}