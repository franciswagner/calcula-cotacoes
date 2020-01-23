package com.ricardococati.repository.dao;

import com.ricardococati.model.dto.CandlestickDiarioDTO;
import java.time.LocalDate;
import java.util.List;

public interface CandlestickDiarioBuscarDAO {

  List<CandlestickDiarioDTO> buscaCandleDiarioPorCodNeg(final String codneg);

  List<String> buscaCandleDiarioPorDtPreg(final LocalDate dtpregLimite);

}