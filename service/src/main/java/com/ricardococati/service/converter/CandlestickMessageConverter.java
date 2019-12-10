package com.ricardococati.service.converter;

import static java.util.Objects.nonNull;

import com.ricardococati.model.dto.CandlestickDTO;
import com.ricardococati.model.dto.CandlestickDiarioDTO;
import com.ricardococati.model.dto.CandlestickDiarioMessage;
import com.ricardococati.model.dto.CandlestickSemanalDTO;
import com.ricardococati.model.dto.CandlestickSemanalMessage;
import java.time.LocalDate;
import org.springframework.stereotype.Component;

@Component
public class CandlestickMessageConverter {

  private static final boolean DEFAULT_VALUE = false;

  public CandlestickDiarioDTO convert(CandlestickDiarioMessage message) {
    return CandlestickDiarioDTO
        .builder()
        .dtpreg(convertStringToLocalDate(message.getDtpreg()))
        .candlestickDTO(
            CandlestickDTO
                .builder()
                .codneg(message.getCodneg())
                .preabe(message.getPreabe())
                .preult(message.getPreult())
                .premin(message.getPremin())
                .premax(message.getPremax())
                .voltot(message.getVoltot())
                .semana(message.getSemana())
                .mediaMovelGerada(DEFAULT_VALUE)
                .mediaExponencialGerada(DEFAULT_VALUE)
                .macdGerada(DEFAULT_VALUE)
                .sinalMacdGerada(DEFAULT_VALUE)
                .histogramaGerada(DEFAULT_VALUE)
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

  public CandlestickSemanalDTO convertSemanal(CandlestickSemanalMessage message) {
    return CandlestickSemanalDTO
        .builder()
        .dtpregini(convertStringToLocalDate(message.getDtpregini()))
        .dtpregfim(convertStringToLocalDate(message.getDtpregfim()))
        .candlestickDTO(
            CandlestickDTO
                .builder()
                .codneg(message.getCodneg())
                .preabe(message.getPreabe())
                .preult(message.getPreult())
                .premin(message.getPremin())
                .premax(message.getPremax())
                .voltot(message.getVoltot())
                .semana(message.getSemana())
                .mediaMovelGerada(DEFAULT_VALUE)
                .mediaExponencialGerada(DEFAULT_VALUE)
                .macdGerada(DEFAULT_VALUE)
                .sinalMacdGerada(DEFAULT_VALUE)
                .histogramaGerada(DEFAULT_VALUE)
                .build())
        .build();
  }

}
