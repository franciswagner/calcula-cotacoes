package com.ricardococati.repository.dao.sqlutil;

import com.ricardococati.model.dto.HistogramaSemanal;
import com.ricardococati.repository.util.SQLAppender;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class HistogramaSemanalSQLUtil {

  public String getInsert() {
    SQLAppender sql = new SQLAppender(100);
    sql.appendSQL("	insert into histograma_semanal( ");
    sql.appendSQL("		id_histograma,  ");
    sql.appendSQL("		codneg,  ");
    sql.appendSQL("		dtpregini,  ");
    sql.appendSQL("		dtpregfim,  ");
    sql.appendSQL("		prehist ");
    sql.appendSQL("	) values ( ");
    sql.appendSQL("		:idHistograma,  ");
    sql.appendSQL("		:codneg,  ");
    sql.appendSQL("		:dtpregini, ");
    sql.appendSQL("		:dtpregfim, ");
    sql.appendSQL("		:prehist ");
    sql.appendSQL("	) ");
    sql.appendSQL(" on conflict (codneg, dtpregini) do update set ");
    sql.appendSQL("		codneg = excluded.codneg, ");
    sql.appendSQL("		dtpregini = excluded.dtpregini, ");
    sql.appendSQL("		dtpregfim = excluded.dtpregfim, ");
    sql.appendSQL("		prehist = excluded.prehist ");
    return sql.getAppendSQLSemQuebra().toString();
  }

  public MapSqlParameterSource toParameters(final HistogramaSemanal macd) {
    return new MapSqlParameterSource()
        .addValue("idHistograma", macd.getIdHistogramaSemanal())
        .addValue("codneg", macd.getHistograma().getCodneg())
        .addValue("dtpregini", macd.getDtpregini())
        .addValue("dtpregfim", macd.getDtpregfim())
        .addValue("prehist", macd.getHistograma().getPrehist());
  }

  public String getSelectByCodNeg() {
    SQLAppender sql = new SQLAppender(100);
    sql.appendSQL("	select ");
    sql.appendSQL("		id_histograma, ");
    sql.appendSQL("		codneg, ");
    sql.appendSQL("		dtpregini, ");
    sql.appendSQL("		dtpregfim, ");
    sql.appendSQL("		prehist ");
    sql.appendSQL("	from ");
    sql.appendSQL("		histograma_semanal ");
    sql.appendSQL("	where ");
    sql.appendSQL("		codneg = :codneg ");
    sql.appendSQL("  order by dtpregini asc");
    return sql.getAppendSQLSemQuebra().toString();
  }

  public MapSqlParameterSource toParametersByCodNeg(final String codneg) {
    return new MapSqlParameterSource()
        .addValue("codneg", codneg);
  }

}
