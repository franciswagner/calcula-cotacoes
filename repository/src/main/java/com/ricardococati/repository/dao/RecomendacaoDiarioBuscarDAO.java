package com.ricardococati.repository.dao;

import com.ricardococati.model.entities.RecomendacaoDiario;
import java.time.LocalDate;
import java.util.List;

public interface RecomendacaoDiarioBuscarDAO {

  List<RecomendacaoDiario> getListRecomendacaoByDtPregECodNeg(
      final LocalDate dtLimitePregao,
      final String codneg
  );

}
