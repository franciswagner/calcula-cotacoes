package com.ricardococati.model.entities;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Candlestick {

  private String codneg;
  private BigDecimal preabe;
  private BigDecimal premax;
  private BigDecimal premin;
  private BigDecimal preult;
  private BigDecimal voltot;
  private Integer semana;

}
