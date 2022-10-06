package com.test.mvpapplication

import com.test.mvpapplication.data.model.User


interface LoginActivityMVP {
    interface View {
        fun getFirstName(): String
        fun getLastName(): String
        fun setFirstName(firstName: String?)
        fun setLastName(lastName: String?)

        fun showInputError()
        fun showUserSavedMessage()
    }

    interface Presenter {
        fun setView(view: View)
        fun loginButtonClicked()
        fun getCurrentUser()
    }

    interface Model {
        fun createUser(name: String, lastName: String)
        fun getUser(): User
    }
}