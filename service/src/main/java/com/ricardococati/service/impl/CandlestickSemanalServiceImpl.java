package com.ricardococati.service.impl;

import com.ricardococati.model.dto.CandlestickSemanalDTO;
import com.ricardococati.model.dto.CandlestickSemanalMessage;
import com.ricardococati.repository.dao.CandlestickSemanalDAO;
import com.ricardococati.service.CandlestickSemanalService;
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
public class CandlestickSemanalServiceImpl implements CandlestickSemanalService {

  private final CandlestickSemanalDAO semanalDAO;
  private final CandlestickMessageConverter converter;

  @Override
  public List<CandlestickSemanalDTO> listaCandlestickSemanal(
      final CandlestickSemanalDTO semanalDTO) {
    return semanalDAO.findCandleSemanalPorCodNeg(semanalDTO.getCandlestickDTO().getCodneg());
  }

  @Override
  public List<String> listCodNegByDtPreg(final LocalDate dtpregLimite) {
    return semanalDAO.getListCodNegByDtPreg(dtpregLimite);
  }

}
