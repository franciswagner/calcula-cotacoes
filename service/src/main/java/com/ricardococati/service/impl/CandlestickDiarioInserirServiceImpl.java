package com.ricardococati.service.impl;

import com.ricardococati.model.dto.CandlestickDiarioMessage;
import com.ricardococati.repository.dao.CandlestickDiarioInserirDAO;
import com.ricardococati.service.CandlestickDiarioInserirService;
import com.ricardococati.service.converter.CandlestickMessageConverter;
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
