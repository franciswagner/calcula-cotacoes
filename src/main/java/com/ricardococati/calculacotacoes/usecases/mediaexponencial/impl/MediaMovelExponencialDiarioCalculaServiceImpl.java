package com.ricardococati.calculacotacoes.usecases.mediaexponencial.impl;

import static com.ricardococati.calculacotacoes.utils.geral.BigDecimalCustomizado.sendBigDecimalGetValueBigDecimalArredonda4Casas;
import static com.ricardococati.calculacotacoes.utils.geral.BigDecimalCustomizado.sendDoubleGetValueBigDecimalArredonda4Casas;
import static java.util.Objects.nonNull;

import com.ricardococati.calculacotacoes.adapters.repositories.mediaexponencial.MediaMovelExponencialDiarioInserirDAO;
import com.ricardococati.calculacotacoes.adapters.repositories.mediasimples.MediaMovelSimplesDiarioBuscarDAO;
import com.ricardococati.calculacotacoes.entities.domains.candlestick.Candlestick;
import com.ricardococati.calculacotacoes.entities.domains.candlestick.CandlestickDiario;
import com.ricardococati.calculacotacoes.entities.domains.mediaexponencial.MediaMovelExponencial;
import com.ricardococati.calculacotacoes.entities.domains.mediaexponencial.MediaMovelExponencialDiario;
import com.ricardococati.calculacotacoes.entities.domains.mediasimples.MediaMovelSimplesDiario;
import com.ricardococati.calculacotacoes.entities.enums.QuantidadePeriodo;
import com.ricardococati.calculacotacoes.usecases.candlestick.CandlestickDiarioBuscarService;
import com.ricardococati.calculacotacoes.usecases.mediaexponencial.MediaMovelExponencialDiarioCalculaService;
import com.ricardococati.calculacotacoes.utils.converters.MediaMovelSimplesConverter;
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
public class MediaMovelExponencialDiarioCalculaServiceImpl
    implements MediaMovelExponencialDiarioCalculaService {

  private static final int PRIMEIRA_POSICAO = 0;
  private static final Boolean MEDIA_MOVEL_SIMPLES_GERADA = true;
  private static final Boolean MEDIA_EXPONENCIAL_NAO_GERADA = false;
  private final CandlestickDiarioBuscarService diarioService;
  private final MediaMovelSimplesConverter converteMediaMovelSimples;
  private final MediaMovelSimplesDiarioBuscarDAO mediaMovelSimplesDAO;
  private final MediaMovelExponencialDiarioInserirDAO mmeInserirDAO;

  @Override
  public List<MediaMovelExponencialDiario> executeByCodNeg(String codneg) {
    log.info("C??digo de negocia????o: " + codneg);
    List<CandlestickDiario> candlestickList =
        diarioService.buscaCandlestickDiarioPorCodNeg(
            buildCandlestickDiarioDTO(codneg));
    List<MediaMovelExponencialDiario> listMME =
        calculaMediaMovelExponencialPorPeriodo(codneg, candlestickList);
    incluirMMEDiario(listMME);
    return listMME;
  }

  private void incluirMMEDiario(List<MediaMovelExponencialDiario> listMME) {
    listMME
        .parallelStream()
        .filter(Objects::nonNull)
        .filter(mmeDiario -> nonNull(mmeDiario.getDtpreg()))
        .filter(mmeDiario -> nonNull(mmeDiario.getMediaMovelExponencial()))
        .filter(mmeDiario -> nonNull(mmeDiario.getMediaMovelExponencial().getCodneg()))
        .forEach(mmeInserirDAO::incluirMediaMovelExponencial);
  }

  private List<MediaMovelExponencialDiario> calculaMediaMovelExponencialPorPeriodo(
      final String codneg,
      List<CandlestickDiario> candlestickList) {
    List<MediaMovelExponencialDiario> mediaMovelExponencialList = new ArrayList<>();
    QuantidadePeriodo
        .getListQuantidadePeriodo()
        .parallelStream()
        .filter(periodo -> nonNull(candlestickList))
        .filter(Objects::nonNull)
        .forEach(periodo ->
            mediaMovelExponencialList.addAll(
                calculaMediaMovelExponencial(periodo, candlestickList)
            )
        );
    return mediaMovelExponencialList;
  }

  public List<MediaMovelExponencialDiario> calculaMediaMovelExponencial(
      int periodo, List<CandlestickDiario> candlestickList) {
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
          candlestickList.get(indice).getCandlestick().getCodneg(),
          candlestickList.get(indice).getDtpreg(),
          periodo,
          calculaMME(periodo, candlestickList.get(indice).getCandlestick().getPreult(),
              listReturn.get(posicao - 1).getMediaMovelExponencial().getPremedult()))
      );
      posicao++;
    }
    return listReturn;
  }

  private MediaMovelSimplesDiario getPrimeiraMedia(
      final int periodo,
      final List<CandlestickDiario> candlestickList,
      final int indice) {
    MediaMovelSimplesDiario mediaMovelSimplesDiario = null;
    try{
      mediaMovelSimplesDiario = mediaMovelSimplesDAO
          .buscaMediaSimplesPorCodNegPeriodoDtPreg(
              candlestickList.get(indice).getCandlestick().getCodneg(),
              periodo,
              candlestickList.get(indice).getDtpreg());
    } catch (Exception exc){
      log.error("Erro ao buscar m??dia m??vel simples! {} ", exc.getMessage());
    }
    return mediaMovelSimplesDiario;
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

  private CandlestickDiario buildCandlestickDiarioDTO(final String codneg) {
    return CandlestickDiario.builder()
        .candlestick(Candlestick.builder().codneg(codneg).build())
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
                .premedult(
                    sendBigDecimalGetValueBigDecimalArredonda4Casas(
                        mmSimples.getMediaMovelSimples().getPremedult()
                    )
                ).build())
        .build();
  }

  private MediaMovelExponencialDiario buildMediaMovelExponencial(
      final String codneg,
      final LocalDate dtpreg,
      final Integer periodo,
      final BigDecimal premed) {
    return MediaMovelExponencialDiario.builder()
        .dtpreg(dtpreg)
        .mediaMovelExponencial(
            MediaMovelExponencial
                .builder()
                .codneg(codneg)
                .periodo(periodo)
                .premedult(
                    sendBigDecimalGetValueBigDecimalArredonda4Casas(premed)
                ).build())
        .build();
  }

}
