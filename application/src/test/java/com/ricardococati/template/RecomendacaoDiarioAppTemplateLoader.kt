package com.ricardococati.template

import br.com.six2six.fixturefactory.Fixture
import br.com.six2six.fixturefactory.Rule
import br.com.six2six.fixturefactory.loader.TemplateLoader
import com.ricardococati.model.entities.Recomendacao
import com.ricardococati.model.entities.RecomendacaoDiario
import java.time.LocalDate

class RecomendacaoDiarioAppTemplateLoader : TemplateLoader {
    override fun load() {
        Fixture.of(RecomendacaoDiario::class.java)
                .addTemplate(RECOMENDACAO_DIARIO_VALID_001,
                        object : Rule() {
                            init {
                                add("idRecomendacaoDiario", random(Long::class.java, range(1L, 200L)))
                                add("dtpreg", LocalDate.of(1978, 2, 16))
                                add("recomendacao", one(Recomendacao::class.java, RecomendacaoTemplateLoader.RECOMENDACAO_VALID_001))
                            }
                        })
                .addTemplate(RECOMENDACAO_DIARIO_VALID_002, object : Rule() {
                    init {
                        add("idRecomendacaoDiario", random(Long::class.java, range(1L, 200L)))
                        add("dtpreg", LocalDate.of(1978, 2, 17))
                        add("recomendacao", one(Recomendacao::class.java, RecomendacaoTemplateLoader.RECOMENDACAO_VALID_002))
                    }
                })
                .addTemplate(RECOMENDACAO_DIARIO_VALID_003, object : Rule() {
                    init {
                        add("idRecomendacaoDiario", random(Long::class.java, range(1L, 200L)))
                        add("dtpreg", LocalDate.of(1978, 2, 18))
                        add("recomendacao", one(Recomendacao::class.java, RecomendacaoTemplateLoader.RECOMENDACAO_VALID_003))
                    }
                })
                .addTemplate(RECOMENDACAO_DIARIO_VALID_004, object : Rule() {
                    init {
                        add("idRecomendacaoDiario", random(Long::class.java, range(1L, 200L)))
                        add("dtpreg", LocalDate.of(1978, 2, 19))
                        add("recomendacao", one(Recomendacao::class.java, RecomendacaoTemplateLoader.RECOMENDACAO_VALID_004))
                    }
                })
                .addTemplate(RECOMENDACAO_DIARIO_VALID_005, object : Rule() {
                    init {
                        add("idRecomendacaoDiario", random(Long::class.java, range(1L, 200L)))
                        add("dtpreg", LocalDate.of(1978, 2, 20))
                        add("recomendacao", one(Recomendacao::class.java, RecomendacaoTemplateLoader.RECOMENDACAO_VALID_005))
                    }
                })
                .addTemplate(RECOMENDACAO_DIARIO_VALID_006, object : Rule() {
                    init {
                        add("idRecomendacaoDiario", random(Long::class.java, range(1L, 200L)))
                        add("dtpreg", LocalDate.of(1978, 2, 21))
                        add("recomendacao", one(Recomendacao::class.java, RecomendacaoTemplateLoader.RECOMENDACAO_VALID_006))
                    }
                })
                .addTemplate(RECOMENDACAO_DIARIO_VALID_007, object : Rule() {
                    init {
                        add("idRecomendacaoDiario", random(Long::class.java, range(1L, 200L)))
                        add("dtpreg", LocalDate.of(1978, 2, 22))
                        add("recomendacao", one(Recomendacao::class.java, RecomendacaoTemplateLoader.RECOMENDACAO_VALID_007))
                    }
                })
                .addTemplate(RECOMENDACAO_DIARIO_VALID_008, object : Rule() {
                    init {
                        add("idRecomendacaoDiario", random(Long::class.java, range(1L, 200L)))
                        add("dtpreg", LocalDate.of(1978, 2, 23))
                        add("recomendacao", one(Recomendacao::class.java, RecomendacaoTemplateLoader.RECOMENDACAO_VALID_008))
                    }
                })
                .addTemplate(RECOMENDACAO_DIARIO_VALID_009, object : Rule() {
                    init {
                        add("idRecomendacaoDiario", random(Long::class.java, range(1L, 200L)))
                        add("dtpreg", LocalDate.of(1978, 2, 24))
                        add("recomendacao", one(Recomendacao::class.java, RecomendacaoTemplateLoader.RECOMENDACAO_VALID_009))
                    }
                })
                .addTemplate(RECOMENDACAO_DIARIO_VALID_010, object : Rule() {
                    init {
                        add("idRecomendacaoDiario", random(Long::class.java, range(1L, 200L)))
                        add("dtpreg", LocalDate.of(1978, 2, 25))
                        add("recomendacao", one(Recomendacao::class.java, RecomendacaoTemplateLoader.RECOMENDACAO_VALID_010))
                    }
                })
                .addTemplate(RECOMENDACAO_DIARIO_VALID_011, object : Rule() {
                    init {
                        add("idRecomendacaoDiario", random(Long::class.java, range(1L, 200L)))
                        add("dtpreg", LocalDate.of(1978, 2, 26))
                        add("recomendacao", one(Recomendacao::class.java, RecomendacaoTemplateLoader.RECOMENDACAO_VALID_011))
                    }
                })
    }

    companion object {
        const val RECOMENDACAO_DIARIO_VALID_001 = "RECOMENDACAO_DIARIO_VALID_001"
        const val RECOMENDACAO_DIARIO_VALID_002 = "RECOMENDACAO_DIARIO_VALID_002"
        const val RECOMENDACAO_DIARIO_VALID_003 = "RECOMENDACAO_DIARIO_VALID_003"
        const val RECOMENDACAO_DIARIO_VALID_004 = "RECOMENDACAO_DIARIO_VALID_004"
        const val RECOMENDACAO_DIARIO_VALID_005 = "RECOMENDACAO_DIARIO_VALID_005"
        const val RECOMENDACAO_DIARIO_VALID_006 = "RECOMENDACAO_DIARIO_VALID_006"
        const val RECOMENDACAO_DIARIO_VALID_007 = "RECOMENDACAO_DIARIO_VALID_007"
        const val RECOMENDACAO_DIARIO_VALID_008 = "RECOMENDACAO_DIARIO_VALID_008"
        const val RECOMENDACAO_DIARIO_VALID_009 = "RECOMENDACAO_DIARIO_VALID_009"
        const val RECOMENDACAO_DIARIO_VALID_010 = "RECOMENDACAO_DIARIO_VALID_010"
        const val RECOMENDACAO_DIARIO_VALID_011 = "RECOMENDACAO_DIARIO_VALID_011"
    }
}