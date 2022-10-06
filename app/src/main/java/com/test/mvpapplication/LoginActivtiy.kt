package com.test.mvpapplication

import android.os.Bundle
import android.view.View

import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.test.mvpapplication.LoginActivityMVP.Presenter
import com.test.mvpapplication.data.model.LoginModel
import com.test.mvpapplication.data.repository.UserRepository
import com.test.mvpapplication.databinding.ActivityLoginBinding
import com.test.mvpapplication.presenter.LoginActivityPresenter


class LoginActivity : AppCompatActivity(), LoginActivityMVP.View {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var presenter: Presenter
    private lateinit var firstNameEditText: EditText
    private lateinit var lastNameEditText: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        presenter = LoginActivityPresenter(LoginModel(UserRepository()))
        firstNameEditText = binding.firstNameEditText
        lastNameEditText = binding.lastNameEditText
        loginButton =binding.loginButton
        loginButton.setOnClickListener { presenter!!.loginButtonClicked() }
    }

    override fun onResume() {
        super.onResume()
        presenter.setView(this)
        presenter.getCurrentUser()
    }

    override fun getFirstName(): String {
        return firstNameEditText.text.toString()
    }

    override fun getLastName(): String {
        return lastNameEditText.text.toString()
    }

    override fun showInputError() {
        Toast.makeText(this, "Текст не может быть пустым", Toast.LENGTH_SHORT).show()
    }

    override fun setFirstName(firstName: String?) {
       firstNameEditText.setText(firstName)
    }

    override fun setLastName(lastName: String?) {
       lastNameEditText.setText(lastName)
    }

    override fun showUserSavedMessage() {
        Toast.makeText(this, "Данные сохранены", Toast.LENGTH_SHORT).show()
    }
}