package com.kau.ganzi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kau.ganzi.model.News
import com.kau.ganzi.model.repository.NewsRepository

class NewsViewModel : ViewModel() {
    private val _news = MutableLiveData<News?>(null)
    val news: LiveData<News?> get() = _news

    fun getNews(id: Long): News? {
        val news = NewsRepository.newses.find { it.id.toLong() == id}

        _news.value = news

        return news
    }
}