package com.ricardococati.calculacotacoes.adapters.repositories.mediaexponencial;

import static br.com.six2six.fixturefactory.Fixture.from;
import static com.ricardococati.calculacotacoes.templates.CandlestickDiarioDTOTemplateLoader.CANDLESTICK_DIARIO_VALID_001;
import static com.ricardococati.calculacotacoes.templates.MediaMovelExponencial9PeriodosDiarioTemplateLoader.MEDIA_MOVEL_EXPONENCIAL_DIARIO_9PERIODOS_VALID_001;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.ricardococati.calculacotacoes.adapters.repositories.candlestick.sqlutil.CandlestickDiarioInserirSQLUtil;
import com.ricardococati.calculacotacoes.adapters.repositories.gerasequencia.impl.GeraSequenciaDAOImpl;
import com.ricardococati.calculacotacoes.adapters.repositories.mediaexponencial.impl.MediaMovelExponencialDiarioInserirDAOImpl;
import com.ricardococati.calculacotacoes.adapters.repositories.mediaexponencial.sqlutil.MediaMovelExponencialDiarioSQLUtil;
import com.ricardococati.calculacotacoes.config.BaseJdbcTest;
import com.ricardococati.calculacotacoes.entities.domains.candlestick.CandlestickDiario;
import com.ricardococati.calculacotacoes.entities.domains.mediaexponencial.MediaMovelExponencialDiario;
import com.ricardococati.calculacotacoes.adapters.repositories.utils.InserirDadosPrimariosDiarioUtil;
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
public class MediaMovelExponencialDiarioInserirDAOImplTest extends BaseJdbcTest {

  @InjectMocks
  private MediaMovelExponencialDiarioInserirDAOImpl target;
  @Mock
  private GeraSequenciaDAOImpl genericDAO;
  @Mock
  private MediaMovelExponencialDiarioSQLUtil sqlUtil;
  @Rule
  public ExpectedException thrown = ExpectedException.none();
  @Mock
  private CandlestickDiarioInserirSQLUtil incluirSQLUtil;

  @Before
  public void setUp() throws Exception {
    FixtureFactoryLoader.loadTemplates("com.ricardococati.calculacotacoes.templates");
    target = new MediaMovelExponencialDiarioInserirDAOImpl(
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
  public void incluirMediaMovelExponencial() {
    //given
    when(genericDAO.getSequence(any())).thenReturn(1);
    when(sqlUtil.getInsert()).thenCallRealMethod();
    when(sqlUtil.toParameters(any())).thenCallRealMethod();
    MediaMovelExponencialDiario dto = buildMMEDiario();
    //when
    Boolean retorno = target.incluirMediaMovelExponencial(dto);
    //then
    assertTrue(retorno);
  }

  @Test
  public void incluirMediaMovelExponencialDiarioNull() {
    //given
    when(genericDAO.getSequence(any())).thenReturn(1);
    when(sqlUtil.getInsert()).thenCallRealMethod();
    when(sqlUtil.toParameters(any())).thenCallRealMethod();
    MediaMovelExponencialDiario dto = null;
    this.thrown.expectMessage(
        "Viola????o de integridade na inser????o de MEDIA_MOVEL_EXPONENCIAL_DIARIO"
    );
    this.thrown.expect(DataIntegrityViolationException.class);
    //when
    Boolean retorno = target.incluirMediaMovelExponencial(dto);
  }

  @Test
  public void incluirMediaMovelExponencialDtPregNull() {
    //given
    when(genericDAO.getSequence(any())).thenReturn(1);
    when(sqlUtil.getInsert()).thenCallRealMethod();
    when(sqlUtil.toParameters(any())).thenCallRealMethod();
    MediaMovelExponencialDiario dto = buildMMEDiario();
    dto.setDtpreg(null);
    this.thrown.expectMessage(
        "Viola????o de integridade na inser????o de MEDIA_MOVEL_EXPONENCIAL_DIARIO"
    );
    this.thrown.expect(DataIntegrityViolationException.class);
    //when
    Boolean retorno = target.incluirMediaMovelExponencial(dto);
  }

  @Test
  public void incluirMediaMovelExponencialNull() {
    //given
    when(genericDAO.getSequence(any())).thenReturn(1);
    when(sqlUtil.getInsert()).thenCallRealMethod();
    when(sqlUtil.toParameters(any())).thenCallRealMethod();
    MediaMovelExponencialDiario dto = buildMMEDiario();
    dto.setMediaMovelExponencial(null);
    this.thrown.expectMessage(
        "Viola????o de integridade na inser????o de MEDIA_MOVEL_EXPONENCIAL_DIARIO"
    );
    this.thrown.expect(DataIntegrityViolationException.class);
    //when
    Boolean retorno = target.incluirMediaMovelExponencial(dto);
  }

  @Test
  public void incluirMediaMovelExponencialCodNegNull() {
    //given
    when(genericDAO.getSequence(any())).thenReturn(1);
    when(sqlUtil.getInsert()).thenCallRealMethod();
    when(sqlUtil.toParameters(any())).thenCallRealMethod();
    MediaMovelExponencialDiario dto = buildMMEDiario();
    dto.getMediaMovelExponencial().setCodneg(null);
    this.thrown.expectMessage(
        "Viola????o de integridade na inser????o de MEDIA_MOVEL_EXPONENCIAL_DIARIO"
    );
    this.thrown.expect(DataIntegrityViolationException.class);
    //when
    Boolean retorno = target.incluirMediaMovelExponencial(dto);
  }

  private MediaMovelExponencialDiario buildMMEDiario(){
    return from(MediaMovelExponencialDiario.class)
        .gimme(MEDIA_MOVEL_EXPONENCIAL_DIARIO_9PERIODOS_VALID_001);
  }

  private CandlestickDiario buildCandlestickDiarioDTO() {
    return from(CandlestickDiario.class)
        .gimme(CANDLESTICK_DIARIO_VALID_001);
  }

}