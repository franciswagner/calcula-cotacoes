package com.ricardococati.calculacotacoes.usecases.recomendacao;

import com.ricardococati.calculacotacoes.entities.domains.recomendacao.RecomendacaoDiario;
import java.time.LocalDate;
import java.util.List;

public interface RecomendacaoDiarioCalculaService {

  List<RecomendacaoDiario> executeByCodNeg(
      final List<String> listCodneg,
      final LocalDate dtLimitePregao
  );

}
