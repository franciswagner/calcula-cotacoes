package com.ricardococati.service.impl;

import static br.com.six2six.fixturefactory.Fixture.from;
import static com.ricardococati.service.impl.templates.CandlestickDiarioDTOTemplateLoader.CANDLESTICK_DIARIO_DTO_VALID_001;
import static com.ricardococati.service.impl.templates.CandlestickDiarioDTOTemplateLoader.CANDLESTICK_DIARIO_DTO_VALID_002;
import static com.ricardococati.service.impl.templates.CandlestickDiarioDTOTemplateLoader.CANDLESTICK_DIARIO_DTO_VALID_003;
import static com.ricardococati.service.impl.templates.CandlestickDiarioDTOTemplateLoader.CANDLESTICK_DIARIO_DTO_VALID_004;
import static com.ricardococati.service.impl.templates.CandlestickDiarioDTOTemplateLoader.CANDLESTICK_DIARIO_DTO_VALID_005;
import static com.ricardococati.service.impl.templates.CandlestickDiarioDTOTemplateLoader.CANDLESTICK_DIARIO_DTO_VALID_006;
import static com.ricardococati.service.impl.templates.CandlestickDiarioDTOTemplateLoader.CANDLESTICK_DIARIO_DTO_VALID_007;
import static com.ricardococati.service.impl.templates.CandlestickDiarioDTOTemplateLoader.CANDLESTICK_DIARIO_DTO_VALID_008;
import static com.ricardococati.service.impl.templates.CandlestickDiarioDTOTemplateLoader.CANDLESTICK_DIARIO_DTO_VALID_009;
import static com.ricardococati.service.impl.templates.CandlestickDiarioDTOTemplateLoader.CANDLESTICK_DIARIO_DTO_VALID_010;
import static com.ricardococati.service.impl.templates.CandlestickDiarioDTOTemplateLoader.CANDLESTICK_DIARIO_DTO_VALID_011;
import static com.ricardococati.service.impl.templates.CandlestickDiarioDTOTemplateLoader.CANDLESTICK_DIARIO_DTO_VALID_012;
import static com.ricardococati.service.impl.templates.CandlestickDiarioDTOTemplateLoader.CANDLESTICK_DIARIO_DTO_VALID_013;
import static com.ricardococati.service.impl.templates.CandlestickDiarioDTOTemplateLoader.CANDLESTICK_DIARIO_DTO_VALID_014;
import static com.ricardococati.service.impl.templates.CandlestickDiarioDTOTemplateLoader.CANDLESTICK_DIARIO_DTO_VALID_015;
import static com.ricardococati.service.impl.templates.CandlestickDiarioDTOTemplateLoader.CANDLESTICK_DIARIO_DTO_VALID_016;
import static com.ricardococati.service.impl.templates.CandlestickDiarioDTOTemplateLoader.CANDLESTICK_DIARIO_DTO_VALID_017;
import static com.ricardococati.service.impl.templates.CandlestickDiarioDTOTemplateLoader.CANDLESTICK_DIARIO_DTO_VALID_018;
import static com.ricardococati.service.impl.templates.CandlestickDiarioDTOTemplateLoader.CANDLESTICK_DIARIO_DTO_VALID_019;
import static com.ricardococati.service.impl.templates.CandlestickDiarioDTOTemplateLoader.CANDLESTICK_DIARIO_DTO_VALID_020;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.ricardococati.model.dto.CandlestickDiarioDTO;
import com.ricardococati.model.dto.MediaMovelSimplesDiario;
import com.ricardococati.repository.dao.MediaMovelSimplesDiarioDAO;
import com.ricardococati.service.BuscarCandlestickDiarioService;
import com.ricardococati.service.converter.MediaMovelSimplesConverter;
import java.math.BigDecimal;
import java.time.LocalDate;
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

  @Before
  public void setUp() {
    FixtureFactoryLoader.loadTemplates("com.ricardococati.service.impl.templates");
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
    assertThat(returned).isNotNull().size().isEqualTo(29);
    assertThat(returned.get(0).getDtpreg()).isNotNull().isEqualTo(LocalDate.of(1978, 2, 24));
    assertThat(returned.get(0).getMediaMovelSimples().getPeriodo()).isNotNull().isEqualTo(9);
    assertThat(returned.get(0).getMediaMovelSimples().getPremedult()).isNotNull().isEqualTo(new BigDecimal("11.4111"));
    assertThat(returned.get(1).getDtpreg()).isNotNull().isEqualTo(LocalDate.of(1978, 2, 25));
    assertThat(returned.get(1).getMediaMovelSimples().getPeriodo()).isNotNull().isEqualTo(9);
    assertThat(returned.get(1).getMediaMovelSimples().getPremedult()).isNotNull().isEqualTo(new BigDecimal("11.5000"));
    assertThat(returned.get(2).getDtpreg()).isNotNull().isEqualTo(LocalDate.of(1978, 2, 26));
    assertThat(returned.get(2).getMediaMovelSimples().getPeriodo()).isNotNull().isEqualTo(9);
    assertThat(returned.get(2).getMediaMovelSimples().getPremedult()).isNotNull().isEqualTo(new BigDecimal("11.5111"));
    assertThat(returned.get(28).getDtpreg()).isNotNull().isEqualTo(LocalDate.of(1978, 3, 07));
    assertThat(returned.get(28).getMediaMovelSimples().getPeriodo()).isNotNull().isEqualTo(13);
    assertThat(returned.get(28).getMediaMovelSimples().getPremedult()).isNotNull().isEqualTo(new BigDecimal("11.5615"));
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
    return from(CandlestickDiarioDTO.class)
        .gimme(20, CANDLESTICK_DIARIO_DTO_VALID_001
            , CANDLESTICK_DIARIO_DTO_VALID_002
            , CANDLESTICK_DIARIO_DTO_VALID_003
            , CANDLESTICK_DIARIO_DTO_VALID_004
            , CANDLESTICK_DIARIO_DTO_VALID_005
            , CANDLESTICK_DIARIO_DTO_VALID_006
            , CANDLESTICK_DIARIO_DTO_VALID_007
            , CANDLESTICK_DIARIO_DTO_VALID_008
            , CANDLESTICK_DIARIO_DTO_VALID_009
            , CANDLESTICK_DIARIO_DTO_VALID_010
            , CANDLESTICK_DIARIO_DTO_VALID_011
            , CANDLESTICK_DIARIO_DTO_VALID_012
            , CANDLESTICK_DIARIO_DTO_VALID_013
            , CANDLESTICK_DIARIO_DTO_VALID_014
            , CANDLESTICK_DIARIO_DTO_VALID_015
            , CANDLESTICK_DIARIO_DTO_VALID_016
            , CANDLESTICK_DIARIO_DTO_VALID_017
            , CANDLESTICK_DIARIO_DTO_VALID_018
            , CANDLESTICK_DIARIO_DTO_VALID_019
            , CANDLESTICK_DIARIO_DTO_VALID_020);
  }

}