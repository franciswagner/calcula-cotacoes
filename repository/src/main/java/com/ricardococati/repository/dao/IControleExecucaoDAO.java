package com.ricardococati.repository.dao;

import com.ricardococati.model.dto.ControleExecucao;

public interface IControleExecucaoDAO {

  ControleExecucao loadControleExecucao();

  Boolean updateControleExecucaoDiario(final ControleExecucao controleExecucao);

  Boolean updateControleExecucaoSemanal(final ControleExecucao controleExecucao);

}
