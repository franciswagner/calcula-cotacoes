package com.ricardococati.controller

import br.com.six2six.fixturefactory.Fixture
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader
import com.ricardococati.model.entities.RecomendacaoDiario
import com.ricardococati.model.entities.RecomendacaoSemanal
import com.ricardococati.service.CalculaGeralDiarioService
import com.ricardococati.service.CalculaGeralSemanalService
import com.ricardococati.template.RecomendacaoDiarioAppTemplateLoader
import com.ricardococati.template.RecomendacaoSemanalAppTemplateLoader
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Matchers
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.util.*

@RunWith(SpringRunner::class)
@WebMvcTest(controllers = [CalculaController::class])
@AutoConfigureMockMvc(addFilters = false)
class CalculaControllerTest {
    @MockBean
    private val geralDiarioService: CalculaGeralDiarioService? = null

    @MockBean
    private val geralSemanalService: CalculaGeralSemanalService? = null

    @Autowired
    private val mockMvc: MockMvc? = null

    @Before
    fun setUp() {
        FixtureFactoryLoader.loadTemplates("com.ricardococati.template")
    }

    @Test
    @Throws(Exception::class)
    fun calculaCodNeg() {
        //given
        Mockito.`when`(geralDiarioService!!.executeByCodNeg(Matchers.any(), Matchers.any()))
                .thenReturn(recomendacaoDiarioList())
        val codneg = Arrays.asList("MGLU3", "BPAN4")
        val dtPregao = "16-02-1978"
        //when
        val result = mockMvc
                ?.perform(
                        MockMvcRequestBuilders.post(String.format("/api/v1/calcula/geral-diario"))
                                .param("codneg", codneg.toString())
                                .param("dtLimitePregao", dtPregao)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
        //then
        result
                ?.andExpect(MockMvcResultMatchers.status().isOk)
                ?.andExpect(MockMvcResultMatchers.jsonPath("$[0].dtpreg", org.hamcrest.Matchers.`is`("1978-02-16")))
                ?.andExpect(MockMvcResultMatchers.jsonPath("$[0].recomendacao.codneg", org.hamcrest.Matchers.`is`("MGLU3")))
                ?.andExpect(MockMvcResultMatchers.jsonPath("$[0].recomendacao.precoFechamento", org.hamcrest.Matchers.`is`(11.1100)))
                ?.andExpect(MockMvcResultMatchers.jsonPath("$[0].recomendacao.precoMME12p", org.hamcrest.Matchers.`is`(11.7500)))
                ?.andExpect(MockMvcResultMatchers.jsonPath("$[0].recomendacao.precoMME26p", org.hamcrest.Matchers.`is`(12.3600)))
                ?.andExpect(MockMvcResultMatchers.jsonPath("$[0].recomendacao.precoMacd", org.hamcrest.Matchers.`is`(-0.6100)))
                ?.andExpect(MockMvcResultMatchers.jsonPath("$[0].recomendacao.precoSinalMacd", org.hamcrest.Matchers.`is`(-0.4800)))
                ?.andExpect(MockMvcResultMatchers.jsonPath("$[0].recomendacao.precoHistograma", org.hamcrest.Matchers.`is`(-0.1300)))
                ?.andExpect(MockMvcResultMatchers.jsonPath("$[0].recomendacao.decisao", org.hamcrest.Matchers.`is`("VENDE")))
                ?.andExpect(MockMvcResultMatchers.jsonPath("$[2].dtpreg", org.hamcrest.Matchers.`is`("1978-02-18")))
                ?.andExpect(MockMvcResultMatchers.jsonPath("$[2].recomendacao.codneg", org.hamcrest.Matchers.`is`("MGLU3")))
                ?.andExpect(MockMvcResultMatchers.jsonPath("$[2].recomendacao.precoFechamento", org.hamcrest.Matchers.`is`(11.0500)))
                ?.andExpect(MockMvcResultMatchers.jsonPath("$[2].recomendacao.precoMME12p", org.hamcrest.Matchers.`is`(11.6400)))
                ?.andExpect(MockMvcResultMatchers.jsonPath("$[2].recomendacao.precoMME26p", org.hamcrest.Matchers.`is`(12.2700)))
                ?.andExpect(MockMvcResultMatchers.jsonPath("$[2].recomendacao.precoMacd", org.hamcrest.Matchers.`is`(-0.6300)))
                ?.andExpect(MockMvcResultMatchers.jsonPath("$[2].recomendacao.precoSinalMacd", org.hamcrest.Matchers.`is`(-0.5100)))
                ?.andExpect(MockMvcResultMatchers.jsonPath("$[2].recomendacao.precoHistograma", org.hamcrest.Matchers.`is`(-0.1200)))
                ?.andExpect(MockMvcResultMatchers.jsonPath("$[2].recomendacao.decisao", org.hamcrest.Matchers.`is`("VENDE")))
    }

    @Test
    @Throws(Exception::class)
    fun calculaCodNegSemanal() {
        //given
        Mockito.`when`(geralSemanalService!!.executeByCodNeg(Matchers.any(), Matchers.any()))
                .thenReturn(recomendacaoSemanalList())
        val codneg = Arrays.asList("MGLU3", "BPAN4")
        val dtPregao = "16-02-1978"
        //when
        val result = mockMvc
                ?.perform(
                        MockMvcRequestBuilders.post(String.format("/api/v1/calcula/geral-semanal"))
                                .param("codneg", codneg.toString())
                                .param("dtLimitePregao", dtPregao)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
        //then
        result
                ?.andExpect(MockMvcResultMatchers.status().isOk)
                ?.andExpect(MockMvcResultMatchers.jsonPath("$[0].dtpregini", org.hamcrest.Matchers.`is`("1978-02-16")))
                ?.andExpect(MockMvcResultMatchers.jsonPath("$[0].dtpregfim", org.hamcrest.Matchers.`is`("1978-02-17")))
                ?.andExpect(MockMvcResultMatchers.jsonPath("$[0].recomendacao.codneg", org.hamcrest.Matchers.`is`("MGLU3")))
                ?.andExpect(MockMvcResultMatchers.jsonPath("$[0].recomendacao.precoFechamento", org.hamcrest.Matchers.`is`(11.1100)))
                ?.andExpect(MockMvcResultMatchers.jsonPath("$[0].recomendacao.precoMME12p", org.hamcrest.Matchers.`is`(11.7500)))
                ?.andExpect(MockMvcResultMatchers.jsonPath("$[0].recomendacao.precoMME26p", org.hamcrest.Matchers.`is`(12.3600)))
                ?.andExpect(MockMvcResultMatchers.jsonPath("$[0].recomendacao.precoMacd", org.hamcrest.Matchers.`is`(-0.6100)))
                ?.andExpect(MockMvcResultMatchers.jsonPath("$[0].recomendacao.precoSinalMacd", org.hamcrest.Matchers.`is`(-0.4800)))
                ?.andExpect(MockMvcResultMatchers.jsonPath("$[0].recomendacao.precoHistograma", org.hamcrest.Matchers.`is`(-0.1300)))
                ?.andExpect(MockMvcResultMatchers.jsonPath("$[0].recomendacao.decisao", org.hamcrest.Matchers.`is`("VENDE")))
                ?.andExpect(MockMvcResultMatchers.jsonPath("$[2].dtpregini", org.hamcrest.Matchers.`is`("1978-02-20")))
                ?.andExpect(MockMvcResultMatchers.jsonPath("$[2].dtpregfim", org.hamcrest.Matchers.`is`("1978-02-21")))
                ?.andExpect(MockMvcResultMatchers.jsonPath("$[2].recomendacao.codneg", org.hamcrest.Matchers.`is`("MGLU3")))
                ?.andExpect(MockMvcResultMatchers.jsonPath("$[2].recomendacao.precoFechamento", org.hamcrest.Matchers.`is`(11.0500)))
                ?.andExpect(MockMvcResultMatchers.jsonPath("$[2].recomendacao.precoMME12p", org.hamcrest.Matchers.`is`(11.6400)))
                ?.andExpect(MockMvcResultMatchers.jsonPath("$[2].recomendacao.precoMME26p", org.hamcrest.Matchers.`is`(12.2700)))
                ?.andExpect(MockMvcResultMatchers.jsonPath("$[2].recomendacao.precoMacd", org.hamcrest.Matchers.`is`(-0.6300)))
                ?.andExpect(MockMvcResultMatchers.jsonPath("$[2].recomendacao.precoSinalMacd", org.hamcrest.Matchers.`is`(-0.5100)))
                ?.andExpect(MockMvcResultMatchers.jsonPath("$[2].recomendacao.precoHistograma", org.hamcrest.Matchers.`is`(-0.1200)))
                ?.andExpect(MockMvcResultMatchers.jsonPath("$[2].recomendacao.decisao", org.hamcrest.Matchers.`is`("VENDE")))
    }

    private fun recomendacaoDiarioList(): List<RecomendacaoDiario> {
        return Fixture.from(RecomendacaoDiario::class.java)
                .gimme(3,
                        RecomendacaoDiarioAppTemplateLoader.RECOMENDACAO_DIARIO_VALID_001,
                        RecomendacaoDiarioAppTemplateLoader.RECOMENDACAO_DIARIO_VALID_002,
                        RecomendacaoDiarioAppTemplateLoader.RECOMENDACAO_DIARIO_VALID_003
                )
    }

    private fun recomendacaoSemanalList(): List<RecomendacaoSemanal> {
        return Fixture.from(RecomendacaoSemanal::class.java)
                .gimme(3,
                        RecomendacaoSemanalAppTemplateLoader.RECOMENDACAO_SEMANAL_VALID_001,
                        RecomendacaoSemanalAppTemplateLoader.RECOMENDACAO_SEMANAL_VALID_002,
                        RecomendacaoSemanalAppTemplateLoader.RECOMENDACAO_SEMANAL_VALID_003
                )
    }
}