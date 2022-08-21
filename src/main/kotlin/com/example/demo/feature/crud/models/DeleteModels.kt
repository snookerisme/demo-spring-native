package com.example.demo.feature.crud.models

data class DeleteRequest(
    val id: String
)

data class DeleteResponse(
    val code: String,
    val description: String
)