package com.ricardococati.repository.dao.impl;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import com.ricardococati.model.dto.CandlestickDTO;
import com.ricardococati.model.dto.CandlestickDiarioDTO;
import com.ricardococati.model.dto.CandlestickSemanalDTO;
import com.ricardococati.repository.dao.BaseJdbcTest;
import com.ricardococati.repository.dao.sqlutil.CandlestickSemanalInserirSQLUtil;
import java.math.BigDecimal;
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
  private GenericDAOImpl genericDAO;
  @Mock
  private CandlestickSemanalInserirSQLUtil sqlUtil;
  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Before
  public void setUp() throws Exception {
    target = new CandlestickSemanalInserirDAOImpl(
        getNamedParameterJdbcTemplate(),
        genericDAO,
        sqlUtil
    );
  }

  @Test
  public void incluirCandlestickSemanal() {
    //given
    when(genericDAO.getSequence(any(), any())).thenReturn(1);
    when(sqlUtil.getInsert()).thenCallRealMethod();
    when(sqlUtil.toParameters(any())).thenCallRealMethod();
    CandlestickSemanalDTO dto = buildCandlestick("MGLU3", 10.1, LocalDate.now(), LocalDate.now());
    //when
    Boolean retorno = target.incluirCandlestickSemanal(dto);
    //then
    assertTrue(retorno);
  }

  @Test
  public void incluirCandlestickSemanalDataInicialNull() {
    //given
    when(genericDAO.getSequence(any(), any())).thenReturn(1);
    when(sqlUtil.getInsert()).thenCallRealMethod();
    when(sqlUtil.toParameters(any())).thenCallRealMethod();
    CandlestickSemanalDTO dto = buildCandlestick("MGLU3", 10.1, null, LocalDate.now());
    this.thrown.expectMessage("Violação de chave na inserção de CANDLESTICK_SEMANAL");
    this.thrown.expect(DataIntegrityViolationException.class);
    //when
    Boolean retorno = target.incluirCandlestickSemanal(dto);
  }

  @Test
  public void incluirCandlestickSemanalDataFinalNull() {
    //given
    when(genericDAO.getSequence(any(), any())).thenReturn(1);
    when(sqlUtil.getInsert()).thenCallRealMethod();
    when(sqlUtil.toParameters(any())).thenCallRealMethod();
    CandlestickSemanalDTO dto = buildCandlestick("MGLU3", 10.1, LocalDate.now(), null);
    this.thrown.expectMessage("Violação de chave na inserção de CANDLESTICK_SEMANAL");
    this.thrown.expect(DataIntegrityViolationException.class);
    //when
    Boolean retorno = target.incluirCandlestickSemanal(dto);
  }

  @Test
  public void incluirCandlestickSemanalDatasNull() {
    //given
    when(genericDAO.getSequence(any(), any())).thenReturn(1);
    when(sqlUtil.getInsert()).thenCallRealMethod();
    when(sqlUtil.toParameters(any())).thenCallRealMethod();
    CandlestickSemanalDTO dto = buildCandlestick("MGLU3", 10.1, null, null);
    this.thrown.expectMessage("Violação de chave na inserção de CANDLESTICK_SEMANAL");
    this.thrown.expect(DataIntegrityViolationException.class);
    //when
    Boolean retorno = target.incluirCandlestickSemanal(dto);
  }

  private CandlestickSemanalDTO buildCandlestick(
      final String codneg,
      final Double preult,
      final LocalDate dtpregini,
      final LocalDate dtpregfim
  ) {
    return CandlestickSemanalDTO
        .builder()
        .dtpregini(dtpregini)
        .dtpregfim(dtpregfim)
        .candlestickDTO(CandlestickDTO
            .builder()
            .preult(new BigDecimal(preult).setScale(4, BigDecimal.ROUND_HALF_UP))
            .codneg(codneg)
            .build()
        ).build();
  }

}