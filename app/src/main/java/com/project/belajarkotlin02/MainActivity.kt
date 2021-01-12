package com.project.belajarkotlin02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val login = findViewById<Button>(R.id.Login)
        val textUsername = findViewById<TextView>(R.id.textUsername)
        val textPassword = findViewById<TextView>(R.id.textPassword)

        login.setOnClickListener {
            //startActivity(Intent(this, Widget::class.java))

            val dataLogin = ModelLogin(textUsername.text.toString(), textPassword.text.toString())
            val intent = Intent(this, ImplicitIntent::class.java)
            intent.putExtra("data", dataLogin)
//            intent.putExtra("user", textUsername.text.toString())
//            intent.putExtra("pass", textPassword.text.toString())

            startActivity(intent)
        }
    }
}