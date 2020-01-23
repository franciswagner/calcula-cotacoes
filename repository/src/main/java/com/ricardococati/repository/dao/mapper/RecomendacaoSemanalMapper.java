package com.ricardococati.repository.dao.mapper;

import static java.util.Objects.nonNull;

import com.ricardococati.model.dto.Recomendacao;
import com.ricardococati.model.dto.RecomendacaoDiario;
import com.ricardococati.model.dto.RecomendacaoSemanal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import org.springframework.stereotype.Service;

@Service
public class RecomendacaoSemanalMapper {

  public RecomendacaoSemanal mapper(ResultSet rs) {
    try {
      return RecomendacaoSemanal
          .builder()
          .idRecomendacaoSemanal(rs.getLong("id_recomendacao"))
          .dtpregini(parseDateWithoutNull(rs, "dtpregini"))
          .dtpregfim(parseDateWithoutNull(rs, "dtpregfim"))
          .recomendacao(
              Recomendacao
                  .builder()
                  .codneg(rs.getString("codneg"))
                  .precoFechamento(rs.getBigDecimal("preco_fechamento"))
                  .precoMME12p(rs.getBigDecimal("preco_mme12p"))
                  .precoMME26p(rs.getBigDecimal("preco_mme26p"))
                  .precoMacd(rs.getBigDecimal("preco_macd"))
                  .precoSinalMacd(rs.getBigDecimal("preco_sinal_macd"))
                  .precoHistograma(rs.getBigDecimal("preco_histograma"))
                  .decisao(rs.getString("decisao"))
                  .build())
          .build();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public RecomendacaoSemanal mapperConsult(ResultSet rs) {
    try {
      return RecomendacaoSemanal
          .builder()
          .dtpregini(parseDateWithoutNull(rs, "dtpregini"))
          .dtpregfim(parseDateWithoutNull(rs, "dtpregfim"))
          .recomendacao(
              Recomendacao
                  .builder()
                  .codneg(rs.getString("codneg"))
                  .precoFechamento(rs.getBigDecimal("preco_fechamento"))
                  .precoMME12p(rs.getBigDecimal("preco_mme12p"))
                  .precoMME26p(rs.getBigDecimal("preco_mme26p"))
                  .precoMacd(rs.getBigDecimal("preco_macd"))
                  .precoSinalMacd(rs.getBigDecimal("preco_sinal_macd"))
                  .precoHistograma(rs.getBigDecimal("preco_histograma"))
                  .build())
          .build();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public LocalDate parseDateWithoutNull(ResultSet rs, String stringData)
      throws SQLException {
    LocalDate date = null;
    if (nonNull(rs.getDate(stringData))) {
      date = rs.getDate(stringData).toLocalDate();
    }
    return date;
  }

}
