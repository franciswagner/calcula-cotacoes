package com.ricardococati.service;

import com.ricardococati.model.dto.RecomendacaoSemanal;
import java.time.LocalDate;
import java.util.List;

public interface CalculaGeralSemanalService {

  List<RecomendacaoSemanal> executeByCodNeg(
      final List<String> listCodneg,
      final LocalDate dtLimitePregao
  ) throws Exception;

}
