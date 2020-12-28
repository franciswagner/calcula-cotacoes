package com.ricardococati.calculacotacoes.adapters.repositories.recomendacao;

import static br.com.six2six.fixturefactory.Fixture.from;
import static com.ricardococati.calculacotacoes.templates.CandlestickDiarioDTOTemplateLoader.CANDLESTICK_DIARIO_VALID_001;
import static com.ricardococati.calculacotacoes.templates.CandlestickSemanalDTOTemplateLoader.CANDLESTICK_SEMANAL_VALID_001;
import static com.ricardococati.calculacotacoes.templates.HistogramaSemanalTemplateLoader.HISTOGRAMA_SEMANAL_VALID_001;
import static com.ricardococati.calculacotacoes.templates.MacdSemanalTemplateLoader.MACD_SEMANAL_VALID_001;
import static com.ricardococati.calculacotacoes.templates.MediaMovelExponencial12PeriodosSemanalTemplateLoader.MEDIA_MOVEL_EXPONENCIAL_SEMANAL_12PERIODOS_VALID_001;
import static com.ricardococati.calculacotacoes.templates.MediaMovelExponencial26PeriodosSemanalTemplateLoader.MEDIA_MOVEL_EXPONENCIAL_SEMANAL_26PERIODOS_VALID_001;
import static com.ricardococati.calculacotacoes.templates.SinalMacdSemanalTemplateLoader.SINAL_MACD_SEMANAL_VALID_001;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.ricardococati.calculacotacoes.adapters.repositories.candlestick.impl.CandlestickSemanalInserirDAOImpl;
import com.ricardococati.calculacotacoes.adapters.repositories.candlestick.sqlutil.CandlestickDiarioInserirSQLUtil;
import com.ricardococati.calculacotacoes.adapters.repositories.candlestick.sqlutil.CandlestickSemanalInserirSQLUtil;
import com.ricardococati.calculacotacoes.adapters.repositories.gerasequencia.impl.GeraSequenciaDAOImpl;
import com.ricardococati.calculacotacoes.adapters.repositories.histograma.impl.HistogramaSemanalInserirDAOImpl;
import com.ricardococati.calculacotacoes.adapters.repositories.histograma.sqlutil.HistogramaSemanalSQLUtil;
import com.ricardococati.calculacotacoes.adapters.repositories.macd.impl.MacdSemanalInserirDAOImpl;
import com.ricardococati.calculacotacoes.adapters.repositories.macd.sqlutil.MacdSemanalSQLUtil;
import com.ricardococati.calculacotacoes.adapters.repositories.mediaexponencial.impl.MediaMovelExponencialSemanalInserirDAOImpl;
import com.ricardococati.calculacotacoes.adapters.repositories.mediaexponencial.sqlutil.MediaMovelExponencialSemanalSQLUtil;
import com.ricardococati.calculacotacoes.adapters.repositories.recomendacao.impl.RecomendacaoSemanalBuscarDAOImpl;
import com.ricardococati.calculacotacoes.adapters.repositories.recomendacao.mapper.RecomendacaoSemanalMapper;
import com.ricardococati.calculacotacoes.adapters.repositories.recomendacao.sqlutil.RecomendacaoSemanalBuscarSQLUtil;
import com.ricardococati.calculacotacoes.adapters.repositories.sinalmacd.impl.SinalMacdSemanalInserirDAOImpl;
import com.ricardococati.calculacotacoes.adapters.repositories.sinalmacd.sqlutil.SinalMacdSemanalSQLUtil;
import com.ricardococati.calculacotacoes.config.BaseJdbcTest;
import com.ricardococati.calculacotacoes.entities.domains.candlestick.CandlestickDiario;
import com.ricardococati.calculacotacoes.entities.domains.candlestick.CandlestickSemanal;
import com.ricardococati.calculacotacoes.entities.domains.histograma.HistogramaSemanal;
import com.ricardococati.calculacotacoes.entities.domains.macd.MacdSemanal;
import com.ricardococati.calculacotacoes.entities.domains.mediaexponencial.MediaMovelExponencialSemanal;
import com.ricardococati.calculacotacoes.entities.domains.recomendacao.RecomendacaoSemanal;
import com.ricardococati.calculacotacoes.entities.domains.sinalmacd.SinalMacdSemanal;
import com.ricardococati.calculacotacoes.adapters.repositories.utils.InserirDadosPrimariosDiarioUtil;
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
public class RecomendacaoSemanalBuscarDAOImplTest extends BaseJdbcTest {

  @InjectMocks
  private RecomendacaoSemanalBuscarDAOImpl target;
  @Mock
  private RecomendacaoSemanalBuscarSQLUtil sqlUtil;
  @Mock
  private RecomendacaoSemanalMapper mapper;
  @Mock
  private CandlestickSemanalInserirSQLUtil incluirCandle;
  @Mock
  private MediaMovelExponencialSemanalSQLUtil incluirMME;
  @Mock
  private MacdSemanalSQLUtil incluirMacd;
  @Mock
  private SinalMacdSemanalSQLUtil incluirSinalMacd;
  @Mock
  private HistogramaSemanalSQLUtil incluirHistograma;
  @Mock
  private GeraSequenciaDAOImpl genericDAO;
  @Mock
  private CandlestickDiarioInserirSQLUtil incluirCandleDiario;

  @Before
  public void setUp() throws Exception {
    FixtureFactoryLoader.loadTemplates("com.ricardococati.calculacotacoes.templates");
    target = new RecomendacaoSemanalBuscarDAOImpl(
        getNamedParameterJdbcTemplate(),
        sqlUtil,
        mapper
    );
    InserirDadosPrimariosDiarioUtil util = new InserirDadosPrimariosDiarioUtil(
        getNamedParameterJdbcTemplate(),
        buildCandlestickDiarioDTO(),
        incluirCandleDiario,
        genericDAO
    );
    util.incluiCandleAntesDeExecutarTestes();
    incluiCandleAntesDeExecutarTestes();
    incluirMMEAntesDeExecutarTestes();
    incluiMacdAntesDeExecutarTestes();
    incluiSinalMacdAntesDeExecutarTestes();
    incluiHistogramaAntesDeExecutarTestes();
  }

  @Test
  public void getListRecomendacaoByDtPregECodNeg() {
    //given
    LocalDate dtpregLocal = LocalDate.of(1978,2,10);
    when(sqlUtil.getSelectByCodNegDtPreg()).thenCallRealMethod();
    when(sqlUtil.toParametersCodNegDtPreg(any(), any())).thenCallRealMethod();
    when(mapper.mapperConsult(any())).thenCallRealMethod();
    //when
    List<RecomendacaoSemanal> result =
        target.getListRecomendacaoByDtPregECodNeg(dtpregLocal, "MGLU3");
    //then
    assertTrue(!result.isEmpty());
    assertThat(result).isNotNull().size().isEqualTo(1);
    assertThat(result.get(0).getDtpregini()).isNotNull().isEqualTo(LocalDate.of(1978, 2, 16));
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
    List<RecomendacaoSemanal> result =
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
    List<RecomendacaoSemanal> result =
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
    List<RecomendacaoSemanal> result =
        target.getListRecomendacaoByDtPregECodNeg(null, null);
    //then
    assertTrue(result.isEmpty());
  }

  private void incluiCandleAntesDeExecutarTestes() {
    CandlestickSemanalInserirDAOImpl incluirDAO = new CandlestickSemanalInserirDAOImpl(
        getNamedParameterJdbcTemplate(), genericDAO, incluirCandle);
    when(incluirCandle.getInsert()).thenCallRealMethod();
    when(incluirCandle.toParameters(any())).thenCallRealMethod();
    when(genericDAO.getSequence(any())).thenReturn(1);
    incluirDAO.incluirCandlestickSemanal(getCandlestickSemanal());
  }

  private void incluirMMEAntesDeExecutarTestes() {
    final MediaMovelExponencialSemanalInserirDAOImpl incluirDAO =
        new MediaMovelExponencialSemanalInserirDAOImpl(
            getNamedParameterJdbcTemplate(),
            genericDAO,
            incluirMME
        );
    when(incluirMME.getInsert()).thenCallRealMethod();
    when(incluirMME.toParameters(any())).thenCallRealMethod();
    when(genericDAO.getSequence(any())).thenReturn(1);
    mediaMovelExponencialSemanalPeriodosList()
        .stream()
        .filter(Objects::nonNull)
        .forEach(incluirDAO::incluirMediaMovelExponencial);
  }

  private void incluiMacdAntesDeExecutarTestes() {
    MacdSemanalInserirDAOImpl incluirDAO = new MacdSemanalInserirDAOImpl(
        getNamedParameterJdbcTemplate(), genericDAO, incluirMacd);
    when(incluirMacd.getInsert()).thenCallRealMethod();
    when(incluirMacd.toParameters(any())).thenCallRealMethod();
    when(genericDAO.getSequence(any())).thenReturn(1);
    macdSemanalList()
        .stream()
        .filter(Objects::nonNull)
        .forEach(incluirDAO::incluirMacd);
  }

  private void incluiSinalMacdAntesDeExecutarTestes() {
    SinalMacdSemanalInserirDAOImpl incluirDAO = new SinalMacdSemanalInserirDAOImpl(
        getNamedParameterJdbcTemplate(), genericDAO, incluirSinalMacd);
    when(incluirSinalMacd.getInsert()).thenCallRealMethod();
    when(incluirSinalMacd.toParameters(any())).thenCallRealMethod();
    when(genericDAO.getSequence(any())).thenReturn(1);
    sinalMacdSemanalList()
        .stream()
        .filter(Objects::nonNull)
        .forEach(incluirDAO::incluirSinalMacd);
  }

  private void incluiHistogramaAntesDeExecutarTestes() {
    HistogramaSemanalInserirDAOImpl incluirDAO = new HistogramaSemanalInserirDAOImpl(
        getNamedParameterJdbcTemplate(), genericDAO, incluirHistograma);
    when(incluirHistograma.getInsert()).thenCallRealMethod();
    when(incluirHistograma.toParameters(any())).thenCallRealMethod();
    when(genericDAO.getSequence(any())).thenReturn(1);
    histogramaSemanalList()
        .stream()
        .filter(Objects::nonNull)
        .forEach(incluirDAO::incluirHistograma);
  }

  private CandlestickSemanal getCandlestickSemanal() {
    return from(CandlestickSemanal.class)
        .gimme(CANDLESTICK_SEMANAL_VALID_001);
  }

  private List<MediaMovelExponencialSemanal> mediaMovelExponencialSemanalPeriodosList(){
    return from(MediaMovelExponencialSemanal.class)
        .gimme(2,MEDIA_MOVEL_EXPONENCIAL_SEMANAL_12PERIODOS_VALID_001,
            MEDIA_MOVEL_EXPONENCIAL_SEMANAL_26PERIODOS_VALID_001);
  }

  private List<MacdSemanal> macdSemanalList(){
    return from(MacdSemanal.class)
        .gimme(1,MACD_SEMANAL_VALID_001);
  }

  private List<SinalMacdSemanal> sinalMacdSemanalList(){
    return from(SinalMacdSemanal.class)
        .gimme(1, SINAL_MACD_SEMANAL_VALID_001);
  }

  private List<HistogramaSemanal> histogramaSemanalList(){
    return from(HistogramaSemanal.class)
        .gimme(1, HISTOGRAMA_SEMANAL_VALID_001);
  }

  private CandlestickDiario buildCandlestickDiarioDTO() {
    return from(CandlestickDiario.class)
        .gimme(CANDLESTICK_DIARIO_VALID_001);
  }

}
