package com.ricardococati.repository.dao;

import com.ricardococati.model.dto.MacdSemanal;
import java.time.LocalDate;
import java.util.List;

public interface MacdSemanalBuscarDAO {

  Boolean incluirMacd(final List<MacdSemanal> macdList);

  List<MacdSemanal> listMacdByCodNeg(final String codneg);

  List<MacdSemanal> buscaMacdMediaSimplesPorCodNegDtPregLimite9Periodos(
      final String codneg,
      final LocalDate dtpregIni
  );

}
