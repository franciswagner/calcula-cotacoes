package com.ricardococati.calculacotacoes.usecases.calculageral;

import static br.com.six2six.fixturefactory.Fixture.from;
import static com.ricardococati.calculacotacoes.templates.HistogramaDiarioTemplateLoader.HISTOGRAMA_DIARIO_VALID_001;
import static com.ricardococati.calculacotacoes.templates.HistogramaDiarioTemplateLoader.HISTOGRAMA_DIARIO_VALID_002;
import static com.ricardococati.calculacotacoes.templates.HistogramaDiarioTemplateLoader.HISTOGRAMA_DIARIO_VALID_003;
import static com.ricardococati.calculacotacoes.templates.HistogramaDiarioTemplateLoader.HISTOGRAMA_DIARIO_VALID_004;
import static com.ricardococati.calculacotacoes.templates.HistogramaDiarioTemplateLoader.HISTOGRAMA_DIARIO_VALID_005;
import static com.ricardococati.calculacotacoes.templates.HistogramaDiarioTemplateLoader.HISTOGRAMA_DIARIO_VALID_006;
import static com.ricardococati.calculacotacoes.templates.HistogramaDiarioTemplateLoader.HISTOGRAMA_DIARIO_VALID_007;
import static com.ricardococati.calculacotacoes.templates.MacdDiarioTemplateLoader.MACD_DIARIO_VALID_001;
import static com.ricardococati.calculacotacoes.templates.MacdDiarioTemplateLoader.MACD_DIARIO_VALID_002;
import static com.ricardococati.calculacotacoes.templates.MacdDiarioTemplateLoader.MACD_DIARIO_VALID_003;
import static com.ricardococati.calculacotacoes.templates.MacdDiarioTemplateLoader.MACD_DIARIO_VALID_004;
import static com.ricardococati.calculacotacoes.templates.MacdDiarioTemplateLoader.MACD_DIARIO_VALID_005;
import static com.ricardococati.calculacotacoes.templates.MacdDiarioTemplateLoader.MACD_DIARIO_VALID_006;
import static com.ricardococati.calculacotacoes.templates.MacdDiarioTemplateLoader.MACD_DIARIO_VALID_007;
import static com.ricardococati.calculacotacoes.templates.MediaMovelExponencial9PeriodosDiarioTemplateLoader.MEDIA_MOVEL_EXPONENCIAL_DIARIO_9PERIODOS_VALID_001;
import static com.ricardococati.calculacotacoes.templates.MediaMovelExponencial9PeriodosDiarioTemplateLoader.MEDIA_MOVEL_EXPONENCIAL_DIARIO_9PERIODOS_VALID_002;
import static com.ricardococati.calculacotacoes.templates.MediaMovelExponencial9PeriodosDiarioTemplateLoader.MEDIA_MOVEL_EXPONENCIAL_DIARIO_9PERIODOS_VALID_003;
import static com.ricardococati.calculacotacoes.templates.MediaMovelExponencial9PeriodosDiarioTemplateLoader.MEDIA_MOVEL_EXPONENCIAL_DIARIO_9PERIODOS_VALID_004;
import static com.ricardococati.calculacotacoes.templates.MediaMovelExponencial9PeriodosDiarioTemplateLoader.MEDIA_MOVEL_EXPONENCIAL_DIARIO_9PERIODOS_VALID_005;
import static com.ricardococati.calculacotacoes.templates.MediaMovelExponencial9PeriodosDiarioTemplateLoader.MEDIA_MOVEL_EXPONENCIAL_DIARIO_9PERIODOS_VALID_006;
import static com.ricardococati.calculacotacoes.templates.MediaMovelExponencial9PeriodosDiarioTemplateLoader.MEDIA_MOVEL_EXPONENCIAL_DIARIO_9PERIODOS_VALID_007;
import static com.ricardococati.calculacotacoes.templates.MediaMovelSimplesDiarioTemplateLoader.MEDIA_MOVEL_SIMPLES_DIARIO_VALID_001;
import static com.ricardococati.calculacotacoes.templates.MediaMovelSimplesDiarioTemplateLoader.MEDIA_MOVEL_SIMPLES_DIARIO_VALID_002;
import static com.ricardococati.calculacotacoes.templates.MediaMovelSimplesDiarioTemplateLoader.MEDIA_MOVEL_SIMPLES_DIARIO_VALID_003;
import static com.ricardococati.calculacotacoes.templates.MediaMovelSimplesDiarioTemplateLoader.MEDIA_MOVEL_SIMPLES_DIARIO_VALID_004;
import static com.ricardococati.calculacotacoes.templates.MediaMovelSimplesDiarioTemplateLoader.MEDIA_MOVEL_SIMPLES_DIARIO_VALID_005;
import static com.ricardococati.calculacotacoes.templates.MediaMovelSimplesDiarioTemplateLoader.MEDIA_MOVEL_SIMPLES_DIARIO_VALID_006;
import static com.ricardococati.calculacotacoes.templates.MediaMovelSimplesDiarioTemplateLoader.MEDIA_MOVEL_SIMPLES_DIARIO_VALID_007;
import static com.ricardococati.calculacotacoes.templates.RecomendacaoDiarioTemplateLoader.RECOMENDACAO_DIARIO_VALID_001;
import static com.ricardococati.calculacotacoes.templates.RecomendacaoDiarioTemplateLoader.RECOMENDACAO_DIARIO_VALID_002;
import static com.ricardococati.calculacotacoes.templates.RecomendacaoDiarioTemplateLoader.RECOMENDACAO_DIARIO_VALID_003;
import static com.ricardococati.calculacotacoes.templates.RecomendacaoDiarioTemplateLoader.RECOMENDACAO_DIARIO_VALID_004;
import static com.ricardococati.calculacotacoes.templates.RecomendacaoDiarioTemplateLoader.RECOMENDACAO_DIARIO_VALID_005;
import static com.ricardococati.calculacotacoes.templates.RecomendacaoDiarioTemplateLoader.RECOMENDACAO_DIARIO_VALID_006;
import static com.ricardococati.calculacotacoes.templates.RecomendacaoDiarioTemplateLoader.RECOMENDACAO_DIARIO_VALID_007;
import static com.ricardococati.calculacotacoes.templates.SinalMacdDiarioTemplateLoader.SINAL_MACD_DIARIO_VALID_001;
import static com.ricardococati.calculacotacoes.templates.SinalMacdDiarioTemplateLoader.SINAL_MACD_DIARIO_VALID_002;
import static com.ricardococati.calculacotacoes.templates.SinalMacdDiarioTemplateLoader.SINAL_MACD_DIARIO_VALID_003;
import static com.ricardococati.calculacotacoes.templates.SinalMacdDiarioTemplateLoader.SINAL_MACD_DIARIO_VALID_004;
import static com.ricardococati.calculacotacoes.templates.SinalMacdDiarioTemplateLoader.SINAL_MACD_DIARIO_VALID_005;
import static com.ricardococati.calculacotacoes.templates.SinalMacdDiarioTemplateLoader.SINAL_MACD_DIARIO_VALID_006;
import static com.ricardococati.calculacotacoes.templates.SinalMacdDiarioTemplateLoader.SINAL_MACD_DIARIO_VALID_007;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.ricardococati.calculacotacoes.adapters.message.action.RecomendacaoActionListener;
import com.ricardococati.calculacotacoes.entities.domains.histograma.HistogramaDiario;
import com.ricardococati.calculacotacoes.entities.domains.macd.MacdDiario;
import com.ricardococati.calculacotacoes.entities.domains.mediaexponencial.MediaMovelExponencialDiario;
import com.ricardococati.calculacotacoes.entities.domains.mediasimples.MediaMovelSimplesDiario;
import com.ricardococati.calculacotacoes.entities.domains.recomendacao.RecomendacaoDiario;
import com.ricardococati.calculacotacoes.entities.domains.sinalmacd.SinalMacdDiario;
import com.ricardococati.calculacotacoes.usecases.calculageral.impl.CalculaGeralDiarioServiceImpl;
import com.ricardococati.calculacotacoes.usecases.histograma.HistogramaDiarioCalculaService;
import com.ricardococati.calculacotacoes.usecases.macd.MACDDiarioCalculaService;
import com.ricardococati.calculacotacoes.usecases.mediaexponencial.MediaMovelExponencialDiarioCalculaService;
import com.ricardococati.calculacotacoes.usecases.mediasimples.MediaMovelSimplesDiarioCalculaService;
import com.ricardococati.calculacotacoes.usecases.recomendacao.RecomendacaoDiarioCalculaService;
import com.ricardococati.calculacotacoes.usecases.sinalmacd.SinalMacdDiarioCalculaService;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CalculaGeralDiarioServiceImplTest {

  @InjectMocks
  private CalculaGeralDiarioServiceImpl target;
  @Mock
  private MediaMovelSimplesDiarioCalculaService mmsService;
  @Mock
  private MediaMovelExponencialDiarioCalculaService mmeService;
  @Mock
  private MACDDiarioCalculaService macdService;
  @Mock
  private SinalMacdDiarioCalculaService sinalMacdService;
  @Mock
  private HistogramaDiarioCalculaService histogramaService;
  @Mock
  private RecomendacaoDiarioCalculaService recomendacaoService;
  @Mock
  private RecomendacaoActionListener actionListener;
  @Rule
  public ExpectedException thrown = ExpectedException.none();

  private LocalDate dtpreg;

  @Before
  public void setUp() {
    FixtureFactoryLoader.loadTemplates("com.ricardococati.calculacotacoes.templates");
    this.dtpreg = LocalDate.of(1978, 2, 16);
  }

  @Test
  public void executeByCodNeg() throws Exception {
    //given
    when(mmsService.executeByCodNeg(any())).thenReturn(mediaMovelSimplesDiarioList());
    when(mmeService.executeByCodNeg(any())).thenReturn(mediaMovelExponencialDiarioList());
    when(macdService.executeByCodNeg(any())).thenReturn(macdDiarioList());
    when(sinalMacdService.executeByCodNeg(any())).thenReturn(sinalMacdDiarioList());
    when(histogramaService.executeByCodNeg(any())).thenReturn(histogramaDiarioList());
    when(recomendacaoService.executeByCodNeg(any(), any())).thenReturn(recomendacaoDiarioList());
    //when
    List<RecomendacaoDiario> result = target.executeByCodNeg(getListCodNeg(), dtpreg);
    //then
    assertTrue(!result.isEmpty());
    assertThat(result).isNotNull().size().isEqualTo(7);
  }

  @Test
  public void executeByCodNegNull() throws Exception {
    //given
    when(mmsService.executeByCodNeg(any())).thenReturn(null);
    when(mmeService.executeByCodNeg(any())).thenReturn(null);
    when(macdService.executeByCodNeg(any())).thenReturn(null);
    when(sinalMacdService.executeByCodNeg(any())).thenReturn(null);
    when(histogramaService.executeByCodNeg(any())).thenReturn(null);
    when(recomendacaoService.executeByCodNeg(any(), any())).thenReturn(null);
    this.thrown.expect(Exception.class);
    //when
    List<RecomendacaoDiario> result = target.executeByCodNeg(getListCodNeg(), dtpreg);
  }

  private List<String> getListCodNeg() {
    return Arrays.asList("MGLU3", "BPAN4");
  }

  private List<RecomendacaoDiario> recomendacaoDiarioList(){
    return from(RecomendacaoDiario.class)
        .gimme(7,
            RECOMENDACAO_DIARIO_VALID_001,
            RECOMENDACAO_DIARIO_VALID_002,
            RECOMENDACAO_DIARIO_VALID_003,
            RECOMENDACAO_DIARIO_VALID_004,
            RECOMENDACAO_DIARIO_VALID_005,
            RECOMENDACAO_DIARIO_VALID_006,
            RECOMENDACAO_DIARIO_VALID_007
        );
  }

  private List<MediaMovelSimplesDiario> mediaMovelSimplesDiarioList(){
    return from(MediaMovelSimplesDiario.class)
        .gimme(7,
            MEDIA_MOVEL_SIMPLES_DIARIO_VALID_001,
            MEDIA_MOVEL_SIMPLES_DIARIO_VALID_002,
            MEDIA_MOVEL_SIMPLES_DIARIO_VALID_003,
            MEDIA_MOVEL_SIMPLES_DIARIO_VALID_004,
            MEDIA_MOVEL_SIMPLES_DIARIO_VALID_005,
            MEDIA_MOVEL_SIMPLES_DIARIO_VALID_006,
            MEDIA_MOVEL_SIMPLES_DIARIO_VALID_007
        );
  }

  private List<MediaMovelExponencialDiario> mediaMovelExponencialDiarioList(){
    return from(MediaMovelExponencialDiario.class)
        .gimme(7,
            MEDIA_MOVEL_EXPONENCIAL_DIARIO_9PERIODOS_VALID_001,
            MEDIA_MOVEL_EXPONENCIAL_DIARIO_9PERIODOS_VALID_002,
            MEDIA_MOVEL_EXPONENCIAL_DIARIO_9PERIODOS_VALID_003,
            MEDIA_MOVEL_EXPONENCIAL_DIARIO_9PERIODOS_VALID_004,
            MEDIA_MOVEL_EXPONENCIAL_DIARIO_9PERIODOS_VALID_005,
            MEDIA_MOVEL_EXPONENCIAL_DIARIO_9PERIODOS_VALID_006,
            MEDIA_MOVEL_EXPONENCIAL_DIARIO_9PERIODOS_VALID_007
        );
  }

  private List<MacdDiario> macdDiarioList(){
    return from(MacdDiario.class)
        .gimme(7,
            MACD_DIARIO_VALID_001,
            MACD_DIARIO_VALID_002,
            MACD_DIARIO_VALID_003,
            MACD_DIARIO_VALID_004,
            MACD_DIARIO_VALID_005,
            MACD_DIARIO_VALID_006,
            MACD_DIARIO_VALID_007
        );
  }

  private List<SinalMacdDiario> sinalMacdDiarioList(){
    return from(SinalMacdDiario.class)
        .gimme(7,
            SINAL_MACD_DIARIO_VALID_001,
            SINAL_MACD_DIARIO_VALID_002,
            SINAL_MACD_DIARIO_VALID_003,
            SINAL_MACD_DIARIO_VALID_004,
            SINAL_MACD_DIARIO_VALID_005,
            SINAL_MACD_DIARIO_VALID_006,
            SINAL_MACD_DIARIO_VALID_007
        );
  }

  private List<HistogramaDiario> histogramaDiarioList(){
    return from(HistogramaDiario.class)
        .gimme(7,
            HISTOGRAMA_DIARIO_VALID_001,
            HISTOGRAMA_DIARIO_VALID_002,
            HISTOGRAMA_DIARIO_VALID_003,
            HISTOGRAMA_DIARIO_VALID_004,
            HISTOGRAMA_DIARIO_VALID_005,
            HISTOGRAMA_DIARIO_VALID_006,
            HISTOGRAMA_DIARIO_VALID_007
        );
  }

}