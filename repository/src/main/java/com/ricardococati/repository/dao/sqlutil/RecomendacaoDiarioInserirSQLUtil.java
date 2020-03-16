package com.ricardococati.repository.dao.sqlutil;

import com.ricardococati.model.entities.RecomendacaoDiario;
import com.ricardococati.repository.util.SQLAppender;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class RecomendacaoDiarioInserirSQLUtil {

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

}
