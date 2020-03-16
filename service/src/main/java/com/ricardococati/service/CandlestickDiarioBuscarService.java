package com.ricardococati.service;

import com.ricardococati.model.entities.CandlestickDiario;
import java.time.LocalDate;
import java.util.List;

public interface CandlestickDiarioBuscarService {

  List<CandlestickDiario> buscaCandlestickDiarioPorCodNeg(CandlestickDiario candlestickDiario);

  List<String> buscaCandlestickDiarioPorDtPreg(final LocalDate dtpregLimite);

}
