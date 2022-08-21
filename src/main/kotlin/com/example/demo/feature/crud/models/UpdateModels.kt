package com.example.demo.feature.crud.models

data class UpdateRequest(
    val id: String,
    val name: String,
    val mobile: String,
    val email: String
)

data class UpdateResponse(
    val code: String,
    val description: String
)