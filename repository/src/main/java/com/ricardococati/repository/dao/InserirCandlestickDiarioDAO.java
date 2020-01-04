package com.ricardococati.repository.dao;

import com.ricardococati.model.dto.CandlestickDiarioDTO;

public interface InserirCandlestickDiarioDAO {

  Boolean insereCandlestickDiario(final CandlestickDiarioDTO candlestickDiarioDTO);

}