package com.example.youssef_echady_sfaxi

object Constants {

    const val TOTAL_QUESTIONS: String = "total_questions"
    const val  CORRECT_ANSWERS: String = "correct_answers"
    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        // 1
        val que1 = Question(
            1, "What country does this flag belong to?",
            R.drawable.gambia,
            "Gambia", "Tunisia",
            "Turkey", "Algeria", 1
        )

        questionsList.add(que1)

        // 2
        val que2 = Question(
            2, "What country does this flag belong to?",
            R.drawable.ethiopia,
            "Angola", "Austria",
            "Ethiopia", "Armenia", 3
        )

        questionsList.add(que2)

        // 3
        val que3 = Question(
            3, "What country does this flag belong to?",
            R.drawable.brazil,
            "Belarus", "Belize",
            "Brunei", "Brazil", 4
        )

        questionsList.add(que3)

        // 4
        val que4 = Question(
            4, "What country does this flag belong to?",
            R.drawable.brunei,
            "Bahamas", "Brunei",
            "Barbados", "Belize", 2
        )

        questionsList.add(que4)

        // 5
        val que5 = Question(
            5, "What country does this flag belong to?",
            R.drawable.ireland,
            "Ireland", "France",
            "Paraguay", "Finland", 1
        )

        questionsList.add(que5)

        // 6
        val que6 = Question(
            6, "What country does this flag belong to?",
            R.drawable.nigeria,
            "Nigeria", "Georgia",
            "Greece", "none of these", 1
        )

        questionsList.add(que6)

        // 7
        val que7 = Question(
            7, "What country does this flag belong to?",
            R.drawable.mozambique,
            "Dominica", "Egypt",
            "Mozambique", "Ethiopia", 3
        )

        questionsList.add(que7)

        // 8
        val que8 = Question(
            8, "What country does this flag belong to?",
            R.drawable.singapore,
            "Ireland", "Iran",
            "Hungary", "Singapore", 4
        )

        questionsList.add(que8)

        // 9
        val que9 = Question(
            9, "What country does this flag belong to?",
            R.drawable.paraguay,
            "Australia", "Paraguay",
            "Tuvalu", "United States of America", 2
        )

        questionsList.add(que9)

        //10
        val que10 = Question(
            10, "What country does this flag belong to?",
            R.drawable.russia,
            "Australia", "Paraguay",
            "Tuvalu", "Russia", 4
        )

        //11
        val que11 = Question(
            11, "What country does this flag belong to?",
            R.drawable.suriname,
            "Australia", "Suriname",
            "Tuvalu", "Saudi Arabia", 2

        )

        //12
        val que12 = Question(
            12, "What country does this flag belong to?",
            R.drawable.cambodia,
            "Sudan", "Cambodia",
            "Chad", "Libya", 1
        )

        //13
        val que13 = Question(
            13, "What country does this flag belong to?",
            R.drawable.eswatini,
            "Angola", "Egypt",
            "Eswatini", "Ethiopia", 3
        )

        //14
        val que14 = Question(
            14, "What country does this flag belong to?",
            R.drawable.tunisia,
            "Tunisia", "Turkey",
            "Eswatini", "Ethiopia", 1
        )

        return questionsList
    }
}