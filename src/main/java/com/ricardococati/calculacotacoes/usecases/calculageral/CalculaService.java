package com.ricardococati.calculacotacoes.usecases.calculageral;

import com.ricardococati.calculacotacoes.entities.domains.controle.ControleExecucao;
import com.ricardococati.calculacotacoes.entities.domains.macd.MacdDiario;
import com.ricardococati.calculacotacoes.entities.domains.macd.MacdSemanal;
import java.util.List;

public interface CalculaService {

  List<MacdDiario> listMacdDiarioByCodNeg(final String codneg);

  List<MacdSemanal> listMacdSemanalByCodNeg(final String codneg);

  ControleExecucao carregaControleExecucao();

  Boolean updateControleExecucaoDiario(final ControleExecucao controleExecucao);

  Boolean updateControleExecucaoSemanal(final ControleExecucao controleExecucao);
}
