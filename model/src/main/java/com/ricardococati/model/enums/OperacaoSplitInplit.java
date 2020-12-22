package com.ricardococati.model.enums;

import lombok.Getter;

public enum OperacaoSplitInplit {

  SPLIT("/"), INPLIT("*");

  @Getter
  private String tipoOperacao;

  OperacaoSplitInplit(final String tipoOperacao) {
    this.tipoOperacao = tipoOperacao;
  }
}
