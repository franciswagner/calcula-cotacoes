package com.ricardococati.service;

import com.ricardococati.model.dto.MediaMovelExponencialSemanal;
import java.util.List;

public interface MediaMovelExponencialSemanalCalculaService {

  List<MediaMovelExponencialSemanal> executeByCodNeg(String codneg);

}
