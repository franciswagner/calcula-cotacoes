package com.ricardococati.calculacotacoes.adapters.repositories.macd;

import static br.com.six2six.fixturefactory.Fixture.from;
import static com.ricardococati.calculacotacoes.adapters.repositories.templates.CandlestickDiarioDTOTemplateLoader.CANDLESTICK_DIARIO_VALID_001;
import static com.ricardococati.calculacotacoes.adapters.repositories.templates.CandlestickSemanalDTOTemplateLoader.CANDLESTICK_SEMANAL_VALID_001;
import static com.ricardococati.calculacotacoes.adapters.repositories.templates.MacdSemanalTemplateLoader.MACD_SEMANAL_VALID_001;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.ricardococati.calculacotacoes.adapters.repositories.candlestick.sqlutil.CandlestickDiarioInserirSQLUtil;
import com.ricardococati.calculacotacoes.adapters.repositories.candlestick.sqlutil.CandlestickSemanalInserirSQLUtil;
import com.ricardococati.calculacotacoes.adapters.repositories.gerasequencia.impl.GeraSequenciaDAOImpl;
import com.ricardococati.calculacotacoes.adapters.repositories.macd.impl.MacdSemanalBuscarDAOImpl;
import com.ricardococati.calculacotacoes.adapters.repositories.macd.impl.MacdSemanalInserirDAOImpl;
import com.ricardococati.calculacotacoes.adapters.repositories.macd.mapper.MacdSemanalMapper;
import com.ricardococati.calculacotacoes.adapters.repositories.macd.sqlutil.MacdSemanalSQLUtil;
import com.ricardococati.calculacotacoes.adapters.repositories.config.BaseJdbcTest;
import com.ricardococati.calculacotacoes.entities.domains.candlestick.CandlestickDiario;
import com.ricardococati.calculacotacoes.entities.domains.candlestick.CandlestickSemanal;
import com.ricardococati.calculacotacoes.entities.domains.macd.MacdSemanal;
import com.ricardococati.calculacotacoes.adapters.repositories.utils.InserirDadosPrimariosSemanalUtil;
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
public class MacdSemanalBuscarDAOImplTest extends BaseJdbcTest {

  @InjectMocks
  private MacdSemanalBuscarDAOImpl target;
  @Mock
  private MacdSemanalMapper mapper;
  @Mock
  private MacdSemanalSQLUtil sqlUtil;
  @Mock
  private GeraSequenciaDAOImpl genericDAO;
  @Mock
  private CandlestickSemanalInserirSQLUtil incluirSQLUtil;
  @Mock
  private CandlestickDiarioInserirSQLUtil incluirDiarioSQLUtil;

  @Before
  public void setUp() throws Exception {
    FixtureFactoryLoader.loadTemplates("com.ricardococati.calculacotacoes.adapters.repositories.templates");
    target = new MacdSemanalBuscarDAOImpl(
        getNamedParameterJdbcTemplate(),
        sqlUtil,
        mapper
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
    incluiMacdAntesDeExecutarTestes();
  }

  @Test
  public void listMacdByCodNeg() {
    //given
    when(sqlUtil.getSelectByCodNeg()).thenCallRealMethod();
    when(sqlUtil.toParametersByCodNeg(any())).thenCallRealMethod();
    when(mapper.mapper(any())).thenCallRealMethod();
    //when
    List<MacdSemanal> result = target.listMacdByCodNeg("MGLU3");
    //then
    assertTrue(!result.isEmpty());
    assertThat(result).isNotNull().size().isEqualTo(1);
    assertThat(result.get(0).getDtpregini()).isNotNull().isEqualTo(LocalDate.of(1978, 2, 16));
    assertThat(result.get(0).getMacd().getCodneg()).isNotNull().isEqualTo("MGLU3");
    assertThat(result.get(0).getMacd().getPremacd()).isNotNull().isEqualTo(new BigDecimal("11.11"));
  }

  @Test
  public void buscaMacdMediaSimplesPorCodNegDtPregLimite9Periodos() {
    //given
    LocalDate dtpregLocal = LocalDate.of(1978,2,16);
    when(sqlUtil.getSelectByCodNegEDtpregLimite9Periodos()).thenCallRealMethod();
    when(sqlUtil.toParametersByCodNegDtpregLimite9Periodos(any(), any())).thenCallRealMethod();
    when(mapper.mapper(any())).thenCallRealMethod();
    //when
    List<MacdSemanal> result = target.buscaMacdMediaSimplesPorCodNegDtPregLimite9Periodos("MGLU3", dtpregLocal);
    //then
    assertTrue(!result.isEmpty());
    assertThat(result).isNotNull().size().isEqualTo(1);
    assertThat(result.get(0).getDtpregini()).isNotNull().isEqualTo(LocalDate.of(1978, 2, 16));
    assertThat(result.get(0).getMacd().getCodneg()).isNotNull().isEqualTo("MGLU3");
    assertThat(result.get(0).getMacd().getPremacd()).isNotNull().isEqualTo(new BigDecimal("11.11"));
  }

  private void incluiMacdAntesDeExecutarTestes() {
    MacdSemanalInserirDAOImpl incluirDAO = new MacdSemanalInserirDAOImpl(
        getNamedParameterJdbcTemplate(), genericDAO, sqlUtil);
    when(sqlUtil.getInsert()).thenCallRealMethod();
    when(sqlUtil.toParameters(any())).thenCallRealMethod();
    when(genericDAO.getSequence(any())).thenReturn(1);
    incluirDAO.incluirMacd(macdSemanal());
  }

  private MacdSemanal macdSemanal(){
    return from(MacdSemanal.class)
        .gimme(MACD_SEMANAL_VALID_001);
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
