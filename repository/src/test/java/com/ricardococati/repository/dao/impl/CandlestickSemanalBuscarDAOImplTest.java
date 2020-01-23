package com.ricardococati.repository.dao.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import com.ricardococati.model.dto.CandlestickDTO;
import com.ricardococati.model.dto.CandlestickDiarioDTO;
import com.ricardococati.model.dto.CandlestickSemanalDTO;
import com.ricardococati.repository.dao.BaseJdbcTest;
import com.ricardococati.repository.dao.mapper.BuscarCandlestickSemanalMapper;
import com.ricardococati.repository.dao.sqlutil.CandlestickSemanalBuscarSQLUtil;
import com.ricardococati.repository.dao.sqlutil.CandlestickSemanalInserirSQLUtil;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CandlestickSemanalBuscarDAOImplTest extends BaseJdbcTest {

  @InjectMocks
  private CandlestickSemanalBuscarDAOImpl target;
  @Mock
  private CandlestickSemanalBuscarSQLUtil sqlUtil;
  @Mock
  private BuscarCandlestickSemanalMapper mapper;
  @Mock
  private CandlestickSemanalInserirSQLUtil incluirSQLUtil;
  @Mock
  private GenericDAOImpl genericDAO;
  private LocalDate dtpregini;
  private LocalDate dtpregfim;

  @Before
  public void setUp() {
    this.dtpregini = LocalDate.of(1978, 2, 16);
    this.dtpregfim = dtpregini.plusDays(6);
    target = new CandlestickSemanalBuscarDAOImpl(getNamedParameterJdbcTemplate(), sqlUtil, mapper);
    incluiCandleAntesDeExecutarTestes();
  }

  private void incluiCandleAntesDeExecutarTestes() {
    CandlestickSemanalInserirDAOImpl incluirDAO = new CandlestickSemanalInserirDAOImpl(
        getNamedParameterJdbcTemplate(), genericDAO, incluirSQLUtil);
    when(incluirSQLUtil.getInsert()).thenCallRealMethod();
    when(incluirSQLUtil.toParameters(any())).thenCallRealMethod();
    when(genericDAO.getSequence(any())).thenReturn(1);
    incluirDAO.incluirCandlestickSemanal(
        buildCandlestick(dtpregini, dtpregfim)
    );
  }

  @Test
  public void buscaCandleSemanalPorCodNeg() {
    //given
    String codneg = "MGLU3";
    when(sqlUtil.getSelectByCodNeg()).thenCallRealMethod();
    when(sqlUtil.toParametersCodNeg(any())).thenCallRealMethod();
    when(mapper.mapper(any())).thenCallRealMethod();
    //when
    List<CandlestickSemanalDTO> result = target.buscaCandleSemanalPorCodNeg(codneg);
    //then
    assertTrue(!result.isEmpty());
    assertThat(result).isNotNull().size().isEqualTo(1);
    assertThat(result.get(0).getCandlestickDTO().getCodneg()).isNotNull().isEqualTo("MGLU3");
    assertThat(result.get(0).getCandlestickDTO().getPreult()).isNotNull().isEqualTo(new BigDecimal("10.10"));
  }

  @Test
  public void buscaCandleSemanalPorDtPreg() {
    //given
    LocalDate dtpregLocal = dtpregini.minusDays(1);
    when(sqlUtil.getSelectCodNegByDtPreg()).thenCallRealMethod();
    when(sqlUtil.toParametersDtPreg(any())).thenCallRealMethod();
    when(mapper.mapperCodNeg(any())).thenCallRealMethod();
    //when
    List<String> result = target.buscaCandleSemanalPorDtPreg(dtpregLocal);
    //then
    assertTrue(!result.isEmpty());
    assertThat(result).isNotNull().size().isEqualTo(1);
    assertThat(result.get(0)).isNotNull().isEqualTo("MGLU3");
  }

  private CandlestickSemanalDTO buildCandlestick(
      final LocalDate dtpregini,
      final LocalDate dtpregfim
  ) {
    return CandlestickSemanalDTO
        .builder()
        .dtpregini(dtpregini)
        .dtpregfim(dtpregfim)
        .candlestickDTO(CandlestickDTO
            .builder()
            .preult(new BigDecimal(10.1).setScale(4, BigDecimal.ROUND_HALF_UP))
            .codneg("MGLU3")
            .build()
        ).build();
  }

}