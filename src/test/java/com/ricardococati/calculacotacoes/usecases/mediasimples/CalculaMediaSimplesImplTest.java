package com.ricardococati.calculacotacoes.usecases.mediasimples;

import static java.util.Objects.nonNull;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import com.ricardococati.calculacotacoes.usecases.mediasimples.impl.CalculaMediaSimplesImpl;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CalculaMediaSimplesImplTest {

  @InjectMocks
  private CalculaMediaSimplesImpl target;

  @Test
  public void calculaOk_0_to_Size(){
    List<BigDecimal> decimalList = getDecimalList();
    BigDecimal result = target.calcula(0,decimalList.size(), decimalList);
    assertTrue(nonNull(result));
    assertThat(result).isNotNull().isEqualTo(new BigDecimal("55.0010"));
  }

  @Test
  public void calculaOk_1_to_Size(){
    List<BigDecimal> decimalList = getDecimalList();
    BigDecimal result = target.calcula(1,decimalList.size(), decimalList);
    assertTrue(nonNull(result));
    assertThat(result).isNotNull().isEqualTo(new BigDecimal("60.0010"));
  }

  @Test
  public void calculaOk_5_to_Size(){
    List<BigDecimal> decimalList = getDecimalList();
    BigDecimal result = target.calcula(5,decimalList.size(), decimalList);
    assertTrue(nonNull(result));
    assertThat(result).isNotNull().isEqualTo(new BigDecimal("80.0010"));
  }

  @Test
  public void calculaOk_2_to_Size_Minus_2(){
    List<BigDecimal> decimalList = getDecimalList();
    BigDecimal result = target.calcula(2,decimalList.size()-2, decimalList);
    assertTrue(nonNull(result));
    assertThat(result).isNotNull().isEqualTo(new BigDecimal("55.0010"));
  }

  @Test
  public void calculaOk_Minus_2_to_Size_Minus_2(){
    List<BigDecimal> decimalList = getDecimalList();
    BigDecimal result = target.calcula(-2,decimalList.size()-2, decimalList);
    assertTrue(nonNull(result));
    assertThat(result).isNotNull().isEqualTo(new BigDecimal("0"));
  }

  @Test
  public void calculaOk_Minus_2_to_Size_More_Than_Size_2(){
    List<BigDecimal> decimalList = getDecimalList();
    BigDecimal result = target.calcula(-2,decimalList.size()+2, decimalList);
    assertTrue(nonNull(result));
    assertThat(result).isNotNull().isEqualTo(new BigDecimal("0"));
  }

  @Test
  public void calculaOk_ListNull(){
    BigDecimal result = target.calcula(1,2, null);
    assertTrue(nonNull(result));
    assertThat(result).isNotNull().isEqualTo(new BigDecimal("0"));
  }

  @Test
  public void calculaOk_EmptyList(){
    BigDecimal result = target.calcula(1,2, new ArrayList<>());
    assertTrue(nonNull(result));
    assertThat(result).isNotNull().isEqualTo(new BigDecimal("0"));
  }

  private ArrayList<BigDecimal> getDecimalList() {
    final ArrayList<BigDecimal> decimalList = new ArrayList<>();
    decimalList.add(new BigDecimal(10.001));
    decimalList.add(new BigDecimal(20.001));
    decimalList.add(new BigDecimal(30.001));
    decimalList.add(new BigDecimal(40.001));
    decimalList.add(new BigDecimal(50.001));
    decimalList.add(new BigDecimal(60.001));
    decimalList.add(new BigDecimal(70.001));
    decimalList.add(new BigDecimal(80.001));
    decimalList.add(new BigDecimal(90.001));
    decimalList.add(new BigDecimal(100.001));
    return decimalList;
  }

}