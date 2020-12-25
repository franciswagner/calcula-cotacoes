package com.ricardococati.calculacotacoes.adapters.repositories.recomendacao.sqlutil;

import com.ricardococati.calculacotacoes.adapters.repositories.utils.SQLAppender;
import org.springframework.stereotype.Component;

@Component
public class RecomendacaoSemanalExcluirSQLUtil {

  public String getDelete() {
    SQLAppender sql = new SQLAppender(30);
    sql.appendSQL("	delete from recomendacao_semanal ");
    return sql.getAppendSQLSemQuebra().toString();
  }

}
