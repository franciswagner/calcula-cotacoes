package com.ricardococati.repository.dao;

import com.ricardococati.model.dto.CandlestickDiarioDTO;
import com.ricardococati.model.dto.SplitInplit;
import java.util.List;

public interface ICandlestickDiarioDAO {

  Boolean incluirCandlestickDiario(final CandlestickDiarioDTO candlestickDiarioDTO);

  Boolean split(final SplitInplit splitInplit);

  Boolean inplit(final SplitInplit splitInplit);

  List<CandlestickDiarioDTO> buscaCandleDiarioPorCodNeg(final String codneg);

  List<String> getListCodNegMediaSimplesFalse();

  List<String> getListCodNegMediaExponencialFalse();

  Boolean updateCandlestickDiario();

  List<String> getListCodNeg();

  Boolean updateCandleDiarioMediaSimplesGeradaByCodNeg(final String codneg);

  Boolean updateCandleDiarioMediaExponencialGeradaByCodNeg(final String codneg);

  Boolean updateCandleDiarioMacdGeradaByCodNeg(final String codneg);

  Boolean updateCandleDiarioSinalMacdGeradaByCodNeg(final String codneg);
}
