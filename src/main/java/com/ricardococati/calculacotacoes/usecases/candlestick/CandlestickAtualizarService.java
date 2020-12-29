package com.ricardococati.calculacotacoes.usecases.candlestick;

import com.ricardococati.calculacotacoes.entities.domains.split.SplitInplit;

public interface CandlestickAtualizarService {

  Boolean executeSplitInplit(final SplitInplit splitInplit);

}
