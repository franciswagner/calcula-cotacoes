package com.ricardococati.repository.dao;

import com.ricardococati.model.entities.ControleExecucao;

public interface ControleExecucaoDAO {

  ControleExecucao loadControleExecucao();

  Boolean updateControleExecucaoDiario(final ControleExecucao controleExecucao);

  Boolean updateControleExecucaoSemanal(final ControleExecucao controleExecucao);

}
