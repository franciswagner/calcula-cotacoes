package com.ricardococati.service.impl

import com.ricardococati.model.entities.RecomendacaoSemanal
import com.ricardococati.model.enums.Decisao
import com.ricardococati.repository.dao.HistogramaSemanalInserirDAO
import com.ricardococati.repository.dao.MacdSemanalBuscarDAO
import com.ricardococati.repository.dao.MediaMovelExponencialSemanalBuscarDAO
import com.ricardococati.repository.dao.RecomendacaoSemanalBuscarDAO
import com.ricardococati.repository.dao.RecomendacaoSemanalExcluirDAO
import com.ricardococati.repository.dao.RecomendacaoSemanalInserirDAO
import com.ricardococati.repository.dao.SinalMacdSemanalBuscarDAO
import com.ricardococati.service.CalculaService
import com.ricardococati.service.CandlestickSemanalBuscarService
import com.ricardococati.service.RecomendacaoSemanalCalculaService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.ArrayList
import java.util.Objects
import java.util.stream.IntStream

@Service
class RecomendacaoSemanalCalculaServiceImpl(
        val calculaCandlestickService: CandlestickSemanalBuscarService,
        val macdDAO: MacdSemanalBuscarDAO,
        val sinalMacdDAO: SinalMacdSemanalBuscarDAO,
        val histogramaDAO: HistogramaSemanalInserirDAO,
        val buscarRecomendacao: RecomendacaoSemanalBuscarDAO,
        val inserirRecomendacao: RecomendacaoSemanalInserirDAO,
        val excluirRecomendacao: RecomendacaoSemanalExcluirDAO,
        val mediaMovelExponencialDAO: MediaMovelExponencialSemanalBuscarDAO,
        val calculaService: CalculaService
) : RecomendacaoSemanalCalculaService {

    override fun executeByCodNeg(
            listCodneg: List<String>, dtLimitePregao: LocalDate): List<RecomendacaoSemanal> {
        excluirRecomendacao.excluirAllRecomendacao()
        val diarioList: MutableList<RecomendacaoSemanal> = ArrayList()
        log.info("Código de negociação: $listCodneg")
        listCodneg
                .parallelStream()
                .filter { obj: String? -> Objects.nonNull(obj) }
                .forEachOrdered { codneg: String ->
                    diarioList.addAll(calculaRecomendacao(codneg, dtLimitePregao))
                    incluirRecomendacao(diarioList)
                }
        return diarioList
    }

    private fun incluirRecomendacao(semanalList: List<RecomendacaoSemanal>) {
        semanalList
                .stream()
                .filter { obj: RecomendacaoSemanal? -> Objects.nonNull(obj) }
                .filter { mmsSemanal: RecomendacaoSemanal -> Objects.nonNull(mmsSemanal.dtpregini) }
                .filter { mmsSemanal: RecomendacaoSemanal -> Objects.nonNull(mmsSemanal.dtpregfim) }
                .filter { mmsSemanal: RecomendacaoSemanal -> Objects.nonNull(mmsSemanal.recomendacao) }
                .filter { mmsSemanal: RecomendacaoSemanal -> Objects.nonNull(mmsSemanal.recomendacao!!.codneg) }
                .forEach { recomendacaoSemanal: RecomendacaoSemanal? -> inserirRecomendacao.incluirRecomendacao(recomendacaoSemanal) }
    }

    private fun calculaRecomendacao(
            codneg: String, dtLimitePregao: LocalDate): List<RecomendacaoSemanal> {
        val recomendacaoList = buildListRecomendacao(
                codneg,
                dtLimitePregao
        )
        IntStream.range(0, recomendacaoList.size)
                .filter { indice: Int -> indice > 0 && recomendacaoList.size >= 2 }
                .forEach { indice: Int ->
                    if (recomendacaoList[indice - 1].recomendacao!!.precoHistograma
                                    ?.compareTo(recomendacaoList[indice].recomendacao!!.precoHistograma)!! < 0) {
                        recomendacaoList[indice].recomendacao!!.decisao = Decisao.TENDENCIA_ALTA.texto
                    } else if (recomendacaoList[indice - 1].recomendacao!!.precoHistograma
                                    ?.compareTo(recomendacaoList[indice].recomendacao!!.precoHistograma)!! > 0) {
                        recomendacaoList[indice].recomendacao!!.decisao = Decisao.TENDENCIA_BAIXA.texto
                    } else {
                        recomendacaoList[indice].recomendacao!!.decisao = Decisao.CONSOLIDANDO.texto
                    }
                }
        return recomendacaoList
    }

    private fun buildListRecomendacao(
            codneg: String,
            dtLimitePregao: LocalDate
    ): List<RecomendacaoSemanal> {
        return buscarRecomendacao.getListRecomendacaoByDtPregECodNeg(
                dtLimitePregao,
                codneg
        )
    }

    override fun toString(): String {
        return ("RecomendacaoSemanalCalculaServiceImpl(calculaCandlestickService=" + calculaCandlestickService + ", macdDAO=" + macdDAO + ", sinalMacdDAO="
                + sinalMacdDAO + ", histogramaDAO=" + histogramaDAO
                + ", buscarRecomendacao=" + buscarRecomendacao + ", inserirRecomendacao=" + inserirRecomendacao + ", excluirRecomendacao=" + excluirRecomendacao
                + ", mediaMovelExponencialDAO=" + mediaMovelExponencialDAO + ", calculaService="
                + calculaService + ")")
    }

    companion object {
        private val log = LoggerFactory
                .getLogger(RecomendacaoSemanalCalculaServiceImpl::class.java)
    }

}