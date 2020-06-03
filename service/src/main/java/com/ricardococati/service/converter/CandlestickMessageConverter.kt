package com.ricardococati.service.converter

import com.ricardococati.model.entities.Candlestick
import com.ricardococati.model.entities.CandlestickDiario
import com.ricardococati.model.entities.CandlestickDiarioMessage
import com.ricardococati.model.entities.CandlestickSemanal
import com.ricardococati.model.entities.CandlestickSemanalMessage
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.util.Objects

@Component
class CandlestickMessageConverter {

    fun convert(message: CandlestickDiarioMessage): CandlestickDiario {
        return CandlestickDiario
                .builder()
                .dtpreg(convertStringToLocalDate(message.dtpreg))
                .candlestick(
                        Candlestick
                                .builder()
                                .codneg(message.codneg)
                                .preabe(message.preabe)
                                .preult(message.preult)
                                .premin(message.premin)
                                .premax(message.premax)
                                .voltot(message.voltot)
                                .semana(message.semana)
                                .build())
                .build()
    }

    private fun convertStringToLocalDate(date: String?): LocalDate {
        var parse = LocalDate.now()
        if (Objects.nonNull(date)) {
            parse = LocalDate.parse(date)
        }
        return parse
    }

    fun convertSemanal(message: CandlestickSemanalMessage): CandlestickSemanal {
        return CandlestickSemanal
                .builder()
                .dtpregini(convertStringToLocalDate(message.dtpregini))
                .dtpregfim(convertStringToLocalDate(message.dtpregfim))
                .candlestick(
                        Candlestick
                                .builder()
                                .codneg(message.codneg)
                                .preabe(message.preabe)
                                .preult(message.preult)
                                .premin(message.premin)
                                .premax(message.premax)
                                .voltot(message.voltot)
                                .semana(message.semana)
                                .build())
                .build()
    }

    companion object {
        private const val DEFAULT_VALUE = false
    }

}