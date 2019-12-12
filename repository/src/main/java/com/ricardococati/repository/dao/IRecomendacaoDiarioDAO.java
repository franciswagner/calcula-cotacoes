package com.ricardococati.repository.dao;

import com.ricardococati.model.dto.RecomendacaoDiario;
import java.util.List;

public interface IRecomendacaoDiarioDAO {

  Boolean incluirRecomendacao(final List<RecomendacaoDiario> macdList);

  Boolean deleteAllRecomendacao();

  List<RecomendacaoDiario> listRecomendacaoByCodNeg(final String codneg);

}
