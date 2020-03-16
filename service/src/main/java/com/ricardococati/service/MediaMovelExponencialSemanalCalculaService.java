package com.ricardococati.service;

import com.ricardococati.model.entities.MediaMovelExponencialSemanal;
import java.util.List;

public interface MediaMovelExponencialSemanalCalculaService {

  List<MediaMovelExponencialSemanal> executeByCodNeg(String codneg);

}
