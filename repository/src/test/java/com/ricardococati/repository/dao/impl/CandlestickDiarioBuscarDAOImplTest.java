package com.ricardococati.repository.dao.impl;

import static com.ricardococati.repository.util.BigDecimalCustomizado.getValueBigDecimalHalfUpArredondado4Casas;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import com.ricardococati.model.entities.Candlestick;
import com.ricardococati.model.entities.CandlestickDiario;
import com.ricardococati.repository.dao.config.BaseJdbcTest;
import com.ricardococati.repository.dao.mapper.BuscarCandlestickDiarioMapper;
import com.ricardococati.repository.dao.sqlutil.CandlestickDiarioBuscarSQLUtil;
import com.ricardococati.repository.dao.sqlutil.CandlestickDiarioInserirSQLUtil;
import com.ricardococati.repository.dao.utils.InserirDadosPrimariosDiarioUtil;
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
  private GeraSequenciaDAOImpl genericDAO;
  private LocalDate dtpreg;

  @Before
  public void setUp() throws Exception {
    this.dtpreg = LocalDate.now();
    target = new CandlestickDiarioBuscarDAOImpl(getNamedParameterJdbcTemplate(), sqlUtil, mapper);
    InserirDadosPrimariosDiarioUtil util = new InserirDadosPrimariosDiarioUtil(
        getNamedParameterJdbcTemplate(),
        buildCandlestickDiarioDTO("MGLU3", 10.1, dtpreg),
        incluirSQLUtil,
        genericDAO
    );
    util.incluiCandleAntesDeExecutarTestes();
  }

  @Test
  public void buscaCandleDiarioPorCodNeg() {
    //given
    String codneg = "MGLU3";
    when(sqlUtil.getSelectByCodNeg()).thenCallRealMethod();
    when(sqlUtil.toParametersCodNeg(any())).thenCallRealMethod();
    when(mapper.mapper(any())).thenCallRealMethod();
    //when
    List<CandlestickDiario> result = target.buscaCandleDiarioPorCodNeg(codneg);
    //then
    assertTrue(!result.isEmpty());
    assertThat(result).isNotNull().size().isEqualTo(1);
    assertThat(result.get(0).getCandlestick().getCodneg()).isNotNull().isEqualTo("MGLU3");
    assertThat(result.get(0).getCandlestick().getPreult()).isNotNull().isEqualTo(new BigDecimal("10.10"));
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
