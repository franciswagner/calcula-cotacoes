package com.ricardococati.calculacotacoes.adapters.queue;

public interface QueuePublisher {

  void enqueue(Object object, final String queueName);
}
