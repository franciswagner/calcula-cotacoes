package com.ricardococati.calculacotacoes.adapters.repositories.macd;

import com.ricardococati.calculacotacoes.entities.domains.macd.MacdDiario;
import java.time.LocalDate;
import java.util.List;

public interface MacdDiarioBuscarDAO {

  List<MacdDiario> listMacdByCodNeg(final String codneg);

  List<MacdDiario> buscaMacdMediaSimplesPorCodNegDtPregLimite9Periodos(
      final String codneg,
      final LocalDate dtpregIni
  );

}
