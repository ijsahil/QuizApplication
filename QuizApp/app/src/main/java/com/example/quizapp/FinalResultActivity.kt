package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FinalResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_result)
        val totalScore = intent.getIntExtra(Constants.CORRECT_ANSWER , 0)
        val totalQuestions  =  intent.getIntExtra(Constants.TOTAL_QUESTIONS , 0)
        var displayName: TextView = findViewById(R.id.displayName)
        var displayScore: TextView = findViewById(R.id.displayScore)
        var finishBtn : Button = findViewById(R.id.btnFinish)
        displayName.text = intent.getStringExtra(Constants.USER_NAME)
        displayScore.text = "Your Score is $totalScore out of $totalQuestions"
        finishBtn.setOnClickListener{
            val intent = Intent(this , MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}