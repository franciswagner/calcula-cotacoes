package com.ricardococati.repository.dao;

import com.ricardococati.model.entities.MediaMovelSimplesDiario;
import java.time.LocalDate;

public interface MediaMovelSimplesDiarioBuscarDAO {

  MediaMovelSimplesDiario buscaMediaSimplesPorCodNegPeriodoDtPreg(
      final String codneg,
      final Integer periodo,
      final LocalDate dtpreg
  ) throws Exception;

}
