package com.ricardococati.repository.dao;

import com.ricardococati.model.dto.MediaMovelSimplesDiario;
import com.ricardococati.model.dto.SplitInplit;
import java.time.LocalDate;
import java.util.List;

public interface IMediaMovelSimplesDiarioDAO {

  Boolean incluirMediaMovelSimples(final List<MediaMovelSimplesDiario> mediaMovelSimplesList);

  Boolean split(SplitInplit splitInplit);

  Boolean inplit(SplitInplit splitInplit);

  MediaMovelSimplesDiario buscaMediaSimplesPorCodNegPeriodoDtPreg(
      final String codneg,
      final Integer periodo,
      final LocalDate dtpreg
  );

  Boolean deleteAllMM();
}
