package com.ricardococati.service;

import com.ricardococati.model.dto.HistogramaDiario;
import java.util.List;

public interface HistogramaDiarioCalculaService {

  List<HistogramaDiario> executeByCodNeg(String codneg);

}
