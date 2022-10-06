package com.test.mvpapplication.presenter

import com.test.mvpapplication.LoginActivityMVP
import com.test.mvpapplication.LoginActivityMVP.Presenter


class LoginActivityPresenter(private val model: LoginActivityMVP.Model) :
    Presenter {

    private var view: LoginActivityMVP.View? = null
    override fun setView(view: LoginActivityMVP.View) {
        this.view = view
    }

    override fun loginButtonClicked() {
        if (view != null) {
            if (view!!.getFirstName().trim { it <= ' ' } == "" || view!!.getLastName().trim { it <= ' ' } == "") {
                view!!.showInputError()
            } else {
                model.createUser(view!!.getFirstName(), view!!.getLastName())
                view!!.showUserSavedMessage()
            }
        }
    }

    override fun getCurrentUser() {
        val user = model.getUser()
        if (user != null) {
            if (view != null) {
                view!!.setFirstName(user.firstName)
                view!!.setLastName(user.lastName)
            }
        }
    }
}