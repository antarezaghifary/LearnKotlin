package com.project.belajarkotlin02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class ImplicitIntent : AppCompatActivity() {
    private lateinit var textUser: TextView
    private lateinit var textPass: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        textUser = (findViewById(R.id.textUser) as? TextView)!!
        textPass = findViewById(R.id.textPass) as?TextView as TextView

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit_intent)

        textUser.text = intent.getStringExtra("user")
        textPass.text = intent.getStringExtra("pass")
    }
}