package com.ricardococati.config.amqp.mapping;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Config {

  private Integer initialInterval;
  private Integer maxInterval;
  private Integer multiplier;
  private Integer retries;
  private Integer successConsumers;
  private Integer errorConsumers;
}