package com.ricardococati.controller

import com.ricardococati.controller.converter.SplitInplitConverter
import com.ricardococati.service.CandlestickAtualizarService
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

@RunWith(SpringRunner::class)
@WebMvcTest(controllers = [SplitInplitController::class])
@AutoConfigureMockMvc(addFilters = false)
class SplitInplitControllerTest {
    @MockBean
    private val atualizarCandlestickDiarioService: CandlestickAtualizarService? = null

    @MockBean
    private val converter: SplitInplitConverter? = null

    @Autowired
    private val mockMvc: MockMvc? = null

    @Test
    @Throws(Exception::class)
    fun splitSucesso() {
        //given
        val dtPregao = "16-02-1978"
        val codneg = "abc123"
        val qtdSplitInplit = "3"
        val operacao = "SPLIT"
        Mockito.`when`(converter!!.convert(Matchers.any(), Matchers.any(), Matchers.any(), Matchers.any())).thenCallRealMethod()
        //when
        val result = mockMvc
                ?.perform(
                        MockMvcRequestBuilders.put(String.format("/api/v1/split-inplit"))
                                .param("dtPregrao", dtPregao)
                                .param("codneg", codneg)
                                .param("qtdSplitInplit", qtdSplitInplit)
                                .param("operacao", operacao)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
        //then
        result
                ?.andExpect(MockMvcResultMatchers.status().isOk)
    }

    @Test
    @Throws(Exception::class)
    fun splitErrorParameter() {
        //given
        val dtPregao = "1978-02-16"
        val codneg: String? = null
        val qtdSplitInplit = "d"
        val operacao = "SPLIT"
        //when
        val result = mockMvc
                ?.perform(
                        MockMvcRequestBuilders.put(String.format("/api/v1/split-inplit/split"))
                                .param("dtPregrao", dtPregao)
                                .param("codneg", codneg)
                                .param("qtdSplitInplit", qtdSplitInplit)
                                .param("operacao", operacao)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
        //then
        result
                ?.andExpect(MockMvcResultMatchers.status().is4xxClientError)
    }

    @Test
    @Throws(Exception::class)
    fun inplitSucesso() {
        //given
        val dtPregao = "16-02-1978"
        val codneg = "abc123"
        val qtdSplitInplit = "3"
        val operacao = "INPLIT"
        Mockito.`when`(converter!!.convert(Matchers.any(), Matchers.any(), Matchers.any(), Matchers.any())).thenCallRealMethod()
        //when
        val result = mockMvc
                ?.perform(
                        MockMvcRequestBuilders.put(String.format("/api/v1/split-inplit"))
                                .param("dtPregrao", dtPregao)
                                .param("codneg", codneg)
                                .param("qtdSplitInplit", qtdSplitInplit)
                                .param("operacao", operacao)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
        //then
        result
                ?.andExpect(MockMvcResultMatchers.status().isOk)
    }

    @Test
    @Throws(Exception::class)
    fun inplitErrorParameter() {
        //given
        val dtPregao = "1978-02-16"
        val codneg: String? = null
        val qtdSplitInplit = "d"
        val operacao = "INPLIT"
        //when
        val result = mockMvc
                ?.perform(
                        MockMvcRequestBuilders.put(String.format("/api/v1/split-inplit/inplit"))
                                .param("dtPregrao", dtPregao)
                                .param("codneg", codneg)
                                .param("qtdSplitInplit", qtdSplitInplit)
                                .param("operacao", operacao)
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON))
        //then
        result
                ?.andExpect(MockMvcResultMatchers.status().is4xxClientError)
    }
}