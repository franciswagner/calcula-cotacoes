package com.ricardococati.repository.dao.impl;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import com.ricardococati.model.dto.CandlestickDTO;
import com.ricardococati.model.dto.CandlestickDiarioDTO;
import com.ricardococati.repository.dao.config.BaseJdbcTest;
import com.ricardococati.repository.dao.sqlutil.CandlestickDiarioInserirSQLUtil;
import java.math.BigDecimal;
import java.math.RoundingMode;
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
public class CandlestickDiarioInserirDAOImplTest extends BaseJdbcTest {

  @InjectMocks
  private CandlestickDiarioInserirDAOImpl target;
  @Mock
  private GeraSequenciaDAOImpl genericDAO;
  @Mock
  private CandlestickDiarioInserirSQLUtil sqlUtil;
  private Integer countInteger;
  private LocalDate dtpreg;
  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Before
  public void setUp() {
    this.countInteger = 0;
    this.dtpreg = LocalDate.of(1978, 2, 16);
    target = new CandlestickDiarioInserirDAOImpl(getNamedParameterJdbcTemplate(), genericDAO, sqlUtil);
  }

  @Test
  public void incluirCandlestickDiario() {
    //given
    when(genericDAO.getSequence(any())).thenReturn(1);
    when(sqlUtil.getInsert()).thenCallRealMethod();
    when(sqlUtil.toParameters(any())).thenCallRealMethod();
    CandlestickDiarioDTO dto = buildCandlestickDiarioDTO("MGLU3", 10.1, dtpreg.plusDays(countInteger += 1));
    //when
    Boolean retorno = target.insereCandlestickDiario(dto);
    //then
    assertTrue(retorno);
  }

  @Test
  public void incluirCandlestickDiarioNull() {
    //given
    when(genericDAO.getSequence(any())).thenReturn(1);
    when(sqlUtil.getInsert()).thenCallRealMethod();
    when(sqlUtil.toParameters(any())).thenCallRealMethod();
    CandlestickDiarioDTO dto = buildCandlestickDiarioDTO("MGLU3", 10.1, null);
    this.thrown.expectMessage("Violação de chave na inserção de CANDLESTICK_DIARIO");
    this.thrown.expect(DataIntegrityViolationException.class);
    //when
    Boolean retorno = target.insereCandlestickDiario(dto);
  }

  private CandlestickDiarioDTO buildCandlestickDiarioDTO(
      final String codneg,
      final Double preult,
      final LocalDate dtpreg
  ) {
    return CandlestickDiarioDTO
        .builder()
        .dtpreg(dtpreg)
        .candlestickDTO(CandlestickDTO
            .builder()
            .preult(new BigDecimal(preult).setScale(4, RoundingMode.HALF_UP))
            .codneg(codneg)
            .build()
        ).build();
  }

}
