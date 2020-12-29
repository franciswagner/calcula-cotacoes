package com.ricardococati.calculacotacoes.entities.domains.candlestick;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CandlestickDiario {

  private Long idCandleDiario;
  private LocalDate dtpreg;
  private Candlestick candlestick;

}
