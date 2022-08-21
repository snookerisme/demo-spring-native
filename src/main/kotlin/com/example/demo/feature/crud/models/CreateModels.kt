package com.example.demo.feature.crud.models

data class CreateRequest(
    val id: String,
    val name: String,
    val mobile: String,
    val email: String
)

data class CreateResponse(
    val code: String,
    val description: String
)