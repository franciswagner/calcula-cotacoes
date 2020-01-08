package com.ricardococati.service.impl;

import static br.com.six2six.fixturefactory.Fixture.from;
import static com.ricardococati.service.impl.templates.RecomendacaoDiarioTemplateLoader.RECOMENDACAO_DIARIO_VALID_001;
import static com.ricardococati.service.impl.templates.RecomendacaoDiarioTemplateLoader.RECOMENDACAO_DIARIO_VALID_002;
import static com.ricardococati.service.impl.templates.RecomendacaoDiarioTemplateLoader.RECOMENDACAO_DIARIO_VALID_003;
import static com.ricardococati.service.impl.templates.RecomendacaoDiarioTemplateLoader.RECOMENDACAO_DIARIO_VALID_004;
import static com.ricardococati.service.impl.templates.RecomendacaoDiarioTemplateLoader.RECOMENDACAO_DIARIO_VALID_005;
import static com.ricardococati.service.impl.templates.RecomendacaoDiarioTemplateLoader.RECOMENDACAO_DIARIO_VALID_006;
import static com.ricardococati.service.impl.templates.RecomendacaoDiarioTemplateLoader.RECOMENDACAO_DIARIO_VALID_007;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.ricardococati.model.dto.RecomendacaoDiario;
import com.ricardococati.service.CalculaHistogramaDiarioService;
import com.ricardococati.service.CalculaMACDDiarioService;
import com.ricardococati.service.CalculaMediaMovelExponencialDiarioService;
import com.ricardococati.service.CalculaMediaMovelSimplesDiarioService;
import com.ricardococati.service.CalculaRecomendacaoDiarioService;
import com.ricardococati.service.CalculaSinalMacdDiarioService;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CalculaGeralDiarioServiceImplTest {

  @InjectMocks
  private CalculaGeralDiarioServiceImpl target;
  @Mock
  private CalculaMediaMovelSimplesDiarioService mmsService;
  @Mock
  private CalculaMediaMovelExponencialDiarioService mmeService;
  @Mock
  private CalculaMACDDiarioService macdService;
  @Mock
  private CalculaSinalMacdDiarioService sinalMacdService;
  @Mock
  private CalculaHistogramaDiarioService histogramaService;
  @Mock
  private CalculaRecomendacaoDiarioService recomendacaoService;

  @Before
  public void setUp() {
    FixtureFactoryLoader.loadTemplates("com.ricardococati.service.impl.templates");
  }

  @Test
  public void executeByCodNeg() {
    //given
    List<RecomendacaoDiario> recomendacoes = from(RecomendacaoDiario.class)
        .gimme(7,
            RECOMENDACAO_DIARIO_VALID_001,
            RECOMENDACAO_DIARIO_VALID_002,
            RECOMENDACAO_DIARIO_VALID_003,
            RECOMENDACAO_DIARIO_VALID_004,
            RECOMENDACAO_DIARIO_VALID_005,
            RECOMENDACAO_DIARIO_VALID_006,
            RECOMENDACAO_DIARIO_VALID_007
        );
    when(mmsService.executeByCodNeg(any())).thenReturn(null);
    when(mmeService.executeByCodNeg(any())).thenReturn(null);
    when(macdService.executeByCodNeg(any())).thenReturn(null);
    when(sinalMacdService.executeByCodNeg(any())).thenReturn(null);
    when(histogramaService.executeByCodNeg(any())).thenReturn(null);
    when(recomendacaoService.executeByCodNeg(any(), any())).thenReturn(null);
    //when
    //then
  }

  private List<String> getListCodNeg() {
    return Arrays.asList("MGLU3", "BPAN4");
  }

}