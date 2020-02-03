package com.ricardococati.service.impl;

import static java.util.Objects.isNull;

import com.ricardococati.model.dto.CandlestickDTO;
import com.ricardococati.model.dto.CandlestickSemanalDTO;
import com.ricardococati.model.dto.MediaMovelExponencial;
import com.ricardococati.model.dto.MediaMovelExponencialSemanal;
import com.ricardococati.model.dto.MediaMovelSimplesSemanal;
import com.ricardococati.model.enums.QuantidadePeriodo;
import com.ricardococati.repository.dao.MediaMovelExponencialSemanalInserirDAO;
import com.ricardococati.repository.dao.MediaMovelSimplesSemanalDAO;
import com.ricardococati.service.CalculaService;
import com.ricardococati.service.CandlestickSemanalBuscarService;
import com.ricardococati.service.MediaMovelExponencialSemanalCalculaService;
import com.ricardococati.service.converter.MediaMovelSimplesConverter;
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
public class MediaMovelExponencialSemanalCalculaServiceImpl
    implements MediaMovelExponencialSemanalCalculaService {

  private static final int PRIMEIRA_POSICAO = 0;
  private static final Boolean MEDIA_MOVEL_SIMPLES_GERADA = true;
  private static final Boolean MEDIA_EXPONENCIAL_NAO_GERADA = false;
  private final CandlestickSemanalBuscarService calculaCandlestickService;
  private final MediaMovelSimplesConverter converteMediaMovelSimples;
  private final MediaMovelSimplesSemanalDAO mediaMovelSimplesDAO;
  private final MediaMovelExponencialSemanalInserirDAO inserirMMEDAO;
  private final CalculaService calculaService;

  @Override
  public List<MediaMovelExponencialSemanal> executeByCodNeg(String codneg) {
    log.info("Código de negociação: " + codneg);
    List<CandlestickSemanalDTO> candlestickList =
        calculaCandlestickService.buscaCandlestickSemanalPorCodNeg(
            buildCandlestickSemanalDTO(codneg));
    List<MediaMovelExponencialSemanal> listMME =
        calculaMediaMovelExponencialPorPeriodo(candlestickList);
    inserirMMESemanal(listMME);
    return listMME;
  }

  private void inserirMMESemanal(List<MediaMovelExponencialSemanal> listMME) {
    listMME
        .stream()
        .filter(Objects::nonNull)
        .forEach(mmeSemanal -> {
          inserirMMEDAO.incluirMediaMovelExponencial(mmeSemanal);
        });
  }

  private List<MediaMovelExponencialSemanal> calculaMediaMovelExponencialPorPeriodo(
      List<CandlestickSemanalDTO> candlestickList) {
    List<MediaMovelExponencialSemanal> mediaMovelExponencialList = new ArrayList<>();
    try {
      QuantidadePeriodo
          .getListQuantidadePeriodo()
          .stream()
          .forEach(periodo ->
              mediaMovelExponencialList
                  .addAll(calculaMediaMovelExponencial(periodo, candlestickList)));
    } catch (Exception ex){
      log.error("Erro no cálculo de média exponencial: {} ", ex.getMessage());
      throw ex;
    }
    return mediaMovelExponencialList;
  }

  public List<MediaMovelExponencialSemanal> calculaMediaMovelExponencial(
      int periodo, List<CandlestickSemanalDTO> candlestickList) {
    List<MediaMovelExponencialSemanal> listReturn = new ArrayList<>();
    int qtdPeriodos = candlestickList.size();
    Integer posicao = 0;
    for (int indice = periodo - 1; indice < qtdPeriodos; indice++) {
      if (posicao == 0) {
        final MediaMovelSimplesSemanal primeiraMedia =
            getPrimeiraMedia(
                periodo,
                candlestickList,
                indice);
        if(isNull(primeiraMedia)){
          return listReturn;
        }
        listReturn.add(buildMediaMovelExponencialByMMS(primeiraMedia));
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
