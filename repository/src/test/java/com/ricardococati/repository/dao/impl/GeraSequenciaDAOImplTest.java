package com.ricardococati.repository.dao.impl;

import com.ricardococati.repository.dao.BaseJdbcTest;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class GeraSequenciaDAOImplTest extends BaseJdbcTest {

  @InjectMocks
  private GeraSequenciaDAOImpl target;
  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Before
  public void setUp() throws Exception {
    target = new GeraSequenciaDAOImpl(
        getNamedParameterJdbcTemplate()
    );
  }

  @Test
  public void getSequenceGeraDuasSequencias() {
    //given
    String sequence = "CANDLESTICK_SEQ";
    //when
    Number retorno1 = target.getSequence(sequence);
    Number retorno2 = target.getSequence(sequence);
    //then
    Assertions.assertThat(retorno1).isNotNull().isEqualTo(1L);
    Assertions.assertThat(retorno2).isNotNull().isEqualTo(2L);
  }

  @Test
  public void getSequenceCandleDiario() {
    //given
    String sequence = "CANDLESTICK_SEQ";
    //when
    Number retorno = target.getSequence(sequence);
    //then
    Assertions.assertThat(retorno).isNotNull().isEqualTo(1L);
  }

  @Test
  public void getSequenceMediaSimplesDiario() {
    //given
    String sequence = "MEDIA_MOVEL_SIMPLES_DIARIO_SEQ";
    //when
    Number retorno = target.getSequence(sequence);
    //then
    Assertions.assertThat(retorno).isNotNull().isEqualTo(1L);
  }

  @Test
  public void getSequenceMediaExponencialDiario() {
    //given
    String sequence = "MEDIA_MOVEL_EXPONENCIAL_DIARIO_SEQ";
    //when
    Number retorno = target.getSequence(sequence);
    //then
    Assertions.assertThat(retorno).isNotNull().isEqualTo(1L);
  }

  @Test
  public void getSequenceMacdDiario() {
    //given
    String sequence = "MACD_DIARIO_SEQ";
    //when
    Number retorno = target.getSequence(sequence);
    //then
    Assertions.assertThat(retorno).isNotNull().isEqualTo(1L);
  }

  @Test
  public void getSequenceSinalMacdDiario() {
    //given
    String sequence = "SINAL_MACD_DIARIO_SEQ";
    //when
    Number retorno = target.getSequence(sequence);
    //then
    Assertions.assertThat(retorno).isNotNull().isEqualTo(1L);
  }

  @Test
  public void getSequenceHistogramaDiario() {
    //given
    String sequence = "HISTOGRAMA_DIARIO_SEQ";
    //when
    Number retorno = target.getSequence(sequence);
    //then
    Assertions.assertThat(retorno).isNotNull().isEqualTo(1L);
  }

  @Test
  public void getSequenceCandleSemanal() {
    //given
    String sequence = "CANDLESTICK_SEMANAL_SEQ";
    //when
    Number retorno = target.getSequence(sequence);
    //then
    Assertions.assertThat(retorno).isNotNull().isEqualTo(1L);
  }

  @Test
  public void getSequenceMediaSimplesSemanal() {
    //given
    String sequence = "MEDIA_MOVEL_SIMPLES_SEMANAL_SEQ";
    //when
    Number retorno = target.getSequence(sequence);
    //then
    Assertions.assertThat(retorno).isNotNull().isEqualTo(1L);
  }

  @Test
  public void getSequenceMediaExponencialSemanal() {
    //given
    String sequence = "MEDIA_MOVEL_EXPONENCIAL_SEMANAL_SEQ";
    //when
    Number retorno = target.getSequence(sequence);
    //then
    Assertions.assertThat(retorno).isNotNull().isEqualTo(1L);
  }

  @Test
  public void getSequenceMacdSemanal() {
    //given
    String sequence = "MACD_SEMANAL_SEQ";
    //when
    Number retorno = target.getSequence(sequence);
    //then
    Assertions.assertThat(retorno).isNotNull().isEqualTo(1L);
  }

  @Test
  public void getSequenceSinalMacdSemanal() {
    //given
    String sequence = "SINAL_MACD_SEMANAL_SEQ";
    //when
    Number retorno = target.getSequence(sequence);
    //then
    Assertions.assertThat(retorno).isNotNull().isEqualTo(1L);
  }

  @Test
  public void getSequenceHistogramaSemanal() {
    //given
    String sequence = "HISTOGRAMA_SEMANAL_SEQ";
    //when
    Number retorno = target.getSequence(sequence);
    //then
    Assertions.assertThat(retorno).isNotNull().isEqualTo(1L);
  }

  @Test
  public void getSequenceNull() {
    //given
    String sequence = null;
    //when
    this.thrown.expectMessage("A sequencia enviada não pode ser nula!");
    this.thrown.expect(IllegalArgumentException.class);
    target.getSequence(sequence);
  }
}