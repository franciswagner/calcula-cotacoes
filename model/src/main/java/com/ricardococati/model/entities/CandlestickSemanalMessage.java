package com.ricardococati.model.entities;

import java.math.BigDecimal;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CandlestickSemanalMessage {

  private Long idCandleSemanal;
  private String dtpregini;
  private String dtpregfim;
  private Integer semana;
  private String codneg;
  private BigDecimal preabe;
  private BigDecimal premax;
  private BigDecimal premin;
  private BigDecimal preult;
  private BigDecimal voltot;

}
