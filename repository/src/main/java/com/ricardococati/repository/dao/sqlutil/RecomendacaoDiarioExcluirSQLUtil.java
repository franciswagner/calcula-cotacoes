package com.ricardococati.repository.dao.sqlutil;

import com.ricardococati.repository.util.SQLAppender;
import org.springframework.stereotype.Component;

@Component
public class RecomendacaoDiarioExcluirSQLUtil {

  public String getDelete() {
    SQLAppender sql = new SQLAppender(30);
    sql.appendSQL("	delete from recomendacao_diario ");
    return sql.getAppendSQLSemQuebra().toString();
  }

}
