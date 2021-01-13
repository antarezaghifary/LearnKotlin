package com.project.belajarkotlin02

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.MediaController
import android.widget.TextView
import androidx.core.app.ActivityCompat
import java.util.jar.Manifest

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


        if(Build.VERSION.SDK_INT >= 23){
            if(checkSelfPermission(android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED ||
                    checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA,
                        android.Manifest.permission.READ_EXTERNAL_STORAGE),100)
            }
        }

        val btnCamera = findViewById<Button>(R.id.btnCamera)
        btnCamera.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        }

        val btnFile = findViewById<Button>(R.id.btnFile)
        btnFile.setOnClickListener {
            val intent = Intent()
            intent.type = "*/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(Intent.createChooser(intent, "Pilih File"),0)
        }

        val btnBrowser = findViewById<Button>(R.id.btnBrowser)
        btnBrowser.setOnClickListener {
            val url = "http://www.google.com"
            val intent = Intent()
            intent.setData(Uri.parse(url))
            startActivity(intent)
        }
    }
    companion object {
        private const val TAG = "MyActivity"
    }
}