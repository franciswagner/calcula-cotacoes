package com.ricardococati.calculacotacoes.adapters.message.executor.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ricardococati.calculacotacoes.adapters.message.executor.MessageExecutorCandleDiario;
import com.ricardococati.calculacotacoes.entities.domains.candlestick.CandlestickDiarioMessage;
import com.ricardococati.calculacotacoes.usecases.candlestick.CandlestickDiarioInserirService;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class MessageExecutorCandleDiarioImpl implements MessageExecutorCandleDiario {

  private final ObjectMapper objectMapper;
  private final CandlestickDiarioInserirService service;

  @Override
  public void execute(final String payload) {
    final CandlestickDiarioMessage domain = payloadToDomain(payload);
    log.info("payload: " + payload);
    service.incluirCandlestickDiario(domain);
  }

  private CandlestickDiarioMessage payloadToDomain(String payload) {
    try {
      return objectMapper.readValue(payload, CandlestickDiarioMessage.class);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
