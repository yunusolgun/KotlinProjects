package com.example.kotlinalertdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(applicationContext,"hoşgeldin",Toast.LENGTH_LONG).show()

    }

    fun save(view: View) {
        val alert = AlertDialog.Builder(this)
        alert.setTitle("Save")
        alert.setMessage("are you sure?")
        alert.setPositiveButton("yes") {dialog, which ->
            Toast.makeText(applicationContext,"kaydedildi",Toast.LENGTH_LONG).show()
        }
        alert.setNegativeButton("no") {dialog, which ->
            Toast.makeText(applicationContext,"not saved",Toast.LENGTH_LONG).show()
        }
        alert.show()
    }
}