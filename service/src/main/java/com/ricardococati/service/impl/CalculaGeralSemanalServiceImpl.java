package com.ricardococati.service.impl;

import static java.util.Objects.nonNull;

import com.ricardococati.model.dto.HistogramaDiario;
import com.ricardococati.model.dto.HistogramaSemanal;
import com.ricardococati.model.dto.MacdDiario;
import com.ricardococati.model.dto.MacdSemanal;
import com.ricardococati.model.dto.MediaMovelExponencialDiario;
import com.ricardococati.model.dto.MediaMovelExponencialSemanal;
import com.ricardococati.model.dto.MediaMovelSimplesDiario;
import com.ricardococati.model.dto.MediaMovelSimplesSemanal;
import com.ricardococati.model.dto.RecomendacaoDiario;
import com.ricardococati.model.dto.RecomendacaoSemanal;
import com.ricardococati.model.dto.SinalMacdDiario;
import com.ricardococati.model.dto.SinalMacdSemanal;
import com.ricardococati.service.CalculaGeralDiarioService;
import com.ricardococati.service.CalculaGeralSemanalService;
import com.ricardococati.service.HistogramaDiarioCalculaService;
import com.ricardococati.service.HistogramaSemanalCalculaService;
import com.ricardococati.service.MACDDiarioCalculaService;
import com.ricardococati.service.MACDSemanalCalculaService;
import com.ricardococati.service.MediaMovelExponencialDiarioCalculaService;
import com.ricardococati.service.MediaMovelExponencialSemanalCalculaService;
import com.ricardococati.service.MediaMovelSimplesDiarioCalculaService;
import com.ricardococati.service.MediaMovelSimplesSemanalCalculaService;
import com.ricardococati.service.RecomendacaoDiarioCalculaService;
import com.ricardococati.service.RecomendacaoSemanalCalculaService;
import com.ricardococati.service.SinalMacdDiarioCalculaService;
import com.ricardococati.service.SinalMacdSemanalCalculaService;
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
public class CalculaGeralSemanalServiceImpl implements
    CalculaGeralSemanalService {

  private final MediaMovelSimplesSemanalCalculaService mmsService;
  private final MediaMovelExponencialSemanalCalculaService mmeService;
  private final MACDSemanalCalculaService macdService;
  private final SinalMacdSemanalCalculaService sinalMacdService;
  private final HistogramaSemanalCalculaService histogramaService;
  private final RecomendacaoSemanalCalculaService recomendacaoService;

  @Override
  public List<RecomendacaoSemanal> executeByCodNeg(
      final List<String> listCodneg,
      final LocalDate dtLimitePregao
  ) throws Exception{
    List<RecomendacaoSemanal> recomendacaoSemanalList = new ArrayList<>();
    try {
      Boolean controle = executeMediaSimplesSemanal(listCodneg);
      controle = controle && executeMediaExponencialSemanal(listCodneg);
      controle = controle && executeMacdSemanal(listCodneg);
      controle = controle && executeSinalMacdSemanal(listCodneg);
      controle = controle && executeHistogramaSemanal(listCodneg);
      if (controle) {
        recomendacaoSemanalList.addAll(recomendacaoService.executeByCodNeg(listCodneg, dtLimitePregao));
      }
    } catch (Exception ex){
      log.error("Erro ao gerar recomendação: {} ", ex.getMessage());
      throw ex;
    }
    return recomendacaoSemanalList;
  }

  private Boolean executeMediaSimplesSemanal(final List<String> listCodneg) throws Exception {
    List<MediaMovelSimplesSemanal> lisMMS = new ArrayList<>();
    listCodneg
        .stream()
        .filter(Objects::nonNull)
        .forEach(codneg -> {
          lisMMS.addAll(mmsService.executeByCodNeg(codneg));
        });
    return nonNull(lisMMS) && !lisMMS.isEmpty();
  }

  private Boolean executeMediaExponencialSemanal(final List<String> listCodneg) throws Exception {
    List<MediaMovelExponencialSemanal> lisMME = new ArrayList<>();
    listCodneg
        .stream()
        .filter(Objects::nonNull)
        .forEach(codneg -> {
          lisMME.addAll(mmeService.executeByCodNeg(codneg));
        });
    return nonNull(lisMME) && !lisMME.isEmpty();
  }

  private Boolean executeMacdSemanal(final List<String> listCodneg) throws Exception {
    List<MacdSemanal> listMacd = new ArrayList<>();
    listCodneg
        .stream()
        .filter(Objects::nonNull)
        .forEach(codneg -> {
          listMacd.addAll(macdService.executeByCodNeg(codneg));
        });
    return nonNull(listMacd) && !listMacd.isEmpty();
  }

  private Boolean executeSinalMacdSemanal(final List<String> listCodneg) throws Exception {
    List<SinalMacdSemanal> listSinal = new ArrayList<>();
    listCodneg
        .stream()
        .filter(Objects::nonNull)
        .forEach(codneg -> {
          listSinal.addAll(sinalMacdService.executeByCodNeg(codneg));
        });
    return nonNull(listSinal) && !listSinal.isEmpty();
  }

  private Boolean executeHistogramaSemanal(final List<String> listCodneg) throws Exception {
    List<HistogramaSemanal> listHistograma = new ArrayList<>();
    listCodneg
        .stream()
        .filter(Objects::nonNull)
        .forEach(codneg -> {
          listHistograma.addAll(histogramaService.executeByCodNeg(codneg));
        });
    return nonNull(listHistograma) && !listHistograma.isEmpty();
  }

}
