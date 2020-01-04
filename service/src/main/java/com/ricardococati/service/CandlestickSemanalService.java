package com.ricardococati.service;

import com.ricardococati.model.dto.CandlestickSemanalDTO;
import com.ricardococati.model.dto.CandlestickSemanalMessage;
import java.time.LocalDate;
import java.util.List;

public interface CandlestickSemanalService {

  List<CandlestickSemanalDTO> listaCandlestickSemanal(CandlestickSemanalDTO candlestickDiarioDTO);

  List<String> listCodNegByDtPreg(final LocalDate dtpregLimite);

}
