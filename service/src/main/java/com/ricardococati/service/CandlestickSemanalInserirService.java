package com.ricardococati.service;

import com.ricardococati.model.dto.CandlestickSemanalMessage;

public interface CandlestickSemanalInserirService {

  Boolean incluirCandlestickSemanal(final CandlestickSemanalMessage message);

}
