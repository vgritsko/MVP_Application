package com.test.mvpapplication.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.mvpapplication.data.model.User
import com.test.mvpapplication.data.repository.LoginRepository

class LoginViewModel(private val repository: LoginRepository) : ViewModel() {
    private val _users = MutableLiveData<User>()
    val users: LiveData<User>
        get() = _users

    fun getUser() {
        _users.value = repository.getUser()
    }

    fun saveUser(user: User) {
        repository.saveUser(user)
    }
}