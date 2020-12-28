package com.ricardococati.calculacotacoes.usecases.candlestick.impl;

import com.ricardococati.calculacotacoes.adapters.repositories.candlestick.CandlestickSemanalBuscarDAO;
import com.ricardococati.calculacotacoes.entities.domains.candlestick.CandlestickSemanal;
import com.ricardococati.calculacotacoes.usecases.candlestick.CandlestickSemanalBuscarService;
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
public class CandlestickSemanalBuscarServiceImpl implements CandlestickSemanalBuscarService {

  private final CandlestickSemanalBuscarDAO semanalDAO;
  private final CandlestickMessageConverter converter;

  @Override
  public List<CandlestickSemanal> buscaCandlestickSemanalPorCodNeg(
      final CandlestickSemanal semanalDTO) {
    return semanalDAO.buscaCandleSemanalPorCodNeg(semanalDTO.getCandlestick().getCodneg());
  }

  @Override
  public List<String> buscaCandlestickSemanalPorDtPreg(
      final LocalDate dtpregLimite) {
    return semanalDAO.buscaCandleSemanalPorDtPreg(dtpregLimite);
  }

}
