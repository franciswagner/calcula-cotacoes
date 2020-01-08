package com.ricardococati.repository.dao;

import com.opentable.db.postgres.embedded.FlywayPreparer;
import com.opentable.db.postgres.junit.EmbeddedPostgresRules;
import com.opentable.db.postgres.junit.PreparedDbRule;
import javax.validation.constraints.NotNull;
import org.junit.Rule;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public abstract class BaseJdbcTest {

  @Rule
  public PreparedDbRule postgresDB;

  public BaseJdbcTest() {
    postgresDB = EmbeddedPostgresRules.preparedDatabase(
        FlywayPreparer.forClasspathLocation(
            new String[]{"filesystem:./../application/src/main/resources/db/migration"})
    );
  }

  @NotNull
  protected final NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
    PreparedDbRule preparedDbRule = this.postgresDB;
    return new NamedParameterJdbcTemplate(preparedDbRule.getTestDatabase());
  }

}
