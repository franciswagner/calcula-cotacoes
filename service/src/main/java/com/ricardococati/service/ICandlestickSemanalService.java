package com.ricardococati.service;

import com.ricardococati.model.dto.CandlestickDiarioDTO;
import com.ricardococati.model.dto.CandlestickDiarioMessage;
import com.ricardococati.model.dto.CandlestickSemanalDTO;
import com.ricardococati.model.dto.CandlestickSemanalMessage;
import java.util.List;

public interface ICandlestickSemanalService {

  Boolean incluirCandlestickSemanal(final CandlestickSemanalMessage message);

  List<CandlestickSemanalDTO> listaCandlestickSemanal(CandlestickSemanalDTO candlestickDiarioDTO);

  List<String> listCodNegocioMediaSimplesFalse();

  Boolean atualizaCandleSemanalMediaSimplesGeradaByCodneg(String codigoNegocio);

  Boolean atualizaCandleSemanalMediaExponencialGeradaByCodneg(String codneg);

  Boolean atualizaCandleSemanalMacdGeradaByCodneg(String codneg);

  Boolean atualizaCandleSemanalSinalMacdGeradaByCodneg(String codneg);

  List<String> listCodNegocioMediaExponencialFalse();

  List<String> listCodNegocioMacdFalse();

}
