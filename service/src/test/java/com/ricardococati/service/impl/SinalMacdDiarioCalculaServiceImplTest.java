package com.ricardococati.service.impl;

import static br.com.six2six.fixturefactory.Fixture.from;
import static com.ricardococati.service.impl.templates.MacdDiarioTemplateLoader.MACD_DIARIO_VALID_001;
import static com.ricardococati.service.impl.templates.MacdDiarioTemplateLoader.MACD_DIARIO_VALID_002;
import static com.ricardococati.service.impl.templates.MacdDiarioTemplateLoader.MACD_DIARIO_VALID_003;
import static com.ricardococati.service.impl.templates.MacdDiarioTemplateLoader.MACD_DIARIO_VALID_004;
import static com.ricardococati.service.impl.templates.MacdDiarioTemplateLoader.MACD_DIARIO_VALID_005;
import static com.ricardococati.service.impl.templates.MacdDiarioTemplateLoader.MACD_DIARIO_VALID_006;
import static com.ricardococati.service.impl.templates.MacdDiarioTemplateLoader.MACD_DIARIO_VALID_007;
import static com.ricardococati.service.impl.templates.MacdDiarioTemplateLoader.MACD_DIARIO_VALID_008;
import static com.ricardococati.service.impl.templates.MacdDiarioTemplateLoader.MACD_DIARIO_VALID_009;
import static com.ricardococati.service.impl.templates.MacdDiarioTemplateLoader.MACD_DIARIO_VALID_010;
import static com.ricardococati.service.impl.templates.MacdDiarioTemplateLoader.MACD_DIARIO_VALID_011;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.ricardococati.model.dto.MacdDiario;
import com.ricardococati.model.dto.SinalMacdDiario;
import com.ricardococati.repository.dao.MacdDiarioDAO;
import com.ricardococati.repository.dao.SinalMacdDiarioDAO;
import com.ricardococati.service.CalculaService;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SinalMacdDiarioCalculaServiceImplTest {

  @InjectMocks
  private SinalMacdDiarioCalculaServiceImpl target;
  @Mock
  private MacdDiarioDAO macdDAO;
  @Mock
  private SinalMacdDiarioDAO sinalMacdDAO;
  @Mock
  private CalculaService calculaService;

  @Before
  public void setUp() throws Exception {
    FixtureFactoryLoader.loadTemplates("com.ricardococati.service.impl.templates");
  }

  @Test
  public void executeByCodNeg() {
    //given
    when(calculaService.listMacdDiarioByCodNeg(any())).thenReturn(macdDiarioList());
    when(macdDAO.buscaMacdMediaSimplesPorCodNegDtPregLimite9Periodos(any(), any())).thenReturn(macdDiarioList());
    //when
    List<SinalMacdDiario> result = target.executeByCodNeg("MGLU3");
    //then
    assertTrue(!result.isEmpty());
    assertThat(result).isNotNull().size().isEqualTo(3);
    assertThat(result.get(0).getDtpreg()).isNotNull().isEqualTo(LocalDate.of(1978, 2, 24));
    assertThat(result.get(0).getSinalMacd().getPeriodo()).isNull();
    assertThat(result.get(0).getSinalMacd().getPresinal()).isNotNull().isEqualTo(new BigDecimal("13.0544"));
    assertThat(result.get(1).getDtpreg()).isNotNull().isEqualTo(LocalDate.of(1978, 2, 25));
    assertThat(result.get(1).getSinalMacd().getPeriodo()).isNotNull().isEqualTo(9);
    assertThat(result.get(1).getSinalMacd().getPresinal()).isNotNull().isEqualTo(new BigDecimal("12.5555"));
    assertThat(result.get(2).getDtpreg()).isNotNull().isEqualTo(LocalDate.of(1978, 2, 26));
    assertThat(result.get(2).getSinalMacd().getPeriodo()).isNotNull().isEqualTo(9);
    assertThat(result.get(2).getSinalMacd().getPresinal()).isNotNull().isEqualTo(new BigDecimal("12.1964"));
  }

  private List<MacdDiario> macdDiarioList(){
    return from(MacdDiario.class)
        .gimme(11,
            MACD_DIARIO_VALID_001,
            MACD_DIARIO_VALID_002,
            MACD_DIARIO_VALID_003,
            MACD_DIARIO_VALID_004,
            MACD_DIARIO_VALID_005,
            MACD_DIARIO_VALID_006,
            MACD_DIARIO_VALID_007,
            MACD_DIARIO_VALID_008,
            MACD_DIARIO_VALID_009,
            MACD_DIARIO_VALID_010,
            MACD_DIARIO_VALID_011
        );
  }

}