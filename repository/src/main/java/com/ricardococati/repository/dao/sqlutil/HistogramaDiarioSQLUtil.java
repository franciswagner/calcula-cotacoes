package com.ricardococati.repository.dao.sqlutil;

import com.ricardococati.model.dto.HistogramaDiario;
import com.ricardococati.repository.util.SQLAppender;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class HistogramaDiarioSQLUtil {

  public String getInsert() {
    SQLAppender sql = new SQLAppender(100);
    sql.appendSQL("	insert into histograma_diario( ");
    sql.appendSQL("		id_histograma,  ");
    sql.appendSQL("		codneg,  ");
    sql.appendSQL("		dtpreg,  ");
    sql.appendSQL("		prehist ");
    sql.appendSQL("	) values ( ");
    sql.appendSQL("		:idHistograma,  ");
    sql.appendSQL("		:codneg,  ");
    sql.appendSQL("		:dtpreg, ");
    sql.appendSQL("		:prehist ");
    sql.appendSQL("	) ");
    sql.appendSQL(" on conflict (codneg, dtpreg) do update set ");
    sql.appendSQL("    codneg = excluded.codneg, ");
    sql.appendSQL("    dtpreg = excluded.dtpreg, ");
    sql.appendSQL("    prehist = excluded.prehist ");
    return sql.getAppendSQLSemQuebra().toString();
  }

  public String getDelete() {
    SQLAppender sql = new SQLAppender(30);
    sql.appendSQL("	delete from histograma_diario ");
    return sql.getAppendSQLSemQuebra().toString();
  }

  public MapSqlParameterSource toParameters(final HistogramaDiario macd) {
    return new MapSqlParameterSource()
        .addValue("idHistograma", macd.getIdHistogramaDiario())
        .addValue("codneg", macd.getHistograma().getCodneg())
        .addValue("dtpreg", macd.getDtpreg())
        .addValue("prehist", macd.getHistograma().getPrehist());
  }

  public String getSelectByCodNeg() {
    SQLAppender sql = new SQLAppender(100);
    sql.appendSQL("	select ");
    sql.appendSQL("		id_histograma, ");
    sql.appendSQL("		codneg, ");
    sql.appendSQL("		dtpreg, ");
    sql.appendSQL("		prehist ");
    sql.appendSQL("	from ");
    sql.appendSQL("		histograma_diario ");
    sql.appendSQL("	where ");
    sql.appendSQL("		codneg = :codneg ");
    sql.appendSQL("  order by dtpreg asc");
    return sql.getAppendSQLSemQuebra().toString();
  }

  public MapSqlParameterSource toParametersByCodNeg(final String codneg) {
    return new MapSqlParameterSource()
        .addValue("codneg", codneg);
  }

}
