package com.ricardococati.listener;

import com.ricardococati.kafka.Topics;
import com.ricardococati.service.message.MessageExecutorCandleDiario;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageListenerCandleDiario {

  private final MessageExecutorCandleDiario messageExecutorCandleDiario;

  @KafkaListener(topics = Topics.CANDLESTICK_DIARIO)
  public void consume(final ConsumerRecord consumerRecord) {
    messageExecutorCandleDiario.execute(consumerRecord.value().toString());
  }
}
