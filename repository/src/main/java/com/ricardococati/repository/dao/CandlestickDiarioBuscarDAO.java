package com.ricardococati.repository.dao;

import com.ricardococati.model.entities.CandlestickDiario;
import java.time.LocalDate;
import java.util.List;

public interface CandlestickDiarioBuscarDAO {

  List<CandlestickDiario> buscaCandleDiarioPorCodNeg(final String codneg);

  List<String> buscaCandleDiarioPorDtPreg(final LocalDate dtpregLimite);

}