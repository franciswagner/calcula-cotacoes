package com.ricardococati.calculacotacoes.entities.domains.macd;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Macd {

  private String codneg;
  private BigDecimal premacd;

}
