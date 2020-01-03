package com.ricardococati.service.impl;

import com.ricardococati.model.dto.SplitInplit;
import com.ricardococati.repository.dao.CandlestickSemanalDAO;
import com.ricardococati.repository.dao.SplitInplitCandlestickDiarioDAO;
import com.ricardococati.service.SplitInplitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SplitInplitServiceImpl implements SplitInplitService {

  private final SplitInplitCandlestickDiarioDAO candlestickDiarioDAO;
  private final CandlestickSemanalDAO candlestickSemanalDAO;

  @Override
  public Boolean executeSplitInplit(final SplitInplit splitInplit) {
    Boolean retorno = candlestickDiarioDAO.updateSplitInplit(splitInplit);
    if (retorno) {
      retorno = candlestickSemanalDAO.split(splitInplit);
    }
    return retorno;
  }

  @Override
  public Boolean inplit(final SplitInplit splitInplit) {
    return candlestickSemanalDAO.inplit(splitInplit);
  }
}
