package com.ricardococati.service.impl;

import com.ricardococati.model.dto.RecomendacaoDiario;
import com.ricardococati.service.CalculaGeralDiarioService;
import com.ricardococati.service.CalculaHistogramaDiarioService;
import com.ricardococati.service.CalculaMACDDiarioService;
import com.ricardococati.service.CalculaMediaMovelExponencialDiarioService;
import com.ricardococati.service.CalculaMediaMovelSimplesDiarioService;
import com.ricardococati.service.CalculaRecomendacaoDiarioService;
import com.ricardococati.service.CalculaSinalMacdDiarioService;
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
public class CalculaGeralDiarioServiceImpl implements
    CalculaGeralDiarioService {

  private final CalculaMediaMovelSimplesDiarioService mmsService;
  private final CalculaMediaMovelExponencialDiarioService mmeService;
  private final CalculaMACDDiarioService macdService;
  private final CalculaSinalMacdDiarioService sinalMacdService;
  private final CalculaHistogramaDiarioService histogramaService;
  private final CalculaRecomendacaoDiarioService recomendacaoService;

  @Override
  public List<RecomendacaoDiario> executeByCodNeg(
      final List<String> listCodneg, final LocalDate dtLimitePregao) {
    List<RecomendacaoDiario> recomendacaoDiarioList = new ArrayList<>();
    Boolean controle = executeMediaSimplesDiario(listCodneg);
    controle = controle && executeMediaExponencialDiario(listCodneg);
    controle = controle && executeMacdDiario(listCodneg);
    controle = controle && executeSinalMacdDiario(listCodneg);
    controle = controle && executeHistogramaDiario(listCodneg);
    if (controle) {
      recomendacaoDiarioList = recomendacaoService.executeByCodNeg(listCodneg, dtLimitePregao);
    }
    return recomendacaoDiarioList;
  }

  private Boolean executeMediaSimplesDiario(final List<String> listCodneg) {
    listCodneg
        .stream()
        .filter(Objects::nonNull)
        .forEach(codneg -> {
          mmsService.executeByCodNeg(codneg);
        });
    return Boolean.TRUE;
  }

  private Boolean executeMediaExponencialDiario(final List<String> listCodneg) {
    listCodneg
        .stream()
        .filter(Objects::nonNull)
        .forEach(codneg -> {
          mmeService.executeByCodNeg(codneg);
        });
    return Boolean.TRUE;
  }

  private Boolean executeMacdDiario(final List<String> listCodneg) {
    listCodneg
        .stream()
        .filter(Objects::nonNull)
        .forEach(codneg -> {
          macdService.executeByCodNeg(codneg);
        });
    return Boolean.TRUE;
  }

  private Boolean executeSinalMacdDiario(final List<String> listCodneg) {
    listCodneg
        .stream()
        .filter(Objects::nonNull)
        .forEach(codneg -> {
          sinalMacdService.executeByCodNeg(codneg);
        });
    return Boolean.TRUE;
  }

  private Boolean executeHistogramaDiario(final List<String> listCodneg) {
    listCodneg
        .stream()
        .filter(Objects::nonNull)
        .forEach(codneg -> {
          histogramaService.executeByCodNeg(codneg);
        });
    return Boolean.TRUE;
  }

}
