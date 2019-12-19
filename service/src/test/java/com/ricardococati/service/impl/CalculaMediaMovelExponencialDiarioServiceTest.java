package com.ricardococati.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import com.ricardococati.model.dto.CandlestickDTO;
import com.ricardococati.model.dto.CandlestickDiarioDTO;
import com.ricardococati.model.dto.MediaMovelExponencialDiario;
import com.ricardococati.model.dto.MediaMovelSimples;
import com.ricardococati.model.dto.MediaMovelSimplesDiario;
import com.ricardococati.repository.dao.IMediaMovelExponencialDiarioDAO;
import com.ricardococati.repository.dao.IMediaMovelSimplesDiarioDAO;
import com.ricardococati.service.ICandlestickDiarioService;
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
public class CalculaMediaMovelExponencialDiarioServiceTest {

  @InjectMocks
  private CalculaMediaMovelExponencialDiarioService target;
  @Mock
  private ICandlestickDiarioService diarioService;
  @Mock
  private IMediaMovelSimplesDiarioDAO mediaMovelSimplesDAO;
  @Mock
  private IMediaMovelExponencialDiarioDAO mediaMovelExponencialDAO;

  private Integer countInteger;
  private LocalDate dtpreg;

  @Before
  public void setUp() {
    this.countInteger = 0;
    this.dtpreg = LocalDate.of(1978, 02, 16);
  }

  @Test
  public void executeByCodNeg() {
    //given
    List<CandlestickDiarioDTO> candlestickList = getListCandlestickDiario();
    when(diarioService.listaCandlestickDiario(any())).thenReturn(candlestickList);
    when(mediaMovelSimplesDAO.buscaMediaSimplesPorCodNegPeriodoDtPreg(any(), any(), any()))
        .thenReturn(buildMediaSimples("MGLU3", 10.1, dtpreg));

    //when
    List<MediaMovelExponencialDiario> returned = target.executeByCodNeg("MGLU3");

    //then
    assertTrue(!returned.isEmpty());
    assertThat(returned).isNotNull().size().isEqualTo(3);
    assertThat(returned.get(0).getDtpreg()).isNotNull().isEqualTo(LocalDate.of(1978, 02, 16));
    assertThat(returned.get(0).getMediaMovelExponencial().getPeriodo()).isNull();
    assertThat(returned.get(0).getMediaMovelExponencial().getPremedult()).isNotNull().isEqualTo(new BigDecimal("10.1000"));
    assertThat(returned.get(1).getDtpreg()).isNotNull().isEqualTo(LocalDate.of(1978, 02, 26));
    assertThat(returned.get(1).getMediaMovelExponencial().getPeriodo()).isNotNull().isEqualTo(9);
    assertThat(returned.get(1).getMediaMovelExponencial().getPremedult()).isNotNull().isEqualTo(new BigDecimal("10.0600"));
    assertThat(returned.get(2).getDtpreg()).isNotNull().isEqualTo(LocalDate.of(1978, 02, 27));
    assertThat(returned.get(2).getMediaMovelExponencial().getPeriodo()).isNotNull().isEqualTo(9);
    assertThat(returned.get(2).getMediaMovelExponencial().getPremedult()).isNotNull().isEqualTo(new BigDecimal("10.0480"));
  }

  @Test
  public void executeByCodNegCandlestickNull() {
    //given
    when(diarioService.listaCandlestickDiario(any())).thenReturn(null);
    when(mediaMovelSimplesDAO.buscaMediaSimplesPorCodNegPeriodoDtPreg(any(), any(), any()))
        .thenReturn(buildMediaSimples("MGLU3", 10.1, dtpreg));
    //when
    List<MediaMovelExponencialDiario> returned = target.executeByCodNeg("MGLU3");
    //then
    assertTrue(returned.isEmpty());
  }

  @Test
  public void executeByCodNegCandlestickEmpty() {
    //given
    when(diarioService.listaCandlestickDiario(any())).thenReturn(null);
    when(mediaMovelSimplesDAO.buscaMediaSimplesPorCodNegPeriodoDtPreg(any(), any(), any()))
        .thenReturn(buildMediaSimples("MGLU3", 10.1, dtpreg));
    //when
    List<MediaMovelExponencialDiario> returned = target.executeByCodNeg("MGLU3");
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

  private MediaMovelSimplesDiario buildMediaSimples(
      final String codneg,
      final Double preult,
      final LocalDate dtpreg
  ) {
    return MediaMovelSimplesDiario
        .builder()
        .dtpreg(dtpreg)
        .mediaMovelSimples(MediaMovelSimples
            .builder()
            .premedult(new BigDecimal(preult).setScale(4, BigDecimal.ROUND_HALF_UP))
            .codneg(codneg)
            .build()
        )
        .build();
  }

}