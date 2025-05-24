package com.kau.ganzi.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.kau.ganzi.model.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class LoginViewModel : ViewModel() {
    private val _loginResult = MutableLiveData<String?>(null)
    val loginResult: LiveData<String?> get() = _loginResult

    fun login(id: String, pw: String) {
        viewModelScope.launch {
         val result = withContext(Dispatchers.IO) {
             UserRepository.login(id, pw)
            }

            _loginResult.value = result
        }
    }
}