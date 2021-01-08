package com.project.belajarkotlin02

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class Widget : AppCompatActivity() {

    private lateinit var buttonToast: Button
    private lateinit var buttonSnackBar: Button
    private lateinit var buttonAlert: Button
    private lateinit var buttonCustomDialog: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_widget)

        buttonToast = findViewById(R.id.buttonToast)
        buttonSnackBar = findViewById(R.id.buttonSnackBar)
        buttonAlert = findViewById(R.id.buttonAlert)
        buttonCustomDialog = findViewById(R.id.buttonCustomDialog)

        buttonToast.setOnClickListener {
            Toast.makeText(applicationContext,"Ini adalah toast", Toast.LENGTH_LONG).show()
            startActivity(Intent(this, ImplementasiListView::class.java))
        }

        buttonSnackBar.setOnClickListener {
            Snackbar.make(it,"Ini adalah snack bar", Snackbar.LENGTH_LONG).show()
        }

        buttonAlert.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setTitle("message")
                setMessage("Ini adalah alert")
                setPositiveButton("OK"){
                    dialog,_-> Toast.makeText(applicationContext,"anda click OK", Toast.LENGTH_LONG).show()
                    dialog.dismiss()
                }
                setNegativeButton("BACK"){
                    dialog, _-> Toast.makeText(applicationContext, "Anda click BACK", Toast.LENGTH_LONG).show()
                    dialog.dismiss()
                }.show()
            }
        }
        buttonCustomDialog.setOnClickListener {
            Dialog(this).apply {
                requestWindowFeature(Window.FEATURE_NO_TITLE)
                setCancelable(false)
                setContentView(R.layout.custom_dialog)

                val btnCancel:Button = this.findViewById(R.id.buttonCancel)
                val btnContinue:Button = this.findViewById(R.id.buttonContinue)

                btnCancel.setOnClickListener {
                    Toast.makeText(applicationContext,"Anda click cancel", Toast.LENGTH_LONG).show()
                    this.dismiss()
                }

                btnContinue.setOnClickListener {
                    Toast.makeText(applicationContext, "Anda click CONTINUE", Toast.LENGTH_LONG)
                        .show()
                    this.dismiss()
                }
            }.show()
        }

    }
}
