package com.ricardococati.calculacotacoes.entities.domains.controle;

import java.time.LocalDate;
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
  private LocalDate calcMediaSimplesDiarioExecutadoDtpreg;
  private Boolean calcMediaSimplesSemanalExecutado;
  private LocalDate calcMediaSimplesSemanalExecutadoDtpreg;
  private Boolean calcMediaExponencialSemanalExecutado;
  private LocalDate calcMediaExponencialSemanalExecutadoDtpreg;
  private Boolean calcMediaExponencialDiarioExecutado;
  private LocalDate calcMediaExponencialDiarioExecutadoDtpreg;
  private Boolean calcMacdDiarioExecutado;
  private LocalDate calcMacdDiarioExecutadoDtpreg;
  private Boolean calcMacdSemanalExecutado;
  private LocalDate calcMacdSemanalExecutadoDtpreg;
  private Boolean calcSinalMacdDiarioExecutado;
  private LocalDate calcSinalMacdDiarioExecutadoDtpreg;
  private Boolean calcSinalMacdSemanalExecutado;
  private LocalDate calcSinalMacdSemanalExecutadoDtpreg;
  private Boolean calcHistogramaDiarioExecutado;
  private LocalDate calcHistogramaDiarioExecutadoDtpreg;
  private Boolean calcHistogramaSemanalExecutado;
  private LocalDate calcHistogramaSemanalExecutadoDtpreg;

}
