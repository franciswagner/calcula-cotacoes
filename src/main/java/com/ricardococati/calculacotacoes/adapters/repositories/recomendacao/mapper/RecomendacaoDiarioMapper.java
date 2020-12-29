package com.ricardococati.calculacotacoes.adapters.repositories.recomendacao.mapper;

import static com.ricardococati.calculacotacoes.utils.data.TratamentoResultSetCampoData.retornaDataSeResultSetContemDataSenaoRetornaNulo;

import com.ricardococati.calculacotacoes.entities.domains.recomendacao.Recomendacao;
import com.ricardococati.calculacotacoes.entities.domains.recomendacao.RecomendacaoDiario;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Service;

@Service
public class RecomendacaoDiarioMapper {

  public RecomendacaoDiario mapperConsult(ResultSet rs) {
    try {
      return RecomendacaoDiario
          .builder()
          .dtpreg(retornaDataSeResultSetContemDataSenaoRetornaNulo(rs, "dtpreg"))
          .recomendacao(
              Recomendacao
                  .builder()
                  .codneg(rs.getString("codneg"))
                  .precoAbertura(rs.getBigDecimal("preco_abertura"))
                  .precoFechamento(rs.getBigDecimal("preco_fechamento"))
                  .precoMinimo(rs.getBigDecimal("preco_minimo"))
                  .precoMaximo(rs.getBigDecimal("preco_maximo"))
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

}
