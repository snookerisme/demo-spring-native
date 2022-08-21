package com.example.demo.feature.crud

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.coRouter

@Configuration
class CrudRouter {
    @Bean
    fun crudRoutes(demoHandler: CrudHandler
    ) = coRouter {
        accept(MediaType.APPLICATION_JSON).nest {
            GET("/get-all", demoHandler::getAll)
            POST("/get", demoHandler::get)
            POST("/create", demoHandler::create)
            POST("/update", demoHandler::update)
            POST("/delete", demoHandler::delete)
        }
    }
}