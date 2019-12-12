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
public class Recomendacao {

  private String codneg;
  private BigDecimal precoFechamento;
  private BigDecimal precoMME12p;
  private BigDecimal precoMME26p;
  private BigDecimal precoMacd;
  private BigDecimal precoSinalMacd;
  private BigDecimal precoHistograma;
  private String decisao;

}
