package com.ricardococati.service.impl;

import com.ricardococati.model.dto.Histograma;
import com.ricardococati.model.dto.HistogramaSemanal;
import com.ricardococati.model.dto.MacdSemanal;
import com.ricardococati.model.dto.SinalMacdSemanal;
import com.ricardococati.repository.dao.IHistogramaSemanalDAO;
import com.ricardococati.repository.dao.IMacdSemanalDAO;
import com.ricardococati.repository.dao.IMediaMovelExponencialSemanalDAO;
import com.ricardococati.repository.dao.ISinalMacdSemanalDAO;
import com.ricardococati.service.ICalculaHistogramaSemanalService;
import com.ricardococati.service.ICalculaService;
import com.ricardococati.service.ICandlestickSemanalService;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Data
@Service
@RequiredArgsConstructor
public class CalculaHistogramaSemanalService
    implements ICalculaHistogramaSemanalService {

  private final ICandlestickSemanalService calculaCandlestickService;
  private final IMacdSemanalDAO macdDAO;
  private final ISinalMacdSemanalDAO sinalMacdDAO;
  private final IHistogramaSemanalDAO histogramaDAO;
  private final IMediaMovelExponencialSemanalDAO mediaMovelExponencialDAO;
  private final ICalculaService calculaService;

  @Override
  public Boolean execute() {
    AtomicBoolean returned = new AtomicBoolean(true);
    if (returned.get()) {
      calculaService
          .listCodNegSemanal()
          .forEach(
              codneg -> {
                returned.set(executeByCodNeg(codneg));
              });
    }
    return returned.get();
  }

  @Override
  public Boolean executeByCodNeg(String codneg) {
    log.info("Código de negociação: " + codneg);
    List<MacdSemanal> macdList =
        macdDAO.listMacdByCodNeg(codneg);
    List<SinalMacdSemanal> sinalMacdList =
        sinalMacdDAO.listSinalMacdByCodNeg(codneg);
    List<HistogramaSemanal> histogramaList = calculaHistograma(macdList, sinalMacdList);
    histogramaDAO.incluirHistograma(histogramaList);
    calculaCandlestickService.atualizaCandleSemanalSinalMacdGeradaByCodneg(codneg);
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
