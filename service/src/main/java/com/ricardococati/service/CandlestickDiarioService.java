package com.ricardococati.service;

import com.ricardococati.model.dto.CandlestickDiarioDTO;
import com.ricardococati.model.dto.CandlestickDiarioMessage;
import java.time.LocalDate;
import java.util.List;

public interface CandlestickDiarioService {

  List<CandlestickDiarioDTO> listaCandlestickDiario(CandlestickDiarioDTO candlestickDiarioDTO);

  List<String> listCodNegocioMediaSimplesFalse(final LocalDate dtpregLimite);

  List<String> listCodNegocioMediaExponencialFalse(final LocalDate dtpregLimite);

  List<String> listCodNegocioMacdFalse(final LocalDate dtpregLimite);

  List<String> listCodNegocioSinalMacdFalse(final LocalDate dtpregLimite);

  List<String> listCodNegocioHistogramaFalse(final LocalDate dtpregLimite);

  List<String> listCodNegByDtPreg(final LocalDate dtpregLimite);

  Boolean incluirCandlestickDiario(final CandlestickDiarioMessage message);

  List<String> listCodNegocio();

  Boolean atualizaCandleDiarioMediaSimplesGeradaByCodneg(String codigoNegocio);

  Boolean atualizaCandleDiarioMediaExponencialGeradaByCodneg(String codneg);

  Boolean atualizaCandleDiarioMacdGeradaByCodneg(String codneg);

  Boolean atualizaCandleDiarioSinalMacdGeradaByCodneg(String codneg);

}