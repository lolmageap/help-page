package com.cherhy.helppage

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan("com.cherhy.helppage")
class HelpPageApplication

fun main(args: Array<String>) {
    runApplication<HelpPageApplication>(*args)
}