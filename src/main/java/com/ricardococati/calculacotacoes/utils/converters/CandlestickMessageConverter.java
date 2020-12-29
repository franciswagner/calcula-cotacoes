package com.ricardococati.calculacotacoes.utils.converters;

import static java.util.Objects.nonNull;

import com.ricardococati.calculacotacoes.entities.domains.candlestick.Candlestick;
import com.ricardococati.calculacotacoes.entities.domains.candlestick.CandlestickDiario;
import com.ricardococati.calculacotacoes.entities.domains.candlestick.CandlestickDiarioMessage;
import com.ricardococati.calculacotacoes.entities.domains.candlestick.CandlestickSemanal;
import com.ricardococati.calculacotacoes.entities.domains.candlestick.CandlestickSemanalMessage;
import java.time.LocalDate;
import org.springframework.stereotype.Component;

@Component
public class CandlestickMessageConverter {

  private static final boolean DEFAULT_VALUE = false;

  public CandlestickDiario convert(final CandlestickDiarioMessage message) {
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

  public CandlestickSemanal convertSemanal(final CandlestickSemanalMessage message) {
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
