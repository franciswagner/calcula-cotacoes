package com.ricardococati.model.entities;

import java.math.BigDecimal;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CandlestickDiarioMessage {

  private String idCandleDiario;
  private String dtpreg;
  private String codneg;
  private BigDecimal preabe;
  private BigDecimal premax;
  private BigDecimal premin;
  private BigDecimal preult;
  private BigDecimal voltot;
  private Integer semana;

}
