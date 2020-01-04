package com.ricardococati.repository.dao;

import com.ricardococati.model.dto.CandlestickDiarioDTO;
import java.time.LocalDate;
import java.util.List;

public interface BuscarCandlestickDiarioDAO {

  List<CandlestickDiarioDTO> buscaCandleDiarioPorCodNeg(final String codneg);

  List<CandlestickDiarioDTO> buscaCandleDiarioPorDtPreg(final LocalDate dtpregLimite);

}