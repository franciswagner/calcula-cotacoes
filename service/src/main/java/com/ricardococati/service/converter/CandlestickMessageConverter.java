package com.ricardococati.service.converter;

import static java.util.Objects.nonNull;

import com.ricardococati.model.entities.Candlestick;
import com.ricardococati.model.entities.CandlestickDiario;
import com.ricardococati.model.entities.CandlestickDiarioMessage;
import com.ricardococati.model.entities.CandlestickSemanal;
import com.ricardococati.model.entities.CandlestickSemanalMessage;
import java.time.LocalDate;
import org.springframework.stereotype.Component;

@Component
public class CandlestickMessageConverter {

  private static final boolean DEFAULT_VALUE = false;

  public CandlestickDiario convert(CandlestickDiarioMessage message) {
    return CandlestickDiario
        .builder()
        .dtpreg(convertStringToLocalDate(message.getDtpreg()))
        .candlestick(
            Candlestick
                .builder()
                .codneg(message.getCodneg())
                .preabe(message.getPreabe())
                .preult(message.getPreult())
                .premin(message.getPremin())
                .premax(message.getPremax())
                .voltot(message.getVoltot())
                .semana(message.getSemana())
                .build())
        .build();
  }

  private LocalDate convertStringToLocalDate(final String date) {
    LocalDate parse = LocalDate.now();
    if (nonNull(date)) {
      parse = LocalDate.parse(date);
    }
    return parse;
  }

  public CandlestickSemanal convertSemanal(CandlestickSemanalMessage message) {
    return CandlestickSemanal
        .builder()
        .dtpregini(convertStringToLocalDate(message.getDtpregini()))
        .dtpregfim(convertStringToLocalDate(message.getDtpregfim()))
        .candlestick(
            Candlestick
                .builder()
                .codneg(message.getCodneg())
                .preabe(message.getPreabe())
                .preult(message.getPreult())
                .premin(message.getPremin())
                .premax(message.getPremax())
                .voltot(message.getVoltot())
                .semana(message.getSemana())
                .build())
        .build();
  }

}
