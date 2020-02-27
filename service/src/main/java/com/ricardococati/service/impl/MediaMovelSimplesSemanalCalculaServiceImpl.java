package com.ricardococati.service.impl;

import static com.ricardococati.service.util.BigDecimalCustomizado.getDoubleValueBigDecimalHalfUpArredondado4Casas;
import static java.util.Objects.nonNull;

import com.ricardococati.model.dto.CandlestickDTO;
import com.ricardococati.model.dto.CandlestickSemanalDTO;
import com.ricardococati.model.dto.MediaMovelSimplesSemanal;
import com.ricardococati.model.enums.QuantidadePeriodo;
import com.ricardococati.repository.dao.MediaMovelSimplesSemanalInserirDAO;
import com.ricardococati.service.CandlestickSemanalBuscarService;
import com.ricardococati.service.MediaMovelSimplesSemanalCalculaService;
import com.ricardococati.service.converter.MediaMovelSimplesConverter;
import com.ricardococati.service.util.BigDecimalCustomizado;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Data
@Service
@RequiredArgsConstructor
public class MediaMovelSimplesSemanalCalculaServiceImpl
    implements MediaMovelSimplesSemanalCalculaService {

  private static final int PRIMEIRA_POSICAO = 0;
  private static final Boolean MEDIA_MOVEL_SIMPLES_NAO_GERADA = false;
  private final CandlestickSemanalBuscarService semanalService;
  private final MediaMovelSimplesConverter converteMediaMovelSimples;
  private final MediaMovelSimplesSemanalInserirDAO mmsInserirDAO;

  @Override
  public List<MediaMovelSimplesSemanal> executeByCodNeg(final String codigoNegocio) {
    log.info("Código de negociação: " + codigoNegocio);
    List<CandlestickSemanalDTO> candlestickList =
        semanalService.buscaCandlestickSemanalPorCodNeg(buildCandlestickSemanalDTO(codigoNegocio));
    List<MediaMovelSimplesSemanal> mediaMovelSimplesList =
        calculaMediaMovelSimplesPorPeriodo(candlestickList, codigoNegocio);
    inserirMMS(mediaMovelSimplesList);
    return mediaMovelSimplesList;
  }

  private void inserirMMS(List<MediaMovelSimplesSemanal> mediaMovelSimplesList) {
    mediaMovelSimplesList
        .parallelStream()
        .filter(Objects::nonNull)
        .filter(mmsSemanal -> nonNull(mmsSemanal.getDtpregini()))
        .filter(mmsSemanal -> nonNull(mmsSemanal.getDtpregfim()))
        .filter(mmsSemanal -> nonNull(mmsSemanal.getMediaMovelSimples()))
        .filter(mmsSemanal -> nonNull(mmsSemanal.getMediaMovelSimples().getCodneg()))
        .forEach(mmsInserirDAO::incluirMediaMovelSimples);
  }

  private List<MediaMovelSimplesSemanal> calculaMediaMovelSimplesPorPeriodo(
      List<CandlestickSemanalDTO> candlestickSemanals, String codneg) {
    List<MediaMovelSimplesSemanal> mediaMovelSimplesList = new ArrayList<>();
    QuantidadePeriodo.getListQuantidadePeriodo()
        .parallelStream()
        .filter(periodo -> nonNull(candlestickSemanals))
        .filter(periodo -> candlestickSemanals.size() >= periodo.intValue())
        .map(periodo -> calculaMediaMovelSimples(periodo, candlestickSemanals, codneg))
        .forEachOrdered(mediaMovelSimplesList::addAll);
    return mediaMovelSimplesList;
  }

  private List<MediaMovelSimplesSemanal> calculaMediaMovelSimples(
      int periodo, List<CandlestickSemanalDTO> candlestickSemanal, String codneg) {
    return IntStream.range(periodo - 1, candlestickSemanal.size())
        .mapToObj(indice -> calcula(periodo, indice, candlestickSemanal, codneg))
        .collect(Collectors.toList());
  }

  private MediaMovelSimplesSemanal calcula(
      int periodo, int posicao, List<CandlestickSemanalDTO> candlestickSemanalList, String codneg) {
    double soma = 0.0;
    MediaMovelSimplesSemanal mediaMovelSimples =
        converteMediaMovelSimples
            .converterCandlestickSemanalToMediaMovelSimples(buildCandlestickSemanalDTO(codneg));
    mediaMovelSimples.getMediaMovelSimples().setPeriodo(periodo);
    for (int indice = posicao - (periodo - 1); indice <= posicao; indice++) {
      CandlestickSemanalDTO candlestickSemanal = candlestickSemanalList.get(indice);
      soma += candlestickSemanal.getCandlestickDTO().getPreult().doubleValue();
      if (indice == posicao) {
        mediaMovelSimples.setDtpregini(candlestickSemanal.getDtpregini());
        mediaMovelSimples.setDtpregfim(candlestickSemanal.getDtpregfim());
        mediaMovelSimples.getMediaMovelSimples().setPremedult(
            getDoubleValueBigDecimalHalfUpArredondado4Casas(soma / periodo)
        );
      }
    }
    return mediaMovelSimples;
  }

  private CandlestickSemanalDTO buildCandlestickSemanalDTO(final String codneg) {
    return CandlestickSemanalDTO.builder()
        .candlestickDTO(CandlestickDTO.builder().codneg(codneg).build())
        .build();
  }
}
