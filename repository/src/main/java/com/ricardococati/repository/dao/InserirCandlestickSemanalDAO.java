package com.ricardococati.repository.dao;

import com.ricardococati.model.dto.CandlestickSemanalDTO;

public interface InserirCandlestickSemanalDAO {

  Boolean incluirCandlestickSemanal(final CandlestickSemanalDTO semanal);

}
