package com.kau.ganzi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kau.ganzi.model.Problem
import com.kau.ganzi.model.repository.ProblemRepository

class ProblemViewModel : ViewModel() {
    private val _problem : MutableLiveData<Problem?> = MutableLiveData<Problem?>(null)
    val problem: LiveData<Problem?> get() = _problem

    private val _isCorrect : MutableLiveData<Boolean?> = MutableLiveData<Boolean?>(null)
    val isCorrect: LiveData<Boolean?> get() = _isCorrect

    fun loadProblem(): Problem? {
        val problem = ProblemRepository.getProblem()
        _problem.value = problem

        return problem
    }

    fun checkAnswer(selectedNumber: Int): Boolean {
        val correctAnswer = ProblemRepository.getProblem()?.getCorrectAnswer()
        val result = (correctAnswer == selectedNumber)

        _isCorrect.value = result
        return result
    }
}