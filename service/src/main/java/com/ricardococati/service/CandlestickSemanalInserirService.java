package com.ricardococati.service;

import com.ricardococati.model.entities.CandlestickSemanalMessage;

public interface CandlestickSemanalInserirService {

  Boolean incluirCandlestickSemanal(final CandlestickSemanalMessage message);

}
