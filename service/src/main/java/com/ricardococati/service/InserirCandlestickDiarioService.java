package com.ricardococati.service;

import com.ricardococati.model.dto.CandlestickDiarioMessage;

public interface InserirCandlestickDiarioService {

  Boolean incluirCandlestickDiario(final CandlestickDiarioMessage message);

}
