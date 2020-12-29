package com.ricardococati.calculacotacoes.adapters.repositories.candlestick;

import com.ricardococati.calculacotacoes.entities.domains.candlestick.CandlestickDiario;

public interface CandlestickDiarioInserirDAO {

  Boolean insereCandlestickDiario(final CandlestickDiario candlestickDiario);

}