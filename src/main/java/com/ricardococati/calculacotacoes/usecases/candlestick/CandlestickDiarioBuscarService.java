package com.ricardococati.calculacotacoes.usecases.candlestick;

import com.ricardococati.calculacotacoes.entities.domains.candlestick.CandlestickDiario;
import java.time.LocalDate;
import java.util.List;

public interface CandlestickDiarioBuscarService {

  List<CandlestickDiario> buscaCandlestickDiarioPorCodNeg(CandlestickDiario candlestickDiario);

  List<String> buscaCandlestickDiarioPorDtPreg(final LocalDate dtpregLimite);

}
