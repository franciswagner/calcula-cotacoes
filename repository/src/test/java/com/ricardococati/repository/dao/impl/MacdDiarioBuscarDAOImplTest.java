package com.ricardococati.repository.dao.impl;

import static br.com.six2six.fixturefactory.Fixture.from;
import static com.ricardococati.repository.dao.templates.MacdDiarioTemplateLoader.MACD_DIARIO_VALID_001;
import static com.ricardococati.repository.dao.templates.MacdDiarioTemplateLoader.MACD_DIARIO_VALID_002;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.ricardococati.model.dto.MacdDiario;
import com.ricardococati.model.dto.RecomendacaoDiario;
import com.ricardococati.repository.dao.config.BaseJdbcTest;
import com.ricardococati.repository.dao.mapper.MacdDiarioMapper;
import com.ricardococati.repository.dao.sqlutil.MacdDiarioSQLUtil;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class MacdDiarioBuscarDAOImplTest extends BaseJdbcTest {

  @InjectMocks
  private MacdDiarioBuscarDAOImpl target;
  @Mock
  private MacdDiarioMapper mapper;
  @Mock
  private MacdDiarioSQLUtil sqlUtil;
  @Mock
  private GeraSequenciaDAOImpl genericDAO;

  @Before
  public void setUp() throws Exception {
    FixtureFactoryLoader.loadTemplates("com.ricardococati.repository.dao.templates");
    target = new MacdDiarioBuscarDAOImpl(getNamedParameterJdbcTemplate(), sqlUtil, mapper);
    incluiMacdAntesDeExecutarTestes();
  }

  @Test
  public void listMacdByCodNeg() {
    //given
    when(sqlUtil.getSelectByCodNeg()).thenCallRealMethod();
    when(sqlUtil.toParametersByCodNeg(any())).thenCallRealMethod();
    when(mapper.mapper(any())).thenCallRealMethod();
    //when
    List<MacdDiario> result = target.listMacdByCodNeg("MGLU3");
    //then
    assertTrue(!result.isEmpty());
    assertThat(result).isNotNull().size().isEqualTo(2);
    assertThat(result.get(0).getDtpreg()).isNotNull().isEqualTo(LocalDate.of(1978, 2, 16));
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
    List<MacdDiario> result = target.buscaMacdMediaSimplesPorCodNegDtPregLimite9Periodos("MGLU3", dtpregLocal);
    //then
    assertTrue(!result.isEmpty());
    assertThat(result).isNotNull().size().isEqualTo(1);
    assertThat(result.get(0).getDtpreg()).isNotNull().isEqualTo(LocalDate.of(1978, 2, 16));
    assertThat(result.get(0).getMacd().getCodneg()).isNotNull().isEqualTo("MGLU3");
    assertThat(result.get(0).getMacd().getPremacd()).isNotNull().isEqualTo(new BigDecimal("11.11"));
  }

  private void incluiMacdAntesDeExecutarTestes() {
    MacdDiarioInserirDAOImpl incluirDAO = new MacdDiarioInserirDAOImpl(
        getNamedParameterJdbcTemplate(), genericDAO, sqlUtil);
    when(sqlUtil.getInsert()).thenCallRealMethod();
    when(sqlUtil.toParameters(any())).thenCallRealMethod();
    when(genericDAO.getSequence(any())).thenReturn(1);
    macdDiarioList()
        .parallelStream()
        .filter(Objects::nonNull)
        .forEach(incluirDAO::incluirMacd);
  }

  private List<MacdDiario> macdDiarioList(){
    return from(MacdDiario.class)
        .gimme(2,
            MACD_DIARIO_VALID_001,
            MACD_DIARIO_VALID_002
        );
  }

}
