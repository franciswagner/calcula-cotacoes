package com.ricardococati.service.impl;

import com.ricardococati.model.dto.CandlestickDiarioDTO;
import com.ricardococati.model.dto.CandlestickDiarioMessage;
import com.ricardococati.repository.dao.ICandlestickDiarioDAO;
import com.ricardococati.service.ICandlestickDiarioService;
import com.ricardococati.service.converter.CandlestickMessageConverter;
import java.util.List;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Data
@Service
@RequiredArgsConstructor
public class CandlestickDiarioService implements ICandlestickDiarioService {


  private final ICandlestickDiarioDAO diarioDAO;
  private final CandlestickMessageConverter converter;

  @Override
  public List<CandlestickDiarioDTO> listaCandlestickDiario(
      final CandlestickDiarioDTO candlestickDiarioDTO) {
    return diarioDAO.buscaCandleDiarioPorCodNeg(candlestickDiarioDTO.getCandlestickDTO().getCodneg());
  }

  @Override
  public List<String> listCodNegocioMediaSimplesFalse() {
    return diarioDAO.getListCodNegMediaSimplesFalse();
  }

  @Override
  public List<String> listCodNegocioMediaExponencialFalse() {
    return diarioDAO.getListCodNegMediaExponencialFalse();
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
