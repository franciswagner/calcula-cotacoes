package com.ricardococati.repository.dao;

import com.ricardococati.model.entities.SinalMacdDiario;
import java.util.List;

public interface SinalMacdDiarioBuscarDAO {

  List<SinalMacdDiario> listSinalMacdByCodNeg(final String codneg);

}
