package com.ricardococati.calculacotacoes.entities.domains.mediaexponencial;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MediaMovelExponencial {

  private String codneg;
  private BigDecimal premedult;
  private Integer periodo;

}
