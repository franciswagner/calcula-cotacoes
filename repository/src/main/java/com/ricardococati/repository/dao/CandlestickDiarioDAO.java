package com.ricardococati.repository.dao;

import com.ricardococati.model.dto.CandlestickDiarioDTO;
import com.ricardococati.model.dto.SplitInplit;
import java.time.LocalDate;
import java.util.List;

public interface CandlestickDiarioDAO {

  Boolean incluirCandlestickDiario(final CandlestickDiarioDTO candlestickDiarioDTO);

  List<CandlestickDiarioDTO> buscaCandleDiarioPorCodNeg(final String codneg);

  List<String> getListCodNegMediaSimplesFalse(final LocalDate dtpregLimite);

  List<String> getListCodNegMediaExponencialFalse(final LocalDate dtpregLimite);

  List<String> getListCodNegMacdFalse(final LocalDate dtpregLimite);

  List<String> getListCodNegSinalMacdFalse(final LocalDate dtpregLimite);

  List<String> getListCodNegHistogramaFalse(final LocalDate dtpregLimite);

  List<String> getListCodNegByDtPreg(final LocalDate dtpregLimite);

  List<String> getListCodNeg();

  Boolean updateCandleDiarioMediaSimplesGeradaByCodNeg(final String codneg);

  Boolean updateCandleDiarioMediaExponencialGeradaByCodNeg(final String codneg);

  Boolean updateCandleDiarioMacdGeradaByCodNeg(final String codneg);

  Boolean updateCandleDiarioSinalMacdGeradaByCodNeg(final String codneg);
}