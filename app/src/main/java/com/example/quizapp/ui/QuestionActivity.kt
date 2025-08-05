package com.example.quizapp.ui

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.example.quizapp.R
import com.example.quizapp.model.Questions
import com.example.quizapp.utils.Constants
import kotlinx.coroutines.delay

//na the bastard wey dey give me wahala be this.

class QuestionActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var progressBar: ProgressBar
    private lateinit var textViewProgressBar: TextView
    private lateinit var flagImageView: ImageView

    private lateinit var optionOne: TextView
    private lateinit var optionTwo: TextView
    private lateinit var optionThree: TextView
    private lateinit var optionFour: TextView
    private lateinit var checkAnswer: Button
    private lateinit var nextButton: Button

    private var currentPosition = 1
    private lateinit var questionsList: MutableList<Questions>
    private var questionsCounter = 0

    private var selectedAnswer = 0
    private lateinit var currentQuestion:Questions
    private var answered = false
    private var x = 0
    private var y = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        progressBar = findViewById(R.id.progressBar)
        textViewProgressBar = findViewById(R.id.textViewProgress)
        flagImageView = findViewById(R.id.countryFlag)
        optionOne = findViewById(R.id.option11)
        optionTwo = findViewById(R.id.option22)
        optionThree = findViewById(R.id.option33)
        optionFour = findViewById(R.id.option44)
        checkAnswer = findViewById(R.id.checkAnswer)
        nextButton = findViewById(R.id.nextButton)

        questionsList = Constants.getQuestions()

        optionOne.setOnClickListener(this)
        optionTwo.setOnClickListener(this)
        optionThree.setOnClickListener(this)
        optionFour.setOnClickListener(this)

        checkAnswer.setOnClickListener(this)

        nextButton.setOnClickListener(this)

        //so the above basically does what it looks like which is connecting the object to the ui components

        setQuestions()

    }

    //this function resets just the colors and text style of the options.
    private fun resetOptions (){
        x = 0
        val option = mutableListOf<TextView>()
        option.add(optionOne) //this adds the element in the bracket to the list defined above.
        option.add(optionTwo)
        option.add(optionThree)
        option.add(optionFour)

        for(i in option){
            i.setTextColor(Color.GRAY)
            i.typeface = Typeface.DEFAULT
            i.setBackgroundResource(R.drawable.option_bg) //i prefer this to Alex's pick of contextCompact
        }

    }


    //the setQuestions function is used to set the flag image and options for a particular question by fetching it from the app constants file
    private fun setQuestions (){ //remember that indexes always start with zero

        //i am starting to understand the structure of the code a lil better now. i think i should have just stuck it out instead.
        //there a few things i would have to look into to get a better understanding of the overall code but that would only happen with...
        //...actually revising rigorously through my notes. it is the only way up atp.
        //i talk about obsession and getting better, well this is what it comes down to. doing what you don't want to do at all.
        //find some way to actually revise through your notes thoroughly as well continuing down the course path.
        //funny how this might make it to my github, the notes in all of my code.
        // i think i should write where i am in my journey towards becoming an android engineer when next month officially starts and then write about how much...
        //...i would have accomplished when august ends. noting down how long has been spent learning so far.


        //the below code does a very simple job which is just to check if we gotten to the very last page of the app and what should be displayed in one of the buttons.

        //private var questionsCounter = 0
        if(questionsCounter < questionsList.size){ //currentPosition would always be less than the size of the question because it doesn't increment at all.
            checkAnswer.text = getString(R.string.checkButton)
            currentQuestion = questionsList[questionsCounter]

            resetOptions()
            val question = questionsList[questionsCounter]
            progressBar.progress = questionsCounter
            flagImageView.setImageResource(question.image)
            textViewProgressBar.text = "${questionsCounter + 1}/${progressBar.max}"
            optionOne.text = question.optionOne
            optionTwo.text = question.optionTwo
            optionThree.text = question.optionThree
            optionFour.text = question.optionFour

        } else {
            nextButton.text = getString(R.string.finish)
            //the final activity gets started here
            Intent(this, FinalActivity::class.java).also {
                startActivity(it)
                finish()
                //in the video, alex just put in 'this' without putting the activity so i am going to run it just to see.
            }
        }

        x = 0
        y = 0
        questionsCounter++
        answered = false

        //finally, i can say i understand the whole structure of the code now. it was very confusing at first.
    }

    //i think the thing that was giving me serious issues was the confusion around functions which i can say i understand a fair bit now.
    //when i wanted to attempt building it on my own, i thought the whole backend would just go one straight way like that...
    //...not once did the concept of functions enter my head.

    //now, i have to write two functions. one which resets the options once they have been selected and the other which sets the  background of the selected option.
    //it feels like there is something that is missing with regards to setting the background of a correct answer once the check answer button has been clicked.


    private fun selectedOption(textView: TextView, selAnswer:Int){ //this function has to take in arguments for the parameters i will define.
        resetOptions()

        //questionsCounter = selectedOption
        selectedAnswer = selAnswer

        textView.setTextColor(Color.GRAY)
        textView.typeface = Typeface.DEFAULT_BOLD
        textView.setBackgroundResource(R.drawable.option_bg)


    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.option11 -> {selectedOption(optionOne, 1)
                                x++}
            R.id.option22 -> {selectedOption(optionTwo, 2)
                                x++}
            R.id.option33 -> {selectedOption(optionThree, 3)
                                x++}
            R.id.option44 -> {selectedOption(optionFour, 4)
                                x++}

            R.id.checkAnswer -> {
                if (x==1){ //! x==1 , !answered
                    checkAns()
                } else if (x==0){
                    resetOptions()
                    selectedAnswer = 0
                    Toast.makeText(this@QuestionActivity, "please, select an option", Toast.LENGTH_SHORT).show()

                }
                y++
            }

            R.id.nextButton -> {
                if(y >= 1){
                    setQuestions()
                } else if (x==0){
                    resetOptions()
                    selectedAnswer = 0
                    Toast.makeText(this@QuestionActivity, "please, select an option", Toast.LENGTH_SHORT).show()
                    //implementation worked perfectly.
                } else if (y == 0){
                    Toast.makeText(this@QuestionActivity, "please, check your answer", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }

    private fun checkAns(){
        answered = true

        if (selectedAnswer == currentQuestion.correctAnswer){
            highlightAnswer(selectedAnswer)
            } else {
            when(selectedAnswer){
                1 -> {optionOne.setBackgroundResource(R.drawable.wrong_option_bg1)
                    optionOne.setTextColor(Color.WHITE)}
                2 -> {optionTwo.setBackgroundResource(R.drawable.wrong_option_bg1)
                    optionTwo.setTextColor(Color.WHITE)}
                3 -> {optionThree.setBackgroundResource(R.drawable.wrong_option_bg1)
                    optionThree.setTextColor(Color.WHITE)}
                4 -> {optionFour.setBackgroundResource(R.drawable.wrong_option_bg1)
                    optionFour.setTextColor(Color.WHITE)}
            }
            //i was wondering why i couldn't just get the right answers. the logic was okay, i just didn't reference the correct buttons.
            //so for such a stupid mistake, i am thinking of doing the rest on my own

            highlightAnswer(currentQuestion.correctAnswer)
            //i actually did it. i can't believe it. i just came up with this just from thinking alone.
            y++

        }

        //checkAnswer.text = getString(R.string.nextButton)


        //setQuestions()

        /*if (answered){
            checkAnswer.text = getString(R.string.nextButton)
        } else {
            Toast.makeText(this@QuestionActivity, "please, select an option", Toast.LENGTH_SHORT).show()
        }*/

    }

    private fun highlightAnswer(answer:Int){
        when(answer) {
            1 -> {
                optionOne.setBackgroundResource(R.drawable.correct_option_bg1)
                optionOne.setTextColor(Color.WHITE)
            }
            2 -> {
                optionTwo.setBackgroundResource(R.drawable.correct_option_bg1)
                optionTwo.setTextColor(Color.WHITE)
            }
            3 -> {
                optionThree.setBackgroundResource(R.drawable.correct_option_bg1)
                optionThree.setTextColor(Color.WHITE)
            }
            4 -> {
                optionFour.setBackgroundResource(R.drawable.correct_option_bg1)
                optionFour.setTextColor(Color.WHITE)
            }
        }
    }
    //we use private so that a particular function doesn't get called outside the class
}
