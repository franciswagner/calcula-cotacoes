package com.ricardococati.controller.converter

import com.ricardococati.model.entities.SplitInplit
import com.ricardococati.model.enums.OperacaoSplitInplit
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class SplitInplitConverter {

    fun convert(
            dtPregao: LocalDate?,
            codneg: String?,
            qtdSplitInplit: Int?,
            operacao: String): SplitInplit {
        return SplitInplit
                .builder()
                .codneg(codneg)
                .dtpreg(dtPregao)
                .qtdSplitInplit(qtdSplitInplit)
                .operacao(OperacaoSplitInplit.valueOf(operacao.toUpperCase()))
                .build()
    }

}