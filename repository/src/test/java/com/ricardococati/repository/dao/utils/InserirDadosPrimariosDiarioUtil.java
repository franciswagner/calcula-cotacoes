package com.ricardococati.repository.dao.utils;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import com.ricardococati.model.entities.CandlestickDiario;
import com.ricardococati.repository.dao.impl.CandlestickDiarioInserirDAOImpl;
import com.ricardococati.repository.dao.impl.GeraSequenciaDAOImpl;
import com.ricardococati.repository.dao.sqlutil.CandlestickDiarioInserirSQLUtil;
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
