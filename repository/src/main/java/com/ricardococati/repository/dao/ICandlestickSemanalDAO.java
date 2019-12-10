package com.ricardococati.repository.dao;

import com.ricardococati.model.dto.CandlestickSemanalDTO;
import com.ricardococati.model.dto.SplitInplit;
import java.util.List;

public interface ICandlestickSemanalDAO {

  Integer contaCandleDiarioSemCandleSemSemanalGerado();

  Boolean incluirCandlestickSemanal(final CandlestickSemanalDTO semanal);

  Boolean split(SplitInplit splitInplit);

  Boolean inplit(SplitInplit splitInplit);

  Boolean updateCandlestickSemanal();

  List<String> listCodNegocioMediaSimplesFalse();

  List<CandlestickSemanalDTO> findCandleSemanalPorCodNeg(final String codneg);

  Boolean updateCandleSemanalMediaSimplesGeradaByCodNeg(final String codneg);

  Boolean updateCandleSemanalMediaExponencialGeradaByCodNeg(final String codneg);

  Boolean updateCandleSemanalMacdGeradaByCodNeg(final String codneg);

  Boolean updateCandleSemanalSinalMacdGeradaByCodNeg(final String codneg);

  List<String> getListCodNeg();
}
