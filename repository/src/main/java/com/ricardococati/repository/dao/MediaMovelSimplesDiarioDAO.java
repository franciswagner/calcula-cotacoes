package com.ricardococati.repository.dao;

import com.ricardococati.model.dto.MediaMovelSimplesDiario;
import com.ricardococati.model.dto.SplitInplit;
import java.time.LocalDate;
import java.util.List;

public interface MediaMovelSimplesDiarioDAO {

  Boolean incluirMediaMovelSimples(final List<MediaMovelSimplesDiario> mediaMovelSimplesList);

  MediaMovelSimplesDiario buscaMediaSimplesPorCodNegPeriodoDtPreg(
      final String codneg,
      final Integer periodo,
      final LocalDate dtpreg
  );

}
