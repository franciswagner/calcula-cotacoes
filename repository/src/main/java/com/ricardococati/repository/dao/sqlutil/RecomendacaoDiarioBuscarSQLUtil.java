package com.ricardococati.repository.dao.sqlutil;

import com.ricardococati.model.enums.QuantidadePeriodo;
import com.ricardococati.repository.util.SQLAppender;
import java.time.LocalDate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class RecomendacaoDiarioBuscarSQLUtil {

  public String getSelectByCodNegDtPreg() {
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
