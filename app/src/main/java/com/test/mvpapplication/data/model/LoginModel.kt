package com.test.mvpapplication.data.model

import com.test.mvpapplication.LoginActivityMVP
import com.test.mvpapplication.data.repository.LoginRepository


class LoginModel(private val repository: LoginRepository) : LoginActivityMVP.Model {

    override fun createUser(name: String, lastName: String) =
        repository.saveUser(User(name, lastName))

    override fun getUser(): User {
        return repository.getUser()
    }


}