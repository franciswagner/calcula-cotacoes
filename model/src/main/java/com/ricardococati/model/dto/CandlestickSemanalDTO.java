package com.ricardococati.model.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CandlestickSemanalDTO {

  private Long idCandleSemanal;
  private LocalDate dtpregini;
  private LocalDate dtpregfim;
  private CandlestickDTO candlestickDTO;

}
