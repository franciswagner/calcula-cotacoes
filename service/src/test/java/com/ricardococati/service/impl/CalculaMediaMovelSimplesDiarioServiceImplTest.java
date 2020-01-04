package com.ricardococati.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import com.ricardococati.model.dto.CandlestickDTO;
import com.ricardococati.model.dto.CandlestickDiarioDTO;
import com.ricardococati.model.dto.MediaMovelSimplesDiario;
import com.ricardococati.repository.dao.MediaMovelSimplesDiarioDAO;
import com.ricardococati.service.BuscarCandlestickDiarioService;
import com.ricardococati.service.converter.MediaMovelSimplesConverter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CalculaMediaMovelSimplesDiarioServiceImplTest {

  @InjectMocks
  private CalculaMediaMovelSimplesDiarioServiceImpl target;
  @Mock
  private BuscarCandlestickDiarioService diarioService;
  @Mock
  private MediaMovelSimplesConverter converteMediaMovelSimples;
  @Mock
  private MediaMovelSimplesDiarioDAO mediaMovelSimplesDAO;

  private Integer countInteger;
  private LocalDate dtpreg;

  @Before
  public void setUp() {
    this.countInteger = 0;
    this.dtpreg = LocalDate.of(1978, 02, 16);
  }

  @Test
  public void executeByCodNegOk() {
    //given
    List<CandlestickDiarioDTO> candlestickList = getListCandlestickDiario();
    when(diarioService.buscaCandlestickDiarioPorCodNeg(any())).thenReturn(candlestickList);
    when(converteMediaMovelSimples
        .converterCandlestickDiarioToMediaMovelSimples(any()))
        .thenCallRealMethod();
    //when
    List<MediaMovelSimplesDiario> returned = target.executeByCodNeg("MGLU3");
    //then
    assertTrue(!returned.isEmpty());
    assertThat(returned).isNotNull().size().isEqualTo(3);
    assertThat(returned.get(0).getDtpreg()).isNotNull().isEqualTo(LocalDate.of(1978, 02, 25));
    assertThat(returned.get(0).getMediaMovelSimples().getPeriodo()).isNotNull().isEqualTo(9);
    assertThat(returned.get(0).getMediaMovelSimples().getPremedult()).isNotNull().isEqualTo(new BigDecimal("10.2556"));
    assertThat(returned.get(1).getDtpreg()).isNotNull().isEqualTo(LocalDate.of(1978, 02, 26));
    assertThat(returned.get(1).getMediaMovelSimples().getPeriodo()).isNotNull().isEqualTo(9);
    assertThat(returned.get(1).getMediaMovelSimples().getPremedult()).isNotNull().isEqualTo(new BigDecimal("10.2333"));
    assertThat(returned.get(2).getDtpreg()).isNotNull().isEqualTo(LocalDate.of(1978, 02, 27));
    assertThat(returned.get(2).getMediaMovelSimples().getPeriodo()).isNotNull().isEqualTo(9);
    assertThat(returned.get(2).getMediaMovelSimples().getPremedult()).isNotNull().isEqualTo(new BigDecimal("10.2000"));
  }

  @Test
  public void executeByCodNegCandlestickNull() {
    //given
    when(diarioService.buscaCandlestickDiarioPorCodNeg(any())).thenReturn(null);
    when(converteMediaMovelSimples
        .converterCandlestickDiarioToMediaMovelSimples(any()))
        .thenCallRealMethod();
    //when
    List<MediaMovelSimplesDiario> returned = target.executeByCodNeg("MGLU3");
    //then
    assertTrue(returned.isEmpty());
  }

  @Test
  public void executeByCodNegCandlestickEmpty() {
    //given
    when(diarioService.buscaCandlestickDiarioPorCodNeg(any())).thenReturn(Collections.EMPTY_LIST);
    when(converteMediaMovelSimples
        .converterCandlestickDiarioToMediaMovelSimples(any()))
        .thenCallRealMethod();
    //when
    List<MediaMovelSimplesDiario> returned = target.executeByCodNeg("MGLU3");
    //then
    assertTrue(returned.isEmpty());
  }

  private List<CandlestickDiarioDTO> getListCandlestickDiario() {
    return Arrays.asList(
        buildCandlestickDiarioDTO("MGLU3", 10.1, dtpreg.plusDays(countInteger += 1)),
        buildCandlestickDiarioDTO("MGLU3", 10.3, dtpreg.plusDays(countInteger += 1)),
        buildCandlestickDiarioDTO("MGLU3", 10.0, dtpreg.plusDays(countInteger += 1)),
        buildCandlestickDiarioDTO("MGLU3", 10.4, dtpreg.plusDays(countInteger += 1)),
        buildCandlestickDiarioDTO("MGLU3", 9.8, dtpreg.plusDays(countInteger += 1)),
        buildCandlestickDiarioDTO("MGLU3", 11.0, dtpreg.plusDays(countInteger += 1)),
        buildCandlestickDiarioDTO("MGLU3", 10.7, dtpreg.plusDays(countInteger += 1)),
        buildCandlestickDiarioDTO("MGLU3", 10.5, dtpreg.plusDays(countInteger += 1)),
        buildCandlestickDiarioDTO("MGLU3", 9.5, dtpreg.plusDays(countInteger += 1)),
        buildCandlestickDiarioDTO("MGLU3", 9.9, dtpreg.plusDays(countInteger += 1)),
        buildCandlestickDiarioDTO("MGLU3", 10.0, dtpreg.plusDays(countInteger += 1))
    );
  }

  private CandlestickDiarioDTO buildCandlestickDiarioDTO(
      final String codneg,
      final Double preult,
      final LocalDate dtpreg
  ) {
    return CandlestickDiarioDTO
        .builder()
        .dtpreg(dtpreg)
        .candlestickDTO(CandlestickDTO
            .builder()
            .preult(new BigDecimal(preult).setScale(4, BigDecimal.ROUND_HALF_UP))
            .codneg(codneg)
            .build()
        )
        .build();
  }

}