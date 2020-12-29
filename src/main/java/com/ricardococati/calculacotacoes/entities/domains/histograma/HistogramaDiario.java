package com.ricardococati.calculacotacoes.entities.domains.histograma;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HistogramaDiario {

  private Long idHistogramaDiario;
  private LocalDate dtpreg;
  private Histograma histograma;

}
