package com.ricardococati.calculacotacoes.usecases.candlestick.impl;

import com.ricardococati.calculacotacoes.adapters.repositories.candlestick.CandlestickDiarioAtualizarDAO;
import com.ricardococati.calculacotacoes.adapters.repositories.candlestick.CandlestickSemanalAtualizarDAO;
import com.ricardococati.calculacotacoes.entities.domains.split.SplitInplit;
import com.ricardococati.calculacotacoes.usecases.candlestick.CandlestickAtualizarService;
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
