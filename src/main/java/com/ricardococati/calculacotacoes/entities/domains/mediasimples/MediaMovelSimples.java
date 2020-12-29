package com.ricardococati.calculacotacoes.entities.domains.mediasimples;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MediaMovelSimples {

  private String codneg;
  private BigDecimal premedult;
  private Integer periodo;

}
