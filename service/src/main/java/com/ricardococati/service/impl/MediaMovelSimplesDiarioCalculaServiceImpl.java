package com.ricardococati.service.impl;

import static java.util.Objects.nonNull;

import com.ricardococati.model.dto.CandlestickDTO;
import com.ricardococati.model.dto.CandlestickDiarioDTO;
import com.ricardococati.model.dto.MediaMovelSimplesDiario;
import com.ricardococati.model.enums.QuantidadePeriodo;
import com.ricardococati.repository.dao.MediaMovelSimplesDiarioInserirDAO;
import com.ricardococati.service.MediaMovelSimplesDiarioCalculaService;
import com.ricardococati.service.CandlestickDiarioBuscarService;
import com.ricardococati.service.converter.MediaMovelSimplesConverter;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
public class MediaMovelSimplesDiarioCalculaServiceImpl
    implements MediaMovelSimplesDiarioCalculaService {

  private final CandlestickDiarioBuscarService diarioService;
  private final MediaMovelSimplesConverter converteMediaMovelSimples;
  private final MediaMovelSimplesDiarioInserirDAO mmsDAO;

  @Override
  public List<MediaMovelSimplesDiario> executeByCodNeg(final String codigoNegocio) {
    log.info("Código de negociação: " + codigoNegocio);
    List<CandlestickDiarioDTO> candlestickList =
        diarioService.buscaCandlestickDiarioPorCodNeg(buildCandlestickDiarioDTO(codigoNegocio));
    List<MediaMovelSimplesDiario> mediaMovelSimplesList =
        calculaMediaMovelSimplesPorPeriodo(candlestickList, codigoNegocio);
    inserirMMSDiario(mediaMovelSimplesList);
    return mediaMovelSimplesList;
  }

  private void inserirMMSDiario(
      final List<MediaMovelSimplesDiario> mediaMovelSimplesList
  ) {
    mediaMovelSimplesList
        .stream()
        .filter(Objects::nonNull)
        .filter(mmsDiario -> nonNull(mmsDiario.getDtpreg()))
        .filter(mmsDiario -> nonNull(mmsDiario.getMediaMovelSimples()))
        .filter(mmsDiario -> nonNull(mmsDiario.getMediaMovelSimples().getCodneg()))
        .forEach(mmsDAO::incluirMediaMovelSimples);
  }

  private List<MediaMovelSimplesDiario> calculaMediaMovelSimplesPorPeriodo(
      List<CandlestickDiarioDTO> candlestickDiarios, String codneg) {
    List<MediaMovelSimplesDiario> mediaMovelSimplesList = new ArrayList<>();
    QuantidadePeriodo
        .getListQuantidadePeriodo()
        .stream()
        .filter(periodo -> nonNull(candlestickDiarios))
        .filter(Objects::nonNull)
        .filter(periodo -> candlestickDiarios.size() >= periodo.intValue())
        .map(periodo -> calculaMediaMovelSimples(periodo, candlestickDiarios, codneg))
        .forEachOrdered(mediaMovelSimplesList::addAll);
    return mediaMovelSimplesList;
  }

  private List<MediaMovelSimplesDiario> calculaMediaMovelSimples(
      int periodo, List<CandlestickDiarioDTO> candlestickDiario, String codneg) {
    return IntStream.range(periodo - 1, candlestickDiario.size())
        .mapToObj(indice -> calcula(periodo, indice, candlestickDiario, codneg))
        .collect(Collectors.toList());
  }

  private MediaMovelSimplesDiario calcula(
      int periodo, int posicao, List<CandlestickDiarioDTO> candlestickDiarioList, String codneg) {
    double soma = 0.0;
    MediaMovelSimplesDiario mediaMovelSimples =
        converteMediaMovelSimples
            .converterCandlestickDiarioToMediaMovelSimples(buildCandlestickDiarioDTO(codneg));
    mediaMovelSimples.getMediaMovelSimples().setPeriodo(periodo);
    for (int indice = posicao - (periodo - 1); indice <= posicao; indice++) {
      CandlestickDiarioDTO candlestickDiario = candlestickDiarioList.get(indice);
      soma += candlestickDiario.getCandlestickDTO().getPreult().doubleValue();
      if (indice == posicao) {
        mediaMovelSimples.setDtpreg(candlestickDiario.getDtpreg());
        mediaMovelSimples.getMediaMovelSimples().setPremedult(
            new BigDecimal(soma / periodo).setScale(4, RoundingMode.HALF_UP)
        );
      }
    }
    return mediaMovelSimples;
  }

  private CandlestickDiarioDTO buildCandlestickDiarioDTO(final String codneg) {
    return CandlestickDiarioDTO.builder()
        .candlestickDTO(CandlestickDTO.builder().codneg(codneg).build())
        .build();
  }
}