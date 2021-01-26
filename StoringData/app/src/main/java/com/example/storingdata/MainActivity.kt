package com.example.storingdata

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    var ageFromPreferences: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //sharedpreferences initalize
        sharedPreferences = this.getSharedPreferences("com.example.storingdata", MODE_PRIVATE)

        ageFromPreferences = sharedPreferences.getInt("age",-1)

        if (ageFromPreferences == -1) {
            textView.text = "Your Age:"
        } else {
            textView.text = "Your Age: $ageFromPreferences"
        }

    }
    
    fun save(view: View) {




        val myAge = editTextTextPersonName.text.toString().toIntOrNull()
        if (myAge != null) {
            textView.text = "Your Age:" + myAge
            sharedPreferences.edit().putInt("age",myAge).apply()
        }
    }


    fun delete(view: View) {
        ageFromPreferences = sharedPreferences.getInt("age",-1)

        if (ageFromPreferences != -1) {
            sharedPreferences.edit().remove("age").apply()
            textView.text = "Your Age:"
        }

    }
    
}