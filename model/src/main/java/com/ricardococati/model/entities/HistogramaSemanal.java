package com.ricardococati.model.entities;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HistogramaSemanal {

  private Long idHistogramaSemanal;
  private LocalDate dtpregini;
  private LocalDate dtpregfim;
  private Histograma histograma;

}
