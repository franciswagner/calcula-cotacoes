package com.ricardococati.calculacotacoes.usecases.candlestick.impl;

import com.ricardococati.calculacotacoes.adapters.repositories.candlestick.CandlestickSemanalInserirDAO;
import com.ricardococati.calculacotacoes.entities.domains.candlestick.CandlestickSemanalMessage;
import com.ricardococati.calculacotacoes.usecases.candlestick.CandlestickSemanalInserirService;
import com.ricardococati.calculacotacoes.utils.converters.CandlestickMessageConverter;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Data
@Service
@RequiredArgsConstructor
public class CandlestickSemanalInserirServiceImpl implements CandlestickSemanalInserirService {

  private final CandlestickSemanalInserirDAO semanalDAO;
  private final CandlestickMessageConverter converter;

  @Override
  public Boolean incluirCandlestickSemanal(final CandlestickSemanalMessage message) {
    return semanalDAO.incluirCandlestickSemanal(converter.convertSemanal(message));
  }

}
