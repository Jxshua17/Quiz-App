package com.example.quizapp.utils

import com.example.quizapp.R
import com.example.quizapp.model.Questions

object Constants{

    const val USERNAME = "name"
    const val TOTAL_QUESTIONS = "totalQuestions" //this is the key that is talking about the RHS
    const val SCORE = "score" //i am not sure anymore. lol

    fun getQuestions():MutableList<Questions>{ //the mutable list here serves the function of defining what it to returned.
        val questions = mutableListOf<Questions>()

        val quest1 = Questions(
            1,
            "what country is this?",
            R.drawable.argentina_flag,
            "Argentina",
            "Spain",
            "Nigeria",
            "Canada",
            1
        )
        questions.add(quest1)

        val quest2 = Questions(
            2,
            "what country is this?",
            R.drawable.canada,
            "Argentina",
            "Spain",
            "Nigeria",
            "Canada",
            4
        )
        questions.add(quest2)

        val quest3 = Questions(
            3,
            "what country is this?",
            R.drawable.denmark,
            "Argentina",
            "Spain",
            "Denmark",
            "Canada",
            3
        )
        questions.add(quest3)

        val quest4 = Questions(
            4,
            "what country is this?",
            R.drawable.england_flag,
            "Argentina",
            "England",
            "Nigeria",
            "Canada",
            2
        )
        questions.add(quest4)

        val quest5 = Questions(
            5,
            "what country is this?",
            R.drawable.france_flag,
            "France",
            "Spain",
            "Nigeria",
            "Canada",
            1
        )
        questions.add(quest5)

        val quest6 = Questions(
            6,
            "what country is this?",
            R.drawable.germany_flag,
            "Argentina",
            "Spain",
            "Germany",
            "Canada",
            3
        )
        questions.add(quest6)

        val quest7 = Questions(
            7,
            "what country is this?",
            R.drawable.italy,
            "Argentina",
            "Italy",
            "Nigeria",
            "Canada",
            2
        )
        questions.add(quest7)

        val quest8 = Questions(
            8,
            "what country is this?",
            R.drawable.mexico,
            "Mexico",
            "Spain",
            "Nigeria",
            "Canada",
            1
        )
        questions.add(quest8)

        val quest9 = Questions(
            9,
            "what country is this?",
            R.drawable.nigerian_flag,
            "Argentina",
            "Spain",
            "Nigeria",
            "Canada",
            3
        )
        questions.add(quest9)

        val quest10 = Questions(
            10,
            "what country is this?",
            R.drawable.spain,
            "Argentina",
            "Spain",
            "Nigeria",
            "Canada",
            2
        )
        questions.add(quest10)

        return questions
    }
}