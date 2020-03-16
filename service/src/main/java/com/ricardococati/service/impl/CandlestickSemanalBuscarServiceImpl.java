package com.ricardococati.service.impl;

import com.ricardococati.model.entities.CandlestickSemanal;
import com.ricardococati.repository.dao.CandlestickSemanalBuscarDAO;
import com.ricardococati.service.CandlestickSemanalBuscarService;
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
