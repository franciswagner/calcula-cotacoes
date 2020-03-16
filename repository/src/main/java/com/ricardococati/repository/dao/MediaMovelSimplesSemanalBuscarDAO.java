package com.ricardococati.repository.dao;

import com.ricardococati.model.entities.MediaMovelSimplesSemanal;
import java.time.LocalDate;

public interface MediaMovelSimplesSemanalBuscarDAO {

  MediaMovelSimplesSemanal buscaMediaSimplesPorCodNegPeriodoDtPreg(
      final String codneg,
      final Integer periodo,
      final LocalDate dtpregini,
      final LocalDate dtpregfim
  ) throws Exception;

}
