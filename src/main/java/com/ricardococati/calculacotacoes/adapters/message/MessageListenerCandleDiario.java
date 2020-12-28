package com.ricardococati.calculacotacoes.adapters.message;

import static com.ricardococati.calculacotacoes.entities.contantes.Topics.CANDLESTICK_DIARIO;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageListenerCandleDiario {

  private final MessageExecutorCandleDiario messageExecutorCandleDiario;

  @KafkaListener(topics = CANDLESTICK_DIARIO)
  public void consume(final ConsumerRecord consumerRecord) {
    messageExecutorCandleDiario.execute(consumerRecord.value().toString());
  }
}
