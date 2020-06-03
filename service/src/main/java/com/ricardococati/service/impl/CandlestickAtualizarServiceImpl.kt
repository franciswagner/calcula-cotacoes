package com.ricardococati.service.impl

import com.ricardococati.model.entities.SplitInplit
import com.ricardococati.repository.dao.CandlestickDiarioAtualizarDAO
import com.ricardococati.repository.dao.CandlestickSemanalAtualizarDAO
import com.ricardococati.service.CandlestickAtualizarService
import org.springframework.stereotype.Service

@Service
class CandlestickAtualizarServiceImpl(
        private val atualizarDiarioDAO: CandlestickDiarioAtualizarDAO,
        private val atualizarSemanalDAO: CandlestickSemanalAtualizarDAO
) : CandlestickAtualizarService {

    override fun executeSplitInplit(splitInplit: SplitInplit): Boolean {
        var retorno = atualizarDiarioDAO.atualizaSplitInplit(splitInplit)
        if (retorno) {
            retorno = atualizarSemanalDAO.atualizaSplitInplit(splitInplit)
        }
        return retorno
    }

}