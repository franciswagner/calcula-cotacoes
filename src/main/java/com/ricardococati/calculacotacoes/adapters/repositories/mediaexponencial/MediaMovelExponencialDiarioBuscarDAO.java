package com.ricardococati.calculacotacoes.adapters.repositories.mediaexponencial;

import com.ricardococati.calculacotacoes.entities.domains.mediaexponencial.MediaMovelExponencialDiario;
import java.util.List;

public interface MediaMovelExponencialDiarioBuscarDAO {

  List<MediaMovelExponencialDiario> getListMMEByCodNegEPeriodo(
      final String codneg, final Integer periodo);

}
