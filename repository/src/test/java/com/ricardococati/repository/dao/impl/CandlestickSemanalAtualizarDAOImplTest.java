package com.ricardococati.repository.dao.impl;

import static com.ricardococati.repository.util.BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import com.ricardococati.model.entities.Candlestick;
import com.ricardococati.model.entities.CandlestickDiario;
import com.ricardococati.model.entities.CandlestickSemanal;
import com.ricardococati.model.entities.SplitInplit;
import com.ricardococati.model.enums.OperacaoSplitInplit;
import com.ricardococati.repository.dao.config.BaseJdbcTest;
import com.ricardococati.repository.dao.sqlutil.CandlestickDiarioInserirSQLUtil;
import com.ricardococati.repository.dao.sqlutil.CandlestickSemanalAtualizarSQLUtil;
import com.ricardococati.repository.dao.sqlutil.CandlestickSemanalInserirSQLUtil;
import com.ricardococati.repository.dao.utils.InserirDadosPrimariosSemanalUtil;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CandlestickSemanalAtualizarDAOImplTest extends BaseJdbcTest {

  @InjectMocks
  private CandlestickSemanalAtualizarDAOImpl target;
  @Mock
  private CandlestickSemanalAtualizarSQLUtil sqlUtil;
  @Mock
  private CandlestickSemanalInserirSQLUtil incluirSQLUtil;
  @Mock
  private CandlestickDiarioInserirSQLUtil incluirDiarioSQLUtil;
  @Mock
  private GeraSequenciaDAOImpl genericDAO;
  private LocalDate dtpregini;
  private LocalDate dtpregfim;

  @Before
  public void setUp() throws Exception {
    this.dtpregini = LocalDate.of(1978, 2, 16);
    this.dtpregfim = dtpregini.plusDays(6);
    target = new CandlestickSemanalAtualizarDAOImpl(getNamedParameterJdbcTemplate(), sqlUtil);
    InserirDadosPrimariosSemanalUtil util = new InserirDadosPrimariosSemanalUtil(
        getNamedParameterJdbcTemplate(),
        buildCandlestick(dtpregini, dtpregfim),
        incluirSQLUtil,
        genericDAO,
        incluirDiarioSQLUtil,
        buildCandlestickDiarioDTO(dtpregini)
    );
    util.incluiCandleDiarioAntesDeExecutarTestes();
    util.incluiCandleAntesDeExecutarTestes();
  }

  @Test
  public void atualizaInplit() {
    SplitInplit splitInplit = build(LocalDate.now(), "INPLIT");
    when(sqlUtil.getUpdateSplitInplit(any())).thenCallRealMethod();
    when(sqlUtil.toParametersUpdateSplitInplit(any())).thenCallRealMethod();
    //when
    Boolean retorno = target.atualizaSplitInplit(splitInplit);
    //then
    assertTrue(retorno);
  }

  @Test
  public void atualizaSplit() {
    SplitInplit splitInplit = build(LocalDate.now(), "SPLIT");
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

  private CandlestickSemanal buildCandlestick(
      final LocalDate dtpregini,
      final LocalDate dtpregfim
  ) {
    return CandlestickSemanal
        .builder()
        .dtpregini(dtpregini)
        .dtpregfim(dtpregfim)
        .candlestick(Candlestick
            .builder()
            .preult(getValueBigDecimalHalfUpArredondado4Casas(10.1))
            .codneg("MGLU3")
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