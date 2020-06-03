package com.ricardococati.service.converter

import com.ricardococati.model.entities.CandlestickDiario
import com.ricardococati.model.entities.MediaMovelExponencial
import com.ricardococati.model.entities.MediaMovelExponencialDiario
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class MediaMovelExponencialConverter {

    fun converterCandlestickDiarioToMediaMovelExponencial(
            candlestickDiario: CandlestickDiario): MediaMovelExponencialDiario {
        return MediaMovelExponencialDiario
                .builder()
                .mediaMovelExponencial(
                        MediaMovelExponencial
                                .builder()
                                .codneg(candlestickDiario.candlestick!!.codneg)
                                .build())
                .build()
    }

    companion object {
        private val log = LoggerFactory
                .getLogger(MediaMovelExponencialConverter::class.java)
    }

}