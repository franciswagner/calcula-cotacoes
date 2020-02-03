package com.ricardococati.repository.dao;

import com.ricardococati.model.dto.MediaMovelExponencialSemanal;
import java.util.List;

public interface MediaMovelExponencialSemanalBuscarDAO {

  List<MediaMovelExponencialSemanal> getListMMEByCodNegEPeriodo(
      final String codneg,
      final Integer periodo
  );

}