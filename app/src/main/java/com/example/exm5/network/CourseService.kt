package com.example.exm5.network

import com.example.exm5.model.Courses
import retrofit2.Response
import retrofit2.http.GET

interface CourseService {
    @GET("83160a49-fe85-46ba-bcf8-3cf5aa09f92b")
    suspend fun getCourses() : Response<Courses>
}