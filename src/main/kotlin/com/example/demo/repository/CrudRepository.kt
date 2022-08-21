package com.example.demo.repository

import com.example.demo.entities.User
import com.example.demo.feature.crud.models.CreateRequest
import com.example.demo.feature.crud.models.DeleteRequest
import com.example.demo.feature.crud.models.GetRequest
import com.example.demo.feature.crud.models.UpdateRequest
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.reactive.awaitFirstOrNull
import org.springframework.data.r2dbc.core.*
import org.springframework.data.relational.core.query.Criteria
import org.springframework.data.relational.core.query.Query
import org.springframework.data.relational.core.query.Update

import org.springframework.stereotype.Repository

@Repository
class CrudRepository(
    private val r2dbcEntityTemplate: R2dbcEntityTemplate,
) {

    suspend fun get(request: GetRequest) =
        r2dbcEntityTemplate.runCatching {
            select(
                Query.query(Criteria.where(User::id.name).`is`(request.id)),
                User::class.java
            ).awaitFirstOrNull()
        }.onFailure {
            println("select database user by id error cause: ${it.message}")
        }.getOrThrow()

    suspend fun create(request: CreateRequest) =
        r2dbcEntityTemplate.runCatching {
            insert(User::class.java)
                .into("USER")
                .usingAndAwait(User(
                    request.id,
                    request.name,
                    request.mobile,
                    request.email
                ))
        }.onFailure {
            println("create database user by id error cause: ${it.message}")
        }.getOrThrow()

    suspend fun update(request: UpdateRequest) =
        r2dbcEntityTemplate.runCatching {
            update(User::class.java)
                .matching(
                    Query.query(
                        Criteria.where(User::id.name).`is`(request.id)
                    )
                )
                .applyAndAwait(
                    Update.update(User::name.name, request.name)
                        .set(User::mobile.name, request.mobile)
                        .set(User::email.name, request.email)
                )
        }.onFailure {
            println("update database user by id error cause: ${it.message}")
        }.getOrThrow()

    suspend fun delete(request: DeleteRequest) =
        r2dbcEntityTemplate.runCatching {
            delete(User::class.java)
                .matching(
                    Query.query(
                        Criteria.where(User::id.name).`is`(request.id)
                    )
                ).allAndAwait()
        }.onFailure {
            println("delete database user by id error cause: ${it.message}")
        }.getOrThrow()

    suspend fun getAll() =
        r2dbcEntityTemplate.runCatching {
            select(User::class.java).flow().toList()
        }.onFailure {
            println("select database user by id error cause: ${it.message}")
        }.getOrThrow()
}