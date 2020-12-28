package com.ricardococati.calculacotacoes.adapters.repositories.recomendacao.sqlutil;

import com.ricardococati.calculacotacoes.utils.sql.SQLAppender;
import org.springframework.stereotype.Component;

@Component
public class RecomendacaoDiarioExcluirSQLUtil {

  public String getDelete() {
    SQLAppender sql = new SQLAppender(30);
    sql.appendSQL("	delete from recomendacao_diario ");
    return sql.getAppendSQLSemQuebra().toString();
  }

}
