package com.ricardococati.repository.dao.sqlutil;

import com.ricardococati.model.dto.ControleExecucao;
import com.ricardococati.repository.util.SQLAppender;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class ControleExecucaoSQLUtil {

  public String getSelectControleExecucaoAtivo() {
    SQLAppender sql = new SQLAppender(100);
    sql.appendSQL(" select ");
    sql.appendSQL(" 	id_controle_execucao, ");
    sql.appendSQL(" 	controle_execucao_ativo, ");
    sql.appendSQL(" 	calc_media_movel_diario_executado, ");
    sql.appendSQL(" 	calc_media_movel_semanal_executado, ");
    sql.appendSQL(" 	calc_media_exponecial_diario_executado, ");
    sql.appendSQL(" 	calc_media_exponecial_semanal_executado, ");
    sql.appendSQL(" 	calc_macd_diario_executado, ");
    sql.appendSQL(" 	calc_macd_semanal_executado, ");
    sql.appendSQL(" 	calc_sinal_macd_diario_executado, ");
    sql.appendSQL(" 	calc_sinal_macd_semanal_executado, ");
    sql.appendSQL(" 	calc_histograma_diario_executado, ");
    sql.appendSQL(" 	calc_histograma_semanal_executado ");
    sql.appendSQL(" from ");
    sql.appendSQL(" 	controle_execucao ");
    return sql.getAppendSQLSemQuebra().toString();
  }

  public MapSqlParameterSource toParametersControleExecucaoAtivo(
      final Boolean controleExecucaoAtivo) {
    return new MapSqlParameterSource()
            .addValue("controleExecucaoAtivo", controleExecucaoAtivo);
  }

  public String getUpdateDiario() {
    final SQLAppender sql = new SQLAppender(100);
    sql.appendSQL(" update controle_execucao set  ");
    sql.appendSQL("   calc_media_movel_diario_executado = :calcMediaMovelDiarioExecutada,  ");
    sql.appendSQL("   calc_media_exponecial_diario_executado = :calcMediaExponecialDiarioExecutada,  ");
    sql.appendSQL("   calc_macd_diario_executado = :calcMacdDiarioExecutada,  ");
    sql.appendSQL("   calc_sinal_macd_diario_executado = :calcSinalMacdDiarioExecutada,  ");
    sql.appendSQL("   calc_histograma_diario_executado = :calcHistogramaDiarioExecutada  ");
    sql.appendSQL(" where id_controle_execucao = :idControleExecucao ");
    return sql.getAppendSQLSemQuebra().toString();
  }

  public MapSqlParameterSource toParametersUpdateDiario(
      final ControleExecucao controleExecucao) {
    return new MapSqlParameterSource()
        .addValue("calcMediaMovelDiarioExecutada", controleExecucao.getCalcMediaSimplesDiarioExecutado())
        .addValue("calcMediaExponecialDiarioExecutada", controleExecucao.getCalcMediaExponencialDiarioExecutado())
        .addValue("calcMacdDiarioExecutada", controleExecucao.getCalcMacdDiarioExecutado())
        .addValue("calcSinalMacdDiarioExecutada", controleExecucao.getCalcSinalMacdDiarioExecutado())
        .addValue("calcHistogramaDiarioExecutada", controleExecucao.getCalcHistogramaDiarioExecutado())
        .addValue("idControleExecucao", controleExecucao.getIdControleExecucao());
  }

  public String getUpdateSemanal() {
    final SQLAppender sql = new SQLAppender(100);
    sql.appendSQL(" update controle_execucao set  ");
    sql.appendSQL("   calc_media_movel_semanal_executado = :calcMediaMovelSemanalExecutada,  ");
    sql.appendSQL("   calc_media_exponecial_semanal_executado = :calcMediaExponecialSemanalExecutada,  ");
    sql.appendSQL("   calc_macd_semanal_executado = :calcMacdSemanalExecutada,  ");
    sql.appendSQL("   calc_sinal_macd_semanal_executado = :calcSinalMacdSemanalExecutada,  ");
    sql.appendSQL("   calc_histograma_semanal_executado = :calcHistogramaSemanalExecutada  ");
    sql.appendSQL(" where id_controle_execucao = :idControleExecucao ");
    return sql.getAppendSQLSemQuebra().toString();
  }

  public MapSqlParameterSource toParametersUpdateSemanal(
      final ControleExecucao controleExecucao) {
    return new MapSqlParameterSource()
        .addValue("calcMediaMovelSemanalExecutada", controleExecucao.getCalcMediaSimplesSemanalExecutado())
        .addValue("calcMediaExponecialSemanalExecutada", controleExecucao.getCalcMediaExponencialSemanalExecutado())
        .addValue("calcMacdSemanalExecutada", controleExecucao.getCalcMacdSemanalExecutado())
        .addValue("calcSinalMacdSemanalExecutada", controleExecucao.getCalcSinalMacdSemanalExecutado())
        .addValue("calcHistogramaSemanalExecutada", controleExecucao.getCalcHistogramaSemanalExecutado())
        .addValue("idControleExecucao", controleExecucao.getIdControleExecucao());
  }

}
