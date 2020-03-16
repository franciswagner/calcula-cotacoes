package com.ricardococati.repository.dao.impl;

import static br.com.six2six.fixturefactory.Fixture.from;
import static com.ricardococati.repository.dao.templates.CandlestickDiarioDTOTemplateLoader.CANDLESTICK_DIARIO_DTO_VALID_001;
import static com.ricardococati.repository.dao.templates.MediaMovelSimplesDiarioTemplateLoader.MEDIA_MOVEL_SIMPLES_DIARIO_VALID_001;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.ricardococati.model.entities.CandlestickDiario;
import com.ricardococati.model.entities.MediaMovelSimplesDiario;
import com.ricardococati.repository.dao.config.BaseJdbcTest;
import com.ricardococati.repository.dao.sqlutil.CandlestickDiarioInserirSQLUtil;
import com.ricardococati.repository.dao.sqlutil.MediaMovelSimplesDiarioSQLUtil;
import com.ricardococati.repository.dao.utils.InserirDadosPrimariosDiarioUtil;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class MediaMovelSimplesDiarioInserirDAOImplTest extends BaseJdbcTest {

  @InjectMocks
  private MediaMovelSimplesDiarioInserirDAOImpl target;
  @Mock
  private GeraSequenciaDAOImpl genericDAO;
  @Mock
  private MediaMovelSimplesDiarioSQLUtil sqlUtil;
  @Rule
  public ExpectedException thrown = ExpectedException.none();
  @Mock
  private CandlestickDiarioInserirSQLUtil incluirSQLUtil;

  @Before
  public void setUp() throws Exception {
    FixtureFactoryLoader.loadTemplates("com.ricardococati.repository.dao.templates");
    target = new MediaMovelSimplesDiarioInserirDAOImpl(
        getNamedParameterJdbcTemplate(),
        genericDAO,
        sqlUtil
    );
    InserirDadosPrimariosDiarioUtil util = new InserirDadosPrimariosDiarioUtil(
        getNamedParameterJdbcTemplate(),
        buildCandlestickDiarioDTO(),
        incluirSQLUtil,
        genericDAO
    );
    util.incluiCandleAntesDeExecutarTestes();
  }

  @Test
  public void incluirMediaMovelSimples() {
    //given
    when(genericDAO.getSequence(any())).thenReturn(1);
    when(sqlUtil.getInsert()).thenCallRealMethod();
    when(sqlUtil.toParameters(any())).thenCallRealMethod();
    MediaMovelSimplesDiario dto = buildMMSDiario();
    //when
    Boolean retorno = target.incluirMediaMovelSimples(dto);
    //then
    assertTrue(retorno);
  }

  @Test
  public void incluirMediaMovelExponencialDiarioNull() {
    //given
    when(genericDAO.getSequence(any())).thenReturn(1);
    when(sqlUtil.getInsert()).thenCallRealMethod();
    when(sqlUtil.toParameters(any())).thenCallRealMethod();
    MediaMovelSimplesDiario dto = null;
    this.thrown.expectMessage(
        "Violação de integridade na inserção de MEDIA_MOVEL_SIMPLES_DIARIO"
    );
    this.thrown.expect(DataIntegrityViolationException.class);
    //when
    Boolean retorno = target.incluirMediaMovelSimples(dto);
  }

  @Test
  public void incluirMediaMovelExponencialDtPregNull() {
    //given
    when(genericDAO.getSequence(any())).thenReturn(1);
    when(sqlUtil.getInsert()).thenCallRealMethod();
    when(sqlUtil.toParameters(any())).thenCallRealMethod();
    MediaMovelSimplesDiario dto = buildMMSDiario();
    dto.setDtpreg(null);
    this.thrown.expectMessage(
        "Violação de integridade na inserção de MEDIA_MOVEL_SIMPLES_DIARIO"
    );
    this.thrown.expect(DataIntegrityViolationException.class);
    //when
    Boolean retorno = target.incluirMediaMovelSimples(dto);
  }

  @Test
  public void incluirMediaMovelExponencialNull() {
    //given
    when(genericDAO.getSequence(any())).thenReturn(1);
    when(sqlUtil.getInsert()).thenCallRealMethod();
    when(sqlUtil.toParameters(any())).thenCallRealMethod();
    MediaMovelSimplesDiario dto = buildMMSDiario();
    dto.setMediaMovelSimples(null);
    this.thrown.expectMessage(
        "Violação de integridade na inserção de MEDIA_MOVEL_SIMPLES_DIARIO"
    );
    this.thrown.expect(DataIntegrityViolationException.class);
    //when
    Boolean retorno = target.incluirMediaMovelSimples(dto);
  }

  @Test
  public void incluirMediaMovelExponencialCodNegNull() {
    //given
    when(genericDAO.getSequence(any())).thenReturn(1);
    when(sqlUtil.getInsert()).thenCallRealMethod();
    when(sqlUtil.toParameters(any())).thenCallRealMethod();
    MediaMovelSimplesDiario dto = buildMMSDiario();
    dto.getMediaMovelSimples().setCodneg(null);
    this.thrown.expectMessage(
        "Violação de integridade na inserção de MEDIA_MOVEL_SIMPLES_DIARIO"
    );
    this.thrown.expect(DataIntegrityViolationException.class);
    //when
    Boolean retorno = target.incluirMediaMovelSimples(dto);
  }

  private MediaMovelSimplesDiario buildMMSDiario(){
    return from(MediaMovelSimplesDiario.class)
        .gimme(MEDIA_MOVEL_SIMPLES_DIARIO_VALID_001);
  }

  private CandlestickDiario buildCandlestickDiarioDTO() {
    return from(CandlestickDiario.class)
        .gimme(CANDLESTICK_DIARIO_DTO_VALID_001);
  }

}