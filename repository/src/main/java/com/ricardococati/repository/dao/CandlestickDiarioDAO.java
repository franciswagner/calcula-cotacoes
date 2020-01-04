package com.ricardococati.repository.dao;

import com.ricardococati.model.dto.CandlestickDiarioDTO;
import java.time.LocalDate;
import java.util.List;

public interface CandlestickDiarioDAO {

  List<CandlestickDiarioDTO> buscaCandleDiarioPorCodNeg(final String codneg);

  List<String> getListCodNegByDtPreg(final LocalDate dtpregLimite);

  List<String> getListCodNeg();

}