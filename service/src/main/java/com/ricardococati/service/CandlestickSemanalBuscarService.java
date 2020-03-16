package com.ricardococati.service;

import com.ricardococati.model.entities.CandlestickSemanal;
import java.time.LocalDate;
import java.util.List;

public interface CandlestickSemanalBuscarService {

  List<CandlestickSemanal> buscaCandlestickSemanalPorCodNeg(CandlestickSemanal candlestickDiarioDTO);

  List<String> buscaCandlestickSemanalPorDtPreg(final LocalDate dtpregLimite);

}
