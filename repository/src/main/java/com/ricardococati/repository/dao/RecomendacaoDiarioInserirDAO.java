package com.ricardococati.repository.dao;

import com.ricardococati.model.dto.RecomendacaoDiario;
import java.util.List;

public interface RecomendacaoDiarioInserirDAO {

  Boolean incluirRecomendacao(final List<RecomendacaoDiario> macdList);

}
