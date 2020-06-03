package com.ricardococati.service.impl

import com.ricardococati.model.entities.ControleExecucao
import com.ricardococati.model.entities.MacdDiario
import com.ricardococati.model.entities.MacdSemanal
import com.ricardococati.repository.dao.CandlestickDiarioBuscarDAO
import com.ricardococati.repository.dao.CandlestickSemanalBuscarDAO
import com.ricardococati.repository.dao.ControleExecucaoDAO
import com.ricardococati.repository.dao.MacdDiarioBuscarDAO
import com.ricardococati.repository.dao.MacdSemanalBuscarDAO
import com.ricardococati.repository.dao.MediaMovelExponencialDiarioBuscarDAO
import com.ricardococati.service.CalculaService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class CalculaServiceImpl(val diarioDAO: CandlestickDiarioBuscarDAO,
                         val semanalDAO: CandlestickSemanalBuscarDAO,
                         val macdDiarioBuscarDAO: MacdDiarioBuscarDAO,
                         val macdSemanalBuscarDAO: MacdSemanalBuscarDAO,
                         val mediaExponencialDAO: MediaMovelExponencialDiarioBuscarDAO,
                         val execucaoDAO: ControleExecucaoDAO
) : CalculaService {

    override fun listMacdDiarioByCodNeg(codneg: String): List<MacdDiario> {
        return macdDiarioBuscarDAO.listMacdByCodNeg(codneg)
    }

    override fun listMacdSemanalByCodNeg(codneg: String): List<MacdSemanal> {
        return macdSemanalBuscarDAO.listMacdByCodNeg(codneg)
    }

    override fun carregaControleExecucao(): ControleExecucao {
        return execucaoDAO.loadControleExecucao()
    }

    override fun updateControleExecucaoDiario(controleExecucao: ControleExecucao): Boolean {
        return execucaoDAO.updateControleExecucaoDiario(controleExecucao)
    }

    override fun updateControleExecucaoSemanal(controleExecucao: ControleExecucao): Boolean {
        return execucaoDAO.updateControleExecucaoSemanal(controleExecucao)
    }

    override fun toString(): String {
        return ("CalculaServiceImpl(diarioDAO=" + diarioDAO + ", semanalDAO=" + semanalDAO + ", macdDiarioBuscarDAO=" + macdDiarioBuscarDAO
                + ", macdSemanalBuscarDAO=" + macdSemanalBuscarDAO + ", mediaExponencialDAO="
                + mediaExponencialDAO + ", execucaoDAO=" + execucaoDAO + ")")
    }

    companion object {
        private val log = LoggerFactory.getLogger(CalculaServiceImpl::class.java)
    }

}