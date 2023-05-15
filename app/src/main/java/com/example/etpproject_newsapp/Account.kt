package com.example.etpproject_newsapp

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class Account : AppCompatActivity() {
    lateinit var bottomNav : BottomNavigationView
    private lateinit var cameraOpenId: ImageView
    lateinit var clickImageId: ImageView
    val pic_id = 123
    lateinit var newmail : EditText
    lateinit var newpass : EditText
    lateinit var save : Button
    lateinit var submit :Button
    lateinit var rbar : RatingBar
    lateinit var feedback : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)

        cameraOpenId = findViewById(R.id.camera)
        clickImageId = findViewById(R.id.click_image)
        save = findViewById(R.id.save)
        newmail = findViewById(R.id.Email)
        newpass = findViewById(R.id.edtPassword)
        submit = findViewById(R.id.submit)
        rbar = findViewById(R.id.rBar)
        feedback = findViewById(R.id.feedback)

        cameraOpenId.setOnClickListener(View.OnClickListener { v: View? ->
            // Create the camera_intent ACTION_IMAGE_CAPTURE it will open the camera for capture the image
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            // Start the activity with camera_intent, and request pic id
            startActivityForResult(cameraIntent, pic_id)
        })

        bottomNav = findViewById(R.id.bottomNav) as BottomNavigationView
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> {
                    val i = Intent(this,MainActivity::class.java)
                    startActivity(i)
                    true
                }
                R.id.account -> {
                    val i = Intent(this,Account::class.java)
                    startActivity(i)

                    true
                }
                else ->
                {
                    false
                }

            }
        }

        submit.setOnClickListener {
            if (rbar != null && feedback !=null)
                {
                    Toast.makeText(this,"Thank you for feedback",Toast.LENGTH_SHORT).show()
                }
                else
            {
                Toast.makeText(this,"Please fill all the details",Toast.LENGTH_SHORT).show()
            }
        }


        val sharedPreferences = getSharedPreferences("UserData", Context.MODE_PRIVATE)
        val storedName=sharedPreferences.getString("Name","")
        val storedEmail = sharedPreferences.getString("Email", "")
        val storedPassword = sharedPreferences.getString("Password", "")

        findViewById<TextView>(R.id.mail).text = storedEmail
        findViewById<TextView>(R.id.name).text = storedPassword


        save.setOnClickListener {
            val sharedPreferences = getSharedPreferences("UserData", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("Email", newmail.text.toString().trim())
            editor.putString("Password", newpass.text.toString().trim())
            editor.apply()
            Toast.makeText(this,"Details changed successfully", Toast.LENGTH_SHORT).show()
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // Match the request 'pic id with requestCode
        if (requestCode == pic_id) {
            // BitMap is data structure of image file which store the image in memory
            val photo = data!!.extras!!["data"] as Bitmap?
            // Set the image in imageview for display
            clickImageId.setImageBitmap(photo)
        }
    }
}