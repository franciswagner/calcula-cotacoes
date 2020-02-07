package com.ricardococati.repository.dao.sqlutil;

import com.ricardococati.model.dto.MediaMovelSimplesDiario;
import com.ricardococati.repository.util.SQLAppender;
import java.time.LocalDate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class MediaMovelSimplesDiarioSQLUtil {

  public String getInsert() {
    SQLAppender sql = new SQLAppender(100);
    sql.appendSQL("	INSERT INTO media_movel_simples_diario( ");
    sql.appendSQL("		id_media_movel_simples,  ");
    sql.appendSQL("		codneg,  ");
    sql.appendSQL("		dtpreg,  ");
    sql.appendSQL("		premedult,  ");
    sql.appendSQL("		periodo ");
    sql.appendSQL("	) values ( ");
    sql.appendSQL("		:idMediaMovelSimples,  ");
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

  public MapSqlParameterSource toParameters(final MediaMovelSimplesDiario mediaMovelSimples) {
    return new MapSqlParameterSource()
        .addValue("idMediaMovelSimples", mediaMovelSimples.getIdMediaMovelSimplesDiario())
        .addValue("codneg", mediaMovelSimples.getMediaMovelSimples().getCodneg())
        .addValue("dtpreg", mediaMovelSimples.getDtpreg())
        .addValue("premedult", mediaMovelSimples.getMediaMovelSimples().getPremedult())
        .addValue("periodo", mediaMovelSimples.getMediaMovelSimples().getPeriodo());
  }

  public String getSelectByCodNegPeriodoDtPreg() {
    SQLAppender sql = new SQLAppender(100);
    sql.appendSQL(" select ");
    sql.appendSQL("		id_media_movel_simples, ");
    sql.appendSQL("		codneg, ");
    sql.appendSQL("		dtpreg, ");
    sql.appendSQL("		premedult, ");
    sql.appendSQL("		periodo ");
    sql.appendSQL(" from media_movel_simples_diario ");
    sql.appendSQL("	where codneg = :codneg ");
    sql.appendSQL("	and periodo = :periodo ");
    sql.appendSQL("	and dtpreg = :dtpreg ");
    sql.appendSQL("	order by dtpreg asc ");
    return sql.getAppendSQLSemQuebra().toString();
  }

  public MapSqlParameterSource toParametersSelectByCodNegPeriodoDtPreg(
      final String codneg,
      final Integer periodo,
      final LocalDate dtpreg) {
    return new MapSqlParameterSource()
        .addValue("codneg", codneg)
        .addValue("periodo", periodo)
        .addValue("dtpreg", dtpreg);
  }

}
