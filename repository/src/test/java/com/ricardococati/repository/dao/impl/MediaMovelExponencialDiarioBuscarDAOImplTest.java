package com.ricardococati.repository.dao.impl;

import static br.com.six2six.fixturefactory.Fixture.from;
import static com.ricardococati.repository.dao.templates.CandlestickDiarioDTOTemplateLoader.CANDLESTICK_DIARIO_VALID_001;
import static com.ricardococati.repository.dao.templates.MediaMovelExponencial12PeriodosDiarioTemplateLoader.MEDIA_MOVEL_EXPONENCIAL_DIARIO_12PERIODOS_VALID_001;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.ricardococati.model.entities.CandlestickDiario;
import com.ricardococati.model.entities.MediaMovelExponencialDiario;
import com.ricardococati.repository.dao.config.BaseJdbcTest;
import com.ricardococati.repository.dao.mapper.MediaMovelExponencialDiarioMapper;
import com.ricardococati.repository.dao.sqlutil.CandlestickDiarioInserirSQLUtil;
import com.ricardococati.repository.dao.sqlutil.MediaMovelExponencialDiarioSQLUtil;
import com.ricardococati.repository.dao.utils.InserirDadosPrimariosDiarioUtil;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class MediaMovelExponencialDiarioBuscarDAOImplTest extends BaseJdbcTest {

  @InjectMocks
  private MediaMovelExponencialDiarioBuscarDAOImpl target;
  @Mock
  private MediaMovelExponencialDiarioSQLUtil sqlUtil;
  @Mock
  private MediaMovelExponencialDiarioMapper mapper;
  @Mock
  private GeraSequenciaDAOImpl genericDAO;
  @Mock
  private CandlestickDiarioInserirSQLUtil incluirSQLUtil;

  @Before
  public void setUp() throws Exception {
    FixtureFactoryLoader.loadTemplates("com.ricardococati.repository.dao.templates");
    target = new MediaMovelExponencialDiarioBuscarDAOImpl(
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
    incluirMMEAntesDeExecutarTestes();
  }

  private void incluirMMEAntesDeExecutarTestes() {
    MediaMovelExponencialDiarioInserirDAOImpl incluirDAO =
        new MediaMovelExponencialDiarioInserirDAOImpl(
            getNamedParameterJdbcTemplate(),
            genericDAO,
            sqlUtil
        );
    when(sqlUtil.getInsert()).thenCallRealMethod();
    when(sqlUtil.toParameters(any())).thenCallRealMethod();
    when(genericDAO.getSequence(any())).thenReturn(1);
    incluirDAO.incluirMediaMovelExponencial(mediaMovelExponencialDiario());
  }

  @Test
  public void getListMMEByCodNegEPeriodo() {
    //given
    when(sqlUtil.getSelectByCodNegEPeriodo()).thenCallRealMethod();
    when(sqlUtil.toParametersByCodNegEPeriodo(any(), any())).thenCallRealMethod();
    when(mapper.mapper(any())).thenCallRealMethod();
    //when
    List<MediaMovelExponencialDiario> result =
        target.getListMMEByCodNegEPeriodo("MGLU3", 12);
    //then
    assertTrue(!result.isEmpty());
    assertThat(result).isNotNull().size().isEqualTo(1);
    assertThat(result.get(0).getDtpreg()).isNotNull().isEqualTo(LocalDate.of(1978, 2, 16));
    assertThat(result.get(0).getMediaMovelExponencial().getCodneg()).isNotNull().isEqualTo("MGLU3");
    assertThat(result.get(0).getMediaMovelExponencial().getPremedult()).isNotNull().isEqualTo(new BigDecimal("13.11"));
  }

  @Test
  public void getListMMEByCodNegNullEPeriodo() {
    //given
    when(sqlUtil.getSelectByCodNegEPeriodo()).thenCallRealMethod();
    when(sqlUtil.toParametersByCodNegEPeriodo(any(), any())).thenCallRealMethod();
    when(mapper.mapper(any())).thenCallRealMethod();
    //when
    List<MediaMovelExponencialDiario> result =
        target.getListMMEByCodNegEPeriodo(null, 12);
    //then
    assertTrue(result.isEmpty());
  }

  @Test
  public void getListMMEByCodNegEPeriodoNull() {
    //given
    when(sqlUtil.getSelectByCodNegEPeriodo()).thenCallRealMethod();
    when(sqlUtil.toParametersByCodNegEPeriodo(any(), any())).thenCallRealMethod();
    when(mapper.mapper(any())).thenCallRealMethod();
    //when
    List<MediaMovelExponencialDiario> result =
        target.getListMMEByCodNegEPeriodo("MGLU3", null);
    //then
    assertTrue(result.isEmpty());
  }

  @Test
  public void getListMMEByCodNegEPeriodoErrado() {
    //given
    when(sqlUtil.getSelectByCodNegEPeriodo()).thenCallRealMethod();
    when(sqlUtil.toParametersByCodNegEPeriodo(any(), any())).thenCallRealMethod();
    when(mapper.mapper(any())).thenCallRealMethod();
    //when
    List<MediaMovelExponencialDiario> result =
        target.getListMMEByCodNegEPeriodo("MGLU3", 27);
    //then
    assertTrue(result.isEmpty());
  }

  private MediaMovelExponencialDiario mediaMovelExponencialDiario(){
    return from(MediaMovelExponencialDiario.class)
        .gimme(MEDIA_MOVEL_EXPONENCIAL_DIARIO_12PERIODOS_VALID_001);
  }

  private CandlestickDiario buildCandlestickDiarioDTO() {
    return from(CandlestickDiario.class)
        .gimme(CANDLESTICK_DIARIO_VALID_001);
  }

}
