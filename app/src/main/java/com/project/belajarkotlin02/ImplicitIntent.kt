package com.project.belajarkotlin02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ImplicitIntent : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit_intent)

        val txtUser = findViewById<TextView>(R.id.textUser1)
        val txtPass = findViewById<TextView>(R.id.textPass)

        val getData = intent.getParcelableExtra<ModelLogin>("data")
        txtUser.text = getData?.username
        txtPass.text = getData?.password


//        txtUser.text = intent.getStringExtra("user")
//        txtPass.text = intent.getStringExtra("pass")
    }

    companion object {
        private const val TAG = "MyActivity"
    }
}