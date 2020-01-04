package com.ricardococati.service.impl;

import com.ricardococati.model.dto.CandlestickDiarioDTO;
import com.ricardococati.repository.dao.BuscarCandlestickDiarioDAO;
import com.ricardococati.service.BuscarCandlestickDiarioService;
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
public class BuscarCandlestickDiarioServiceImpl implements BuscarCandlestickDiarioService {

  private final BuscarCandlestickDiarioDAO diarioDAO;
  private final CandlestickMessageConverter converter;

  @Override
  public List<CandlestickDiarioDTO> buscaCandlestickDiarioPorCodNeg(
      final CandlestickDiarioDTO candlestickDiarioDTO) {
    return diarioDAO.buscaCandleDiarioPorCodNeg(candlestickDiarioDTO.getCandlestickDTO().getCodneg());
  }

  @Override
  public List<String> buscaCandlestickDiarioPorDtPreg(
      final LocalDate dtpregLimite) {
    return diarioDAO.buscaCandleDiarioPorDtPreg(dtpregLimite);
  }

}
