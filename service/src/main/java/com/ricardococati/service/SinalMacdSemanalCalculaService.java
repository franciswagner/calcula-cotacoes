package com.ricardococati.service;

import com.ricardococati.model.entities.SinalMacdSemanal;
import java.util.List;

public interface SinalMacdSemanalCalculaService {

  List<SinalMacdSemanal> executeByCodNeg(String codneg);

}
