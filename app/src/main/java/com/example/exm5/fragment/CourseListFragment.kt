package com.example.exm5.fragment

import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
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
            courseViewModel.courseResult.collect { result ->

                val progressBar = binding.progressBar
                progressBar.visibility = View.VISIBLE

                when (result) {
                    is ResultResponse.Success -> {
                        progressBar.visibility = View.GONE
                        binding.rvParent.adapter = CourseListAdapter().apply {
                            setCourseData(result.course.allCourses)
                        }
                    }

                    is ResultResponse.Error -> {
                        progressBar.visibility = View.GONE
                        Toast.makeText(requireContext(), result.error, Toast.LENGTH_SHORT)
                            .show()
                    }

                    else -> {
                        progressBar.visibility = View.VISIBLE
                    }
                }
            }
        }
    }
}