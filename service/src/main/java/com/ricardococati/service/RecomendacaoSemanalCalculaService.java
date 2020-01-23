package com.ricardococati.service;

import com.ricardococati.model.dto.RecomendacaoSemanal;
import java.time.LocalDate;
import java.util.List;

public interface RecomendacaoSemanalCalculaService {

  List<RecomendacaoSemanal> executeByCodNeg(
      final List<String> listCodneg,
      final LocalDate dtLimitePregao
  );

}
