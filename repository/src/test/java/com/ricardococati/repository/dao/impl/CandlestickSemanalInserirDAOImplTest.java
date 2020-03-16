package com.ricardococati.repository.dao.impl;

import static com.ricardococati.repository.util.BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import com.ricardococati.model.entities.Candlestick;
import com.ricardococati.model.entities.CandlestickDiario;
import com.ricardococati.model.entities.CandlestickSemanal;
import com.ricardococati.repository.dao.config.BaseJdbcTest;
import com.ricardococati.repository.dao.sqlutil.CandlestickDiarioInserirSQLUtil;
import com.ricardococati.repository.dao.sqlutil.CandlestickSemanalInserirSQLUtil;
import com.ricardococati.repository.dao.utils.InserirDadosPrimariosSemanalUtil;
import java.time.LocalDate;
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
public class CandlestickSemanalInserirDAOImplTest extends BaseJdbcTest {

  @InjectMocks
  private CandlestickSemanalInserirDAOImpl target;
  @Mock
  private GeraSequenciaDAOImpl genericDAO;
  @Mock
  private CandlestickSemanalInserirSQLUtil sqlUtil;
  @Mock
  private CandlestickDiarioInserirSQLUtil incluirDiarioSQLUtil;
  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Before
  public void setUp() throws Exception {
    target = new CandlestickSemanalInserirDAOImpl(
        getNamedParameterJdbcTemplate(),
        genericDAO,
        sqlUtil
    );
    InserirDadosPrimariosSemanalUtil util = new InserirDadosPrimariosSemanalUtil(
        getNamedParameterJdbcTemplate(),
        buildCandlestick("MGLU3", 10.1, LocalDate.now(), LocalDate.now()),
        sqlUtil,
        genericDAO,
        incluirDiarioSQLUtil,
        buildCandlestickDiarioDTO(LocalDate.now())
    );
    util.incluiCandleDiarioAntesDeExecutarTestes();
  }

  @Test
  public void incluirCandlestickSemanal() {
    //given
    when(genericDAO.getSequence(any())).thenReturn(1);
    when(sqlUtil.getInsert()).thenCallRealMethod();
    when(sqlUtil.toParameters(any())).thenCallRealMethod();
    CandlestickSemanal dto = buildCandlestick("MGLU3", 10.1, LocalDate.now(), LocalDate.now());
    //when
    Boolean retorno = target.incluirCandlestickSemanal(dto);
    //then
    assertTrue(retorno);
  }

  @Test
  public void incluirCandlestickSemanalDataInicialNull() {
    //given
    when(genericDAO.getSequence(any())).thenReturn(1);
    when(sqlUtil.getInsert()).thenCallRealMethod();
    when(sqlUtil.toParameters(any())).thenCallRealMethod();
    CandlestickSemanal dto = buildCandlestick("MGLU3", 10.1, null, LocalDate.now());
    this.thrown.expectMessage("Violação de chave na inserção de CANDLESTICK_SEMANAL");
    this.thrown.expect(DataIntegrityViolationException.class);
    //when
    target.incluirCandlestickSemanal(dto);
  }

  @Test
  public void incluirCandlestickSemanalDataFinalNull() {
    //given
    when(genericDAO.getSequence(any())).thenReturn(1);
    when(sqlUtil.getInsert()).thenCallRealMethod();
    when(sqlUtil.toParameters(any())).thenCallRealMethod();
    CandlestickSemanal dto = buildCandlestick("MGLU3", 10.1, LocalDate.now(), null);
    this.thrown.expectMessage("Violação de chave na inserção de CANDLESTICK_SEMANAL");
    this.thrown.expect(DataIntegrityViolationException.class);
    //when
    target.incluirCandlestickSemanal(dto);
  }

  @Test
  public void incluirCandlestickSemanalDatasNull() {
    //given
    when(genericDAO.getSequence(any())).thenReturn(1);
    when(sqlUtil.getInsert()).thenCallRealMethod();
    when(sqlUtil.toParameters(any())).thenCallRealMethod();
    CandlestickSemanal dto = buildCandlestick("MGLU3", 10.1, null, null);
    this.thrown.expectMessage("Violação de chave na inserção de CANDLESTICK_SEMANAL");
    this.thrown.expect(DataIntegrityViolationException.class);
    //when
    target.incluirCandlestickSemanal(dto);
  }

  private CandlestickSemanal buildCandlestick(
      final String codneg,
      final Double preult,
      final LocalDate dtpregini,
      final LocalDate dtpregfim
  ) {
    return CandlestickSemanal
        .builder()
        .dtpregini(dtpregini)
        .dtpregfim(dtpregfim)
        .candlestick(Candlestick
            .builder()
            .preult(getValueBigDecimalHalfUpArredondado4Casas(preult))
            .codneg(codneg)
            .build()
        ).build();
  }

  private CandlestickDiario buildCandlestickDiarioDTO(
      final LocalDate dtpreg
  ) {
    return CandlestickDiario
        .builder()
        .dtpreg(dtpreg)
        .candlestick(Candlestick
            .builder()
            .preult(getValueBigDecimalHalfUpArredondado4Casas(10.1))
            .codneg("MGLU3")
            .build()
        ).build();
  }

}