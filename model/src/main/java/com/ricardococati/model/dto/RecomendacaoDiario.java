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
public class RecomendacaoDiario {

  private Long idRecomendacaoDiario;
  private LocalDate dtpreg;
  private Recomendacao recomendacao;

}
