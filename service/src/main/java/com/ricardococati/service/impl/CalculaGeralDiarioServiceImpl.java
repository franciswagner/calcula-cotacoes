package com.ricardococati.service.impl;

import com.ricardococati.model.dto.RecomendacaoDiario;
import com.ricardococati.service.CalculaHistogramaDiarioService;
import com.ricardococati.service.CalculaMACDDiarioService;
import com.ricardococati.service.CalculaMediaMovelExponencialDiarioService;
import com.ricardococati.service.CalculaMediaMovelSimplesDiarioService;
import com.ricardococati.service.CalculaRecomendacaoDiarioService;
import com.ricardococati.service.CalculaSinalMacdDiarioService;
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
public class CalculaGeralDiarioServiceImpl implements
    com.ricardococati.service.CalculaGeralDiarioService {

  private final CalculaMediaMovelSimplesDiarioService mmsService;
  private final CalculaMediaMovelExponencialDiarioService mmeService;
  private final CalculaMACDDiarioService macdService;
  private final CalculaSinalMacdDiarioService sinalMacdService;
  private final CalculaHistogramaDiarioService histogramaService;
  private final CalculaRecomendacaoDiarioService recomendacaoService;

  @Override
  public List<RecomendacaoDiario> executeByCodNeg(
      final String codneg, final LocalDate dtLimitePregao) {
    List<RecomendacaoDiario> recomendacaoDiarioList = new ArrayList<>();
    Boolean controle = executeMediaSimplesDiario(codneg);
    controle = controle && executeMediaExponencialDiario(codneg);
    controle = controle && executeMacdDiario(codneg);
    controle = controle && executeSinalMacdDiario(codneg);
    controle = controle && executeHistogramaDiario(codneg);
    if (controle) {
      recomendacaoDiarioList = recomendacaoService.executeByCodNeg(codneg, dtLimitePregao);
    }
    return recomendacaoDiarioList;
  }

  private Boolean executeMediaSimplesDiario(final String codneg) {
    mmsService.executeByCodNeg(codneg);
    return Boolean.TRUE;
  }

  private Boolean executeMediaExponencialDiario(final String codneg) {
    mmeService.executeByCodNeg(codneg);
    return Boolean.TRUE;
  }

  private Boolean executeMacdDiario(final String codneg) {
    macdService.executeByCodNeg(codneg);
    return Boolean.TRUE;
  }

  private Boolean executeSinalMacdDiario(final String codneg) {
    sinalMacdService.executeByCodNeg(codneg);
    return Boolean.TRUE;
  }

  private Boolean executeHistogramaDiario(final String codneg) {
    histogramaService.executeByCodNeg(codneg);
    return Boolean.TRUE;
  }

}
