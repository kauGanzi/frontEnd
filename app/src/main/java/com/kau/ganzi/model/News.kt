package com.kau.ganzi.model

class News {
    var id: Long = 0
    var title: String = ""
    var content: String = ""

    constructor() {}
    constructor(id: Long, title: String, content: String) {
        this.id = id
        this.title = title
        this.content = content
    }

    fun getTitle() : String {
        return title
    }

    fun getContent() : String {
        return content
    }
}