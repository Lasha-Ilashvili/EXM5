package com.example.exm5.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exm5.model.Courses
import com.example.exm5.network.ApiClient
import com.example.exm5.resource.ResultResponse
import com.squareup.moshi.Moshi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import okio.IOException

class CourseViewModel : ViewModel() {

    private val _courseResult = MutableStateFlow<ResultResponse<Courses>?>(null)
    val courseResult get() = _courseResult.asStateFlow()

    init {
        setInitialList()
    }

    private fun setInitialList() {
        viewModelScope.launch {
            try {
                val response = ApiClient.courseService().getCourses()

                if (response.isSuccessful) {
                    _courseResult.value = ResultResponse.Success(response.body()!!)
                } else {
                    val r = response.errorBody().toString()
                    val moshi = Moshi.Builder().build()
                    val adapter = moshi.adapter(String::class.java)

                    _courseResult.value =
                        ResultResponse.Error("Failed to fetch chats ${adapter.fromJson(r)!!}")
                }

            } catch (e: IOException) {
                _courseResult.value = ResultResponse.Error("Network error: ${e.message}")
            }
        }
    }
}