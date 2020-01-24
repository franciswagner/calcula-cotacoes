package com.ricardococati.repository.dao.sqlutil;

import com.ricardococati.model.dto.SinalMacdDiario;
import com.ricardococati.repository.util.SQLAppender;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class SinalMacdDiarioSQLUtil {

  public String getInsert() {
    SQLAppender sql = new SQLAppender(100);
    sql.appendSQL("	insert into sinal_macd_diario( ");
    sql.appendSQL("		id_sinal_macd,  ");
    sql.appendSQL("		codneg,  ");
    sql.appendSQL("		dtpreg,  ");
    sql.appendSQL("		presinal ");
    sql.appendSQL("	) values ( ");
    sql.appendSQL("		:idSinalMacd,  ");
    sql.appendSQL("		:codneg,  ");
    sql.appendSQL("		:dtpreg, ");
    sql.appendSQL("		:presinal ");
    sql.appendSQL("	) ");
    sql.appendSQL(" on conflict (codneg, dtpreg) do update set ");
    sql.appendSQL("    codneg = excluded.codneg, ");
    sql.appendSQL("    dtpreg = excluded.dtpreg, ");
    sql.appendSQL("    presinal = excluded.presinal ");
    return sql.getAppendSQLSemQuebra().toString();
  }

  public MapSqlParameterSource toParameters(final SinalMacdDiario macd) {
    return new MapSqlParameterSource()
        .addValue("idSinalMacd", macd.getIdSinalMacdDiario())
        .addValue("codneg", macd.getSinalMacd().getCodneg())
        .addValue("dtpreg", macd.getDtpreg())
        .addValue("presinal", macd.getSinalMacd().getPresinal());
  }

  public String getSelectByCodNeg() {
    SQLAppender sql = new SQLAppender(100);
    sql.appendSQL("	select ");
    sql.appendSQL("		id_sinal_macd, ");
    sql.appendSQL("		codneg, ");
    sql.appendSQL("		dtpreg, ");
    sql.appendSQL("		presinal ");
    sql.appendSQL("	from ");
    sql.appendSQL("		sinal_macd_diario ");
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
