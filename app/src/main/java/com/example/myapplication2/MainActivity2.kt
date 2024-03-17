package com.example.myapplication2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.rikmorty.R

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val id = intent.getIntExtra("id",0)
    }
}