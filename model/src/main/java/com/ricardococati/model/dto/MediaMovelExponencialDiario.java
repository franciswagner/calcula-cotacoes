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
public class MediaMovelExponencialDiario {

  private static final long serialVersionUID = 505011356059052924L;
  private Long idMediaMovelExponencialDiario;
  private LocalDate dtpreg;
  private MediaMovelExponencial mediaMovelExponencial;

}
