package com.ricardococati.calculacotacoes.usecases.sinalmacd;

import com.ricardococati.calculacotacoes.entities.domains.sinalmacd.SinalMacdDiario;
import java.util.List;

public interface SinalMacdDiarioCalculaService {

  List<SinalMacdDiario> executeByCodNeg(String codneg);

}
