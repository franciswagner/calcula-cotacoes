package com.ricardococati.service.impl;

import static java.util.Objects.nonNull;

import com.ricardococati.model.dto.Macd;
import com.ricardococati.model.dto.MacdDiario;
import com.ricardococati.model.dto.MediaMovelExponencialDiario;
import com.ricardococati.model.dto.MediaMovelExponencialSemanal;
import com.ricardococati.model.enums.QuantidadePeriodo;
import com.ricardococati.repository.dao.MacdDiarioBuscarDAO;
import com.ricardococati.repository.dao.MacdDiarioInserirDAO;
import com.ricardococati.repository.dao.MediaMovelExponencialDiarioBuscarDAO;
import com.ricardococati.service.MACDDiarioCalculaService;
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
public class MACDDiarioCalculaServiceImpl
    implements MACDDiarioCalculaService {

  private final MediaMovelExponencialDiarioBuscarDAO mmeDAO;
  private final MacdDiarioBuscarDAO macdDAO;
  private final MacdDiarioInserirDAO macdInserirDAO;

  @Override
  public List<MacdDiario> executeByCodNeg(String codneg) {
    log.info("Código de negociação: " + codneg);
    return calculaMACD(codneg);
  }

  private List<MacdDiario> calculaMACD(final String codneg) {
    List<MacdDiario> macdList = new ArrayList<>();
    final List<MediaMovelExponencialDiario> listMedia12 = buscaMME12Periodo(codneg);
    final List<MediaMovelExponencialDiario> listMedia26 = buscaMME26Periodo(codneg);
    if(nonNull(listMedia12) && nonNull(listMedia26)) {
      listMedia12.forEach(mme12 -> {
        listMedia26
            .stream()
            .filter(mme26 -> mme12.getDtpreg().isEqual(mme26.getDtpreg()))
            .forEach(mme26 -> {
              BigDecimal premacd =
                  mme12.getMediaMovelExponencial().getPremedult()
                  .subtract(mme26.getMediaMovelExponencial().getPremedult());
              macdList.add(
                  buildMacd(
                      mme26.getMediaMovelExponencial().getCodneg(),
                      mme26.getDtpreg(),
                      premacd
                  )
              );
            });
      });
    }
    inserirMacd(macdList);
    return macdList;
  }

  private void inserirMacd(List<MacdDiario> macdList) {
    macdList
        .parallelStream()
        .filter(Objects::nonNull)
        .filter(macdDiario -> nonNull(macdDiario.getDtpreg()))
        .filter(macdDiario -> nonNull(macdDiario.getMacd()))
        .filter(macdDiario -> nonNull(macdDiario.getMacd().getCodneg()))
        .forEach(macdInserirDAO::incluirMacd);
  }

  private List<MediaMovelExponencialDiario> buscaMME12Periodo(final String codneg) {
    return mmeDAO.getListMMEByCodNegEPeriodo(
        codneg,
        QuantidadePeriodo.FAST_12.getQuantidade());
  }

  private List<MediaMovelExponencialDiario> buscaMME26Periodo(final String codneg) {
    return mmeDAO.getListMMEByCodNegEPeriodo(
        codneg,
        QuantidadePeriodo.SLOW_26.getQuantidade());
  }

  private MacdDiario buildMacd(
      final String codneg,
      final LocalDate dtpreg,
      final BigDecimal prepremacd) {
    return MacdDiario.builder()
        .dtpreg(dtpreg)
        .macd(Macd.builder().codneg(codneg)
        .premacd(prepremacd).build())
        .build();
  }

}
