package com.ricardococati.service.impl;

import com.ricardococati.model.dto.Macd;
import com.ricardococati.model.dto.MacdSemanal;
import com.ricardococati.model.dto.MediaMovelExponencialSemanal;
import com.ricardococati.model.enums.QuantidadePeriodo;
import com.ricardococati.repository.dao.MacdSemanalDAO;
import com.ricardococati.repository.dao.MediaMovelExponencialSemanalDAO;
import com.ricardococati.service.MACDSemanalCalculaService;
import com.ricardococati.service.CalculaService;
import com.ricardococati.service.CandlestickSemanalBuscarService;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Data
@Service
@RequiredArgsConstructor
public class MACDSemanalCalculaServiceImpl
    implements MACDSemanalCalculaService {

  private final CandlestickSemanalBuscarService candleSemanalService;
  private final MediaMovelExponencialSemanalDAO mmeDAO;
  private final MacdSemanalDAO macdDAO;
  private final CalculaService calculaService;

  @Override
  public List<MacdSemanal> executeByCodNeg(String codneg) {
    log.info("Código de negociação: " + codneg);
    final List<MacdSemanal> macdSemanalList = calculaMACD(codneg);
    return macdSemanalList;
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

  private List<MacdSemanal> calculaMACD(final String codneg) {
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
    return macdList;
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
