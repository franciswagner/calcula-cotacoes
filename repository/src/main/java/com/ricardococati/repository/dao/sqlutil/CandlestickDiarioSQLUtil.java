package com.ricardococati.repository.dao.sqlutil;

import com.ricardococati.model.dto.CandlestickDiarioDTO;
import com.ricardococati.model.dto.SplitInplit;
import com.ricardococati.repository.util.SQLAppender;
import java.time.LocalDate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class CandlestickDiarioSQLUtil {

  public String getInsert() {
    SQLAppender sql = new SQLAppender(100);
    sql.appendSQL("	insert into candlestick_diario ( ");
    sql.appendSQL("		id_candle_diario, ");
    sql.appendSQL("		codneg, ");
    sql.appendSQL("		dtpreg, ");
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
    sql.appendSQL("		:idCandleDiario, ");
    sql.appendSQL("		:codneg, ");
    sql.appendSQL("		:dtpreg, ");
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
    sql.appendSQL(" on conflict (codneg, dtpreg) do update set ");
    sql.appendSQL("		codneg = excluded.codneg, ");
    sql.appendSQL("		dtpreg = excluded.dtpreg, ");
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

  public MapSqlParameterSource toParameters(final CandlestickDiarioDTO candlestickDiarioDTO) {
    return new MapSqlParameterSource()
        .addValue("idCandleDiario", candlestickDiarioDTO.getIdCandleDiario())
        .addValue("codneg", candlestickDiarioDTO.getCandlestickDTO().getCodneg())
        .addValue("dtpreg", candlestickDiarioDTO.getDtpreg())
        .addValue("mediaMovelGerada", candlestickDiarioDTO.getCandlestickDTO().getMediaMovelGerada())
        .addValue("mediaExponencialGerada", candlestickDiarioDTO.getCandlestickDTO().getMediaExponencialGerada())
        .addValue("macdGerada", candlestickDiarioDTO.getCandlestickDTO().getMacdGerada())
        .addValue("sinalMacdGerada", candlestickDiarioDTO.getCandlestickDTO().getSinalMacdGerada())
        .addValue("histogramaGerada", candlestickDiarioDTO.getCandlestickDTO().getHistogramaGerada())
        .addValue("preabe", candlestickDiarioDTO.getCandlestickDTO().getPreabe())
        .addValue("premax", candlestickDiarioDTO.getCandlestickDTO().getPremax())
        .addValue("premin", candlestickDiarioDTO.getCandlestickDTO().getPremin())
        .addValue("preult", candlestickDiarioDTO.getCandlestickDTO().getPreult())
        .addValue("semana", candlestickDiarioDTO.getCandlestickDTO().getSemana())
        .addValue("voltot", candlestickDiarioDTO.getCandlestickDTO().getVoltot());
  }

  public String getUpdate(final String operacao) {
    final SQLAppender sql = new SQLAppender(100);
    sql.appendSQL(" update candlestick_diario set  ");
    sql.appendSQL("   preabe = preabe "+operacao+" :qtddivmult,  ");
    sql.appendSQL("   premax = premax "+operacao+" :qtddivmult,  ");
    sql.appendSQL("   premin = premin "+operacao+" :qtddivmult, ");
    sql.appendSQL("   preult = preult "+operacao+" :qtddivmult ");
    sql.appendSQL(" where dtpreg < :dtpreg ");
    sql.appendSQL(" and   codneg = :codneg ");
    return sql.getAppendSQLSemQuebra().toString();
  }

  public MapSqlParameterSource toParametersUpdate(final SplitInplit splitInplit) {
    return new MapSqlParameterSource()
        .addValue("dtpreg", splitInplit.getDtpreg())
        .addValue("codneg", splitInplit.getCodneg())
        .addValue("qtddivmult", splitInplit.getQtdSplitInplit());
  }

  public String getSelectCodNegMediaSimplesFalse() {
    final SQLAppender sql = new SQLAppender(100);
    sql.appendSQL(" select ");
    sql.appendSQL("   codneg  ");
    sql.appendSQL(" from candlestick_diario ");
    sql.appendSQL(" where media_movel_gerada = false ");
    sql.appendSQL(" group by codneg ");
    sql.appendSQL(" order by codneg asc ");
    return sql.getAppendSQLSemQuebra().toString();
  }

  public String getSelectCodNegMediaExponencialFalse() {
    final SQLAppender sql = new SQLAppender(100);
    sql.appendSQL(" select ");
    sql.appendSQL("   codneg  ");
    sql.appendSQL(" from candlestick_diario ");
    sql.appendSQL(" where media_movel_gerada = true ");
    sql.appendSQL(" and media_exponecial_gerada = false ");
    sql.appendSQL(" group by codneg ");
    sql.appendSQL(" order by codneg asc ");
    return sql.getAppendSQLSemQuebra().toString();
  }

  public String getSelectCodNegMacdFalse() {
    final SQLAppender sql = new SQLAppender(100);
    sql.appendSQL(" select ");
    sql.appendSQL("   codneg  ");
    sql.appendSQL(" from candlestick_diario ");
    sql.appendSQL(" where media_exponecial_gerada = true ");
    sql.appendSQL(" and macdGerada = false ");
    sql.appendSQL(" group by codneg ");
    sql.appendSQL(" order by codneg asc ");
    return sql.getAppendSQLSemQuebra().toString();
  }

  public String getSelectCodNegSinalMacdFalse() {
    final SQLAppender sql = new SQLAppender(100);
    sql.appendSQL(" select ");
    sql.appendSQL("   codneg  ");
    sql.appendSQL(" from candlestick_diario ");
    sql.appendSQL(" where macdGerada = true ");
    sql.appendSQL(" and sinalMacdGerada = false ");
    sql.appendSQL(" group by codneg ");
    sql.appendSQL(" order by codneg asc ");
    return sql.getAppendSQLSemQuebra().toString();
  }

  public String getSelectCodNegHistogramaFalse() {
    final SQLAppender sql = new SQLAppender(100);
    sql.appendSQL(" select ");
    sql.appendSQL("   codneg  ");
    sql.appendSQL(" from candlestick_diario ");
    sql.appendSQL(" where macdGerada = true ");
    sql.appendSQL(" and sinalMacdGerada = true ");
    sql.appendSQL(" and histogramaGerada = true ");
    sql.appendSQL(" group by codneg ");
    sql.appendSQL(" order by codneg asc ");
    return sql.getAppendSQLSemQuebra().toString();
  }

  public String getSelectByCodNeg() {
    SQLAppender sql = new SQLAppender(100);
    sql.appendSQL(" select ");
    sql.appendSQL("		id_candle_diario, ");
    sql.appendSQL("		codneg, ");
    sql.appendSQL("		dtpreg, ");
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
    sql.appendSQL(" from candlestick_diario ");
    sql.appendSQL("	where codneg = :codneg ");
    sql.appendSQL("	order by dtpreg asc ");
    return sql.getAppendSQLSemQuebra().toString();
  }

  public MapSqlParameterSource toParametersCodNeg(final String codneg) {
    return new MapSqlParameterSource()
        .addValue("codneg", codneg);
  }

  public String getUpdateMediaMovel() {
    final SQLAppender sql = new SQLAppender(100);
    sql.appendSQL(" update candlestick_diario set  ");
    sql.appendSQL("   media_movel_gerada = false,  ");
    sql.appendSQL("   media_exponecial_gerada = false,  ");
    sql.appendSQL("   macd_gerada = false,  ");
    sql.appendSQL("   sinal_macd_gerada = false,  ");
    sql.appendSQL("   histograma_gerada = false  ");
    return sql.getAppendSQLSemQuebra().toString();
  }

  public String getUpdateMediaMovelByCodneg() {
    final SQLAppender sql = new SQLAppender(100);
    sql.appendSQL(" update candlestick_diario set  ");
    sql.appendSQL("   media_movel_gerada = true  ");
    sql.appendSQL(" where codneg = :codneg ");
    return sql.getAppendSQLSemQuebra().toString();
  }

  public String getUpdateMediaExponencialByCodneg() {
    final SQLAppender sql = new SQLAppender(100);
    sql.appendSQL(" update candlestick_diario set  ");
    sql.appendSQL("   media_exponecial_gerada = true  ");
    sql.appendSQL(" where codneg = :codneg ");
    return sql.getAppendSQLSemQuebra().toString();
  }

  public String getUpdateMacdByCodneg() {
    final SQLAppender sql = new SQLAppender(100);
    sql.appendSQL(" update candlestick_diario set  ");
    sql.appendSQL("   macd_gerada = true  ");
    sql.appendSQL(" where codneg = :codneg ");
    return sql.getAppendSQLSemQuebra().toString();
  }

  public String getUpdateSinalMacdByCodneg() {
    final SQLAppender sql = new SQLAppender(100);
    sql.appendSQL(" update candlestick_diario set  ");
    sql.appendSQL("   sinal_macd_gerada = true  ");
    sql.appendSQL(" where codneg = :codneg ");
    return sql.getAppendSQLSemQuebra().toString();
  }

  public String getSelectCodNeg() {
    SQLAppender sql = new SQLAppender(100);
    sql.appendSQL(" select ");
    sql.appendSQL("   codneg  ");
    sql.appendSQL(" from candlestick_diario ");
    sql.appendSQL(" group by codneg ");
    sql.appendSQL(" order by codneg asc ");
    return sql.getAppendSQLSemQuebra().toString();
  }
}