package com.ricardococati.calculacotacoes.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Decisao {

  TENDENCIA_ALTA("Tendencia de Alta"),
  TENDENCIA_BAIXA("Tendencia de Baixa"),
  CONSOLIDANDO("Consolidando");

  @Getter
  private String texto;

}
