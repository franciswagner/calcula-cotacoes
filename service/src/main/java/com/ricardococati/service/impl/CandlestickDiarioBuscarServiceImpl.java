package com.ricardococati.service.impl;

import com.ricardococati.model.entities.CandlestickDiario;
import com.ricardococati.repository.dao.CandlestickDiarioBuscarDAO;
import com.ricardococati.service.CandlestickDiarioBuscarService;
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
public class CandlestickDiarioBuscarServiceImpl implements CandlestickDiarioBuscarService {

  private final CandlestickDiarioBuscarDAO diarioDAO;
  private final CandlestickMessageConverter converter;

  @Override
  public List<CandlestickDiario> buscaCandlestickDiarioPorCodNeg(
      final CandlestickDiario candlestickDiario) {
    return diarioDAO.buscaCandleDiarioPorCodNeg(candlestickDiario.getCandlestick().getCodneg());
  }

  @Override
  public List<String> buscaCandlestickDiarioPorDtPreg(
      final LocalDate dtpregLimite) {
    return diarioDAO.buscaCandleDiarioPorDtPreg(dtpregLimite);
  }

}
