package com.example.exm5.resource

sealed class ResultResponse<T> {
    data class Success<T>(val course: T) : ResultResponse<T>()
    data class Error<T>(val error: String) : ResultResponse<T>()
}