package com.ricardococati.service;

import com.ricardococati.model.entities.CandlestickDiarioMessage;

public interface CandlestickDiarioInserirService {

  Boolean incluirCandlestickDiario(final CandlestickDiarioMessage message);

}
