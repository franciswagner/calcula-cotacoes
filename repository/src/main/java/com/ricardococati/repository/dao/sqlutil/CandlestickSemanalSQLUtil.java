package com.ricardococati.repository.dao.sqlutil;

import com.ricardococati.model.dto.CandlestickSemanalDTO;
import com.ricardococati.model.dto.SplitInplit;
import com.ricardococati.repository.util.SQLAppender;
import java.time.LocalDate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class CandlestickSemanalSQLUtil {

  public String getInsert() {
    SQLAppender sql = new SQLAppender(100);
    sql.appendSQL("	insert into candlestick_semanal ( ");
    sql.appendSQL("		id_candle_semanal, ");
    sql.appendSQL("		codneg, ");
    sql.appendSQL("		dtpregini, ");
    sql.appendSQL("		dtpregfim, ");
    sql.appendSQL("		media_movel_gerada, ");
    sql.appendSQL("		media_exponecial_gerada, ");
    sql.appendSQL("		macd_gerada, ");
    sql.appendSQL("		sinal_macd_gerada, ");
    sql.appendSQL("		histograma_gerada, ");
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
    sql.appendSQL("		:mediaMovelGerada, ");
    sql.appendSQL("		:mediaExponencialGerada, ");
    sql.appendSQL("		:macdGerada, ");
    sql.appendSQL("		:sinalMacdGerada, ");
    sql.appendSQL("		:histogramaGerada, ");
    sql.appendSQL("		:preabe, ");
    sql.appendSQL("		:premax, ");
    sql.appendSQL("		:premin, ");
    sql.appendSQL("		:preult, ");
    sql.appendSQL("		:semana, ");
    sql.appendSQL("		:voltot ");
    sql.appendSQL("   ) ");
    sql.appendSQL(" on conflict (codneg, dtpregini, dtpregfim) do update set ");
    sql.appendSQL("		codneg = excluded.codneg, ");
    sql.appendSQL("		dtpregini = excluded.dtpregini, ");
    sql.appendSQL("		dtpregfim = excluded.dtpregfim, ");
    sql.appendSQL("		media_movel_gerada = excluded.media_movel_gerada, ");
    sql.appendSQL("		media_exponecial_gerada = excluded.media_exponecial_gerada, ");
    sql.appendSQL("		macd_gerada = excluded.macd_gerada, ");
    sql.appendSQL("		sinal_macd_gerada = excluded.sinal_macd_gerada, ");
    sql.appendSQL("		histograma_gerada = excluded.histograma_gerada, ");
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
        .addValue("mediaMovelGerada", candlestickSemanalDTO.getCandlestickDTO().getMediaMovelGerada())
        .addValue("mediaExponencialGerada", candlestickSemanalDTO.getCandlestickDTO().getMediaExponencialGerada())
        .addValue("macdGerada", candlestickSemanalDTO.getCandlestickDTO().getMacdGerada())
        .addValue("sinalMacdGerada", candlestickSemanalDTO.getCandlestickDTO().getSinalMacdGerada())
        .addValue("histogramaGerada", candlestickSemanalDTO.getCandlestickDTO().getHistogramaGerada())
        .addValue("preabe", candlestickSemanalDTO.getCandlestickDTO().getPreabe())
        .addValue("premax", candlestickSemanalDTO.getCandlestickDTO().getPremax())
        .addValue("premin", candlestickSemanalDTO.getCandlestickDTO().getPremin())
        .addValue("preult", candlestickSemanalDTO.getCandlestickDTO().getPreult())
        .addValue("semana", candlestickSemanalDTO.getCandlestickDTO().getSemana())
        .addValue("voltot", candlestickSemanalDTO.getCandlestickDTO().getVoltot());
  }

  public String getUpdate(final String operacao) {
    final SQLAppender sql = new SQLAppender(100);
    sql.appendSQL(" update candlestick_semanal set  ");
    sql.appendSQL("   preabe = preabe "+operacao+" :qtddivmult,  ");
    sql.appendSQL("   premax = premax "+operacao+" :qtddivmult,  ");
    sql.appendSQL("   premin = premin "+operacao+" :qtddivmult, ");
    sql.appendSQL("   preult = preult "+operacao+" :qtddivmult ");
    sql.appendSQL(" where dtpregini < :dtpreg ");
    sql.appendSQL(" and   codneg = :codneg ");
    return sql.getAppendSQLSemQuebra().toString();
  }

  public MapSqlParameterSource toParametersUpdate(final SplitInplit splitInplit) {
    return new MapSqlParameterSource()
        .addValue("dtpreg", splitInplit.getDtpreg())
        .addValue("codneg", splitInplit.getCodneg())
        .addValue("qtddivmult", splitInplit.getQtdSplitInplit());
  }

  public String getSelectByCodNeg() {
    SQLAppender sql = new SQLAppender(100);
    sql.appendSQL(" select ");
    sql.appendSQL("		id_candle_semanal, ");
    sql.appendSQL("		codneg, ");
    sql.appendSQL("		dtpregini, ");
    sql.appendSQL("		dtpregfim, ");
    sql.appendSQL("		media_movel_gerada, ");
    sql.appendSQL("		media_exponecial_gerada, ");
    sql.appendSQL("		macd_gerada, ");
    sql.appendSQL("		sinal_macd_gerada, ");
    sql.appendSQL("		histograma_gerada, ");
    sql.appendSQL("		preabe, ");
    sql.appendSQL("		premax, ");
    sql.appendSQL("		premin, ");
    sql.appendSQL("		preult, ");
    sql.appendSQL("		semana, ");
    sql.appendSQL("		voltot ");
    sql.appendSQL(" from candlestick_semanal ");
    sql.appendSQL("	where codneg = :codneg ");
    sql.appendSQL("	order by dtpregini asc ");
    return sql.getAppendSQLSemQuebra().toString();
  }

  public MapSqlParameterSource toParametersCodNeg(final String codneg) {
    return new MapSqlParameterSource()
        .addValue("codneg", codneg);
  }

  public String getSelectCodNegByDtPreg() {
    final SQLAppender sql = new SQLAppender(100);
    sql.appendSQL(" select ");
    sql.appendSQL("   codneg  ");
    sql.appendSQL(" from candlestick_semanal ");
    sql.appendSQL(" where dtpregini > :dtpregini ");
    sql.appendSQL(" group by codneg ");
    sql.appendSQL(" order by codneg asc ");
    return sql.getAppendSQLSemQuebra().toString();
  }

  public MapSqlParameterSource toParametersDtPreg(final LocalDate dtpreg) {
    return new MapSqlParameterSource()
        .addValue("dtpregini", dtpreg);
  }

}
