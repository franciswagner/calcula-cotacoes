package com.ricardococati.calculacotacoes.adapters.repositories.recomendacao.sqlutil;

import com.ricardococati.calculacotacoes.utils.sql.SQLAppender;
import com.ricardococati.calculacotacoes.entities.domains.recomendacao.RecomendacaoSemanal;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class RecomendacaoSemanalInserirSQLUtil {

  public String getInsert() {
    SQLAppender sql = new SQLAppender(100);
    sql.appendSQL("	insert into recomendacao_semanal( ");
    sql.appendSQL("		id_recomendacao,  ");
    sql.appendSQL("		codneg,  ");
    sql.appendSQL("		dtpregini,  ");
    sql.appendSQL("		dtpregfim,  ");
    sql.appendSQL("		preco_fechamento, ");
    sql.appendSQL("		preco_mme12p, ");
    sql.appendSQL("		preco_mme26p, ");
    sql.appendSQL("		preco_macd, ");
    sql.appendSQL("		preco_sinal_macd, ");
    sql.appendSQL("		preco_histograma, ");
    sql.appendSQL("		voltot, ");
    sql.appendSQL("		decisao ");
    sql.appendSQL("	) values ( ");
    sql.appendSQL("		:idRecomendacao,  ");
    sql.appendSQL("		:codneg,  ");
    sql.appendSQL("		:dtpregini,  ");
    sql.appendSQL("		:dtpregfim,  ");
    sql.appendSQL("		:precoFechamento, ");
    sql.appendSQL("		:precoMME12p, ");
    sql.appendSQL("		:precoMME26p, ");
    sql.appendSQL("		:precoMacd, ");
    sql.appendSQL("		:precoSinalMacd, ");
    sql.appendSQL("		:precoHistograma, ");
    sql.appendSQL("		:voltot, ");
    sql.appendSQL("		:decisao ");
    sql.appendSQL("	) ");
    sql.appendSQL(" on conflict (codneg, dtpregini) do update set ");
    sql.appendSQL("		codneg = excluded.codneg,  ");
    sql.appendSQL("		dtpregini = excluded.dtpregini,  ");
    sql.appendSQL("		dtpregfim = excluded.dtpregfim,  ");
    sql.appendSQL("		preco_fechamento = excluded.preco_fechamento, ");
    sql.appendSQL("		preco_mme12p = excluded.preco_mme12p, ");
    sql.appendSQL("		preco_mme26p = excluded.preco_mme26p, ");
    sql.appendSQL("		preco_macd = excluded.preco_macd, ");
    sql.appendSQL("		preco_sinal_macd = excluded.preco_sinal_macd, ");
    sql.appendSQL("		preco_histograma = excluded.preco_histograma, ");
    sql.appendSQL("		voltot = excluded.voltot, ");
    sql.appendSQL("		decisao = excluded.decisao ");
    return sql.getAppendSQLSemQuebra().toString();
  }

  public MapSqlParameterSource toParameters(final RecomendacaoSemanal semanal) {
    return new MapSqlParameterSource()
        .addValue("idRecomendacao", semanal.getIdRecomendacaoSemanal())
        .addValue("codneg", semanal.getRecomendacao().getCodneg())
        .addValue("dtpregini", semanal.getDtpregini())
        .addValue("dtpregfim", semanal.getDtpregfim())
        .addValue("precoFechamento", semanal.getRecomendacao().getPrecoFechamento())
        .addValue("precoMME12p", semanal.getRecomendacao().getPrecoMME12p())
        .addValue("precoMME26p", semanal.getRecomendacao().getPrecoMME26p())
        .addValue("precoMacd", semanal.getRecomendacao().getPrecoMacd())
        .addValue("precoSinalMacd", semanal.getRecomendacao().getPrecoSinalMacd())
        .addValue("precoHistograma", semanal.getRecomendacao().getPrecoHistograma())
        .addValue("voltot", semanal.getRecomendacao().getVoltot())
        .addValue("decisao", semanal.getRecomendacao().getDecisao());
  }

}
