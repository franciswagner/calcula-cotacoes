package com.ricardococati.calculacotacoes.adapters.repositories.candlestick;

import com.ricardococati.calculacotacoes.entities.domains.candlestick.CandlestickDiario;
import java.time.LocalDate;
import java.util.List;

public interface CandlestickDiarioBuscarDAO {

  List<CandlestickDiario> buscaCandleDiarioPorCodNeg(final String codneg);

  List<String> buscaCandleDiarioPorDtPreg(final LocalDate dtpregLimite);

}