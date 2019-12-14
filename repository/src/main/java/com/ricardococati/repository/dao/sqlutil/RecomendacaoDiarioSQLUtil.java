package com.ricardococati.repository.dao.sqlutil;

import com.ricardococati.model.dto.RecomendacaoDiario;
import com.ricardococati.model.enums.QuantidadePeriodo;
import com.ricardococati.repository.util.SQLAppender;
import java.time.LocalDate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class RecomendacaoDiarioSQLUtil {

  public String getInsert() {
    SQLAppender sql = new SQLAppender(100);
    sql.appendSQL("	insert into recomendacao_diario( ");
    sql.appendSQL("		id_recomendacao,  ");
    sql.appendSQL("		codneg,  ");
    sql.appendSQL("		dtpreg,  ");
    sql.appendSQL("		preco_fechamento, ");
    sql.appendSQL("		preco_mme12p, ");
    sql.appendSQL("		preco_mme26p, ");
    sql.appendSQL("		preco_macd, ");
    sql.appendSQL("		preco_sinal_macd, ");
    sql.appendSQL("		preco_histograma, ");
    sql.appendSQL("		decisao ");
    sql.appendSQL("	) values ( ");
    sql.appendSQL("		:idRecomendacao,  ");
    sql.appendSQL("		:codneg,  ");
    sql.appendSQL("		:dtpreg,  ");
    sql.appendSQL("		:precoFechamento, ");
    sql.appendSQL("		:precoMME12p, ");
    sql.appendSQL("		:precoMME26p, ");
    sql.appendSQL("		:precoMacd, ");
    sql.appendSQL("		:precoSinalMacd, ");
    sql.appendSQL("		:precoHistograma, ");
    sql.appendSQL("		:decisao ");
    sql.appendSQL("	) ");
    sql.appendSQL(" on conflict (codneg, dtpreg) do update set ");
    sql.appendSQL("		codneg = excluded.codneg,  ");
    sql.appendSQL("		dtpreg = excluded.dtpreg,  ");
    sql.appendSQL("		preco_fechamento = excluded.preco_fechamento, ");
    sql.appendSQL("		preco_mme12p = excluded.preco_mme12p, ");
    sql.appendSQL("		preco_mme26p = excluded.preco_mme26p, ");
    sql.appendSQL("		preco_macd = excluded.preco_macd, ");
    sql.appendSQL("		preco_sinal_macd = excluded.preco_sinal_macd, ");
    sql.appendSQL("		preco_histograma = excluded.preco_histograma, ");
    sql.appendSQL("		decisao = excluded.decisao ");
    return sql.getAppendSQLSemQuebra().toString();
  }

  public String getDelete() {
    SQLAppender sql = new SQLAppender(30);
    sql.appendSQL("	delete from recomendacao_diario ");
    return sql.getAppendSQLSemQuebra().toString();
  }

  public MapSqlParameterSource toParameters(final RecomendacaoDiario diario) {
    return new MapSqlParameterSource()
        .addValue("idRecomendacao", diario.getIdRecomendacaoDiario())
        .addValue("codneg", diario.getRecomendacao().getCodneg())
        .addValue("dtpreg", diario.getDtpreg())
        .addValue("precoFechamento", diario.getRecomendacao().getPrecoFechamento())
        .addValue("precoMME12p", diario.getRecomendacao().getPrecoMME12p())
        .addValue("precoMME26p", diario.getRecomendacao().getPrecoMME26p())
        .addValue("precoMacd", diario.getRecomendacao().getPrecoMacd())
        .addValue("precoSinalMacd", diario.getRecomendacao().getPrecoSinalMacd())
        .addValue("precoHistograma", diario.getRecomendacao().getPrecoHistograma())
        .addValue("decisao", diario.getRecomendacao().getDecisao());
  }

  public String getSelectByCodNeg() {
    SQLAppender sql = new SQLAppender(100);
    sql.appendSQL("	select ");
    sql.appendSQL("		id_recomendacao,  ");
    sql.appendSQL("		codneg,  ");
    sql.appendSQL("		dtpreg,  ");
    sql.appendSQL("		preco_fechamento, ");
    sql.appendSQL("		preco_mme12p, ");
    sql.appendSQL("		preco_mme26p, ");
    sql.appendSQL("		preco_macd, ");
    sql.appendSQL("		preco_sinal_macd, ");
    sql.appendSQL("		preco_histograma, ");
    sql.appendSQL("		decisao ");
    sql.appendSQL("	from ");
    sql.appendSQL("		recomendacao_diario ");
    sql.appendSQL("	where ");
    sql.appendSQL("		codneg = :codneg ");
    sql.appendSQL("  order by dtpreg asc");
    return sql.getAppendSQLSemQuebra().toString();
  }

  public MapSqlParameterSource toParametersByCodNeg(final String codneg) {
    return new MapSqlParameterSource()
        .addValue("codneg", codneg);
  }

  public String getSelectByCodNegDtPreg() {
    SQLAppender sql = new SQLAppender(100);
    sql.appendSQL(" select ");
    sql.appendSQL("     cd.codneg, ");
    sql.appendSQL("     cd.dtpreg, ");
    sql.appendSQL("     cd.preult as preco_fechamento, ");
    sql.appendSQL("     mme12.premedult as preco_mme12p, ");
    sql.appendSQL("     mme26.premedult as preco_mme26p, ");
    sql.appendSQL("     md.premacd as preco_macd, ");
    sql.appendSQL("     smd.presinal as preco_sinal_macd, ");
    sql.appendSQL("     hd.prehist as preco_histograma ");
    sql.appendSQL(" from candlestick_diario cd ");
    sql.appendSQL(" inner join histograma_diario hd on hd.codneg = cd.codneg and hd.dtpreg = cd.dtpreg ");
    sql.appendSQL(" inner join macd_diario md on md.codneg = hd.codneg and md.dtpreg = hd.dtpreg ");
    sql.appendSQL(" inner join sinal_macd_diario smd on smd.codneg = hd.codneg and smd.dtpreg = hd.dtpreg ");
    sql.appendSQL(" inner join media_movel_exponencial_diario mme12 on ");
    sql.appendSQL("     mme12.codneg = hd.codneg and mme12.dtpreg = hd.dtpreg and mme12.periodo = "
        + QuantidadePeriodo.FAST_12.getQuantidade());
    sql.appendSQL(" inner join media_movel_exponencial_diario mme26 on ");
    sql.appendSQL("     mme26.codneg = hd.codneg and mme26.dtpreg = hd.dtpreg and mme26.periodo = "
        + QuantidadePeriodo.SLOW_26.getQuantidade());
    sql.appendSQL(" where hd.codneg = :codneg ");
    sql.appendSQL(" and hd.dtpreg >= :dtpreg ");
    sql.appendSQL(" order by hd.dtpreg asc ");
    return sql.getAppendSQLSemQuebra().toString();
  }

  public MapSqlParameterSource toParametersCodNegDtPreg(
      final String codneg,
      final LocalDate dtpreg) {
    return new MapSqlParameterSource()
        .addValue("codneg", codneg)
        .addValue("dtpreg", dtpreg);
  }

}
