package com.ricardococati.repository.dao;

import com.ricardococati.model.dto.MediaMovelExponencialDiario;
import java.util.List;

public interface MediaMovelExponencialDiarioDAO {

  Boolean incluirMediaMovelExponencial(final List<MediaMovelExponencialDiario> mediaMovelExponencialList);

  Boolean deleteAllMME();

  List<MediaMovelExponencialDiario> getListMMEByCodNegEPeriodo(final String codneg, final Integer periodo);

  List<MediaMovelExponencialDiario> getListMME12ByCodNegEPeriodo(final String codneg, final Integer periodo);

  List<MediaMovelExponencialDiario> getListMME26ByCodNegEPeriodo(final String codneg, final Integer periodo);

  List<MediaMovelExponencialDiario> listMediaExponencialByCodneg(final String codneg);
}
