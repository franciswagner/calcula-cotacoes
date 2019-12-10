package com.ricardococati.service;

import com.ricardococati.model.dto.ControleExecucao;
import com.ricardococati.model.dto.MacdDiario;
import com.ricardococati.model.dto.MacdSemanal;
import java.util.List;

public interface ICalculaService {

  List<String> listCodNegDiario();

  List<String> listCodNegSemanal();

  List<MacdDiario> listMacdDiarioByCodNeg(String codneg);

  List<MacdSemanal> listMacdSemanalByCodNeg(String codneg);

  ControleExecucao carregaControleExecucao();

  Boolean updateControleExecucaoDiario(final ControleExecucao controleExecucao);

  Boolean updateControleExecucaoSemanal(final ControleExecucao controleExecucao);
}
