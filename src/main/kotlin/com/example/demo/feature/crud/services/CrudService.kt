package com.example.demo.feature.crud.services

import com.example.demo.commons.Status.SUCCESS
import com.example.demo.feature.crud.models.*
import com.example.demo.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
class CrudService(
    private val crudRepository: CrudRepository
) {

    suspend fun get(request: GetRequest): GetResponse {
        val data = crudRepository.get(request)
        return GetResponse(
            SUCCESS,
            "Get success",
            data
        )
    }

    suspend fun create(request: CreateRequest): CreateResponse {
        crudRepository.create(request)
        return CreateResponse(
            SUCCESS,
            "Create success",
        )
    }

    suspend fun update(request: UpdateRequest): UpdateResponse {
        crudRepository.update(request)
        return UpdateResponse(
            SUCCESS,
            "Update success",
        )
    }

    suspend fun delete(request: DeleteRequest): DeleteResponse {
        crudRepository.delete(request)
        return DeleteResponse(
            SUCCESS,
            "Delete success",
        )
    }

    suspend fun getAll(): GetAllResponse {
        val data = crudRepository.getAll()
        return GetAllResponse(
            SUCCESS,
            "Get all success",
            data
        )
    }
}