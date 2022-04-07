package com.example.livedata1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel  : ViewModel(){

    //var number = 0
    val numberLiveData = MutableLiveData<Int>(1)

    val questionLiveData = MutableLiveData<String>(
        QuestionRepository.questionList[0]
    )

    val questionCount = QuestionRepository.questionList.size

    var nextEnabledLiveData = MutableLiveData<Boolean>(true)
    var prevEnabledLiveData = MutableLiveData<Boolean>(false)
    fun nextClicked() {
        numberLiveData.value = numberLiveData.value?.plus(1)
        numberLiveData.value?.let{ number ->
            questionLiveData.value = QuestionRepository.questionList[number-1]
        }
    }

    fun prevClicked() {
        numberLiveData.value = numberLiveData.value?.minus(1)
        numberLiveData.value?.let{ number ->
            questionLiveData.value = QuestionRepository.questionList[number-1]
        }
    }
    fun checkNextPrev(){
        nextEnabledLiveData.value=when(numberLiveData.value){
            questionCount->false
            else->true
        }
        prevEnabledLiveData.value=when(numberLiveData.value){
            1->false
            else->true
        }
    }


}