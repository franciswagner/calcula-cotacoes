package com.ricardococati.repository.dao;

import com.ricardococati.model.dto.CandlestickDiarioDTO;
import com.ricardococati.model.dto.RecomendacaoDiario;
import java.time.LocalDate;
import java.util.List;

public interface IRecomendacaoDiarioDAO {

  Boolean incluirRecomendacao(final List<RecomendacaoDiario> macdList);

  Boolean deleteAllRecomendacao();

  List<RecomendacaoDiario> listRecomendacaoByCodNeg(final String codneg);

  List<RecomendacaoDiario> getListRecomendacaoByDtPregECodNeg(
      final LocalDate dtLimitePregao,
      final String codneg
  );

}
