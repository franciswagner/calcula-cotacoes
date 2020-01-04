package com.ricardococati.service.impl;

import com.ricardococati.model.dto.CandlestickDiarioDTO;
import com.ricardococati.model.dto.CandlestickDiarioMessage;
import com.ricardococati.repository.dao.CandlestickDiarioDAO;
import com.ricardococati.repository.dao.IncluirCandlestickDiarioDAO;
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
  private final IncluirCandlestickDiarioDAO incluirDiario;
  private final CandlestickMessageConverter converter;

  @Override
  public List<CandlestickDiarioDTO> listaCandlestickDiario(
      final CandlestickDiarioDTO candlestickDiarioDTO) {
    return diarioDAO.buscaCandleDiarioPorCodNeg(candlestickDiarioDTO.getCandlestickDTO().getCodneg());
  }

  @Override
  public List<String> listCodNegByDtPreg(final LocalDate dtpregLimite) {
    return diarioDAO.getListCodNegByDtPreg(dtpregLimite);
  }

  @Override
  public Boolean incluirCandlestickDiario(final CandlestickDiarioMessage message) {
    return incluirDiario.incluirCandlestickDiario(converter.convert(message));
  }

  @Override
  public List<String> listCodNegocio() {
    return diarioDAO.getListCodNeg();
  }

}
