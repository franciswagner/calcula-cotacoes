package com.ricardococati.repository.dao.sqlutil;

import com.ricardococati.model.dto.CandlestickDiarioDTO;
import com.ricardococati.model.dto.SplitInplit;
import com.ricardococati.repository.util.SQLAppender;
import java.time.LocalDate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class CandlestickDiarioInserirSQLUtil {

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

}