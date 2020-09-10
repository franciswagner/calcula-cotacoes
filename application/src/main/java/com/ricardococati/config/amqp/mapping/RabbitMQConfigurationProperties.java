package com.ricardococati.config.amqp.mapping;

import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "personal.rabbit")
public class RabbitMQConfigurationProperties {

  private List<Binding> bindings;
  private Config config;

  public Optional<Binding> getQueueByName(final String queue) {
    return bindings
        .stream()
        .filter(binding -> binding.getQueue().equals(queue))
        .findFirst();
  }

}