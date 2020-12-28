package com.ricardococati.calculacotacoes.usecases.mediasimples.impl;

import static com.ricardococati.calculacotacoes.utils.geral.BigDecimalCustomizado.sendDoubleGetValueBigDecimalArredonda4Casas;
import static java.util.Objects.nonNull;

import com.ricardococati.calculacotacoes.adapters.repositories.mediasimples.MediaMovelSimplesDiarioInserirDAO;
import com.ricardococati.calculacotacoes.entities.domains.candlestick.Candlestick;
import com.ricardococati.calculacotacoes.entities.domains.candlestick.CandlestickDiario;
import com.ricardococati.calculacotacoes.entities.domains.mediasimples.MediaMovelSimplesDiario;
import com.ricardococati.calculacotacoes.entities.enums.QuantidadePeriodo;
import com.ricardococati.calculacotacoes.usecases.candlestick.CandlestickDiarioBuscarService;
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
    return IntStream.range(periodo - 1, candlestickDiario.size())
        .mapToObj(indice -> calcula(periodo, indice, candlestickDiario, codneg))
        .collect(Collectors.toList());
  }

  private MediaMovelSimplesDiario calcula(
      int periodo, int posicao, List<CandlestickDiario> candlestickDiarioList, String codneg) {
    double soma = 0.0;
    MediaMovelSimplesDiario mediaMovelSimples =
        converteMediaMovelSimples
            .converterCandlestickDiarioToMediaMovelSimples(buildCandlestickDiarioDTO(codneg));
    mediaMovelSimples.getMediaMovelSimples().setPeriodo(periodo);
    for (int indice = posicao - (periodo - 1); indice <= posicao; indice++) {
      CandlestickDiario candlestickDiario = candlestickDiarioList.get(indice);
      soma += candlestickDiario.getCandlestick().getPreult().doubleValue();
      if (indice == posicao) {
        mediaMovelSimples.setDtpreg(candlestickDiario.getDtpreg());
        mediaMovelSimples.getMediaMovelSimples().setPremedult(
            sendDoubleGetValueBigDecimalArredonda4Casas(soma / periodo)
        );
      }
    }
    return mediaMovelSimples;
  }

  private CandlestickDiario buildCandlestickDiarioDTO(final String codneg) {
    return CandlestickDiario.builder()
        .candlestick(Candlestick.builder().codneg(codneg).build())
        .build();
  }
}