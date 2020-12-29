package com.ricardococati.calculacotacoes.adapters.queue.mapping;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Binding {

  private String topic;
  private String routingKey;
  private String queue;
  private boolean declare;
  private Integer ttl;
  private String deadLetterRoutingKey;
  private String deadLetterExchange;

  public Binding(final String topic, final String routingKey, final String queue,
      final boolean declare, final Integer ttl) {
    this.topic = topic;
    this.routingKey = routingKey;
    this.queue = queue;
    this.declare = declare;
    this.ttl = ttl;
  }

  public Binding(final String topic, final String routingKey, final String queue,
      final boolean declare, final Integer ttl, final String deadLetterRoutingKey,
      final String deadLetterExchange) {
    this.topic = topic;
    this.routingKey = routingKey;
    this.queue = queue;
    this.declare = declare;
    this.ttl = ttl;
    this.deadLetterRoutingKey = deadLetterRoutingKey;
    this.deadLetterExchange = deadLetterExchange;
  }
}
