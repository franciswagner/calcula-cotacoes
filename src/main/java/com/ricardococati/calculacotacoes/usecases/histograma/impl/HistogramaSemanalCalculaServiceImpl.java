package com.ricardococati.calculacotacoes.usecases.histograma.impl;

import static java.util.Objects.nonNull;

import com.ricardococati.calculacotacoes.adapters.repositories.histograma.HistogramaSemanalInserirDAO;
import com.ricardococati.calculacotacoes.adapters.repositories.macd.MacdSemanalBuscarDAO;
import com.ricardococati.calculacotacoes.adapters.repositories.mediaexponencial.MediaMovelExponencialSemanalBuscarDAO;
import com.ricardococati.calculacotacoes.adapters.repositories.sinalmacd.SinalMacdSemanalBuscarDAO;
import com.ricardococati.calculacotacoes.entities.domains.histograma.Histograma;
import com.ricardococati.calculacotacoes.entities.domains.histograma.HistogramaSemanal;
import com.ricardococati.calculacotacoes.entities.domains.macd.MacdSemanal;
import com.ricardococati.calculacotacoes.entities.domains.sinalmacd.SinalMacdSemanal;
import com.ricardococati.calculacotacoes.usecases.calculageral.CalculaService;
import com.ricardococati.calculacotacoes.usecases.histograma.HistogramaSemanalCalculaService;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Data
@Service
@RequiredArgsConstructor
public class HistogramaSemanalCalculaServiceImpl
    implements HistogramaSemanalCalculaService {

  private final MacdSemanalBuscarDAO macdDAO;
  private final SinalMacdSemanalBuscarDAO sinalMacdDAO;
  private final HistogramaSemanalInserirDAO histogramaDAO;
  private final MediaMovelExponencialSemanalBuscarDAO mediaMovelExponencialDAO;
  private final CalculaService calculaService;

  @Override
  public List<HistogramaSemanal> executeByCodNeg(String codneg) {
    log.info("Código de negociação: " + codneg);
    List<MacdSemanal> macdList =
        macdDAO.listMacdByCodNeg(codneg);
    List<SinalMacdSemanal> sinalMacdList =
        sinalMacdDAO.listSinalMacdByCodNeg(codneg);
    List<HistogramaSemanal> histogramaList = calculaHistograma(macdList, sinalMacdList);
    incluirHistograma(histogramaList);
    return histogramaList;
  }

  private void incluirHistograma(List<HistogramaSemanal> histogramaList) {
    histogramaList
        .parallelStream()
        .filter(Objects::nonNull)
        .filter(histogramaSemanal -> nonNull(histogramaSemanal.getDtpregini()))
        .filter(histogramaSemanal -> nonNull(histogramaSemanal.getDtpregfim()))
        .filter(histogramaSemanal -> nonNull(histogramaSemanal.getHistograma()))
        .filter(histogramaSemanal -> nonNull(histogramaSemanal.getHistograma().getCodneg()))
        .forEach(histogramaDAO::incluirHistograma);
  }

  private List<HistogramaSemanal> calculaHistograma(
      final List<MacdSemanal> macdList,
      final List<SinalMacdSemanal> sinalMacdList
  ) {
    List<HistogramaSemanal> histogramaList = new ArrayList<>();
    if(nonNull(macdList) && nonNull(sinalMacdList)) {
      macdList.forEach(macd -> {
        sinalMacdList
            .stream()
            .filter(sinal ->
                sinal.getDtpregini().isEqual(macd.getDtpregini())
                && sinal.getDtpregfim().isEqual(macd.getDtpregfim())
                && sinal.getSinalMacd().getCodneg().equals(macd.getMacd().getCodneg())
            )
            .map(sinal -> buildHistograma(macd, sinal))
            .filter(hist -> !histogramaList.contains(hist))
            .forEach(histogramaList::add);
      });
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
