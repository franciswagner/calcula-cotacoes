package com.ricardococati.calculacotacoes.adapters.repositories.candlestick.sqlutil;

import com.ricardococati.calculacotacoes.adapters.repositories.utils.SQLAppender;
import java.time.LocalDate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class CandlestickSemanalBuscarSQLUtil {

  public String getSelectByCodNeg() {
    SQLAppender sql = new SQLAppender(100);
    sql.appendSQL(" select ");
    sql.appendSQL("		id_candle_semanal, ");
    sql.appendSQL("		codneg, ");
    sql.appendSQL("		dtpregini, ");
    sql.appendSQL("		dtpregfim, ");
    sql.appendSQL("		preabe, ");
    sql.appendSQL("		premax, ");
    sql.appendSQL("		premin, ");
    sql.appendSQL("		preult, ");
    sql.appendSQL("		semana, ");
    sql.appendSQL("		voltot ");
    sql.appendSQL(" from candlestick_semanal ");
    sql.appendSQL("	where codneg = :codneg ");
    sql.appendSQL("	order by dtpregini asc ");
    return sql.getAppendSQLSemQuebra().toString();
  }

  public MapSqlParameterSource toParametersCodNeg(final String codneg) {
    return new MapSqlParameterSource()
        .addValue("codneg", codneg);
  }

  public String getSelectCodNegByDtPreg() {
    final SQLAppender sql = new SQLAppender(100);
    sql.appendSQL(" select ");
    sql.appendSQL("   codneg  ");
    sql.appendSQL(" from candlestick_semanal ");
    sql.appendSQL(" where dtpregini > :dtpregini ");
    sql.appendSQL(" group by codneg ");
    sql.appendSQL(" order by codneg asc ");
    return sql.getAppendSQLSemQuebra().toString();
  }

  public MapSqlParameterSource toParametersDtPreg(final LocalDate dtpreg) {
    return new MapSqlParameterSource()
        .addValue("dtpregini", dtpreg);
  }

}
