package com.ricardococati.calculacotacoes.usecases.recomendacao;

import com.ricardococati.calculacotacoes.entities.domains.recomendacao.RecomendacaoSemanal;
import java.time.LocalDate;
import java.util.List;

public interface RecomendacaoSemanalCalculaService {

  List<RecomendacaoSemanal> executeByCodNeg(
      final List<String> listCodneg,
      final LocalDate dtLimitePregao
  );

}
