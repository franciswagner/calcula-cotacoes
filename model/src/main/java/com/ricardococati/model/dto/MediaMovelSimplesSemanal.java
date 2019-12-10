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
public class MediaMovelSimplesSemanal {

  private Long idMediaMovelSimplesSemanal;
  private LocalDate dtpregini;
  private LocalDate dtpregfim;
  private MediaMovelSimples mediaMovelSimples;

}
