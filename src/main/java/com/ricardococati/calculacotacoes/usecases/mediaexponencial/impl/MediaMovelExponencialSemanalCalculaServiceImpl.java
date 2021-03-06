package com.ricardococati.calculacotacoes.usecases.mediaexponencial.impl;

import static com.ricardococati.calculacotacoes.utils.geral.BigDecimalCustomizado.sendBigDecimalGetValueBigDecimalArredonda4Casas;
import static com.ricardococati.calculacotacoes.utils.geral.BigDecimalCustomizado.sendDoubleGetValueBigDecimalArredonda4Casas;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import com.ricardococati.calculacotacoes.adapters.repositories.mediaexponencial.MediaMovelExponencialSemanalInserirDAO;
import com.ricardococati.calculacotacoes.adapters.repositories.mediasimples.MediaMovelSimplesSemanalBuscarDAO;
import com.ricardococati.calculacotacoes.entities.domains.candlestick.Candlestick;
import com.ricardococati.calculacotacoes.entities.domains.candlestick.CandlestickSemanal;
import com.ricardococati.calculacotacoes.entities.domains.mediaexponencial.MediaMovelExponencial;
import com.ricardococati.calculacotacoes.entities.domains.mediaexponencial.MediaMovelExponencialSemanal;
import com.ricardococati.calculacotacoes.entities.domains.mediasimples.MediaMovelSimplesSemanal;
import com.ricardococati.calculacotacoes.entities.enums.QuantidadePeriodo;
import com.ricardococati.calculacotacoes.usecases.calculageral.CalculaService;
import com.ricardococati.calculacotacoes.usecases.candlestick.CandlestickSemanalBuscarService;
import com.ricardococati.calculacotacoes.usecases.mediaexponencial.MediaMovelExponencialSemanalCalculaService;
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
public class MediaMovelExponencialSemanalCalculaServiceImpl
    implements MediaMovelExponencialSemanalCalculaService {

  private static final int PRIMEIRA_POSICAO = 0;
  private static final Boolean MEDIA_MOVEL_SIMPLES_GERADA = true;
  private static final Boolean MEDIA_EXPONENCIAL_NAO_GERADA = false;
  private final CandlestickSemanalBuscarService calculaCandlestickService;
  private final MediaMovelSimplesConverter converteMediaMovelSimples;
  private final MediaMovelSimplesSemanalBuscarDAO mediaMovelSimplesDAO;
  private final MediaMovelExponencialSemanalInserirDAO inserirMMEDAO;
  private final CalculaService calculaService;

  @Override
  public List<MediaMovelExponencialSemanal> executeByCodNeg(String codneg) {
    log.info("C??digo de negocia????o: " + codneg);
    List<CandlestickSemanal> candlestickList =
        calculaCandlestickService.buscaCandlestickSemanalPorCodNeg(
            buildCandlestickSemanalDTO(codneg));
    List<MediaMovelExponencialSemanal> listMME =
        calculaMediaMovelExponencialPorPeriodo(candlestickList);
    inserirMMESemanal(listMME);
    return listMME;
  }

  private void inserirMMESemanal(List<MediaMovelExponencialSemanal> listMME) {
    listMME
        .parallelStream()
        .filter(Objects::nonNull)
        .filter(mmeSemanal -> nonNull(mmeSemanal.getDtpregini()))
        .filter(mmeSemanal -> nonNull(mmeSemanal.getDtpregfim()))
        .filter(mmeSemanal -> nonNull(mmeSemanal.getMediaMovelExponencial()))
        .filter(mmeSemanal -> nonNull(mmeSemanal.getMediaMovelExponencial().getCodneg()))
        .forEach(inserirMMEDAO::incluirMediaMovelExponencial);
  }

  private List<MediaMovelExponencialSemanal> calculaMediaMovelExponencialPorPeriodo(
      List<CandlestickSemanal> candlestickList) {
    List<MediaMovelExponencialSemanal> mediaMovelExponencialList = new ArrayList<>();
    try {
      QuantidadePeriodo
          .getListQuantidadePeriodo()
          .stream()
          .filter(periodo -> nonNull(candlestickList))
          .filter(Objects::nonNull)
          .forEach(periodo ->
              mediaMovelExponencialList
                  .addAll(calculaMediaMovelExponencial(periodo, candlestickList)));
    } catch (Exception ex){
      log.error("Erro no c??lculo de m??dia exponencial: {} ", ex.getMessage());
      throw ex;
    }
    return mediaMovelExponencialList;
  }

  public List<MediaMovelExponencialSemanal> calculaMediaMovelExponencial(
      int periodo, List<CandlestickSemanal> candlestickList) {
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
          candlestickList.get(indice).getCandlestick().getCodneg(),
          candlestickList.get(indice).getDtpregini(),
          candlestickList.get(indice).getDtpregfim(),
          periodo,
          calculaMME(periodo, candlestickList.get(indice).getCandlestick().getPreult(),
              listReturn.get(posicao - 1).getMediaMovelExponencial().getPremedult()))
      );
      posicao++;
    }
    return listReturn;
  }

  private MediaMovelSimplesSemanal getPrimeiraMedia(
      final int periodo,
      final List<CandlestickSemanal> candlestickList,
      final int indice) {
    try {
      return mediaMovelSimplesDAO
          .buscaMediaSimplesPorCodNegPeriodoDtPreg(
              candlestickList.get(indice).getCandlestick().getCodneg(),
              periodo,
              candlestickList.get(indice).getDtpregini(),
              candlestickList.get(indice).getDtpregfim());
    } catch (Exception e) {
      log.error("Erro ao buscar m??dia m??vel simples! {}", e.getMessage());
      return null;
    }
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

  private CandlestickSemanal buildCandlestickSemanalDTO(final String codneg) {
    return CandlestickSemanal
        .builder()
        .candlestick(
            Candlestick
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
                .premedult(
                    sendBigDecimalGetValueBigDecimalArredonda4Casas(
                        mmSimples.getMediaMovelSimples().getPremedult()
                    )
                ).build())
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
                .premedult(sendBigDecimalGetValueBigDecimalArredonda4Casas(premed))
                .build())
        .build();
  }

}
