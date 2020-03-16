package com.ricardococati.service.converter;

import com.ricardococati.model.entities.CandlestickDiario;
import com.ricardococati.model.entities.CandlestickSemanal;
import com.ricardococati.model.entities.MediaMovelSimples;
import com.ricardococati.model.entities.MediaMovelSimplesDiario;
import com.ricardococati.model.entities.MediaMovelSimplesSemanal;
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
