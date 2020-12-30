package com.ricardococati.calculacotacoes.adapters.queue.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ricardococati.calculacotacoes.adapters.queue.QueuePublisher;
import com.ricardococati.calculacotacoes.adapters.queue.mapping.Binding;
import com.ricardococati.calculacotacoes.adapters.queue.mapping.RabbitMQConfigurationProperties;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RabbitMQPublisher implements QueuePublisher {

  private final RabbitTemplate template;
  private final ObjectMapper objectMapper;
  private final RabbitMQConfigurationProperties properties;

  @Override
  public void enqueue(final Object object, final String queueName) {
    final Binding binding =
        properties
            .getQueueByName(queueName)
            .orElseThrow(
                () -> {
                  log.error("Unable to find the given queue: {}", queueName);
                  return new RuntimeException(
                      String.format("Unable to find the given queue: '%s'", queueName));
                });
    final String exchange = binding.getTopic();
    final String json = stringifyRabbitMessage(object);

    log.info(
        "enqueueing message: {}. On queue: {}. At :{} ",
        object,
        binding.getQueue(),
        LocalDateTime.now());

    final Message message = template.getMessageConverter().toMessage(json, new MessageProperties());
    this.template.send(exchange, binding.getRoutingKey(), message);
  }

  private String stringifyRabbitMessage(final Object data) {
    try {
      return objectMapper.writeValueAsString(data);
    } catch (final JsonProcessingException e) {
      log.error("object could not be serialized as a json string", e.getMessage());
    }

    return data.toString();
  }
}
