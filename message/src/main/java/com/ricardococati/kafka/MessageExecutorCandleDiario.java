package com.ricardococati.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ricardococati.model.dto.CandlestickDiarioMessage;
import com.ricardococati.service.CandlestickDiarioInserirService;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageExecutorCandleDiario {

  private final ObjectMapper objectMapper;
  private final CandlestickDiarioInserirService service;

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
