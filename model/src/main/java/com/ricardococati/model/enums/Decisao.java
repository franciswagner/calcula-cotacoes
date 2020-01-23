package com.ricardococati.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Decisao {

  COMPRA("COMPRA"),
  VENDE("VENDE"),
  NEUTRO("NEUTRO");

  @Getter
  private String texto;

}
