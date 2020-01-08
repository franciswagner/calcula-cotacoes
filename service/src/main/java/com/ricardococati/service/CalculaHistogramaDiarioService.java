package com.ricardococati.service;

import com.ricardococati.model.dto.HistogramaDiario;
import java.util.List;

public interface CalculaHistogramaDiarioService {

  List<HistogramaDiario> executeByCodNeg(String codneg);

}
