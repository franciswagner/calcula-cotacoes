package com.ricardococati.calculacotacoes.entities.domains.mediaexponencial;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MediaMovelExponencialSemanal {

  private static final long serialVersionUID = 505011356059052924L;
  private Long idMediaMovelExponencialSemanal;
  private LocalDate dtpregini;
  private LocalDate dtpregfim;
  private MediaMovelExponencial mediaMovelExponencial;

}
