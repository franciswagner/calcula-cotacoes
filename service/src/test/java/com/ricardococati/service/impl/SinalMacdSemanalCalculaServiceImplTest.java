package com.ricardococati.service.impl;

import static br.com.six2six.fixturefactory.Fixture.from;
import static com.ricardococati.service.impl.templates.MacdSemanalTemplateLoader.MACD_SEMANAL_VALID_001;
import static com.ricardococati.service.impl.templates.MacdSemanalTemplateLoader.MACD_SEMANAL_VALID_002;
import static com.ricardococati.service.impl.templates.MacdSemanalTemplateLoader.MACD_SEMANAL_VALID_003;
import static com.ricardococati.service.impl.templates.MacdSemanalTemplateLoader.MACD_SEMANAL_VALID_004;
import static com.ricardococati.service.impl.templates.MacdSemanalTemplateLoader.MACD_SEMANAL_VALID_005;
import static com.ricardococati.service.impl.templates.MacdSemanalTemplateLoader.MACD_SEMANAL_VALID_006;
import static com.ricardococati.service.impl.templates.MacdSemanalTemplateLoader.MACD_SEMANAL_VALID_007;
import static com.ricardococati.service.impl.templates.MacdSemanalTemplateLoader.MACD_SEMANAL_VALID_008;
import static com.ricardococati.service.impl.templates.MacdSemanalTemplateLoader.MACD_SEMANAL_VALID_009;
import static com.ricardococati.service.impl.templates.MacdSemanalTemplateLoader.MACD_SEMANAL_VALID_010;
import static com.ricardococati.service.impl.templates.MacdSemanalTemplateLoader.MACD_SEMANAL_VALID_011;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.ricardococati.model.entities.MacdSemanal;
import com.ricardococati.model.entities.SinalMacdSemanal;
import com.ricardococati.repository.dao.MacdSemanalBuscarDAO;
import com.ricardococati.repository.dao.SinalMacdSemanalInserirDAO;
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
public class SinalMacdSemanalCalculaServiceImplTest {

  @InjectMocks
  private SinalMacdSemanalCalculaServiceImpl target;
  @Mock
  private MacdSemanalBuscarDAO macdDAO;
  @Mock
  private SinalMacdSemanalInserirDAO sinalMacdDAO;
  @Mock
  private CalculaService calculaService;

  @Before
  public void setUp() throws Exception {
    FixtureFactoryLoader.loadTemplates("com.ricardococati.service.impl.templates");
  }

  @Test
  public void executeByCodNeg() {
    //given
    when(calculaService.listMacdSemanalByCodNeg(any())).thenReturn(macdSemanalList());
    when(macdDAO.buscaMacdMediaSimplesPorCodNegDtPregLimite9Periodos(any(), any())).thenReturn(macdSemanalList());
    //when
    List<SinalMacdSemanal> result = target.executeByCodNeg("MGLU3");
    //then
    assertTrue(!result.isEmpty());
    assertThat(result).isNotNull().size().isEqualTo(3);
    assertThat(result.get(0).getDtpregini()).isNotNull().isEqualTo(LocalDate.of(1978, 3, 5));
    assertThat(result.get(0).getSinalMacd().getPeriodo()).isNull();
    assertThat(result.get(0).getSinalMacd().getPresinal()).isNotNull().isEqualTo(new BigDecimal("13.0544"));
    assertThat(result.get(1).getDtpregini()).isNotNull().isEqualTo(LocalDate.of(1978, 3, 7));
    assertThat(result.get(1).getSinalMacd().getPeriodo()).isNotNull().isEqualTo(9);
    assertThat(result.get(1).getSinalMacd().getPresinal()).isNotNull().isEqualTo(new BigDecimal("12.5555"));
    assertThat(result.get(2).getDtpregini()).isNotNull().isEqualTo(LocalDate.of(1978, 3, 9));
    assertThat(result.get(2).getSinalMacd().getPeriodo()).isNotNull().isEqualTo(9);
    assertThat(result.get(2).getSinalMacd().getPresinal()).isNotNull().isEqualTo(new BigDecimal("12.1964"));
  }

  private List<MacdSemanal> macdSemanalList(){
    return from(MacdSemanal.class)
        .gimme(11,
            MACD_SEMANAL_VALID_001,
            MACD_SEMANAL_VALID_002,
            MACD_SEMANAL_VALID_003,
            MACD_SEMANAL_VALID_004,
            MACD_SEMANAL_VALID_005,
            MACD_SEMANAL_VALID_006,
            MACD_SEMANAL_VALID_007,
            MACD_SEMANAL_VALID_008,
            MACD_SEMANAL_VALID_009,
            MACD_SEMANAL_VALID_010,
            MACD_SEMANAL_VALID_011
        );
  }

}
