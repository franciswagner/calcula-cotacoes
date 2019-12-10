package com.ricardococati.service.impl;

import com.ricardococati.model.dto.Macd;
import com.ricardococati.model.dto.MacdDiario;
import com.ricardococati.model.dto.SinalMacd;
import com.ricardococati.model.dto.SinalMacdDiario;
import com.ricardococati.model.enums.QuantidadePeriodo;
import com.ricardococati.repository.dao.IMacdDiarioDAO;
import com.ricardococati.repository.dao.IMediaMovelExponencialDiarioDAO;
import com.ricardococati.repository.dao.ISinalMacdDiarioDAO;
import com.ricardococati.service.ICalculaService;
import com.ricardococati.service.ICalculaSinalMacdDiarioService;
import com.ricardococati.service.ICandlestickDiarioService;
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
public class CalculaSinalMacdDiarioService
    implements ICalculaSinalMacdDiarioService {

  private final ICandlestickDiarioService calculaCandlestickService;
  private final IMacdDiarioDAO macdDAO;
  private final ISinalMacdDiarioDAO sinalMacdDAO;
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
        calculaService.listMacdDiarioByCodNeg(codneg);
    List<SinalMacdDiario> sinalMacdList =
        calculaMediaMovelExponencialMacd9Periodos(macdList);
    sinalMacdDAO.incluirSinalMacd(sinalMacdList);
    calculaCandlestickService.atualizaCandleDiarioSinalMacdGeradaByCodneg(codneg);
    return Boolean.TRUE;
  }

  private List<SinalMacdDiario> calculaMediaMovelExponencialMacd9Periodos(
      List<MacdDiario> macdList) {
    List<SinalMacdDiario> mediaMovelExponencialList =
        calculaMediaMovelExponencial(QuantidadePeriodo.FAST_9.getQuantidade(), macdList);
    return mediaMovelExponencialList;
  }

  private List<SinalMacdDiario> calculaMediaMovelExponencial(
      int periodo, List<MacdDiario> macdList) {
    List<SinalMacdDiario> listReturn = new ArrayList<>();
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
          macdList.get(indice).getDtpreg(),
          periodo,
          calculaMME(periodo, macdList.get(indice).getMacd().getPremacd(),
              listReturn.get(posicao - 1).getSinalMacd().getPresinal()))
      );
      posicao++;
    }
    return listReturn;
  }

  private MacdDiario getPrimeiraMedia(
      final List<MacdDiario> macdList,
      final Integer indice,
      final Integer periodo
  ) {
    final BigDecimal valorSomado = macdDAO
        .buscaMacdMediaSimplesPorCodNegDtPregLimite9Periodos(
            macdList.get(indice).getMacd().getCodneg(),
            macdList.get(indice).getDtpreg())
        .stream()
        .filter(Objects::nonNull)
        .map(MacdDiario::getMacd)
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

  private SinalMacdDiario buildSinalMacdByMMS(final MacdDiario macd) {
    return SinalMacdDiario.builder()
        .dtpreg(macd.getDtpreg())
        .sinalMacd(SinalMacd.builder().codneg(macd.getMacd().getCodneg())
        .presinal(macd.getMacd().getPremacd()).build())
        .build();
  }

  private MacdDiario buildMacdPremed(final MacdDiario macd, final BigDecimal premed) {
    return MacdDiario.builder()
        .dtpreg(macd.getDtpreg())
        .macd(Macd.builder().codneg(macd.getMacd().getCodneg())
        .premacd(premed).build())
        .build();
  }

  private SinalMacdDiario buildSinalMacd(
      final String codneg,
      final LocalDate dtpreg,
      final Integer periodo,
      final BigDecimal premed) {
    return SinalMacdDiario.builder()
        .dtpreg(dtpreg)
        .sinalMacd(SinalMacd.builder().codneg(codneg)
        .periodo(periodo)
        .presinal(premed).build())
        .build();
  }

}
