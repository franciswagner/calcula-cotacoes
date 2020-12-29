package com.ricardococati.calculacotacoes.adapters.repositories.sinalmacd;

import com.ricardococati.calculacotacoes.entities.domains.sinalmacd.SinalMacdDiario;
import java.util.List;

public interface SinalMacdDiarioBuscarDAO {

  List<SinalMacdDiario> listSinalMacdByCodNeg(final String codneg);

}
