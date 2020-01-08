package com.ricardococati.service;

import com.ricardococati.model.dto.SinalMacdDiario;
import java.util.List;

public interface CalculaSinalMacdDiarioService {

  List<SinalMacdDiario> executeByCodNeg(String codneg);

}
