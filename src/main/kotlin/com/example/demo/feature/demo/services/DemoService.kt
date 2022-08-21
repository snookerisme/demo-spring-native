package com.example.demo.feature.demo.services

import com.example.demo.feature.demo.models.DemoResponse
import org.springframework.stereotype.Service

@Service
class DemoService {

    suspend fun demo(): DemoResponse {
        return DemoResponse(
            "Hi!,I am snooker."
        )
    }
}