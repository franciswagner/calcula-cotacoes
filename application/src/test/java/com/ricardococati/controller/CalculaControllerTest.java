package com.ricardococati.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ricardococati.service.ICalculaMediaMovelExponencialDiarioService;
import com.ricardococati.service.ICalculaMediaMovelSimplesDiarioService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {CalculaController.class})
@AutoConfigureMockMvc(addFilters = false)
public class CalculaControllerTest {

  @MockBean
  private ICalculaMediaMovelSimplesDiarioService serviceMS;
  @MockBean
  private ICalculaMediaMovelExponencialDiarioService serviceME;
  @Autowired
  private MockMvc mockMvc;

  @Test
  public void calculaMMS() throws Exception {
    //given
    String codneg = "abc123";
    //when
    final ResultActions result = this.mockMvc
        .perform(
            post(String.format("/api/v1/calcula/media-simples"))
                .param("codneg", codneg)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));
    //then
    result
        .andExpect(status().isOk());
  }

  @Test
  public void calculaMME() throws Exception {
    //given
    String codneg = "abc123";
    //when
    final ResultActions result = this.mockMvc
        .perform(
            post(String.format("/api/v1/calcula/media-exponencial"))
                .param("codneg", codneg)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));
    //then
    result
        .andExpect(status().isOk());
  }
}