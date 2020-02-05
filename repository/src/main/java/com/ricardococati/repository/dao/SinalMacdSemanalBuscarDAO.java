package com.ricardococati.repository.dao;

import com.ricardococati.model.dto.SinalMacdSemanal;
import java.util.List;

public interface SinalMacdSemanalBuscarDAO {

  List<SinalMacdSemanal> listSinalMacdByCodNeg(final String codneg);

}
