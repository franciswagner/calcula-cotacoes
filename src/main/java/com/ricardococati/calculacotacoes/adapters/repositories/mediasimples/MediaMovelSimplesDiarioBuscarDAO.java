package com.ricardococati.calculacotacoes.adapters.repositories.mediasimples;

import com.ricardococati.calculacotacoes.entities.domains.mediasimples.MediaMovelSimplesDiario;
import java.time.LocalDate;

public interface MediaMovelSimplesDiarioBuscarDAO {

  MediaMovelSimplesDiario buscaMediaSimplesPorCodNegPeriodoDtPreg(
      final String codneg,
      final Integer periodo,
      final LocalDate dtpreg
  ) throws Exception;

}
