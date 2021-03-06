package com.ricardococati.calculacotacoes.usecases.sinalmacd.impl;

import static com.ricardococati.calculacotacoes.entities.enums.QuantidadePeriodo.FAST_9;
import static com.ricardococati.calculacotacoes.utils.geral.BigDecimalCustomizado.sendBigDecimalGetValueBigDecimalArredonda4Casas;
import static com.ricardococati.calculacotacoes.utils.geral.BigDecimalCustomizado.sendDoubleGetValueBigDecimalArredonda4Casas;
import static java.util.Objects.nonNull;

import com.ricardococati.calculacotacoes.adapters.repositories.macd.MacdSemanalBuscarDAO;
import com.ricardococati.calculacotacoes.adapters.repositories.mediaexponencial.MediaMovelExponencialSemanalBuscarDAO;
import com.ricardococati.calculacotacoes.adapters.repositories.sinalmacd.SinalMacdSemanalInserirDAO;
import com.ricardococati.calculacotacoes.entities.domains.macd.Macd;
import com.ricardococati.calculacotacoes.entities.domains.macd.MacdSemanal;
import com.ricardococati.calculacotacoes.entities.domains.sinalmacd.SinalMacd;
import com.ricardococati.calculacotacoes.entities.domains.sinalmacd.SinalMacdSemanal;
import com.ricardococati.calculacotacoes.usecases.calculageral.CalculaService;
import com.ricardococati.calculacotacoes.usecases.candlestick.CandlestickSemanalBuscarService;
import com.ricardococati.calculacotacoes.usecases.sinalmacd.SinalMacdSemanalCalculaService;
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
    log.info("C??digo de negocia????o: " + codneg);
    List<MacdSemanal> macdList =
        calculaService.listMacdSemanalByCodNeg(codneg);
    List<SinalMacdSemanal> sinalMacdList =
        calculaMediaMovelExponencialMacd9Periodos(macdList);
    incluirSinalMacdSemanal(sinalMacdList);
    return sinalMacdList;
  }

  private void incluirSinalMacdSemanal(List<SinalMacdSemanal> sinalMacdList) {
    sinalMacdList
        .parallelStream()
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
        calculaMediaMovelExponencial(FAST_9.getQuantidade(), macdList);
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
    final BigDecimal valorSomado = sendBigDecimalGetValueBigDecimalArredonda4Casas(macdDAO
        .buscaMacdMediaSimplesPorCodNegDtPregLimite9Periodos(
            macdList.get(indice).getMacd().getCodneg(),
            macdList.get(indice).getDtpregini())
        .stream()
        .filter(Objects::nonNull)
        .map(MacdSemanal::getMacd)
        .map(Macd::getPremacd)
        .reduce(BigDecimal::add)
        .orElse(BigDecimal.ZERO));
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
    return sendDoubleGetValueBigDecimalArredonda4Casas(
        precoHojeMultplFatorK + mmeOntemMultplFatorKMenos1
    );
  }

  private SinalMacdSemanal buildSinalMacdByMMS(final MacdSemanal macd) {
    return SinalMacdSemanal.builder()
        .dtpregini(macd.getDtpregini())
        .dtpregfim(macd.getDtpregfim())
        .sinalMacd(
            SinalMacd
                .builder()
                .codneg(macd.getMacd().getCodneg())
                .presinal(
                    sendBigDecimalGetValueBigDecimalArredonda4Casas(macd.getMacd().getPremacd())
                ).build())
        .build();
  }

  private MacdSemanal buildMacdPremed(final MacdSemanal macd, final BigDecimal premed) {
    return MacdSemanal.builder()
        .dtpregini(macd.getDtpregini())
        .dtpregfim(macd.getDtpregfim())
        .macd(
            Macd
                .builder()
                .codneg(macd.getMacd().getCodneg())
                .premacd(sendBigDecimalGetValueBigDecimalArredonda4Casas(premed))
                .build()
        ).build();
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
