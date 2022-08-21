package com.example.demo.feature.crud

import com.example.demo.feature.crud.models.CreateRequest
import com.example.demo.feature.crud.models.DeleteRequest
import com.example.demo.feature.crud.models.GetRequest
import com.example.demo.feature.crud.models.UpdateRequest
import com.example.demo.feature.crud.services.CrudService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.*

@Component
class CrudHandler(
    private val crudService: CrudService
) {
    suspend fun get(request: ServerRequest) = request.awaitBody<GetRequest>()
        .let {
            ServerResponse.ok().json().bodyValueAndAwait(crudService.get(it))
        }

    suspend fun create(request: ServerRequest) = request.awaitBody<CreateRequest>()
        .let {
            ServerResponse.ok().json().bodyValueAndAwait(crudService.create(it))
        }

    suspend fun update(request: ServerRequest) = request.awaitBody<UpdateRequest>()
        .let {
            ServerResponse.ok().json().bodyValueAndAwait(crudService.update(it))
        }

    suspend fun delete(request: ServerRequest) = request.awaitBody<DeleteRequest>()
        .let {
            ServerResponse.ok().json().bodyValueAndAwait(crudService.delete(it))
        }

    suspend fun getAll(request: ServerRequest) = ServerResponse.ok().json().bodyValueAndAwait(crudService.getAll())
}