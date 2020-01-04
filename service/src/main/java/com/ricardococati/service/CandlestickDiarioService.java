package com.ricardococati.service;

import com.ricardococati.model.dto.CandlestickDiarioDTO;
import com.ricardococati.model.dto.CandlestickDiarioMessage;
import java.time.LocalDate;
import java.util.List;

public interface CandlestickDiarioService {

  List<CandlestickDiarioDTO> listaCandlestickDiario(CandlestickDiarioDTO candlestickDiarioDTO);

  List<String> listCodNegByDtPreg(final LocalDate dtpregLimite);

  Boolean incluirCandlestickDiario(final CandlestickDiarioMessage message);

  List<String> listCodNegocio();

}
