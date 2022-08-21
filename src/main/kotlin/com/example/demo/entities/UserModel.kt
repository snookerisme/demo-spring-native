package com.example.demo.entities

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("USER")
data class User(
    @Id
    val id : String,
    val name : String,
    val mobile : String,
    val email : String
)