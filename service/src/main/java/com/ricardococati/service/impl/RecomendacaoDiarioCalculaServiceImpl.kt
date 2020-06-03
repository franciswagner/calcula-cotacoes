package com.ricardococati.service.impl

import com.ricardococati.model.entities.RecomendacaoDiario
import com.ricardococati.model.enums.Decisao
import com.ricardococati.repository.dao.HistogramaDiarioInserirDAO
import com.ricardococati.repository.dao.MacdDiarioBuscarDAO
import com.ricardococati.repository.dao.MediaMovelExponencialDiarioBuscarDAO
import com.ricardococati.repository.dao.RecomendacaoDiarioBuscarDAO
import com.ricardococati.repository.dao.RecomendacaoDiarioExcluirDAO
import com.ricardococati.repository.dao.RecomendacaoDiarioInserirDAO
import com.ricardococati.repository.dao.SinalMacdDiarioBuscarDAO
import com.ricardococati.service.CalculaService
import com.ricardococati.service.CandlestickDiarioBuscarService
import com.ricardococati.service.RecomendacaoDiarioCalculaService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.ArrayList
import java.util.Objects
import java.util.stream.IntStream

@Service
class RecomendacaoDiarioCalculaServiceImpl(
        val calculaCandlestickService: CandlestickDiarioBuscarService,
        val macdDAO: MacdDiarioBuscarDAO,
        val sinalMacdDAO: SinalMacdDiarioBuscarDAO,
        val histogramaDAO: HistogramaDiarioInserirDAO,
        val buscarRecomendacao: RecomendacaoDiarioBuscarDAO,
        val inserirRecomendacao: RecomendacaoDiarioInserirDAO,
        val excluirRecomendacao: RecomendacaoDiarioExcluirDAO,
        val mediaMovelExponencialDAO: MediaMovelExponencialDiarioBuscarDAO,
        val calculaService: CalculaService
) : RecomendacaoDiarioCalculaService {

    override fun executeByCodNeg(
            listCodneg: List<String>, dtLimitePregao: LocalDate): List<RecomendacaoDiario> {
        excluirRecomendacao.excluirAllRecomendacao()
        val diarioList: MutableList<RecomendacaoDiario> = ArrayList()
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

    private fun incluirRecomendacao(diarioList: List<RecomendacaoDiario>) {
        diarioList
                .stream()
                .filter { obj: RecomendacaoDiario? -> Objects.nonNull(obj) }
                .filter { mmsSemanal: RecomendacaoDiario -> Objects.nonNull(mmsSemanal.dtpreg) }
                .filter { mmsSemanal: RecomendacaoDiario -> Objects.nonNull(mmsSemanal.recomendacao) }
                .filter { mmsSemanal: RecomendacaoDiario -> Objects.nonNull(mmsSemanal.recomendacao!!.codneg) }
                .forEach { recomendacaoDiario: RecomendacaoDiario? -> inserirRecomendacao.incluirRecomendacao(recomendacaoDiario) }
    }

    private fun calculaRecomendacao(
            codneg: String, dtLimitePregao: LocalDate): List<RecomendacaoDiario> {
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
    ): List<RecomendacaoDiario> {
        return buscarRecomendacao.getListRecomendacaoByDtPregECodNeg(
                dtLimitePregao,
                codneg
        )
    }

    override fun toString(): String {
        return ("RecomendacaoDiarioCalculaServiceImpl(calculaCandlestickService=" + calculaCandlestickService + ", macdDAO=" + macdDAO + ", sinalMacdDAO="
                + sinalMacdDAO + ", histogramaDAO=" + histogramaDAO
                + ", buscarRecomendacao=" + buscarRecomendacao + ", inserirRecomendacao=" + inserirRecomendacao + ", excluirRecomendacao=" + excluirRecomendacao
                + ", mediaMovelExponencialDAO=" + mediaMovelExponencialDAO + ", calculaService="
                + calculaService + ")")
    }

    companion object {
        private val log = LoggerFactory
                .getLogger(RecomendacaoDiarioCalculaServiceImpl::class.java)
    }

}