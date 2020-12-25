package com.ricardococati.calculacotacoes.adapters.repositories.recomendacao;

import com.ricardococati.calculacotacoes.entities.domains.recomendacao.RecomendacaoDiario;

public interface RecomendacaoDiarioInserirDAO {

  Boolean incluirRecomendacao(final RecomendacaoDiario recomendacaoDiario);

}
