package com.ricardococati.calculacotacoes.adapters.repositories.recomendacao;

import com.ricardococati.calculacotacoes.entities.domains.recomendacao.RecomendacaoSemanal;
import java.time.LocalDate;
import java.util.List;

public interface RecomendacaoSemanalBuscarDAO {

  List<RecomendacaoSemanal> getListRecomendacaoByDtPregECodNeg(
      final LocalDate dtLimitePregao,
      final String codneg
  );

}
