package com.ricardococati.repository.dao;

import com.ricardococati.model.dto.RecomendacaoSemanal;
import java.time.LocalDate;
import java.util.List;

public interface RecomendacaoSemanalBuscarDAO {

  List<RecomendacaoSemanal> getListRecomendacaoByDtPregECodNeg(
      final LocalDate dtLimitePregao,
      final String codneg
  );

}
