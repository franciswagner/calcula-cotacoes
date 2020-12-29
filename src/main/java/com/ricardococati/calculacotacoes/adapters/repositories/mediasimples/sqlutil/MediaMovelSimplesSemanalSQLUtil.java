package com.ricardococati.calculacotacoes.adapters.repositories.mediasimples.sqlutil;

import com.ricardococati.calculacotacoes.utils.sql.SQLAppender;
import com.ricardococati.calculacotacoes.entities.domains.mediasimples.MediaMovelSimplesSemanal;
import java.time.LocalDate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class MediaMovelSimplesSemanalSQLUtil {

  public String getInsert() {
    SQLAppender sql = new SQLAppender(100);
    sql.appendSQL("	INSERT INTO media_movel_simples_semanal( ");
    sql.appendSQL("		id_media_movel_simples,  ");
    sql.appendSQL("		codneg,  ");
    sql.appendSQL("		dtpregini,  ");
    sql.appendSQL("		dtpregfim,  ");
    sql.appendSQL("		premedult,  ");
    sql.appendSQL("		periodo ");
    sql.appendSQL("	) values ( ");
    sql.appendSQL("		:idMediaMovelSimples,  ");
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

  public MapSqlParameterSource toParameters(final MediaMovelSimplesSemanal mediaMovelSimples) {
    return new MapSqlParameterSource()
        .addValue("idMediaMovelSimples", mediaMovelSimples.getIdMediaMovelSimplesSemanal())
        .addValue("codneg", mediaMovelSimples.getMediaMovelSimples().getCodneg())
        .addValue("dtpregini", mediaMovelSimples.getDtpregini())
        .addValue("dtpregfim", mediaMovelSimples.getDtpregfim())
        .addValue("premedult", mediaMovelSimples.getMediaMovelSimples().getPremedult())
        .addValue("periodo", mediaMovelSimples.getMediaMovelSimples().getPeriodo());
  }

  public String getSelectByCodNegPeriodoDtPreg() {
    SQLAppender sql = new SQLAppender(100);
    sql.appendSQL(" select ");
    sql.appendSQL("		id_media_movel_simples, ");
    sql.appendSQL("		codneg, ");
    sql.appendSQL("		dtpregini, ");
    sql.appendSQL("		dtpregfim, ");
    sql.appendSQL("		premedult, ");
    sql.appendSQL("		periodo ");
    sql.appendSQL(" from media_movel_simples_semanal ");
    sql.appendSQL("	where codneg = :codneg ");
    sql.appendSQL("	and periodo = :periodo ");
    sql.appendSQL("	and dtpregini = :dtpregini ");
    sql.appendSQL("	and dtpregfim = :dtpregfim ");
    return sql.getAppendSQLSemQuebra().toString();
  }

  public MapSqlParameterSource toParametersSelectByCodNegPeriodoDtPreg(
      final String codneg,
      final Integer periodo,
      final LocalDate dtpregini,
      final LocalDate dtpregfim) {
    return new MapSqlParameterSource()
        .addValue("codneg", codneg)
        .addValue("periodo", periodo)
        .addValue("dtpregini", dtpregini)
        .addValue("dtpregfim", dtpregfim);
  }

}
