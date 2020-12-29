package com.ricardococati.calculacotacoes.entities.enums;

import java.util.Arrays;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum QuantidadePeriodo {

  FAST_9(9),
  FAST_12(12),
  FAST_13(13),
  SLOW_26(26),
  SLOW_100(100);

  @Getter
  private Integer quantidade;

  public static List<Integer> getListQuantidadePeriodo() {
    return Arrays.asList(
        FAST_9.getQuantidade(),
        FAST_12.getQuantidade(),
        FAST_13.getQuantidade(),
        SLOW_26.getQuantidade(),
        SLOW_100.getQuantidade()
        );
  }

}
