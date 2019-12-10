package com.ricardococati.model.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CandlestickDTO {

  private String codneg;
  private BigDecimal preabe;
  private BigDecimal premax;
  private BigDecimal premin;
  private BigDecimal preult;
  private BigDecimal voltot;
  private Integer semana;
  private Boolean mediaMovelGerada;
  private Boolean mediaExponencialGerada;
  private Boolean macdGerada;
  private Boolean sinalMacdGerada;
  private Boolean histogramaGerada;

}
