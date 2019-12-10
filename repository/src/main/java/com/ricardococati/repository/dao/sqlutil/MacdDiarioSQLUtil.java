package com.ricardococati.repository.dao.sqlutil;

import com.ricardococati.model.dto.MacdDiario;
import com.ricardococati.repository.util.SQLAppender;
import java.time.LocalDate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class MacdDiarioSQLUtil {

  public String getInsert() {
    SQLAppender sql = new SQLAppender(100);
    sql.appendSQL("	insert into macd_diario( ");
    sql.appendSQL("		id_macd,  ");
    sql.appendSQL("		codneg,  ");
    sql.appendSQL("		dtpreg,  ");
    sql.appendSQL("		premacd ");
    sql.appendSQL("	) values ( ");
    sql.appendSQL("		:idMacd,  ");
    sql.appendSQL("		:codneg,  ");
    sql.appendSQL("		:dtpreg, ");
    sql.appendSQL("		:premacd ");
    sql.appendSQL("	) ");
    sql.appendSQL(" on conflict (codneg, dtpreg) do update set ");
    sql.appendSQL("    codneg = excluded.codneg, ");
    sql.appendSQL("    dtpreg = excluded.dtpreg, ");
    sql.appendSQL("    premacd = excluded.premacd ");
    return sql.getAppendSQLSemQuebra().toString();
  }

  public String getDelete() {
    SQLAppender sql = new SQLAppender(30);
    sql.appendSQL("	delete from macd_diario ");
    return sql.getAppendSQLSemQuebra().toString();
  }

  public MapSqlParameterSource toParameters(final MacdDiario macd) {
    return new MapSqlParameterSource()
        .addValue("idMacd", macd.getIdMacdDiario())
        .addValue("codneg", macd.getMacd().getCodneg())
        .addValue("dtpreg", macd.getDtpreg())
        .addValue("premacd", macd.getMacd().getPremacd());
  }

  public String getSelectByCodNeg() {
    SQLAppender sql = new SQLAppender(100);
    sql.appendSQL("	select ");
    sql.appendSQL("		id_macd, ");
    sql.appendSQL("		codneg, ");
    sql.appendSQL("		dtpreg, ");
    sql.appendSQL("		premacd ");
    sql.appendSQL("	from ");
    sql.appendSQL("		macd_diario ");
    sql.appendSQL("	where ");
    sql.appendSQL("		codneg = :codneg ");
    sql.appendSQL("  order by dtpreg asc");
    return sql.getAppendSQLSemQuebra().toString();
  }

  public MapSqlParameterSource toParametersByCodNeg(final String codneg) {
    return new MapSqlParameterSource()
        .addValue("codneg", codneg);
  }

  public String getSelectByCodNegEDtpregLimite9Periodos() {
    SQLAppender sql = new SQLAppender(100);
    sql.appendSQL("	select ");
    sql.appendSQL("		id_macd, ");
    sql.appendSQL("		codneg, ");
    sql.appendSQL("		dtpreg, ");
    sql.appendSQL("		premacd ");
    sql.appendSQL("	from ");
    sql.appendSQL("		macd_diario ");
    sql.appendSQL("	where ");
    sql.appendSQL("		codneg = :codneg ");
    sql.appendSQL("	  and dtpreg <= :dtpregini ");
    sql.appendSQL("  order by dtpreg asc");
    sql.appendSQL("	 limit 9 ");
    return sql.getAppendSQLSemQuebra().toString();
  }

  public MapSqlParameterSource toParametersByCodNegDtpregLimite9Periodos(
      final String codneg,
      final LocalDate dtpregIni
  ) {
    return new MapSqlParameterSource()
        .addValue("codneg", codneg)
        .addValue("dtpregini", dtpregIni);
  }

}
