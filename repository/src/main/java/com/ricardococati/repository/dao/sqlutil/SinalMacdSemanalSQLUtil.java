package com.ricardococati.repository.dao.sqlutil;

import com.ricardococati.model.dto.SinalMacdSemanal;
import com.ricardococati.repository.util.SQLAppender;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class SinalMacdSemanalSQLUtil {

  public String getInsert() {
    SQLAppender sql = new SQLAppender(100);
    sql.appendSQL("	insert into sinal_macd_semanal( ");
    sql.appendSQL("		id_sinal_macd,  ");
    sql.appendSQL("		codneg,  ");
    sql.appendSQL("		dtpregini,  ");
    sql.appendSQL("		dtpregfim,  ");
    sql.appendSQL("		presinal ");
    sql.appendSQL("	) values ( ");
    sql.appendSQL("		:idSinalMacd,  ");
    sql.appendSQL("		:codneg,  ");
    sql.appendSQL("		:dtpregini, ");
    sql.appendSQL("		:dtpregfim, ");
    sql.appendSQL("		:presinal ");
    sql.appendSQL("	) ");
    sql.appendSQL(" on conflict (codneg, dtpregini) do update set ");
    sql.appendSQL("		codneg = excluded.codneg, ");
    sql.appendSQL("		dtpregini = excluded.dtpregini, ");
    sql.appendSQL("		dtpregfim = excluded.dtpregfim, ");
    sql.appendSQL("		presinal = excluded.presinal ");
    return sql.getAppendSQLSemQuebra().toString();
  }

  public MapSqlParameterSource toParameters(final SinalMacdSemanal macd) {
    return new MapSqlParameterSource()
        .addValue("idSinalMacd", macd.getIdSinalMacdSemanal())
        .addValue("codneg", macd.getSinalMacd().getCodneg())
        .addValue("dtpregini", macd.getDtpregini())
        .addValue("dtpregfim", macd.getDtpregfim())
        .addValue("presinal", macd.getSinalMacd().getPresinal());
  }

  public String getSelectByCodNeg() {
    SQLAppender sql = new SQLAppender(100);
    sql.appendSQL("	select ");
    sql.appendSQL("		id_sinal_macd, ");
    sql.appendSQL("		codneg, ");
    sql.appendSQL("		dtpregini,  ");
    sql.appendSQL("		dtpregfim,  ");
    sql.appendSQL("		presinal ");
    sql.appendSQL("	from ");
    sql.appendSQL("		sinal_macd_semanal ");
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
