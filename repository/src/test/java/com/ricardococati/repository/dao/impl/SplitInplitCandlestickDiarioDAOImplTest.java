package com.ricardococati.repository.dao.impl;

import static org.junit.Assert.assertFalse;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import com.ricardococati.model.dto.SplitInplit;
import com.ricardococati.model.enums.OperacaoSplitInplit;
import com.ricardococati.repository.dao.BaseOccurrenceJdbcTest;
import com.ricardococati.repository.dao.sqlutil.SplitInplitCandlestickDiarioSQLUtil;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class SplitInplitCandlestickDiarioDAOImplTest extends BaseOccurrenceJdbcTest {

  @InjectMocks
  private SplitInplitCandlestickDiarioDAOImpl target;
  @Mock
  private SplitInplitCandlestickDiarioSQLUtil sqlUtil;

  @Before
  public void setUp() {
    target = new SplitInplitCandlestickDiarioDAOImpl(getNamedParameterJdbcTemplate(), sqlUtil);
  }

  @Test
  public void updateSplitInplit() {
    //given
    SplitInplit splitInplit = build("MGLU3", LocalDate.now(), 2, "SPLIT");
    when(sqlUtil.getUpdateSplitInplit(any())).thenCallRealMethod();
    when(sqlUtil.toParametersUpdateSplitInplit(any())).thenCallRealMethod();
    //when
    Boolean retorno = target.updateSplitInplit(splitInplit);
    //then
    assertFalse(retorno);
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

}