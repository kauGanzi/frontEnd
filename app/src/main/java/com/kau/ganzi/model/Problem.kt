package com.kau.ganzi.model

class Problem {
    var id: Long = 0
    var question: String = ""
    var choices: Array<String> = Array(4) { ""}
    var correctAnswer: Int = 0

    constructor()

    constructor(id: Long, question: String, choices: Array<String>, correctAnswer: Int) {
        this.id = id
        this.question = question
        this.choices = choices
        this.correctAnswer = correctAnswer
    }
}