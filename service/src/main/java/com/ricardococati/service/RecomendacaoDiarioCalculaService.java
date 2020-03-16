package com.ricardococati.service;

import com.ricardococati.model.entities.RecomendacaoDiario;
import java.time.LocalDate;
import java.util.List;

public interface RecomendacaoDiarioCalculaService {

  List<RecomendacaoDiario> executeByCodNeg(
      final List<String> listCodneg,
      final LocalDate dtLimitePregao
  );

}
