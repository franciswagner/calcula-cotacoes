package com.ricardococati.service;

import com.ricardococati.model.dto.CandlestickDiarioMessage;

public interface CandlestickDiarioInserirService {

  Boolean incluirCandlestickDiario(final CandlestickDiarioMessage message);

}
