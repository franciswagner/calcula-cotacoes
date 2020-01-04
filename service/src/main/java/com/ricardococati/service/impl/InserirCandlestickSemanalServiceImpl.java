package com.ricardococati.service.impl;

import com.ricardococati.model.dto.CandlestickSemanalMessage;
import com.ricardococati.repository.dao.InserirCandlestickSemanalDAO;
import com.ricardococati.service.InserirCandlestickSemanalService;
import com.ricardococati.service.converter.CandlestickMessageConverter;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Data
@Service
@RequiredArgsConstructor
public class InserirCandlestickSemanalServiceImpl implements InserirCandlestickSemanalService {

  private final InserirCandlestickSemanalDAO semanalDAO;
  private final CandlestickMessageConverter converter;

  @Override
  public Boolean incluirCandlestickSemanal(final CandlestickSemanalMessage message) {
    return semanalDAO.incluirCandlestickSemanal(converter.convertSemanal(message));
  }

}
