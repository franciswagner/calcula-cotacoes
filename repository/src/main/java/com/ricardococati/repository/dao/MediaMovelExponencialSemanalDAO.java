package com.ricardococati.repository.dao;

import com.ricardococati.model.dto.MediaMovelExponencialSemanal;
import java.util.List;

public interface MediaMovelExponencialSemanalDAO {

  Boolean incluirMediaMovelExponencial(
      final List<MediaMovelExponencialSemanal> mediaMovelExponencialList);

  Boolean deleteAllMME();

  List<MediaMovelExponencialSemanal> getListMMEByCodNegEPeriodo(final String codneg,
      final Integer periodo);

  List<MediaMovelExponencialSemanal> listMediaExponencialByCodneg(final String codneg);
}
