package com.test.mvpapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.test.mvpapplication.ViewModel.LoginViewModel
import com.test.mvpapplication.data.model.User
import com.test.mvpapplication.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity(), LoginActivityMVP.View {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var firstNameEditText: EditText
    private lateinit var lastNameEditText: EditText
    private lateinit var loginButton: Button
    private val loginViewModel by viewModels<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        firstNameEditText = binding.firstNameEditText
        lastNameEditText = binding.lastNameEditText
        loginButton = binding.loginButton
        loginButton.setOnClickListener { loginViewModel.saveUser(User(getFirstName(),getLastName())) }

        loginViewModel.users.observe(this, Observer {
            if (it != null) {
                setFirstName(it.firstName)
                setLastName(it.lastName)
            }
        })
    }

    override fun onResume() {
        super.onResume()

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