package com.ricardococati.calculacotacoes.adapters.message.sender;

public interface KafkaSender {

  void send(String payload, String topicName);

}
