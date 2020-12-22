package com.ricardococati.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum OperacaoSplitInplit {

  SPLIT("/"), INPLIT("*");

  @Getter
  private String tipoOperacao;

}
