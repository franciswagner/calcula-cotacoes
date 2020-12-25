package com.ricardococati.calculacotacoes.entities.domains.sinalmacd;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SinalMacdDiario {

  private Long idSinalMacdDiario;
  private LocalDate dtpreg;
  private SinalMacd sinalMacd;

}
