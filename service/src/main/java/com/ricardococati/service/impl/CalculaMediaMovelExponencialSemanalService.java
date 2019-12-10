package com.ricardococati.service.impl;

import com.ricardococati.model.dto.CandlestickDTO;
import com.ricardococati.model.dto.CandlestickSemanalDTO;
import com.ricardococati.model.dto.MediaMovelExponencial;
import com.ricardococati.model.dto.MediaMovelExponencialSemanal;
import com.ricardococati.model.dto.MediaMovelSimplesSemanal;
import com.ricardococati.model.enums.QuantidadePeriodo;
import com.ricardococati.repository.dao.IMediaMovelExponencialSemanalDAO;
import com.ricardococati.repository.dao.IMediaMovelSimplesSemanalDAO;
import com.ricardococati.service.ICalculaMediaMovelExponencialSemanalService;
import com.ricardococati.service.ICalculaService;
import com.ricardococati.service.ICandlestickSemanalService;
import com.ricardococati.service.converter.ConverteMediaMovelSimples;
import java.math.BigDecimal;
import java.time.LocalDate;
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
public class CalculaMediaMovelExponencialSemanalService
    implements ICalculaMediaMovelExponencialSemanalService {

  private static final int PRIMEIRA_POSICAO = 0;
  private static final Boolean MEDIA_MOVEL_SIMPLES_GERADA = true;
  private static final Boolean MEDIA_EXPONENCIAL_NAO_GERADA = false;
  private final ICandlestickSemanalService calculaCandlestickService;
  private final ConverteMediaMovelSimples converteMediaMovelSimples;
  private final IMediaMovelSimplesSemanalDAO mediaMovelSimplesDAO;
  private final IMediaMovelExponencialSemanalDAO mediaMovelExponencialDAO;
  private final ICalculaService calculaService;

  @Override
  public Boolean execute() {
    AtomicBoolean returned = new AtomicBoolean(true);
    if (returned.get()) {
      calculaService
          .listCodNegSemanal()
          .forEach(
              codigoNegocio -> {
                returned.set(executeByCodNeg(codigoNegocio));
                calculaCandlestickService
                    .atualizaCandleSemanalMediaExponencialGeradaByCodneg(codigoNegocio);
              });
    }
    return returned.get();
  }

  @Override
  public Boolean executeByCodNeg(String codneg) {
    log.info("Código de negociação: " + codneg);
    List<CandlestickSemanalDTO> candlestickList =
        calculaCandlestickService.listaCandlestickSemanal(
            buildCandlestickSemanalDTO(codneg));
    List<MediaMovelExponencialSemanal> listMME =
        calculaMediaMovelExponencialPorPeriodo(candlestickList);
    mediaMovelExponencialDAO.incluirMediaMovelExponencial(listMME);
    return Boolean.TRUE;
  }

  private List<MediaMovelExponencialSemanal> calculaMediaMovelExponencialPorPeriodo(
      List<CandlestickSemanalDTO> candlestickList) {
    List<MediaMovelExponencialSemanal> mediaMovelExponencialList = new ArrayList<>();
    QuantidadePeriodo
        .getListQuantidadePeriodo()
        .stream()
        .forEach(periodo ->
            mediaMovelExponencialList
                .addAll(calculaMediaMovelExponencial(periodo, candlestickList)));
    return mediaMovelExponencialList;
  }

  public List<MediaMovelExponencialSemanal> calculaMediaMovelExponencial(
      int periodo, List<CandlestickSemanalDTO> candlestickList) {
    List<MediaMovelExponencialSemanal> listReturn = new ArrayList<>();
    int qtdPeriodos = candlestickList.size();
    Integer posicao = 0;
    for (int indice = periodo - 1; indice < qtdPeriodos; indice++) {
      if (posicao == 0) {
        listReturn.add(
            buildMediaMovelExponencialByMMS(getPrimeiraMedia(periodo, candlestickList, indice)));
        posicao++;
        continue;
      }
      listReturn.add(buildMediaMovelExponencial(
          candlestickList.get(indice).getCandlestickDTO().getCodneg(),
          candlestickList.get(indice).getDtpregini(),
          candlestickList.get(indice).getDtpregfim(),
          periodo,
          calculaMME(periodo, candlestickList.get(indice).getCandlestickDTO().getPreult(),
              listReturn.get(posicao - 1).getMediaMovelExponencial().getPremedult()))
      );
      posicao++;
    }
    return listReturn;
  }

  private MediaMovelSimplesSemanal getPrimeiraMedia(
      final int periodo,
      final List<CandlestickSemanalDTO> candlestickList,
      final int indice) {
    return mediaMovelSimplesDAO
        .buscaMediaSimplesPorCodNegPeriodoDtPreg(
            candlestickList.get(indice).getCandlestickDTO().getCodneg(),
            periodo,
            candlestickList.get(indice).getDtpregini(),
            candlestickList.get(indice).getDtpregfim());
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

  private CandlestickSemanalDTO buildCandlestickSemanalDTO(final String codneg) {
    return CandlestickSemanalDTO
        .builder()
        .candlestickDTO(
            CandlestickDTO
                .builder()
                .codneg(codneg)
                .build())
        .build();
  }

  private MediaMovelExponencialSemanal buildMediaMovelExponencialByMMS(
      final MediaMovelSimplesSemanal mmSimples) {
    return MediaMovelExponencialSemanal.builder()
        .dtpregini(mmSimples.getDtpregini())
        .dtpregfim(mmSimples.getDtpregfim())
        .mediaMovelExponencial(
            MediaMovelExponencial
                .builder()
                .codneg(mmSimples.getMediaMovelSimples().getCodneg())
                .periodo(mmSimples.getMediaMovelSimples().getPeriodo())
                .premedult(mmSimples.getMediaMovelSimples().getPremedult())
                .build())
        .build();
  }

  private MediaMovelExponencialSemanal buildMediaMovelExponencial(
      final String codneg,
      final LocalDate dtpregini,
      final LocalDate dtpregfim,
      final Integer periodo,
      final BigDecimal premed) {
    return MediaMovelExponencialSemanal.builder()
        .dtpregini(dtpregini)
        .dtpregfim(dtpregfim)
        .mediaMovelExponencial(
            MediaMovelExponencial
                .builder()
                .codneg(codneg)
                .periodo(periodo)
                .premedult(premed)
                .build())
        .build();
  }

}
