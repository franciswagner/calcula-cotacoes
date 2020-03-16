package com.ricardococati.repository.dao.impl;

import static br.com.six2six.fixturefactory.Fixture.from;
import static com.ricardococati.repository.dao.templates.CandlestickDiarioDTOTemplateLoader.CANDLESTICK_DIARIO_DTO_VALID_001;
import static com.ricardococati.repository.dao.templates.MediaMovelSimplesDiarioTemplateLoader.MEDIA_MOVEL_SIMPLES_DIARIO_VALID_001;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.ricardococati.model.entities.CandlestickDiario;
import com.ricardococati.model.entities.MediaMovelSimplesDiario;
import com.ricardococati.repository.dao.config.BaseJdbcTest;
import com.ricardococati.repository.dao.mapper.MediaMovelSimplesDiarioMapper;
import com.ricardococati.repository.dao.sqlutil.CandlestickDiarioInserirSQLUtil;
import com.ricardococati.repository.dao.sqlutil.MediaMovelSimplesDiarioSQLUtil;
import com.ricardococati.repository.dao.utils.InserirDadosPrimariosDiarioUtil;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class MediaMovelSimplesDiarioBuscarDAOImplTest extends BaseJdbcTest {

  @InjectMocks
  private MediaMovelSimplesDiarioBuscarDAOImpl target;
  @Mock
  private MediaMovelSimplesDiarioSQLUtil sqlUtil;
  @Mock
  private MediaMovelSimplesDiarioMapper mapper;
  @Mock
  private GeraSequenciaDAOImpl genericDAO;
  @Rule
  public ExpectedException thrown = ExpectedException.none();
  @Mock
  private CandlestickDiarioInserirSQLUtil incluirSQLUtil;

  @Before
  public void setUp() throws Exception {
    FixtureFactoryLoader.loadTemplates("com.ricardococati.repository.dao.templates");
    target = new MediaMovelSimplesDiarioBuscarDAOImpl(
        getNamedParameterJdbcTemplate(),
        sqlUtil,
        mapper
    );
    InserirDadosPrimariosDiarioUtil util = new InserirDadosPrimariosDiarioUtil(
        getNamedParameterJdbcTemplate(),
        buildCandlestickDiarioDTO(),
        incluirSQLUtil,
        genericDAO
    );
    util.incluiCandleAntesDeExecutarTestes();
    incluirMMSAntesDeExecutarTestes();
  }

  private void incluirMMSAntesDeExecutarTestes() {
    MediaMovelSimplesDiarioInserirDAOImpl incluirDAO =
        new MediaMovelSimplesDiarioInserirDAOImpl(
            getNamedParameterJdbcTemplate(),
            genericDAO,
            sqlUtil
        );
    when(sqlUtil.getInsert()).thenCallRealMethod();
    when(sqlUtil.toParameters(any())).thenCallRealMethod();
    when(genericDAO.getSequence(any())).thenReturn(1);
    incluirDAO.incluirMediaMovelSimples(mediaMovelSimples());
  }

  @Test
  public void buscaMediaSimplesPorCodNegPeriodoDtPreg() throws Exception {
    //given
    when(sqlUtil.getSelectByCodNegPeriodoDtPreg()).thenCallRealMethod();
    when(sqlUtil.toParametersSelectByCodNegPeriodoDtPreg(any(), any(), any())).thenCallRealMethod();
    when(mapper.mapper(any())).thenCallRealMethod();
    //when
    final LocalDate dtpreg = LocalDate.of(1978, 2, 16);
    MediaMovelSimplesDiario result =
        target.buscaMediaSimplesPorCodNegPeriodoDtPreg("MGLU3", 9, dtpreg);
    //then
    assertThat(result).isNotNull();
    assertThat(result.getDtpreg()).isNotNull().isEqualTo(LocalDate.of(1978, 2, 16));
    assertThat(result.getMediaMovelSimples().getCodneg()).isNotNull().isEqualTo("MGLU3");
    assertThat(result.getMediaMovelSimples().getPeriodo()).isNotNull().isEqualTo(9);
    assertThat(result.getMediaMovelSimples().getPremedult()).isNotNull().isEqualTo(new BigDecimal("11.11"));
  }

  @Test
  public void buscaMediaSimplesPorCodNegPeriodoErradoDtPreg() throws Exception {
    //given
    when(sqlUtil.getSelectByCodNegPeriodoDtPreg()).thenCallRealMethod();
    when(sqlUtil.toParametersSelectByCodNegPeriodoDtPreg(any(), any(), any())).thenCallRealMethod();
    when(mapper.mapper(any())).thenCallRealMethod();
    final LocalDate dtpreg = LocalDate.of(1978, 2, 16);
    this.thrown.expectMessage("Erro ao buscar média móvel simples!");
    this.thrown.expect(EmptyResultDataAccessException.class);
    //when
    target.buscaMediaSimplesPorCodNegPeriodoDtPreg("MGLU3", 12, dtpreg);
  }

  @Test
  public void buscaMediaSimplesPorCodNegErradoPeriodoDtPreg() throws Exception {
    //given
    when(sqlUtil.getSelectByCodNegPeriodoDtPreg()).thenCallRealMethod();
    when(sqlUtil.toParametersSelectByCodNegPeriodoDtPreg(any(), any(), any())).thenCallRealMethod();
    when(mapper.mapper(any())).thenCallRealMethod();
    final LocalDate dtpreg = LocalDate.of(1978, 2, 16);
    this.thrown.expectMessage("Erro ao buscar média móvel simples!");
    this.thrown.expect(EmptyResultDataAccessException.class);
    //when
    target.buscaMediaSimplesPorCodNegPeriodoDtPreg("MGLU", 9, dtpreg);
  }

  @Test
  public void buscaMediaSimplesPorCodNegPeriodoDtPregErrado() throws Exception {
    //given
    when(sqlUtil.getSelectByCodNegPeriodoDtPreg()).thenCallRealMethod();
    when(sqlUtil.toParametersSelectByCodNegPeriodoDtPreg(any(), any(), any())).thenCallRealMethod();
    when(mapper.mapper(any())).thenCallRealMethod();
    final LocalDate dtpreg = LocalDate.of(1978, 2, 7);
    this.thrown.expectMessage("Erro ao buscar média móvel simples!");
    this.thrown.expect(EmptyResultDataAccessException.class);
    //when
    target.buscaMediaSimplesPorCodNegPeriodoDtPreg("MGLU3", 9, dtpreg);
  }

  private MediaMovelSimplesDiario mediaMovelSimples(){
    return from(MediaMovelSimplesDiario.class)
        .gimme(MEDIA_MOVEL_SIMPLES_DIARIO_VALID_001);
  }

  private CandlestickDiario buildCandlestickDiarioDTO() {
    return from(CandlestickDiario.class)
        .gimme(CANDLESTICK_DIARIO_DTO_VALID_001);
  }

}
