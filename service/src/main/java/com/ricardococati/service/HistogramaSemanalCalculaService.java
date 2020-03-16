package com.ricardococati.service;

import com.ricardococati.model.entities.HistogramaSemanal;
import java.util.List;

public interface HistogramaSemanalCalculaService {

  List<HistogramaSemanal> executeByCodNeg(String codneg);

}
