package com.ricardococati.service.impl;

import static java.util.Objects.nonNull;

import com.ricardococati.model.dto.Histograma;
import com.ricardococati.model.dto.HistogramaDiario;
import com.ricardococati.model.dto.MacdDiario;
import com.ricardococati.model.dto.MediaMovelExponencialDiario;
import com.ricardococati.model.dto.MediaMovelSimplesDiario;
import com.ricardococati.model.dto.RecomendacaoDiario;
import com.ricardococati.model.dto.SinalMacdDiario;
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
      final List<String> listCodneg,
      final LocalDate dtLimitePregao
  ) throws Exception{
    List<RecomendacaoDiario> recomendacaoDiarioList = new ArrayList<>();
    try {
      Boolean controle = executeMediaSimplesDiario(listCodneg);
      controle = controle && executeMediaExponencialDiario(listCodneg);
      controle = controle && executeMacdDiario(listCodneg);
      controle = controle && executeSinalMacdDiario(listCodneg);
      controle = controle && executeHistogramaDiario(listCodneg);
      if (controle) {
        recomendacaoDiarioList = recomendacaoService.executeByCodNeg(listCodneg, dtLimitePregao);
      }
    } catch (Exception ex){
      log.error("Erro ao gerar recomendação: {} ", ex.getMessage());
      throw ex;
    }
    return recomendacaoDiarioList;
  }

  private Boolean executeMediaSimplesDiario(final List<String> listCodneg) throws Exception {
    List<MediaMovelSimplesDiario> lisMMS = new ArrayList<>();
    listCodneg
        .stream()
        .filter(Objects::nonNull)
        .forEach(codneg -> {
          lisMMS.addAll(mmsService.executeByCodNeg(codneg));
        });
    return nonNull(lisMMS) && !lisMMS.isEmpty();
  }

  private Boolean executeMediaExponencialDiario(final List<String> listCodneg) throws Exception {
    List<MediaMovelExponencialDiario> lisMME = new ArrayList<>();
    listCodneg
        .stream()
        .filter(Objects::nonNull)
        .forEach(codneg -> {
          lisMME.addAll(mmeService.executeByCodNeg(codneg));
        });
    return nonNull(lisMME) && !lisMME.isEmpty();
  }

  private Boolean executeMacdDiario(final List<String> listCodneg) throws Exception {
    List<MacdDiario> listMacd = new ArrayList<>();
    listCodneg
        .stream()
        .filter(Objects::nonNull)
        .forEach(codneg -> {
          listMacd.addAll(macdService.executeByCodNeg(codneg));
        });
    return nonNull(listMacd) && !listMacd.isEmpty();
  }

  private Boolean executeSinalMacdDiario(final List<String> listCodneg) throws Exception {
    List<SinalMacdDiario> listSinal = new ArrayList<>();
    listCodneg
        .stream()
        .filter(Objects::nonNull)
        .forEach(codneg -> {
          listSinal.addAll(sinalMacdService.executeByCodNeg(codneg));
        });
    return nonNull(listSinal) && !listSinal.isEmpty();
  }

  private Boolean executeHistogramaDiario(final List<String> listCodneg) throws Exception {
    List<HistogramaDiario> listHistograma = new ArrayList<>();
    listCodneg
        .stream()
        .filter(Objects::nonNull)
        .forEach(codneg -> {
          listHistograma.addAll(histogramaService.executeByCodNeg(codneg));
        });
    return nonNull(listHistograma) && !listHistograma.isEmpty();
  }

}
