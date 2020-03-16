package com.ricardococati.service.converter;

import com.ricardococati.model.entities.CandlestickDiario;
import com.ricardococati.model.entities.MediaMovelExponencial;
import com.ricardococati.model.entities.MediaMovelExponencialDiario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MediaMovelExponencialConverter {

  public MediaMovelExponencialDiario converterCandlestickDiarioToMediaMovelExponencial(
      CandlestickDiario candlestickDiario){
    return MediaMovelExponencialDiario
        .builder()
        .mediaMovelExponencial(
            MediaMovelExponencial
                .builder()
                .codneg(candlestickDiario.getCandlestick().getCodneg())
                .build())
        .build();
  }
}
