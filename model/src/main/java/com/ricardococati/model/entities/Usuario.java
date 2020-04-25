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
public class Usuario {

  private Long idUsuario;
  private String nomeUsuario;
  private String email;
  private LocalDate ultimaDataExecucao;

}
