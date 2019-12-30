package com.ricardococati.repository.dao;

import com.ricardococati.model.dto.SinalMacdDiario;
import java.util.List;

public interface SinalMacdDiarioDAO {

  Boolean incluirSinalMacd(final List<SinalMacdDiario> macdList);

  Boolean deleteAllSinalMacd();

  List<SinalMacdDiario> listSinalMacdByCodNeg(final String codneg);

}
