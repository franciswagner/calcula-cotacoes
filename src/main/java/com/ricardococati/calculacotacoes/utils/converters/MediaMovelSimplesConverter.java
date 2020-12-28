package com.ricardococati.calculacotacoes.utils.converters;

import com.ricardococati.calculacotacoes.entities.domains.candlestick.CandlestickDiario;
import com.ricardococati.calculacotacoes.entities.domains.candlestick.CandlestickSemanal;
import com.ricardococati.calculacotacoes.entities.domains.mediasimples.MediaMovelSimples;
import com.ricardococati.calculacotacoes.entities.domains.mediasimples.MediaMovelSimplesDiario;
import com.ricardococati.calculacotacoes.entities.domains.mediasimples.MediaMovelSimplesSemanal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MediaMovelSimplesConverter {

  public MediaMovelSimplesDiario converterCandlestickDiarioToMediaMovelSimples(
      CandlestickDiario candlestickDiario) {
    return MediaMovelSimplesDiario
        .builder()
        .dtpreg(candlestickDiario.getDtpreg())
        .mediaMovelSimples(
            MediaMovelSimples
                .builder()
                .codneg(candlestickDiario.getCandlestick().getCodneg())
                .build())
        .build();
  }

  public MediaMovelSimplesSemanal converterCandlestickSemanalToMediaMovelSimples(
      CandlestickSemanal candlestickSemanal) {
    return MediaMovelSimplesSemanal
        .builder()
        .dtpregini(candlestickSemanal.getDtpregini())
        .dtpregfim(candlestickSemanal.getDtpregfim())
        .mediaMovelSimples(
            MediaMovelSimples
                .builder()
                .codneg(candlestickSemanal.getCandlestick().getCodneg())
                .build())
        .build();
  }

}
