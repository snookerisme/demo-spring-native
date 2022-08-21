package com.example.demo.feature.crud.models

import com.example.demo.entities.User

data class GetRequest(
    val id: String
)

data class GetResponse(
    val code: String,
    val description: String,
    val data: User?
)