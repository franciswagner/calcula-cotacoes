package com.ricardococati.calculacotacoes.adapters.repositories.recomendacao;

import com.ricardococati.calculacotacoes.entities.domains.recomendacao.RecomendacaoDiario;
import java.time.LocalDate;
import java.util.List;

public interface RecomendacaoDiarioBuscarDAO {

  List<RecomendacaoDiario> getListRecomendacaoByDtPregECodNeg(
      final LocalDate dtLimitePregao,
      final String codneg
  );

}
