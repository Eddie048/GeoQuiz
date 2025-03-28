package com.bignerdranch.android.geoquiz

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bignerdranch.android.geoquiz.databinding.ActivityQuestionListBinding

class QuestionListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuestionListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up RecyclerView with a linear layout and adapter
        binding.questionRecyclerView?.layoutManager = LinearLayoutManager(this)

        val questions = getQuestions()
        val adapter = QuestionAdapter(questions) { position ->
            // When an item is clicked, launch the detail activity.
            val intent = Intent(this, QuestionDetailActivity::class.java)
            intent.putExtra("QUESTION_INDEX", position)
            startActivity(intent)
        }
        binding.questionRecyclerView?.adapter = adapter
    }

    private fun getQuestions(): List<Question> {
        // Replicate your question bank
        return listOf(
            Question(R.string.question_australia, true),
            Question(R.string.question_oceans, true),
            Question(R.string.question_mideast, false),
            Question(R.string.question_africa, false),
            Question(R.string.question_americas, true),
            Question(R.string.question_asia, true)
        )
    }
}
