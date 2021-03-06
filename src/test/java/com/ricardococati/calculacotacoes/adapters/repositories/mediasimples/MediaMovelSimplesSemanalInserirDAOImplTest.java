package com.ricardococati.calculacotacoes.adapters.repositories.mediasimples;

import static br.com.six2six.fixturefactory.Fixture.from;
import static com.ricardococati.calculacotacoes.templates.CandlestickDiarioDTOTemplateLoader.CANDLESTICK_DIARIO_VALID_001;
import static com.ricardococati.calculacotacoes.templates.CandlestickSemanalDTOTemplateLoader.CANDLESTICK_SEMANAL_VALID_001;
import static com.ricardococati.calculacotacoes.templates.MediaMovelSimplesSemanalTemplateLoader.MEDIA_MOVEL_SIMPLES_SEMANAL_VALID_001;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.ricardococati.calculacotacoes.adapters.repositories.candlestick.sqlutil.CandlestickDiarioInserirSQLUtil;
import com.ricardococati.calculacotacoes.adapters.repositories.candlestick.sqlutil.CandlestickSemanalInserirSQLUtil;
import com.ricardococati.calculacotacoes.adapters.repositories.gerasequencia.impl.GeraSequenciaDAOImpl;
import com.ricardococati.calculacotacoes.adapters.repositories.mediasimples.impl.MediaMovelSimplesSemanalInserirDAOImpl;
import com.ricardococati.calculacotacoes.adapters.repositories.mediasimples.sqlutil.MediaMovelSimplesSemanalSQLUtil;
import com.ricardococati.calculacotacoes.config.BaseJdbcTest;
import com.ricardococati.calculacotacoes.entities.domains.candlestick.CandlestickDiario;
import com.ricardococati.calculacotacoes.entities.domains.candlestick.CandlestickSemanal;
import com.ricardococati.calculacotacoes.entities.domains.mediasimples.MediaMovelSimplesSemanal;
import com.ricardococati.calculacotacoes.adapters.repositories.utils.InserirDadosPrimariosSemanalUtil;
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
public class MediaMovelSimplesSemanalInserirDAOImplTest extends BaseJdbcTest {

  @InjectMocks
  private MediaMovelSimplesSemanalInserirDAOImpl target;
  @Mock
  private GeraSequenciaDAOImpl genericDAO;
  @Mock
  private MediaMovelSimplesSemanalSQLUtil sqlUtil;
  @Rule
  public ExpectedException thrown = ExpectedException.none();
  @Mock
  private CandlestickSemanalInserirSQLUtil incluirSQLUtil;
  @Mock
  private CandlestickDiarioInserirSQLUtil incluirDiarioSQLUtil;

  @Before
  public void setUp() throws Exception {
    FixtureFactoryLoader.loadTemplates("com.ricardococati.calculacotacoes.templates");
    target = new MediaMovelSimplesSemanalInserirDAOImpl(
        getNamedParameterJdbcTemplate(),
        genericDAO,
        sqlUtil
    );
    InserirDadosPrimariosSemanalUtil util = new InserirDadosPrimariosSemanalUtil(
        getNamedParameterJdbcTemplate(),
        buildCandlestickSemanalDTO(),
        incluirSQLUtil,
        genericDAO,
        incluirDiarioSQLUtil,
        buildCandlestickDiarioDTO()
    );
    util.incluiCandleDiarioAntesDeExecutarTestes();
    util.incluiCandleAntesDeExecutarTestes();
  }

  @Test
  public void incluirMediaMovelSimples() {
    //given
    when(genericDAO.getSequence(any())).thenReturn(1);
    when(sqlUtil.getInsert()).thenCallRealMethod();
    when(sqlUtil.toParameters(any())).thenCallRealMethod();
    MediaMovelSimplesSemanal dto = buildMMSSemanal();
    //when
    Boolean retorno = target.incluirMediaMovelSimples(dto);
    //then
    assertTrue(retorno);
  }

  @Test
  public void incluirMediaMovelExponencialSemanalNull() {
    //given
    when(genericDAO.getSequence(any())).thenReturn(1);
    when(sqlUtil.getInsert()).thenCallRealMethod();
    when(sqlUtil.toParameters(any())).thenCallRealMethod();
    MediaMovelSimplesSemanal dto = null;
    this.thrown.expectMessage(
        "Viola????o de integridade na inser????o de MEDIA_MOVEL_SIMPLES_SEMANAL"
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
    MediaMovelSimplesSemanal dto = buildMMSSemanal();
    dto.setDtpregini(null);
    this.thrown.expectMessage(
        "Viola????o de integridade na inser????o de MEDIA_MOVEL_SIMPLES_SEMANAL"
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
    MediaMovelSimplesSemanal dto = buildMMSSemanal();
    dto.setMediaMovelSimples(null);
    this.thrown.expectMessage(
        "Viola????o de integridade na inser????o de MEDIA_MOVEL_SIMPLES_SEMANAL"
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
    MediaMovelSimplesSemanal dto = buildMMSSemanal();
    dto.getMediaMovelSimples().setCodneg(null);
    this.thrown.expectMessage(
        "Viola????o de integridade na inser????o de MEDIA_MOVEL_SIMPLES_SEMANAL"
    );
    this.thrown.expect(DataIntegrityViolationException.class);
    //when
    Boolean retorno = target.incluirMediaMovelSimples(dto);
  }

  private MediaMovelSimplesSemanal buildMMSSemanal(){
    return from(MediaMovelSimplesSemanal.class)
        .gimme(MEDIA_MOVEL_SIMPLES_SEMANAL_VALID_001);
  }

  private CandlestickDiario buildCandlestickDiarioDTO() {
    return from(CandlestickDiario.class)
        .gimme(CANDLESTICK_DIARIO_VALID_001);
  }

  private CandlestickSemanal buildCandlestickSemanalDTO() {
    return from(CandlestickSemanal.class)
        .gimme(CANDLESTICK_SEMANAL_VALID_001);
  }

}
