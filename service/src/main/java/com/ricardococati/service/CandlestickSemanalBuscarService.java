package com.ricardococati.service;

import com.ricardococati.model.dto.CandlestickSemanalDTO;
import com.ricardococati.model.dto.CandlestickSemanalMessage;
import java.time.LocalDate;
import java.util.List;

public interface CandlestickSemanalBuscarService {

  List<CandlestickSemanalDTO> buscaCandlestickSemanalPorCodNeg(CandlestickSemanalDTO candlestickDiarioDTO);

  List<String> buscaCandlestickSemanalPorDtPreg(final LocalDate dtpregLimite);

}
