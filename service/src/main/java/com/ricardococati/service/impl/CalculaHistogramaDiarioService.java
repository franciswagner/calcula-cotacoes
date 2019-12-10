package com.ricardococati.service.impl;

import com.ricardococati.model.dto.Histograma;
import com.ricardococati.model.dto.HistogramaDiario;
import com.ricardococati.model.dto.MacdDiario;
import com.ricardococati.model.dto.SinalMacdDiario;
import com.ricardococati.repository.dao.IHistogramaDiarioDAO;
import com.ricardococati.repository.dao.IMacdDiarioDAO;
import com.ricardococati.repository.dao.IMediaMovelExponencialDiarioDAO;
import com.ricardococati.repository.dao.ISinalMacdDiarioDAO;
import com.ricardococati.service.ICalculaHistogramaDiarioService;
import com.ricardococati.service.ICalculaService;
import com.ricardococati.service.ICandlestickDiarioService;
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
public class CalculaHistogramaDiarioService
    implements ICalculaHistogramaDiarioService {

  private final ICandlestickDiarioService calculaCandlestickService;
  private final IMacdDiarioDAO macdDAO;
  private final ISinalMacdDiarioDAO sinalMacdDAO;
  private final IHistogramaDiarioDAO histogramaDAO;
  private final IMediaMovelExponencialDiarioDAO mediaMovelExponencialDAO;
  private final ICalculaService calculaService;

  @Override
  public Boolean execute() {
    AtomicBoolean returned = new AtomicBoolean(true);
    if (returned.get()) {
      calculaService
          .listCodNegDiario()
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
    List<MacdDiario> macdList =
        macdDAO.listMacdByCodNeg(codneg);
    List<SinalMacdDiario> sinalMacdList =
        sinalMacdDAO.listSinalMacdByCodNeg(codneg);
    List<HistogramaDiario> histogramaList = calculaHistograma(macdList, sinalMacdList);
    histogramaDAO.incluirHistograma(histogramaList);
    calculaCandlestickService.atualizaCandleDiarioSinalMacdGeradaByCodneg(codneg);
    return Boolean.TRUE;
  }

  private List<HistogramaDiario> calculaHistograma(
      List<MacdDiario> macdList, List<SinalMacdDiario> sinalMacdList) {
    List<HistogramaDiario> histogramaList = new ArrayList<>();
    for(MacdDiario macd : macdList){
      for (SinalMacdDiario sinal : sinalMacdList){
        if (sinal.getDtpreg().isEqual(macd.getDtpreg())
            && sinal.getSinalMacd().getCodneg().equals(macd.getMacd().getCodneg())){
          HistogramaDiario hist = buildHistograma(macd, sinal);
          if (!histogramaList.contains(hist)){
            histogramaList.add(hist);
          }
        }
      }
    }
    return histogramaList;
  }

  private HistogramaDiario buildHistograma(final MacdDiario macd, final SinalMacdDiario sinal) {
    return HistogramaDiario.builder()
        .dtpreg(macd.getDtpreg())
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
