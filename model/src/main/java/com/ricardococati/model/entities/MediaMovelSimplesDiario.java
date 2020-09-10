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
public class MediaMovelSimplesDiario {

  private Long idMediaMovelSimplesDiario;
  private LocalDate dtpreg;
  private MediaMovelSimples mediaMovelSimples;

}