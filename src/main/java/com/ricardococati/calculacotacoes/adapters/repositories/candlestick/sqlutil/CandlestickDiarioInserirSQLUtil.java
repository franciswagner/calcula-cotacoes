package com.ricardococati.calculacotacoes.adapters.repositories.candlestick.sqlutil;

import com.ricardococati.calculacotacoes.utils.sql.SQLAppender;
import com.ricardococati.calculacotacoes.entities.domains.candlestick.CandlestickDiario;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class CandlestickDiarioInserirSQLUtil {

  public String getInsert() {
    SQLAppender sql = new SQLAppender(100);
    sql.appendSQL("	insert into candlestick_diario ( ");
    sql.appendSQL("		id_candle_diario, ");
    sql.appendSQL("		codneg, ");
    sql.appendSQL("		dtpreg, ");
    sql.appendSQL("		preabe, ");
    sql.appendSQL("		premax, ");
    sql.appendSQL("		premin, ");
    sql.appendSQL("		preult, ");
    sql.appendSQL("		semana, ");
    sql.appendSQL("		voltot) ");
    sql.appendSQL("	values( ");
    sql.appendSQL("		:idCandleDiario, ");
    sql.appendSQL("		:codneg, ");
    sql.appendSQL("		:dtpreg, ");
    sql.appendSQL("		:preabe, ");
    sql.appendSQL("		:premax, ");
    sql.appendSQL("		:premin, ");
    sql.appendSQL("		:preult, ");
    sql.appendSQL("		:semana, ");
    sql.appendSQL("		:voltot ");
    sql.appendSQL("   ) ");
    sql.appendSQL(" on conflict (codneg, dtpreg) do update set ");
    sql.appendSQL("		codneg = excluded.codneg, ");
    sql.appendSQL("		dtpreg = excluded.dtpreg, ");
    sql.appendSQL("		preabe = excluded.preabe, ");
    sql.appendSQL("		premax = excluded.premax, ");
    sql.appendSQL("		premin = excluded.premin, ");
    sql.appendSQL("		preult = excluded.preult, ");
    sql.appendSQL("		semana = excluded.semana, ");
    sql.appendSQL("		voltot = excluded.voltot ");

    return sql.getAppendSQLSemQuebra().toString();
  }

  public MapSqlParameterSource toParameters(final CandlestickDiario candlestickDiario) {
    return new MapSqlParameterSource()
        .addValue("idCandleDiario", candlestickDiario.getIdCandleDiario())
        .addValue("codneg", candlestickDiario.getCandlestick().getCodneg())
        .addValue("dtpreg", candlestickDiario.getDtpreg())
        .addValue("preabe", candlestickDiario.getCandlestick().getPreabe())
        .addValue("premax", candlestickDiario.getCandlestick().getPremax())
        .addValue("premin", candlestickDiario.getCandlestick().getPremin())
        .addValue("preult", candlestickDiario.getCandlestick().getPreult())
        .addValue("semana", candlestickDiario.getCandlestick().getSemana())
        .addValue("voltot", candlestickDiario.getCandlestick().getVoltot());
  }

}