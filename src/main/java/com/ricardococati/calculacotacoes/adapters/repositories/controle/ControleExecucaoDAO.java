package com.ricardococati.calculacotacoes.adapters.repositories.controle;

import com.ricardococati.calculacotacoes.entities.domains.controle.ControleExecucao;

public interface ControleExecucaoDAO {

  ControleExecucao loadControleExecucao();

  Boolean updateControleExecucaoDiario(final ControleExecucao controleExecucao);

  Boolean updateControleExecucaoSemanal(final ControleExecucao controleExecucao);

}
