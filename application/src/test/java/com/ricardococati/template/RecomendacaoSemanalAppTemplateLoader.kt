package com.ricardococati.template

import br.com.six2six.fixturefactory.Fixture
import br.com.six2six.fixturefactory.Rule
import br.com.six2six.fixturefactory.loader.TemplateLoader
import com.ricardococati.model.entities.Recomendacao
import com.ricardococati.model.entities.RecomendacaoSemanal
import java.time.LocalDate

class RecomendacaoSemanalAppTemplateLoader : TemplateLoader {
    private val localDate = LocalDate.of(1978, 2, 15)
    override fun load() {
        Fixture.of(RecomendacaoSemanal::class.java)
                .addTemplate(RECOMENDACAO_SEMANAL_VALID_001,
                        object : Rule() {
                            init {
                                add("idRecomendacaoSemanal", random(Long::class.java, range(1L, 200L)))
                                add("dtpregini", localDate.plusDays(1))
                                add("dtpregfim", localDate.plusDays(2))
                                add("recomendacao", one(Recomendacao::class.java, RecomendacaoTemplateLoader.RECOMENDACAO_VALID_001))
                            }
                        })
                .addTemplate(RECOMENDACAO_SEMANAL_VALID_002, object : Rule() {
                    init {
                        add("idRecomendacaoSemanal", random(Long::class.java, range(1L, 200L)))
                        add("dtpregini", localDate.plusDays(3))
                        add("dtpregfim", localDate.plusDays(4))
                        add("recomendacao", one(Recomendacao::class.java, RecomendacaoTemplateLoader.RECOMENDACAO_VALID_002))
                    }
                })
                .addTemplate(RECOMENDACAO_SEMANAL_VALID_003, object : Rule() {
                    init {
                        add("idRecomendacaoSemanal", random(Long::class.java, range(1L, 200L)))
                        add("dtpregini", localDate.plusDays(5))
                        add("dtpregfim", localDate.plusDays(6))
                        add("recomendacao", one(Recomendacao::class.java, RecomendacaoTemplateLoader.RECOMENDACAO_VALID_003))
                    }
                })
                .addTemplate(RECOMENDACAO_SEMANAL_VALID_004, object : Rule() {
                    init {
                        add("idRecomendacaoSemanal", random(Long::class.java, range(1L, 200L)))
                        add("dtpregini", localDate.plusDays(7))
                        add("dtpregfim", localDate.plusDays(8))
                        add("recomendacao", one(Recomendacao::class.java, RecomendacaoTemplateLoader.RECOMENDACAO_VALID_004))
                    }
                })
                .addTemplate(RECOMENDACAO_SEMANAL_VALID_005, object : Rule() {
                    init {
                        add("idRecomendacaoSemanal", random(Long::class.java, range(1L, 200L)))
                        add("dtpregini", localDate.plusDays(9))
                        add("dtpregfim", localDate.plusDays(10))
                        add("recomendacao", one(Recomendacao::class.java, RecomendacaoTemplateLoader.RECOMENDACAO_VALID_005))
                    }
                })
                .addTemplate(RECOMENDACAO_SEMANAL_VALID_006, object : Rule() {
                    init {
                        add("idRecomendacaoSemanal", random(Long::class.java, range(1L, 200L)))
                        add("dtpregini", localDate.plusDays(11))
                        add("dtpregfim", localDate.plusDays(12))
                        add("recomendacao", one(Recomendacao::class.java, RecomendacaoTemplateLoader.RECOMENDACAO_VALID_006))
                    }
                })
                .addTemplate(RECOMENDACAO_SEMANAL_VALID_007, object : Rule() {
                    init {
                        add("idRecomendacaoSemanal", random(Long::class.java, range(1L, 200L)))
                        add("dtpregini", localDate.plusDays(13))
                        add("dtpregfim", localDate.plusDays(14))
                        add("recomendacao", one(Recomendacao::class.java, RecomendacaoTemplateLoader.RECOMENDACAO_VALID_007))
                    }
                })
                .addTemplate(RECOMENDACAO_SEMANAL_VALID_008, object : Rule() {
                    init {
                        add("idRecomendacaoSemanal", random(Long::class.java, range(1L, 200L)))
                        add("dtpregini", localDate.plusDays(15))
                        add("dtpregfim", localDate.plusDays(16))
                        add("recomendacao", one(Recomendacao::class.java, RecomendacaoTemplateLoader.RECOMENDACAO_VALID_008))
                    }
                })
                .addTemplate(RECOMENDACAO_SEMANAL_VALID_009, object : Rule() {
                    init {
                        add("idRecomendacaoSemanal", random(Long::class.java, range(1L, 200L)))
                        add("dtpregini", localDate.plusDays(17))
                        add("dtpregfim", localDate.plusDays(18))
                        add("recomendacao", one(Recomendacao::class.java, RecomendacaoTemplateLoader.RECOMENDACAO_VALID_009))
                    }
                })
                .addTemplate(RECOMENDACAO_SEMANAL_VALID_010, object : Rule() {
                    init {
                        add("idRecomendacaoSemanal", random(Long::class.java, range(1L, 200L)))
                        add("dtpregini", localDate.plusDays(19))
                        add("dtpregfim", localDate.plusDays(20))
                        add("recomendacao", one(Recomendacao::class.java, RecomendacaoTemplateLoader.RECOMENDACAO_VALID_010))
                    }
                })
                .addTemplate(RECOMENDACAO_SEMANAL_VALID_011, object : Rule() {
                    init {
                        add("idRecomendacaoSemanal", random(Long::class.java, range(1L, 200L)))
                        add("dtpregini", localDate.plusDays(21))
                        add("dtpregfim", localDate.plusDays(22))
                        add("recomendacao", one(Recomendacao::class.java, RecomendacaoTemplateLoader.RECOMENDACAO_VALID_011))
                    }
                })
    }

    companion object {
        const val RECOMENDACAO_SEMANAL_VALID_001 = "RECOMENDACAO_SEMANAL_VALID_001"
        const val RECOMENDACAO_SEMANAL_VALID_002 = "RECOMENDACAO_SEMANAL_VALID_002"
        const val RECOMENDACAO_SEMANAL_VALID_003 = "RECOMENDACAO_SEMANAL_VALID_003"
        const val RECOMENDACAO_SEMANAL_VALID_004 = "RECOMENDACAO_SEMANAL_VALID_004"
        const val RECOMENDACAO_SEMANAL_VALID_005 = "RECOMENDACAO_SEMANAL_VALID_005"
        const val RECOMENDACAO_SEMANAL_VALID_006 = "RECOMENDACAO_SEMANAL_VALID_006"
        const val RECOMENDACAO_SEMANAL_VALID_007 = "RECOMENDACAO_SEMANAL_VALID_007"
        const val RECOMENDACAO_SEMANAL_VALID_008 = "RECOMENDACAO_SEMANAL_VALID_008"
        const val RECOMENDACAO_SEMANAL_VALID_009 = "RECOMENDACAO_SEMANAL_VALID_009"
        const val RECOMENDACAO_SEMANAL_VALID_010 = "RECOMENDACAO_SEMANAL_VALID_010"
        const val RECOMENDACAO_SEMANAL_VALID_011 = "RECOMENDACAO_SEMANAL_VALID_011"
    }
}