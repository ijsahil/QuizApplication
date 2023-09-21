package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {
    private var correctAnswers: Int = 0
    private var userName: String? = null

    private var currentPosition: Int = 1
    private var selectedOption: Int = 0
    private var questionList: ArrayList<Question>? = null

    private var progressBar: ProgressBar? = null
    private var tvProgressBar: TextView? = null


    private var imageView: ImageView? = null
    private var submitBtn: Button? = null
    var questionView: TextView? = null

    private var optionOne: TextView? = null
    private var optionTwo: TextView? = null
    private var optionThree: TextView? = null
    private var optionFour: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        progressBar = findViewById(R.id.progressBarId)
        tvProgressBar = findViewById(R.id.progressBarTv)
        imageView = findViewById(R.id.imageViewId)
        submitBtn = findViewById(R.id.submit_btn)
        optionOne = findViewById(R.id.optionOneId)
        optionTwo = findViewById(R.id.optionTwoId)
        optionThree = findViewById(R.id.optionThreeId)
        optionFour = findViewById(R.id.optionFourId)
        questionView = findViewById(R.id.questionViewId)
        questionList = Constants.getQuestions()

        optionOne?.setOnClickListener(this)
        optionTwo?.setOnClickListener(this)
        optionThree?.setOnClickListener(this)
        optionFour?.setOnClickListener(this)
        submitBtn?.setOnClickListener(this)
        setQuestions()

        userName = intent.getStringExtra(Constants.USER_NAME)
    }

    private fun setQuestions() {
        defaultOptionView()
        var question: Question = questionList!![currentPosition - 1]
        progressBar?.progress = currentPosition
        tvProgressBar?.text = "$currentPosition/${progressBar?.max}"
        questionView?.text = question.Question
        imageView?.setImageResource(question.img)
        optionOne?.text = question.optionOne
        optionTwo?.text = question.optionTwo
        optionThree?.text = question.optionThree
        optionFour?.text = question.optionFour

        if (currentPosition == questionList!!.size + 1) {
            submitBtn?.text = "FINISH"
        } else {
            submitBtn?.text = "SUBMIT"
        }
    }

    private fun defaultOptionView() {
        val options = ArrayList<TextView>()
        optionOne?.let {
            options.add(0, it)
        }
        optionTwo?.let {
            options.add(1, it)
        }
        optionThree?.let {
            options.add(2, it)
        }
        optionFour?.let {
            options.add(3, it)
        }

        for (option in options) {
            option.setTextColor(Color.parseColor("#2A9D8F"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }
    }


    private fun selectedOptionView(tv: TextView, option: Int) {
        defaultOptionView()
        selectedOption = option
        tv.setTextColor(Color.parseColor("#2A9D8F"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)

    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.optionOneId -> optionOne?.let {
                selectedOptionView(it, 1)
            }

            R.id.optionTwoId -> optionTwo?.let {
                selectedOptionView(it, 2)
            }

            R.id.optionThreeId -> optionThree?.let {
                selectedOptionView(it, 3)
            }

            R.id.optionFourId -> optionFour?.let {
                selectedOptionView(it, 4)
            }

            R.id.submit_btn -> submitBtn?.let {
                if (selectedOption == 0) {
                    currentPosition++
                    when {
                        currentPosition <= questionList!!.size ->
                            setQuestions()

                        else -> {
                            val intent = Intent(this, FinalResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, userName)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, questionList!!.size)
                            intent.putExtra(Constants.CORRECT_ANSWER, correctAnswers)
                            startActivity(intent)
                            finish()
                        }
                    }
                } else {
                    var question = questionList?.get(currentPosition - 1)
                    if (question!!.correctAnswer != selectedOption) {
                        answerView(selectedOption, R.drawable.wrong_option_bg)
                    } else {
                        correctAnswers++
                    }
                    answerView(question!!.correctAnswer, R.drawable.correct_option_bg)
                    if (currentPosition == questionList?.size) {
                        submitBtn?.text = "FINISH"
                    } else {
                        submitBtn?.text = "Go to next question"
                    }
                    selectedOption = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawable: Int) {
        when (answer) {
            1 -> optionOne?.background = ContextCompat.getDrawable(this, drawable)
            2 -> optionTwo?.background = ContextCompat.getDrawable(this, drawable)
            3 -> optionThree?.background = ContextCompat.getDrawable(this, drawable)
            4 -> optionFour?.background = ContextCompat.getDrawable(this, drawable)
        }
    }
}