package com.ricardococati.calculacotacoes.usecases.mediaexponencial;

import com.ricardococati.calculacotacoes.entities.domains.mediaexponencial.MediaMovelExponencialSemanal;
import java.util.List;

public interface MediaMovelExponencialSemanalCalculaService {

  List<MediaMovelExponencialSemanal> executeByCodNeg(String codneg);

}
