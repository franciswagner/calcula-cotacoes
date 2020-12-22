package com.ricardococati.listener;

import com.ricardococati.kafka.Topics;
import com.ricardococati.service.message.MessageExecutorCandleSemanal;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageListenerCandleSemanal {

  private final MessageExecutorCandleSemanal messageExecutorCandleSemanal;

  @KafkaListener(topics = Topics.CANDLESTICK_SEMANAL)
  public void consume(final ConsumerRecord consumerRecord) {
    messageExecutorCandleSemanal.execute(consumerRecord.value().toString());
  }
}
