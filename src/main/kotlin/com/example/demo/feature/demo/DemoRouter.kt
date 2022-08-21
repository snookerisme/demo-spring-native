package com.example.demo.feature.demo

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class DemoRouter {
    @Bean
    fun demoRoutes(demoHandler: DemoHandler
    ) = coRouter {
        accept(MediaType.APPLICATION_JSON).nest {
            GET("/demo", demoHandler::demoGet)
        }
    }
}