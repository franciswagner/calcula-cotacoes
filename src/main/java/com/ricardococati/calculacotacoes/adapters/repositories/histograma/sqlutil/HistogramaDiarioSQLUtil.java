package com.ricardococati.calculacotacoes.adapters.repositories.histograma.sqlutil;

import com.ricardococati.calculacotacoes.adapters.repositories.utils.SQLAppender;
import com.ricardococati.calculacotacoes.entities.domains.histograma.HistogramaDiario;
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

  public MapSqlParameterSource toParameters(final HistogramaDiario macd) {
    return new MapSqlParameterSource()
        .addValue("idHistograma", macd.getIdHistogramaDiario())
        .addValue("codneg", macd.getHistograma().getCodneg())
        .addValue("dtpreg", macd.getDtpreg())
        .addValue("prehist", macd.getHistograma().getPrehist());
  }

}
