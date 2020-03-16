package com.ricardococati.repository.dao.impl;

import static br.com.six2six.fixturefactory.Fixture.from;
import static com.ricardococati.repository.dao.templates.CandlestickDiarioDTOTemplateLoader.CANDLESTICK_DIARIO_DTO_VALID_001;
import static com.ricardococati.repository.dao.templates.SinalMacdDiarioTemplateLoader.SINAL_MACD_DIARIO_VALID_001;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.ricardococati.model.entities.CandlestickDiario;
import com.ricardococati.model.entities.SinalMacdDiario;
import com.ricardococati.repository.dao.config.BaseJdbcTest;
import com.ricardococati.repository.dao.mapper.SinalMacdDiarioMapper;
import com.ricardococati.repository.dao.sqlutil.CandlestickDiarioInserirSQLUtil;
import com.ricardococati.repository.dao.sqlutil.SinalMacdDiarioSQLUtil;
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
public class SinalMacdDiarioBuscarDAOImplTest extends BaseJdbcTest {

  @InjectMocks
  private SinalMacdDiarioBuscarDAOImpl target;
  @Mock
  private SinalMacdDiarioSQLUtil sqlUtil;
  @Mock
  private SinalMacdDiarioMapper mapper;
  @Mock
  private GeraSequenciaDAOImpl genericDAO;
  @Mock
  private SinalMacdDiarioSQLUtil incluirSinalMacd;
  @Mock
  private CandlestickDiarioInserirSQLUtil incluirSQLUtil;

  @Before
  public void setUp() throws Exception {
    FixtureFactoryLoader.loadTemplates("com.ricardococati.repository.dao.templates");
    target = new SinalMacdDiarioBuscarDAOImpl(
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
    incluiSinalMacdAntesDeExecutarTestes();
  }

  @Test
  public void listSinalMacdByCodNeg() {
    //given
    when(sqlUtil.getSelectByCodNeg()).thenCallRealMethod();
    when(sqlUtil.toParametersByCodNeg(any())).thenCallRealMethod();
    when(mapper.mapper(any())).thenCallRealMethod();
    //when
    List<SinalMacdDiario> result =
        target.listSinalMacdByCodNeg("MGLU3");
    //then
    assertTrue(!result.isEmpty());
    assertThat(result).isNotNull().size().isEqualTo(1);
    assertThat(result.get(0).getDtpreg()).isNotNull().isEqualTo(LocalDate.of(1978, 2, 16));
    assertThat(result.get(0).getSinalMacd().getCodneg()).isNotNull().isEqualTo("MGLU3");
    assertThat(result.get(0).getSinalMacd().getPresinal()).isNotNull().isEqualTo(new BigDecimal("12.11"));
  }

  @Test
  public void getListMMEByNull() {
    //given
    when(sqlUtil.getSelectByCodNeg()).thenCallRealMethod();
    when(sqlUtil.toParametersByCodNeg(any())).thenCallRealMethod();
    when(mapper.mapper(any())).thenCallRealMethod();
    //when
    List<SinalMacdDiario> result =
        target.listSinalMacdByCodNeg(null);
    //then
    assertTrue(result.isEmpty());
  }

  @Test
  public void getListMMEByCodNegEmpty() {
    //given
    when(sqlUtil.getSelectByCodNeg()).thenCallRealMethod();
    when(sqlUtil.toParametersByCodNeg(any())).thenCallRealMethod();
    when(mapper.mapper(any())).thenCallRealMethod();
    //when
    List<SinalMacdDiario> result =
        target.listSinalMacdByCodNeg("");
    //then
    assertTrue(result.isEmpty());
  }

  private void incluiSinalMacdAntesDeExecutarTestes() {
    SinalMacdDiarioInserirDAOImpl incluirDAO = new SinalMacdDiarioInserirDAOImpl(
        getNamedParameterJdbcTemplate(), genericDAO, incluirSinalMacd);
    when(incluirSinalMacd.getInsert()).thenCallRealMethod();
    when(incluirSinalMacd.toParameters(any())).thenCallRealMethod();
    when(genericDAO.getSequence(any())).thenReturn(1);
    incluirDAO.incluirSinalMacd(sinalMacdDiario());
  }

  private SinalMacdDiario sinalMacdDiario(){
    return from(SinalMacdDiario.class)
        .gimme(SINAL_MACD_DIARIO_VALID_001);
  }

  private CandlestickDiario buildCandlestickDiarioDTO() {
    return from(CandlestickDiario.class)
        .gimme(CANDLESTICK_DIARIO_DTO_VALID_001);
  }

}
