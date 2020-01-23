package com.ricardococati.service;

import com.ricardococati.model.dto.HistogramaSemanal;
import java.util.List;

public interface HistogramaSemanalCalculaService {

  List<HistogramaSemanal> executeByCodNeg(String codneg);

}
