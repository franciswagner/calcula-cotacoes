package com.ricardococati.service.impl;

import com.ricardococati.model.dto.CandlestickSemanalDTO;
import com.ricardococati.repository.dao.CandlestickSemanalDAO;
import com.ricardococati.service.BuscarCandlestickSemanalService;
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
public class BuscarCandlestickSemanalServiceImpl implements BuscarCandlestickSemanalService {

  private final CandlestickSemanalDAO semanalDAO;
  private final CandlestickMessageConverter converter;

  @Override
  public List<CandlestickSemanalDTO> buscaCandlestickSemanalPorCodNeg(
      final CandlestickSemanalDTO semanalDTO) {
    return semanalDAO.buscaCandleSemanalPorCodNeg(semanalDTO.getCandlestickDTO().getCodneg());
  }

  @Override
  public List<String> buscaCandlestickSemanalPorDtPreg(
      final LocalDate dtpregLimite) {
    return semanalDAO.buscaCandleSemanalPorDtPreg(dtpregLimite);
  }

}
