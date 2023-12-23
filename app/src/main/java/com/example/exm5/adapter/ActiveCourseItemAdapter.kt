package com.example.exm5.adapter

import android.graphics.Color
import android.view.LayoutInflater.from
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.exm5.databinding.ActiveCourseItemBinding
import com.example.exm5.model.Course

class ActiveCourseItemAdapter :
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

            val mainColor = Color.parseColor("#${course.mainColor}")
            val backgroundColorInt = getColor(mainColor, course.backgroundColorPresent!!)
            val playButtonColor = getColor(mainColor, course.playButtonColorPresent!!)

            with(binding) {
                root.background.setTint(backgroundColorInt)
                ivActiveCoursePlayIcon.background.setTint(playButtonColor)
                ivActiveCoursePlayIcon.setColorFilter(mainColor)
                piActiveCoursePlayIcon.setIndicatorColor(mainColor)
                piActiveCoursePlayIcon.progress = course.progress!!.toInt()
                tvActiveCourseTitle.text = course.title
                tvActiveCourseTitle.setTextColor(mainColor)
                tvActiveCourseBookingTime.text = course.bookingTime
                tvActiveCourseBookingTime.setTextColor(mainColor)
                ivActiveCoursePfp.background.setTint(mainColor)

                Glide.with(itemView.context)
                    .load(course.image)
                    .into(ivActiveCoursePfp)
            }
        }

        private fun getColor(mainColor: Int, backgroundColor: String): Int {
            return Color.argb(
                backgroundColor.toInt(),
                Color.red(mainColor),
                Color.green(mainColor),
                Color.blue(mainColor)
            )
        }
    }
}