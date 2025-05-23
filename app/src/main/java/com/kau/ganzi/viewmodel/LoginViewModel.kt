package com.example.checkid.viewmodel

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

class LoginViewModel(context: Context) : ViewModel() {
    private val _loginResult = MutableLiveData<Boolean?>(null)
    val loginResult: LiveData<Boolean?> get() = _loginResult

    fun login(context: Context, id: String, password: String) {
        UserRepository.login()
    }
}

class LoginViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(context) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class : ${modelClass.name}")
    }
}