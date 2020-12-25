package com.ricardococati.calculacotacoes.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum OperacaoSplitInplit {

  SPLIT("/"), INPLIT("*");

  @Getter
  private String tipoOperacao;

}
