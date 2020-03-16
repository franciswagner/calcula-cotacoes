package com.ricardococati.service.impl;

import com.ricardococati.model.entities.SplitInplit;
import com.ricardococati.repository.dao.CandlestickSemanalAtualizarDAO;
import com.ricardococati.repository.dao.CandlestickDiarioAtualizarDAO;
import com.ricardococati.service.CandlestickAtualizarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CandlestickAtualizarServiceImpl implements CandlestickAtualizarService {

  private final CandlestickDiarioAtualizarDAO atualizarDiarioDAO;
  private final CandlestickSemanalAtualizarDAO atualizarSemanalDAO;

  @Override
  public Boolean executeSplitInplit(final SplitInplit splitInplit) {
    Boolean retorno = atualizarDiarioDAO.atualizaSplitInplit(splitInplit);
    if (retorno) {
      retorno = atualizarSemanalDAO.atualizaSplitInplit(splitInplit);
    }
    return retorno;
  }

}
