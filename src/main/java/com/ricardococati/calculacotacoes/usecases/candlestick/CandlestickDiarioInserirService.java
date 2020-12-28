package com.ricardococati.calculacotacoes.usecases.candlestick;

import com.ricardococati.calculacotacoes.entities.domains.candlestick.CandlestickDiarioMessage;

public interface CandlestickDiarioInserirService {

  Boolean incluirCandlestickDiario(final CandlestickDiarioMessage message);

}
