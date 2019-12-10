package com.ricardococati.service.impl;

import com.ricardococati.model.dto.Macd;
import com.ricardococati.model.dto.MacdSemanal;
import com.ricardococati.model.dto.MediaMovelExponencialSemanal;
import com.ricardococati.model.enums.QuantidadePeriodo;
import com.ricardococati.repository.dao.IMacdSemanalDAO;
import com.ricardococati.repository.dao.IMediaMovelExponencialSemanalDAO;
import com.ricardococati.service.ICalculaMACDSemanalService;
import com.ricardococati.service.ICalculaService;
import com.ricardococati.service.ICandlestickSemanalService;
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
public class CalculaMACDSemanalService
    implements ICalculaMACDSemanalService {

  private final ICandlestickSemanalService candleSemanalService;
  private final IMediaMovelExponencialSemanalDAO mmeDAO;
  private final IMacdSemanalDAO macdDAO;
  private final ICalculaService calculaService;

  @Override
  public Boolean execute() {
    AtomicBoolean returned = new AtomicBoolean(true);
    if (returned.get()) {
      calculaService
          .listCodNegSemanal()
          .forEach(
              codigoNegocio -> {
                log.info("Código de negociação: " + codigoNegocio);
                returned.set(calculaMACD(codigoNegocio));
                candleSemanalService.atualizaCandleSemanalMacdGeradaByCodneg(codigoNegocio);
              });
    }
    return returned.get();
  }

  private List<MediaMovelExponencialSemanal> buscaMME12Periodo(final String codneg) {
    return mmeDAO.getListMMEByCodNegEPeriodo(
        codneg,
        QuantidadePeriodo.FAST_12.getQuantidade());
  }

  private List<MediaMovelExponencialSemanal> buscaMME26Periodo(final String codneg) {
    return mmeDAO.getListMMEByCodNegEPeriodo(
        codneg,
        QuantidadePeriodo.SLOW_26.getQuantidade());
  }

  private Boolean calculaMACD(final String codneg) {
    List<MacdSemanal> macdList = new ArrayList<>();
    final List<MediaMovelExponencialSemanal> listMedia12 = buscaMME12Periodo(codneg);
    final List<MediaMovelExponencialSemanal> listMedia26 = buscaMME26Periodo(codneg);
    for (MediaMovelExponencialSemanal mme12 : listMedia12) {
      for (MediaMovelExponencialSemanal mme26 : listMedia26) {
        if (mme12.getDtpregini().isEqual(mme26.getDtpregini())
        && mme12.getDtpregfim().isEqual(mme26.getDtpregfim())) {
          BigDecimal premacd = mme12.getMediaMovelExponencial().getPremedult()
              .subtract(mme26.getMediaMovelExponencial().getPremedult());
          macdList.add(
              buildMacd(
                  mme26.getMediaMovelExponencial().getCodneg(),
                  mme26.getDtpregini(),
                  mme26.getDtpregfim(),
                  premacd
              )
          );
        }
      }
    }
    macdDAO.incluirMacd(macdList);
    return Boolean.TRUE;
  }

  @Override
  public Boolean executeByCodNeg(String codneg) {
    log.info("Código de negociação: " + codneg);
    calculaMACD(codneg);
    return Boolean.TRUE;
  }

  private MacdSemanal buildMacd(
      final String codneg,
      final LocalDate dtpregini,
      final LocalDate dtpregfim,
      final BigDecimal prepremacd) {
    return MacdSemanal.builder()
        .dtpregini(dtpregini)
        .dtpregfim(dtpregfim)
        .macd(Macd.builder().codneg(codneg)
        .premacd(prepremacd).build())
        .build();
  }

}
