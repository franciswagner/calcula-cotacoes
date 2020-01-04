package com.ricardococati.service.impl;

import com.ricardococati.model.dto.CandlestickDiarioMessage;
import com.ricardococati.repository.dao.IncluirCandlestickDiarioDAO;
import com.ricardococati.service.InserirCandlestickDiarioService;
import com.ricardococati.service.converter.CandlestickMessageConverter;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Data
@Service
@RequiredArgsConstructor
public class InserirCandlestickDiarioServiceImpl implements InserirCandlestickDiarioService {


  private final IncluirCandlestickDiarioDAO incluirDiario;
  private final CandlestickMessageConverter converter;

  @Override
  public Boolean incluirCandlestickDiario(final CandlestickDiarioMessage message) {
    return incluirDiario.incluirCandlestickDiario(converter.convert(message));
  }

}
