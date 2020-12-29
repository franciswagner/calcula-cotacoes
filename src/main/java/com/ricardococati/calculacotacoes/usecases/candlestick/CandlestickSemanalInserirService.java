package com.ricardococati.calculacotacoes.usecases.candlestick;

import com.ricardococati.calculacotacoes.entities.domains.candlestick.CandlestickSemanalMessage;

public interface CandlestickSemanalInserirService {

  Boolean incluirCandlestickSemanal(final CandlestickSemanalMessage message);

}
