package com.ricardococati.calculacotacoes.usecases.candlestick;

import com.ricardococati.calculacotacoes.entities.domains.candlestick.CandlestickSemanal;
import java.time.LocalDate;
import java.util.List;

public interface CandlestickSemanalBuscarService {

  List<CandlestickSemanal> buscaCandlestickSemanalPorCodNeg(CandlestickSemanal candlestickDiarioDTO);

  List<String> buscaCandlestickSemanalPorDtPreg(final LocalDate dtpregLimite);

}
