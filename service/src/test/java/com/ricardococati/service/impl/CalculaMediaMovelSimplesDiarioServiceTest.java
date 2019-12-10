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

  @Test
  public void executeOk() {
    //given
    List<String> listCodneg = getListCodneg();
    List<CandlestickDiarioDTO> candlestickList = getListCandlestickDiario(listCodneg);
    when(diarioService.listCodNegocioMediaSimplesFalse()).thenReturn(listCodneg);
    when(diarioService.listaCandlestickDiario(any())).thenReturn(candlestickList);
    when(converteMediaMovelSimples
        .converterCandlestickDiarioToMediaMovelSimples(any()))
        .thenCallRealMethod();
    //when
    Boolean returned = target.execute();
    //then
    assertTrue(returned);
  }

  @Test
  public void executeByCodNegOk() {
  }

  private List<String> getListCodneg() {
    return Arrays.asList(
        "MGLU3",
        "PETR3",
        "VALE3",
        "MGLU4",
        "PETR4",
        "VALE4",
        "MGLU5",
        "PETR5",
        "VALE5",
        "MGLU6",
        "PETR6",
        "VALE6"
    );
  }

  public List<CandlestickDiarioDTO> getListCandlestickDiario(List<String> listCodneg) {
    return listCodneg
        .stream()
        .map(s -> buildCandlestickDiarioDTO(s))
        .collect(Collectors.toList());
  }

  private CandlestickDiarioDTO buildCandlestickDiarioDTO(final String codneg) {
    return CandlestickDiarioDTO
        .builder()
        .dtpreg(LocalDate.of(1978,02,16))
        .candlestickDTO(CandlestickDTO
            .builder()
            .preult(new BigDecimal(10.01))
            .codneg(codneg)
            .build()
        )
        .build();
  }

  public MediaMovelSimplesDiario buildMediaMovelSimples(final CandlestickDiarioDTO dto) {
    return MediaMovelSimplesDiario
        .builder()
        .dtpreg(dto.getDtpreg())
        .mediaMovelSimples(
            MediaMovelSimples
                .builder()
                .periodo(9)
                .premedult(new BigDecimal(10.01))
                .codneg(dto.getCandlestickDTO().getCodneg())
                .build())
        .build();
  }
}
