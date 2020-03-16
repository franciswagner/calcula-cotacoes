package com.ricardococati.service;

import com.ricardococati.model.entities.ControleExecucao;
import com.ricardococati.model.entities.MacdDiario;
import com.ricardococati.model.entities.MacdSemanal;
import java.util.List;

public interface CalculaService {

  List<MacdDiario> listMacdDiarioByCodNeg(final String codneg);

  List<MacdSemanal> listMacdSemanalByCodNeg(final String codneg);

  ControleExecucao carregaControleExecucao();

  Boolean updateControleExecucaoDiario(final ControleExecucao controleExecucao);

  Boolean updateControleExecucaoSemanal(final ControleExecucao controleExecucao);
}
