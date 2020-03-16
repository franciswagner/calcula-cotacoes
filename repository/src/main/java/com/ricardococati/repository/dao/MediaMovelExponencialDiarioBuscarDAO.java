package com.ricardococati.repository.dao;

import com.ricardococati.model.entities.MediaMovelExponencialDiario;
import java.util.List;

public interface MediaMovelExponencialDiarioBuscarDAO {

  List<MediaMovelExponencialDiario> getListMMEByCodNegEPeriodo(
      final String codneg, final Integer periodo);

}
