package com.example.exm5.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.toColorInt
import androidx.recyclerview.widget.RecyclerView
import com.example.exm5.R
import com.example.exm5.databinding.NewCourseItemBinding
import com.example.exm5.model.Course

class NewCourseItemAdapter : RecyclerView.Adapter<NewCourseItemAdapter.NewCourseItemViewHolder>() {

    private lateinit var currentNewList: List<Course>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewCourseItemViewHolder {
        return NewCourseItemViewHolder(
            NewCourseItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    fun setNewCourseData(newList: List<Course>) {
        currentNewList = newList
    }

    override fun getItemCount(): Int = currentNewList.size

    override fun onBindViewHolder(holder: NewCourseItemViewHolder, position: Int) {
        holder.bind()
    }

    inner class NewCourseItemViewHolder(private val binding: NewCourseItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val course = currentNewList[adapterPosition]
            val mainColor = "#${course.mainColor}".toColorInt()

            with(binding) {
                root.background.setTint(mainColor)
                ivNewCourseIconType.setImageResource(getImage(course.iconType))
                tvNewCourseTitle.text = course.title
                tvNewCourseQuestion.text = course.question
                tvNewCourseDuration.text = course.duration
                ivNewCoursePlayIcon.setColorFilter(mainColor)
            }
        }

        private fun getImage(iconType: String?): Int {
            return when (iconType!!) {
                "settings" -> R.drawable.ic_settings
                else -> R.drawable.ic_card
            }
        }
    }
}