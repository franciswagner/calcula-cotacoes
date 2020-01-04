package com.ricardococati.service.impl;

import com.ricardococati.model.dto.Histograma;
import com.ricardococati.model.dto.HistogramaSemanal;
import com.ricardococati.model.dto.MacdSemanal;
import com.ricardococati.model.dto.SinalMacdSemanal;
import com.ricardococati.repository.dao.HistogramaSemanalDAO;
import com.ricardococati.repository.dao.MacdSemanalDAO;
import com.ricardococati.repository.dao.MediaMovelExponencialSemanalDAO;
import com.ricardococati.repository.dao.SinalMacdSemanalDAO;
import com.ricardococati.service.CalculaHistogramaSemanalService;
import com.ricardococati.service.CalculaService;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Data
@Service
@RequiredArgsConstructor
public class CalculaHistogramaSemanalServiceImpl
    implements CalculaHistogramaSemanalService {

  private final MacdSemanalDAO macdDAO;
  private final SinalMacdSemanalDAO sinalMacdDAO;
  private final HistogramaSemanalDAO histogramaDAO;
  private final MediaMovelExponencialSemanalDAO mediaMovelExponencialDAO;
  private final CalculaService calculaService;

  @Override
  public Boolean executeByCodNeg(String codneg) {
    log.info("Código de negociação: " + codneg);
    List<MacdSemanal> macdList =
        macdDAO.listMacdByCodNeg(codneg);
    List<SinalMacdSemanal> sinalMacdList =
        sinalMacdDAO.listSinalMacdByCodNeg(codneg);
    List<HistogramaSemanal> histogramaList = calculaHistograma(macdList, sinalMacdList);
    histogramaDAO.incluirHistograma(histogramaList);
    return Boolean.TRUE;
  }

  private List<HistogramaSemanal> calculaHistograma(
      List<MacdSemanal> macdList, List<SinalMacdSemanal> sinalMacdList) {
    List<HistogramaSemanal> histogramaList = new ArrayList<>();
    for(MacdSemanal macd : macdList){
      for (SinalMacdSemanal sinal : sinalMacdList){
        if (sinal.getDtpregini().isEqual(macd.getDtpregini())
            && sinal.getDtpregfim().isEqual(macd.getDtpregfim())
            && sinal.getSinalMacd().getCodneg().equals(macd.getMacd().getCodneg())){
          HistogramaSemanal hist = buildHistograma(macd, sinal);
          if (!histogramaList.contains(hist)){
            histogramaList.add(hist);
          }
        }
      }
    }
    return histogramaList;
  }

  private HistogramaSemanal buildHistograma(final MacdSemanal macd, final SinalMacdSemanal sinal) {
    return HistogramaSemanal.builder()
        .dtpregini(macd.getDtpregini())
        .dtpregfim(macd.getDtpregfim())
        .histograma(
            Histograma
                .builder()
                .codneg(macd.getMacd().getCodneg())
                .prehist(macd.getMacd().getPremacd()
                    .subtract(sinal.getSinalMacd().getPresinal()))
                .build())
        .build();
  }

}
