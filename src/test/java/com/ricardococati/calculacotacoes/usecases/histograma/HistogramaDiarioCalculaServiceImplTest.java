package com.ricardococati.calculacotacoes.usecases.histograma;

import static br.com.six2six.fixturefactory.Fixture.from;
import static com.ricardococati.calculacotacoes.templates.MacdDiarioTemplateLoader.MACD_DIARIO_VALID_001;
import static com.ricardococati.calculacotacoes.templates.MacdDiarioTemplateLoader.MACD_DIARIO_VALID_002;
import static com.ricardococati.calculacotacoes.templates.MacdDiarioTemplateLoader.MACD_DIARIO_VALID_003;
import static com.ricardococati.calculacotacoes.templates.MacdDiarioTemplateLoader.MACD_DIARIO_VALID_004;
import static com.ricardococati.calculacotacoes.templates.MacdDiarioTemplateLoader.MACD_DIARIO_VALID_005;
import static com.ricardococati.calculacotacoes.templates.MacdDiarioTemplateLoader.MACD_DIARIO_VALID_006;
import static com.ricardococati.calculacotacoes.templates.MacdDiarioTemplateLoader.MACD_DIARIO_VALID_007;
import static com.ricardococati.calculacotacoes.templates.MacdDiarioTemplateLoader.MACD_DIARIO_VALID_008;
import static com.ricardococati.calculacotacoes.templates.MacdDiarioTemplateLoader.MACD_DIARIO_VALID_009;
import static com.ricardococati.calculacotacoes.templates.MacdDiarioTemplateLoader.MACD_DIARIO_VALID_010;
import static com.ricardococati.calculacotacoes.templates.MacdDiarioTemplateLoader.MACD_DIARIO_VALID_011;
import static com.ricardococati.calculacotacoes.templates.SinalMacdDiarioTemplateLoader.SINAL_MACD_DIARIO_VALID_001;
import static com.ricardococati.calculacotacoes.templates.SinalMacdDiarioTemplateLoader.SINAL_MACD_DIARIO_VALID_002;
import static com.ricardococati.calculacotacoes.templates.SinalMacdDiarioTemplateLoader.SINAL_MACD_DIARIO_VALID_003;
import static com.ricardococati.calculacotacoes.templates.SinalMacdDiarioTemplateLoader.SINAL_MACD_DIARIO_VALID_004;
import static com.ricardococati.calculacotacoes.templates.SinalMacdDiarioTemplateLoader.SINAL_MACD_DIARIO_VALID_005;
import static com.ricardococati.calculacotacoes.templates.SinalMacdDiarioTemplateLoader.SINAL_MACD_DIARIO_VALID_006;
import static com.ricardococati.calculacotacoes.templates.SinalMacdDiarioTemplateLoader.SINAL_MACD_DIARIO_VALID_007;
import static com.ricardococati.calculacotacoes.templates.SinalMacdDiarioTemplateLoader.SINAL_MACD_DIARIO_VALID_008;
import static com.ricardococati.calculacotacoes.templates.SinalMacdDiarioTemplateLoader.SINAL_MACD_DIARIO_VALID_009;
import static com.ricardococati.calculacotacoes.templates.SinalMacdDiarioTemplateLoader.SINAL_MACD_DIARIO_VALID_010;
import static com.ricardococati.calculacotacoes.templates.SinalMacdDiarioTemplateLoader.SINAL_MACD_DIARIO_VALID_011;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.ricardococati.calculacotacoes.adapters.repositories.histograma.HistogramaDiarioInserirDAO;
import com.ricardococati.calculacotacoes.adapters.repositories.macd.MacdDiarioBuscarDAO;
import com.ricardococati.calculacotacoes.adapters.repositories.sinalmacd.SinalMacdDiarioBuscarDAO;
import com.ricardococati.calculacotacoes.entities.domains.histograma.HistogramaDiario;
import com.ricardococati.calculacotacoes.entities.domains.macd.MacdDiario;
import com.ricardococati.calculacotacoes.entities.domains.sinalmacd.SinalMacdDiario;
import com.ricardococati.calculacotacoes.usecases.histograma.impl.HistogramaDiarioCalculaServiceImpl;
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
public class HistogramaDiarioCalculaServiceImplTest {

  @InjectMocks
  private HistogramaDiarioCalculaServiceImpl target;
  @Mock
  private MacdDiarioBuscarDAO macdDAO;
  @Mock
  private SinalMacdDiarioBuscarDAO sinalMacdDAO;
  @Mock
  private HistogramaDiarioInserirDAO histogramaDAO;

  @Before
  public void setUp() throws Exception {
    FixtureFactoryLoader.loadTemplates("com.ricardococati.calculacotacoes.templates");
  }

  @Test
  public void executeByCodNeg() {
    //given
    when(macdDAO.listMacdByCodNeg(any())).thenReturn(macdDiarioList());
    when(sinalMacdDAO.listSinalMacdByCodNeg(any())).thenReturn(sinalMacdDiarioList());
    //when
    List<HistogramaDiario> result = target.executeByCodNeg("MGLU3");
    //then
    assertTrue(!result.isEmpty());
    assertThat(result).isNotNull().size().isEqualTo(11);
    assertThat(result.get(0).getDtpreg()).isNotNull().isEqualTo(LocalDate.of(1978, 2, 16));
    assertThat(result.get(0).getHistograma().getPrehist()).isNotNull().isEqualTo(new BigDecimal("-1.0000"));
    assertThat(result.get(1).getDtpreg()).isNotNull().isEqualTo(LocalDate.of(1978, 2, 17));
    assertThat(result.get(1).getHistograma().getPrehist()).isNotNull().isEqualTo(new BigDecimal("1.0000"));
    assertThat(result.get(5).getDtpreg()).isNotNull().isEqualTo(LocalDate.of(1978, 2, 21));
    assertThat(result.get(5).getHistograma().getPrehist()).isNotNull().isEqualTo(new BigDecimal("-1.0000"));
    assertThat(result.get(10).getDtpreg()).isNotNull().isEqualTo(LocalDate.of(1978, 2, 26));
    assertThat(result.get(10).getHistograma().getPrehist()).isNotNull().isEqualTo(new BigDecimal("1.0000"));
  }

  @Test
  public void executeByCodNegNull() {
    //given
    when(macdDAO.listMacdByCodNeg(any())).thenReturn(null);
    when(sinalMacdDAO.listSinalMacdByCodNeg(any())).thenReturn(null);
    //when
    List<HistogramaDiario> result = target.executeByCodNeg("MGLU3");
    //then
    assertTrue(result.isEmpty());
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

  private List<SinalMacdDiario> sinalMacdDiarioList(){
    return from(SinalMacdDiario.class)
        .gimme(11,
            SINAL_MACD_DIARIO_VALID_001,
            SINAL_MACD_DIARIO_VALID_002,
            SINAL_MACD_DIARIO_VALID_003,
            SINAL_MACD_DIARIO_VALID_004,
            SINAL_MACD_DIARIO_VALID_005,
            SINAL_MACD_DIARIO_VALID_006,
            SINAL_MACD_DIARIO_VALID_007,
            SINAL_MACD_DIARIO_VALID_008,
            SINAL_MACD_DIARIO_VALID_009,
            SINAL_MACD_DIARIO_VALID_010,
            SINAL_MACD_DIARIO_VALID_011
        );
  }

}