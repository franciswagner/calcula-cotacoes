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
public class CandlestickSemanal {

  private Long idCandleSemanal;
  private LocalDate dtpregini;
  private LocalDate dtpregfim;
  private Candlestick candlestick;

}
