package com.ricardococati.calculacotacoes.usecases.candlestick.impl;

import com.ricardococati.calculacotacoes.adapters.repositories.candlestick.CandlestickDiarioInserirDAO;
import com.ricardococati.calculacotacoes.entities.domains.candlestick.CandlestickDiarioMessage;
import com.ricardococati.calculacotacoes.usecases.candlestick.CandlestickDiarioInserirService;
import com.ricardococati.calculacotacoes.utils.converters.CandlestickMessageConverter;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Data
@Service
@RequiredArgsConstructor
public class CandlestickDiarioInserirServiceImpl implements CandlestickDiarioInserirService {


  private final CandlestickDiarioInserirDAO incluirDiario;
  private final CandlestickMessageConverter converter;

  @Override
  public Boolean incluirCandlestickDiario(final CandlestickDiarioMessage message) {
    return incluirDiario.insereCandlestickDiario(converter.convert(message));
  }

}
