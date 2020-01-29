package com.ricardococati.service.impl;

import com.ricardococati.model.dto.ControleExecucao;
import com.ricardococati.model.dto.MacdDiario;
import com.ricardococati.model.dto.MacdSemanal;
import com.ricardococati.repository.dao.CandlestickDiarioBuscarDAO;
import com.ricardococati.repository.dao.CandlestickSemanalBuscarDAO;
import com.ricardococati.repository.dao.ControleExecucaoDAO;
import com.ricardococati.repository.dao.MacdDiarioBuscarDAO;
import com.ricardococati.repository.dao.MacdSemanalBuscarDAO;
import com.ricardococati.repository.dao.MediaMovelExponencialDiarioDAO;
import com.ricardococati.service.CalculaService;
import java.util.List;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Data
@Service
@RequiredArgsConstructor
public class CalculaServiceImpl implements CalculaService {

  private final CandlestickDiarioBuscarDAO diarioDAO;
  private final CandlestickSemanalBuscarDAO semanalDAO;
  private final MacdDiarioBuscarDAO macdDiarioBuscarDAO;
  private final MacdSemanalBuscarDAO macdSemanalBuscarDAO;
  private final MediaMovelExponencialDiarioDAO mediaExponencialDAO;
  private final ControleExecucaoDAO execucaoDAO;

  @Override
  public List<MacdDiario> listMacdDiarioByCodNeg(String codneg) {
    return macdDiarioBuscarDAO.listMacdByCodNeg(codneg);
  }

  @Override
  public List<MacdSemanal> listMacdSemanalByCodNeg(String codneg) {
    return macdSemanalBuscarDAO.listMacdByCodNeg(codneg);
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
