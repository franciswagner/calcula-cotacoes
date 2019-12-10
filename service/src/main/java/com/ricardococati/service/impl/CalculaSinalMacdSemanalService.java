package com.ricardococati.service.impl;

import com.ricardococati.model.dto.Macd;
import com.ricardococati.model.dto.MacdSemanal;
import com.ricardococati.model.dto.SinalMacd;
import com.ricardococati.model.dto.SinalMacdSemanal;
import com.ricardococati.model.enums.QuantidadePeriodo;
import com.ricardococati.repository.dao.IMacdSemanalDAO;
import com.ricardococati.repository.dao.IMediaMovelExponencialSemanalDAO;
import com.ricardococati.repository.dao.ISinalMacdSemanalDAO;
import com.ricardococati.service.ICalculaService;
import com.ricardococati.service.ICalculaSinalMacdSemanalService;
import com.ricardococati.service.ICandlestickSemanalService;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Data
@Service
@RequiredArgsConstructor
public class CalculaSinalMacdSemanalService
    implements ICalculaSinalMacdSemanalService {

  private final ICandlestickSemanalService calculaCandlestickService;
  private final IMacdSemanalDAO macdDAO;
  private final ISinalMacdSemanalDAO sinalMacdDAO;
  private final IMediaMovelExponencialSemanalDAO mediaMovelExponencialDAO;
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
    List<MacdSemanal> macdList =
        calculaService.listMacdSemanalByCodNeg(codneg);
    List<SinalMacdSemanal> sinalMacdList =
        calculaMediaMovelExponencialMacd9Periodos(macdList);
    sinalMacdDAO.incluirSinalMacd(sinalMacdList);
    calculaCandlestickService.atualizaCandleSemanalSinalMacdGeradaByCodneg(codneg);
    return Boolean.TRUE;
  }

  private List<SinalMacdSemanal> calculaMediaMovelExponencialMacd9Periodos(
      List<MacdSemanal> macdList) {
    List<SinalMacdSemanal> mediaMovelExponencialList =
        calculaMediaMovelExponencial(QuantidadePeriodo.FAST_9.getQuantidade(), macdList);
    return mediaMovelExponencialList;
  }

  private List<SinalMacdSemanal> calculaMediaMovelExponencial(
      int periodo, List<MacdSemanal> macdList) {
    List<SinalMacdSemanal> listReturn = new ArrayList<>();
    final Integer qtdPeriodos = macdList.size();
    Integer posicao = 0;
    for (Integer indice = periodo - 1; indice < qtdPeriodos; indice++) {
      if (posicao == 0) {
        listReturn.add(
            buildSinalMacdByMMS(getPrimeiraMedia(macdList, indice, periodo)));
        posicao++;
        continue;
      }
      listReturn.add(buildSinalMacd(
          macdList.get(indice).getMacd().getCodneg(),
          macdList.get(indice).getDtpregini(),
          macdList.get(indice).getDtpregfim(),
          periodo,
          calculaMME(periodo, macdList.get(indice).getMacd().getPremacd(),
              listReturn.get(posicao - 1).getSinalMacd().getPresinal()))
      );
      posicao++;
    }
    return listReturn;
  }

  private MacdSemanal getPrimeiraMedia(
      final List<MacdSemanal> macdList,
      final Integer indice,
      final Integer periodo
  ) {
    final BigDecimal valorSomado = macdDAO
        .buscaMacdMediaSimplesPorCodNegDtPregLimite9Periodos(
            macdList.get(indice).getMacd().getCodneg(),
            macdList.get(indice).getDtpregini())
        .stream()
        .filter(Objects::nonNull)
        .map(MacdSemanal::getMacd)
        .map(Macd::getPremacd)
        .reduce(BigDecimal::add)
        .orElse(BigDecimal.ZERO);
    return buildMacdPremed(
        macdList.get(indice),
        new BigDecimal(valorSomado.doubleValue() / periodo)
    );
  }

  private BigDecimal calculaMME(
      final Integer periodo,
      final BigDecimal precoHoje,
      final BigDecimal precoMMEOntem) {
    Double coeficienteK = 2d / (periodo + 1);
    Integer menos1 = 1;
    Double precoHojeMultplFatorK = precoHoje.doubleValue() * coeficienteK;
    Double mmeOntemMultplFatorKMenos1 = precoMMEOntem.doubleValue() * (menos1 - coeficienteK);
    return new BigDecimal(precoHojeMultplFatorK + mmeOntemMultplFatorKMenos1);
  }

  private SinalMacdSemanal buildSinalMacdByMMS(final MacdSemanal macd) {
    return SinalMacdSemanal.builder()
        .dtpregini(macd.getDtpregini())
        .dtpregfim(macd.getDtpregfim())
        .sinalMacd(SinalMacd.builder().codneg(macd.getMacd().getCodneg())
        .presinal(macd.getMacd().getPremacd()).build())
        .build();
  }

  private MacdSemanal buildMacdPremed(final MacdSemanal macd, final BigDecimal premed) {
    return MacdSemanal.builder()
        .dtpregini(macd.getDtpregini())
        .dtpregfim(macd.getDtpregfim())
        .macd(Macd.builder().codneg(macd.getMacd().getCodneg())
        .premacd(premed).build())
        .build();
  }

  private SinalMacdSemanal buildSinalMacd(
      final String codneg,
      final LocalDate dtpregini,
      final LocalDate dtpregfim,
      final Integer periodo,
      final BigDecimal premed) {
    return SinalMacdSemanal.builder()
        .dtpregini(dtpregini)
        .dtpregfim(dtpregfim)
        .sinalMacd(SinalMacd.builder().codneg(codneg)
        .periodo(periodo)
        .presinal(premed).build())
        .build();
  }

}
