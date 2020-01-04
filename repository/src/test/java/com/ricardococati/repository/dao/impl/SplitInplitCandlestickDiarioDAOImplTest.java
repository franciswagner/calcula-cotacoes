package com.ricardococati.repository.dao.impl;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import com.ricardococati.model.dto.CandlestickDTO;
import com.ricardococati.model.dto.CandlestickDiarioDTO;
import com.ricardococati.model.dto.SplitInplit;
import com.ricardococati.model.enums.OperacaoSplitInplit;
import com.ricardococati.repository.dao.BaseOccurrenceJdbcTest;
import com.ricardococati.repository.dao.GenericDAO;
import com.ricardococati.repository.dao.sqlutil.IncluirCandlestickDiarioSQLUtil;
import com.ricardococati.repository.dao.sqlutil.SplitInplitCandlestickDiarioSQLUtil;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class SplitInplitCandlestickDiarioDAOImplTest extends BaseOccurrenceJdbcTest {

  @InjectMocks
  private SplitInplitCandlestickDiarioDAOImpl target;
  @MockBean
  private IncluirCandlestickDiarioDAOImpl incluirDAO;
  @Mock
  private SplitInplitCandlestickDiarioSQLUtil sqlUtil;
  @Mock
  private IncluirCandlestickDiarioSQLUtil incluirSQLUtil;
  @Mock
  private GenericDAO genericDAO;
  private Integer countInteger;
  private LocalDate dtpreg;

  @Before
  public void setUp() {
    this.countInteger = 0;
    this.dtpreg = LocalDate.of(1978, 02, 16);
    target = new SplitInplitCandlestickDiarioDAOImpl(getNamedParameterJdbcTemplate(), sqlUtil);
    incluiCandleAntesDeExecutarTestes();
  }

  private void incluiCandleAntesDeExecutarTestes() {
    incluirDAO = new IncluirCandlestickDiarioDAOImpl(getNamedParameterJdbcTemplate(), genericDAO, incluirSQLUtil);
    when(incluirSQLUtil.getInsert()).thenCallRealMethod();
    when(incluirSQLUtil.toParameters(any())).thenCallRealMethod();
    when(genericDAO.getSequence(any(), any())).thenReturn(1);
    incluirDAO.incluirCandlestickDiario(
        buildCandlestickDiarioDTO("MGLU3", 10.1, dtpreg.plusDays(countInteger += 1))
    );
  }

  @Test
  public void updateSplit() {
    //given
    SplitInplit splitInplit = build("MGLU3", LocalDate.now(), 2, "SPLIT");
    when(sqlUtil.getUpdateSplitInplit(any())).thenCallRealMethod();
    when(sqlUtil.toParametersUpdateSplitInplit(any())).thenCallRealMethod();
    //when
    Boolean retorno = target.updateSplitInplit(splitInplit);
    //then
    assertTrue(retorno);
  }

  @Test
  public void updateInplit() {
    //given
    SplitInplit splitInplit = build("MGLU3", LocalDate.now(), 2, "INPLIT");
    when(sqlUtil.getUpdateSplitInplit(any())).thenCallRealMethod();
    when(sqlUtil.toParametersUpdateSplitInplit(any())).thenCallRealMethod();
    //when
    Boolean retorno = target.updateSplitInplit(splitInplit);
    //then
    assertTrue(retorno);
  }

  private SplitInplit build(
      final String codneg,
      final LocalDate dtpreg,
      final Integer qtdSplitInplit,
      final String operacao
  ) {
    return SplitInplit
        .builder()
        .codneg(codneg)
        .dtpreg(dtpreg)
        .qtdSplitInplit(qtdSplitInplit)
        .operacao(OperacaoSplitInplit.valueOf(operacao))
        .build();
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
            .preult(new BigDecimal(preult).setScale(4, BigDecimal.ROUND_HALF_UP))
            .codneg(codneg)
            .build()
        ).build();
  }

}