package com.ricardococati.service.converter

import com.ricardococati.model.entities.CandlestickDiario
import com.ricardococati.model.entities.CandlestickSemanal
import com.ricardococati.model.entities.MediaMovelSimples
import com.ricardococati.model.entities.MediaMovelSimplesDiario
import com.ricardococati.model.entities.MediaMovelSimplesSemanal
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class MediaMovelSimplesConverter {

    fun converterCandlestickDiarioToMediaMovelSimples(
            candlestickDiario: CandlestickDiario): MediaMovelSimplesDiario {
        return MediaMovelSimplesDiario
                .builder()
                .dtpreg(candlestickDiario.dtpreg)
                .mediaMovelSimples(
                        MediaMovelSimples
                                .builder()
                                .codneg(candlestickDiario.candlestick!!.codneg)
                                .build())
                .build()
    }

    fun converterCandlestickSemanalToMediaMovelSimples(
            candlestickSemanal: CandlestickSemanal): MediaMovelSimplesSemanal {
        return MediaMovelSimplesSemanal
                .builder()
                .dtpregini(candlestickSemanal.dtpregini)
                .dtpregfim(candlestickSemanal.dtpregfim)
                .mediaMovelSimples(
                        MediaMovelSimples
                                .builder()
                                .codneg(candlestickSemanal.candlestick!!.codneg)
                                .build())
                .build()
    }

    companion object {
        private val log = LoggerFactory
                .getLogger(MediaMovelSimplesConverter::class.java)
    }

}