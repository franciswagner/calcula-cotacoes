package com.ricardococati.config

import org.flywaydb.core.Flyway
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
open class FlywayConfigurationCalculo(val dataSource: DataSource) : FlywayAutoConfiguration() {

    @Bean(initMethod = "migrate")
    open fun flywayInitializer(): Flyway {
        val flyway = Flyway()
        flyway.dataSource = dataSource
        flyway.setLocations("/db/migration")
        flyway.setSchemas("public")
        flyway.isBaselineOnMigrate = false
        flyway.sqlMigrationPrefix = "V"
        flyway.migrate()
        return flyway
    }

}