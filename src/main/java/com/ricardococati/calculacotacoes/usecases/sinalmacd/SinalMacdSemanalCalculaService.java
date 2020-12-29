package com.ricardococati.calculacotacoes.usecases.sinalmacd;

import com.ricardococati.calculacotacoes.entities.domains.sinalmacd.SinalMacdSemanal;
import java.util.List;

public interface SinalMacdSemanalCalculaService {

  List<SinalMacdSemanal> executeByCodNeg(String codneg);

}
