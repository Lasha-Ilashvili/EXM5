package com.example.exm5.adapter

import android.view.LayoutInflater.from
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exm5.databinding.ActiveCourseItemBinding
import com.example.exm5.model.Course

class ActiveCourseItemAdapter:
    RecyclerView.Adapter<ActiveCourseItemAdapter.ActiveCourseItemViewHolder>() {

    private lateinit var currentActiveList: List<Course>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActiveCourseItemViewHolder {
        return ActiveCourseItemViewHolder(
            ActiveCourseItemBinding.inflate(
                from(parent.context),
                parent,
                false
            )
        )
    }

    fun setActiveCourseData(newList: List<Course>) {
        currentActiveList = newList
    }

    override fun getItemCount(): Int = currentActiveList.size

    override fun onBindViewHolder(holder: ActiveCourseItemViewHolder, position: Int) {
        holder.bind()
    }

    inner class ActiveCourseItemViewHolder(private val binding: ActiveCourseItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val course = currentActiveList[adapterPosition]

            with(binding) {
                tvActiveCourse.text = course.title
            }
        }
    }
}