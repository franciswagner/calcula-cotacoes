package com.ricardococati.calculacotacoes.adapters.repositories.recomendacao;

import static br.com.six2six.fixturefactory.Fixture.from;
import static com.ricardococati.calculacotacoes.templates.CandlestickDiarioDTOTemplateLoader.CANDLESTICK_DIARIO_VALID_001;
import static com.ricardococati.calculacotacoes.templates.HistogramaDiarioTemplateLoader.HISTOGRAMA_DIARIO_VALID_001;
import static com.ricardococati.calculacotacoes.templates.MacdDiarioTemplateLoader.MACD_DIARIO_VALID_001;
import static com.ricardococati.calculacotacoes.templates.MediaMovelExponencial12PeriodosDiarioTemplateLoader.MEDIA_MOVEL_EXPONENCIAL_DIARIO_12PERIODOS_VALID_001;
import static com.ricardococati.calculacotacoes.templates.MediaMovelExponencial26PeriodosDiarioTemplateLoader.MEDIA_MOVEL_EXPONENCIAL_DIARIO_26PERIODOS_VALID_001;
import static com.ricardococati.calculacotacoes.templates.SinalMacdDiarioTemplateLoader.SINAL_MACD_DIARIO_VALID_001;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.ricardococati.calculacotacoes.adapters.repositories.candlestick.impl.CandlestickDiarioInserirDAOImpl;
import com.ricardococati.calculacotacoes.adapters.repositories.candlestick.sqlutil.CandlestickDiarioInserirSQLUtil;
import com.ricardococati.calculacotacoes.adapters.repositories.gerasequencia.impl.GeraSequenciaDAOImpl;
import com.ricardococati.calculacotacoes.adapters.repositories.histograma.impl.HistogramaDiarioInserirDAOImpl;
import com.ricardococati.calculacotacoes.adapters.repositories.histograma.sqlutil.HistogramaDiarioSQLUtil;
import com.ricardococati.calculacotacoes.adapters.repositories.macd.impl.MacdDiarioInserirDAOImpl;
import com.ricardococati.calculacotacoes.adapters.repositories.macd.sqlutil.MacdDiarioSQLUtil;
import com.ricardococati.calculacotacoes.adapters.repositories.mediaexponencial.impl.MediaMovelExponencialDiarioInserirDAOImpl;
import com.ricardococati.calculacotacoes.adapters.repositories.mediaexponencial.sqlutil.MediaMovelExponencialDiarioSQLUtil;
import com.ricardococati.calculacotacoes.adapters.repositories.recomendacao.impl.RecomendacaoDiarioBuscarDAOImpl;
import com.ricardococati.calculacotacoes.adapters.repositories.recomendacao.mapper.RecomendacaoDiarioMapper;
import com.ricardococati.calculacotacoes.adapters.repositories.recomendacao.sqlutil.RecomendacaoDiarioBuscarSQLUtil;
import com.ricardococati.calculacotacoes.adapters.repositories.sinalmacd.impl.SinalMacdDiarioInserirDAOImpl;
import com.ricardococati.calculacotacoes.adapters.repositories.sinalmacd.sqlutil.SinalMacdDiarioSQLUtil;
import com.ricardococati.calculacotacoes.config.BaseJdbcTest;
import com.ricardococati.calculacotacoes.entities.domains.candlestick.CandlestickDiario;
import com.ricardococati.calculacotacoes.entities.domains.histograma.HistogramaDiario;
import com.ricardococati.calculacotacoes.entities.domains.macd.MacdDiario;
import com.ricardococati.calculacotacoes.entities.domains.mediaexponencial.MediaMovelExponencialDiario;
import com.ricardococati.calculacotacoes.entities.domains.recomendacao.RecomendacaoDiario;
import com.ricardococati.calculacotacoes.entities.domains.sinalmacd.SinalMacdDiario;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class RecomendacaoDiarioBuscarDAOImplTest extends BaseJdbcTest {

  @InjectMocks
  private RecomendacaoDiarioBuscarDAOImpl target;
  @Mock
  private RecomendacaoDiarioBuscarSQLUtil sqlUtil;
  @Mock
  private RecomendacaoDiarioMapper mapper;
  @Mock
  private CandlestickDiarioInserirSQLUtil incluirCandle;
  @Mock
  private MediaMovelExponencialDiarioSQLUtil incluirMME;
  @Mock
  private MacdDiarioSQLUtil incluirMacd;
  @Mock
  private SinalMacdDiarioSQLUtil incluirSinalMacd;
  @Mock
  private HistogramaDiarioSQLUtil incluirHistograma;
  @Mock
  private GeraSequenciaDAOImpl genericDAO;

  @Before
  public void setUp() throws Exception {
    FixtureFactoryLoader.loadTemplates("com.ricardococati.calculacotacoes.templates");
    target = new RecomendacaoDiarioBuscarDAOImpl(getNamedParameterJdbcTemplate(), sqlUtil, mapper);
    incluiCandleAntesDeExecutarTestes();
    incluirMMEAntesDeExecutarTestes();
    incluiMacdAntesDeExecutarTestes();
    incluiSinalMacdAntesDeExecutarTestes();
    incluiHistogramaAntesDeExecutarTestes();
  }

  @Test
  public void getListRecomendacaoByDtPregECodNeg() {
    //given
    LocalDate dtpregLocal = LocalDate.of(1978,2,16);
    when(sqlUtil.getSelectByCodNegDtPreg()).thenCallRealMethod();
    when(sqlUtil.toParametersCodNegDtPreg(any(), any())).thenCallRealMethod();
    when(mapper.mapperConsult(any())).thenCallRealMethod();
    //when
    List<RecomendacaoDiario> result =
        target.getListRecomendacaoByDtPregECodNeg(dtpregLocal, "MGLU3");
    //then
    assertTrue(!result.isEmpty());
    assertThat(result).isNotNull().size().isEqualTo(1);
    assertThat(result.get(0).getDtpreg()).isNotNull().isEqualTo(LocalDate.of(1978, 2, 16));
    assertThat(result.get(0).getRecomendacao().getCodneg()).isNotNull().isEqualTo("MGLU3");
    assertThat(result.get(0).getRecomendacao().getPrecoFechamento()).isNotNull().isEqualTo(new BigDecimal("11.10"));
    assertThat(result.get(0).getRecomendacao().getPrecoMME12p()).isNotNull().isEqualTo(new BigDecimal("13.11"));
    assertThat(result.get(0).getRecomendacao().getPrecoMME26p()).isNotNull().isEqualTo(new BigDecimal("12.11"));
    assertThat(result.get(0).getRecomendacao().getPrecoMacd()).isNotNull().isEqualTo(new BigDecimal("11.11"));
    assertThat(result.get(0).getRecomendacao().getPrecoSinalMacd()).isNotNull().isEqualTo(new BigDecimal("12.11"));
    assertThat(result.get(0).getRecomendacao().getPrecoHistograma()).isNotNull().isEqualTo(new BigDecimal("11.11"));
  }

  @Test
  public void getListRecomendacaoByDtPregECodNegNull() {
    //given
    LocalDate dtpregLocal = LocalDate.of(1978,2,16);
    when(sqlUtil.getSelectByCodNegDtPreg()).thenCallRealMethod();
    when(sqlUtil.toParametersCodNegDtPreg(any(), any())).thenCallRealMethod();
    when(mapper.mapperConsult(any())).thenCallRealMethod();
    //when
    List<RecomendacaoDiario> result =
        target.getListRecomendacaoByDtPregECodNeg(dtpregLocal, null);
    //then
    assertTrue(result.isEmpty());
  }

  @Test
  public void getListRecomendacaoByDtPregNullECodNeg() {
    //given
    when(sqlUtil.getSelectByCodNegDtPreg()).thenCallRealMethod();
    when(sqlUtil.toParametersCodNegDtPreg(any(), any())).thenCallRealMethod();
    when(mapper.mapperConsult(any())).thenCallRealMethod();
    //when
    List<RecomendacaoDiario> result =
        target.getListRecomendacaoByDtPregECodNeg(null, "MGLU3");
    //then
    assertTrue(result.isEmpty());
  }

  @Test
  public void getListRecomendacaoByDtPregNullECodNegNull() {
    //given
    when(sqlUtil.getSelectByCodNegDtPreg()).thenCallRealMethod();
    when(sqlUtil.toParametersCodNegDtPreg(any(), any())).thenCallRealMethod();
    when(mapper.mapperConsult(any())).thenCallRealMethod();
    //when
    List<RecomendacaoDiario> result =
        target.getListRecomendacaoByDtPregECodNeg(null, null);
    //then
    assertTrue(result.isEmpty());
  }

  private void incluiCandleAntesDeExecutarTestes() {
    CandlestickDiarioInserirDAOImpl incluirDAO = new CandlestickDiarioInserirDAOImpl(
        getNamedParameterJdbcTemplate(), genericDAO, incluirCandle);
    when(incluirCandle.getInsert()).thenCallRealMethod();
    when(incluirCandle.toParameters(any())).thenCallRealMethod();
    when(genericDAO.getSequence(any())).thenReturn(1);
    incluirDAO.insereCandlestickDiario(getCandlestickDiario());
  }

  private void incluirMMEAntesDeExecutarTestes() {
    MediaMovelExponencialDiarioInserirDAOImpl incluirDAO = new MediaMovelExponencialDiarioInserirDAOImpl(
        getNamedParameterJdbcTemplate(), genericDAO, incluirMME);
    when(incluirMME.getInsert()).thenCallRealMethod();
    when(incluirMME.toParameters(any())).thenCallRealMethod();
    when(genericDAO.getSequence(any())).thenReturn(1);
    mediaMovelExponencialDiarioPeriodosList()
        .stream()
        .filter(Objects::nonNull)
        .forEach(incluirDAO::incluirMediaMovelExponencial);
  }

  private void incluiMacdAntesDeExecutarTestes() {
    MacdDiarioInserirDAOImpl incluirDAO = new MacdDiarioInserirDAOImpl(
        getNamedParameterJdbcTemplate(), genericDAO, incluirMacd);
    when(incluirMacd.getInsert()).thenCallRealMethod();
    when(incluirMacd.toParameters(any())).thenCallRealMethod();
    when(genericDAO.getSequence(any())).thenReturn(1);
    macdDiarioList()
        .stream()
        .filter(Objects::nonNull)
        .forEach(incluirDAO::incluirMacd);
  }

  private void incluiSinalMacdAntesDeExecutarTestes() {
    SinalMacdDiarioInserirDAOImpl incluirDAO = new SinalMacdDiarioInserirDAOImpl(
        getNamedParameterJdbcTemplate(), genericDAO, incluirSinalMacd);
    when(incluirSinalMacd.getInsert()).thenCallRealMethod();
    when(incluirSinalMacd.toParameters(any())).thenCallRealMethod();
    when(genericDAO.getSequence(any())).thenReturn(1);
    sinalMacdDiarioList()
        .stream()
        .filter(Objects::nonNull)
        .forEach(incluirDAO::incluirSinalMacd);
  }

  private void incluiHistogramaAntesDeExecutarTestes() {
    HistogramaDiarioInserirDAOImpl incluirDAO = new HistogramaDiarioInserirDAOImpl(
        getNamedParameterJdbcTemplate(), genericDAO, incluirHistograma);
    when(incluirHistograma.getInsert()).thenCallRealMethod();
    when(incluirHistograma.toParameters(any())).thenCallRealMethod();
    when(genericDAO.getSequence(any())).thenReturn(1);
    histogramaDiarioList()
        .stream()
        .forEach(incluirDAO::incluirHistograma);
  }

  private CandlestickDiario getCandlestickDiario() {
    return from(CandlestickDiario.class)
        .gimme(CANDLESTICK_DIARIO_VALID_001);
  }

  private List<MediaMovelExponencialDiario> mediaMovelExponencialDiarioPeriodosList(){
    return from(MediaMovelExponencialDiario.class)
        .gimme(2,MEDIA_MOVEL_EXPONENCIAL_DIARIO_12PERIODOS_VALID_001,
            MEDIA_MOVEL_EXPONENCIAL_DIARIO_26PERIODOS_VALID_001);
  }

  private List<MacdDiario> macdDiarioList(){
    return from(MacdDiario.class)
        .gimme(1,MACD_DIARIO_VALID_001);
  }

  private List<SinalMacdDiario> sinalMacdDiarioList(){
    return from(SinalMacdDiario.class)
        .gimme(1, SINAL_MACD_DIARIO_VALID_001);
  }

  private List<HistogramaDiario> histogramaDiarioList(){
    return from(HistogramaDiario.class)
        .gimme(1, HISTOGRAMA_DIARIO_VALID_001);
  }

}
