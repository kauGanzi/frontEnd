package com.kau.ganzi.model

class User {
    var id: String = ""
    var pw: String = ""
    var name: String = ""

    constructor()

    constructor(id: String, pw: String) {
        this.id = id
        this.pw = pw
    }
}