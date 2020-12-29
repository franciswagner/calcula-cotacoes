package com.ricardococati.calculacotacoes.usecases.calculageral.impl;

import com.ricardococati.calculacotacoes.adapters.repositories.candlestick.CandlestickDiarioBuscarDAO;
import com.ricardococati.calculacotacoes.adapters.repositories.candlestick.CandlestickSemanalBuscarDAO;
import com.ricardococati.calculacotacoes.adapters.repositories.controle.ControleExecucaoDAO;
import com.ricardococati.calculacotacoes.adapters.repositories.macd.MacdDiarioBuscarDAO;
import com.ricardococati.calculacotacoes.adapters.repositories.macd.MacdSemanalBuscarDAO;
import com.ricardococati.calculacotacoes.adapters.repositories.mediaexponencial.MediaMovelExponencialDiarioBuscarDAO;
import com.ricardococati.calculacotacoes.entities.domains.controle.ControleExecucao;
import com.ricardococati.calculacotacoes.entities.domains.macd.MacdDiario;
import com.ricardococati.calculacotacoes.entities.domains.macd.MacdSemanal;
import com.ricardococati.calculacotacoes.usecases.calculageral.CalculaService;
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
  private final MediaMovelExponencialDiarioBuscarDAO mediaExponencialDAO;
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
