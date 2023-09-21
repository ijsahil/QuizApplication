package com.example.quizapp

object Constants {
    const val USER_NAME : String = "USER_NAME"
    const val CORRECT_ANSWER : String = "CORRECT_ANSWER"
    const val TOTAL_QUESTIONS : String = "TOTAL_QUESTIONS"

    fun getQuestions(): ArrayList<Question> {
        val questionList = arrayListOf<Question>()
        val que1 = Question(
            1,
            "Which football icon has earned the title Mr. Champions League ,played for clubs such as Manchester United, Real Madrid, and Juventus?",
            R.drawable.ronaldo,
            "Lionel Messi", " Cristiano Ronaldo", "Robert Lewandowski", "Andres Iniesta", 2
        )
        questionList.add(que1)
        val que2 = Question(2,"Which country won the FIFA World Cup in 2018?",R.drawable.que2,"Brazil","France","Spain","Argentina",2)
        questionList.add(que2)
        val que3 = Question(3,"Who is often referred to as The Goat of Football?",R.drawable.q3,"Lionel messi","Pele","Cristiano Ronaldo","Neymar jr",3)
        questionList.add(que3)
        val que4 = Question(4,"Which stadium is known as The Theatre of Dreams?",R.drawable.que4,"Camp Nou","Anfield","Old Trafford","Santiago Bernabeu",3)
        questionList.add(que4)
        val que5 = Question(5,"Which tournament is considered the most prestigious club competition in European football?",R.drawable.que5,"UEFA Champions League","FIFA Club World Cup","CONCACAF Gold Cup","Copa America",1)
        questionList.add(que5)
        val que6 = Question(6,"Which footballer is known as the Egyptian King ?",R.drawable.que6,"Mohamed Salah","Ahmed Musa","Hakim Ziyech","Riyad Mahrez",1)
        questionList.add(que6)
        val que7 = Question(7,"Which legendary coach is known for leading Barcelona to numerous successes, implementing the tiki-taka style of play?",R.drawable.que7,"Jose Mourinho","Arsene Wenger","Pep Guardiola","Jurgen Klopp",3)
        questionList.add(que7)
        val que8 = Question(8,"Who holds the record for the most goals scored in a single FIFA World Cup tournament?",R.drawable.que8,"Ronaldo","Miroslav Klose","Diego Maradona","Zinedine Zidane\n",2)
        questionList.add(que8)
        val que9 = Question(9,"Which club has won the most UEFA Champions League titles?",R.drawable.que9,"FC Barcelona","AC Milan","Real Madrid","Liverpool",3)
        questionList.add(que9)
        return questionList
    }
}