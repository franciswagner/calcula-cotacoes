package com.ricardococati.service.impl;

import static java.util.Objects.nonNull;

import com.ricardococati.model.dto.Histograma;
import com.ricardococati.model.dto.HistogramaDiario;
import com.ricardococati.model.dto.MacdDiario;
import com.ricardococati.model.dto.SinalMacdDiario;
import com.ricardococati.repository.dao.HistogramaDiarioInserirDAO;
import com.ricardococati.repository.dao.MacdDiarioBuscarDAO;
import com.ricardococati.repository.dao.SinalMacdDiarioBuscarDAO;
import com.ricardococati.service.HistogramaDiarioCalculaService;
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
public class HistogramaDiarioCalculaServiceImpl
    implements HistogramaDiarioCalculaService {

  private final MacdDiarioBuscarDAO macdDAO;
  private final SinalMacdDiarioBuscarDAO sinalMacdDAO;
  private final HistogramaDiarioInserirDAO histogramaDAO;

  @Override
  public List<HistogramaDiario> executeByCodNeg(String codneg) {
    log.info("Código de negociação: " + codneg);
    List<MacdDiario> macdList =
        macdDAO.listMacdByCodNeg(codneg);
    List<SinalMacdDiario> sinalMacdList =
        sinalMacdDAO.listSinalMacdByCodNeg(codneg);
    List<HistogramaDiario> histogramaList = calculaHistograma(macdList, sinalMacdList);
    insereHistograma(histogramaList);
    return histogramaList;
  }

  private void insereHistograma(List<HistogramaDiario> histogramaList) {
    histogramaList
        .stream()
        .filter(Objects::nonNull)
        .filter(histogramaDiario -> nonNull(histogramaDiario.getDtpreg()))
        .filter(histogramaDiario -> nonNull(histogramaDiario.getHistograma()))
        .filter(histogramaDiario -> nonNull(histogramaDiario.getHistograma().getCodneg()))
        .forEach(histogramaDAO::incluirHistograma);
  }

  private List<HistogramaDiario> calculaHistograma(
      final List<MacdDiario> macdList,
      final List<SinalMacdDiario> sinalMacdList
  ) {
    List<HistogramaDiario> histogramaList = new ArrayList<>();
    if(nonNull(macdList) && nonNull(sinalMacdList)) {
      for (MacdDiario macd : macdList) {
        for (SinalMacdDiario sinal : sinalMacdList) {
          if (sinal.getDtpreg().isEqual(macd.getDtpreg())
              && sinal.getSinalMacd().getCodneg().equals(macd.getMacd().getCodneg())) {
            HistogramaDiario hist = buildHistograma(macd, sinal);
            if (!histogramaList.contains(hist)) {
              histogramaList.add(hist);
            }
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
