package com.example.myapplication2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


import com.example.rikmorty.R
import com.example.rikmorty.network.RetroService

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val id = intent.getIntExtra("id",0)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()



        val personApi = retrofit.create(RetroService::class.java)
        lifecycleScope.launch(Dispatchers.IO) {
            val lood = personApi.getRickAndMorty(id)
            val nikname2:TextView = findViewById(R.id.nikname2)
            val status2:TextView = findViewById(R.id.status2)
            val gender2:TextView = findViewById(R.id.gender2)
            val Type2:TextView = findViewById(R.id.Type2)
            val origin2:TextView = findViewById(R.id.origin2)
            val location2:TextView = findViewById(R.id.location2)
            val Episode2:TextView = findViewById(R.id.episode2)
            val url2:TextView=findViewById(R.id.url2)
            val buttonfind:TextView=findViewById(R.id.buttonfind)
            val image2:ImageView=findViewById(R.id.image2)
            nikname2.text = lood.name.toString()
            status2.text = lood.status.toString()
            gender2.text = lood.gender.toString()
            Type2.text = lood.species.toString()
            Episode2.text = lood.episode.toString()
            origin2.text = lood.origin?.name.toString()
            location2.text = lood.location?.name.toString()
            url2.text=lood.url.toString()


        }

    }
}