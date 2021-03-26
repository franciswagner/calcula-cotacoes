package com.ricardococati.calculacotacoes.usecases.mediasimples.impl;

import static com.ricardococati.calculacotacoes.utils.geral.BigDecimalCustomizado.sendDoubleGetValueBigDecimalArredonda4Casas;
import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.toList;

import com.ricardococati.calculacotacoes.adapters.repositories.mediasimples.MediaMovelSimplesDiarioInserirDAO;
import com.ricardococati.calculacotacoes.entities.domains.candlestick.Candlestick;
import com.ricardococati.calculacotacoes.entities.domains.candlestick.CandlestickDiario;
import com.ricardococati.calculacotacoes.entities.domains.mediasimples.MediaMovelSimplesDiario;
import com.ricardococati.calculacotacoes.entities.enums.QuantidadePeriodo;
import com.ricardococati.calculacotacoes.usecases.candlestick.CandlestickDiarioBuscarService;
import com.ricardococati.calculacotacoes.usecases.mediasimples.CalculaMediaSimples;
import com.ricardococati.calculacotacoes.usecases.mediasimples.MediaMovelSimplesDiarioCalculaService;
import com.ricardococati.calculacotacoes.utils.converters.MediaMovelSimplesConverter;
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
@Service
@RequiredArgsConstructor
public class MediaMovelSimplesDiarioCalculaServiceImpl
    implements MediaMovelSimplesDiarioCalculaService {

  private final CandlestickDiarioBuscarService diarioService;
  private final MediaMovelSimplesConverter converteMediaMovelSimples;
  private final MediaMovelSimplesDiarioInserirDAO mmsDAO;
  private final CalculaMediaSimples mediaSimples;

  @Override
  public List<MediaMovelSimplesDiario> executeByCodNeg(final String codigoNegocio) {
    log.info("Código de negociação: " + codigoNegocio);
    List<CandlestickDiario> candlestickList =
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
        .parallelStream()
        .filter(Objects::nonNull)
        .filter(mmsDiario -> nonNull(mmsDiario.getDtpreg()))
        .filter(mmsDiario -> nonNull(mmsDiario.getMediaMovelSimples()))
        .filter(mmsDiario -> nonNull(mmsDiario.getMediaMovelSimples().getCodneg()))
        .forEach(mmsDAO::incluirMediaMovelSimples);
  }

  private List<MediaMovelSimplesDiario> calculaMediaMovelSimplesPorPeriodo(
      List<CandlestickDiario> candlestickDiarios, String codneg) {
    List<MediaMovelSimplesDiario> mediaMovelSimplesList = new ArrayList<>();
    QuantidadePeriodo
        .getListQuantidadePeriodo()
        .parallelStream()
        .filter(periodo -> nonNull(candlestickDiarios))
        .filter(Objects::nonNull)
        .filter(periodo -> candlestickDiarios.size() >= periodo.intValue())
        .map(periodo -> calculaMediaMovelSimples(periodo, candlestickDiarios, codneg))
        .forEachOrdered(mediaMovelSimplesList::addAll);
    return mediaMovelSimplesList;
  }

  private List<MediaMovelSimplesDiario> calculaMediaMovelSimples(
      int periodo, List<CandlestickDiario> candlestickDiario, String codneg) {
    return IntStream
        .range(periodo - 1, candlestickDiario.size())
        .mapToObj(posicao -> calcula(periodo, posicao, candlestickDiario, codneg))
        .collect(toList());
  }

  private MediaMovelSimplesDiario calcula(
      final int periodo,
      final int posicao,
      final List<CandlestickDiario> candlestickDiarioList,
      final String codneg) {
    double soma = 0.0;
    MediaMovelSimplesDiario mediaMovelSimples =
        converteMediaMovelSimples
            .converterCandlestickDiarioToMediaMovelSimples(buildCandlestickDiarioDTO(codneg));
    mediaMovelSimples.getMediaMovelSimples().setPeriodo(periodo);
    final int rangeInicio = posicao - (periodo - 1);
    mediaMovelSimples.setDtpreg(candlestickDiarioList.get(posicao).getDtpreg());
    mediaMovelSimples.getMediaMovelSimples().setPremedult(
        mediaSimples.calcula(
            rangeInicio,
            posicao,
            candlestickDiarioList
                .stream()
                .map(CandlestickDiario::getCandlestick)
                .map(Candlestick::getPreult)
                .collect(toList())));
    return mediaMovelSimples;
  }

  private CandlestickDiario buildCandlestickDiarioDTO(final String codneg) {
    return CandlestickDiario.builder()
        .candlestick(Candlestick.builder().codneg(codneg).build())
        .build();
  }
}