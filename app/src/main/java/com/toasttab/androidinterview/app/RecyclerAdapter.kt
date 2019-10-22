package com.toasttab.androidinterview.app

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.toasttab.androidinterview.R
import com.toasttab.androidinterview.universities.University


class RecyclerAdapter(private val universityNames: List<University>,
                      private val clickListener: (University) -> Unit) : RecyclerView.Adapter<RecyclerAdapter.UniversityViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UniversityViewHolder { // Inflates individually item views from their corresponding XML
        Log.d("Adapter", "OnCreateViewHolder")
        val universitiesRowItem = LayoutInflater.from(parent.context)
                .inflate(R.layout.universities_row_item, parent, false)

        return UniversityViewHolder(universitiesRowItem, clickListener)
    }

    override fun onBindViewHolder(holder: UniversityViewHolder, position: Int) { //Populates each item with data
        Log.d("Adapter", "onBindViewHolder for position $position")
        holder.bind(universityNames[position])
    }

    override fun getItemCount() = universityNames.size //Asks for the number of items that will be displayed

    class UniversityViewHolder(itemView: View, private val clickListener: (University) -> Unit) : RecyclerView.ViewHolder(itemView) {
        private val universityNameTextView: TextView = itemView.findViewById(R.id.university_name)
        private lateinit var universityName: University

        init {
            universityNameTextView.setOnClickListener { clickListener(universityName)}
        }

        fun bind(universityName: University){ //binds the text of the view to the textView associated with a single university
            universityNameTextView.text = universityName.name
            this.universityName = universityName //this is referring to private lateinit var universityName: University and universityName is (universityName: University)
        }
    }
}
