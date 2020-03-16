package com.ricardococati.repository.dao.impl;

import static com.ricardococati.repository.util.BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import com.ricardococati.model.entities.Candlestick;
import com.ricardococati.model.entities.CandlestickDiario;
import com.ricardococati.repository.dao.config.BaseJdbcTest;
import com.ricardococati.repository.dao.sqlutil.CandlestickDiarioInserirSQLUtil;
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
    target = new CandlestickDiarioInserirDAOImpl(
        getNamedParameterJdbcTemplate(),
        genericDAO,
        sqlUtil
    );
  }

  @Test
  public void incluirCandlestickDiario() {
    //given
    when(genericDAO.getSequence(any())).thenReturn(1);
    when(sqlUtil.getInsert()).thenCallRealMethod();
    when(sqlUtil.toParameters(any())).thenCallRealMethod();
    CandlestickDiario dto = buildCandlestickDiarioDTO("MGLU3", 10.1, dtpreg.plusDays(countInteger += 1));
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
    CandlestickDiario dto = buildCandlestickDiarioDTO("MGLU3", 10.1, null);
    this.thrown.expectMessage("Violação de chave na inserção de CANDLESTICK_DIARIO");
    this.thrown.expect(DataIntegrityViolationException.class);
    //when
    Boolean retorno = target.insereCandlestickDiario(dto);
  }

  private CandlestickDiario buildCandlestickDiarioDTO(
      final String codneg,
      final Double preult,
      final LocalDate dtpreg
  ) {
    return CandlestickDiario
        .builder()
        .dtpreg(dtpreg)
        .candlestick(Candlestick
            .builder()
            .preult(getValueBigDecimalHalfUpArredondado4Casas(preult))
            .codneg(codneg)
            .build()
        ).build();
  }

}
