package com.ricardococati.service;

import com.ricardococati.model.dto.CandlestickSemanalDTO;
import com.ricardococati.model.dto.CandlestickSemanalMessage;
import java.time.LocalDate;
import java.util.List;

public interface CandlestickSemanalService {

  Boolean incluirCandlestickSemanal(final CandlestickSemanalMessage message);

  List<CandlestickSemanalDTO> listaCandlestickSemanal(CandlestickSemanalDTO candlestickDiarioDTO);

  Boolean atualizaCandleSemanalSinalMacdGeradaByCodneg(String codneg);

  List<String> listCodNegByDtPreg(final LocalDate dtpregLimite);

}
