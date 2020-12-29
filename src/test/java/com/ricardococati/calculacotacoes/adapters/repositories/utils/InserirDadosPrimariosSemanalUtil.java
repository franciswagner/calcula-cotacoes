package com.ricardococati.calculacotacoes.adapters.repositories.utils;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import com.ricardococati.calculacotacoes.adapters.repositories.candlestick.impl.CandlestickDiarioInserirDAOImpl;
import com.ricardococati.calculacotacoes.adapters.repositories.candlestick.impl.CandlestickSemanalInserirDAOImpl;
import com.ricardococati.calculacotacoes.adapters.repositories.candlestick.sqlutil.CandlestickDiarioInserirSQLUtil;
import com.ricardococati.calculacotacoes.adapters.repositories.candlestick.sqlutil.CandlestickSemanalInserirSQLUtil;
import com.ricardococati.calculacotacoes.adapters.repositories.gerasequencia.impl.GeraSequenciaDAOImpl;
import com.ricardococati.calculacotacoes.entities.domains.candlestick.CandlestickDiario;
import com.ricardococati.calculacotacoes.entities.domains.candlestick.CandlestickSemanal;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@RequiredArgsConstructor
public class InserirDadosPrimariosSemanalUtil {

  private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
  private final CandlestickSemanal candlestickSemanal;
  private final CandlestickSemanalInserirSQLUtil candlestickSQLUtil;
  private final GeraSequenciaDAOImpl genericDAO;
  private final CandlestickDiarioInserirSQLUtil incluirDiarioSQLUtil;
  private final CandlestickDiario candlestickDiario;

  public void incluiCandleAntesDeExecutarTestes() throws Exception {
    CandlestickSemanalInserirDAOImpl incluirDAO =
        new CandlestickSemanalInserirDAOImpl(
            namedParameterJdbcTemplate, genericDAO, candlestickSQLUtil);
    when(candlestickSQLUtil.getInsert()).thenCallRealMethod();
    when(candlestickSQLUtil.toParameters(any())).thenCallRealMethod();
    when(genericDAO.getSequence(any())).thenReturn(1);
    incluirDAO.incluirCandlestickSemanal(candlestickSemanal);
  }

  public void incluiCandleDiarioAntesDeExecutarTestes() throws Exception {
    CandlestickDiarioInserirDAOImpl incluirDAO =
        new CandlestickDiarioInserirDAOImpl(
            namedParameterJdbcTemplate, genericDAO, incluirDiarioSQLUtil);
    when(incluirDiarioSQLUtil.getInsert()).thenCallRealMethod();
    when(incluirDiarioSQLUtil.toParameters(any())).thenCallRealMethod();
    when(genericDAO.getSequence(any())).thenReturn(1);
    incluirDAO.insereCandlestickDiario(candlestickDiario);
  }

}
