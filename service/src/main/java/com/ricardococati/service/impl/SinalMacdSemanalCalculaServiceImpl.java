package com.ricardococati.service.impl;

import static java.util.Objects.nonNull;

import com.ricardococati.model.dto.Macd;
import com.ricardococati.model.dto.MacdSemanal;
import com.ricardococati.model.dto.SinalMacd;
import com.ricardococati.model.dto.SinalMacdSemanal;
import com.ricardococati.model.enums.QuantidadePeriodo;
import com.ricardococati.repository.dao.MacdSemanalBuscarDAO;
import com.ricardococati.repository.dao.MediaMovelExponencialSemanalBuscarDAO;
import com.ricardococati.repository.dao.SinalMacdSemanalInserirDAO;
import com.ricardococati.service.CalculaService;
import com.ricardococati.service.CandlestickSemanalBuscarService;
import com.ricardococati.service.SinalMacdSemanalCalculaService;
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
public class SinalMacdSemanalCalculaServiceImpl
    implements SinalMacdSemanalCalculaService {

  private final CandlestickSemanalBuscarService calculaCandlestickService;
  private final MacdSemanalBuscarDAO macdDAO;
  private final SinalMacdSemanalInserirDAO sinalMacdDAO;
  private final MediaMovelExponencialSemanalBuscarDAO mediaMovelExponencialDAO;
  private final CalculaService calculaService;

  @Override
  public List<SinalMacdSemanal> executeByCodNeg(String codneg) {
    log.info("Código de negociação: " + codneg);
    List<MacdSemanal> macdList =
        calculaService.listMacdSemanalByCodNeg(codneg);
    List<SinalMacdSemanal> sinalMacdList =
        calculaMediaMovelExponencialMacd9Periodos(macdList);
    incluirSinalMacdSemanal(sinalMacdList);
    return sinalMacdList;
  }

  private void incluirSinalMacdSemanal(List<SinalMacdSemanal> sinalMacdList) {
    sinalMacdList
        .stream()
        .filter(Objects::nonNull)
        .filter(sinalMacdSemanal -> nonNull(sinalMacdSemanal.getDtpregini()))
        .filter(sinalMacdSemanal -> nonNull(sinalMacdSemanal.getDtpregfim()))
        .filter(sinalMacdSemanal -> nonNull(sinalMacdSemanal.getSinalMacd()))
        .filter(sinalMacdSemanal -> nonNull(sinalMacdSemanal.getSinalMacd().getCodneg()))
        .forEach(sinalMacdDAO::incluirSinalMacd);
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
        .orElse(BigDecimal.ZERO)
        .setScale(4, BigDecimal.ROUND_HALF_UP);
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
    return new BigDecimal(precoHojeMultplFatorK + mmeOntemMultplFatorKMenos1)
        .setScale(4, BigDecimal.ROUND_HALF_UP);
  }

  private SinalMacdSemanal buildSinalMacdByMMS(final MacdSemanal macd) {
    return SinalMacdSemanal.builder()
        .dtpregini(macd.getDtpregini())
        .dtpregfim(macd.getDtpregfim())
        .sinalMacd(SinalMacd.builder().codneg(macd.getMacd().getCodneg())
            .presinal(macd.getMacd().getPremacd()
                .setScale(4, BigDecimal.ROUND_HALF_UP)).build())
        .build();
  }

  private MacdSemanal buildMacdPremed(final MacdSemanal macd, final BigDecimal premed) {
    return MacdSemanal.builder()
        .dtpregini(macd.getDtpregini())
        .dtpregfim(macd.getDtpregfim())
        .macd(Macd.builder().codneg(macd.getMacd().getCodneg())
        .premacd(premed.setScale(4, BigDecimal.ROUND_HALF_UP)).build())
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
