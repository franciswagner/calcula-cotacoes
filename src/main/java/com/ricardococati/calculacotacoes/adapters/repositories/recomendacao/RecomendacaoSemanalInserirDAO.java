package com.ricardococati.calculacotacoes.adapters.repositories.recomendacao;

import com.ricardococati.calculacotacoes.entities.domains.recomendacao.RecomendacaoSemanal;

public interface RecomendacaoSemanalInserirDAO {

  Boolean incluirRecomendacao(final RecomendacaoSemanal recomendacaoSemanal);

}
