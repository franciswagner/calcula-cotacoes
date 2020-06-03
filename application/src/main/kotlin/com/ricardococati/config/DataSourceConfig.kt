package com.ricardococati.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
open class DataSourceConfig {

    @Bean
    open fun dataSource(@Value("\${spring.datasource.url}") url: String?,  //
                        @Value("\${spring.datasource.username}") username: String?,  //
                        @Value("\${spring.datasource.password}") password: String?,  //
                        @Value("\${spring.datasource.driver-class-name}") driver: String?
    ): DataSource? {
        val config = HikariConfig()
        config.setJdbcUrl(url)
        config.setUsername(username)
        config.setPassword(password)
        config.setDriverClassName(driver)
        return HikariDataSource(config)
    }

}
