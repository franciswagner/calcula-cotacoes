package com.ricardococati.repository.dao.sqlutil;

import com.ricardococati.model.dto.CandlestickSemanalDTO;
import com.ricardococati.repository.util.SQLAppender;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class CandlestickSemanalInserirSQLUtil {

  public String getInsert() {
    SQLAppender sql = new SQLAppender(100);
    sql.appendSQL("	insert into candlestick_semanal ( ");
    sql.appendSQL("		id_candle_semanal, ");
    sql.appendSQL("		codneg, ");
    sql.appendSQL("		dtpregini, ");
    sql.appendSQL("		dtpregfim, ");
    sql.appendSQL("		preabe, ");
    sql.appendSQL("		premax, ");
    sql.appendSQL("		premin, ");
    sql.appendSQL("		preult, ");
    sql.appendSQL("		semana, ");
    sql.appendSQL("		voltot) ");
    sql.appendSQL("	values( ");
    sql.appendSQL("		:idCandleSemanal, ");
    sql.appendSQL("		:codneg, ");
    sql.appendSQL("		:dtpregini, ");
    sql.appendSQL("		:dtpregfim, ");
    sql.appendSQL("		:preabe, ");
    sql.appendSQL("		:premax, ");
    sql.appendSQL("		:premin, ");
    sql.appendSQL("		:preult, ");
    sql.appendSQL("		:semana, ");
    sql.appendSQL("		:voltot ");
    sql.appendSQL("   ) ");
    sql.appendSQL(" on conflict (codneg, dtpregini) do update set ");
    sql.appendSQL("		codneg = excluded.codneg, ");
    sql.appendSQL("		dtpregini = excluded.dtpregini, ");
    sql.appendSQL("		dtpregfim = excluded.dtpregfim, ");
    sql.appendSQL("		preabe = excluded.preabe, ");
    sql.appendSQL("		premax = excluded.premax, ");
    sql.appendSQL("		premin = excluded.premin, ");
    sql.appendSQL("		preult = excluded.preult, ");
    sql.appendSQL("		semana = excluded.semana, ");
    sql.appendSQL("		voltot = excluded.voltot ");
    return sql.getAppendSQLSemQuebra().toString();
  }

  public MapSqlParameterSource toParameters(final CandlestickSemanalDTO candlestickSemanalDTO) {
    return new MapSqlParameterSource()
        .addValue("idCandleSemanal", candlestickSemanalDTO.getIdCandleSemanal())
        .addValue("codneg", candlestickSemanalDTO.getCandlestickDTO().getCodneg())
        .addValue("dtpregini", candlestickSemanalDTO.getDtpregini())
        .addValue("dtpregfim", candlestickSemanalDTO.getDtpregfim())
        .addValue("preabe", candlestickSemanalDTO.getCandlestickDTO().getPreabe())
        .addValue("premax", candlestickSemanalDTO.getCandlestickDTO().getPremax())
        .addValue("premin", candlestickSemanalDTO.getCandlestickDTO().getPremin())
        .addValue("preult", candlestickSemanalDTO.getCandlestickDTO().getPreult())
        .addValue("semana", candlestickSemanalDTO.getCandlestickDTO().getSemana())
        .addValue("voltot", candlestickSemanalDTO.getCandlestickDTO().getVoltot());
  }

}
