package com.ricardococati.repository.dao;

import com.ricardococati.model.dto.CandlestickDiarioDTO;
import com.ricardococati.model.dto.SplitInplit;
import java.time.LocalDate;
import java.util.List;

public interface ICandlestickDiarioDAO {

  Boolean incluirCandlestickDiario(final CandlestickDiarioDTO candlestickDiarioDTO);

  Boolean split(final SplitInplit splitInplit);

  Boolean inplit(final SplitInplit splitInplit);

  List<CandlestickDiarioDTO> buscaCandleDiarioPorCodNeg(final String codneg);

  List<String> getListCodNegMediaSimplesFalse();

  List<String> getListCodNegMediaExponencialFalse();

  List<String> getListCodNegMacdFalse();

  List<String> getListCodNegSinalMacdFalse();

  List<String> getListCodNegHistogramaFalse();

  Boolean updateCandlestickDiario();

  List<String> getListCodNeg();

  Boolean updateCandleDiarioMediaSimplesGeradaByCodNeg(final String codneg);

  Boolean updateCandleDiarioMediaExponencialGeradaByCodNeg(final String codneg);

  Boolean updateCandleDiarioMacdGeradaByCodNeg(final String codneg);

  Boolean updateCandleDiarioSinalMacdGeradaByCodNeg(final String codneg);
}