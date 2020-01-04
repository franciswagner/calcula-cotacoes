package com.ricardococati.repository.dao;

import com.ricardococati.model.dto.CandlestickSemanalDTO;
import com.ricardococati.model.dto.SplitInplit;
import java.time.LocalDate;
import java.util.List;

public interface CandlestickSemanalDAO {

  Boolean incluirCandlestickSemanal(final CandlestickSemanalDTO semanal);

  Boolean split(SplitInplit splitInplit);

  Boolean inplit(SplitInplit splitInplit);

  List<CandlestickSemanalDTO> findCandleSemanalPorCodNeg(final String codneg);

  List<String> getListCodNegByDtPreg(final LocalDate dtpregLimite);

}
