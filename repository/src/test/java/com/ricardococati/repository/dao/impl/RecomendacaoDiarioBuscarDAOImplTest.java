package com.ricardococati.repository.dao.impl;

import static br.com.six2six.fixturefactory.Fixture.from;
import static com.ricardococati.repository.dao.templates.CandlestickDiarioDTOTemplateLoader.CANDLESTICK_DIARIO_DTO_VALID_001;
import static com.ricardococati.repository.dao.templates.HistogramaDiarioTemplateLoader.HISTOGRAMA_DIARIO_VALID_001;
import static com.ricardococati.repository.dao.templates.MacdDiarioTemplateLoader.MACD_DIARIO_VALID_001;
import static com.ricardococati.repository.dao.templates.MediaMovelExponencial12PeriodosDiarioTemplateLoader.MEDIA_MOVEL_EXPONENCIAL_DIARIO_12PERIODOS_VALID_001;
import static com.ricardococati.repository.dao.templates.MediaMovelExponencial26PeriodosDiarioTemplateLoader.MEDIA_MOVEL_EXPONENCIAL_DIARIO_26PERIODOS_VALID_001;
import static com.ricardococati.repository.dao.templates.SinalMacdDiarioTemplateLoader.SINAL_MACD_DIARIO_VALID_001;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.ricardococati.model.dto.CandlestickDiarioDTO;
import com.ricardococati.model.dto.HistogramaDiario;
import com.ricardococati.model.dto.MacdDiario;
import com.ricardococati.model.dto.MediaMovelExponencialDiario;
import com.ricardococati.model.dto.RecomendacaoDiario;
import com.ricardococati.model.dto.SinalMacdDiario;
import com.ricardococati.repository.dao.config.BaseJdbcTest;
import com.ricardococati.repository.dao.mapper.RecomendacaoDiarioMapper;
import com.ricardococati.repository.dao.sqlutil.CandlestickDiarioInserirSQLUtil;
import com.ricardococati.repository.dao.sqlutil.HistogramaDiarioSQLUtil;
import com.ricardococati.repository.dao.sqlutil.MacdDiarioSQLUtil;
import com.ricardococati.repository.dao.sqlutil.MediaMovelExponencialDiarioSQLUtil;
import com.ricardococati.repository.dao.sqlutil.RecomendacaoDiarioBuscarSQLUtil;
import com.ricardococati.repository.dao.sqlutil.SinalMacdDiarioSQLUtil;
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
    FixtureFactoryLoader.loadTemplates("com.ricardococati.repository.dao.templates");
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

  private CandlestickDiarioDTO getCandlestickDiario() {
    return from(CandlestickDiarioDTO.class)
        .gimme(CANDLESTICK_DIARIO_DTO_VALID_001);
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
