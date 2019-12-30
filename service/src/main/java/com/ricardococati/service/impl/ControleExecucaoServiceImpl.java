package com.ricardococati.service.impl;

import com.ricardococati.model.dto.ControleExecucao;
import com.ricardococati.repository.dao.ControleExecucaoDAO;
import com.ricardococati.service.ControleExecucaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ControleExecucaoServiceImpl implements ControleExecucaoService {

  private final ControleExecucaoDAO execucaoDAO;

  @Override
  public ControleExecucao carregaControleExecucao() {
    return execucaoDAO.loadControleExecucao();
  }

}
