package com.ricardococati.repository.dao.impl;

import static br.com.six2six.fixturefactory.Fixture.from;
import static com.ricardococati.repository.dao.templates.MacdSemanalTemplateLoader.MACD_SEMANAL_VALID_001;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.ricardococati.model.dto.MacdSemanal;
import com.ricardococati.repository.dao.BaseJdbcTest;
import com.ricardococati.repository.dao.sqlutil.MacdSemanalSQLUtil;
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
public class MacdSemanalInserirDAOImplTest extends BaseJdbcTest {

  @InjectMocks
  private MacdSemanalInserirDAOImpl target;
  @Mock
  private GeraSequenciaDAOImpl genericDAO;
  @Mock
  private MacdSemanalSQLUtil sqlUtil;
  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Before
  public void setUp() throws Exception {
    FixtureFactoryLoader.loadTemplates("com.ricardococati.repository.dao.templates");
    target = new MacdSemanalInserirDAOImpl(getNamedParameterJdbcTemplate(), genericDAO, sqlUtil);
  }

  @Test
  public void incluirMacd() {
    //given
    when(genericDAO.getSequence(any())).thenReturn(1);
    when(sqlUtil.getInsert()).thenCallRealMethod();
    when(sqlUtil.toParameters(any())).thenCallRealMethod();
    MacdSemanal dto = buildMacd();
    //when
    Boolean retorno = target.incluirMacd(dto);
    //then
    assertTrue(retorno);
  }

  @Test
  public void incluirMacdNull() {
    //given
    when(genericDAO.getSequence(any())).thenReturn(1);
    when(sqlUtil.getInsert()).thenCallRealMethod();
    when(sqlUtil.toParameters(any())).thenCallRealMethod();
    MacdSemanal dto = null;
    this.thrown.expectMessage("Violação de integridade na inserção de MACD_SEMANAL");
    this.thrown.expect(DataIntegrityViolationException.class);
    //when
    target.incluirMacd(dto);
  }

  private MacdSemanal buildMacd() {
    return from(MacdSemanal.class)
        .gimme(MACD_SEMANAL_VALID_001);
  }

}
