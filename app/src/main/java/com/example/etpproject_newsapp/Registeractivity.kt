package com.example.etpproject_newsapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Registeractivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registeractivity)
        var signup=findViewById<Button>(R.id.btnSignup)
        var name=findViewById<EditText>(R.id.edtUserName)
        var email=findViewById<EditText>(R.id.Email)
        var pwd=findViewById<EditText>(R.id.edtPassword)
        var cpwd=findViewById<EditText>(R.id.password)

        signup.setOnClickListener {

            if (name.text.toString().isEmpty() ||
                email.text.toString().isEmpty() ||
                pwd.text.toString().isEmpty() ||
                cpwd.text.toString().isEmpty()
            ) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {
                // Handle form submission
                val sharedPreferences = getSharedPreferences("UserData", Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString("Name", name.text.toString().trim())
                editor.putString("Email", email.text.toString().trim())
                editor.putString("Password", pwd.text.toString().trim())
                editor.apply()
                signup.setOnClickListener {
                    val intent = Intent(this, loginscreen::class.java)
                    startActivity(intent)
                }
            }

        }
    }
}