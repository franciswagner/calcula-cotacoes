package com.ricardococati.service.impl;

import static java.util.Objects.nonNull;

import com.ricardococati.model.dto.CandlestickDTO;
import com.ricardococati.model.dto.CandlestickDiarioDTO;
import com.ricardococati.model.dto.MediaMovelExponencial;
import com.ricardococati.model.dto.MediaMovelExponencialDiario;
import com.ricardococati.model.dto.MediaMovelSimplesDiario;
import com.ricardococati.model.enums.QuantidadePeriodo;
import com.ricardococati.repository.dao.MediaMovelExponencialDiarioDAO;
import com.ricardococati.repository.dao.MediaMovelSimplesDiarioDAO;
import com.ricardococati.service.CalculaMediaMovelExponencialDiarioService;
import com.ricardococati.service.CandlestickDiarioService;
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
public class CalculaMediaMovelExponencialDiarioServiceImpl
    implements CalculaMediaMovelExponencialDiarioService {

  private static final int PRIMEIRA_POSICAO = 0;
  private static final Boolean MEDIA_MOVEL_SIMPLES_GERADA = true;
  private static final Boolean MEDIA_EXPONENCIAL_NAO_GERADA = false;
  private final CandlestickDiarioService diarioService;
  private final MediaMovelSimplesConverter converteMediaMovelSimples;
  private final MediaMovelSimplesDiarioDAO mediaMovelSimplesDAO;
  private final MediaMovelExponencialDiarioDAO mediaMovelExponencialDAO;

  @Override
  public List<MediaMovelExponencialDiario> executeByCodNeg(String codneg) {
    log.info("Código de negociação: " + codneg);
    List<CandlestickDiarioDTO> candlestickList =
        diarioService.listaCandlestickDiario(
            buildCandlestickDiarioDTO(codneg));
    List<MediaMovelExponencialDiario> listMME =
        calculaMediaMovelExponencialPorPeriodo(codneg, candlestickList);
    mediaMovelExponencialDAO.incluirMediaMovelExponencial(listMME);
    return listMME;
  }

  private List<MediaMovelExponencialDiario> calculaMediaMovelExponencialPorPeriodo(
      final String codneg,
      List<CandlestickDiarioDTO> candlestickList) {
    List<MediaMovelExponencialDiario> mediaMovelExponencialList = new ArrayList<>();
    QuantidadePeriodo
        .getListQuantidadePeriodo()
        .stream()
        .filter(periodo -> nonNull(candlestickList))
        .filter(Objects::nonNull)
        .forEach(periodo ->
            mediaMovelExponencialList
                .addAll(calculaMediaMovelExponencial(periodo, candlestickList)));
    return mediaMovelExponencialList;
  }

  public List<MediaMovelExponencialDiario> calculaMediaMovelExponencial(
      int periodo, List<CandlestickDiarioDTO> candlestickList) {
    List<MediaMovelExponencialDiario> listReturn = new ArrayList<>();
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
          candlestickList.get(indice).getDtpreg(),
          periodo,
          calculaMME(periodo, candlestickList.get(indice).getCandlestickDTO().getPreult(),
              listReturn.get(posicao - 1).getMediaMovelExponencial().getPremedult()))
      );
      posicao++;
    }
    return listReturn;
  }

  private MediaMovelSimplesDiario getPrimeiraMedia(
      final int periodo,
      final List<CandlestickDiarioDTO> candlestickList,
      final int indice) {
    return mediaMovelSimplesDAO
        .buscaMediaSimplesPorCodNegPeriodoDtPreg(
            candlestickList.get(indice).getCandlestickDTO().getCodneg(),
            periodo,
            candlestickList.get(indice).getDtpreg());
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

  private CandlestickDiarioDTO buildCandlestickDiarioDTO(final String codneg) {
    return CandlestickDiarioDTO.builder()
        .candlestickDTO(CandlestickDTO.builder().codneg(codneg).build())
        .build();
  }

  private MediaMovelExponencialDiario buildMediaMovelExponencialByMMS(
      final MediaMovelSimplesDiario mmSimples) {
    return MediaMovelExponencialDiario.builder()
        .dtpreg(mmSimples.getDtpreg())
        .mediaMovelExponencial(
            MediaMovelExponencial
                .builder()
                .codneg(mmSimples.getMediaMovelSimples().getCodneg())
                .periodo(mmSimples.getMediaMovelSimples().getPeriodo())
                .premedult(mmSimples.getMediaMovelSimples().getPremedult().setScale(4, BigDecimal.ROUND_HALF_UP))
                .build())
        .build();
  }

  private MediaMovelExponencialDiario buildMediaMovelExponencial(
      final String codneg,
      final LocalDate dtpreg,
      final Integer periodo,
      final BigDecimal premed) {
    return MediaMovelExponencialDiario.builder()
        .dtpreg(dtpreg)
        .mediaMovelExponencial(MediaMovelExponencial.builder().codneg(codneg)
            .periodo(periodo)
            .premedult(premed.setScale(4, BigDecimal.ROUND_HALF_UP)).build())
        .build();
  }

}