package com.ricardococati.config.amqp;

import com.ricardococati.config.amqp.mapping.Binding;

public final class MessageContext<T> {

  private Binding binding;
  private T message;

  public MessageContext(final T message, final Binding mqMapping) {
    this.message = message;
    this.binding = mqMapping;
  }

  public Binding getRabbitMQBiding() {
    return binding;
  }

  public T getMessage() {
    return message;
  }

}