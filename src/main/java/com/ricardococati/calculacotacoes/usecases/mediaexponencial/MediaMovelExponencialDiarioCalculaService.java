package com.ricardococati.calculacotacoes.usecases.mediaexponencial;

import com.ricardococati.calculacotacoes.entities.domains.mediaexponencial.MediaMovelExponencialDiario;
import java.util.List;

public interface MediaMovelExponencialDiarioCalculaService {

  List<MediaMovelExponencialDiario> executeByCodNeg(String codneg);

}
