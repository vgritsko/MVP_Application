package com.test.mvpapplication.data.repository

import com.test.mvpapplication.data.model.User


class UserRepository : LoginRepository {
    private  var user: User? = null

    override fun getUser(): User {
        return if (user == null) {
            User("Vadim", "Gritsko")
        } else {
           this.user!!
        }
    }

    override fun saveUser(user: User?) {
        var user: User? = user
        if (user == null) {
            user = getUser()
        }
        this.user = user
    }
}