package com.ricardococati.calculacotacoes.adapters.repositories.recomendacao.sqlutil;

import com.ricardococati.calculacotacoes.utils.sql.SQLAppender;
import com.ricardococati.calculacotacoes.entities.enums.QuantidadePeriodo;
import java.time.LocalDate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class RecomendacaoDiarioBuscarSQLUtil {

  public String getSelectByCodNegDtPreg() {
    final Integer fast12 = QuantidadePeriodo.FAST_12.getQuantidade();
    final Integer slow26 = QuantidadePeriodo.SLOW_26.getQuantidade();
    SQLAppender sql = new SQLAppender(100);
    sql.appendSQL(" select ");
    sql.appendSQL("     cd.codneg, ");
    sql.appendSQL("     cd.dtpreg, ");
    sql.appendSQL("     cd.preabe as preco_abertura, ");
    sql.appendSQL("     cd.preult as preco_fechamento, ");
    sql.appendSQL("     cd.premin as preco_minimo, ");
    sql.appendSQL("     cd.premax as preco_maximo, ");
    sql.appendSQL("     mme12.premedult as preco_mme12p, ");
    sql.appendSQL("     mme26.premedult as preco_mme26p, ");
    sql.appendSQL("     md.premacd as preco_macd, ");
    sql.appendSQL("     smd.presinal as preco_sinal_macd, ");
    sql.appendSQL("     hd.prehist as preco_histograma, ");
    sql.appendSQL("     cd.voltot as voltot ");
    sql.appendSQL(" from candlestick_diario cd ");
    sql.appendSQL(" inner join histograma_diario hd on hd.codneg = cd.codneg ");
    sql.appendSQL("                                 and hd.dtpreg = cd.dtpreg ");
    sql.appendSQL(" inner join macd_diario md on md.codneg = hd.codneg ");
    sql.appendSQL("                           and md.dtpreg = hd.dtpreg ");
    sql.appendSQL(" inner join sinal_macd_diario smd on smd.codneg = hd.codneg ");
    sql.appendSQL("                                  and smd.dtpreg = hd.dtpreg ");
    sql.appendSQL(" inner join media_movel_exponencial_diario mme12 on mme12.codneg = hd.codneg ");
    sql.appendSQL("                                                 and mme12.dtpreg = hd.dtpreg ");
    sql.appendSQL("                                                 and mme12.periodo = " + fast12);
    sql.appendSQL(" inner join media_movel_exponencial_diario mme26 on mme26.codneg = hd.codneg ");
    sql.appendSQL("                                                 and mme26.dtpreg = hd.dtpreg ");
    sql.appendSQL("                                                 and mme26.periodo = " + slow26);
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
