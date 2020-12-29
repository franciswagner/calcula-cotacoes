package com.ricardococati.calculacotacoes.usecases.calculageral;

import com.ricardococati.calculacotacoes.entities.domains.recomendacao.RecomendacaoDiario;
import java.time.LocalDate;
import java.util.List;

public interface CalculaGeralDiarioService {

  List<RecomendacaoDiario> executeByCodNeg(
      final List<String> listCodneg,
      final LocalDate dtLimitePregao
  ) throws Exception;

}
