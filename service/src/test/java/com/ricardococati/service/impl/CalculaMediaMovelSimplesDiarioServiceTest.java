package com.ricardococati.service.impl;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import com.ricardococati.model.dto.CandlestickDTO;
import com.ricardococati.model.dto.CandlestickDiarioDTO;
import com.ricardococati.model.dto.MediaMovelSimples;
import com.ricardococati.model.dto.MediaMovelSimplesDiario;
import com.ricardococati.repository.dao.IMediaMovelSimplesDiarioDAO;
import com.ricardococati.service.ICandlestickDiarioService;
import com.ricardococati.service.converter.ConverteMediaMovelSimples;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CalculaMediaMovelSimplesDiarioServiceTest {

  @InjectMocks
  private CalculaMediaMovelSimplesDiarioService target;
  @Mock
  private ICandlestickDiarioService diarioService;
  @Mock
  private ConverteMediaMovelSimples converteMediaMovelSimples;
  @Mock
  private IMediaMovelSimplesDiarioDAO mediaMovelSimplesDAO;

  private Integer countInteger;
  private LocalDate dtpreg;

  @Before
  public void setUp() {
    this.countInteger = 0;
    this.dtpreg = LocalDate.of(1978, 02, 16);
  }

  @Test
  public void executeOk() {
    //given
    List<CandlestickDiarioDTO> candlestickList = getListCandlestickDiario();
    when(diarioService.listaCandlestickDiario(any())).thenReturn(candlestickList);
    when(converteMediaMovelSimples
        .converterCandlestickDiarioToMediaMovelSimples(any()))
        .thenCallRealMethod();
    //when
    List<MediaMovelSimplesDiario> returned = target.executeByCodNeg("MGLU3");
    //then
    assertTrue(!returned.isEmpty());
  }

  @Test
  public void executeByCodNegOk() {
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