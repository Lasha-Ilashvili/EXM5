package com.example.exm5.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Courses(
    @Json(name = "new_courses") val newCourses: List<Course>,
    @Json(name = "active_courses") val activeCourses: List<Course>
) {
    val allCourses = listOf(listOf(Course(title = "Course")), newCourses, activeCourses)
}