package com.example.kotlinsqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        println("helloood")
        try {
            println("helloo2")
            val myDatabase = this.openOrCreateDatabase("Musicians", MODE_PRIVATE,null)
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS musicians (id INTEGER PRIMARY KEY,name VARCHAR, age INT)")
            //myDatabase.execSQL("CREATE TABLE IF NOT EXISTS musicians (name VARCHAR, age INT)")
            myDatabase.execSQL("INSERT INTO musicians VALUES ('James',50)")
            myDatabase.execSQL("INSERT INTO musicians VALUES ('Lars',56)")

            val cursor = myDatabase.rawQuery("SELECT * FROM musicians",null)
            val nameIx = cursor.getColumnIndex("name")
            val ageIx = cursor.getColumnIndex("age")
            val idIx = cursor.getColumnIndex("id")

            println("helloo3")
            while (cursor.moveToNext()) {
                println("Name: "+ cursor.getString(nameIx))
                println("Age: "+ cursor.getString(ageIx))
                println("Id: "+ cursor.getString(idIx))
            }

            cursor.close()

        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}