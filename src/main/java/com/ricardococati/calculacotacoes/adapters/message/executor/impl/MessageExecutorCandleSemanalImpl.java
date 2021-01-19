package com.ricardococati.calculacotacoes.adapters.message.executor.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ricardococati.calculacotacoes.adapters.message.executor.MessageExecutorCandleSemanal;
import com.ricardococati.calculacotacoes.entities.domains.candlestick.CandlestickSemanalMessage;
import com.ricardococati.calculacotacoes.usecases.candlestick.CandlestickSemanalInserirService;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class MessageExecutorCandleSemanalImpl implements MessageExecutorCandleSemanal {

  private final ObjectMapper objectMapper;
  private final CandlestickSemanalInserirService service;

  @Override
  public void execute(final String payload) {
    final CandlestickSemanalMessage domain = payloadToDomain(payload);
    log.info("payload: " + payload);
    service.incluirCandlestickSemanal(domain);
  }

  private CandlestickSemanalMessage payloadToDomain(String payload) {
    try {
      return objectMapper.readValue(payload, CandlestickSemanalMessage.class);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
