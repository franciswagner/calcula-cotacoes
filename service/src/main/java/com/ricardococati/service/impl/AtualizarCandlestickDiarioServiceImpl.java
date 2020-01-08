package com.ricardococati.service.impl;

import com.ricardococati.model.dto.SplitInplit;
import com.ricardococati.repository.dao.AtualizarCandlestickSemanalDAO;
import com.ricardococati.repository.dao.AtualizarCandlestickDiarioDAO;
import com.ricardococati.service.AtualizarCandlestickDiarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AtualizarCandlestickDiarioServiceImpl implements AtualizarCandlestickDiarioService {

  private final AtualizarCandlestickDiarioDAO atualizarDiarioDAO;
  private final AtualizarCandlestickSemanalDAO atualizarSemanalDAO;

  @Override
  public Boolean executeSplitInplit(final SplitInplit splitInplit) {
    Boolean retorno = atualizarDiarioDAO.atualizaSplitInplit(splitInplit);
    if (retorno) {
      retorno = atualizarSemanalDAO.atualizaSplitInplit(splitInplit);
    }
    return retorno;
  }

}
