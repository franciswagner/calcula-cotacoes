package com.ricardococati.calculacotacoes.usecases.candlestick.impl;

import com.ricardococati.calculacotacoes.adapters.repositories.candlestick.CandlestickDiarioBuscarDAO;
import com.ricardococati.calculacotacoes.entities.domains.candlestick.CandlestickDiario;
import com.ricardococati.calculacotacoes.usecases.candlestick.CandlestickDiarioBuscarService;
import com.ricardococati.calculacotacoes.utils.converters.CandlestickMessageConverter;
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
