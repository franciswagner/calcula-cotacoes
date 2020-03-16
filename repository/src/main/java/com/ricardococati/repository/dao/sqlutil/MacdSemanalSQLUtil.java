package com.ricardococati.repository.dao.sqlutil;

import com.ricardococati.model.dto.MacdSemanal;
import com.ricardococati.repository.util.SQLAppender;
import java.time.LocalDate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class MacdSemanalSQLUtil {

  public String getInsert() {
    SQLAppender sql = new SQLAppender(100);
    sql.appendSQL("	insert into macd_semanal( ");
    sql.appendSQL("		id_macd,  ");
    sql.appendSQL("		codneg,  ");
    sql.appendSQL("		dtpregini,  ");
    sql.appendSQL("		dtpregfim,  ");
    sql.appendSQL("		premacd ");
    sql.appendSQL("	) values ( ");
    sql.appendSQL("		:idMacd,  ");
    sql.appendSQL("		:codneg,  ");
    sql.appendSQL("		:dtpregini, ");
    sql.appendSQL("		:dtpregfim, ");
    sql.appendSQL("		:premacd ");
    sql.appendSQL("	) ");
    sql.appendSQL(" on conflict (codneg, dtpregini) do update set ");
    sql.appendSQL("		codneg = excluded.codneg, ");
    sql.appendSQL("		dtpregini = excluded.dtpregini, ");
    sql.appendSQL("		dtpregfim = excluded.dtpregfim, ");
    sql.appendSQL("		premacd = excluded.premacd ");
    return sql.getAppendSQLSemQuebra().toString();
  }

  public MapSqlParameterSource toParameters(final MacdSemanal macd) {
    return new MapSqlParameterSource()
        .addValue("idMacd", macd.getIdMacdSemanal())
        .addValue("codneg", macd.getMacd().getCodneg())
        .addValue("dtpregini", macd.getDtpregini())
        .addValue("dtpregfim", macd.getDtpregfim())
        .addValue("premacd", macd.getMacd().getPremacd());
  }

  public String getSelectByCodNeg() {
    SQLAppender sql = new SQLAppender(100);
    sql.appendSQL("	select ");
    sql.appendSQL("		id_macd, ");
    sql.appendSQL("		codneg, ");
    sql.appendSQL("		dtpregini,  ");
    sql.appendSQL("		dtpregfim,  ");
    sql.appendSQL("		premacd ");
    sql.appendSQL("	from ");
    sql.appendSQL("		macd_semanal ");
    sql.appendSQL("	where ");
    sql.appendSQL("		codneg = :codneg ");
    sql.appendSQL("  order by dtpregini asc");
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
    sql.appendSQL("		dtpregini,  ");
    sql.appendSQL("		dtpregfim,  ");
    sql.appendSQL("		premacd ");
    sql.appendSQL("	from ");
    sql.appendSQL("		macd_semanal ");
    sql.appendSQL("	where ");
    sql.appendSQL("		codneg = :codneg ");
    sql.appendSQL("	  and dtpregini <= :dtpregini ");
    sql.appendSQL("  order by dtpregini asc");
    sql.appendSQL("	 limit 9 ");
    return sql.getAppendSQLSemQuebra().toString();
  }

  public MapSqlParameterSource toParametersByCodNegDtpregLimite9Periodos(
      final String codneg,
      final LocalDate dtpregini
  ) {
    return new MapSqlParameterSource()
        .addValue("codneg", codneg)
        .addValue("dtpregini", dtpregini);
  }

}
