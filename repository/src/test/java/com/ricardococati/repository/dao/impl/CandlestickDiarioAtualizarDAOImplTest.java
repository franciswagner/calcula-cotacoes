package com.ricardococati.repository.dao.impl;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import com.ricardococati.model.dto.CandlestickDTO;
import com.ricardococati.model.dto.CandlestickDiarioDTO;
import com.ricardococati.model.dto.SplitInplit;
import com.ricardococati.model.enums.OperacaoSplitInplit;
import com.ricardococati.repository.dao.config.BaseJdbcTest;
import com.ricardococati.repository.dao.sqlutil.CandlestickDiarioInserirSQLUtil;
import com.ricardococati.repository.dao.sqlutil.CandlestickDiarioAtualizarSQLUtil;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CandlestickDiarioAtualizarDAOImplTest extends BaseJdbcTest {

  @InjectMocks
  private CandlestickDiarioAtualizarDAOImpl target;
  @Mock
  private CandlestickDiarioAtualizarSQLUtil sqlUtil;
  @Mock
  private CandlestickDiarioInserirSQLUtil incluirSQLUtil;
  @Mock
  private GeraSequenciaDAOImpl genericDAO;
  private Integer countInteger;
  private LocalDate dtpreg;

  @Before
  public void setUp() {
    this.countInteger = 0;
    this.dtpreg = LocalDate.of(1978, 2, 16);
    target = new CandlestickDiarioAtualizarDAOImpl(getNamedParameterJdbcTemplate(), sqlUtil);
    incluiCandleAntesDeExecutarTestes();
  }

  private void incluiCandleAntesDeExecutarTestes() {
    CandlestickDiarioInserirDAOImpl incluirDAO = new CandlestickDiarioInserirDAOImpl(
        getNamedParameterJdbcTemplate(), genericDAO, incluirSQLUtil);
    when(incluirSQLUtil.getInsert()).thenCallRealMethod();
    when(incluirSQLUtil.toParameters(any())).thenCallRealMethod();
    when(genericDAO.getSequence(any())).thenReturn(1);
    incluirDAO.insereCandlestickDiario(
        buildCandlestickDiarioDTO(dtpreg.plusDays(countInteger += 1))
    );
  }

  @Test
  public void updateSplit() {
    //given
    SplitInplit splitInplit = build(LocalDate.now(), "SPLIT");
    when(sqlUtil.getUpdateSplitInplit(any())).thenCallRealMethod();
    when(sqlUtil.toParametersUpdateSplitInplit(any())).thenCallRealMethod();
    //when
    Boolean retorno = target.atualizaSplitInplit(splitInplit);
    //then
    assertTrue(retorno);
  }

  @Test
  public void updateInplit() {
    //given
    SplitInplit splitInplit = build(LocalDate.now(), "INPLIT");
    when(sqlUtil.getUpdateSplitInplit(any())).thenCallRealMethod();
    when(sqlUtil.toParametersUpdateSplitInplit(any())).thenCallRealMethod();
    //when
    Boolean retorno = target.atualizaSplitInplit(splitInplit);
    //then
    assertTrue(retorno);
  }

  private SplitInplit build(
      final LocalDate dtpreg,
      final String operacao
  ) {
    return SplitInplit
        .builder()
        .codneg("MGLU3")
        .dtpreg(dtpreg)
        .qtdSplitInplit(2)
        .operacao(OperacaoSplitInplit.valueOf(operacao))
        .build();
  }

  private CandlestickDiarioDTO buildCandlestickDiarioDTO(
      final LocalDate dtpreg
  ) {
    return CandlestickDiarioDTO
        .builder()
        .dtpreg(dtpreg)
        .candlestickDTO(CandlestickDTO
            .builder()
            .preult(new BigDecimal(10.1).setScale(4, BigDecimal.ROUND_HALF_UP))
            .codneg("MGLU3")
            .build()
        ).build();
  }

}