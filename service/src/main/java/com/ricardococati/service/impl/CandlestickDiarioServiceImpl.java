package com.ricardococati.service.impl;

import com.ricardococati.model.dto.CandlestickDiarioDTO;
import com.ricardococati.model.dto.CandlestickDiarioMessage;
import com.ricardococati.repository.dao.CandlestickDiarioDAO;
import com.ricardococati.service.CandlestickDiarioService;
import com.ricardococati.service.converter.CandlestickMessageConverter;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Data
@Service
@RequiredArgsConstructor
public class CandlestickDiarioServiceImpl implements CandlestickDiarioService {


  private final CandlestickDiarioDAO diarioDAO;
  private final CandlestickMessageConverter converter;

  @Override
  public List<CandlestickDiarioDTO> listaCandlestickDiario(
      final CandlestickDiarioDTO candlestickDiarioDTO) {
    return diarioDAO.buscaCandleDiarioPorCodNeg(candlestickDiarioDTO.getCandlestickDTO().getCodneg());
  }

  @Override
  public List<String> listCodNegocioMediaSimplesFalse(final LocalDate dtpregLimite) {
    return diarioDAO.getListCodNegMediaSimplesFalse(dtpregLimite);
  }

  @Override
  public List<String> listCodNegocioMediaExponencialFalse(final LocalDate dtpregLimite) {
    return diarioDAO.getListCodNegMediaExponencialFalse(dtpregLimite);
  }

  @Override
  public List<String> listCodNegocioMacdFalse(final LocalDate dtpregLimite) {
    return diarioDAO.getListCodNegMacdFalse(dtpregLimite);
  }

  @Override
  public List<String> listCodNegocioSinalMacdFalse(final LocalDate dtpregLimite) {
    return diarioDAO.getListCodNegSinalMacdFalse(dtpregLimite);
  }

  @Override
  public List<String> listCodNegocioHistogramaFalse(final LocalDate dtpregLimite) {
    return diarioDAO.getListCodNegHistogramaFalse(dtpregLimite);
  }

  @Override
  public List<String> listCodNegByDtPreg(final LocalDate dtpregLimite) {
    return diarioDAO.getListCodNegByDtPreg(dtpregLimite);
  }

  @Override
  public Boolean incluirCandlestickDiario(final CandlestickDiarioMessage message) {
    return diarioDAO.incluirCandlestickDiario(converter.convert(message));
  }

  @Override
  public List<String> listCodNegocio() {
    return diarioDAO.getListCodNeg();
  }

  @Override
  public Boolean atualizaCandleDiarioMediaSimplesGeradaByCodneg(String codneg) {
    return diarioDAO.updateCandleDiarioMediaSimplesGeradaByCodNeg(codneg);
  }

  @Override
  public Boolean atualizaCandleDiarioMediaExponencialGeradaByCodneg(String codneg) {
    return diarioDAO.updateCandleDiarioMediaExponencialGeradaByCodNeg(codneg);
  }

  @Override
  public Boolean atualizaCandleDiarioMacdGeradaByCodneg(String codneg) {
    return diarioDAO.updateCandleDiarioMacdGeradaByCodNeg(codneg);
  }

  @Override
  public Boolean atualizaCandleDiarioSinalMacdGeradaByCodneg(String codneg) {
    return diarioDAO.updateCandleDiarioSinalMacdGeradaByCodNeg(codneg);
  }

}
