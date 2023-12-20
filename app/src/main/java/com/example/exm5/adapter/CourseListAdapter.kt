package com.example.exm5.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exm5.databinding.ActiveCourseListBinding
import com.example.exm5.databinding.NewCourseListBinding
import com.example.exm5.databinding.TitleItemBinding
import com.example.exm5.model.Course

class CourseListAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private lateinit var currentCourseList: List<List<Course>>

    private companion object {
        const val TITLE = 0
        const val NEW_COURSE = 1
        const val ACTIVE_COURSE = 2
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            1 -> NEW_COURSE
            2 -> ACTIVE_COURSE
            else -> TITLE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            NEW_COURSE -> NewCourseViewHolder(
                NewCourseListBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            ACTIVE_COURSE -> ActiveCourseViewHolder(
                ActiveCourseListBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            else -> TitleViewHolder(
                TitleItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is NewCourseViewHolder -> holder.bind()
            is ActiveCourseViewHolder -> holder.bind()
        }
    }

    fun setCourseData(newList: List<List<Course>>) {
        currentCourseList = newList
    }

    override fun getItemCount(): Int = currentCourseList.size

    inner class TitleViewHolder(private val titleItemBinding: TitleItemBinding) :
        RecyclerView.ViewHolder(titleItemBinding.root)

    inner class NewCourseViewHolder(private val newCourseBinding: NewCourseListBinding) :
        RecyclerView.ViewHolder(newCourseBinding.root) {

        fun bind() {
            val courses = currentCourseList[NEW_COURSE]

            with(newCourseBinding) {
                rvNewCourses.adapter = NewCourseItemAdapter().apply {
                    setNewCourseData(courses)
                }
            }
        }
    }

    inner class ActiveCourseViewHolder(private val activeCourseBinding: ActiveCourseListBinding) :
        RecyclerView.ViewHolder(activeCourseBinding.root) {

        fun bind() {
            val courses = currentCourseList[ACTIVE_COURSE]

            with(activeCourseBinding) {
                rvActiveCourses.adapter = ActiveCourseItemAdapter().apply {
                    setActiveCourseData(courses)
                }
            }
        }
    }
}