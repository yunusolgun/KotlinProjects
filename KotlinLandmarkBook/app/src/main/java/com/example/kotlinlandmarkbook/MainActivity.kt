package com.example.kotlinlandmarkbook

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var landmarkNames = ArrayList<String>()
        landmarkNames.add("Pisa")
        landmarkNames.add("Colloseum")
        landmarkNames.add("Eiffel")
        landmarkNames.add("London Bridge")

        val pisa = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.pisa)
        val colosseum = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.colosseum)
        val eiffel = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.eiffel)
        val londonbridge = BitmapFactory.decodeResource(applicationContext.resources,R.drawable.londonbridge)

        var landmarkImages = ArrayList<Bitmap>()
        landmarkImages.add(pisa)
        landmarkImages.add(colosseum)
        landmarkImages.add(eiffel)
        landmarkImages.add(londonbridge)

        //val adapter = ArrayAdapter(this,R.layout.list_row,R.id.textView2,landmarkNames)
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,landmarkNames)
        listView.adapter = adapter
        listView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(applicationContext,DetailsActivity::class.java)
            intent.putExtra("name",landmarkNames[i])

            val singleton = Singleton.Selected
            singleton.selectedImage = landmarkImages[i]

            startActivity(intent)
        }

    }
}