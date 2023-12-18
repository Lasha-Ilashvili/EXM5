package com.example.exm5.resources

sealed class ResultResponse<T> {
    data class Success<T>(val token: T) : ResultResponse<T>()
    data class Error<T>(val error: String) : ResultResponse<T>()
}