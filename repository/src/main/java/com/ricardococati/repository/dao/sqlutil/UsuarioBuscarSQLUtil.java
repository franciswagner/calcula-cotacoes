package com.ricardococati.repository.dao.sqlutil;

import com.ricardococati.repository.util.SQLAppender;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class UsuarioBuscarSQLUtil {

  public String getSelectAtivoByUsuario() {
    SQLAppender sql = new SQLAppender(100);
    sql.appendSQL(" select ");
    sql.appendSQL("		atv.id_ativo, ");
    sql.appendSQL("		atv.ativo ");
    sql.appendSQL(" from usuario usu ");
    sql.appendSQL("   inner join usuario_ativo ua on ua.id_usuario = usu.id_usuario ");
    sql.appendSQL("   inner join ativo atv on atv.id_ativo = ua.id_ativo ");
    sql.appendSQL("	where usu.id_usuario = :idUsuario ");
    sql.appendSQL("	order by atv.ativo asc ");
    return sql.getAppendSQLSemQuebra().toString();
  }

  public MapSqlParameterSource toParametersAtivoByUsuario(final Long idUsuario) {
    return new MapSqlParameterSource()
        .addValue("idUsuario", idUsuario);
  }

}
