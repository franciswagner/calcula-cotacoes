package com.ricardococati.service;

import com.ricardococati.model.dto.CandlestickDiarioDTO;
import java.time.LocalDate;
import java.util.List;

public interface BuscarCandlestickDiarioService {

  List<CandlestickDiarioDTO> buscaCandlestickDiarioPorCodNeg(CandlestickDiarioDTO candlestickDiarioDTO);

  List<String> buscaCandlestickDiarioPorDtPreg(final LocalDate dtpregLimite);

}
