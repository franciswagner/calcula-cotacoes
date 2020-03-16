package com.ricardococati.repository.dao.sqlutil;

import com.ricardococati.model.entities.ControleExecucao;
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
    sql.appendSQL("     calc_media_movel_diario_executado = :calcMediaMovelDiarioExecutado, ");
    sql.appendSQL("     calc_media_movel_diario_executado_dtexec = :calcMediaMovelDiarioExecutadoDtexec, ");
    sql.appendSQL("     calc_media_exponecial_diario_executado = :calcMovelExponecialDiarioExecutado, ");
    sql.appendSQL("     calc_media_exponecial_diario_executado_dtexec = :calcMovelExponecialDiarioExecutadoDtexec, ");
    sql.appendSQL("     calc_macd_diario_executado = :calcMacdDiarioExecutado, ");
    sql.appendSQL("     calc_macd_diario_executado_dtexec = :calcMacdDiarioExecutadoDtexec, ");
    sql.appendSQL("     calc_sinal_macd_diario_executado = :calcSinalMacdDiarioExecutado, ");
    sql.appendSQL("     calc_sinal_macd_diario_executado_dtexec = :calcSinalMacdDiarioExecutadoDtexec, ");
    sql.appendSQL("     calc_histograma_diario_executado = :calcHistogramaDiarioExecutado, ");
    sql.appendSQL("     calc_histograma_diario_executado_dtexec = :calcHistogramaDiarioExecutadoDtexec ");
    sql.appendSQL(" where id_controle_execucao = :idControleExecucao ");
    return sql.getAppendSQLSemQuebra().toString();
  }

  public MapSqlParameterSource toParametersUpdateDiario(
      final ControleExecucao controleExecucao) {
    return new MapSqlParameterSource()
        .addValue("calcMediaMovelDiarioExecutado", controleExecucao.getCalcMediaSimplesDiarioExecutado())
        .addValue("calcMediaMovelDiarioExecutadoDtexec", controleExecucao.getCalcMediaSimplesDiarioExecutadoDtpreg())
        .addValue("calcMovelExponecialDiarioExecutado", controleExecucao.getCalcMediaExponencialDiarioExecutado())
        .addValue("calcMovelExponecialDiarioExecutadoDtexec", controleExecucao.getCalcMediaExponencialDiarioExecutadoDtpreg())
        .addValue("calcMacdDiarioExecutado", controleExecucao.getCalcMacdDiarioExecutado())
        .addValue("calcMacdDiarioExecutadoDtexec", controleExecucao.getCalcMacdDiarioExecutadoDtpreg())
        .addValue("calcSinalMacdDiarioExecutado", controleExecucao.getCalcSinalMacdDiarioExecutado())
        .addValue("calcSinalMacdDiarioExecutadoDtexec", controleExecucao.getCalcSinalMacdDiarioExecutadoDtpreg())
        .addValue("calcHistogramaDiarioExecutado", controleExecucao.getCalcHistogramaDiarioExecutado())
        .addValue("calcHistogramaDiarioExecutadoDtexec", controleExecucao.getCalcHistogramaDiarioExecutadoDtpreg())
        .addValue("idControleExecucao", controleExecucao.getIdControleExecucao());
  }

  public String getUpdateSemanal() {
    final SQLAppender sql = new SQLAppender(100);
    sql.appendSQL(" update controle_execucao set  ");
    sql.appendSQL("     calc_media_movel_semanal_executado = :calcMediaMovelSemanalExecutado, ");
    sql.appendSQL("     calc_media_movel_semanal_executado_dtexec = :calcMediaMovelSemanalExecutadoDtexec, ");
    sql.appendSQL("     calc_media_exponecial_semanal_executado = :calcMovelExponecialSemanalExecutado, ");
    sql.appendSQL("     calc_media_exponecial_semanal_executado_dtexec = :calcMovelExponecialSemanalExecutadoDtexec, ");
    sql.appendSQL("     calc_macd_semanal_executado = :calcMacdSemanalExecutado, ");
    sql.appendSQL("     calc_macd_semanal_executado_dtexec = :calcMacdSemanalExecutadoDtexec, ");
    sql.appendSQL("     calc_sinal_macd_semanal_executado = :calcSinalMacdSemanalExecutado, ");
    sql.appendSQL("     calc_sinal_macd_semanal_executado_dtexec = :calcSinalMacdSemanalExecutadoDtexec, ");
    sql.appendSQL("     calc_histograma_semanal_executado = :calcHistogramaSemanalExecutado, ");
    sql.appendSQL("     calc_histograma_semanal_executado_dtexec = :calcHistogramaSemanalExecutadoDtexec ");
    sql.appendSQL(" where id_controle_execucao = :idControleExecucao ");
    return sql.getAppendSQLSemQuebra().toString();
  }

  public MapSqlParameterSource toParametersUpdateSemanal(
      final ControleExecucao controleExecucao) {
    return new MapSqlParameterSource()
        .addValue("calcMediaMovelSemanalExecutado", controleExecucao.getCalcMediaSimplesSemanalExecutado())
        .addValue("calcMediaMovelSemanalExecutadoDtexec", controleExecucao.getCalcMediaSimplesSemanalExecutadoDtpreg())
        .addValue("calcMovelExponecialSemanalExecutado", controleExecucao.getCalcMediaExponencialSemanalExecutado())
        .addValue("calcMovelExponecialSemanalExecutadoDtexec", controleExecucao.getCalcMediaExponencialSemanalExecutadoDtpreg())
        .addValue("calcMacdSemanalExecutado", controleExecucao.getCalcMacdSemanalExecutado())
        .addValue("calcMacdSemanalExecutadoDtexec", controleExecucao.getCalcMacdSemanalExecutadoDtpreg())
        .addValue("calcSinalMacdSemanalExecutado", controleExecucao.getCalcSinalMacdSemanalExecutado())
        .addValue("calcSinalMacdSemanalExecutadoDtexec", controleExecucao.getCalcSinalMacdSemanalExecutadoDtpreg())
        .addValue("calcHistogramaSemanalExecutado", controleExecucao.getCalcHistogramaSemanalExecutado())
        .addValue("calcHistogramaSemanalExecutadoDtexec", controleExecucao.getCalcHistogramaSemanalExecutadoDtpreg())
        .addValue("idControleExecucao", controleExecucao.getIdControleExecucao());
  }

}
