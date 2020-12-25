package com.ricardococati.calculacotacoes.adapters.repositories.candlestick.sqlutil;

import com.ricardococati.calculacotacoes.adapters.repositories.utils.SQLAppender;
import com.ricardococati.calculacotacoes.entities.domains.candlestick.CandlestickSemanal;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class CandlestickSemanalInserirSQLUtil {

  public String getInsert() {
    SQLAppender sql = new SQLAppender(100);
    sql.appendSQL("	insert into candlestick_semanal ( ");
    sql.appendSQL("		id_candle_semanal, ");
    sql.appendSQL("		codneg, ");
    sql.appendSQL("		dtpregini, ");
    sql.appendSQL("		dtpregfim, ");
    sql.appendSQL("		preabe, ");
    sql.appendSQL("		premax, ");
    sql.appendSQL("		premin, ");
    sql.appendSQL("		preult, ");
    sql.appendSQL("		semana, ");
    sql.appendSQL("		voltot) ");
    sql.appendSQL("	values( ");
    sql.appendSQL("		:idCandleSemanal, ");
    sql.appendSQL("		:codneg, ");
    sql.appendSQL("		:dtpregini, ");
    sql.appendSQL("		:dtpregfim, ");
    sql.appendSQL("		:preabe, ");
    sql.appendSQL("		:premax, ");
    sql.appendSQL("		:premin, ");
    sql.appendSQL("		:preult, ");
    sql.appendSQL("		:semana, ");
    sql.appendSQL("		:voltot ");
    sql.appendSQL("   ) ");
    sql.appendSQL(" on conflict (codneg, dtpregini) do update set ");
    sql.appendSQL("		codneg = excluded.codneg, ");
    sql.appendSQL("		dtpregini = excluded.dtpregini, ");
    sql.appendSQL("		dtpregfim = excluded.dtpregfim, ");
    sql.appendSQL("		preabe = excluded.preabe, ");
    sql.appendSQL("		premax = excluded.premax, ");
    sql.appendSQL("		premin = excluded.premin, ");
    sql.appendSQL("		preult = excluded.preult, ");
    sql.appendSQL("		semana = excluded.semana, ");
    sql.appendSQL("		voltot = excluded.voltot ");
    return sql.getAppendSQLSemQuebra().toString();
  }

  public MapSqlParameterSource toParameters(final CandlestickSemanal candlestickSemanal) {
    return new MapSqlParameterSource()
        .addValue("idCandleSemanal", candlestickSemanal.getIdCandleSemanal())
        .addValue("codneg", candlestickSemanal.getCandlestick().getCodneg())
        .addValue("dtpregini", candlestickSemanal.getDtpregini())
        .addValue("dtpregfim", candlestickSemanal.getDtpregfim())
        .addValue("preabe", candlestickSemanal.getCandlestick().getPreabe())
        .addValue("premax", candlestickSemanal.getCandlestick().getPremax())
        .addValue("premin", candlestickSemanal.getCandlestick().getPremin())
        .addValue("preult", candlestickSemanal.getCandlestick().getPreult())
        .addValue("semana", candlestickSemanal.getCandlestick().getSemana())
        .addValue("voltot", candlestickSemanal.getCandlestick().getVoltot());
  }

}
