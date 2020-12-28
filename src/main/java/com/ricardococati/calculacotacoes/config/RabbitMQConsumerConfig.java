package com.ricardococati.calculacotacoes.config;

import com.ricardococati.calculacotacoes.adapters.queue.mapping.RabbitMQConfigurationProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.retry.RejectAndDontRequeueRecoverer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RabbitMQConsumerConfig {

  private final ConnectionFactory connectionFactory;

  @Bean
  public RabbitAdmin rabbitAdmin(final ConnectionFactory connectionFactory) {
    return new RabbitAdmin(connectionFactory);
  }

  @Bean
  public SimpleRabbitListenerContainerFactory rabbitSuccessListenerContainerFactory(
      final RabbitMQConfigurationProperties configurationProperties) {
    return getFactory(
        configurationProperties.getConfig().getRetries(),
        configurationProperties.getConfig().getSuccessConsumers());
  }

  @Bean
  public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(
      final RabbitMQConfigurationProperties configurationProperties) {
    return getFactory(
        configurationProperties.getConfig().getRetries(),
        configurationProperties.getConfig().getErrorConsumers());
  }

  private SimpleRabbitListenerContainerFactory getFactory(Integer retries, Integer consumers) {
    SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
    factory.setConnectionFactory(connectionFactory);
    factory.setConcurrentConsumers(consumers);
    factory.setDefaultRequeueRejected(false);
    factory.setAdviceChain(
        org.springframework.amqp.rabbit.config.RetryInterceptorBuilder.stateless()
            .recoverer(new RejectAndDontRequeueRecoverer())
            .maxAttempts(retries)
            .build());
    return factory;
  }
}
