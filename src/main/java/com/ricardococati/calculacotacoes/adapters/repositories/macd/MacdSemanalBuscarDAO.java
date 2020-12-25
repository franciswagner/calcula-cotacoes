package com.ricardococati.calculacotacoes.adapters.repositories.macd;

import com.ricardococati.calculacotacoes.entities.domains.macd.MacdSemanal;
import java.time.LocalDate;
import java.util.List;

public interface MacdSemanalBuscarDAO {

  List<MacdSemanal> listMacdByCodNeg(final String codneg);

  List<MacdSemanal> buscaMacdMediaSimplesPorCodNegDtPregLimite9Periodos(
      final String codneg,
      final LocalDate dtpregIni
  );

}
