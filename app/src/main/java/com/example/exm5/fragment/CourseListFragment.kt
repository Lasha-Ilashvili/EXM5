package com.example.exm5.fragment

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.exm5.adapter.CourseListAdapter
import com.example.exm5.base.BaseFragment
import com.example.exm5.databinding.FragmentCourseListBinding
import com.example.exm5.resource.ResultResponse
import com.example.exm5.view_model.CourseViewModel
import kotlinx.coroutines.launch

class CourseListFragment :
    BaseFragment<FragmentCourseListBinding>(FragmentCourseListBinding::inflate) {

    private val courseViewModel: CourseViewModel by viewModels()


    override fun observe() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                courseViewModel.courseResult.collect { result ->
                    when (result) {
                        is ResultResponse.Success -> {
                            binding.rvParent.adapter = CourseListAdapter().apply {
                                setCourseData(result.course.allCourses)
                            }
                        }

                        is ResultResponse.Error -> {
                            Toast.makeText(requireContext(), result.error, Toast.LENGTH_SHORT)
                                .show()
                        }

                        else -> {
                        }
                    }
                }
            }
        }
    }
}