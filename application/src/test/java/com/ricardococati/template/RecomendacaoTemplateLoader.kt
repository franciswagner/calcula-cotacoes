package com.ricardococati.template

import br.com.six2six.fixturefactory.Fixture
import br.com.six2six.fixturefactory.Rule
import br.com.six2six.fixturefactory.loader.TemplateLoader
import com.ricardococati.model.entities.Recomendacao
import com.ricardococati.repository.util.BigDecimalCustomizado

class RecomendacaoTemplateLoader : TemplateLoader {
    override fun load() {
        Fixture.of(Recomendacao::class.java)
                .addTemplate(RECOMENDACAO_VALID_001,
                        object : Rule() {
                            init {
                                add("codneg", "MGLU3")
                                add("precoFechamento", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(11.11))
                                add("precoMME12p", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(11.75))
                                add("precoMME26p", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(12.36))
                                add("precoMacd", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(-0.61))
                                add("precoSinalMacd", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(-0.48))
                                add("precoHistograma", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(-0.13))
                                add("decisao", "VENDE")
                            }
                        })
                .addTemplate(RECOMENDACAO_VALID_002).inherits(RECOMENDACAO_VALID_001,
                        object : Rule() {
                            init {
                                add("precoFechamento", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(11.05))
                                add("precoMME12p", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(11.64))
                                add("precoMME26p", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(12.27))
                                add("precoMacd", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(-0.63))
                                add("precoSinalMacd", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(-0.51))
                                add("precoHistograma", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(-0.12))
                            }
                        })
                .addTemplate(RECOMENDACAO_VALID_003).inherits(RECOMENDACAO_VALID_001,
                        object : Rule() {
                            init {
                                add("precoFechamento", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(11.05))
                                add("precoMME12p", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(11.64))
                                add("precoMME26p", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(12.27))
                                add("precoMacd", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(-0.63))
                                add("precoSinalMacd", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(-0.51))
                                add("precoHistograma", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(-0.12))
                            }
                        })
                .addTemplate(RECOMENDACAO_VALID_004).inherits(RECOMENDACAO_VALID_001,
                        object : Rule() {
                            init {
                                add("precoFechamento", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(11.05))
                                add("precoMME12p", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(11.64))
                                add("precoMME26p", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(12.27))
                                add("precoMacd", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(-0.63))
                                add("precoSinalMacd", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(-0.51))
                                add("precoHistograma", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(-0.12))
                            }
                        })
                .addTemplate(RECOMENDACAO_VALID_005).inherits(RECOMENDACAO_VALID_001,
                        object : Rule() {
                            init {
                                add("precoFechamento", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(11.05))
                                add("precoMME12p", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(11.64))
                                add("precoMME26p", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(12.27))
                                add("precoMacd", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(-0.63))
                                add("precoSinalMacd", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(-0.51))
                                add("precoHistograma", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(-0.12))
                            }
                        })
                .addTemplate(RECOMENDACAO_VALID_006).inherits(RECOMENDACAO_VALID_001,
                        object : Rule() {
                            init {
                                add("precoFechamento", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(11.05))
                                add("precoMME12p", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(11.64))
                                add("precoMME26p", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(12.27))
                                add("precoMacd", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(-0.63))
                                add("precoSinalMacd", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(-0.51))
                                add("precoHistograma", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(-0.12))
                            }
                        })
                .addTemplate(RECOMENDACAO_VALID_007).inherits(RECOMENDACAO_VALID_001,
                        object : Rule() {
                            init {
                                add("precoFechamento", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(11.05))
                                add("precoMME12p", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(11.64))
                                add("precoMME26p", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(12.27))
                                add("precoMacd", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(-0.63))
                                add("precoSinalMacd", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(-0.51))
                                add("precoHistograma", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(-0.12))
                            }
                        })
                .addTemplate(RECOMENDACAO_VALID_007).inherits(RECOMENDACAO_VALID_001,
                        object : Rule() {
                            init {
                                add("precoFechamento", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(11.05))
                                add("precoMME12p", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(11.64))
                                add("precoMME26p", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(12.27))
                                add("precoMacd", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(-0.63))
                                add("precoSinalMacd", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(-0.51))
                                add("precoHistograma", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(-0.12))
                            }
                        })
                .addTemplate(RECOMENDACAO_VALID_008).inherits(RECOMENDACAO_VALID_001,
                        object : Rule() {
                            init {
                                add("precoFechamento", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(11.05))
                                add("precoMME12p", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(11.64))
                                add("precoMME26p", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(12.27))
                                add("precoMacd", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(-0.63))
                                add("precoSinalMacd", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(-0.51))
                                add("precoHistograma", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(-0.12))
                            }
                        })
                .addTemplate(RECOMENDACAO_VALID_009).inherits(RECOMENDACAO_VALID_001,
                        object : Rule() {
                            init {
                                add("precoFechamento", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(11.05))
                                add("precoMME12p", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(11.64))
                                add("precoMME26p", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(12.27))
                                add("precoMacd", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(-0.63))
                                add("precoSinalMacd", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(-0.51))
                                add("precoHistograma", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(-0.12))
                            }
                        })
                .addTemplate(RECOMENDACAO_VALID_010).inherits(RECOMENDACAO_VALID_001,
                        object : Rule() {
                            init {
                                add("precoFechamento", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(11.05))
                                add("precoMME12p", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(11.64))
                                add("precoMME26p", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(12.27))
                                add("precoMacd", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(-0.63))
                                add("precoSinalMacd", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(-0.51))
                                add("precoHistograma", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(-0.12))
                            }
                        })
                .addTemplate(RECOMENDACAO_VALID_011).inherits(RECOMENDACAO_VALID_001,
                        object : Rule() {
                            init {
                                add("precoFechamento", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(11.05))
                                add("precoMME12p", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(11.64))
                                add("precoMME26p", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(12.27))
                                add("precoMacd", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(-0.63))
                                add("precoSinalMacd", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(-0.51))
                                add("precoHistograma", BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas(-0.12))
                            }
                        })
    }

    companion object {
        const val RECOMENDACAO_VALID_001 = "RECOMENDACAO_VALID_001"
        const val RECOMENDACAO_VALID_002 = "RECOMENDACAO_VALID_002"
        const val RECOMENDACAO_VALID_003 = "RECOMENDACAO_VALID_003"
        const val RECOMENDACAO_VALID_004 = "RECOMENDACAO_VALID_004"
        const val RECOMENDACAO_VALID_005 = "RECOMENDACAO_VALID_005"
        const val RECOMENDACAO_VALID_006 = "RECOMENDACAO_VALID_006"
        const val RECOMENDACAO_VALID_007 = "RECOMENDACAO_VALID_007"
        const val RECOMENDACAO_VALID_008 = "RECOMENDACAO_VALID_008"
        const val RECOMENDACAO_VALID_009 = "RECOMENDACAO_VALID_009"
        const val RECOMENDACAO_VALID_010 = "RECOMENDACAO_VALID_010"
        const val RECOMENDACAO_VALID_011 = "RECOMENDACAO_VALID_011"
    }
}