package com.ricardococati.calculacotacoes.adapters.repositories.sinalmacd;

import com.ricardococati.calculacotacoes.entities.domains.sinalmacd.SinalMacdSemanal;
import java.util.List;

public interface SinalMacdSemanalBuscarDAO {

  List<SinalMacdSemanal> listSinalMacdByCodNeg(final String codneg);

}
