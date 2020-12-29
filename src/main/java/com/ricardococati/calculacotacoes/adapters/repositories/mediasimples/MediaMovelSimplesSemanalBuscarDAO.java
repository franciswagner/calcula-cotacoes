package com.ricardococati.calculacotacoes.adapters.repositories.mediasimples;

import com.ricardococati.calculacotacoes.entities.domains.mediasimples.MediaMovelSimplesSemanal;
import java.time.LocalDate;

public interface MediaMovelSimplesSemanalBuscarDAO {

  MediaMovelSimplesSemanal buscaMediaSimplesPorCodNegPeriodoDtPreg(
      final String codneg,
      final Integer periodo,
      final LocalDate dtpregini,
      final LocalDate dtpregfim
  ) throws Exception;

}
