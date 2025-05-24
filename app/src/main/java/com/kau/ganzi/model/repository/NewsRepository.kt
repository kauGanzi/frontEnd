package com.kau.ganzi.model.repository

import com.kau.ganzi.model.News

object NewsRepository {
    val newses: ArrayList<News> = ArrayList()

    init {
        newses.add(
            News(
                id = 1,
                title = "오늘의 건강 뉴스 1",
                content = "건강을 위한 최신 뉴스 내용입니다."
            )
        )

        newses.add(
            News(
                id = 2,
                title = "오늘의 건강 뉴스 2",
                content = "운동과 영양의 중요성에 대한 소식입니다."
            )
        )

        newses.add(
            News(
                id = 3,
                title = "오늘의 건강 뉴스 3",
                content = "정신 건강 관리에 대한 새로운 연구 결과를 소개합니다."
            )
        )
    }
}
