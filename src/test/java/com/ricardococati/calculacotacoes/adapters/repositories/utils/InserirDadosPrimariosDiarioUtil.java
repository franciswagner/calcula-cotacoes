package com.ricardococati.calculacotacoes.adapters.repositories.utils;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import com.ricardococati.calculacotacoes.adapters.repositories.candlestick.impl.CandlestickDiarioInserirDAOImpl;
import com.ricardococati.calculacotacoes.adapters.repositories.candlestick.sqlutil.CandlestickDiarioInserirSQLUtil;
import com.ricardococati.calculacotacoes.adapters.repositories.gerasequencia.impl.GeraSequenciaDAOImpl;
import com.ricardococati.calculacotacoes.entities.domains.candlestick.CandlestickDiario;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

@RequiredArgsConstructor
public class InserirDadosPrimariosDiarioUtil {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final CandlestickDiario candlestickDiario;
    private final CandlestickDiarioInserirSQLUtil candlestickSQLUtil;
    private final GeraSequenciaDAOImpl genericDAO;

    public void incluiCandleAntesDeExecutarTestes() throws Exception {
        CandlestickDiarioInserirDAOImpl incluirDAO =
                new CandlestickDiarioInserirDAOImpl(
                namedParameterJdbcTemplate, genericDAO, candlestickSQLUtil);
        when(candlestickSQLUtil.getInsert()).thenCallRealMethod();
        when(candlestickSQLUtil.toParameters(any())).thenCallRealMethod();
        when(genericDAO.getSequence(any())).thenReturn(1);
        incluirDAO.insereCandlestickDiario(candlestickDiario);
    }

}
