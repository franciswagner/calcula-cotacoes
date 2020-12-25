package com.ricardococati.calculacotacoes.adapters.repositories.mediaexponencial.sqlutil;

import com.ricardococati.calculacotacoes.adapters.repositories.utils.SQLAppender;
import com.ricardococati.calculacotacoes.entities.domains.mediaexponencial.MediaMovelExponencialDiario;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class MediaMovelExponencialDiarioSQLUtil {

  public String getInsert() {
    SQLAppender sql = new SQLAppender(100);
    sql.appendSQL("	insert into media_movel_exponencial_diario( ");
    sql.appendSQL("		id_media_movel_exponencial,  ");
    sql.appendSQL("		codneg,  ");
    sql.appendSQL("		dtpreg,  ");
    sql.appendSQL("		premedult,  ");
    sql.appendSQL("		periodo ");
    sql.appendSQL("	) values ( ");
    sql.appendSQL("		:idMediaMovelexponencial,  ");
    sql.appendSQL("		:codneg,  ");
    sql.appendSQL("		:dtpreg, ");
    sql.appendSQL("		:premedult,  ");
    sql.appendSQL("		:periodo ");
    sql.appendSQL("	) ");
    sql.appendSQL(" on conflict (codneg, dtpreg, periodo) do update set ");
    sql.appendSQL("    codneg = excluded.codneg, ");
    sql.appendSQL("    dtpreg = excluded.dtpreg, ");
    sql.appendSQL("    premedult = excluded.premedult, ");
    sql.appendSQL("    periodo = excluded.periodo ");
    return sql.getAppendSQLSemQuebra().toString();
  }

  public MapSqlParameterSource toParameters(final MediaMovelExponencialDiario mediaMovelExponencial) {
    return new MapSqlParameterSource()
        .addValue("idMediaMovelexponencial", mediaMovelExponencial.getIdMediaMovelExponencialDiario())
        .addValue("codneg", mediaMovelExponencial.getMediaMovelExponencial().getCodneg())
        .addValue("dtpreg", mediaMovelExponencial.getDtpreg())
        .addValue("premedult", mediaMovelExponencial.getMediaMovelExponencial().getPremedult())
        .addValue("periodo", mediaMovelExponencial.getMediaMovelExponencial().getPeriodo());
  }

  public String getSelectByCodNegEPeriodo() {
    SQLAppender sql = new SQLAppender(100);
    sql.appendSQL("	select ");
    sql.appendSQL("		id_media_movel_exponencial, ");
    sql.appendSQL("		codneg, ");
    sql.appendSQL("		dtpreg, ");
    sql.appendSQL("		premedult, ");
    sql.appendSQL("		periodo ");
    sql.appendSQL("	from ");
    sql.appendSQL("		media_movel_exponencial_diario ");
    sql.appendSQL("	where ");
    sql.appendSQL("		codneg = :codneg ");
    sql.appendSQL("		and periodo = :periodo ");
    sql.appendSQL("  order by dtpreg asc");
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
    sql.appendSQL("		dtpreg, ");
    sql.appendSQL("		premedult, ");
    sql.appendSQL("		periodo ");
    sql.appendSQL("	from ");
    sql.appendSQL("		media_movel_exponencial_diario ");
    sql.appendSQL("	where ");
    sql.appendSQL("  order by codneg, dtpreg asc");
    return sql.getAppendSQLSemQuebra().toString();
  }

}
