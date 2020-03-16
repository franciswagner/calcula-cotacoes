package com.ricardococati.repository.dao.impl;

import static br.com.six2six.fixturefactory.Fixture.from;
import static com.ricardococati.repository.dao.templates.CandlestickDiarioDTOTemplateLoader.CANDLESTICK_DIARIO_DTO_VALID_001;
import static com.ricardococati.repository.dao.templates.CandlestickSemanalDTOTemplateLoader.CANDLESTICK_SEMANAL_DTO_VALID_001;
import static com.ricardococati.repository.dao.templates.MediaMovelExponencial9PeriodosSemanalTemplateLoader.MEDIA_MOVEL_EXPONENCIAL_SEMANAL_9PERIODOS_VALID_001;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.ricardococati.model.entities.CandlestickDiario;
import com.ricardococati.model.entities.CandlestickSemanal;
import com.ricardococati.model.entities.MediaMovelExponencialSemanal;
import com.ricardococati.repository.dao.config.BaseJdbcTest;
import com.ricardococati.repository.dao.sqlutil.CandlestickDiarioInserirSQLUtil;
import com.ricardococati.repository.dao.sqlutil.CandlestickSemanalInserirSQLUtil;
import com.ricardococati.repository.dao.sqlutil.MediaMovelExponencialSemanalSQLUtil;
import com.ricardococati.repository.dao.utils.InserirDadosPrimariosSemanalUtil;
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
public class MediaMovelExponencialSemanalInserirDAOImplTest extends BaseJdbcTest {

  @InjectMocks
  private MediaMovelExponencialSemanalInserirDAOImpl target;
  @Mock
  private GeraSequenciaDAOImpl genericDAO;
  @Mock
  private MediaMovelExponencialSemanalSQLUtil sqlUtil;
  @Rule
  public ExpectedException thrown = ExpectedException.none();
  @Mock
  private CandlestickSemanalInserirSQLUtil incluirSQLUtil;
  @Mock
  private CandlestickDiarioInserirSQLUtil incluirDiarioSQLUtil;

  @Before
  public void setUp() throws Exception {
    FixtureFactoryLoader.loadTemplates("com.ricardococati.repository.dao.templates");
    target = new MediaMovelExponencialSemanalInserirDAOImpl(
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
  public void incluirMediaMovelExponencial() {
    //given
    when(genericDAO.getSequence(any())).thenReturn(1);
    when(sqlUtil.getInsert()).thenCallRealMethod();
    when(sqlUtil.toParameters(any())).thenCallRealMethod();
    MediaMovelExponencialSemanal dto = buildMMESemanal();
    //when
    Boolean retorno = target.incluirMediaMovelExponencial(dto);
    //then
    assertTrue(retorno);
  }

  @Test
  public void incluirMediaMovelExponencialSemanalNull() {
    //given
    when(genericDAO.getSequence(any())).thenReturn(1);
    when(sqlUtil.getInsert()).thenCallRealMethod();
    when(sqlUtil.toParameters(any())).thenCallRealMethod();
    MediaMovelExponencialSemanal dto = null;
    this.thrown.expectMessage(
        "Violação de integridade na inserção de MEDIA_MOVEL_EXPONENCIAL_SEMANAL"
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
    MediaMovelExponencialSemanal dto = buildMMESemanal();
    dto.setDtpregini(null);
    this.thrown.expectMessage(
        "Violação de integridade na inserção de MEDIA_MOVEL_EXPONENCIAL_SEMANAL"
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
    MediaMovelExponencialSemanal dto = buildMMESemanal();
    dto.setMediaMovelExponencial(null);
    this.thrown.expectMessage(
        "Violação de integridade na inserção de MEDIA_MOVEL_EXPONENCIAL_SEMANAL"
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
    MediaMovelExponencialSemanal dto = buildMMESemanal();
    dto.getMediaMovelExponencial().setCodneg(null);
    this.thrown.expectMessage(
        "Violação de integridade na inserção de MEDIA_MOVEL_EXPONENCIAL_SEMANAL"
    );
    this.thrown.expect(DataIntegrityViolationException.class);
    //when
    Boolean retorno = target.incluirMediaMovelExponencial(dto);
  }

  private MediaMovelExponencialSemanal buildMMESemanal(){
    return from(MediaMovelExponencialSemanal.class)
        .gimme(MEDIA_MOVEL_EXPONENCIAL_SEMANAL_9PERIODOS_VALID_001);
  }

  private CandlestickDiario buildCandlestickDiarioDTO() {
    return from(CandlestickDiario.class)
        .gimme(CANDLESTICK_DIARIO_DTO_VALID_001);
  }

  private CandlestickSemanal buildCandlestickSemanalDTO() {
    return from(CandlestickSemanal.class)
        .gimme(CANDLESTICK_SEMANAL_DTO_VALID_001);
  }

}