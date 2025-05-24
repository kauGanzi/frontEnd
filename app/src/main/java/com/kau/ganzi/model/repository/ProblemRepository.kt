package com.kau.ganzi.model.repository

import com.kau.ganzi.model.Problem

object ProblemRepository {
    var problem: Problem?

    init {
        problem = setProblem()

    }

    fun getProblem(): Problem? {
        return problem
    }

    fun setProblem(): Problem {

    }
}