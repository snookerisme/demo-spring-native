package com.example.demo.feature.demo

import com.example.demo.feature.demo.services.DemoService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*

@Component
class DemoHandler(
    private val demoService: DemoService
) {
    suspend fun demoGet(request: ServerRequest) =
        ServerResponse.ok().json().bodyValueAndAwait(demoService.demo())
}