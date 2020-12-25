package com.ricardococati.calculacotacoes.entities.domains.ativo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ativo {

  private Long idAtivo;
  private String ativo;

}
