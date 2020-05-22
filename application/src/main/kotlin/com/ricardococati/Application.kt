package com.ricardococati

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.transaction.annotation.EnableTransactionManagement

@SpringBootApplication
@ComponentScan("com.ricardococati.*")
@EnableScheduling
@EnableTransactionManagement
open class Application

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}
