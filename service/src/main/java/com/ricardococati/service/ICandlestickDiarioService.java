package com.ricardococati.service;

import com.ricardococati.model.dto.CandlestickDiarioDTO;
import com.ricardococati.model.dto.CandlestickDiarioMessage;
import java.util.List;

public interface ICandlestickDiarioService {

  List<CandlestickDiarioDTO> listaCandlestickDiario(CandlestickDiarioDTO candlestickDiarioDTO);

  List<String> listCodNegocioMediaSimplesFalse();

  List<String> listCodNegocioMediaExponencialFalse();

  Boolean incluirCandlestickDiario(final CandlestickDiarioMessage message);

  List<String> listCodNegocio();

  Boolean atualizaCandleDiarioMediaSimplesGeradaByCodneg(String codigoNegocio);

  Boolean atualizaCandleDiarioMediaExponencialGeradaByCodneg(String codneg);

  Boolean atualizaCandleDiarioMacdGeradaByCodneg(String codneg);

  Boolean atualizaCandleDiarioSinalMacdGeradaByCodneg(String codneg);

}
