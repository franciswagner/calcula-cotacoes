package com.ricardococati.repository.dao;

import com.ricardococati.model.dto.MediaMovelExponencialDiario;
import java.util.List;

public interface MediaMovelExponencialDiarioBuscarDAO {

  List<MediaMovelExponencialDiario> getListMME12ByCodNegEPeriodo(
      final String codneg, final Integer periodo);

  List<MediaMovelExponencialDiario> getListMME26ByCodNegEPeriodo(
      final String codneg, final Integer periodo);

}
