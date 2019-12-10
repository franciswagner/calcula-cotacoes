package com.ricardococati.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ControleExecucao {

  private Long idControleExecucao;
  private Boolean controleExecucaoAtivo;
  private Boolean calcMediaSimplesDiarioExecutado;
  private Boolean calcMediaSimplesSemanalExecutado;
  private Boolean calcMediaExponencialSemanalExecutado;
  private Boolean calcMediaExponencialDiarioExecutado;
  private Boolean calcMacdDiarioExecutado;
  private Boolean calcMacdSemanalExecutado;
  private Boolean calcSinalMacdDiarioExecutado;
  private Boolean calcSinalMacdSemanalExecutado;
  private Boolean calcHistogramaDiarioExecutado;
  private Boolean calcHistogramaSemanalExecutado;

}
