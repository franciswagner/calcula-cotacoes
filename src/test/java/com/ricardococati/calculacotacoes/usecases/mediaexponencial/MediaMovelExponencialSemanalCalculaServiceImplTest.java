package com.ricardococati.calculacotacoes.usecases.mediaexponencial;

import static br.com.six2six.fixturefactory.Fixture.from;
import static com.ricardococati.calculacotacoes.templates.CandlestickSemanalDTOTemplateLoader.CANDLESTICK_SEMANAL_VALID_001;
import static com.ricardococati.calculacotacoes.templates.CandlestickSemanalDTOTemplateLoader.CANDLESTICK_SEMANAL_VALID_002;
import static com.ricardococati.calculacotacoes.templates.CandlestickSemanalDTOTemplateLoader.CANDLESTICK_SEMANAL_VALID_003;
import static com.ricardococati.calculacotacoes.templates.CandlestickSemanalDTOTemplateLoader.CANDLESTICK_SEMANAL_VALID_004;
import static com.ricardococati.calculacotacoes.templates.CandlestickSemanalDTOTemplateLoader.CANDLESTICK_SEMANAL_VALID_005;
import static com.ricardococati.calculacotacoes.templates.CandlestickSemanalDTOTemplateLoader.CANDLESTICK_SEMANAL_VALID_006;
import static com.ricardococati.calculacotacoes.templates.CandlestickSemanalDTOTemplateLoader.CANDLESTICK_SEMANAL_VALID_007;
import static com.ricardococati.calculacotacoes.templates.CandlestickSemanalDTOTemplateLoader.CANDLESTICK_SEMANAL_VALID_008;
import static com.ricardococati.calculacotacoes.templates.CandlestickSemanalDTOTemplateLoader.CANDLESTICK_SEMANAL_VALID_009;
import static com.ricardococati.calculacotacoes.templates.CandlestickSemanalDTOTemplateLoader.CANDLESTICK_SEMANAL_VALID_010;
import static com.ricardococati.calculacotacoes.templates.CandlestickSemanalDTOTemplateLoader.CANDLESTICK_SEMANAL_VALID_011;
import static com.ricardococati.calculacotacoes.templates.CandlestickSemanalDTOTemplateLoader.CANDLESTICK_SEMANAL_VALID_012;
import static com.ricardococati.calculacotacoes.templates.CandlestickSemanalDTOTemplateLoader.CANDLESTICK_SEMANAL_VALID_013;
import static com.ricardococati.calculacotacoes.templates.CandlestickSemanalDTOTemplateLoader.CANDLESTICK_SEMANAL_VALID_014;
import static com.ricardococati.calculacotacoes.templates.CandlestickSemanalDTOTemplateLoader.CANDLESTICK_SEMANAL_VALID_015;
import static com.ricardococati.calculacotacoes.templates.CandlestickSemanalDTOTemplateLoader.CANDLESTICK_SEMANAL_VALID_016;
import static com.ricardococati.calculacotacoes.templates.CandlestickSemanalDTOTemplateLoader.CANDLESTICK_SEMANAL_VALID_017;
import static com.ricardococati.calculacotacoes.templates.CandlestickSemanalDTOTemplateLoader.CANDLESTICK_SEMANAL_VALID_018;
import static com.ricardococati.calculacotacoes.templates.CandlestickSemanalDTOTemplateLoader.CANDLESTICK_SEMANAL_VALID_019;
import static com.ricardococati.calculacotacoes.templates.CandlestickSemanalDTOTemplateLoader.CANDLESTICK_SEMANAL_VALID_020;
import static com.ricardococati.calculacotacoes.utils.geral.BigDecimalCustomizado.sendDoubleGetValueBigDecimalArredonda4Casas;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.ricardococati.calculacotacoes.adapters.repositories.mediaexponencial.MediaMovelExponencialSemanalBuscarDAO;
import com.ricardococati.calculacotacoes.adapters.repositories.mediaexponencial.MediaMovelExponencialSemanalInserirDAO;
import com.ricardococati.calculacotacoes.adapters.repositories.mediasimples.MediaMovelSimplesSemanalBuscarDAO;
import com.ricardococati.calculacotacoes.entities.domains.candlestick.CandlestickSemanal;
import com.ricardococati.calculacotacoes.entities.domains.mediaexponencial.MediaMovelExponencialSemanal;
import com.ricardococati.calculacotacoes.entities.domains.mediasimples.MediaMovelSimples;
import com.ricardococati.calculacotacoes.entities.domains.mediasimples.MediaMovelSimplesSemanal;
import com.ricardococati.calculacotacoes.usecases.candlestick.CandlestickSemanalBuscarService;
import com.ricardococati.calculacotacoes.usecases.mediaexponencial.impl.MediaMovelExponencialSemanalCalculaServiceImpl;
import java.time.LocalDate;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MediaMovelExponencialSemanalCalculaServiceImplTest {

  @InjectMocks
  private MediaMovelExponencialSemanalCalculaServiceImpl target;
  @Mock
  private CandlestickSemanalBuscarService semanalService;
  @Mock
  private MediaMovelSimplesSemanalBuscarDAO mediaMovelSimplesDAO;
  @Mock
  private MediaMovelExponencialSemanalBuscarDAO mmeDAO;
  @Mock
  private MediaMovelExponencialSemanalInserirDAO mmeInserirDAO;

  private LocalDate dtpreg;

  @Before
  public void setUp() {
    FixtureFactoryLoader.loadTemplates("com.ricardococati.calculacotacoes.templates");
    this.dtpreg = LocalDate.of(1978, 2, 16);
  }

  @Test
  public void executeByCodNeg() throws Exception {
    //given
    List<CandlestickSemanal> candlestickList = getListCandlestickSemanal();
    when(semanalService.buscaCandlestickSemanalPorCodNeg(any())).thenReturn(candlestickList);
    final int periodo = 9;
    when(mediaMovelSimplesDAO.buscaMediaSimplesPorCodNegPeriodoDtPreg(any(), any(), any(), any()))
        .thenReturn(buildMediaSimples("MGLU3", 10.1, dtpreg.plusDays(periodo-1), periodo));

    //when
    List<MediaMovelExponencialSemanal> returned = target.executeByCodNeg("MGLU3");

    //then
    assertTrue(!returned.isEmpty());
    assertThat(returned).isNotNull().size().isEqualTo(29);
  }

  @Test
  public void executeByCodNegCandlestickNull() throws Exception {
    //given
    when(semanalService.buscaCandlestickSemanalPorCodNeg(any())).thenReturn(null);
    when(mediaMovelSimplesDAO.buscaMediaSimplesPorCodNegPeriodoDtPreg(any(), any(), any(), any()))
        .thenReturn(buildMediaSimples("MGLU3", 10.1, dtpreg, 9));
    //when
    List<MediaMovelExponencialSemanal> returned = target.executeByCodNeg("MGLU3");
    //then
    assertTrue(returned.isEmpty());
  }

  @Test
  public void executeByCodNegCandlestickEmpty() throws Exception {
    //given
    when(semanalService.buscaCandlestickSemanalPorCodNeg(any())).thenReturn(null);
    when(mediaMovelSimplesDAO.buscaMediaSimplesPorCodNegPeriodoDtPreg(any(), any(), any(), any()))
        .thenReturn(buildMediaSimples("MGLU3", 10.1, dtpreg, 9));
    //when
    List<MediaMovelExponencialSemanal> returned = target.executeByCodNeg("MGLU3");
    //then
    assertTrue(returned.isEmpty());
  }

  private List<CandlestickSemanal> getListCandlestickSemanal() {
    return from(CandlestickSemanal.class)
        .gimme(20, CANDLESTICK_SEMANAL_VALID_001
            , CANDLESTICK_SEMANAL_VALID_002
            , CANDLESTICK_SEMANAL_VALID_003
            , CANDLESTICK_SEMANAL_VALID_004
            , CANDLESTICK_SEMANAL_VALID_005
            , CANDLESTICK_SEMANAL_VALID_006
            , CANDLESTICK_SEMANAL_VALID_007
            , CANDLESTICK_SEMANAL_VALID_008
            , CANDLESTICK_SEMANAL_VALID_009
            , CANDLESTICK_SEMANAL_VALID_010
            , CANDLESTICK_SEMANAL_VALID_011
            , CANDLESTICK_SEMANAL_VALID_012
            , CANDLESTICK_SEMANAL_VALID_013
            , CANDLESTICK_SEMANAL_VALID_014
            , CANDLESTICK_SEMANAL_VALID_015
            , CANDLESTICK_SEMANAL_VALID_016
            , CANDLESTICK_SEMANAL_VALID_017
            , CANDLESTICK_SEMANAL_VALID_018
            , CANDLESTICK_SEMANAL_VALID_019
            , CANDLESTICK_SEMANAL_VALID_020);
  }

  private MediaMovelSimplesSemanal buildMediaSimples(
      final String codneg,
      final Double preult,
      final LocalDate dtpreg,
      final Integer periodo
  ) {
    return MediaMovelSimplesSemanal
        .builder()
        .dtpregini(dtpreg)
        .mediaMovelSimples(MediaMovelSimples
            .builder()
            .premedult(sendDoubleGetValueBigDecimalArredonda4Casas(preult))
            .codneg(codneg)
            .periodo(periodo)
            .build()
        )
        .build();
  }

}