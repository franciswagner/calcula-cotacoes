package com.ricardococati.calculacotacoes.adapters.repositories.candlestick;

import com.ricardococati.calculacotacoes.entities.domains.candlestick.CandlestickSemanal;
import java.time.LocalDate;
import java.util.List;

public interface CandlestickSemanalBuscarDAO {

  List<CandlestickSemanal> buscaCandleSemanalPorCodNeg(final String codneg);

  List<String> buscaCandleSemanalPorDtPreg(final LocalDate dtpregLimite);

}
