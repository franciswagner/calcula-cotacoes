package com.ricardococati.service.converter;

import com.ricardococati.model.dto.CandlestickDiarioDTO;
import com.ricardococati.model.dto.MediaMovelExponencial;
import com.ricardococati.model.dto.MediaMovelExponencialDiario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ConverteMediaMovelExponencial {

  public MediaMovelExponencialDiario converterCandlestickDiarioToMediaMovelExponencial(
      CandlestickDiarioDTO candlestickDiario){
    return MediaMovelExponencialDiario
        .builder()
        .mediaMovelExponencial(
            MediaMovelExponencial
                .builder()
                .codneg(candlestickDiario.getCandlestickDTO().getCodneg())
                .build())
        .build();
  }
}
