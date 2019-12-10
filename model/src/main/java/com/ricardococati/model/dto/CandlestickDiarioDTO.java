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
public class CandlestickDiarioDTO {

  private Long idCandleDiario;
  private LocalDate dtpreg;
  private CandlestickDTO candlestickDTO;

}
