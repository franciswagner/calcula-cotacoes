package com.ricardococati.calculacotacoes.adapters.repositories.recomendacao.sqlutil;

import com.ricardococati.calculacotacoes.utils.sql.SQLAppender;
import com.ricardococati.calculacotacoes.entities.enums.QuantidadePeriodo;
import java.time.LocalDate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class RecomendacaoSemanalBuscarSQLUtil {

  public String getSelectByCodNegDtPreg() {
    SQLAppender sql = new SQLAppender(100);
    final Integer fast12 = QuantidadePeriodo.FAST_12.getQuantidade();
    final Integer slow26 = QuantidadePeriodo.SLOW_26.getQuantidade();
    sql.appendSQL(" select ");
    sql.appendSQL("     cs.codneg, ");
    sql.appendSQL("     cs.dtpregini, ");
    sql.appendSQL("     cs.dtpregfim, ");
    sql.appendSQL("     cs.preabe as preco_abertura, ");
    sql.appendSQL("     cs.preult as preco_fechamento, ");
    sql.appendSQL("     cs.premin as preco_minimo, ");
    sql.appendSQL("     cs.premax as preco_maximo, ");
    sql.appendSQL("     mme12.premedult as preco_mme12p, ");
    sql.appendSQL("     mme26.premedult as preco_mme26p, ");
    sql.appendSQL("     md.premacd as preco_macd, ");
    sql.appendSQL("     smd.presinal as preco_sinal_macd, ");
    sql.appendSQL("     hs.prehist as preco_histograma, ");
    sql.appendSQL("     cs.voltot as voltot ");
    sql.appendSQL(" from candlestick_semanal cs ");
    sql.appendSQL(" inner join histograma_semanal hs on hs.codneg = cs.codneg ");
    sql.appendSQL("                                  and hs.dtpregini = cs.dtpregini ");
    sql.appendSQL("                                  and hs.dtpregfim = cs.dtpregfim ");
    sql.appendSQL(" inner join macd_semanal md on md.codneg = hs.codneg ");
    sql.appendSQL("                            and md.dtpregini = hs.dtpregini ");
    sql.appendSQL("                            and md.dtpregfim = hs.dtpregfim ");
    sql.appendSQL(" inner join sinal_macd_semanal smd on smd.codneg = hs.codneg ");
    sql.appendSQL("                                   and smd.dtpregini = hs.dtpregini ");
    sql.appendSQL("                                   and smd.dtpregfim = hs.dtpregfim ");
    sql.appendSQL(" inner join media_movel_exponencial_semanal mme12 on mme12.codneg = hs.codneg ");
    sql.appendSQL("                                                  and mme12.dtpregini = hs.dtpregini ");
    sql.appendSQL("                                                  and mme12.dtpregfim = hs.dtpregfim ");
    sql.appendSQL("                                                  and mme12.periodo = " + fast12);
    sql.appendSQL(" inner join media_movel_exponencial_semanal mme26 on mme26.codneg = hs.codneg ");
    sql.appendSQL("                                                  and mme26.dtpregini = hs.dtpregini ");
    sql.appendSQL("                                                  and mme26.dtpregfim = hs.dtpregfim ");
    sql.appendSQL("                                                  and mme26.periodo = " + slow26);
    sql.appendSQL(" where hs.codneg = :codneg ");
    sql.appendSQL(" and hs.dtpregini >= :dtpregini ");
    sql.appendSQL(" order by hs.dtpregini asc ");
    return sql.getAppendSQLSemQuebra().toString();
  }

  public MapSqlParameterSource toParametersCodNegDtPreg(
      final String codneg,
      final LocalDate dtpregini) {
    return new MapSqlParameterSource()
        .addValue("codneg", codneg)
        .addValue("dtpregini", dtpregini);
  }

}
