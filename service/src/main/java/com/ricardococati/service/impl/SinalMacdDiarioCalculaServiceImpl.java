package com.ricardococati.service.impl;

import static com.ricardococati.service.util.BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas;
import static com.ricardococati.service.util.BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas;
import static java.util.Objects.nonNull;

import com.ricardococati.model.entities.Macd;
import com.ricardococati.model.entities.MacdDiario;
import com.ricardococati.model.entities.SinalMacd;
import com.ricardococati.model.entities.SinalMacdDiario;
import com.ricardococati.model.enums.QuantidadePeriodo;
import com.ricardococati.repository.dao.MacdDiarioBuscarDAO;
import com.ricardococati.repository.dao.SinalMacdDiarioInserirDAO;
import com.ricardococati.service.CalculaService;
import com.ricardococati.service.SinalMacdDiarioCalculaService;
import java.math.BigDecimal;
import java.time.LocalDate;
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
public class SinalMacdDiarioCalculaServiceImpl
    implements SinalMacdDiarioCalculaService {

  private final MacdDiarioBuscarDAO macdDAO;
  private final SinalMacdDiarioInserirDAO sinalMacdDAO;
  private final CalculaService calculaService;

  @Override
  public List<SinalMacdDiario> executeByCodNeg(String codneg) {
    log.info("Código de negociação: " + codneg);
    List<MacdDiario> macdList =
        calculaService.listMacdDiarioByCodNeg(codneg);
    List<SinalMacdDiario> sinalMacdList =
        calculaMediaMovelExponencialMacd9Periodos(macdList);
    incluirSinalMacd(sinalMacdList);
    return sinalMacdList;
  }

  private void incluirSinalMacd(List<SinalMacdDiario> sinalMacdList) {
    sinalMacdList
        .parallelStream()
        .filter(Objects::nonNull)
        .filter(sinalMacdDiario -> nonNull(sinalMacdDiario.getDtpreg()))
        .filter(sinalMacdDiario -> nonNull(sinalMacdDiario.getSinalMacd()))
        .filter(sinalMacdDiario -> nonNull(sinalMacdDiario.getSinalMacd().getCodneg()))
        .forEach(sinalMacdDAO::incluirSinalMacd);
  }

  private List<SinalMacdDiario> calculaMediaMovelExponencialMacd9Periodos(
      List<MacdDiario> macdList) {
    List<SinalMacdDiario> mediaMovelExponencialList =
        calculaMediaMovelExponencialParaMacd(QuantidadePeriodo.FAST_9.getQuantidade(), macdList);
    return mediaMovelExponencialList;
  }

  private List<SinalMacdDiario> calculaMediaMovelExponencialParaMacd(
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
    final BigDecimal valorSomado = getValueBigDecimalHalfUpArredondado4Casas(macdDAO
        .buscaMacdMediaSimplesPorCodNegDtPregLimite9Periodos(
            macdList.get(indice).getMacd().getCodneg(),
            macdList.get(indice).getDtpreg())
        .stream()
        .filter(Objects::nonNull)
        .map(MacdDiario::getMacd)
        .map(Macd::getPremacd)
        .reduce(BigDecimal::add)
        .orElse(BigDecimal.ZERO));
    return buildMacdPremed(
        macdList.get(indice),
        getDoubleValueBigDecimalHalfUpArredondado4Casas(
            valorSomado.doubleValue() /
                periodo
        )
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
    return getDoubleValueBigDecimalHalfUpArredondado4Casas(
        precoHojeMultplFatorK +
            mmeOntemMultplFatorKMenos1
    );
  }

  private SinalMacdDiario buildSinalMacdByMMS(final MacdDiario macd) {
    return SinalMacdDiario.builder()
        .dtpreg(macd.getDtpreg())
        .sinalMacd(
            SinalMacd
                .builder()
                .codneg(macd.getMacd().getCodneg())
                .presinal(
                    getValueBigDecimalHalfUpArredondado4Casas(macd.getMacd().getPremacd()))
                .build()
        ).build();
  }

  private MacdDiario buildMacdPremed(final MacdDiario macd, final BigDecimal premed) {
    return MacdDiario.builder()
        .dtpreg(macd.getDtpreg())
        .macd(
            Macd
                .builder()
                .codneg(macd.getMacd().getCodneg())
                .premacd(getValueBigDecimalHalfUpArredondado4Casas(premed))
                .build())
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
