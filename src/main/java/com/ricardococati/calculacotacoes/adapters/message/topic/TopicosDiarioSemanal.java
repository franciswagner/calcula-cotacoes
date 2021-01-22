package com.ricardococati.calculacotacoes.adapters.message.topic;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TopicosDiarioSemanal {

  TOPIC_RECOMENDACAO_DIARIA("recomendacao-diaria"),
  TOPIC_RECOMENDACAO_SEMANAL("recomendacao-semanal");

  @Getter
  private String topicName;

}
