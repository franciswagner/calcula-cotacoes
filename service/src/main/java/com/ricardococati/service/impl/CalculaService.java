package com.ricardococati.service.impl;

import com.ricardococati.model.dto.ControleExecucao;
import com.ricardococati.model.dto.MacdDiario;
import com.ricardococati.model.dto.MacdSemanal;
import com.ricardococati.repository.dao.ICandlestickDiarioDAO;
import com.ricardococati.repository.dao.ICandlestickSemanalDAO;
import com.ricardococati.repository.dao.IControleExecucaoDAO;
import com.ricardococati.repository.dao.IMacdDiarioDAO;
import com.ricardococati.repository.dao.IMacdSemanalDAO;
import com.ricardococati.repository.dao.IMediaMovelExponencialDiarioDAO;
import com.ricardococati.service.ICalculaService;
import java.util.List;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Data
@Service
@RequiredArgsConstructor
public class CalculaService implements ICalculaService {

  private final ICandlestickDiarioDAO diarioDAO;
  private final ICandlestickSemanalDAO semanalDAO;
  private final IMacdDiarioDAO macdDiarioDAO;
  private final IMacdSemanalDAO macdSemanalDAO;
  private final IMediaMovelExponencialDiarioDAO mediaExponencialDAO;
  private final IControleExecucaoDAO execucaoDAO;

  @Override
  public List<String> listCodNegDiario() {
    return diarioDAO.getListCodNeg();
  }

  @Override
  public List<String> listCodNegSemanal() {
    return semanalDAO.getListCodNeg();
  }

  @Override
  public List<MacdDiario> listMacdDiarioByCodNeg(String codneg) {
    return macdDiarioDAO.listMacdByCodNeg(codneg);
  }

  @Override
  public List<MacdSemanal> listMacdSemanalByCodNeg(String codneg) {
    return macdSemanalDAO.listMacdByCodNeg(codneg);
  }

  @Override
  public ControleExecucao carregaControleExecucao() {
    return execucaoDAO.loadControleExecucao();
  }

  @Override
  public Boolean updateControleExecucaoDiario(ControleExecucao controleExecucao) {
    return execucaoDAO.updateControleExecucaoDiario(controleExecucao);
  }

  @Override
  public Boolean updateControleExecucaoSemanal(ControleExecucao controleExecucao) {
    return execucaoDAO.updateControleExecucaoSemanal(controleExecucao);
  }

}
