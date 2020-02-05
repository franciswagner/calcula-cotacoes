package com.ricardococati.service.impl;

import static br.com.six2six.fixturefactory.Fixture.from;
import static com.ricardococati.service.impl.templates.HistogramaSemanalTemplateLoader.HISTOGRAMA_SEMANAL_VALID_001;
import static com.ricardococati.service.impl.templates.HistogramaSemanalTemplateLoader.HISTOGRAMA_SEMANAL_VALID_002;
import static com.ricardococati.service.impl.templates.HistogramaSemanalTemplateLoader.HISTOGRAMA_SEMANAL_VALID_003;
import static com.ricardococati.service.impl.templates.HistogramaSemanalTemplateLoader.HISTOGRAMA_SEMANAL_VALID_004;
import static com.ricardococati.service.impl.templates.HistogramaSemanalTemplateLoader.HISTOGRAMA_SEMANAL_VALID_005;
import static com.ricardococati.service.impl.templates.HistogramaSemanalTemplateLoader.HISTOGRAMA_SEMANAL_VALID_006;
import static com.ricardococati.service.impl.templates.HistogramaSemanalTemplateLoader.HISTOGRAMA_SEMANAL_VALID_007;
import static com.ricardococati.service.impl.templates.MacdSemanalTemplateLoader.MACD_SEMANAL_VALID_001;
import static com.ricardococati.service.impl.templates.MacdSemanalTemplateLoader.MACD_SEMANAL_VALID_002;
import static com.ricardococati.service.impl.templates.MacdSemanalTemplateLoader.MACD_SEMANAL_VALID_003;
import static com.ricardococati.service.impl.templates.MacdSemanalTemplateLoader.MACD_SEMANAL_VALID_004;
import static com.ricardococati.service.impl.templates.MacdSemanalTemplateLoader.MACD_SEMANAL_VALID_005;
import static com.ricardococati.service.impl.templates.MacdSemanalTemplateLoader.MACD_SEMANAL_VALID_006;
import static com.ricardococati.service.impl.templates.MacdSemanalTemplateLoader.MACD_SEMANAL_VALID_007;
import static com.ricardococati.service.impl.templates.MediaMovelExponencial9PeriodosSemanalTemplateLoader.MEDIA_MOVEL_EXPONENCIAL_SEMANAL_9PERIODOS_VALID_001;
import static com.ricardococati.service.impl.templates.MediaMovelExponencial9PeriodosSemanalTemplateLoader.MEDIA_MOVEL_EXPONENCIAL_SEMANAL_9PERIODOS_VALID_002;
import static com.ricardococati.service.impl.templates.MediaMovelExponencial9PeriodosSemanalTemplateLoader.MEDIA_MOVEL_EXPONENCIAL_SEMANAL_9PERIODOS_VALID_003;
import static com.ricardococati.service.impl.templates.MediaMovelExponencial9PeriodosSemanalTemplateLoader.MEDIA_MOVEL_EXPONENCIAL_SEMANAL_9PERIODOS_VALID_004;
import static com.ricardococati.service.impl.templates.MediaMovelExponencial9PeriodosSemanalTemplateLoader.MEDIA_MOVEL_EXPONENCIAL_SEMANAL_9PERIODOS_VALID_005;
import static com.ricardococati.service.impl.templates.MediaMovelExponencial9PeriodosSemanalTemplateLoader.MEDIA_MOVEL_EXPONENCIAL_SEMANAL_9PERIODOS_VALID_006;
import static com.ricardococati.service.impl.templates.MediaMovelExponencial9PeriodosSemanalTemplateLoader.MEDIA_MOVEL_EXPONENCIAL_SEMANAL_9PERIODOS_VALID_007;
import static com.ricardococati.service.impl.templates.MediaMovelSimplesSemanalTemplateLoader.MEDIA_MOVEL_SIMPLES_SEMANAL_VALID_001;
import static com.ricardococati.service.impl.templates.MediaMovelSimplesSemanalTemplateLoader.MEDIA_MOVEL_SIMPLES_SEMANAL_VALID_002;
import static com.ricardococati.service.impl.templates.MediaMovelSimplesSemanalTemplateLoader.MEDIA_MOVEL_SIMPLES_SEMANAL_VALID_003;
import static com.ricardococati.service.impl.templates.MediaMovelSimplesSemanalTemplateLoader.MEDIA_MOVEL_SIMPLES_SEMANAL_VALID_004;
import static com.ricardococati.service.impl.templates.MediaMovelSimplesSemanalTemplateLoader.MEDIA_MOVEL_SIMPLES_SEMANAL_VALID_005;
import static com.ricardococati.service.impl.templates.MediaMovelSimplesSemanalTemplateLoader.MEDIA_MOVEL_SIMPLES_SEMANAL_VALID_006;
import static com.ricardococati.service.impl.templates.MediaMovelSimplesSemanalTemplateLoader.MEDIA_MOVEL_SIMPLES_SEMANAL_VALID_007;
import static com.ricardococati.service.impl.templates.RecomendacaoSemanalTemplateLoader.RECOMENDACAO_SEMANAL_VALID_001;
import static com.ricardococati.service.impl.templates.RecomendacaoSemanalTemplateLoader.RECOMENDACAO_SEMANAL_VALID_002;
import static com.ricardococati.service.impl.templates.RecomendacaoSemanalTemplateLoader.RECOMENDACAO_SEMANAL_VALID_003;
import static com.ricardococati.service.impl.templates.RecomendacaoSemanalTemplateLoader.RECOMENDACAO_SEMANAL_VALID_004;
import static com.ricardococati.service.impl.templates.RecomendacaoSemanalTemplateLoader.RECOMENDACAO_SEMANAL_VALID_005;
import static com.ricardococati.service.impl.templates.RecomendacaoSemanalTemplateLoader.RECOMENDACAO_SEMANAL_VALID_006;
import static com.ricardococati.service.impl.templates.RecomendacaoSemanalTemplateLoader.RECOMENDACAO_SEMANAL_VALID_007;
import static com.ricardococati.service.impl.templates.SinalMacdSemanalTemplateLoader.SINAL_MACD_SEMANAL_VALID_001;
import static com.ricardococati.service.impl.templates.SinalMacdSemanalTemplateLoader.SINAL_MACD_SEMANAL_VALID_002;
import static com.ricardococati.service.impl.templates.SinalMacdSemanalTemplateLoader.SINAL_MACD_SEMANAL_VALID_003;
import static com.ricardococati.service.impl.templates.SinalMacdSemanalTemplateLoader.SINAL_MACD_SEMANAL_VALID_004;
import static com.ricardococati.service.impl.templates.SinalMacdSemanalTemplateLoader.SINAL_MACD_SEMANAL_VALID_005;
import static com.ricardococati.service.impl.templates.SinalMacdSemanalTemplateLoader.SINAL_MACD_SEMANAL_VALID_006;
import static com.ricardococati.service.impl.templates.SinalMacdSemanalTemplateLoader.SINAL_MACD_SEMANAL_VALID_007;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.ricardococati.model.dto.HistogramaSemanal;
import com.ricardococati.model.dto.MacdSemanal;
import com.ricardococati.model.dto.MediaMovelExponencialSemanal;
import com.ricardococati.model.dto.MediaMovelSimplesSemanal;
import com.ricardococati.model.dto.RecomendacaoSemanal;
import com.ricardococati.model.dto.SinalMacdSemanal;
import com.ricardococati.service.HistogramaSemanalCalculaService;
import com.ricardococati.service.MACDSemanalCalculaService;
import com.ricardococati.service.MediaMovelExponencialSemanalCalculaService;
import com.ricardococati.service.MediaMovelSimplesSemanalCalculaService;
import com.ricardococati.service.RecomendacaoSemanalCalculaService;
import com.ricardococati.service.SinalMacdSemanalCalculaService;
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
public class CalculaGeralSemanalServiceImplTest {

  @InjectMocks
  private CalculaGeralSemanalServiceImpl target;
  @Mock
  private MediaMovelSimplesSemanalCalculaService mmsService;
  @Mock
  private MediaMovelExponencialSemanalCalculaService mmeService;
  @Mock
  private MACDSemanalCalculaService macdService;
  @Mock
  private SinalMacdSemanalCalculaService sinalMacdService;
  @Mock
  private HistogramaSemanalCalculaService histogramaService;
  @Mock
  private RecomendacaoSemanalCalculaService recomendacaoService;
  @Rule
  public ExpectedException thrown = ExpectedException.none();

  private LocalDate dtpreg;

  @Before
  public void setUp() {
    FixtureFactoryLoader.loadTemplates("com.ricardococati.service.impl.templates");
    this.dtpreg = LocalDate.of(1978, 2, 16);
  }

  @Test
  public void executeByCodNeg() throws Exception {
    //given
    when(mmsService.executeByCodNeg(any())).thenReturn(mediaMovelSimplesSemanalList());
    when(mmeService.executeByCodNeg(any())).thenReturn(mediaMovelExponencialSemanalList());
    when(macdService.executeByCodNeg(any())).thenReturn(macdSemanalList());
    when(sinalMacdService.executeByCodNeg(any())).thenReturn(sinalMacdSemanalList());
    when(histogramaService.executeByCodNeg(any())).thenReturn(histogramaSemanalList());
    when(recomendacaoService.executeByCodNeg(any(), any())).thenReturn(recomendacaoSemanalList());
    //when
    List<RecomendacaoSemanal> result = target.executeByCodNeg(getListCodNeg(), dtpreg);
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
    List<RecomendacaoSemanal> result = target.executeByCodNeg(getListCodNeg(), dtpreg);
  }

  private List<String> getListCodNeg() {
    return Arrays.asList("MGLU3", "BPAN4");
  }

  private List<RecomendacaoSemanal> recomendacaoSemanalList(){
    return from(RecomendacaoSemanal.class)
        .gimme(7,
            RECOMENDACAO_SEMANAL_VALID_001,
            RECOMENDACAO_SEMANAL_VALID_002,
            RECOMENDACAO_SEMANAL_VALID_003,
            RECOMENDACAO_SEMANAL_VALID_004,
            RECOMENDACAO_SEMANAL_VALID_005,
            RECOMENDACAO_SEMANAL_VALID_006,
            RECOMENDACAO_SEMANAL_VALID_007
        );
  }

  private List<MediaMovelSimplesSemanal> mediaMovelSimplesSemanalList(){
    return from(MediaMovelSimplesSemanal.class)
        .gimme(7,
            MEDIA_MOVEL_SIMPLES_SEMANAL_VALID_001,
            MEDIA_MOVEL_SIMPLES_SEMANAL_VALID_002,
            MEDIA_MOVEL_SIMPLES_SEMANAL_VALID_003,
            MEDIA_MOVEL_SIMPLES_SEMANAL_VALID_004,
            MEDIA_MOVEL_SIMPLES_SEMANAL_VALID_005,
            MEDIA_MOVEL_SIMPLES_SEMANAL_VALID_006,
            MEDIA_MOVEL_SIMPLES_SEMANAL_VALID_007
        );
  }

  private List<MediaMovelExponencialSemanal> mediaMovelExponencialSemanalList(){
    return from(MediaMovelExponencialSemanal.class)
        .gimme(7,
            MEDIA_MOVEL_EXPONENCIAL_SEMANAL_9PERIODOS_VALID_001,
            MEDIA_MOVEL_EXPONENCIAL_SEMANAL_9PERIODOS_VALID_002,
            MEDIA_MOVEL_EXPONENCIAL_SEMANAL_9PERIODOS_VALID_003,
            MEDIA_MOVEL_EXPONENCIAL_SEMANAL_9PERIODOS_VALID_004,
            MEDIA_MOVEL_EXPONENCIAL_SEMANAL_9PERIODOS_VALID_005,
            MEDIA_MOVEL_EXPONENCIAL_SEMANAL_9PERIODOS_VALID_006,
            MEDIA_MOVEL_EXPONENCIAL_SEMANAL_9PERIODOS_VALID_007
        );
  }

  private List<MacdSemanal> macdSemanalList(){
    return from(MacdSemanal.class)
        .gimme(7,
            MACD_SEMANAL_VALID_001,
            MACD_SEMANAL_VALID_002,
            MACD_SEMANAL_VALID_003,
            MACD_SEMANAL_VALID_004,
            MACD_SEMANAL_VALID_005,
            MACD_SEMANAL_VALID_006,
            MACD_SEMANAL_VALID_007
        );
  }

  private List<SinalMacdSemanal> sinalMacdSemanalList(){
    return from(SinalMacdSemanal.class)
        .gimme(7,
            SINAL_MACD_SEMANAL_VALID_001,
            SINAL_MACD_SEMANAL_VALID_002,
            SINAL_MACD_SEMANAL_VALID_003,
            SINAL_MACD_SEMANAL_VALID_004,
            SINAL_MACD_SEMANAL_VALID_005,
            SINAL_MACD_SEMANAL_VALID_006,
            SINAL_MACD_SEMANAL_VALID_007
        );
  }

  private List<HistogramaSemanal> histogramaSemanalList(){
    return from(HistogramaSemanal.class)
        .gimme(7,
            HISTOGRAMA_SEMANAL_VALID_001,
            HISTOGRAMA_SEMANAL_VALID_002,
            HISTOGRAMA_SEMANAL_VALID_003,
            HISTOGRAMA_SEMANAL_VALID_004,
            HISTOGRAMA_SEMANAL_VALID_005,
            HISTOGRAMA_SEMANAL_VALID_006,
            HISTOGRAMA_SEMANAL_VALID_007
        );
  }

}