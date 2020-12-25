package com.ricardococati.calculacotacoes.adapters.repositories.controle.mapper;

import com.ricardococati.calculacotacoes.entities.domains.controle.ControleExecucao;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Component;

@Component
public class ControleExecucaoMapper {

  public ControleExecucao mapper(ResultSet rs) {
    try {
      return ControleExecucao
          .builder()
          .idControleExecucao(rs.getLong("id_controle_execucao"))
          .controleExecucaoAtivo(rs.getBoolean("controle_execucao_ativo"))
          .calcMediaSimplesDiarioExecutado(rs.getBoolean("calc_media_movel_diario_executado"))
          .calcMediaSimplesSemanalExecutado(rs.getBoolean("calc_media_movel_semanal_executado"))
          .calcMediaExponencialDiarioExecutado(rs.getBoolean("calc_media_exponecial_diario_executado"))
          .calcMediaExponencialSemanalExecutado(rs.getBoolean("calc_media_exponecial_semanal_executado"))
          .calcMacdDiarioExecutado(rs.getBoolean("calc_macd_diario_executado"))
          .calcMacdSemanalExecutado(rs.getBoolean("calc_macd_semanal_executado"))
          .calcSinalMacdDiarioExecutado(rs.getBoolean("calc_sinal_macd_diario_executado"))
          .calcSinalMacdSemanalExecutado(rs.getBoolean("calc_sinal_macd_semanal_executado"))
          .calcHistogramaDiarioExecutado(rs.getBoolean("calc_histograma_diario_executado"))
          .calcHistogramaSemanalExecutado(rs.getBoolean("calc_histograma_semanal_executado"))
          .build();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

}
