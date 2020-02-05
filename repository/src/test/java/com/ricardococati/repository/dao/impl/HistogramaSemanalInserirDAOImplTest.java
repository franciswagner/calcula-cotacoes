package com.ricardococati.repository.dao.impl;

import static br.com.six2six.fixturefactory.Fixture.from;
import static com.ricardococati.repository.dao.templates.HistogramaSemanalTemplateLoader.HISTOGRAMA_SEMANAL_VALID_001;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.ricardococati.model.dto.HistogramaSemanal;
import com.ricardococati.repository.dao.config.BaseJdbcTest;
import com.ricardococati.repository.dao.sqlutil.HistogramaSemanalSQLUtil;
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
public class HistogramaSemanalInserirDAOImplTest extends BaseJdbcTest {

  @InjectMocks
  private HistogramaSemanalInserirDAOImpl target;
  @Mock
  private GeraSequenciaDAOImpl genericDAO;
  @Mock
  private HistogramaSemanalSQLUtil sqlUtil;
  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Before
  public void setUp() throws Exception {
    FixtureFactoryLoader.loadTemplates("com.ricardococati.repository.dao.templates");
    target = new HistogramaSemanalInserirDAOImpl(getNamedParameterJdbcTemplate(), genericDAO, sqlUtil);
  }

  @Test
  public void incluirHistograma() {
    //given
    when(genericDAO.getSequence(any())).thenReturn(1);
    when(sqlUtil.getInsert()).thenCallRealMethod();
    when(sqlUtil.toParameters(any())).thenCallRealMethod();
    HistogramaSemanal dto = buildHistogramaSemanal();
    //when
    Boolean retorno = target.incluirHistograma(dto);
    //then
    assertTrue(retorno);
  }

  @Test
  public void incluirHistogramaNull() {
    //given
    when(genericDAO.getSequence(any())).thenReturn(1);
    when(sqlUtil.getInsert()).thenCallRealMethod();
    when(sqlUtil.toParameters(any())).thenCallRealMethod();
    HistogramaSemanal dto = null;
    this.thrown.expectMessage("Violação de integridade na inserção de HISTOGRAMA_SEMANAL");
    this.thrown.expect(DataIntegrityViolationException.class);
    //when
    Boolean retorno = target.incluirHistograma(dto);
  }

  private HistogramaSemanal buildHistogramaSemanal(){
    return from(HistogramaSemanal.class)
        .gimme(HISTOGRAMA_SEMANAL_VALID_001);
  }
}