package com.ricardococati.service.impl;

import com.ricardococati.model.dto.MacdDiario;
import com.ricardococati.model.dto.Recomendacao;
import com.ricardococati.model.dto.RecomendacaoDiario;
import com.ricardococati.model.dto.SinalMacdDiario;
import com.ricardococati.repository.dao.IHistogramaDiarioDAO;
import com.ricardococati.repository.dao.IMacdDiarioDAO;
import com.ricardococati.repository.dao.IMediaMovelExponencialDiarioDAO;
import com.ricardococati.repository.dao.IRecomendacaoDiarioDAO;
import com.ricardococati.repository.dao.ISinalMacdDiarioDAO;
import com.ricardococati.service.ICalculaRecomendacaoDiarioService;
import com.ricardococati.service.ICalculaService;
import com.ricardococati.service.ICandlestickDiarioService;
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
public class CalculaRecomendacaoDiarioService
    implements ICalculaRecomendacaoDiarioService {

  private final ICandlestickDiarioService calculaCandlestickService;
  private final IMacdDiarioDAO macdDAO;
  private final ISinalMacdDiarioDAO sinalMacdDAO;
  private final IHistogramaDiarioDAO histogramaDAO;
  private final IRecomendacaoDiarioDAO recomendacaoDAO;
  private final IMediaMovelExponencialDiarioDAO mediaMovelExponencialDAO;
  private final ICalculaService calculaService;

  @Override
  public List<RecomendacaoDiario> executeByCodNeg(String codneg) {
    log.info("Código de negociação: " + codneg);
    List<MacdDiario> macdList =
        macdDAO.listMacdByCodNeg(codneg);
    List<SinalMacdDiario> sinalMacdList =
        sinalMacdDAO.listSinalMacdByCodNeg(codneg);
    List<RecomendacaoDiario> diarioList = calculaRecomendacao(macdList, sinalMacdList);
    recomendacaoDAO.incluirRecomendacao(diarioList);
    calculaCandlestickService.atualizaCandleDiarioSinalMacdGeradaByCodneg(codneg);
    return diarioList;
  }

  private List<RecomendacaoDiario> calculaRecomendacao(
      List<MacdDiario> macdList, List<SinalMacdDiario> sinalMacdList) {
    List<RecomendacaoDiario> RecomendacaoList = new ArrayList<>();
    for(MacdDiario macd : macdList){
      for (SinalMacdDiario sinal : sinalMacdList){
        if (sinal.getDtpreg().isEqual(macd.getDtpreg())
            && sinal.getSinalMacd().getCodneg().equals(macd.getMacd().getCodneg())){
          RecomendacaoDiario hist = buildRecomendacao(macd, sinal);
          if (!RecomendacaoList.contains(hist)){
            RecomendacaoList.add(hist);
          }
        }
      }
    }
    return RecomendacaoList;
  }

  private RecomendacaoDiario buildRecomendacao(final MacdDiario macd, final SinalMacdDiario sinal) {
    return RecomendacaoDiario.builder()
        .dtpreg(macd.getDtpreg())
        .recomendacao(
            Recomendacao
                .builder()
                .codneg(macd.getMacd().getCodneg())
                .precoFechamento(macd.getMacd().getPremacd()
                    .subtract(sinal.getSinalMacd().getPresinal()))
                .build())
        .build();
  }

}
