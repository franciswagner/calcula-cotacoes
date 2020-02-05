package com.ricardococati.repository.dao.impl;

import static br.com.six2six.fixturefactory.Fixture.from;
import static com.ricardococati.repository.dao.templates.SinalMacdSemanalTemplateLoader.SINAL_MACD_SEMANAL_VALID_001;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.ricardococati.model.dto.SinalMacdSemanal;
import com.ricardococati.repository.dao.config.BaseJdbcTest;
import com.ricardococati.repository.dao.sqlutil.SinalMacdSemanalSQLUtil;
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
public class SinalMacdSemanalInserirDAOImplTest extends BaseJdbcTest {

  @InjectMocks
  private SinalMacdSemanalInserirDAOImpl target;
  @Mock
  private GeraSequenciaDAOImpl genericDAO;
  @Mock
  private SinalMacdSemanalSQLUtil sqlUtil;
  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Before
  public void setUp() throws Exception {
    FixtureFactoryLoader.loadTemplates("com.ricardococati.repository.dao.templates");
    target = new SinalMacdSemanalInserirDAOImpl(
        getNamedParameterJdbcTemplate(),
        genericDAO,
        sqlUtil
    );
  }

  @Test
  public void incluirSinalMacd() {
    //given
    when(genericDAO.getSequence(any())).thenReturn(1);
    when(sqlUtil.getInsert()).thenCallRealMethod();
    when(sqlUtil.toParameters(any())).thenCallRealMethod();
    SinalMacdSemanal dto = buildSinalMacdSemanal();
    //when
    Boolean retorno = target.incluirSinalMacd(dto);
    //then
    assertTrue(retorno);
  }

  @Test
  public void incluirSinalMacdSemanalNull() {
    //given
    when(genericDAO.getSequence(any())).thenReturn(1);
    when(sqlUtil.getInsert()).thenCallRealMethod();
    when(sqlUtil.toParameters(any())).thenCallRealMethod();
    SinalMacdSemanal dto = null;
    this.thrown.expectMessage(
        "Violação de integridade na inserção de SINAL_MACD_SEMANAL"
    );
    this.thrown.expect(DataIntegrityViolationException.class);
    //when
    Boolean retorno = target.incluirSinalMacd(dto);
  }

  @Test
  public void incluirSinalMacdDtPregNull() {
    //given
    when(genericDAO.getSequence(any())).thenReturn(1);
    when(sqlUtil.getInsert()).thenCallRealMethod();
    when(sqlUtil.toParameters(any())).thenCallRealMethod();
    SinalMacdSemanal dto = buildSinalMacdSemanal();
    dto.setDtpregini(null);
    this.thrown.expectMessage(
        "Violação de integridade na inserção de SINAL_MACD_SEMANAL"
    );
    this.thrown.expect(DataIntegrityViolationException.class);
    //when
    Boolean retorno = target.incluirSinalMacd(dto);
  }

  @Test
  public void incluirSinalMacdNull() {
    //given
    when(genericDAO.getSequence(any())).thenReturn(1);
    when(sqlUtil.getInsert()).thenCallRealMethod();
    when(sqlUtil.toParameters(any())).thenCallRealMethod();
    SinalMacdSemanal dto = buildSinalMacdSemanal();
    dto.setSinalMacd(null);
    this.thrown.expectMessage(
        "Violação de integridade na inserção de SINAL_MACD_SEMANAL"
    );
    this.thrown.expect(DataIntegrityViolationException.class);
    //when
    Boolean retorno = target.incluirSinalMacd(dto);
  }

  @Test
  public void incluirSinalMacdCodNegNull() {
    //given
    when(genericDAO.getSequence(any())).thenReturn(1);
    when(sqlUtil.getInsert()).thenCallRealMethod();
    when(sqlUtil.toParameters(any())).thenCallRealMethod();
    SinalMacdSemanal dto = buildSinalMacdSemanal();
    dto.getSinalMacd().setCodneg(null);
    this.thrown.expectMessage(
        "Violação de integridade na inserção de SINAL_MACD_SEMANAL"
    );
    this.thrown.expect(DataIntegrityViolationException.class);
    //when
    Boolean retorno = target.incluirSinalMacd(dto);
  }

  private SinalMacdSemanal buildSinalMacdSemanal() {
    return from(SinalMacdSemanal.class)
        .gimme(SINAL_MACD_SEMANAL_VALID_001);
  }

}