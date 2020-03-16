package com.ricardococati.repository.dao.impl;

import static br.com.six2six.fixturefactory.Fixture.from;
import static com.ricardococati.repository.dao.templates.CandlestickDiarioDTOTemplateLoader.CANDLESTICK_DIARIO_VALID_001;
import static com.ricardococati.repository.dao.templates.RecomendacaoDiarioTemplateLoader.RECOMENDACAO_DIARIO_VALID_001;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.ricardococati.model.entities.CandlestickDiario;
import com.ricardococati.model.entities.RecomendacaoDiario;
import com.ricardococati.repository.dao.config.BaseJdbcTest;
import com.ricardococati.repository.dao.sqlutil.CandlestickDiarioInserirSQLUtil;
import com.ricardococati.repository.dao.sqlutil.RecomendacaoDiarioInserirSQLUtil;
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
public class RecomendacaoDiarioInserirDAOImplTest extends BaseJdbcTest {

  @InjectMocks
  private RecomendacaoDiarioInserirDAOImpl target;
  @Mock
  private GeraSequenciaDAOImpl genericDAO;
  @Mock
  private RecomendacaoDiarioInserirSQLUtil sqlUtil;
  @Rule
  public ExpectedException thrown = ExpectedException.none();
  @Mock
  private CandlestickDiarioInserirSQLUtil incluirCandle;

  @Before
  public void setUp() throws Exception {
    FixtureFactoryLoader.loadTemplates("com.ricardococati.repository.dao.templates");
    target = new RecomendacaoDiarioInserirDAOImpl(
        getNamedParameterJdbcTemplate(),
        genericDAO,
        sqlUtil
    );
    incluiCandleAntesDeExecutarTestes();
  }

  @Test
  public void incluirRecomendacao() {
    //given
    when(genericDAO.getSequence(any())).thenReturn(1);
    when(sqlUtil.getInsert()).thenCallRealMethod();
    when(sqlUtil.toParameters(any())).thenCallRealMethod();
    RecomendacaoDiario dto = buildRecomendacao();
    //when
    Boolean retorno = target.incluirRecomendacao(dto);
    //then
    assertTrue(retorno);
  }

  @Test
  public void incluirMediaMovelExponencialSemanalNull() {
    //given
    when(genericDAO.getSequence(any())).thenReturn(1);
    when(sqlUtil.getInsert()).thenCallRealMethod();
    when(sqlUtil.toParameters(any())).thenCallRealMethod();
    RecomendacaoDiario dto = null;
    this.thrown.expectMessage(
        "Violação de integridade na inserção de RECOMENDACAO_DIARIO"
    );
    this.thrown.expect(DataIntegrityViolationException.class);
    //when
    Boolean retorno = target.incluirRecomendacao(dto);
  }

  @Test
  public void incluirMediaMovelExponencialDtPregNull() {
    //given
    when(genericDAO.getSequence(any())).thenReturn(1);
    when(sqlUtil.getInsert()).thenCallRealMethod();
    when(sqlUtil.toParameters(any())).thenCallRealMethod();
    RecomendacaoDiario dto = buildRecomendacao();
    dto.setDtpreg(null);
    this.thrown.expectMessage(
        "Violação de integridade na inserção de RECOMENDACAO_DIARIO"
    );
    this.thrown.expect(DataIntegrityViolationException.class);
    //when
    Boolean retorno = target.incluirRecomendacao(dto);
  }

  @Test
  public void incluirMediaMovelExponencialNull() {
    //given
    when(genericDAO.getSequence(any())).thenReturn(1);
    when(sqlUtil.getInsert()).thenCallRealMethod();
    when(sqlUtil.toParameters(any())).thenCallRealMethod();
    RecomendacaoDiario dto = buildRecomendacao();
    dto.setRecomendacao(null);
    this.thrown.expectMessage(
        "Violação de integridade na inserção de RECOMENDACAO_DIARIO"
    );
    this.thrown.expect(DataIntegrityViolationException.class);
    //when
    Boolean retorno = target.incluirRecomendacao(dto);
  }

  @Test
  public void incluirMediaMovelExponencialCodNegNull() {
    //given
    when(genericDAO.getSequence(any())).thenReturn(1);
    when(sqlUtil.getInsert()).thenCallRealMethod();
    when(sqlUtil.toParameters(any())).thenCallRealMethod();
    RecomendacaoDiario dto = buildRecomendacao();
    dto.getRecomendacao().setCodneg(null);
    this.thrown.expectMessage(
        "Violação de integridade na inserção de RECOMENDACAO_DIARIO"
    );
    this.thrown.expect(DataIntegrityViolationException.class);
    //when
    Boolean retorno = target.incluirRecomendacao(dto);
  }

  private void incluiCandleAntesDeExecutarTestes() {
    CandlestickDiarioInserirDAOImpl incluirDAO = new CandlestickDiarioInserirDAOImpl(
        getNamedParameterJdbcTemplate(), genericDAO, incluirCandle);
    when(incluirCandle.getInsert()).thenCallRealMethod();
    when(incluirCandle.toParameters(any())).thenCallRealMethod();
    when(genericDAO.getSequence(any())).thenReturn(1);
    incluirDAO.insereCandlestickDiario(getCandlestickDiario());
  }

  private CandlestickDiario getCandlestickDiario() {
    return from(CandlestickDiario.class)
        .gimme(CANDLESTICK_DIARIO_VALID_001);
  }

  private RecomendacaoDiario buildRecomendacao() {
    return from(RecomendacaoDiario.class)
        .gimme(RECOMENDACAO_DIARIO_VALID_001);
  }

}
