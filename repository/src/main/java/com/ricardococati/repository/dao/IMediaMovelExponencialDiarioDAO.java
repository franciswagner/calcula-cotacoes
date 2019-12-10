package com.ricardococati.repository.dao;

import com.ricardococati.model.dto.MediaMovelExponencialDiario;
import java.util.List;

public interface IMediaMovelExponencialDiarioDAO {

  Boolean incluirMediaMovelExponencial(final List<MediaMovelExponencialDiario> mediaMovelExponencialList);

  Boolean deleteAllMME();

  List<MediaMovelExponencialDiario> getListMMEByCodNegEPeriodo(final String codneg, final Integer periodo);

  List<MediaMovelExponencialDiario> listMediaExponencialByCodneg(final String codneg);
}
