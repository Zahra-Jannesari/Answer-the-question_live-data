package com.example.AnswerIt_LiveData

object QuestionRepository {
    val questionList = arrayListOf(
        Question(" result of 2 + 2 ","4",false),
        Question(" result of  5 - 2 ","3",false),
        Question(" result of 3 * 4","12",false),
        Question(" result of 10 % 2","0",false),
        Question(" result of 3 * 5","15",false)
    )
}
data class Question(var questionText:String,var questionAnswer:String,var isAnswered:Boolean){
}