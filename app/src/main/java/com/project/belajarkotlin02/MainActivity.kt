package com.project.belajarkotlin02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var login: Button
    private lateinit var textUsername: EditText
    private lateinit var textPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        login = findViewById(R.id.Login)
        textUsername = findViewById(R.id.textUsername)
        textPassword = findViewById(R.id.textPassword)

        login.setOnClickListener {
            //startActivity(Intent(this, Widget::class.java))
            val intent = Intent(this, ImplicitIntent::class.java)
            intent.putExtra("user", textUsername.text.toString())
            intent.putExtra("pass", textPassword.text.toString())
            startActivity(intent)
        }
    }
}