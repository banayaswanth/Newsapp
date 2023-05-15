package com.example.etpproject_newsapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class loginscreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginscreen)
        val register = findViewById<TextView>(R.id.register)
        val loginButton = findViewById<Button>(R.id.btnLogin)
        val userEditText = findViewById<EditText>(R.id.edtUserName)
        val passwordEditText = findViewById<EditText>(R.id.edtPassword)
        register.setOnClickListener {
            val i = Intent(this,Registeractivity::class.java)
            startActivity(i)
        }

//        var tt=findViewById<TextView>(R.id.text3)
        loginButton.setOnClickListener {
            val sharedPreferences = getSharedPreferences("UserData", Context.MODE_PRIVATE)
            val storedName=sharedPreferences.getString("Name","")
            val storedEmail = sharedPreferences.getString("Email", "")
            val storedPassword = sharedPreferences.getString("Password", "")

            val enteredData = userEditText.text.toString().trim()
            val enteredPassword = passwordEditText.text.toString().trim()

            if ((enteredData == storedEmail || enteredData == storedName) && enteredPassword == storedPassword) {
                // Credentials are correct
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                // Credentials are incorrect
                Toast.makeText(this, "Enter The correct Credentials", Toast.LENGTH_SHORT).show()
            }
        }
    }
}