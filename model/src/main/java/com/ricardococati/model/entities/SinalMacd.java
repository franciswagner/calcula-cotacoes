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
public class SinalMacd {

  private String codneg;
  private BigDecimal presinal;
  private Integer periodo;

}
