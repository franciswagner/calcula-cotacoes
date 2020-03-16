package com.ricardococati.repository.dao;

import com.ricardococati.model.entities.CandlestickSemanal;
import java.time.LocalDate;
import java.util.List;

public interface CandlestickSemanalBuscarDAO {

  List<CandlestickSemanal> buscaCandleSemanalPorCodNeg(final String codneg);

  List<String> buscaCandleSemanalPorDtPreg(final LocalDate dtpregLimite);

}
