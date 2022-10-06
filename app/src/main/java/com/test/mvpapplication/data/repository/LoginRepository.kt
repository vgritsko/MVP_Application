package com.test.mvpapplication.data.repository

import com.test.mvpapplication.data.model.User


interface LoginRepository {
    fun getUser () :User

    fun saveUser(user: User?)
}