package com.ricardococati.calculacotacoes.entities.domains.split;

import com.ricardococati.calculacotacoes.entities.enums.OperacaoSplitInplit;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SplitInplit {

  private String codneg;
  private LocalDate dtpreg;
  private Integer qtdSplitInplit;
  private OperacaoSplitInplit operacao;

}
