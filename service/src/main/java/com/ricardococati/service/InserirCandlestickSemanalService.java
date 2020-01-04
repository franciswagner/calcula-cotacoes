package com.ricardococati.service;

import com.ricardococati.model.dto.CandlestickSemanalMessage;

public interface InserirCandlestickSemanalService {

  Boolean incluirCandlestickSemanal(final CandlestickSemanalMessage message);

}
