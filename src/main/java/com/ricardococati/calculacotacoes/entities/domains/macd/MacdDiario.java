package com.ricardococati.calculacotacoes.entities.domains.macd;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MacdDiario {

  private Long idMacdDiario;
  private LocalDate dtpreg;
  private Macd macd;

}
