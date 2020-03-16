package com.ricardococati.service.impl;

import static java.util.Objects.nonNull;

import com.ricardococati.model.entities.Macd;
import com.ricardococati.model.entities.MacdSemanal;
import com.ricardococati.model.entities.MediaMovelExponencialSemanal;
import com.ricardococati.model.enums.QuantidadePeriodo;
import com.ricardococati.repository.dao.MacdSemanalBuscarDAO;
import com.ricardococati.repository.dao.MacdSemanalInserirDAO;
import com.ricardococati.repository.dao.MediaMovelExponencialSemanalBuscarDAO;
import com.ricardococati.service.MACDSemanalCalculaService;
import com.ricardococati.service.CalculaService;
import com.ricardococati.service.CandlestickSemanalBuscarService;
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
public class MACDSemanalCalculaServiceImpl
    implements MACDSemanalCalculaService {

  private final CandlestickSemanalBuscarService candleSemanalService;
  private final MediaMovelExponencialSemanalBuscarDAO mmeDAO;
  private final MacdSemanalBuscarDAO macdDAO;
  private final CalculaService calculaService;
  private final MacdSemanalInserirDAO incluirMacd;

  @Override
  public List<MacdSemanal> executeByCodNeg(String codneg) {
    log.info("Código de negociação: " + codneg);
    return calculaMACD(codneg);
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
    if(nonNull(listMedia12) && nonNull(listMedia26)) {
      listMedia12.forEach(mme12 -> {
        listMedia26
            .stream()
            .filter(mme26 ->
                mme12.getDtpregini().isEqual(mme26.getDtpregini())
                && mme12.getDtpregfim().isEqual(mme26.getDtpregfim()))
            .forEach(mme26 -> {
              BigDecimal premacd =
                  mme12
                      .getMediaMovelExponencial()
                      .getPremedult()
                      .subtract(mme26.getMediaMovelExponencial().getPremedult());
          macdList.add(
              buildMacd(
                  mme26.getMediaMovelExponencial().getCodneg(),
                  mme26.getDtpregini(),
                  mme26.getDtpregfim(),
                  premacd
              )
          );
        });
      });
    }
    incluirMacd(macdList);
    return macdList;
  }

  private void incluirMacd(List<MacdSemanal> macdList) {
    macdList
        .parallelStream()
        .filter(Objects::nonNull)
        .filter(macdSemanal -> nonNull(macdSemanal.getDtpregini()))
        .filter(macdSemanal -> nonNull(macdSemanal.getDtpregfim()))
        .filter(macdSemanal -> nonNull(macdSemanal.getMacd()))
        .filter(macdSemanal -> nonNull(macdSemanal.getMacd().getCodneg()))
        .forEach(incluirMacd::incluirMacd);
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
