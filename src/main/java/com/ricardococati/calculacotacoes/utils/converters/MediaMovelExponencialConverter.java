package com.ricardococati.calculacotacoes.utils.converters;

import com.ricardococati.calculacotacoes.entities.domains.candlestick.CandlestickDiario;
import com.ricardococati.calculacotacoes.entities.domains.mediaexponencial.MediaMovelExponencial;
import com.ricardococati.calculacotacoes.entities.domains.mediaexponencial.MediaMovelExponencialDiario;
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
