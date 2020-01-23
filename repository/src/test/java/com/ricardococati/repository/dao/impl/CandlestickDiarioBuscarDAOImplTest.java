package com.ricardococati.repository.dao.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import com.ricardococati.model.dto.CandlestickDTO;
import com.ricardococati.model.dto.CandlestickDiarioDTO;
import com.ricardococati.repository.dao.BaseJdbcTest;
import com.ricardococati.repository.dao.mapper.BuscarCandlestickDiarioMapper;
import com.ricardococati.repository.dao.sqlutil.CandlestickDiarioBuscarSQLUtil;
import com.ricardococati.repository.dao.sqlutil.CandlestickDiarioInserirSQLUtil;
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
public class CandlestickDiarioBuscarDAOImplTest extends BaseJdbcTest {

  @InjectMocks
  private CandlestickDiarioBuscarDAOImpl target;
  @Mock
  private BuscarCandlestickDiarioMapper mapper;
  @Mock
  private CandlestickDiarioBuscarSQLUtil sqlUtil;
  @Mock
  private CandlestickDiarioInserirSQLUtil incluirSQLUtil;
  @Mock
  private GenericDAOImpl genericDAO;
  private LocalDate dtpreg;

  @Before
  public void setUp() {
    this.dtpreg = LocalDate.now();
    target = new CandlestickDiarioBuscarDAOImpl(getNamedParameterJdbcTemplate(), sqlUtil, mapper);
    incluiCandleAntesDeExecutarTestes();
  }

  private void incluiCandleAntesDeExecutarTestes() {
    CandlestickDiarioInserirDAOImpl incluirDAO = new CandlestickDiarioInserirDAOImpl(
        getNamedParameterJdbcTemplate(), genericDAO, incluirSQLUtil);
    when(incluirSQLUtil.getInsert()).thenCallRealMethod();
    when(incluirSQLUtil.toParameters(any())).thenCallRealMethod();
    when(genericDAO.getSequence(any())).thenReturn(1);
    incluirDAO.insereCandlestickDiario(
        buildCandlestickDiarioDTO("MGLU3", 10.1, dtpreg)
    );
  }

  @Test
  public void buscaCandleDiarioPorCodNeg() {
    //given
    String codneg = "MGLU3";
    when(sqlUtil.getSelectByCodNeg()).thenCallRealMethod();
    when(sqlUtil.toParametersCodNeg(any())).thenCallRealMethod();
    when(mapper.mapper(any())).thenCallRealMethod();
    //when
    List<CandlestickDiarioDTO> result = target.buscaCandleDiarioPorCodNeg(codneg);
    //then
    assertTrue(!result.isEmpty());
    assertThat(result).isNotNull().size().isEqualTo(1);
    assertThat(result.get(0).getCandlestickDTO().getCodneg()).isNotNull().isEqualTo("MGLU3");
    assertThat(result.get(0).getCandlestickDTO().getPreult()).isNotNull().isEqualTo(new BigDecimal("10.10"));
  }

  @Test
  public void buscaCandleDiarioPorDtPreg() {
    //given
    LocalDate dtpregLocal = LocalDate.now().minusDays(1);
    when(sqlUtil.getSelectCodNegByDtPreg()).thenCallRealMethod();
    when(sqlUtil.toParametersDtPreg(any())).thenCallRealMethod();
    when(mapper.mapperCodNeg(any())).thenCallRealMethod();
    //when
    List<String> result = target.buscaCandleDiarioPorDtPreg(dtpregLocal);
    //then
    assertTrue(!result.isEmpty());
    assertThat(result).isNotNull().size().isEqualTo(1);
    assertThat(result.get(0)).isNotNull().isEqualTo("MGLU3");
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
