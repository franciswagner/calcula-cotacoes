package com.ricardococati.calculacotacoes.usecases.calculageral;

import com.ricardococati.calculacotacoes.entities.domains.recomendacao.RecomendacaoSemanal;
import java.time.LocalDate;
import java.util.List;

public interface CalculaGeralSemanalService {

  List<RecomendacaoSemanal> executeByCodNeg(
      final List<String> listCodneg,
      final LocalDate dtLimitePregao
  ) throws Exception;

}
