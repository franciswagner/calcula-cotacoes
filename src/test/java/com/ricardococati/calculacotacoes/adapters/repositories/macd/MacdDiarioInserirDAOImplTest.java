package com.ricardococati.calculacotacoes.adapters.repositories.macd;

import static br.com.six2six.fixturefactory.Fixture.from;
import static com.ricardococati.calculacotacoes.templates.CandlestickDiarioDTOTemplateLoader.CANDLESTICK_DIARIO_VALID_001;
import static com.ricardococati.calculacotacoes.templates.MacdDiarioTemplateLoader.MACD_DIARIO_VALID_001;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.opentable.db.postgres.junit.EmbeddedPostgresRules;
import com.opentable.db.postgres.junit.SingleInstancePostgresRule;
import com.ricardococati.calculacotacoes.adapters.repositories.candlestick.sqlutil.CandlestickDiarioInserirSQLUtil;
import com.ricardococati.calculacotacoes.adapters.repositories.gerasequencia.impl.GeraSequenciaDAOImpl;
import com.ricardococati.calculacotacoes.adapters.repositories.macd.impl.MacdDiarioInserirDAOImpl;
import com.ricardococati.calculacotacoes.adapters.repositories.macd.sqlutil.MacdDiarioSQLUtil;
import com.ricardococati.calculacotacoes.config.BaseJdbcTest;
import com.ricardococati.calculacotacoes.entities.domains.candlestick.CandlestickDiario;
import com.ricardococati.calculacotacoes.entities.domains.macd.MacdDiario;
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
public class MacdDiarioInserirDAOImplTest extends BaseJdbcTest {

  @InjectMocks
  private MacdDiarioInserirDAOImpl target;
  @Mock
  private GeraSequenciaDAOImpl genericDAO;
  @Mock
  private MacdDiarioSQLUtil sqlUtil;
  @Mock
  private CandlestickDiarioInserirSQLUtil incluirSQLUtil;
  @Rule
  public ExpectedException thrown = ExpectedException.none();
  @Rule
  public SingleInstancePostgresRule pg = EmbeddedPostgresRules.singleInstance();

  @Before
  public void setUp() throws Exception {
    FixtureFactoryLoader.loadTemplates("com.ricardococati.calculacotacoes.templates");
    target = new MacdDiarioInserirDAOImpl(
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
  public void incluirMacd() {
    //given
    when(genericDAO.getSequence(any())).thenReturn(1);
    when(sqlUtil.getInsert()).thenCallRealMethod();
    when(sqlUtil.toParameters(any())).thenCallRealMethod();
    MacdDiario dto = buildMacd();
    //when
    Boolean retorno = target.incluirMacd(dto);
    //then
    assertTrue(retorno);
  }

  @Test
  public void incluirHistogramaNull() {
    //given
    when(genericDAO.getSequence(any())).thenReturn(1);
    when(sqlUtil.getInsert()).thenCallRealMethod();
    when(sqlUtil.toParameters(any())).thenCallRealMethod();
    MacdDiario dto = null;
    this.thrown.expectMessage("Viola????o de integridade na inser????o de MACD_DIARIO");
    this.thrown.expect(DataIntegrityViolationException.class);
    //when
    target.incluirMacd(dto);
  }

  private MacdDiario buildMacd() {
    return from(MacdDiario.class)
        .gimme(MACD_DIARIO_VALID_001);
  }

  private CandlestickDiario buildCandlestickDiarioDTO() {
    return from(CandlestickDiario.class)
        .gimme(CANDLESTICK_DIARIO_VALID_001);
  }

}
