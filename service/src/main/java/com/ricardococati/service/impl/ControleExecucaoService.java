package com.ricardococati.service.impl;

import com.ricardococati.model.dto.ControleExecucao;
import com.ricardococati.model.dto.SplitInplit;
import com.ricardococati.repository.dao.ICandlestickDiarioDAO;
import com.ricardococati.repository.dao.ICandlestickSemanalDAO;
import com.ricardococati.repository.dao.IControleExecucaoDAO;
import com.ricardococati.service.IControleExecucaoService;
import com.ricardococati.service.ISplitInplitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ControleExecucaoService implements IControleExecucaoService {

  private final IControleExecucaoDAO execucaoDAO;

  @Override
  public ControleExecucao carregaControleExecucao() {
    return execucaoDAO.loadControleExecucao();
  }

}
