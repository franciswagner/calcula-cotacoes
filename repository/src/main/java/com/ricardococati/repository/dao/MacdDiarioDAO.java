package com.ricardococati.repository.dao;

import com.ricardococati.model.dto.MacdDiario;
import java.time.LocalDate;
import java.util.List;

public interface MacdDiarioDAO {

  Boolean incluirMacd(final List<MacdDiario> macdList);

  Boolean deleteAllMacd();

  List<MacdDiario> listMacdByCodNeg(final String codneg);

  List<MacdDiario> buscaMacdMediaSimplesPorCodNegDtPregLimite9Periodos(
      final String codneg,
      final LocalDate dtpregIni
  );

}
