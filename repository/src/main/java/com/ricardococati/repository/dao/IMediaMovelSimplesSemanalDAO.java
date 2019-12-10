package com.ricardococati.repository.dao;

import com.ricardococati.model.dto.MediaMovelSimplesSemanal;
import java.time.LocalDate;
import java.util.List;

public interface IMediaMovelSimplesSemanalDAO {

  Boolean incluirMediaMovelSimples(final List<MediaMovelSimplesSemanal> mediaMovelSimplesList);

  MediaMovelSimplesSemanal buscaMediaSimplesPorCodNegPeriodoDtPreg(
      final String codneg,
      final Integer periodo,
      final LocalDate dtpregini,
      final LocalDate dtpregfim
  );

  Boolean deleteAllMM();

}
