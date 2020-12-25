package com.ricardococati.calculacotacoes.adapters.repositories.mediaexponencial.sqlutil;

import com.ricardococati.calculacotacoes.adapters.repositories.utils.SQLAppender;
import com.ricardococati.calculacotacoes.entities.domains.mediaexponencial.MediaMovelExponencialSemanal;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class MediaMovelExponencialSemanalSQLUtil {

  public String getInsert() {
    SQLAppender sql = new SQLAppender(100);
    sql.appendSQL("	insert into media_movel_exponencial_semanal( ");
    sql.appendSQL("		id_media_movel_exponencial,  ");
    sql.appendSQL("		codneg,  ");
    sql.appendSQL("		dtpregini,  ");
    sql.appendSQL("		dtpregfim,  ");
    sql.appendSQL("		premedult,  ");
    sql.appendSQL("		periodo ");
    sql.appendSQL("	) values ( ");
    sql.appendSQL("		:idMediaMovelexponencial,  ");
    sql.appendSQL("		:codneg,  ");
    sql.appendSQL("		:dtpregini, ");
    sql.appendSQL("		:dtpregfim, ");
    sql.appendSQL("		:premedult,  ");
    sql.appendSQL("		:periodo ");
    sql.appendSQL("	) ");
    sql.appendSQL(" on conflict (codneg, dtpregini, periodo) do update set ");
    sql.appendSQL("		codneg = excluded.codneg, ");
    sql.appendSQL("		dtpregini = excluded.dtpregini, ");
    sql.appendSQL("		dtpregfim = excluded.dtpregfim, ");
    sql.appendSQL("		premedult = excluded.premedult, ");
    sql.appendSQL("		periodo = excluded.periodo ");
    return sql.getAppendSQLSemQuebra().toString();
  }

  public MapSqlParameterSource toParameters(final MediaMovelExponencialSemanal mediaMovelExponencial) {
    return new MapSqlParameterSource()
        .addValue("idMediaMovelexponencial", mediaMovelExponencial.getIdMediaMovelExponencialSemanal())
        .addValue("codneg", mediaMovelExponencial.getMediaMovelExponencial().getCodneg())
        .addValue("dtpregini", mediaMovelExponencial.getDtpregini())
        .addValue("dtpregfim", mediaMovelExponencial.getDtpregfim())
        .addValue("premedult", mediaMovelExponencial.getMediaMovelExponencial().getPremedult())
        .addValue("periodo", mediaMovelExponencial.getMediaMovelExponencial().getPeriodo());
  }

  public String getSelectByCodNegEPeriodo() {
    SQLAppender sql = new SQLAppender(100);
    sql.appendSQL("	select ");
    sql.appendSQL("		id_media_movel_exponencial, ");
    sql.appendSQL("		codneg, ");
    sql.appendSQL("		dtpregini, ");
    sql.appendSQL("		dtpregfim, ");
    sql.appendSQL("		premedult, ");
    sql.appendSQL("		periodo ");
    sql.appendSQL("	from ");
    sql.appendSQL("		media_movel_exponencial_semanal ");
    sql.appendSQL("	where ");
    sql.appendSQL("		codneg = :codneg ");
    sql.appendSQL("		and periodo = :periodo ");
    sql.appendSQL("  order by dtpregini asc");
    return sql.getAppendSQLSemQuebra().toString();
  }

  public MapSqlParameterSource toParametersByCodNegEPeriodo(final String codneg, final Integer periodo) {
    return new MapSqlParameterSource()
        .addValue("codneg", codneg)
        .addValue("periodo", periodo);
  }

  public String getSelect() {
    SQLAppender sql = new SQLAppender(100);
    sql.appendSQL("	select ");
    sql.appendSQL("		id_media_movel_exponencial, ");
    sql.appendSQL("		codneg, ");
    sql.appendSQL("		dtpregini, ");
    sql.appendSQL("		dtpregfim, ");
    sql.appendSQL("		premedult, ");
    sql.appendSQL("		periodo ");
    sql.appendSQL("	from ");
    sql.appendSQL("		media_movel_exponencial_semanal ");
    sql.appendSQL("	where ");
    sql.appendSQL("  order by codneg, dtpregini asc");
    return sql.getAppendSQLSemQuebra().toString();
  }

}
