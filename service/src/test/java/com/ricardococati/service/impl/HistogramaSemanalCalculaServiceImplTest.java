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
import static com.ricardococati.service.impl.templates.SinalMacdSemanalTemplateLoader.SINAL_MACD_SEMANAL_VALID_001;
import static com.ricardococati.service.impl.templates.SinalMacdSemanalTemplateLoader.SINAL_MACD_SEMANAL_VALID_002;
import static com.ricardococati.service.impl.templates.SinalMacdSemanalTemplateLoader.SINAL_MACD_SEMANAL_VALID_003;
import static com.ricardococati.service.impl.templates.SinalMacdSemanalTemplateLoader.SINAL_MACD_SEMANAL_VALID_004;
import static com.ricardococati.service.impl.templates.SinalMacdSemanalTemplateLoader.SINAL_MACD_SEMANAL_VALID_005;
import static com.ricardococati.service.impl.templates.SinalMacdSemanalTemplateLoader.SINAL_MACD_SEMANAL_VALID_006;
import static com.ricardococati.service.impl.templates.SinalMacdSemanalTemplateLoader.SINAL_MACD_SEMANAL_VALID_007;
import static com.ricardococati.service.impl.templates.SinalMacdSemanalTemplateLoader.SINAL_MACD_SEMANAL_VALID_008;
import static com.ricardococati.service.impl.templates.SinalMacdSemanalTemplateLoader.SINAL_MACD_SEMANAL_VALID_009;
import static com.ricardococati.service.impl.templates.SinalMacdSemanalTemplateLoader.SINAL_MACD_SEMANAL_VALID_010;
import static com.ricardococati.service.impl.templates.SinalMacdSemanalTemplateLoader.SINAL_MACD_SEMANAL_VALID_011;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.ricardococati.model.entities.HistogramaSemanal;
import com.ricardococati.model.entities.MacdSemanal;
import com.ricardococati.model.entities.SinalMacdSemanal;
import com.ricardococati.repository.dao.HistogramaSemanalInserirDAO;
import com.ricardococati.repository.dao.MacdSemanalBuscarDAO;
import com.ricardococati.repository.dao.SinalMacdSemanalBuscarDAO;
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
public class HistogramaSemanalCalculaServiceImplTest {

  @InjectMocks
  private HistogramaSemanalCalculaServiceImpl target;
  @Mock
  private MacdSemanalBuscarDAO macdDAO;
  @Mock
  private SinalMacdSemanalBuscarDAO sinalMacdDAO;
  @Mock
  private HistogramaSemanalInserirDAO histogramaDAO;

  @Before
  public void setUp() throws Exception {
    FixtureFactoryLoader.loadTemplates("com.ricardococati.service.impl.templates");
  }

  @Test
  public void executeByCodNeg() {
    //given
    when(macdDAO.listMacdByCodNeg(any())).thenReturn(macdSemanalList());
    when(sinalMacdDAO.listSinalMacdByCodNeg(any())).thenReturn(sinalMacdSemanalList());
    //when
    List<HistogramaSemanal> result = target.executeByCodNeg("MGLU3");
    //then
    assertTrue(!result.isEmpty());
    assertThat(result).isNotNull().size().isEqualTo(11);
    assertThat(result.get(0).getDtpregini()).isNotNull().isEqualTo(LocalDate.of(1978, 2, 16));
    assertThat(result.get(0).getHistograma().getPrehist()).isNotNull().isEqualTo(new BigDecimal("-1.0000"));
    assertThat(result.get(1).getDtpregini()).isNotNull().isEqualTo(LocalDate.of(1978, 2, 19));
    assertThat(result.get(1).getHistograma().getPrehist()).isNotNull().isEqualTo(new BigDecimal("1.0000"));
    assertThat(result.get(5).getDtpregini()).isNotNull().isEqualTo(LocalDate.of(1978, 2, 27));
    assertThat(result.get(5).getHistograma().getPrehist()).isNotNull().isEqualTo(new BigDecimal("-1.0000"));
    assertThat(result.get(10).getDtpregini()).isNotNull().isEqualTo(LocalDate.of(1978, 3, 9));
    assertThat(result.get(10).getHistograma().getPrehist()).isNotNull().isEqualTo(new BigDecimal("1.0000"));
  }

  @Test
  public void executeByCodNegNull() {
    //given
    when(macdDAO.listMacdByCodNeg(any())).thenReturn(null);
    when(sinalMacdDAO.listSinalMacdByCodNeg(any())).thenReturn(null);
    //when
    List<HistogramaSemanal> result = target.executeByCodNeg("MGLU3");
    //then
    assertTrue(result.isEmpty());
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

  private List<SinalMacdSemanal> sinalMacdSemanalList(){
    return from(SinalMacdSemanal.class)
        .gimme(11,
            SINAL_MACD_SEMANAL_VALID_001,
            SINAL_MACD_SEMANAL_VALID_002,
            SINAL_MACD_SEMANAL_VALID_003,
            SINAL_MACD_SEMANAL_VALID_004,
            SINAL_MACD_SEMANAL_VALID_005,
            SINAL_MACD_SEMANAL_VALID_006,
            SINAL_MACD_SEMANAL_VALID_007,
            SINAL_MACD_SEMANAL_VALID_008,
            SINAL_MACD_SEMANAL_VALID_009,
            SINAL_MACD_SEMANAL_VALID_010,
            SINAL_MACD_SEMANAL_VALID_011
        );
  }

}