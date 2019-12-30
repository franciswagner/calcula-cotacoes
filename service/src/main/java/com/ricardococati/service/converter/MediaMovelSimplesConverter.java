package com.ricardococati.service.converter;

import com.ricardococati.model.dto.CandlestickDiarioDTO;
import com.ricardococati.model.dto.CandlestickSemanalDTO;
import com.ricardococati.model.dto.MediaMovelSimples;
import com.ricardococati.model.dto.MediaMovelSimplesDiario;
import com.ricardococati.model.dto.MediaMovelSimplesSemanal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MediaMovelSimplesConverter {

  public MediaMovelSimplesDiario converterCandlestickDiarioToMediaMovelSimples(
      CandlestickDiarioDTO candlestickDiario) {
    return MediaMovelSimplesDiario
        .builder()
        .dtpreg(candlestickDiario.getDtpreg())
        .mediaMovelSimples(
            MediaMovelSimples
                .builder()
                .codneg(candlestickDiario.getCandlestickDTO().getCodneg())
                .build())
        .build();
  }

  public MediaMovelSimplesSemanal converterCandlestickSemanalToMediaMovelSimples(
      CandlestickSemanalDTO candlestickSemanal) {
    return MediaMovelSimplesSemanal
        .builder()
        .dtpregini(candlestickSemanal.getDtpregini())
        .dtpregfim(candlestickSemanal.getDtpregfim())
        .mediaMovelSimples(
            MediaMovelSimples
                .builder()
                .codneg(candlestickSemanal.getCandlestickDTO().getCodneg())
                .build())
        .build();
  }

}
