package com.ricardococati.calculacotacoes.adapters.repositories.mediaexponencial;

import com.ricardococati.calculacotacoes.entities.domains.mediaexponencial.MediaMovelExponencialSemanal;
import java.util.List;

public interface MediaMovelExponencialSemanalBuscarDAO {

  List<MediaMovelExponencialSemanal> getListMMEByCodNegEPeriodo(
      final String codneg,
      final Integer periodo
  );

}