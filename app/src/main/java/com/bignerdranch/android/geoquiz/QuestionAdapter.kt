package com.bignerdranch.android.geoquiz

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class QuestionAdapter(
    private val questions: List<Question>,
    private val itemClickListener: (Int) -> Unit
) : RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder>() {

    inner class QuestionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val questionTextView: TextView = itemView.findViewById(R.id.question_text_view)

        init {
            itemView.setOnClickListener {
                // Use adapterPosition to determine which item was clicked
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    itemClickListener(position)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_question, parent, false)
        return QuestionViewHolder(view)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        val question = questions[position]
        // Using setText with resource id automatically displays the string from resources
        holder.questionTextView.setText(question.textResId)
    }

    override fun getItemCount(): Int = questions.size
}
